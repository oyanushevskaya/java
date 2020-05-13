package taf.listener;

import static taf.util.StringUtils.getCurrentTimeAsString;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import taf.driver.DriverSingleton;

public class TestListener implements ITestListener {
  private final Logger logger = LogManager.getRootLogger();

  @Override
  public void onTestStart(ITestResult result) {
    logger.info(String.format("%s test case started", result.getName()));
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    logger.info(String.format("Test %s finished success ", result.getName()));
  }

  @Override
  public void onTestFailure(ITestResult result) {
    saveScreenshot();
    logger.info(String.format("Test %s failed ", result.getName()));
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    saveScreenshot();
    logger.info(String.format("Test %s skipped ", result.getName()));
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    logger.info(String.format("Test %s failed but within success percentage ", result.getName()));
  }

  @Override
  public void onStart(ITestContext context) {
    logger.info(String.format("%s tests started", context.getName()));
  }

  @Override
  public void onFinish(ITestContext context) {
    logger.info(String.format("%s tests finished", context.getName()));
  }

  private void saveScreenshot() {
    File screenCapture = ((TakesScreenshot) DriverSingleton
        .getDriver())
        .getScreenshotAs(OutputType.FILE);
    try {
      FileUtils.copyFile(screenCapture,
          new File(".//target/screenshots/" + getCurrentTimeAsString() + ".png"));
    } catch (IOException e) {
      logger.error(String.format("Failed to save screen: %s", e.getLocalizedMessage()));
    }
    logger.info("Successful to save screen");
  }
}

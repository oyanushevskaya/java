package webdriver.google_cloud.util;

import static webdriver.google_cloud.util.StringUtils.*;

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
import webdriver.google_cloud.driver.DriverSingleton;

public class TestListener implements ITestListener {
  private final Logger logger = LogManager.getRootLogger();

  @Override
  public void onTestStart(ITestResult result) {
    logger.info(result.getName() + " test case started");
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    logger.info("Test finished success : " + result.getName());
  }

  @Override
  public void onTestFailure(ITestResult result) {
    saveScreenshot();
    logger.info("Test failed: " + result.getName());
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    saveScreenshot();
    logger.info("Test skipped: " + result.getName());
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    logger.info("Test failed but within success percentage: " + result.getName());
  }

  @Override
  public void onTestFailedWithTimeout(ITestResult result) {
    saveScreenshot();
    logger.info("Test failed with timeout: " + result.getName());
  }

  @Override
  public void onStart(ITestContext context) {
    logger.info(context.getName() + " tests started");
  }

  @Override
  public void onFinish(ITestContext context) {
    logger.info(context.getName() + " tests finished");
  }

  private void saveScreenshot() {
    File screenCapture = ((TakesScreenshot) DriverSingleton
        .getDriver())
        .getScreenshotAs(OutputType.FILE);
    try {
      FileUtils.copyFile(screenCapture,
          new File(".//target/screenshots/" + getCurrentTimeAsString() + ".png"));
    } catch (IOException e) {
      logger.error("Failed to save screen: " + e.getLocalizedMessage());
    }
    logger.info("Successful to save screen");
  }
}

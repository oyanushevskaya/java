package taf.listener;

import static taf.util.StringUtils.getCurrentTimeAsString;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import taf.driver.DriverFactory;
import taf.logging.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

  @Override
  public void onTestStart(ITestResult result) {
    Log.info(String.format("%s test case started", result.getName()));
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    Log.info(String.format("Test %s finished success ", result.getName()));
  }

  @Override
  public void onTestFailure(ITestResult result) {
    saveScreenshot();
    Log.info(String.format("Test %s failed ", result.getName()));
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    saveScreenshot();
    Log.info(String.format("Test %s skipped ", result.getName()));
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    Log.info(String.format("Test %s failed but within success percentage ", result.getName()));
  }

  @Override
  public void onStart(ITestContext context) {
    Log.info(String.format("%s tests started", context.getName()));
  }

  @Override
  public void onFinish(ITestContext context) {
    Log.info(String.format("%s tests finished", context.getName()));
  }

  private void saveScreenshot() {
    File screenshotPath = null;
    File screenCapture = ((TakesScreenshot) DriverFactory
        .getDriver())
        .getScreenshotAs(OutputType.FILE);
    try {
      screenshotPath = new File(".//target/screenshots/" + getCurrentTimeAsString() + ".png");
      FileUtils.copyFile(screenCapture, screenshotPath);
    } catch (IOException e) {
      Log.error(String.format("Failed to save screen: %s", e.getLocalizedMessage()));
    }
    Log.info(String.format("Screen saved: <a href='%s' target='blank'>screenshot.file</a>",
        screenshotPath.getAbsolutePath()));
  }
}

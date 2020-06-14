package taf.browser;

import static taf.driver.DriverSingleton.getDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {
  private static final Logger logger = LogManager.getRootLogger();

  public static final  int TIME_OUT_IN_SECONDS = 100;

  public static WebElement waitVisibilityOfElementLocated(By by) {
    logger.info(String.format("Wait visibility of element located - %s", by));
    highlightElement(by);
    return new WebDriverWait(getDriver(), TIME_OUT_IN_SECONDS)
        .until(ExpectedConditions.visibilityOfElementLocated(by));
  }

  public static WebElement waitForVisibility(WebElement element) {
    logger.info(String.format("Wait visibility of element located - %s", element));
    return new WebDriverWait(getDriver(), TIME_OUT_IN_SECONDS)
        .until(ExpectedConditions.visibilityOf(element));
  }

  public static WebElement waitElementToBeClickable(By by) {
    logger.info(String.format("Wait element to be clickable - %s", by));
    highlightElement(by);
    return new WebDriverWait(getDriver(), TIME_OUT_IN_SECONDS)
        .until(ExpectedConditions.elementToBeClickable(by));
  }

  public static WebElement waitElementToBeClickable(WebElement element) {
    logger.info(String.format("Wait element to be clickable - %s", element));
    return new WebDriverWait(getDriver(), TIME_OUT_IN_SECONDS)
        .until(ExpectedConditions.elementToBeClickable(element));
  }

  public static void waitFrameToBeAvailable(String frameLocator) {
    logger.info(String.format("Wait frame to be available and switch to it - %s", frameLocator));
    new WebDriverWait(getDriver(), TIME_OUT_IN_SECONDS)
        .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
  }

  public static void waitInvisibilityOfElementLocated(By by) {
    logger.info(String.format("Wait invisibility of element located - %s", by));
    new WebDriverWait(getDriver(), TIME_OUT_IN_SECONDS)
        .until(ExpectedConditions.invisibilityOfElementLocated(by));
  }

  public static void highlightElement(By by) {
    logger.info(String.format("Highlight element - %s", by));
    WebElement element = new WebDriverWait(getDriver(), TIME_OUT_IN_SECONDS)
        .until(ExpectedConditions.visibilityOfElementLocated(by));
    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='2px solid red'",
        element);
  }
}

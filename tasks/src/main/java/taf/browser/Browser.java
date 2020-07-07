package taf.browser;

import static taf.driver.DriverFactory.getDriver;

import taf.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {
  public static final  int TIME_OUT_IN_SECONDS = 100;

  public static WebElement waitVisibilityOfElementLocated(By by) {
    Log.info(String.format("Wait visibility of element located - %s", by));
    return new WebDriverWait(getDriver(), TIME_OUT_IN_SECONDS)
        .until(ExpectedConditions.visibilityOfElementLocated(by));
  }

  public static WebElement waitForVisibility(WebElement element) {
    Log.info(String.format("Wait visibility of element located - %s", element));
    return new WebDriverWait(getDriver(), TIME_OUT_IN_SECONDS)
        .until(ExpectedConditions.visibilityOf(element));
  }

  public static WebElement waitElementToBeClickable(By by) {
    Log.info(String.format("Wait element to be clickable - %s", by));
    return new WebDriverWait(getDriver(), TIME_OUT_IN_SECONDS)
        .until(ExpectedConditions.elementToBeClickable(by));
  }

  public static WebElement waitElementToBeClickable(WebElement element) {
    Log.info(String.format("Wait element to be clickable - %s", element));
    return new WebDriverWait(getDriver(), TIME_OUT_IN_SECONDS)
        .until(ExpectedConditions.elementToBeClickable(element));
  }

  public static void waitFrameToBeAvailable(String frameLocator) {
    Log.info(String.format("Wait frame to be available and switch to it - %s", frameLocator));
    new WebDriverWait(getDriver(), TIME_OUT_IN_SECONDS)
        .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
  }

  public static void waitInvisibilityOfElementLocated(By by) {
    Log.info(String.format("Wait invisibility of element located - %s", by));
    new WebDriverWait(getDriver(), TIME_OUT_IN_SECONDS)
        .until(ExpectedConditions.invisibilityOfElementLocated(by));
  }

  public static WebElement highlightElement(By by) {
    Log.info(String.format("Highlight element - %s", by));
    WebElement element = waitVisibilityOfElementLocated(by);
    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='2px solid red'",
        element);
    return element;
  }

  public static WebElement highlightElement(WebElement webElement) {
    Log.info(String.format("Highlight element - %s", webElement));
    WebElement element = waitForVisibility(webElement);
    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='2px solid red'",
        element);
    return element;
  }
}

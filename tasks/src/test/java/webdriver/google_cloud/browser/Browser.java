package webdriver.google_cloud.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {
  private final static int TIME_OUT_IN_SECONDS = 100;

  public static WebElement waitForVisibility(WebDriver driver, WebElement element) {
    return new WebDriverWait(driver, TIME_OUT_IN_SECONDS)
        .until(ExpectedConditions.visibilityOf(element));
  }

  public static WebElement waitElementToBeClickable(WebDriver driver, WebElement element) {
    return new WebDriverWait(driver, TIME_OUT_IN_SECONDS)
        .until(ExpectedConditions.elementToBeClickable(element));
  }

  public static void waitFrameToBeAvailable(WebDriver driver, String frameLocator) {
    new WebDriverWait(driver, TIME_OUT_IN_SECONDS)
        .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
  }
}


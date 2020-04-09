package webdriver.google_cloud.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.google_cloud.driver.DriverSingleton;

public class Browser {
  public final static int TIME_OUT_IN_SECONDS = 100;

  public static WebElement waitForVisibility(WebElement element) {
    return new WebDriverWait(DriverSingleton.getDriver(), TIME_OUT_IN_SECONDS)
        .until(ExpectedConditions.visibilityOf(element));
  }

  public static WebElement waitElementToBeClickable(WebElement element) {
    return new WebDriverWait(DriverSingleton.getDriver(), TIME_OUT_IN_SECONDS)
        .until(ExpectedConditions.elementToBeClickable(element));
  }

  public static void waitFrameToBeAvailable(String frameLocator) {
    new WebDriverWait(DriverSingleton.getDriver(), TIME_OUT_IN_SECONDS)
        .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
  }
}


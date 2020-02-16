package webdriver.google_cloud.browser;

import static webdriver.google_cloud.constants.Constants.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {
  public static void waitForVisibleElement(WebDriver driver, WebElement element) {
    new WebDriverWait(driver, TIME_OUT_IN_SECONDS)
        .until(ExpectedConditions.visibilityOf(element));
  }

  public static void waitForVisibleFrame(WebDriver driver, String frameLocator) {
    new WebDriverWait(driver, TIME_OUT_IN_SECONDS)
        .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
  }
}

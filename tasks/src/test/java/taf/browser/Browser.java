package taf.browser;

import static taf.constants.Constants.TIME_OUT_IN_SECONDS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {
  public static void waitForVisibleElement(WebDriver driver, WebElement element) {
    new WebDriverWait(driver, TIME_OUT_IN_SECONDS)
        .until(ExpectedConditions.visibilityOf(element));
  }

  public static void waitElementToBeClickable(WebDriver driver, By by) {
    new WebDriverWait(driver, TIME_OUT_IN_SECONDS)
        .until(ExpectedConditions.elementToBeClickable(by));
  }
}

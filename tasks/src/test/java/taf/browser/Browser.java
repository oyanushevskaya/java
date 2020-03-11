package taf.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {
  public final static int TIME_OUT_IN_SECONDS = 30;

  public static void waitForVisibility(WebDriver driver, WebElement element) {
    new WebDriverWait(driver, TIME_OUT_IN_SECONDS)
        .until(ExpectedConditions.visibilityOf(element));
  }

  public static WebElement waitElementToBeClickable(WebDriver driver, By by) {
    return new WebDriverWait(driver, TIME_OUT_IN_SECONDS)
        .until(ExpectedConditions.elementToBeClickable(by));
  }
}

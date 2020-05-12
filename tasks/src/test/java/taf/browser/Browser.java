package taf.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import taf.driver.DriverSingleton;

public class Browser {
  public static final  int TIME_OUT_IN_SECONDS = 100;

  public static WebElement waitVisibilityOfElementLocated(By by) {
    return new WebDriverWait(DriverSingleton.getDriver(), TIME_OUT_IN_SECONDS)
        .until(ExpectedConditions.visibilityOfElementLocated(by));
  }

  public static WebElement waitElementToBeClickable(By by) {
    return new WebDriverWait(DriverSingleton.getDriver(), TIME_OUT_IN_SECONDS)
        .until(ExpectedConditions.elementToBeClickable(by));
  }
}

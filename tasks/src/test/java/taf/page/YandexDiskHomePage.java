package taf.page;

import static taf.browser.Browser.*;
import static taf.constants.Constants.*;

import org.openqa.selenium.WebDriver;

public class YandexDiskHomePage extends YandexDiskAbstractPage{
  public YandexDiskHomePage(WebDriver driver) {
    super(driver);
  }

  public YandexDiskHomePage openPage() {
    driver.get(HOMEPAGE_URL);
    return this;
  }

  public void clickLoginButton() {
    waitElementToBeClickable(driver, LOGIN_BUTTON);
    driver.findElement(LOGIN_BUTTON).click();
  }
}

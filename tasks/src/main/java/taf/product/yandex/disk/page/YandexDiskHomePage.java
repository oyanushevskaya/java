package taf.product.yandex.disk.page;

import static taf.browser.Browser.*;
import static taf.product.yandex.disk.data.DataStorage.HOMEPAGE_URL;

import taf.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexDiskHomePage extends YandexDiskAbstractPage{
  public static final By LOGIN_BUTTON = By.xpath("//a[contains(@class,'button_login')]");

  public YandexDiskHomePage(WebDriver driver) {
    super(driver);
  }

  public YandexDiskHomePage openPage() {
    Log.info(String.format("Open %s page", HOMEPAGE_URL));
    driver.get(HOMEPAGE_URL);
    return this;
  }

  public void clickLoginButton() {
    Log.info("Click 'Sign in' button in home page");
    waitElementToBeClickable(LOGIN_BUTTON);
    highlightElement(LOGIN_BUTTON).click();
  }
}

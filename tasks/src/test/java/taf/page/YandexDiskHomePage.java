package taf.page;

import static taf.browser.Browser.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexDiskHomePage extends YandexDiskAbstractPage{
  public static final String HOMEPAGE_URL = "https://disk.yandex.com/";
  public static final By LOGIN_BUTTON = By.xpath("//a[contains(@class,'button_login')]");

  public YandexDiskHomePage(WebDriver driver) {
    super(driver);
  }

  public YandexDiskHomePage openPage() {
    driver.get(HOMEPAGE_URL);
    return this;
  }

  public void clickLoginButton() {
    waitElementToBeClickable(LOGIN_BUTTON).click();
  }
}

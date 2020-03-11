package taf.page;

import static taf.browser.Browser.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexDiskHomePage extends YandexDiskAbstractPage{
  public final static String HOMEPAGE_URL = "https://disk.yandex.com/";
  public final static By LOGIN_BUTTON = By.xpath("//a[contains(@class,'button_login')]");

  public YandexDiskHomePage(WebDriver driver) {
    super(driver);
  }

  public YandexDiskHomePage openPage() {
    driver.get(HOMEPAGE_URL);
    return this;
  }

  public void clickLoginButton() {
    waitElementToBeClickable(driver, LOGIN_BUTTON).click();
  }
}

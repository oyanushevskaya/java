package taf.product.yandex.disk.page;

import static taf.browser.Browser.*;
import static taf.product.yandex.disk.util.StringUtils.HOMEPAGE_URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexDiskHomePage extends YandexDiskAbstractPage{
  private final Logger logger = LogManager.getRootLogger();

  public static final By LOGIN_BUTTON = By.xpath("//a[contains(@class,'button_login')]");

  public YandexDiskHomePage(WebDriver driver) {
    super(driver);
  }

  public YandexDiskHomePage openPage() {
    logger.info(String.format("Open %s page", HOMEPAGE_URL));
    driver.get(HOMEPAGE_URL);
    return this;
  }

  public void clickLoginButton() {
    logger.info("Click 'Sign in' button in home page");
    waitElementToBeClickable(LOGIN_BUTTON).click();
  }
}

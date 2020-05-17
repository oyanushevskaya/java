package taf.product.yandex.disk.page;

import static taf.browser.Browser.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YandexDiskAuthPage extends YandexDiskAbstractPage{
  private final Logger logger = LogManager.getRootLogger();

  public static final By LOGIN_FIELD = By.id("passp-field-login");
  public static final By PASSWORD_FIELD = By.id("passp-field-passwd");
  public static final By SIGN_IN_BUTTON = By.cssSelector("div.passp-button.passp-sign-in-button");

  public static final By ERROR_MESSAGE_LABEL = By.xpath("//div[@class='passp-form-field__error']");
  public static final By ACCOUNT_ICON = By.cssSelector("div.user-pic.user-account__pic");
  public static final By ACCOUNT_NAME_LABEL = By.xpath("//span[@class='user-account__name']");

  public YandexDiskAuthPage(WebDriver driver) {
    super(driver);
  }

  public YandexDiskAuthPage enterLogin(String login) {
    logger.info("Type login in form from property");
    waitVisibilityOfElementLocated(LOGIN_FIELD);
    WebElement loginInput = driver.findElement(LOGIN_FIELD);
    loginInput.click();
    loginInput.sendKeys(login);
    return this;
  }

  public YandexDiskAuthPage enterPassword(String password) {
    logger.info("Type password in form from property");
    waitVisibilityOfElementLocated(PASSWORD_FIELD);
    WebElement passwordInput = driver.findElement(PASSWORD_FIELD);
    passwordInput.click();
    passwordInput.sendKeys(password);
    return this;
  }

  public YandexDiskAuthPage clickSignInButton() {
    logger.info("Click 'Log in' button in form");
    driver.findElement(SIGN_IN_BUTTON).click();
    return this;
  }

  public boolean isErrorMessageDisplayed() {
    return waitVisibilityOfElementLocated(ERROR_MESSAGE_LABEL).isDisplayed();
  }

  public void clickUserAccount() {
    logger.info("Click user account icon");
    waitElementToBeClickable(ACCOUNT_ICON).click();
  }

  public String getUserName() {
    return waitVisibilityOfElementLocated(ACCOUNT_NAME_LABEL).getText();
  }
}

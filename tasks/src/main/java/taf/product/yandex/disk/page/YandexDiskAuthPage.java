package taf.product.yandex.disk.page;

import static taf.browser.Browser.*;

import taf.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YandexDiskAuthPage extends YandexDiskAbstractPage{
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
    Log.info(String.format("Type login in form from property - %s", login));
    waitVisibilityOfElementLocated(LOGIN_FIELD);
    highlightElement(LOGIN_FIELD);
    WebElement loginInput = driver.findElement(LOGIN_FIELD);
    loginInput.click();
    loginInput.sendKeys(login);
    return this;
  }

  public YandexDiskAuthPage enterPassword(String password) {
    Log.info(String.format("Type password in form from property - %s", password));
    waitVisibilityOfElementLocated(PASSWORD_FIELD);
    highlightElement(PASSWORD_FIELD);
    WebElement passwordInput = driver.findElement(PASSWORD_FIELD);
    passwordInput.click();
    passwordInput.sendKeys(password);
    return this;
  }

  public YandexDiskAuthPage clickSignInButton() {
    Log.info("Click 'Log in' button in form");
    waitElementToBeClickable(SIGN_IN_BUTTON);
    highlightElement(SIGN_IN_BUTTON).click();
    return this;
  }

  public boolean isErrorMessageDisplayed() {
    return waitVisibilityOfElementLocated(ERROR_MESSAGE_LABEL).isDisplayed();
  }

  public void clickUserAccount() {
    Log.info("Click user account icon");
    waitElementToBeClickable(ACCOUNT_ICON);
    highlightElement(ACCOUNT_ICON).click();
  }

  public String getUserName() {
    return waitVisibilityOfElementLocated(ACCOUNT_NAME_LABEL).getText();
  }
}

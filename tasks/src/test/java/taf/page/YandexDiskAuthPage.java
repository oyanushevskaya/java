package taf.page;

import static taf.browser.Browser.*;
import static taf.constants.Constants.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YandexDiskAuthPage extends YandexDiskAbstractPage{
  public YandexDiskAuthPage(WebDriver driver) {
    super(driver);
  }

  public void enterLogin(String login) {
    waitElementToBeClickable(driver, LOGIN_FIELD);
    WebElement loginInput = driver.findElement(LOGIN_FIELD);
    loginInput.click();
    loginInput.sendKeys(login);
    driver.findElement(SIGN_IN_BUTTON).click();
  }

  public void enterPassword(String password) {
    waitElementToBeClickable(driver, PASSWORD_FIELD);
    WebElement passwordInput = driver.findElement(PASSWORD_FIELD);
    passwordInput.click();
    passwordInput.sendKeys(password);
    driver.findElement(SIGN_IN_BUTTON).click();
  }

  public void logInYandexDisk(String login, String password) {
    enterLogin(login);
    enterPassword(password);
  }

  public boolean errorMessageIsDisplayed() {
    waitElementToBeClickable(driver, ERROR_MESSAGE);
    return driver.findElement(ERROR_MESSAGE).isDisplayed();
  }

  public void clickUserAccount() {
    waitElementToBeClickable(driver, USER_ACCOUNT);
    driver.findElement(USER_ACCOUNT).click();
  }

  public String getUserName() {
    waitElementToBeClickable(driver, USER_ACCOUNT_NAME);
    return driver.findElement(USER_ACCOUNT_NAME).getText();
  }
}

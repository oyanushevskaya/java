package taf.page;

import static taf.browser.Browser.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YandexDiskAuthPage extends YandexDiskAbstractPage{
  public final static By LOGIN_FIELD = By.id("passp-field-login");
  public final static By PASSWORD_FIELD = By.id("passp-field-passwd");
  public final static By SIGN_IN_BUTTON = By.cssSelector("div.passp-button.passp-sign-in-button");

  public final static By ERROR_MESSAGE_LABEL = By.xpath("//div[@class='passp-form-field__error']");
  public final static By ACCOUNT_ICON = By.cssSelector("div.user-pic.user-account__pic");
  public final static By ACCOUNT_NAME_LABEL = By.xpath("//span[@class='user-account__name']");

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

  public boolean isErrorMessageDisplayed() {
    return waitElementToBeClickable(driver, ERROR_MESSAGE_LABEL).isDisplayed();
  }

  public void clickUserAccount() {
    waitElementToBeClickable(driver, ACCOUNT_ICON).click();
  }

  public String getUserName() {
    return waitElementToBeClickable(driver, ACCOUNT_NAME_LABEL).getText();
  }
}

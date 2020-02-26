package taf.page;

import static taf.browser.Browser.waitElementToBeClickable;
import static taf.constants.Constants.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class YandexDiskDocumentPage extends YandexDiskAbstractPage {

  public YandexDiskDocumentPage(WebDriver driver) {
    super(driver);
  }

  public YandexDiskDocumentPage switchToFrame() {
    driver.switchTo().frame(driver.findElement(By.className("editor-doc__iframe")));
    return this;
  }

  public YandexDiskDocumentPage typeTextInDocument(String text) {
    waitElementToBeClickable(driver, TEXT_INPUT);
    driver.findElement(TEXT_INPUT).sendKeys(text);
    return this;
  }

  public YandexDiskDocumentPage saveStatusDocument() {
    waitElementToBeClickable(driver, DOCUMENT_SAVE_STATUS);
    driver.findElement(DOCUMENT_SAVE_STATUS);
    return this;
  }

  public YandexDiskDocumentPage clickMenuItemFile() {
    waitElementToBeClickable(driver, MENU_ITEM_FILE);
    driver.findElement(MENU_ITEM_FILE).click();
    return this;
  }

  public YandexDiskDocumentPage clickRenameButton() {
    waitElementToBeClickable(driver, MENU_ITEM_SAVE_AS);
    driver.findElement(MENU_ITEM_SAVE_AS).click();

    waitElementToBeClickable(driver, MENU_ITEM_RENAME);
    driver.findElement(MENU_ITEM_RENAME).click();
    return this;
  }

  public YandexDiskDocumentPage renameDocument(String name) {
    waitElementToBeClickable(driver, DOCUMENT_NAME_INPUT);
    driver.findElement(DOCUMENT_NAME_INPUT).clear();
    waitElementToBeClickable(driver, DOCUMENT_NAME_INPUT);
    driver.findElement(DOCUMENT_NAME_INPUT).sendKeys(name + Keys.ENTER);
    return this;
  }

  public void clickCloseDocument() {
    waitElementToBeClickable(driver, MENU_ITEM_EXIT);
    driver.findElement(MENU_ITEM_EXIT).click();
  }

  public String getTextFromDocument() {
    waitElementToBeClickable(driver, TEXT_INPUT);
    return driver.findElement(TEXT_INPUT).getText();
  }
}

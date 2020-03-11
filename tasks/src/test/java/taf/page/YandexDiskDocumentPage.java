package taf.page;

import static taf.browser.Browser.waitElementToBeClickable;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class YandexDiskDocumentPage extends YandexDiskAbstractPage {
  public final static By TEXT_INPUT = By.xpath("//*[@id='WACViewPanel_EditingElement']/p");
  public final static By MENU_ITEM_FILE = By.id("id__1");
  public final static By MENU_ITEM_SAVE_AS = By.xpath("//a[@id='faSaveAs-Menu32']");
  public final static By MENU_ITEM_RENAME = By.xpath("//li/a[@id='jbtnRenameDialog-Menu48']");
  public final static By MENU_ITEM_EXIT = By.xpath("//a[@id='btnjClose-Menu32']");
  public final static By DOCUMENT_NAME_INPUT = By.id("txtDocumentName");
  public final static By DOCUMENT_SAVE_STATUS = By.xpath("//span[contains(text(),'Saved to Yandex')]");

  public YandexDiskDocumentPage(WebDriver driver) {
    super(driver);
  }

  public YandexDiskDocumentPage switchToFrame() {
    driver.switchTo().frame(driver.findElement(By.className("editor-doc__iframe")));
    return this;
  }

  public YandexDiskDocumentPage typeTextInDocument(String text) {
    waitElementToBeClickable(driver, TEXT_INPUT).sendKeys(text);
    return this;
  }

  public YandexDiskDocumentPage clickMenuItemFile() {
    waitElementToBeClickable(driver, DOCUMENT_SAVE_STATUS);
    waitElementToBeClickable(driver, MENU_ITEM_FILE).click();
    return this;
  }

  public YandexDiskDocumentPage clickRenameButton() {
    waitElementToBeClickable(driver, MENU_ITEM_SAVE_AS).click();

    waitElementToBeClickable(driver, MENU_ITEM_RENAME).click();
    return this;
  }

  public YandexDiskDocumentPage renameDocument(String name) {
    waitElementToBeClickable(driver, DOCUMENT_NAME_INPUT).clear();
    waitElementToBeClickable(driver, DOCUMENT_NAME_INPUT).sendKeys(name + Keys.ENTER);
    return this;
  }

  public void clickCloseDocument() {
    waitElementToBeClickable(driver, MENU_ITEM_EXIT).click();
  }

  public String getTextFromDocument() {
    return waitElementToBeClickable(driver, TEXT_INPUT).getText();
  }
}

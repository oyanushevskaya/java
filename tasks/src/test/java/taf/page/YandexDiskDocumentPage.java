package taf.page;

import static taf.browser.Browser.waitElementToBeClickable;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class YandexDiskDocumentPage extends YandexDiskAbstractPage {
  public final static By DOCUMENT_TEXT_INPUT = By.xpath("//*[@id='WACViewPanel_EditingElement']/p");
  public final static By DOCUMENT_FILE_TAB = By.id("id__1");
  public final static By DOCUMENT_SAVE_AS_BUTTON = By.id("faSaveAs-Menu32");
  public final static By DOCUMENT_RENAME_BUTTON = By.xpath("//li/a[@id='jbtnRenameDialog-Menu48']");
  public final static By DOCUMENT_EXIT_BUTTON = By.id("btnjClose-Menu32");
  public final static By DOCUMENT_NAME_INPUT = By.id("txtDocumentName");
  public final static By DOCUMENT_SAVE_STATUS_LABEL = By.xpath("//span[contains(text(),'Saved to Yandex')]");

  public YandexDiskDocumentPage(WebDriver driver) {
    super(driver);
  }

  public YandexDiskDocumentPage switchToFrame() {
    driver.switchTo().frame(driver.findElement(By.className("editor-doc__iframe")));
    return this;
  }

  public YandexDiskDocumentPage typeTextInDocument(String text) {
    waitElementToBeClickable(driver, DOCUMENT_TEXT_INPUT).sendKeys(text);
    return this;
  }

  public YandexDiskDocumentPage clickMenuItemFile() {
    waitElementToBeClickable(driver, DOCUMENT_SAVE_STATUS_LABEL);
    waitElementToBeClickable(driver, DOCUMENT_FILE_TAB).click();
    return this;
  }

  public YandexDiskDocumentPage clickRenameButton() {
    waitElementToBeClickable(driver, DOCUMENT_SAVE_AS_BUTTON).click();

    waitElementToBeClickable(driver, DOCUMENT_RENAME_BUTTON).click();
    return this;
  }

  public YandexDiskDocumentPage renameDocument(String name) {
    waitElementToBeClickable(driver, DOCUMENT_NAME_INPUT).clear();
    waitElementToBeClickable(driver, DOCUMENT_NAME_INPUT).sendKeys(name + Keys.ENTER);
    return this;
  }

  public void clickCloseDocument() {
    waitElementToBeClickable(driver, DOCUMENT_EXIT_BUTTON).click();
  }

  public String getTextFromDocument() {
    return waitElementToBeClickable(driver, DOCUMENT_TEXT_INPUT).getText();
  }
}

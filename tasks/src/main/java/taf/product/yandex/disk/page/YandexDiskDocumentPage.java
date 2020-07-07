package taf.product.yandex.disk.page;

import static taf.browser.Browser.highlightElement;
import static taf.browser.Browser.waitElementToBeClickable;
import static taf.browser.Browser.waitVisibilityOfElementLocated;

import taf.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import taf.product.yandex.disk.service.DocumentFactory;

public class YandexDiskDocumentPage extends YandexDiskAbstractPage {
  public static final By DOCUMENT_TEXT_INPUT = By.xpath("//*[@id='WACViewPanel_EditingElement']//p[@class='Paragraph']");
  public static final By DOCUMENT_FILE_TAB = By.id("id__1");
  public static final By DOCUMENT_SAVE_AS_BUTTON = By.id("faSaveAs-Menu32");
  public static final By DOCUMENT_RENAME_BUTTON = By.xpath("//li/a[@id='jbtnRenameDialog-Menu48']");
  public static final By DOCUMENT_EXIT_BUTTON = By.id("btnjClose-Menu32");
  public static final By DOCUMENT_NAME_INPUT = By.id("CommitNewDocumentTitle");
  public static final By DOCUMENT_SAVE_STATUS_LABEL = By.xpath("//span[contains(text(),'Saved to Yandex')]");
  
  public static final By DOCUMENT_NOT_FOUND_ERROR_MESSAGE = By.xpath("//div[@class='editor-doc__caption']");
  public static final By BACK_TO_YANDEX_DISK_BUTTON = By.xpath("//a[@class=' nb-button _nb-action-button']");

  public YandexDiskDocumentPage(WebDriver driver) {
    super(driver);
  }

  public YandexDiskDocumentPage switchToFrame() {
    if (!isErrorDisplayed()) {
      Log.info("Switch to frame");
      driver.switchTo().frame(waitVisibilityOfElementLocated(By.className("editor-doc__iframe")));
    } else {
      Log.error("The file cannot be found to edit. Click 'Go to Yandex.Disk' button ");
      waitElementToBeClickable(BACK_TO_YANDEX_DISK_BUTTON);
      highlightElement(BACK_TO_YANDEX_DISK_BUTTON).click();
    }
    return this;
  }

  public boolean isErrorDisplayed() {
    return !driver.findElements(DOCUMENT_NOT_FOUND_ERROR_MESSAGE).isEmpty();
  }

  public YandexDiskDocumentPage typeTextInDocument() {
    String documentText = DocumentFactory.getDocumentInfo().getText();
    Log.info(String.format("Type text in document from property - %s", documentText));
    waitVisibilityOfElementLocated(DOCUMENT_TEXT_INPUT).click();
    highlightElement(DOCUMENT_TEXT_INPUT).sendKeys(documentText);
    return this;
  }

  public YandexDiskDocumentPage clickMenuItemFile() {
    Log.info("Click 'File' tab in document menu");
    waitVisibilityOfElementLocated(DOCUMENT_SAVE_STATUS_LABEL);
    waitElementToBeClickable(DOCUMENT_FILE_TAB);
    highlightElement(DOCUMENT_FILE_TAB).click();
    return this;
  }

  public YandexDiskDocumentPage clickSaveAsButton() {
    Log.info("Click 'Save as' button in 'File' tab");
    waitElementToBeClickable(DOCUMENT_SAVE_AS_BUTTON);
    highlightElement(DOCUMENT_SAVE_AS_BUTTON).click();
    return this;
  }

  public YandexDiskDocumentPage clickRenameButton() {
    Log.info("Click 'Rename' button in 'Save as' tab");
    waitElementToBeClickable(DOCUMENT_RENAME_BUTTON);
    highlightElement(DOCUMENT_RENAME_BUTTON).click();
    return this;
  }

  public YandexDiskDocumentPage renameDocument() {
    String documentName = DocumentFactory.getDocumentInfo().getName();
    Log.info(String.format("Type document name from property - %s", documentName));
    waitVisibilityOfElementLocated(DOCUMENT_NAME_INPUT);
    highlightElement(DOCUMENT_NAME_INPUT).sendKeys(documentName + Keys.ENTER);
    return this;
  }

  public void clickCloseDocument() {
    Log.info("Click 'Exit' button in 'File' tab in document menu");
    waitElementToBeClickable(DOCUMENT_EXIT_BUTTON);
    highlightElement(DOCUMENT_EXIT_BUTTON).click();
  }

  public String getTextFromDocument() {
    return waitVisibilityOfElementLocated(DOCUMENT_TEXT_INPUT).getText();
  }
}

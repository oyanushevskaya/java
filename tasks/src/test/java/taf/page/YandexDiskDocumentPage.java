package taf.page;

import static taf.browser.Browser.waitElementToBeClickable;
import static taf.browser.Browser.waitVisibilityOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import taf.service.DocumentCreator;

public class YandexDiskDocumentPage extends YandexDiskAbstractPage {
  public static final By DOCUMENT_TEXT_INPUT = By.xpath("//*[@id='WACViewPanel_EditingElement']/p");
  public static final By DOCUMENT_FILE_TAB = By.id("id__1");
  public static final By DOCUMENT_SAVE_AS_BUTTON = By.id("faSaveAs-Menu32");
  public static final By DOCUMENT_RENAME_BUTTON = By.xpath("//li/a[@id='jbtnRenameDialog-Menu48']");
  public static final By DOCUMENT_EXIT_BUTTON = By.id("btnjClose-Menu32");
  public static final By DOCUMENT_NAME_INPUT = By.id("txtDocumentName");
  public static final By DOCUMENT_SAVE_STATUS_LABEL = By.xpath("//span[contains(text(),'Saved to Yandex')]");
  
  public static final By DOCUMENT_NOT_FOUND_ERROR_MESSAGE = By.xpath("//div[@class='editor-doc__caption']");
  public static final By BACK_TO_YANDEX_DISK_BUTTON = By.xpath("//a[@class=' nb-button _nb-action-button']");

  public YandexDiskDocumentPage(WebDriver driver) {
    super(driver);
  }

  public YandexDiskDocumentPage switchToFrame() {
    if (!isErrorDisplayed()) {
      driver.switchTo().frame(waitVisibilityOfElementLocated(By.className("editor-doc__iframe")));
    } else {
      waitElementToBeClickable(BACK_TO_YANDEX_DISK_BUTTON).click();
    }
    return this;
  }

  public boolean isErrorDisplayed() {
    return !driver.findElements(DOCUMENT_NOT_FOUND_ERROR_MESSAGE).isEmpty();
  }

  public YandexDiskDocumentPage typeTextInDocument() {
    waitVisibilityOfElementLocated(DOCUMENT_TEXT_INPUT)
        .sendKeys(DocumentCreator.getDocumentInfo().getText());
    return this;
  }

  public YandexDiskDocumentPage clickMenuItemFile() {
    waitVisibilityOfElementLocated(DOCUMENT_SAVE_STATUS_LABEL);
    waitElementToBeClickable(DOCUMENT_FILE_TAB).click();
    return this;
  }

  public YandexDiskDocumentPage clickSaveAsButton() {
    waitElementToBeClickable(DOCUMENT_SAVE_AS_BUTTON).click();
    return this;
  }

  public YandexDiskDocumentPage clickRenameButton() {
    waitElementToBeClickable(DOCUMENT_RENAME_BUTTON).click();
    return this;
  }

  public YandexDiskDocumentPage renameDocument() {
    waitVisibilityOfElementLocated(DOCUMENT_NAME_INPUT)
        .sendKeys(DocumentCreator.getDocumentInfo().getName() + Keys.ENTER);
    return this;
  }

  public void clickCloseDocument() {
    waitElementToBeClickable(DOCUMENT_EXIT_BUTTON).click();
  }

  public String getTextFromDocument() {
    return waitVisibilityOfElementLocated(DOCUMENT_TEXT_INPUT).getText();
  }
}

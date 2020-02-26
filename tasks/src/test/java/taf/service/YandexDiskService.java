package taf.service;

import static taf.constants.Constants.*;

import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import taf.page.*;

public class YandexDiskService extends YandexDiskAbstractPage {
  private ArrayList<String> tabs;

  public YandexDiskService(WebDriver driver) {
    super(driver);
  }

  public void switchToDocumentPageTab() {
    tabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1));
  }

  public void switchToFolderPageTab() {
    driver.switchTo().window(tabs.get(0));
  }

  public YandexDiskService navigateToYandexDisk() {
    new YandexDiskHomePage(driver)
        .openPage()
        .clickLoginButton();
    return this;
  }

  public String getUserName() {
    new YandexDiskAuthPage(driver)
        .clickUserAccount();
    return new YandexDiskAuthPage(driver).getUserName();
  }

  public void logIntoAccount() {
    new YandexDiskAuthPage(driver)
        .logInYandexDisk(LOGIN, PASSWORD);
  }

  public YandexDiskService createNewFolder() {
    new YandexDiskMainPage(driver)
        .clickMenuItemFiles()
        .createFolder()
        .typeFolderName()
        .pressCreateFolder()
        .visitCreatedFolder();
    return this;
  }

  public YandexDiskService createNewDocument() {
    new YandexDiskMainPage(driver)
        .createNewDocument();
    switchToDocumentPageTab();
    new YandexDiskDocumentPage(driver)
        .switchToFrame()
        .typeTextInDocument(DOCUMENT_BODY_TEXT)
        .saveStatusDocument()
        .clickMenuItemFile()
        .clickRenameButton()
        .renameDocument(DOCUMENT_NAME)
        .clickMenuItemFile()
        .clickCloseDocument();
    switchToFolderPageTab();
    return this;
  }

  public void deleteDocument() {
    new YandexDiskMainPage(driver)
        .clickMenuItemFiles()
        .visitCreatedFolder()
        .clickFoundDocument()
        .clickDeleteDocumentButton();
  }

  public void emptyTrash() {
    new YandexDiskMainPage(driver)
        .clickTrashButton()
        .clickEmptyTrash()
        .confirmEmptyTrash();
  }

  public boolean foundCreatedFolder() {
    new YandexDiskMainPage(driver)
        .clickMenuItemFiles();
    return new YandexDiskMainPage(driver).folderIsDisplayed();
  }

  public boolean foundCreatedDocumentInFolder() {
    new YandexDiskMainPage(driver)
        .clickFoundDocument();
    return new YandexDiskMainPage(driver).documentIsDisplayed();
  }

  public String foundTextInDocument() {
    new YandexDiskMainPage(driver)
        .clickEditDocumentButton();
    switchToDocumentPageTab();
    new YandexDiskDocumentPage(driver)
        .switchToFrame();
    return new YandexDiskDocumentPage(driver).getTextFromDocument();
  }

  public boolean foundDocumentInTrash() {
    new YandexDiskMainPage(driver)
        .clickTrashButton()
        .clickFoundDocument();
    return new YandexDiskMainPage(driver).documentIsDisplayed();
  }

  public boolean trashIsEmpty() {
    new YandexDiskMainPage(driver)
        .clickTrashButton();
    return new YandexDiskMainPage(driver).isEmpty();
  }
}

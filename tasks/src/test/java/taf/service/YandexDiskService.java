package taf.service;

import static taf.util.StringUtils.*;

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

  public void navigateToYandexDisk() {
    new YandexDiskHomePage(driver)
        .openPage()
        .clickLoginButton();
  }

  public String getUserName() {
    new YandexDiskAuthPage(driver)
        .clickUserAccount();
    return new YandexDiskAuthPage(driver).getUserName();
  }

  public void logIntoAccount() {
    new YandexDiskAuthPage(driver)
        .logInYandexDisk(VALID_LOGIN, VALID_PASSWORD);
  }

  public void createNewFolder() {
    new YandexDiskMainPage(driver)
        .clickMenuItemFiles()
        .createFolder()
        .typeFolderName()
        .pressCreateFolder()
        .visitCreatedFolder();
  }

  public void createNewDocument() {
    new YandexDiskMainPage(driver)
        .createNewDocument();
    switchToDocumentPageTab();
    new YandexDiskDocumentPage(driver)
        .switchToFrame()
        .typeTextInDocument(DOCUMENT_BODY_TEXT)
        .clickMenuItemFile()
        .clickRenameButton()
        .renameDocument(DOCUMENT_NAME)
        .clickMenuItemFile()
        .clickCloseDocument();
    switchToFolderPageTab();
  }

  public void deleteDocument() {
    new YandexDiskMainPage(driver)
        .clickMenuItemFiles()
        .visitCreatedFolder()
        .clickFoundDocument()
        .clickDeleteDocumentButton();
  }

  public void isTrashEmpty() {
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

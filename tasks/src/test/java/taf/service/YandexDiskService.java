package taf.service;

import static taf.service.FolderFactory.*;

import java.util.ArrayList;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import taf.model.User;
import taf.page.*;

public class YandexDiskService extends YandexDiskAbstractPage {
  private ArrayList<String> tabs;

  public YandexDiskService(WebDriver driver) {
    super(driver);
  }

  public void switchToSecondTab() {
    tabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1));
  }

  public void switchToFirstTab() {
    driver.switchTo().window(tabs.get(0));
  }

  public void closeTab() {
    ((JavascriptExecutor) driver).executeScript("window.onbeforeunload = null;" + "window.close()");
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

  public void logIntoAccount(User user) {
    new YandexDiskAuthPage(driver)
        .enterLogin(user.getUsername())
        .clickSignInButton()
        .enterPassword(user.getPassword())
        .clickSignInButton();
  }

  public void createNewFolder() {
    new YandexDiskMainPage(driver)
        .clickMenuItemFiles()
        .createResource()
        .createFolder()
        .typeFolderName(generateFolderName())
        .pressCreateFolder()
        .visitCreatedFolder();
  }

  public void createNewDocument() {
    new YandexDiskMainPage(driver)
        .createResource()
        .createNewDocument();
    switchToSecondTab();
    new YandexDiskDocumentPage(driver)
        .switchToFrame()
        .typeTextInDocument()
        .clickMenuItemFile()
        .clickSaveAsButton()
        .clickRenameButton()
        .renameDocument()
        .clickMenuItemFile()
        .clickCloseDocument();
    switchToFirstTab();
  }

  public void deleteDocument() {
    new YandexDiskDocumentPage(driver)
        .clickMenuItemFile()
        .clickCloseDocument();
    switchToFirstTab();
    new YandexDiskMainPage(driver)
        .clickMenuItemFiles()
        .visitCreatedFolder()
        .clickFoundDocument()
        .clickDeleteResource();
  }

  public void deleteFolder() {
    new YandexDiskMainPage(driver)
        .clickMenuItemFiles()
        .clickFoundFolder()
        .clickDeleteResource();
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
        .clickMenuItemFiles()
        .visitCreatedFolder()
        .clickFoundDocument()
        .clickEditDocument();
    switchToSecondTab();
    new YandexDiskDocumentPage(driver)
        .switchToFrame();
    while (new YandexDiskDocumentPage(driver).isErrorDisplayed()) {
      new YandexDiskMainPage(driver)
          .clickFoundDocument()
          .clickEditDocument();
      switchToSecondTab();
      closeTab();
      switchToSecondTab();
      new YandexDiskDocumentPage(driver)
          .switchToFrame();
    }

    return new YandexDiskDocumentPage(driver).getTextFromDocument();
  }

  public boolean foundDocumentInTrash() {
    new YandexDiskMainPage(driver)
        .clickTrashButton();
    return new YandexDiskMainPage(driver).documentIsDisplayed();
  }

  public boolean foundFolderInTrash() {
    new YandexDiskMainPage(driver)
        .clickTrashButton();
    return new YandexDiskMainPage(driver).folderIsDisplayed();
  }

  public boolean isTrashEmpty() {
    new YandexDiskMainPage(driver)
        .clickTrashButton()
        .clickEmptyTrash()
        .confirmEmptyTrash();
    return new YandexDiskMainPage(driver).isEmpty();
  }
}

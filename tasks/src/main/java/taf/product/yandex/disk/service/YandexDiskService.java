package taf.product.yandex.disk.service;

import static taf.product.yandex.disk.service.FolderFactory.generateFolderName;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import taf.product.yandex.disk.page.YandexDiskAbstractPage;
import taf.product.yandex.disk.page.YandexDiskAuthPage;
import taf.product.yandex.disk.page.YandexDiskHomePage;
import taf.product.yandex.disk.page.YandexDiskDocumentPage;
import taf.product.yandex.disk.model.User;
import taf.product.yandex.disk.page.YandexDiskMainPage;

public class YandexDiskService extends YandexDiskAbstractPage {
  private final Logger logger = LogManager.getRootLogger();
  private ArrayList<String> tabs;

  public YandexDiskService(WebDriver driver) {
    super(driver);
  }

  public void switchToSecondTab() {
    logger.info("Switch to second tab");
    tabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1));
  }

  public void switchToFirstTab() {
    logger.info("Switch to first tab");
    driver.switchTo().window(tabs.get(0));
  }

  public void closeTab() {
    logger.info("Close tab");
    driver.close();
  }

  public void navigateToYandexDisk() {
    logger.info("Navigate to Yandex disk");
    new YandexDiskHomePage(driver)
        .openPage()
        .clickLoginButton();
  }

  public String getUserAccountName() {
    new YandexDiskAuthPage(driver)
        .clickUserAccount();
    return new YandexDiskAuthPage(driver).getUserName();
  }

  public void logIntoAccount(User user) {
    logger.info("Log into account in Yandex disk");
    new YandexDiskAuthPage(driver)
        .enterLogin(user.getUsername())
        .clickSignInButton()
        .enterPassword(user.getPassword())
        .clickSignInButton();
  }

  public void createNewFolder() {
    logger.info("Create new folder");
    new YandexDiskMainPage(driver)
        .clickMenuItemFiles()
        .clickCreateResource()
        .clickCreateFolder()
        .typeFolderName(generateFolderName())
        .clickSaveFolder()
        .visitCreatedFolder();
  }

  public void createNewDocument() {
    logger.info("Create new document");
    new YandexDiskMainPage(driver)
        .clickCreateResource()
        .clickCreateDocument();
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
    logger.info("Delete document");
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
    logger.info("Delete folder");
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

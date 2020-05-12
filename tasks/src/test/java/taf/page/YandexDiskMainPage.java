package taf.page;

import static taf.browser.Browser.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import taf.model.Folder;
import taf.service.DocumentFactory;

public class YandexDiskMainPage extends YandexDiskAbstractPage {
  public static final By NEWEST_TAB = By.xpath("//a[@title='Newest']");
  public static final By FILES_TAB = By.id("/disk");
  public static final By PHOTO_TAB = By.xpath("//a[@title='Photo']");
  public static final By SHARED_ACCESS_TAB = By.xpath("//a[@title='Shared access']");
  public static final By HISTORY_TAB = By.xpath("//a[@title='History']");
  public static final By ARCHIVE_TAB = By.xpath("//a[@title='Archive']");
  public static final By TRASH_TAB = By.id("/trash");

  public static final By CREATE_RESOURCE_TAB = By
      .xpath("//span[@class='create-resource-popup-with-anchor']/button");
  public static final By CREATE_FOLDER_BUTTON = By
      .xpath("//span[contains(@class, 'file-icon_dir_plus')]/..");
  public static final By FOLDER_NAME_INPUT = By
      .xpath("//form[@class='rename-dialog__rename-form']//input");
  public static final By CREATE_DOCUMENT_BUTTON = By
      .xpath("//span[contains(@class, 'file-icon_doc')]/..");

  public static final By EDIT_DOCUMENT_BUTTON = By
      .xpath("//button[contains(@class, 'groupable-buttons__visible-button_name_edit')]");
  public static final By DELETE_RESOURCE_BUTTON = By
      .xpath("//button[contains(@class, 'groupable-buttons__visible-button_name_delete')]");

  public static final By EMPTY_TRASH_BUTTON = By
      .xpath("//button[contains(@class,'client-listing__clean-trash-button')]");
  public static final By CONFIRMATION_EMPTY_TRASH_BUTTON = By
      .xpath("//button[contains(@class,'confirmation-dialog__button_submit')]");
  public static final By DOCUMENT_LINK = By.xpath("//div[@class='listing-item__info']");
  public static final By NOTIFICATION_MESSAGE_LABEL = By
      .cssSelector("div.notifications__text.js-message");

  public static final By TRASH_TITLE = By.xpath("//h1[@class='listing-heading__title']");

  public static final String PATTERN_FOUND_CREATED_DOCUMENT =
      "//div[@class='listing-item__info']//span[@title='%s.docx']";
  public static final String PATTERN_FOUND_CREATED_FOLDER =
      "//div[@class='listing-item__info']//span[contains(text(), '%s')]";

  private static String folderName;
  private static By createdFolder;
  private static By createdDocument;

  public YandexDiskMainPage(WebDriver driver) {
    super(driver);
  }

  public String getNewestLink() {
    return waitVisibilityOfElementLocated(NEWEST_TAB).getAttribute("href");
  }

  public String getFilesLink() {
    return driver.findElement(FILES_TAB).getAttribute("href");
  }

  public String getPhotoLink() {
    return driver.findElement(PHOTO_TAB).getAttribute("href");
  }

  public String getPublishedLink() {
    return driver.findElement(SHARED_ACCESS_TAB).getAttribute("href");
  }

  public String getHistoryLink() {
    return driver.findElement(HISTORY_TAB).getAttribute("href");
  }

  public String getArchiveLink() {
    return driver.findElement(ARCHIVE_TAB).getAttribute("href");
  }

  public String getTrashLink() {
    return driver.findElement(TRASH_TAB).getAttribute("href");
  }

  public YandexDiskMainPage clickMenuItemFiles() {
    waitElementToBeClickable(FILES_TAB).click();
    return this;
  }

  public YandexDiskMainPage createResource() {
    waitElementToBeClickable(CREATE_RESOURCE_TAB).click();
    return this;
  }

  public YandexDiskMainPage createFolder() {
    waitElementToBeClickable(CREATE_FOLDER_BUTTON).click();
    return this;
  }

  public YandexDiskMainPage typeFolderName(Folder folder) {
    folderName = folder.getName();

    WebElement folderNameInput = waitVisibilityOfElementLocated(FOLDER_NAME_INPUT);
    folderNameInput.sendKeys(Keys.CONTROL + "a");
    folderNameInput.sendKeys(folderName);
    return this;
  }

  public YandexDiskMainPage pressCreateFolder() {
    waitVisibilityOfElementLocated(FOLDER_NAME_INPUT).sendKeys(Keys.ENTER);
    waitVisibilityOfElementLocated(NOTIFICATION_MESSAGE_LABEL);
    return this;
  }

  public YandexDiskMainPage visitCreatedFolder() {
    createdFolder = By.xpath(String.format(PATTERN_FOUND_CREATED_FOLDER, folderName));

    waitVisibilityOfElementLocated(createdFolder);
    new Actions(driver).moveToElement(waitElementToBeClickable(createdFolder)).doubleClick().perform();
    return this;
  }

  public YandexDiskMainPage clickFoundFolder() {
    waitElementToBeClickable(createdFolder).click();
    return this;
  }

  public boolean folderIsDisplayed() {
    return waitVisibilityOfElementLocated(createdFolder).isDisplayed();
  }

  public void createNewDocument() {
    waitElementToBeClickable(CREATE_DOCUMENT_BUTTON).click();
  }

  public YandexDiskMainPage clickFoundDocument() {
    createdDocument = By.xpath(
        String.format(PATTERN_FOUND_CREATED_DOCUMENT, DocumentFactory.getDocumentInfo().getName()));
    waitElementToBeClickable(createdDocument).click();
    return this;
  }

  public boolean documentIsDisplayed() {
    return waitVisibilityOfElementLocated(createdDocument).isDisplayed();
  }

  public void clickEditDocument() {
    waitElementToBeClickable(EDIT_DOCUMENT_BUTTON).click();
  }

  public void clickDeleteResource() {
    waitElementToBeClickable(DELETE_RESOURCE_BUTTON).click();
  }

  public YandexDiskMainPage clickTrashButton() {
    waitElementToBeClickable(TRASH_TAB).click();
    return this;
  }

  public YandexDiskMainPage clickEmptyTrash() {
    waitElementToBeClickable(EMPTY_TRASH_BUTTON).click();
    return this;
  }

  public void confirmEmptyTrash() {
    waitElementToBeClickable(CONFIRMATION_EMPTY_TRASH_BUTTON).click();
    waitVisibilityOfElementLocated(NOTIFICATION_MESSAGE_LABEL);
  }

  public boolean isEmpty() {
    waitVisibilityOfElementLocated(TRASH_TITLE);
    int sizeTrash = driver.findElements(DOCUMENT_LINK).size();
    return sizeTrash == 0;
  }
}

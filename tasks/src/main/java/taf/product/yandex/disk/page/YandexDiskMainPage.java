package taf.product.yandex.disk.page;

import static taf.browser.Browser.*;

import taf.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import taf.product.yandex.disk.service.DocumentFactory;
import taf.product.yandex.disk.model.Folder;

public class YandexDiskMainPage extends YandexDiskAbstractPage {
  public static final By NEWEST_TAB = By.xpath("//a[@title='Newest']");
  public static final By FILES_TAB = By.id("/disk");
  public static final By PHOTO_TAB = By.xpath("//a[@title='Photo']");
  public static final By SHARED_ACCESS_TAB = By.xpath("//a[@title='Shared access']");
  public static final By HISTORY_TAB = By.xpath("//a[@title='History']");
  public static final By ARCHIVE_TAB = By.xpath("//a[@title='Archive']");
  public static final By TRASH_TAB = By.id("/trash");

  public static final By CREATE_RESOURCE_BUTTON = By
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
  public static final By PROGRESS_BAR = By
      .cssSelector("div.ns-view-boxProgressbars.ns-view-id-5");

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
    Log.info("Click 'Files' menu item in main page");
    waitElementToBeClickable(FILES_TAB);
    highlightElement(FILES_TAB).click();
    return this;
  }

  public YandexDiskMainPage clickCreateResource() {
    Log.info("Click 'Create' button for new resource");
    waitElementToBeClickable(CREATE_RESOURCE_BUTTON);
    highlightElement(CREATE_RESOURCE_BUTTON).click();
    return this;
  }

  public YandexDiskMainPage clickCreateFolder() {
    Log.info("Click 'Folder' button");
    waitElementToBeClickable(CREATE_FOLDER_BUTTON);
    highlightElement(CREATE_FOLDER_BUTTON).click();
    return this;
  }

  public YandexDiskMainPage typeFolderName(Folder folder) {
    folderName = folder.getName();
    Log.info(String.format("Type folder name in rename form - %s", folderName));

    highlightElement(FOLDER_NAME_INPUT);
    WebElement folderNameInput = waitVisibilityOfElementLocated(FOLDER_NAME_INPUT);
    folderNameInput.sendKeys(Keys.CONTROL + "a");
    folderNameInput.sendKeys(folderName);
    return this;
  }

  public YandexDiskMainPage clickSaveFolder() {
    Log.info("Click 'Save' button and wait notifications text about saving");
    waitVisibilityOfElementLocated(FOLDER_NAME_INPUT);
    highlightElement(FOLDER_NAME_INPUT).sendKeys(Keys.ENTER);
    waitVisibilityOfElementLocated(NOTIFICATION_MESSAGE_LABEL);
    return this;
  }

  public YandexDiskMainPage visitCreatedFolder() {
    Log.info("Click two times for visit created folder");
    createdFolder = By.xpath(String.format(PATTERN_FOUND_CREATED_FOLDER, folderName));

    waitVisibilityOfElementLocated(createdFolder);
    new Actions(driver).moveToElement(waitElementToBeClickable(createdFolder)).doubleClick().perform();
    return this;
  }

  public YandexDiskMainPage clickFoundFolder() {
    Log.info(String.format("Click on created folder %s ", folderName));
    waitElementToBeClickable(createdFolder);
    highlightElement(createdFolder).click();
    return this;
  }

  public boolean folderIsDisplayed() {
    return waitVisibilityOfElementLocated(createdFolder).isDisplayed();
  }

  public void clickCreateDocument() {
    Log.info("Click 'Document' button");
    waitElementToBeClickable(CREATE_DOCUMENT_BUTTON);
    highlightElement(CREATE_DOCUMENT_BUTTON).click();
  }

  public YandexDiskMainPage clickFoundDocument() {
    String documentName = DocumentFactory.getDocumentInfo().getName();
    Log.info(String.format("Click on created document %s", documentName));
    createdDocument = By.xpath(String.format(PATTERN_FOUND_CREATED_DOCUMENT, documentName));
    waitElementToBeClickable(createdDocument);
    highlightElement(createdDocument).click();
    return this;
  }

  public boolean documentIsDisplayed() {
    return waitVisibilityOfElementLocated(createdDocument).isDisplayed();
  }

  public void clickEditDocument() {
    Log.info("Click 'Edit' button in toolbar");
    waitElementToBeClickable(EDIT_DOCUMENT_BUTTON);
    highlightElement(EDIT_DOCUMENT_BUTTON).click();
  }

  public void clickDeleteResource() {
    Log.info("Click 'Delete' button in toolbar");
    waitElementToBeClickable(DELETE_RESOURCE_BUTTON);
    highlightElement(DELETE_RESOURCE_BUTTON).click();
    waitInvisibilityOfElementLocated(PROGRESS_BAR);
  }

  public YandexDiskMainPage clickTrashButton() {
    Log.info("Click 'Trash' menu item in main page");
    waitElementToBeClickable(TRASH_TAB);
    highlightElement(TRASH_TAB).click();
    return this;
  }

  public YandexDiskMainPage clickEmptyTrash() {
    Log.info("Click 'Empty trash' button");
    waitElementToBeClickable(EMPTY_TRASH_BUTTON);
    highlightElement(EMPTY_TRASH_BUTTON).click();
    return this;
  }

  public void confirmEmptyTrash() {
    Log.info("Click 'Empty' button for confirmation deleting files");
    waitElementToBeClickable(CONFIRMATION_EMPTY_TRASH_BUTTON);
    highlightElement(CONFIRMATION_EMPTY_TRASH_BUTTON).click();
    waitVisibilityOfElementLocated(NOTIFICATION_MESSAGE_LABEL);
  }

  public boolean isEmpty() {
    waitVisibilityOfElementLocated(TRASH_TITLE);
    int sizeTrash = driver.findElements(DOCUMENT_LINK).size();
    return sizeTrash == 0;
  }
}

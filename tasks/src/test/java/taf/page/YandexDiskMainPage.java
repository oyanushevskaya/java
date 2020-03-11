package taf.page;

import static taf.browser.Browser.*;
import static taf.util.StringUtils.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import taf.util.StringUtils;

public class YandexDiskMainPage extends YandexDiskAbstractPage {
  public final static By NEWEST_TITLE = By.xpath("//a[@title='Newest']");
  public final static By ID_FILES = By.id("/disk");
  public final static By PHOTO_TITLE = By.xpath("//a[@title='Photo']");
  public final static By SHARED_ACCESS_TITLE = By.xpath("//a[@title='Shared access']");
  public final static By HISTORY_TITLE = By.xpath("//a[@title='History']");
  public final static By ARCHIVE_TITLE = By.xpath("//a[@title='Archive']");
  public final static By ID_TRASH = By.id("/trash");

  public final static By CREATE_RESOURCE = By
      .xpath("//span[@class='create-resource-popup-with-anchor']/button");
  public final static By CREATE_RESOURCE_FOLDER = By
      .xpath("//span[contains(@class, 'file-icon_dir_plus')]/..");
  public final static By FOLDER_NAME_INPUT = By
      .xpath("//form[@class='rename-dialog__rename-form']//input");
  public final static By CREATE_RESOURCE_DOCUMENT = By
      .xpath("//span[contains(@class, 'file-icon_doc')]/..");

  public final static By EDIT_DOCUMENT_BUTTON = By
      .xpath("//button[contains(@class, 'groupable-buttons__visible-button_name_edit')]");
  public final static By DELETE_DOCUMENT_BUTTON = By
      .xpath("//button[contains(@class, 'groupable-buttons__visible-button_name_delete')]");

  public final static By DOCUMENT_TITLE = By
      .xpath("//div[@class='listing-item__info']//span[@title='" + DOCUMENT_NAME + ".docx']");
  public final static By EMPTY_TRASH_BUTTON = By
      .xpath("//button[contains(@class,'client-listing__clean-trash-button')]");
  public final static By CONFIRMATION_EMPTY_TRASH = By
      .xpath("//button[contains(@class,'confirmation-dialog__button_submit')]");
  public final static By ALL_DOCUMENTS = By.xpath("//div[@class='listing-item__info']");
  public final static By MESSAGE_TRASH_EMPTIED = By
      .xpath("//div[@class='notifications__text js-message']");

  public final static String CREATED_FOLDER = "//span[contains(text(), '%s')]/parent::div";
  public final static String FOUNDED_FOLDER = "//div[@class='listing-item__info']//span[contains(text(), '%s')]";

  private static String folderName;
  private WebElement folderNameInput;


  public YandexDiskMainPage(WebDriver driver) {
    super(driver);
  }

  public String getNewestLink() {
    waitElementToBeClickable(driver, NEWEST_TITLE);
    return driver.findElement(NEWEST_TITLE).getAttribute("href");
  }

  public String getFilesLink() {
    return driver.findElement(ID_FILES).getAttribute("href");
  }

  public String getPhotoLink() {
    return driver.findElement(PHOTO_TITLE).getAttribute("href");
  }

  public String getPublishedLink() {
    return driver.findElement(SHARED_ACCESS_TITLE).getAttribute("href");
  }

  public String getHistoryLink() {
    return driver.findElement(HISTORY_TITLE).getAttribute("href");
  }

  public String getArchiveLink() {
    return driver.findElement(ARCHIVE_TITLE).getAttribute("href");
  }

  public String getTrashLink() {
    return driver.findElement(ID_TRASH).getAttribute("href");
  }

  public YandexDiskMainPage clickMenuItemFiles() {
    waitElementToBeClickable(driver, ID_FILES).click();
    return this;
  }

  public YandexDiskMainPage createFolder() {
    waitElementToBeClickable(driver, CREATE_RESOURCE).click();
    waitElementToBeClickable(driver, CREATE_RESOURCE_FOLDER).click();
    return this;
  }

  public YandexDiskMainPage pressCreateFolder() {
    folderNameInput.sendKeys(Keys.ENTER);
    return this;
  }

  public YandexDiskMainPage typeFolderName() {
    folderName = new StringUtils().generateFolderName();

    folderNameInput = driver.findElement(FOLDER_NAME_INPUT);
    folderNameInput.sendKeys(Keys.CONTROL + "a");
    waitElementToBeClickable(driver, FOLDER_NAME_INPUT).sendKeys(folderName);
    return this;
  }

  public YandexDiskMainPage visitCreatedFolder() {
    Actions actions = new Actions(driver);
    By createdFolder = By.xpath(String.format(CREATED_FOLDER, folderName));
    waitElementToBeClickable(driver, createdFolder);

    WebElement findFolder = driver.findElement(createdFolder);
    waitElementToBeClickable(driver, createdFolder);
    actions.doubleClick(findFolder).perform();
    return this;
  }

  public boolean folderIsDisplayed() {
    WebElement foundFolder = driver.findElement(By.xpath(String.format(FOUNDED_FOLDER, folderName)));
    return foundFolder.isDisplayed();
  }

  public void createNewDocument() {
    waitElementToBeClickable(driver, CREATE_RESOURCE).click();
    waitElementToBeClickable(driver, CREATE_RESOURCE_DOCUMENT).click();
  }

  public YandexDiskMainPage clickFoundDocument() {
    waitElementToBeClickable(driver, DOCUMENT_TITLE).click();
    return this;
  }

  public boolean documentIsDisplayed() {
    waitForVisibility(driver, driver.findElement(DOCUMENT_TITLE));
    return driver.findElement(DOCUMENT_TITLE).isDisplayed();
  }

  public void clickEditDocumentButton() {
    waitElementToBeClickable(driver, EDIT_DOCUMENT_BUTTON).click();
  }

  public void clickDeleteDocumentButton() {
    waitElementToBeClickable(driver, DELETE_DOCUMENT_BUTTON).click();
  }

  public YandexDiskMainPage clickTrashButton() {
    waitElementToBeClickable(driver, ID_TRASH).click();
    return this;
  }

  public YandexDiskMainPage clickEmptyTrash() {
    waitElementToBeClickable(driver, EMPTY_TRASH_BUTTON).click();
    return this;
  }

  public void confirmEmptyTrash() {
    waitElementToBeClickable(driver, CONFIRMATION_EMPTY_TRASH).click();
    waitElementToBeClickable(driver, MESSAGE_TRASH_EMPTIED);
  }

  public boolean isEmpty() {
    int sizeTrash = driver.findElements(ALL_DOCUMENTS).size();
    return sizeTrash == 0;
  }
}

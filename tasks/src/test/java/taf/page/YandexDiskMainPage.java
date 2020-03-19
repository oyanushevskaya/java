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
  public final static By NEWEST_TAB = By.xpath("//a[@title='Newest']");
  public final static By FILES_TAB = By.id("/disk");
  public final static By PHOTO_TAB = By.xpath("//a[@title='Photo']");
  public final static By SHARED_ACCESS_TAB = By.xpath("//a[@title='Shared access']");
  public final static By HISTORY_TAB = By.xpath("//a[@title='History']");
  public final static By ARCHIVE_TAB = By.xpath("//a[@title='Archive']");
  public final static By TRASH_TAB = By.id("/trash");

  public final static By CREATE_RESOURCE_TAB = By
      .xpath("//span[@class='create-resource-popup-with-anchor']/button");
  public final static By CREATE_FOLDER_BUTTON = By
      .xpath("//span[contains(@class, 'file-icon_dir_plus')]/..");
  public final static By FOLDER_NAME_INPUT = By
      .xpath("//form[@class='rename-dialog__rename-form']//input");
  public final static By CREATE_DOCUMENT_BUTTON = By
      .xpath("//span[contains(@class, 'file-icon_doc')]/..");

  public final static By EDIT_DOCUMENT_BUTTON = By
      .xpath("//button[contains(@class, 'groupable-buttons__visible-button_name_edit')]");
  public final static By DELETE_DOCUMENT_BUTTON = By
      .xpath("//button[contains(@class, 'groupable-buttons__visible-button_name_delete')]");

  public final static By EMPTY_TRASH_BUTTON = By
      .xpath("//button[contains(@class,'client-listing__clean-trash-button')]");
  public final static By CONFIRMATION_EMPTY_TRASH_BUTTON = By
      .xpath("//button[contains(@class,'confirmation-dialog__button_submit')]");
  public final static By DOCUMENT_LINK = By.xpath("//div[@class='listing-item__info']");
  public final static By TRASH_EMPTIED_MESSAGE_LABEL = By
      .cssSelector("div.notifications__text.js-message");

  public final static String PATTERN_FOUND_DOCUMENT = "//div[@class='listing-item__info']//span[@title='%s.docx']";
  public final static String PATTERN_CREATED_FOLDER = "//span[contains(text(), '%s')]/parent::div";
  public final static String PATTERN_FOUND_FOLDER = "//div[@class='listing-item__info']//span[contains(text(), '%s')]";

  private static String folderName;

  public YandexDiskMainPage(WebDriver driver) {
    super(driver);
  }

  public String getNewestLink() {
    waitElementToBeClickable(driver, NEWEST_TAB);
    return driver.findElement(NEWEST_TAB).getAttribute("href");
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
    waitElementToBeClickable(driver, FILES_TAB).click();
    return this;
  }

  public YandexDiskMainPage createFolder() {
    waitElementToBeClickable(driver, CREATE_RESOURCE_TAB).click();
    waitElementToBeClickable(driver, CREATE_FOLDER_BUTTON).click();
    return this;
  }

  public YandexDiskMainPage typeFolderName() {
    folderName = new StringUtils().generateFolderName();

    waitForVisibility(driver, driver.findElement(FOLDER_NAME_INPUT));
    waitElementToBeClickable(driver, FOLDER_NAME_INPUT).sendKeys(Keys.CONTROL + "a");
    waitElementToBeClickable(driver, FOLDER_NAME_INPUT).sendKeys(folderName);
    return this;
  }

  public YandexDiskMainPage pressCreateFolder() {
    waitElementToBeClickable(driver, FOLDER_NAME_INPUT).sendKeys(Keys.ENTER);
    return this;
  }

  public YandexDiskMainPage visitCreatedFolder() {
    Actions actions = new Actions(driver);
    By createdFolder = By.xpath(String.format(PATTERN_CREATED_FOLDER, folderName));
    waitElementToBeClickable(driver, createdFolder);

    WebElement findFolder = driver.findElement(createdFolder);
    waitElementToBeClickable(driver, createdFolder);
    actions.doubleClick(findFolder).perform();
    return this;
  }

  public boolean folderIsDisplayed() {
    WebElement foundFolder = driver.findElement(By.xpath(String.format(PATTERN_FOUND_FOLDER, folderName)));
    return foundFolder.isDisplayed();
  }

  public void createNewDocument() {
    waitElementToBeClickable(driver, CREATE_RESOURCE_TAB).click();
    waitElementToBeClickable(driver, CREATE_DOCUMENT_BUTTON).click();
  }

  public YandexDiskMainPage clickFoundDocument() {
    waitElementToBeClickable(driver, By.xpath(String.format(PATTERN_FOUND_DOCUMENT, DOCUMENT_NAME))).click();
    return this;
  }

  public boolean documentIsDisplayed() {
    return waitForVisibility(driver,
        driver.findElement(By.xpath(String.format(PATTERN_FOUND_DOCUMENT, DOCUMENT_NAME))))
        .isDisplayed();
  }

  public void clickEditDocumentButton() {
    waitElementToBeClickable(driver, EDIT_DOCUMENT_BUTTON).click();
  }

  public void clickDeleteDocumentButton() {
    waitForVisibility(driver, driver.findElement(DELETE_DOCUMENT_BUTTON));
    waitElementToBeClickable(driver, DELETE_DOCUMENT_BUTTON).click();
  }

  public YandexDiskMainPage clickTrashButton() {
    waitElementToBeClickable(driver, TRASH_TAB).click();
    return this;
  }

  public YandexDiskMainPage clickEmptyTrash() {
    waitElementToBeClickable(driver, EMPTY_TRASH_BUTTON).click();
    return this;
  }

  public void confirmEmptyTrash() {
    waitElementToBeClickable(driver, CONFIRMATION_EMPTY_TRASH_BUTTON).click();
    waitElementToBeClickable(driver, TRASH_EMPTIED_MESSAGE_LABEL);
  }

  public boolean isEmpty() {
    int sizeTrash = driver.findElements(DOCUMENT_LINK).size();
    return sizeTrash == 0;
  }
}

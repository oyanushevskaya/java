package taf.page;

import static taf.browser.Browser.*;
import static taf.constants.Constants.*;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class YandexDiskMainPage extends YandexDiskAbstractPage {
  private static String folderName;
  private WebElement folderNameInput;

  private String generateFolderName() {
    Random random = new Random();
    return "folder_" + random.nextInt(RANDOM_NUMBER_BOUND);
  }

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
    waitElementToBeClickable(driver, ID_FILES);
    driver.findElement(ID_FILES).click();
    return this;
  }

  public YandexDiskMainPage createFolder() {
    waitElementToBeClickable(driver, CREATE_RESOURCE);
    driver.findElement(CREATE_RESOURCE).click();

    waitElementToBeClickable(driver, CREATE_RESOURCE_FOLDER);
    driver.findElement(CREATE_RESOURCE_FOLDER).click();
    return this;
  }

  public YandexDiskMainPage pressCreateFolder() {
    folderNameInput.sendKeys(Keys.ENTER);
    return this;
  }

  public YandexDiskMainPage typeFolderName() {
    folderName = generateFolderName();

    folderNameInput = driver.findElement(FOLDER_NAME_INPUT);
    folderNameInput.sendKeys(Keys.CONTROL + "a");
    waitForVisibleElement(driver, folderNameInput);
    folderNameInput.sendKeys(folderName);
    return this;
  }

  public YandexDiskMainPage visitCreatedFolder() {
    Actions actions = new Actions(driver);
    By createdFolder = By.xpath("//span[contains(text(), '"+ folderName +"')]/parent::div");
    waitElementToBeClickable(driver, createdFolder);

    WebElement findFolder = driver.findElement(createdFolder);
    waitElementToBeClickable(driver, createdFolder);
    actions.doubleClick(findFolder).perform();
    return this;
  }

  public boolean folderIsDisplayed() {
    WebElement foundFolder = driver.findElement(By.xpath("//div[@class='listing-item__info']//span[contains(text(), '"+ folderName +"')]"));
    return foundFolder.isDisplayed();
  }

  public void createNewDocument() {
    waitElementToBeClickable(driver, CREATE_RESOURCE);
    driver.findElement(CREATE_RESOURCE).click();

    waitElementToBeClickable(driver, CREATE_RESOURCE_DOCUMENT);
    driver.findElement(CREATE_RESOURCE_DOCUMENT).click();
  }

  public YandexDiskMainPage clickFoundDocument() {
    waitElementToBeClickable(driver, DOCUMENT_TITLE);
    driver.findElement(DOCUMENT_TITLE).click();
    return this;
  }

  public boolean documentIsDisplayed() {
    waitForVisibleElement(driver, driver.findElement(DOCUMENT_TITLE));
    return driver.findElement(DOCUMENT_TITLE).isDisplayed();
  }

  public void clickEditDocumentButton() {
    waitElementToBeClickable(driver, EDIT_DOCUMENT_BUTTON);
    driver.findElement(EDIT_DOCUMENT_BUTTON).click();
  }

  public void clickDeleteDocumentButton() {
    waitElementToBeClickable(driver, DELETE_DOCUMENT_BUTTON);
    driver.findElement(DELETE_DOCUMENT_BUTTON).click();
  }

  public YandexDiskMainPage clickTrashButton() {
    waitElementToBeClickable(driver, ID_TRASH);
    driver.findElement(ID_TRASH).click();
    return this;
  }

  public YandexDiskMainPage clickEmptyTrash() {
    waitElementToBeClickable(driver, EMPTY_TRASH_BUTTON);
    driver.findElement(EMPTY_TRASH_BUTTON).click();
    return this;
  }

  public void confirmEmptyTrash() {
    waitElementToBeClickable(driver, CONFIRMATION_EMPTY_TRASH);
    driver.findElement(CONFIRMATION_EMPTY_TRASH).click();
    waitElementToBeClickable(driver, MESSAGE_TRASH_EMPTIED);
    driver.findElement(MESSAGE_TRASH_EMPTIED);
  }

  public boolean isEmpty() {
    int sizeTrash = driver.findElements(ALL_DOCUMENTS).size();
    return sizeTrash == 0;
  }
}

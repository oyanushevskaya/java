package taf.constants;

import org.openqa.selenium.By;

public class Constants {
  public final static int TIME_OUT_IN_SECONDS = 30;

  public final static int RANDOM_NUMBER_BOUND = 100;

  public final static String LOGIN = "training.test.login";
  public final static String PASSWORD = "training.test.password";
  public final static String DOCUMENT_BODY_TEXT = "Hello world!!!";
  public final static String DOCUMENT_NAME = "Hello world";

  public final static String HOMEPAGE_URL = "https://disk.yandex.com/";

  public final static By ERROR_MESSAGE = By.xpath("//div[@class='passp-form-field__error']");
  public final static By USER_ACCOUNT = By.xpath("//div[@class='user-pic user-account__pic']");
  public final static By USER_ACCOUNT_NAME = By.xpath("//span[@class='user-account__name']");

  public final static By LOGIN_BUTTON = By.xpath("//a[contains(@class,'button_login')]");
  public final static By LOGIN_FIELD = By.id("passp-field-login");
  public final static By PASSWORD_FIELD = By.id("passp-field-passwd");
  public final static By SIGN_IN_BUTTON = By.xpath("//div[@class='passp-button passp-sign-in-button']");

  public final static By NEWEST_TITLE = By.xpath("//a[@title='Newest']");
  public final static By ID_FILES = By.id("/disk");
  public final static By PHOTO_TITLE = By.xpath("//a[@title='Photo']");
  public final static By SHARED_ACCESS_TITLE = By.xpath("//a[@title='Shared access']");
  public final static By HISTORY_TITLE = By.xpath("//a[@title='History']");
  public final static By ARCHIVE_TITLE = By.xpath("//a[@title='Archive']");
  public final static By ID_TRASH = By.id("/trash");

  public final static String NEWEST_LINK = "https://disk.yandex.com/client/recent";
  public final static String FILES_LINK = "https://disk.yandex.com/client/disk";
  public final static String PHOTO_LINK = "https://disk.yandex.com/client/photo";
  public final static String PUBLISHED_LINK = "https://disk.yandex.com/client/shared";
  public final static String HISTORY_LINK = "https://disk.yandex.com/client/journal";
  public final static String ARCHIVE_LINK = "https://disk.yandex.com/client/attach";
  public final static String TRASH_LINK = "https://disk.yandex.com/client/trash";

  public final static By CREATE_RESOURCE = By.xpath("//span[@class='create-resource-popup-with-anchor']/button");
  public final static By CREATE_RESOURCE_FOLDER = By.xpath("//span[contains(@class, 'file-icon_dir_plus')]/..");
  public final static By FOLDER_NAME_INPUT = By.xpath("//form[@class='rename-dialog__rename-form']//input");
  public final static By CREATE_RESOURCE_DOCUMENT = By.xpath("//span[contains(@class, 'file-icon_doc')]/..");

  public final static By TEXT_INPUT = By.xpath("//*[@id='WACViewPanel_EditingElement']/p");
  public final static By MENU_ITEM_FILE = By.id("id__1");
  public final static By MENU_ITEM_SAVE_AS = By.xpath("//a[@id='faSaveAs-Menu32']");
  public final static By MENU_ITEM_RENAME = By.xpath("//li/a[@id='jbtnRenameDialog-Menu48']");
  public final static By MENU_ITEM_EXIT = By.xpath("//a[@id='btnjClose-Menu32']");

  public final static By DOCUMENT_NAME_INPUT = By.id("txtDocumentName");
  public final static By EDIT_DOCUMENT_BUTTON = By.xpath("//button[contains(@class, 'groupable-buttons__visible-button_name_edit')]");
  public final static By DELETE_DOCUMENT_BUTTON = By.xpath("//button[contains(@class, 'groupable-buttons__visible-button_name_delete')]");
  public final static By DOCUMENT_SAVE_STATUS = By.xpath("//span[contains(text(),'Saved to Yandex')]");

  public final static By DOCUMENT_TITLE = By.xpath("//div[@class='listing-item__info']//span[@title='"+ DOCUMENT_NAME +".docx']");
  public final static By EMPTY_TRASH_BUTTON = By.xpath("//button[contains(@class,'client-listing__clean-trash-button')]");
  public final static By CONFIRMATION_EMPTY_TRASH = By.xpath("//button[contains(@class,'confirmation-dialog__button_submit')]");
  public final static By ALL_DOCUMENTS = By.xpath("//div[@class='listing-item__info']");
  public final static By MESSAGE_TRASH_EMPTIED = By.xpath("//div[@class='notifications__text js-message']");
}

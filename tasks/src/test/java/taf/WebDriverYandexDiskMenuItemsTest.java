package taf;

import static taf.constants.Constants.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import taf.page.YandexDiskMainPage;
import taf.service.YandexDiskService;

public class WebDriverYandexDiskMenuItemsTest {
  private WebDriver driver;

  @BeforeMethod(alwaysRun = true,
      description = "Google Chrome opens, goes to Yandex Disk Auth page and logged in with correct credentials")
  public void goToDiskMainPage() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    new YandexDiskService(driver)
        .navigateToYandexDisk()
        .logIntoAccount();
  }

  @Test(description = "Check that all main menu items works correctly and lead to correct page")
  public void checkMenuItems() {
    YandexDiskMainPage mainPage = new YandexDiskMainPage(driver);
    SoftAssert softAssert = new SoftAssert();
    softAssert.assertEquals(mainPage.getNewestLink(), NEWEST_LINK,
        "not selected 'Newest' menu item");
    softAssert.assertEquals(mainPage.getFilesLink(), FILES_LINK,
        "not selected 'Files' menu item");
    softAssert.assertEquals(mainPage.getPhotoLink(), PHOTO_LINK,
        "not selected 'Photo' menu item");
    softAssert.assertEquals(mainPage.getPublishedLink(), PUBLISHED_LINK,
        "not selected 'Shared access' menu item");
    softAssert.assertEquals(mainPage.getHistoryLink(), HISTORY_LINK,
        "not selected 'History' menu item");
    softAssert.assertEquals(mainPage.getArchiveLink(), ARCHIVE_LINK,
        "not selected 'Archive' menu item");
    softAssert.assertEquals(mainPage.getTrashLink(), TRASH_LINK,
        "not selected 'Trash' menu item");
    softAssert.assertAll();
  }

  @AfterMethod(alwaysRun = true, description = "Google Chrome browser closes")
  public void browserTearDown() {
    driver.quit();
  }
}

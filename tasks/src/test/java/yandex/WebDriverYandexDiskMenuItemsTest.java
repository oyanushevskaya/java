package yandex;

import static taf.product.yandex.disk.data.DataStorage.*;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import taf.product.yandex.disk.page.YandexDiskMainPage;

public class WebDriverYandexDiskMenuItemsTest extends CommonConditions {

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

}

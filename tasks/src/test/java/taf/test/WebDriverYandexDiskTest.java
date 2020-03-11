package taf.test;

import static taf.util.StringUtils.*;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import taf.service.YandexDiskService;

public class WebDriverYandexDiskTest extends CommonConditions{

  private YandexDiskService yandexDiskService;

  @Test(description = "Check creation of new folder and can visited that folder")
  public void verifyCreateNewFolder() {
    yandexDiskService = new YandexDiskService(driver);
    yandexDiskService.createNewFolder();
    Assert.assertTrue(new YandexDiskService(driver).foundCreatedFolder(),
        "folder was not found");
  }

  @Test(description = "Check new file and can opened this file")
  public void verifyCreateNewFile() {
    SoftAssert softAssert = new SoftAssert();
    yandexDiskService = new YandexDiskService(driver);
    yandexDiskService.createNewFolder();
    yandexDiskService.createNewDocument();
    softAssert.assertTrue(new YandexDiskService(driver).foundCreatedDocumentInFolder(),
        "document was not found in folder");
    softAssert.assertEquals(new YandexDiskService(driver).foundTextInDocument(),
        " " + DOCUMENT_BODY_TEXT + " ",
        "text was not equals in document");
  }

  @Test(description = "Check document in trash")
  public void verifyMoveDocumentToTrash() {
    yandexDiskService = new YandexDiskService(driver);
    yandexDiskService.createNewFolder();
    yandexDiskService.createNewDocument();
    yandexDiskService.deleteDocument();
    Assert.assertTrue(new YandexDiskService(driver).foundDocumentInTrash(),
        "document was not found in trash");
  }

  @Test(description = "Check trash is empty", dependsOnMethods = "verifyMoveDocumentToTrash")
  public void verifyTrashIsEmpty() {
    new YandexDiskService(driver)
        .isTrashEmpty();
    Assert.assertTrue(new YandexDiskService(driver).trashIsEmpty(), "trash is not empty");
  }
}

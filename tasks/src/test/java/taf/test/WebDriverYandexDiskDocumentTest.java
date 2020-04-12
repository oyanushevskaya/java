package taf.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import taf.service.DocumentCreator;
import taf.service.TestDataReader;
import taf.service.YandexDiskService;

public class WebDriverYandexDiskDocumentTest extends CommonConditions{
  private YandexDiskService yandexDiskService;

  @Test(description = "Check new file and can opened this file, check text in document")
  public void verifyCreateNewDocument() {
    yandexDiskService = new YandexDiskService(driver);
    yandexDiskService.createNewFolder();
    yandexDiskService.createNewDocument();
    Assert.assertTrue(new YandexDiskService(driver).foundCreatedDocumentInFolder(),
        "document was not found in folder");
  }

  @Test(description = "Check text in document", dependsOnMethods = "verifyCreateNewDocument")
  public void verifyTextInDocument() {
    Assert.assertEquals(new YandexDiskService(driver).foundTextInDocument(),
        " " + TestDataReader.getTestData(DocumentCreator.DOCUMENT_BODY_TEXT) + " ",
        "text was not equals in document");
  }

  @Test(description = "Check document in trash", dependsOnMethods = "verifyTextInDocument")
  public void verifyDeleteDocument() {
    yandexDiskService.deleteDocument();
    yandexDiskService.deleteFolder();
    Assert.assertTrue(new YandexDiskService(driver).foundDocumentInTrash(),
        "document was not found in trash");
  }
}

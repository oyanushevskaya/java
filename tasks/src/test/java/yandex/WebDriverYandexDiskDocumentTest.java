package yandex;

import org.testng.Assert;
import org.testng.annotations.Test;
import taf.product.yandex.disk.service.DocumentFactory;
import taf.reader.TestDataReader;
import taf.product.yandex.disk.service.YandexDiskService;

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

  @Test(description = "Check text in document")
  public void verifyTextInDocument() {
    Assert.assertEquals(new YandexDiskService(driver).foundTextInDocument(),
        " " + TestDataReader.getTestData(DocumentFactory.DOCUMENT_BODY_TEXT) + " ",
        "text was not equals in document");
  }

  @Test(description = "Check document in trash")
  public void verifyDeleteDocument() {
    yandexDiskService.deleteDocument();
    yandexDiskService.deleteFolder();
    Assert.assertTrue(new YandexDiskService(driver).foundDocumentInTrash(),
        "document was not found in trash");
  }
}

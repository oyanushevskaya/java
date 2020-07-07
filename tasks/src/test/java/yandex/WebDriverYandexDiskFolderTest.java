package yandex;

import org.testng.Assert;
import org.testng.annotations.Test;
import taf.product.yandex.disk.service.YandexDiskService;

public class WebDriverYandexDiskFolderTest extends CommonConditions {
  private YandexDiskService yandexDiskService;

  @Test(description = "Check creation of new folder and can visited that folder")
  public void verifyCreateNewFolder() {
    yandexDiskService = new YandexDiskService(driver);
    yandexDiskService.createNewFolder();
    Assert.assertTrue(new YandexDiskService(driver).foundCreatedFolder(),
        "folder was not found");
  }

  @Test(description = "Check folder in trash")
  public void verifyDeleteFolder() {
    yandexDiskService.deleteFolder();
    Assert.assertTrue(new YandexDiskService(driver).foundFolderInTrash(),
        "folder was not found in trash");
  }
}

package yandex;

import org.testng.Assert;
import org.testng.annotations.*;
import taf.product.yandex.disk.service.YandexDiskService;

public class WebDriverYandexDiskRecycleBinTest extends CommonConditions{

  @Test(description = "Check trash is empty")
  public void verifyTrashIsEmpty() {
    Assert.assertTrue(new YandexDiskService(driver).isTrashEmpty(), "trash is not empty");
  }
}

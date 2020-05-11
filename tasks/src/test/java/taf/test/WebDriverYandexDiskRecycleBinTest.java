package taf.test;

import org.testng.Assert;
import org.testng.annotations.*;
import taf.service.YandexDiskService;

public class WebDriverYandexDiskRecycleBinTest extends CommonConditions{

  @Test(description = "Check trash is empty")
  public void verifyTrashIsEmpty() {
    Assert.assertTrue(new YandexDiskService(driver).trashIsEmpty(), "trash is not empty");
  }
}

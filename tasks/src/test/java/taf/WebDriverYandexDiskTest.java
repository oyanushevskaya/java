package taf;

import static taf.constants.Constants.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import taf.service.YandexDiskService;

public class WebDriverYandexDiskTest {
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

  @Test(description = "Check creation of new folder and can visited that folder")
  public void verifyCreateNewFolder() {
    new YandexDiskService(driver)
        .createNewFolder();
    Assert.assertTrue(new YandexDiskService(driver).foundCreatedFolder(),
        "folder was not found");
  }

  @Test(description = "Check new file and can opened this file")
  public void verifyCreateNewFile() {
    new YandexDiskService(driver)
        .createNewFolder()
        .createNewDocument();
    Assert.assertTrue(new YandexDiskService(driver).foundCreatedDocumentInFolder(),
        "document was not found in folder");
    Assert.assertEquals(new YandexDiskService(driver).foundTextInDocument(),
        " " + DOCUMENT_BODY_TEXT + " ",
        "text was not equals in document");
  }

  @Test(description = "Check document in trash")
  public void verifyMoveDocumentToTrash() {
    new YandexDiskService(driver)
        .createNewFolder()
        .createNewDocument()
        .deleteDocument();
    Assert.assertTrue(new YandexDiskService(driver).foundDocumentInTrash(),
        "document was not found in trash");
  }

  @Test(description = "Check trash is empty", dependsOnMethods = "verifyMoveDocumentToTrash")
  public void verifyTrashIsEmpty() {
    new YandexDiskService(driver)
        .emptyTrash();
    Assert.assertTrue(new YandexDiskService(driver).trashIsEmpty(), "trash is not empty");
  }

  @AfterMethod(alwaysRun = true)
  public void browserTearDown() {
    driver.quit();
  }
}

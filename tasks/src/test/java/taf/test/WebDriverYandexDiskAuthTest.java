package taf.test;

import static taf.util.StringUtils.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import taf.page.YandexDiskAuthPage;
import taf.service.YandexDiskService;

public class WebDriverYandexDiskAuthTest {
  private WebDriver driver;

  @DataProvider(name = "Credentials")
  public static Object[][] getData() {
    return new Object[][]{
        {INVALID_LOGIN, INVALID_PASSWORD, false},
        {VALID_LOGIN, VALID_PASSWORD, true}};
  }

  @BeforeMethod(alwaysRun = true, description = "Google Chrome opens, goes to Yandex Disk Auth page")
  public void goToAuthPage() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    new YandexDiskService(driver)
        .navigateToYandexDisk();
  }

  @Test(dataProvider = "Credentials",
      description = "Verify that not log or log into account in Yandex Disk")
  public void verifyLoginIntoYandexDisk(String login, String password, boolean shouldSucceed) {
    SoftAssert softAssert = new SoftAssert();
    new YandexDiskAuthPage(driver)
        .logInYandexDisk(login, password);
    if (shouldSucceed) {
      softAssert.assertEquals(new YandexDiskService(driver).getUserName(), VALID_LOGIN,
          "User was not logged in");
    } else {
      softAssert.assertTrue(new YandexDiskAuthPage(driver).isErrorMessageDisplayed(),
          "Error message was not displayed");
    }
    softAssert.assertAll();
  }

  @AfterMethod(alwaysRun = true, description = "Google Chrome browser closes")
  public void browserTearDown() {
    driver.quit();
  }
}

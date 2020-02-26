package taf;

import static taf.constants.Constants.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import taf.page.YandexDiskAuthPage;
import taf.service.YandexDiskService;

public class WebDriverYandexDiskAuthTest {
  private WebDriver driver;

  @DataProvider(name = "Authentication is valid")
  public static Object[][] validCredentials() {
    return new Object[][]{{LOGIN, PASSWORD}};
  }

  @DataProvider(name = "Username is invalid")
  public static Object[][] invalidLogin() {
    return new Object[][]{{"test_1"}};
  }

  @DataProvider(name = "Incorrect password")
  public static Object[][] invalidPassword() {
    return new Object[][]{{LOGIN, "123"}};
  }

  @BeforeMethod(alwaysRun = true, description = "Google Chrome opens, goes to Yandex Disk Auth page")
  public void goToAuthPage() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    new YandexDiskService(driver)
        .navigateToYandexDisk();
  }

  @Test(dataProvider = "Username is invalid", description = "Verify that not log into account in Yandex Disk")
  public void verifyInvalidLoginIntoYandexDisk(String login) {
    new YandexDiskAuthPage(driver)
        .enterLogin(login);
    Assert.assertTrue(new YandexDiskAuthPage(driver).errorMessageIsDisplayed());
  }

  @Test(dataProvider = "Incorrect password", description = "Verify that not log into account in Yandex Disk")
  public void verifyInvalidPassword(String login, String password) {
    new YandexDiskAuthPage(driver)
        .logInYandexDisk(login, password);
    Assert.assertTrue(new YandexDiskAuthPage(driver).errorMessageIsDisplayed());
  }

  @Test(dataProvider = "Authentication is valid", description = "Verify that log into account in Yandex Disk")
  public void verifyValidLoginIntoYandexDisk(String login, String password) {
    new YandexDiskAuthPage(driver)
        .logInYandexDisk(login, password);
    Assert.assertEquals(new YandexDiskService(driver).getUserName(), LOGIN, "User was not logged in");
  }

  @AfterMethod(alwaysRun = true, description = "Google Chrome browser closes")
  public void browserTearDown() {
    driver.quit();
  }
}

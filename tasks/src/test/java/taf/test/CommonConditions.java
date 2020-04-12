package taf.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import taf.model.User;
import taf.service.UserCreator;
import taf.service.YandexDiskService;
import taf.driver.DriverSingleton;

public class CommonConditions {
  protected WebDriver driver;

  @BeforeClass(alwaysRun = true,
      description = "Google Chrome opens, goes to Yandex Disk Auth page and logged in with correct credentials")
  public void goToDiskMainPage() {
    driver = DriverSingleton.getDriver();
    User user = UserCreator.withValidCredentialsFromProperty();
    new YandexDiskService(driver)
        .navigateToYandexDisk();
    new YandexDiskService(driver)
        .logIntoAccount(user);
  }

  @AfterClass(alwaysRun = true, description = "Google Chrome browser closes")
  public void browserTearDown() {
    DriverSingleton.closeDriver();
  }

}

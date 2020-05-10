package taf.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import taf.model.User;
import taf.service.UserFactory;
import taf.service.YandexDiskService;
import taf.driver.DriverSingleton;

public class CommonConditions {
  protected WebDriver driver;

  @BeforeClass(alwaysRun = true,
      description = "Google Chrome opens, goes to Yandex Disk Auth page and logged in with correct credentials")
  public void goToDiskMainPage() {
    driver = DriverSingleton.getDriver();
    User user = UserFactory.withValidCredentialsFromProperty();
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

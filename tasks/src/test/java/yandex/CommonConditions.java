package yandex;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import taf.browser.BrowserFactory;
import taf.listener.SuiteListener;
import taf.listener.TestListener;
import taf.product.yandex.disk.model.User;
import taf.product.yandex.disk.service.UserFactory;
import taf.product.yandex.disk.service.YandexDiskService;
import taf.driver.DriverFactory;

@Listeners({TestListener.class, SuiteListener.class})
public class CommonConditions {
  protected WebDriver driver;

  @BeforeClass(alwaysRun = true,
      description = "Google Chrome opens, goes to Yandex Disk Auth page and logged in with correct credentials")
  public void goToDiskMainPage() {
    driver = BrowserFactory.createInstance();
    DriverFactory.setDriver(driver);
    driver = DriverFactory.getDriver();

    User user = UserFactory.withValidCredentialsFromProperty();
    new YandexDiskService(driver)
        .navigateToYandexDisk();
    new YandexDiskService(driver)
        .logIntoAccount(user);
  }

  @AfterClass(alwaysRun = true, description = "Google Chrome browser closes")
  public void browserTearDown() {
    DriverFactory.closeDriver();
  }

}

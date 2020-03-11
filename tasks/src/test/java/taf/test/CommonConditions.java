package taf.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import taf.service.YandexDiskService;

public class CommonConditions {
  protected WebDriver driver;

  @BeforeMethod(alwaysRun = true,
      description = "Google Chrome opens, goes to Yandex Disk Auth page and logged in with correct credentials")
  public void goToDiskMainPage() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    new YandexDiskService(driver)
        .navigateToYandexDisk();
    new YandexDiskService(driver)
        .logIntoAccount();
  }

  @AfterMethod(alwaysRun = true, description = "Google Chrome browser closes")
  public void browserTearDown() {
    driver.quit();
  }

}

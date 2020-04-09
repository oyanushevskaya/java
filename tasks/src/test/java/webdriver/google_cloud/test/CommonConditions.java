package webdriver.google_cloud.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import webdriver.google_cloud.driver.DriverSingleton;
import webdriver.google_cloud.model.ComputeEngine;
import webdriver.google_cloud.service.ComputeEngineFactory;
import webdriver.google_cloud.service.GoogleCloudService;
import webdriver.google_cloud.util.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {
  protected WebDriver driver;

  @BeforeMethod(alwaysRun = true,
      description = "Google Chrome opens, going to Google Cloud Home page and Calculator page, form is filling")
  public void goToCalculatorPage() {
    driver = DriverSingleton.getDriver();
    ComputeEngine computeEngine = ComputeEngineFactory.withCredentialsFromProperty();
    new GoogleCloudService(driver)
        .navigateToCalculatorPage();
    new GoogleCloudService(driver)
        .fillCalculatorFormForComputeEngine(computeEngine);
  }

  @AfterMethod(alwaysRun = true, description = "Google Chrome browser closes")
  public void browserTearDown() {
    DriverSingleton.closeDriver();
  }
}

package google;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import taf.browser.BrowserFactory;
import taf.driver.DriverFactory;
import taf.listener.SuiteListener;
import taf.product.google.cloud.model.ComputeEngine;
import taf.product.google.cloud.service.ComputeEngineFactory;
import taf.product.google.cloud.service.GoogleCloudService;
import taf.listener.TestListener;

@Listeners({TestListener.class, SuiteListener.class})
public class CommonConditions {
  protected WebDriver driver;

  @BeforeMethod(alwaysRun = true,
      description = "Google Chrome opens, going to Google Cloud Home page and Calculator page, form is filling")
  public void goToCalculatorPage() {
    driver = BrowserFactory.createInstance();
    DriverFactory.setDriver(driver);
    driver = DriverFactory.getDriver();

    ComputeEngine computeEngine = ComputeEngineFactory.withCredentialsFromProperty();
    new GoogleCloudService(driver)
        .navigateToCalculatorPage();
    new GoogleCloudService(driver)
        .fillCalculatorFormForComputeEngine(computeEngine);
  }

  @AfterMethod(alwaysRun = true, description = "Google Chrome browser closes")
  public void browserTearDown() {
    DriverFactory.closeDriver();
  }
}

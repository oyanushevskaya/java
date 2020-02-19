package webdriver.google_cloud;

import static webdriver.google_cloud.constants.Constants.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import webdriver.google_cloud.page.GoogleCloudCalculatorPage;
import webdriver.google_cloud.service.GoogleCloudService;

public class WebDriverGoogleCloudTest {
  private WebDriver driver;
  private GoogleCloudCalculatorPage calculatorPage;

  @BeforeMethod(alwaysRun = true,
      description = "Google Chrome opens, going to Google Cloud Home page and Calculator page, form is filling")
  public void goToCalculatorPage() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    new GoogleCloudService(driver)
        .navigateToCalculatorPage()
        .fillCalculatorForm();
  }

  @Test(description = "Verify that details for compute engine displaying correctly on Calculator page")
  public void verifyDropdownValues() {
    SoftAssert softAssert = new SoftAssert();
    calculatorPage = new GoogleCloudCalculatorPage(driver);
    softAssert.assertEquals(calculatorPage.getMachineClassText(), MACHINE_CLASS_REGULAR,
        ERROR_MACHINE_CLASS);
    softAssert.assertEquals(calculatorPage.getMachineTypeText(), MACHINE_TYPE_N1STANDART8,
        ERROR_MACHINE_TYPE);
    softAssert.assertEquals(calculatorPage.getRegionText(), REGION_FRANKFURT, ERROR_REGION);
    softAssert.assertEquals(calculatorPage.getLocalSSDText(), LOCAL_SSD_2x375GB, ERROR_LOCAL_SSD);
    softAssert.assertEquals(calculatorPage.getCommittedUsage(), USAGE_1YEAR, ERROR_USAGE);
    softAssert.assertAll();
  }

  @Test(description = "Google Cloud Platform Pricing Calculator count total estimated cost per 1 month for compute engine")
  public void verifyTotalCostForComputeEngine() {
    calculatorPage = new GoogleCloudCalculatorPage(driver);
    calculatorPage.clickAddToEstimate();
    Assert.assertEquals(calculatorPage.getTotalCostText(),TOTAL_ESTIMATED_COST, ERROR_TOTAL_COST);
  }

  @AfterMethod(alwaysRun = true, description = "Google Chrome browser closes")
  public void browserTearDown() {
    driver.quit();
  }
}

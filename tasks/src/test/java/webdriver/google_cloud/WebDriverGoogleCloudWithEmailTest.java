package webdriver.google_cloud;

import static webdriver.google_cloud.constants.Constants.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import webdriver.google_cloud.page.TenMinuteEmailHomePage;
import webdriver.google_cloud.page.GoogleCloudCalculatorPage;
import webdriver.google_cloud.page.GoogleCloudHomePage;
import webdriver.google_cloud.service.GoogleCloudService;

public class WebDriverGoogleCloudWithEmailTest {
  private WebDriver driver;

  @BeforeMethod(alwaysRun = true)
  public void browserSetup() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    new GoogleCloudHomePage(driver)
        .openPage();
    new GoogleCloudService(driver)
        .navigateToCalculatorPage()
        .fillCalculatorForm();
  }

  @Test(description = "Verify that details for compute engine displaying correctly on Calculator page")
  public void verifyDropdownValues() {
    GoogleCloudCalculatorPage calculatorPage = new GoogleCloudCalculatorPage(driver);
    SoftAssert softAssert = new SoftAssert();
    softAssert.assertTrue(calculatorPage.getMachineClassText().equals(MACHINE_CLASS_REGULAR),
        ERROR_MACHINE_CLASS);
    softAssert.assertTrue(calculatorPage.getMachineTypeText().contains(MACHINE_TYPE_N1STANDART8),
        ERROR_MACHINE_TYPE);
    softAssert.assertTrue(calculatorPage.getRegionText().equals(REGION_FRANKFURT),
        ERROR_REGION);
    softAssert.assertTrue(calculatorPage.getLocalSSDText().equals(LOCAL_SSD_2x375GB),
        ERROR_LOCAL_SSD);
    softAssert.assertTrue(calculatorPage.getCommittedUsage().equals(USAGE_1YEAR),
        ERROR_USAGE);
    softAssert.assertAll();
  }

  @Test(description = "Verify total cost that was sent on email")
  public void verifyTotalCostByEmail() {
    new GoogleCloudService(driver)
        .addEstimateAndSentOnEmail();

    Assert.assertTrue(new TenMinuteEmailHomePage(driver).getTotalCostFromEmailText().contains(TOTAL_ESTIMATED_COST),
        ERROR_TOTAL_COST);
  }

  @AfterMethod(alwaysRun = true)
  public void browserTearDown() {
    driver.quit();
  }

}

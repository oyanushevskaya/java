package webdriver.google_cloud.test;

import static webdriver.google_cloud.util.StringUtils.*;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import webdriver.google_cloud.page.GoogleCloudCalculatorPage;

public class WebDriverGoogleCloudValuesTest extends CommonConditions {

  @Test(description = "Verify that details for compute engine displaying correctly on Calculator page")
  public void verifyDropdownValues() {
    SoftAssert softAssert = new SoftAssert();
    GoogleCloudCalculatorPage calculatorPage = new GoogleCloudCalculatorPage(driver);
    softAssert.assertEquals(calculatorPage.getMachineClassText(), MACHINE_CLASS_REGULAR,
        ERROR_MACHINE_CLASS);
    softAssert.assertEquals(calculatorPage.getMachineTypeText(), MACHINE_TYPE_N1STANDART8,
        ERROR_MACHINE_TYPE);
    softAssert.assertEquals(calculatorPage.getRegionText(), REGION_FRANKFURT, ERROR_REGION);
    softAssert.assertEquals(calculatorPage.getLocalSSDText(), LOCAL_SSD_2x375GB, ERROR_LOCAL_SSD);
    softAssert.assertEquals(calculatorPage.getCommittedUsage(), USAGE_1YEAR, ERROR_USAGE);
    softAssert.assertAll();
  }
}

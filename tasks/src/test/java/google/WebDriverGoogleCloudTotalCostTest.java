package google;

import static taf.product.google.cloud.data.DataStorage.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import taf.product.google.cloud.page.GoogleCloudCalculatorPage;

public class WebDriverGoogleCloudTotalCostTest extends CommonConditions {

  @Test(description = "Google Cloud Platform Pricing Calculator count total estimated cost per 1 month for compute engine")
  public void verifyTotalCostForComputeEngine() {
    GoogleCloudCalculatorPage calculatorPage = new GoogleCloudCalculatorPage(driver);
    calculatorPage.clickAddToEstimate();
    Assert.assertEquals(calculatorPage.getTotalCostText(),TOTAL_ESTIMATED_COST, ERROR_TOTAL_COST);
  }
}

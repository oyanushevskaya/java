package google_cloud;

import static taf.product.google.cloud.util.StringUtils.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import taf.product.google.cloud.page.TenMinuteEmailHomePage;
import taf.product.google.cloud.service.GoogleCloudService;

public class WebDriverGoogleCloudSendEmailTest extends CommonConditions {

  @Test(description = "Verify total cost that was sent on email")
  public void verifyTotalCostByEmail() {
    new GoogleCloudService(driver)
        .addEstimateAndSendEmail();
    Assert.assertEquals(new TenMinuteEmailHomePage(driver).getTotalCostFromEmailText(),
        ESTIMATED_MONTHLY_COST,
        ERROR_TOTAL_COST);
  }
}

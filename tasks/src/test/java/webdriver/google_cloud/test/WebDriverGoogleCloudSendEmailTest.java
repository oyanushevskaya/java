package webdriver.google_cloud.test;

import static webdriver.google_cloud.util.StringUtils.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import webdriver.google_cloud.page.TenMinuteEmailHomePage;
import webdriver.google_cloud.service.GoogleCloudService;

public class WebDriverGoogleCloudSendEmailTest extends CommonConditions {

  @Test(description = "Verify total cost that was sent on email")
  public void verifyTotalCostByEmail() {
    new GoogleCloudService(driver)
        .addEstimateAndSentOnEmail();
    Assert.assertEquals(new TenMinuteEmailHomePage(driver).getTotalCostFromEmailText(),
        ESTIMATED_MONTHLY_COST,
        ERROR_TOTAL_COST);
  }
}

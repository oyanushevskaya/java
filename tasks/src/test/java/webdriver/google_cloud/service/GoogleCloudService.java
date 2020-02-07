package webdriver.google_cloud.service;

import static webdriver.google_cloud.constants.Constants.*;

import org.openqa.selenium.WebDriver;
import webdriver.google_cloud.page.EmailFormCalculatorPage;
import webdriver.google_cloud.page.GoogleCloudAbstractPage;
import webdriver.google_cloud.page.GoogleCloudCalculatorPage;
import webdriver.google_cloud.page.GoogleCloudHomePage;
import webdriver.google_cloud.page.TenMinuteEmailHomePage;

public class GoogleCloudService extends GoogleCloudAbstractPage {
  public GoogleCloudService(WebDriver driver) {
    super(driver);
  }

  public GoogleCloudService navigateToCalculatorPage() {
    new GoogleCloudHomePage(driver)
        .clickSearchButton()
        .typeSearchTerm(TERM_FOR_SEARCH)
        .findTerm(TERM_FOR_SEARCH);
    return this;
  }

  public void fillCalculatorForm() {
    new GoogleCloudCalculatorPage(driver)
        .clickComputeEngine()
        .typeNumberOfInstance(NUMBER_OF_INSTANCE)
        .chooseOperatingSystem()
        .chooseMachineClass()
        .chooseMachineType()
        .chooseAddGRUs()
        .chooseLocalSSD()
        .chooseDatacenterLocation()
        .chooseCommittedUsage();
  }

  public void addEstimateAndSentOnEmail() {
    new GoogleCloudCalculatorPage(driver)
        .clickAddToEstimate()
        .clickEmailEstimate();
    new TenMinuteEmailHomePage(driver)
        .copyAddress();
    new EmailFormCalculatorPage(driver)
        .getEmail()
        .clickSendEmail()
        .viewEmail();
  }
}

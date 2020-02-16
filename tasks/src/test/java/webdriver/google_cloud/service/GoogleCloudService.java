package webdriver.google_cloud.service;

import static webdriver.google_cloud.constants.Constants.*;

import java.util.ArrayList;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import webdriver.google_cloud.page.*;

public class GoogleCloudService extends GoogleCloudAbstractPage {
  private static ArrayList<String> tabs;

  public GoogleCloudService(WebDriver driver) {
    super(driver);
  }

  public void addNewTab() {
    ((JavascriptExecutor)driver).executeScript("window.open()");
  }

  public void switchToMailPageTab() {
    tabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1));
    driver.get("https://10minutemail.com");
  }

  public void switchToCalculatorPageTab() {
    driver.switchTo().window(tabs.get(0));
  }

  public GoogleCloudService navigateToCalculatorPage() {
    new GoogleCloudHomePage(driver)
        .openPage()
        .clickSearchButton()
        .typeSearchTerm(TERM_FOR_SEARCH)
        .findTerm(TERM_FOR_SEARCH);
    return this;
  }

  public void fillCalculatorForm() {
    new GoogleCloudCalculatorPage(driver)
        .clickComputeEngine()
        .typeNumberOfInstance(NUMBER_OF_INSTANCE)
        .chooseOperatingSystem("free")
        .chooseMachineClass("regular")
        .chooseMachineType("CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8")
        .chooseAddGRUs("1", "NVIDIA_TESLA_V100")
        .chooseLocalSSD("2")
        .chooseDatacenterLocation("europe-west3")
        .chooseCommittedUsage("1");
  }

  public void addEstimateAndSentOnEmail() {
    new GoogleCloudCalculatorPage(driver)
        .clickAddToEstimate()
        .clickEmailEstimate();
    addNewTab();
    switchToMailPageTab();
    new TenMinuteEmailHomePage(driver)
        .copyAddress();
    switchToCalculatorPageTab();
    new EmailFormCalculatorPage(driver)
        .getEmail()
        .clickSendEmail();
    switchToMailPageTab();
    new TenMinuteEmailHomePage(driver)
        .viewEmail();
  }
}

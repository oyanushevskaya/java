package webdriver.google_cloud.service;

import static webdriver.google_cloud.util.StringUtils.*;

import java.util.ArrayList;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import webdriver.google_cloud.model.ComputeEngine;
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
  }

  public void switchToCalculatorPageTab() {
    driver.switchTo().window(tabs.get(0));
  }

  public void navigateToCalculatorPage() {
    new GoogleCloudHomePage(driver)
        .openPage()
        .clickSearchButton()
        .typeSearchTerm(TERM_FOR_SEARCH)
        .findTerm(TERM_FOR_SEARCH);
  }

  public void fillCalculatorFormForComputeEngine(ComputeEngine computeEngine) {
    new GoogleCloudCalculatorPage(driver)
        .switchToFrame()
        .clickComputeEngine()
        .typeNumberOfInstance(computeEngine.getNumberOfInstances())
        .chooseOperatingSystem(computeEngine.getOperatingSystem())
        .chooseMachineClass(computeEngine.getMachineClass())
        .chooseMachineType(computeEngine.getMachineType())
        .clickAddGRUs()
        .chooseNumbersOfGRUs(computeEngine.getNumberOfGPUs())
        .chooseGRUType(computeEngine.getGPUType())
        .chooseLocalSSD(computeEngine.getLocalSSD())
        .chooseDatacenterLocation(computeEngine.getDatacenterLocation())
        .chooseCommittedUsage(computeEngine.getCommittedUsage());
  }

  public void addEstimateAndSentOnEmail() {
    new GoogleCloudCalculatorPage(driver)
        .clickAddToEstimate()
        .clickEmailEstimate();
    addNewTab();
    switchToMailPageTab();
    new TenMinuteEmailHomePage(driver)
        .openPage()
        .clickOnMail()
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

package webdriver.google_cloud.service;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import webdriver.google_cloud.model.ComputeEngine;
import webdriver.google_cloud.page.*;

public class GoogleCloudService extends GoogleCloudAbstractPage {
  private final Logger logger = LogManager.getRootLogger();
  private static ArrayList<String> tabs;

  public GoogleCloudService(WebDriver driver) {
    super(driver);
  }

  public void addNewTab() {
    logger.info("Open new tab");
    ((JavascriptExecutor)driver).executeScript("window.open()");
  }

  public void switchToMailPageTab() {
    logger.info("Switch to mail page");
    tabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1));
  }

  public void switchToCalculatorPageTab() {
    logger.info("Switch to calculator page");
    driver.switchTo().window(tabs.get(0));
  }

  public void navigateToCalculatorPage() {
    logger.info("Navigate to calculator page");
    new GoogleCloudHomePage(driver)
        .openPage()
        .clickSearchButton()
        .typeSearchTerm()
        .findTerm();
  }

  public void fillCalculatorFormForComputeEngine(ComputeEngine computeEngine) {
    logger.info("Fill the calculator form for compute engine");
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

  public void addEstimateAndSendEmail() {
    logger.info("Add to estimate and send email estimate");
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

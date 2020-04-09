package webdriver.google_cloud.page;

import static org.openqa.selenium.Keys.ARROW_DOWN;
import static org.openqa.selenium.Keys.ENTER;
import static webdriver.google_cloud.browser.Browser.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudCalculatorPage extends GoogleCloudAbstractPage {
  private final Logger logger = LogManager.getRootLogger();

  @FindBy(xpath = "//div[@title='Compute Engine']/..")
  private WebElement computeEngineButton;
  @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
  private WebElement numberOfInstanceInput;
  @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.os']")
  private WebElement searchOperatingSystemDropdown;
  @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.class']")
  private WebElement machineClassDropdown;
  @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.instance']")
  private WebElement machineTypeDropdown;
  @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
  private WebElement addGRUsCheckbox;
  @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuCount']")
  private WebElement numbersOfGRUsDropdown;
  @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuType']")
  private WebElement GRUTypeDropdown;
  @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.ssd']")
  private WebElement localSSDDropdown;
  @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.location']")
  private WebElement datacenterLocationDropdown;
  @FindBy(xpath = "//md-select[@ng-disabled='listingCtrl.isCudDisabled']")
  private WebElement committedUsageDropdown;
  @FindBy(xpath = "//button[contains(text(), 'Add to Estimate')]")
  private WebElement addToEstimateButton;
  @FindBy(xpath = "//*[@class='md-title']/b")
  public WebElement totalCostLabel;
  @FindBy(id = "email_quote")
  private WebElement emailEstimateButton;

  private static final String PATTERN_CHOOSE_VALUE = "[@value='%s']";
  private static final String NUMBERS_OF_GRU_CONTAINER =
      "//md-option[@ng-repeat='item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]']";
  private static final String LOCAL_SSD_CONTAINER =
      "//md-option[@ng-repeat='item in listingCtrl.supportedSsd']";
  private static final String LOCATION_CONTAINER =
      "//*[@id='select_container_84']//*";
  private static final String USAGE_CONTAINER =
      "//*[@id='select_container_91']//*";


  public GoogleCloudCalculatorPage(WebDriver driver) {
    super(driver);
  }

  public String getMachineClassText() {
    return waitForVisibility(machineClassDropdown).getText();
  }

  public String getMachineTypeText() {
    return machineTypeDropdown.getText();
  }

  public String getRegionText() {
    return datacenterLocationDropdown.getText();
  }

  public String getLocalSSDText() {
    return localSSDDropdown.getText();
  }

  public String getCommittedUsage() {
    return committedUsageDropdown.getText();
  }

  public String getTotalCostText() {
    return totalCostLabel.getText();
  }

  public WebElement chooseOption(String value) {
    return driver.findElement(By.xpath(String.format("//*" + PATTERN_CHOOSE_VALUE, value)));
  }

  public WebElement chooseOption(String container, String value) {
    return driver.findElement(By.xpath(String.format(container + PATTERN_CHOOSE_VALUE, value)));
  }

  public GoogleCloudCalculatorPage switchToFrame() {
    logger.info("Switch to frame");
    driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
    waitFrameToBeAvailable("myFrame");
    return this;
  }

  public GoogleCloudCalculatorPage clickComputeEngine() {
    logger.info("Select Compute Engine");
    waitForVisibility(computeEngineButton).click();
    return this;
  }

  public GoogleCloudCalculatorPage typeNumberOfInstance(String number) {
    logger.info("Number of instance - " + number);
    waitForVisibility(numberOfInstanceInput).click();
    numberOfInstanceInput.sendKeys(number);
    return this;
  }

  public GoogleCloudCalculatorPage chooseOperatingSystem(String value) {
    logger.info("Operating system - " + value);
    searchOperatingSystemDropdown.sendKeys(ARROW_DOWN);
    chooseOption(value).click();
    return this;
  }

  public GoogleCloudCalculatorPage chooseMachineClass(String value) {
    logger.info("Machine class - " + value);
    machineClassDropdown.sendKeys(ARROW_DOWN);
    waitForVisibility(chooseOption(value)).click();
    return this;
  }

  public GoogleCloudCalculatorPage chooseMachineType(String value) {
    logger.info("Machine type - " + value);
    machineTypeDropdown.sendKeys(ARROW_DOWN);
    waitForVisibility(chooseOption(value)).sendKeys(ENTER);
    return this;
  }

  public GoogleCloudCalculatorPage clickAddGRUs() {
    logger.info("Click 'Add GRUs' button");
    waitForVisibility(addGRUsCheckbox).sendKeys(ENTER);
    return this;
  }

  public GoogleCloudCalculatorPage chooseNumbersOfGRUs(String number) {
    logger.info("Number of GRUs - " + number);
    numbersOfGRUsDropdown.sendKeys(ARROW_DOWN);
    waitForVisibility(chooseOption(NUMBERS_OF_GRU_CONTAINER, number)).sendKeys(ENTER);
    return this;
  }

  public GoogleCloudCalculatorPage chooseGRUType(String value) {
    logger.info("GRU type - " + value);
    GRUTypeDropdown.sendKeys(ARROW_DOWN);
    waitForVisibility(chooseOption(value)).sendKeys(ENTER);
    return this;
  }

  public GoogleCloudCalculatorPage chooseLocalSSD(String value) {
    logger.info("Local SSD - " + value);
    localSSDDropdown.sendKeys(ARROW_DOWN);
    waitForVisibility(chooseOption(LOCAL_SSD_CONTAINER, value)).sendKeys(ENTER);
    return this;
  }

  public GoogleCloudCalculatorPage chooseDatacenterLocation(String value) {
    logger.info("Datacenter location - " + value);
    datacenterLocationDropdown.sendKeys(ARROW_DOWN);
    waitForVisibility(chooseOption(LOCATION_CONTAINER, value)).sendKeys(ENTER);
    return this;
  }

  public void chooseCommittedUsage(String value) {
    logger.info("Committed usage - " + value);
    committedUsageDropdown.sendKeys(ARROW_DOWN);
    waitForVisibility(chooseOption(USAGE_CONTAINER, value)).sendKeys(ENTER);
  }

  public GoogleCloudCalculatorPage clickAddToEstimate() {
    logger.info("Click 'Add to estimate' button");
    addToEstimateButton.sendKeys(ENTER);
    return this;
  }

  public void clickEmailEstimate() {
    logger.info("Click 'Email estimate' button");
    emailEstimateButton.sendKeys(ENTER);
  }
}

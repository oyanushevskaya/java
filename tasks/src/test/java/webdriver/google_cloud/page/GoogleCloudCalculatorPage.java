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
  @FindBy(id = "input_55")
  private WebElement numberOfInstanceInput;
  @FindBy(id = "select_67")
  private WebElement searchOperatingSystemDropdown;
  @FindBy(id = "select_71")
  private WebElement machineClassDropdown;
  @FindBy(id = "select_80")
  private WebElement machineTypeDropdown;
  @FindBy(xpath = "//md-checkbox")
  private WebElement addGRUsCheckbox;
  @FindBy(id = "select_328")
  private WebElement numbersOfGRUsDropdown;
  @FindBy(id = "select_330")
  private WebElement GRUTypeDropdown;
  @FindBy(id = "select_167")
  private WebElement localSSDDropdown;
  @FindBy(id = "select_82")
  private WebElement datacenterLocationDropdown;
  @FindBy(id = "select_89")
  private WebElement committedUsageDropdown;
  @FindBy(xpath = "//button[contains(text(), 'Add to Estimate')]")
  private WebElement addToEstimateButton;
  @FindBy(xpath = "//*[@class='md-title']/b")
  public WebElement totalCostLabel;
  @FindBy(id = "email_quote")
  private WebElement emailEstimateButton;

  private static final String PATTERN_CHOOSE_VALUE = "//*[@value='%s']";
  private static final String NUMBERS_OF_GRU_CONTAINER = "//*[@id='select_container_329']";
  private static final String LOCAL_SSD_CONTAINER = "//*[@id='select_container_168']";
  private static final String LOCATION_CONTAINER = "//*[@id='select_container_83']";
  private static final String USAGE_CONTAINER = "//*[@id='select_container_90']";

  public GoogleCloudCalculatorPage(WebDriver driver) {
    super(driver);
  }

  public String getMachineClassText() {
    return waitForVisibility(driver,machineClassDropdown).getText();
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
    return driver.findElement(By.xpath(String.format(PATTERN_CHOOSE_VALUE, value)));
  }

  public WebElement chooseOption(String container, String value) {
    return driver.findElement(By.xpath(String.format(container + PATTERN_CHOOSE_VALUE, value)));
  }

  public GoogleCloudCalculatorPage switchToFrame() {
    driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
    waitFrameToBeAvailable(driver, "myFrame");
    logger.info("Switched to frame");
    return this;
  }

  public GoogleCloudCalculatorPage clickComputeEngine() {
    waitForVisibility(driver, computeEngineButton).click();
    logger.info("Compute Engine was chosen");
    return this;
  }

  public GoogleCloudCalculatorPage typeNumberOfInstance(String number) {
    waitForVisibility(driver, numberOfInstanceInput).click();
    numberOfInstanceInput.sendKeys(number);
    logger.info("Number of instance - " + number);
    return this;
  }

  public GoogleCloudCalculatorPage chooseOperatingSystem(String value) {
    searchOperatingSystemDropdown.sendKeys(ARROW_DOWN);
    chooseOption(value).click();
    logger.info("Operating system - " + value);
    return this;
  }

  public GoogleCloudCalculatorPage chooseMachineClass(String value) {
    machineClassDropdown.sendKeys(ARROW_DOWN);
    waitForVisibility(driver,chooseOption(value)).click();
    logger.info("Machine class - " + value);
    return this;
  }

  public GoogleCloudCalculatorPage chooseMachineType(String value) {
    machineTypeDropdown.sendKeys(ARROW_DOWN);
    waitForVisibility(driver, chooseOption(value)).sendKeys(ENTER);
    logger.info("Machine type - " + value);
    return this;
  }

  public GoogleCloudCalculatorPage clickAddGRUs() {
    waitForVisibility(driver, addGRUsCheckbox).sendKeys(ENTER);
    logger.info("Button 'Add GRUs' was clicked");
    return this;
  }

  public GoogleCloudCalculatorPage chooseNumbersOfGRUs(String number) {
    numbersOfGRUsDropdown.sendKeys(ARROW_DOWN);
    waitForVisibility(driver, chooseOption(NUMBERS_OF_GRU_CONTAINER, number)).sendKeys(ENTER);
    logger.info("Number of GRUs - " + number);
    return this;
  }

  public GoogleCloudCalculatorPage chooseGRUType(String value) {
    GRUTypeDropdown.sendKeys(ARROW_DOWN);
    waitForVisibility(driver, chooseOption(value)).sendKeys(ENTER);
    logger.info("GRU type - " + value);
    return this;
  }

  public GoogleCloudCalculatorPage chooseLocalSSD(String value) {
    localSSDDropdown.sendKeys(ARROW_DOWN);
    waitForVisibility(driver, chooseOption(LOCAL_SSD_CONTAINER, value)).sendKeys(ENTER);
    logger.info("Local SSD - " + value);
    return this;
  }

  public GoogleCloudCalculatorPage chooseDatacenterLocation(String value) {
    datacenterLocationDropdown.sendKeys(ARROW_DOWN);
    waitForVisibility(driver, chooseOption(LOCATION_CONTAINER, value)).sendKeys(ENTER);
    logger.info("Datacenter location - " + value);
    return this;
  }

  public void chooseCommittedUsage(String value) {
    committedUsageDropdown.sendKeys(ARROW_DOWN);
    waitForVisibility(driver, chooseOption(USAGE_CONTAINER, value)).sendKeys(ENTER);
    logger.info("Committed usage - " + value);
  }

  public GoogleCloudCalculatorPage clickAddToEstimate() {
    addToEstimateButton.sendKeys(ENTER);
    logger.info("Button 'Add to estimate' was clicked");
    return this;
  }

  public void clickEmailEstimate() {
    emailEstimateButton.sendKeys(ENTER);
    logger.info("Button 'Email estimate' was clicked");
  }
}

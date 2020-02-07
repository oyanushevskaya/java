package webdriver.google_cloud.page;

import static org.openqa.selenium.Keys.ARROW_DOWN;
import static org.openqa.selenium.Keys.ENTER;
import static webdriver.google_cloud.browser.Browser.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudCalculatorPage extends GoogleCloudAbstractPage {

  @FindBy(xpath = "//div[@title='Compute Engine']/..")
  private WebElement computeEngineButton;
  @FindBy(id = "input_53")
  private WebElement numberOfInstanceInput;
  @FindBy(id = "select_65")
  private WebElement searchOperatingSystemDropdown;
  @FindBy(id = "select_option_55")
  private WebElement freeDebianOption;
  @FindBy(id = "select_69")
  private WebElement machineClassDropdown;
  @FindBy(id = "select_option_67")
  private WebElement regularOption;
  @FindBy(id = "select_78")
  private WebElement machineTypeDropdown;
  @FindBy(id = "select_option_212")
  private WebElement n1Standart8Option;
  @FindBy(xpath = "//md-checkbox")
  private WebElement addGRUsCheckbox;
  @FindBy(id = "select_355")
  private WebElement numbersOfGRUsDropdown;
  @FindBy(id = "select_option_360")
  private WebElement numberOneOption;
  @FindBy(id = "select_357")
  private WebElement GRUTypeDropdown;
  @FindBy(id = "select_option_367")
  private WebElement NVIDIATeslaV100Option;
  @FindBy(id = "select_172")
  private WebElement localSSDDropdown;
  @FindBy(id = "select_option_233")
  private WebElement localSSDOption_2;
  @FindBy(id = "select_80")
  private WebElement datacenterLocationDropdown;
  @FindBy(id = "select_option_181")
  private WebElement frankfurtOption;
  @FindBy(id = "select_87")
  private WebElement committedUsageDropdown;
  @FindBy(id = "select_option_85")
  private WebElement oneYearOption;
  @FindBy(xpath = "//button[contains(text(), 'Add to Estimate')]")
  private WebElement addToEstimateButton;
  @FindBy(xpath = "//*[@class='md-title']/b")
  public WebElement totalCost;
  @FindBy(id = "email_quote")
  private WebElement emailEstimateButton;

  public GoogleCloudCalculatorPage(WebDriver driver) {
    super(driver);
  }

  public String getMachineClassText() {
    return machineClassDropdown.getText();
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
    return totalCost.getText();
  }

  public GoogleCloudCalculatorPage clickComputeEngine() {
    driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
    waitForVisibleFrame(driver);
    waitForVisibleElement(driver, computeEngineButton);
    computeEngineButton.click();
    return this;
  }

  public GoogleCloudCalculatorPage typeNumberOfInstance(String number) {
    numberOfInstanceInput.click();
    numberOfInstanceInput.sendKeys(number);
    return this;
  }

  public GoogleCloudCalculatorPage chooseOperatingSystem() {
    searchOperatingSystemDropdown.sendKeys(ARROW_DOWN);
    freeDebianOption.click();
    return this;
  }

  public GoogleCloudCalculatorPage chooseMachineClass() {
    machineClassDropdown.sendKeys(ARROW_DOWN);
    waitForVisibleElement(driver, regularOption);
    regularOption.click();
    return this;
  }

  public GoogleCloudCalculatorPage chooseMachineType() {
    machineTypeDropdown.sendKeys(ARROW_DOWN);
    waitForVisibleElement(driver, n1Standart8Option);
    n1Standart8Option.sendKeys(ENTER);
    return this;
  }

  public GoogleCloudCalculatorPage chooseAddGRUs() {
    addGRUsCheckbox.sendKeys(ENTER);

    numbersOfGRUsDropdown.sendKeys(ARROW_DOWN);
    waitForVisibleElement(driver, numberOneOption);
    numberOneOption.sendKeys(ENTER);

    GRUTypeDropdown.sendKeys(ARROW_DOWN);
    waitForVisibleElement(driver, NVIDIATeslaV100Option);
    NVIDIATeslaV100Option.sendKeys(ENTER);
    return this;
  }

  public GoogleCloudCalculatorPage chooseLocalSSD() {
    localSSDDropdown.sendKeys(ARROW_DOWN);
    waitForVisibleElement(driver, localSSDOption_2);
    localSSDOption_2.sendKeys(ENTER);
    return this;
  }

  public GoogleCloudCalculatorPage chooseDatacenterLocation() {
    datacenterLocationDropdown.sendKeys(ARROW_DOWN);
    waitForVisibleElement(driver, frankfurtOption);
    frankfurtOption.sendKeys(ENTER);
    return this;
  }

  public void chooseCommittedUsage() {
    committedUsageDropdown.sendKeys(ARROW_DOWN);
    waitForVisibleElement(driver, oneYearOption);
    oneYearOption.sendKeys(ENTER);
  }

  public GoogleCloudCalculatorPage clickAddToEstimate() {
    addToEstimateButton.sendKeys(ENTER);
    return this;
  }

  public void clickEmailEstimate() {
    emailEstimateButton.sendKeys(ENTER);
    new TenMinuteEmailHomePage(driver);
  }
}

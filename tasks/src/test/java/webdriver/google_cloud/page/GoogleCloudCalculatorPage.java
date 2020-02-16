package webdriver.google_cloud.page;

import static org.openqa.selenium.Keys.ARROW_DOWN;
import static org.openqa.selenium.Keys.ENTER;
import static webdriver.google_cloud.browser.Browser.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudCalculatorPage extends GoogleCloudAbstractPage {
  private WebElement webElement;

  @FindBy(xpath = "//div[@title='Compute Engine']/..")
  private WebElement computeEngineButton;
  @FindBy(id = "input_53")
  private WebElement numberOfInstanceInput;
  @FindBy(id = "select_65")
  private WebElement searchOperatingSystemDropdown;
  @FindBy(id = "select_69")
  private WebElement machineClassDropdown;
  @FindBy(id = "select_78")
  private WebElement machineTypeDropdown;
  @FindBy(xpath = "//md-checkbox")
  private WebElement addGRUsCheckbox;
  @FindBy(id = "select_355")
  private WebElement numbersOfGRUsDropdown;
  @FindBy(id = "select_357")
  private WebElement GRUTypeDropdown;
  @FindBy(id = "select_172")
  private WebElement localSSDDropdown;
  @FindBy(id = "select_80")
  private WebElement datacenterLocationDropdown;
  @FindBy(id = "select_87")
  private WebElement committedUsageDropdown;
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
    waitForVisibleElement(driver,machineClassDropdown);
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

  public WebElement chooseOption(String value) {
    return driver.findElement(By.xpath("//*[@value='"+value+"']"));
  }

  public GoogleCloudCalculatorPage clickComputeEngine() {
    driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
    waitForVisibleFrame(driver, "myFrame");
    waitForVisibleElement(driver, computeEngineButton);
    computeEngineButton.click();
    return this;
  }

  public GoogleCloudCalculatorPage typeNumberOfInstance(String number) {
    numberOfInstanceInput.click();
    numberOfInstanceInput.sendKeys(number);
    return this;
  }

  public GoogleCloudCalculatorPage chooseOperatingSystem(String value) {
    searchOperatingSystemDropdown.sendKeys(ARROW_DOWN);
    chooseOption(value).click();
    return this;
  }

  public GoogleCloudCalculatorPage chooseMachineClass(String value) {
    machineClassDropdown.sendKeys(ARROW_DOWN);
    webElement = chooseOption(value);
    waitForVisibleElement(driver, webElement);
    webElement.sendKeys(ENTER);
    return this;
  }

  public GoogleCloudCalculatorPage chooseMachineType(String value) {
    machineTypeDropdown.sendKeys(ARROW_DOWN);
    webElement = chooseOption(value);
    waitForVisibleElement(driver, webElement);
    webElement.sendKeys(ENTER);
    return this;
  }

  public GoogleCloudCalculatorPage chooseAddGRUs(String numberValue, String typeValue) {
    addGRUsCheckbox.sendKeys(ENTER);

    numbersOfGRUsDropdown.sendKeys(ARROW_DOWN);
    webElement = driver.findElement(By.xpath("//*[@id='select_container_356']//*[@value='"+numberValue+"']"));
    waitForVisibleElement(driver, webElement);
    webElement.sendKeys(ENTER);

    GRUTypeDropdown.sendKeys(ARROW_DOWN);
    webElement = chooseOption(typeValue);
    waitForVisibleElement(driver, webElement);
    webElement.sendKeys(ENTER);
    return this;
  }

  public GoogleCloudCalculatorPage chooseLocalSSD(String value) {
    localSSDDropdown.sendKeys(ARROW_DOWN);
    webElement = driver.findElement(By.xpath("//*[@id='select_container_173']//*[@value='"+value+"']"));
    waitForVisibleElement(driver, webElement);
    webElement.sendKeys(ENTER);
    return this;
  }

  public GoogleCloudCalculatorPage chooseDatacenterLocation(String value) {
    datacenterLocationDropdown.sendKeys(ARROW_DOWN);
    webElement = driver.findElement(By.xpath("//*[@id='select_container_81']//*[@value='"+value+"']"));
    waitForVisibleElement(driver, webElement);
    webElement.sendKeys(ENTER);
    return this;
  }

  public void chooseCommittedUsage(String value) {
    committedUsageDropdown.sendKeys(ARROW_DOWN);
    webElement = driver.findElement(By.xpath("//*[@id='select_container_88']//*[@value='"+value+"']"));
    waitForVisibleElement(driver, webElement);
    webElement.sendKeys(ENTER);
  }

  public GoogleCloudCalculatorPage clickAddToEstimate() {
    addToEstimateButton.sendKeys(ENTER);
    return this;
  }

  public void clickEmailEstimate() {
    emailEstimateButton.sendKeys(ENTER);
  }
}

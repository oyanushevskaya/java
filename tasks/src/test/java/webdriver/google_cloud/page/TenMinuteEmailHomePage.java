package webdriver.google_cloud.page;

import static webdriver.google_cloud.browser.Browser.waitForVisibleElement;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TenMinuteEmailHomePage extends GoogleCloudAbstractPage {
  @FindBy(id = "mailAddress")
  private WebElement mailInput;
  @FindBy(xpath = "//*[@role='tab']")
  private WebElement messagesList;
  @FindBy(xpath = "//*[@id='mobilepadding']//h2")
  private WebElement totalCostFromEmail;

  private ArrayList<String> tabs;

  public TenMinuteEmailHomePage(WebDriver driver) {
    super(driver);
  }

  public String getTotalCostFromEmailText() {
    return totalCostFromEmail.getText();
  }

  public void addNewTab() {
    ((JavascriptExecutor)driver).executeScript("window.open()");
  }

  public void switchToTenMinutePageTab() {
    tabs = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1));
    driver.get("https://10minutemail.com");
  }

  public void switchToCalculatorPageTab() {
    driver.switchTo().window(tabs.get(0));
  }

  public void copyAddress() {
    addNewTab();
    switchToTenMinutePageTab();
    waitForVisibleElement(driver, mailInput);
    mailInput.sendKeys(Keys.chord(Keys.CONTROL, "c"));
    switchToCalculatorPageTab();
    new EmailFormCalculatorPage(driver);
  }

  public void viewEmail() {
    switchToTenMinutePageTab();
    new WebDriverWait(driver, 100)
        .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@role='tab']")));
    messagesList.click();
  }
}

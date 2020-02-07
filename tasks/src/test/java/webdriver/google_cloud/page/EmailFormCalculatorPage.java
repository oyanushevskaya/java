package webdriver.google_cloud.page;

import static webdriver.google_cloud.browser.Browser.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFormCalculatorPage extends GoogleCloudAbstractPage {
  @FindBy(xpath = "//input[@type='email']")
  private WebElement emailInput;
  @FindBy(xpath = "//button[contains(text(),'Send Email')]")
  private WebElement sendEmailButton;

  public EmailFormCalculatorPage(WebDriver driver) {
    super(driver);
  }

  public EmailFormCalculatorPage getEmail() {
    driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
    waitForVisibleFrame(driver);
    emailInput.click();
    waitForVisibleElement(driver, emailInput);
    emailInput.sendKeys(Keys.chord(Keys.CONTROL,"v"));
    return this;
  }

  public TenMinuteEmailHomePage clickSendEmail() {
    sendEmailButton.sendKeys(Keys.ENTER);
    return new TenMinuteEmailHomePage(driver);
  }
}

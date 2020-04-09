package webdriver.google_cloud.page;

import static webdriver.google_cloud.browser.Browser.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFormCalculatorPage extends GoogleCloudAbstractPage {
  private final Logger logger = LogManager.getRootLogger();

  @FindBy(xpath = "//input[@type='email']")
  private WebElement emailInput;
  @FindBy(xpath = "//button[contains(text(),'Send Email')]")
  private WebElement sendEmailButton;
  @FindBy(xpath = "//form[@name='emailForm']")
  private WebElement emailForm;

  public EmailFormCalculatorPage(WebDriver driver) {
    super(driver);
  }

  public EmailFormCalculatorPage getEmail() {
    logger.info("Paste generated mail in email form");
    driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
    waitFrameToBeAvailable("myFrame");

    waitElementToBeClickable(emailForm).click();
    waitForVisibility(emailInput).sendKeys(Keys.chord(Keys.CONTROL,"v"));
    return this;
  }

  public void clickSendEmail() {
    logger.info("Click 'Send email' button");
    waitForVisibility(sendEmailButton).sendKeys(Keys.ENTER);
  }
}

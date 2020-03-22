package webdriver.google_cloud.page;

import static webdriver.google_cloud.browser.Browser.waitElementToBeClickable;
import static webdriver.google_cloud.browser.Browser.waitForVisibility;
import static webdriver.google_cloud.util.StringUtils.EMAIL_PAGE_URL;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TenMinuteEmailHomePage extends GoogleCloudAbstractPage {
  private final Logger logger = LogManager.getRootLogger();

  @FindBy(css = "button.click-to-copy")
  private WebElement mailButton;
  @FindBy(id = "mail")
  private WebElement mailInput;
  @FindBy(css = "input.emailbox-input")
  private WebElement mailBox;

  @FindBy(xpath = "//li[not(@class='hide ')]//*[@class='arrow-link-ico']")
  private WebElement messageLink;
  @FindBy(xpath = "//*[@id='mobilepadding']//h2")
  private WebElement totalCostFromEmailLabel;

  public TenMinuteEmailHomePage(WebDriver driver) {
    super(driver);
  }

  public TenMinuteEmailHomePage openPage() {
    driver.get(EMAIL_PAGE_URL);
    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    logger.info("Page " + EMAIL_PAGE_URL + " was opened");
    return this;
  }

  public TenMinuteEmailHomePage clickOnMail() {
    waitElementToBeClickable(driver, mailInput).click();
    return this;
  }

  public void copyAddress() {
    waitForVisibility(driver, mailInput).sendKeys(Keys.chord(Keys.CONTROL, "a"));
    waitForVisibility(driver, mailInput).sendKeys(Keys.chord(Keys.CONTROL, "c"));
    logger.info("Generated mail was copied");
  }

  public void viewEmail() {
    waitForVisibility(driver, messageLink);
    waitElementToBeClickable(driver, messageLink).click();
    logger.info("Email was arrived on generated mail");
  }

  public String getTotalCostFromEmailText() {
    return waitForVisibility(driver, totalCostFromEmailLabel).getText();
  }
}

package taf.product.google.cloud.page;

import static taf.browser.Browser.*;
import static taf.product.google.cloud.util.StringUtils.EMAIL_PAGE_URL;

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
    logger.info("Open " + EMAIL_PAGE_URL + " page");
    driver.get(EMAIL_PAGE_URL);
    return this;
  }

  public TenMinuteEmailHomePage clickOnMail() {
    logger.info("Click on the mail");
    waitElementToBeClickable(mailInput).click();
    return this;
  }

  public void copyAddress() {
    logger.info("Copy generated mail");
    waitForVisibility(mailInput).sendKeys(Keys.chord(Keys.CONTROL, "a"));
    mailInput.sendKeys(Keys.chord(Keys.CONTROL, "c"));
  }

  public void viewEmail() {
    logger.info("Arrive email on generated mail");
    waitElementToBeClickable(messageLink).click();
  }

  public String getTotalCostFromEmailText() {
    return waitForVisibility(totalCostFromEmailLabel).getText();
  }
}

package webdriver.google_cloud.page;

import static webdriver.google_cloud.browser.Browser.waitForVisibleElement;

import org.openqa.selenium.By;
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

  public TenMinuteEmailHomePage(WebDriver driver) {
    super(driver);
  }

  public String getTotalCostFromEmailText() {
    waitForVisibleElement(driver, totalCostFromEmail);
    return totalCostFromEmail.getText();
  }

  public void copyAddress() {
    waitForVisibleElement(driver, mailInput);
    mailInput.sendKeys(Keys.chord(Keys.CONTROL, "c"));
  }

  public void viewEmail() {
    new WebDriverWait(driver, 100)
        .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@role='tab']")));
    messagesList.click();
  }
}

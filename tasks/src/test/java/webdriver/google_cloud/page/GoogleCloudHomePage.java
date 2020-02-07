package webdriver.google_cloud.page;

import static webdriver.google_cloud.browser.Browser.*;
import static webdriver.google_cloud.constants.Constants.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudHomePage extends GoogleCloudAbstractPage {
  @FindBy(name = "q")
  private WebElement searchInput;

  public GoogleCloudHomePage(WebDriver driver) {
    super(driver);
  }

  public void openPage() {
    driver.get(HOMEPAGE_URL);
  }

  public GoogleCloudHomePage clickSearchButton() {
    waitForVisibleElement(driver, searchInput);
    searchInput.click();
    return this;
  }

  public GoogleCloudHomePage typeSearchTerm(String term) {
    waitForVisibleElement(driver, searchInput);
    searchInput.sendKeys(term + Keys.ENTER);
    return this;
  }

  public void findTerm(String term) {
    new WebDriverWait(driver,10)
        .until(driver -> driver.findElement(By.xpath("//b[contains(text(), '" + term + "')]")))
        .click();
    new GoogleCloudCalculatorPage(driver);
  }
}

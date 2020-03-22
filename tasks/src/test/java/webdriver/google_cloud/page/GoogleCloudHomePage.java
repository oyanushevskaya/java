package webdriver.google_cloud.page;

import static webdriver.google_cloud.browser.Browser.*;
import static webdriver.google_cloud.util.StringUtils.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudHomePage extends GoogleCloudAbstractPage {
  private final Logger logger = LogManager.getRootLogger();
  private static final String PATTERN_FIND_TERM = "//b[contains(text(), '%s')]";
  private static final int TIME_OUT_IN_SECONDS = 30;

  @FindBy(name = "q")
  private WebElement searchInput;

  public GoogleCloudHomePage(WebDriver driver) {
    super(driver);
  }

  public GoogleCloudHomePage openPage() {
    driver.get(HOMEPAGE_URL);
    logger.info("Page " + HOMEPAGE_URL + " was opened");
    return this;
  }

  public GoogleCloudHomePage clickSearchButton() {
    waitElementToBeClickable(driver, searchInput).click();
    return this;
  }

  public GoogleCloudHomePage typeSearchTerm(String term) {
    waitForVisibility(driver, searchInput).sendKeys(term + Keys.ENTER);
    return this;
  }

  public void findTerm(String term) {
    new WebDriverWait(driver,TIME_OUT_IN_SECONDS)
        .until(driver -> driver.findElement(By.xpath(String.format(PATTERN_FIND_TERM, term))))
        .click();
    logger.info(term + " was found in search line");
  }
}

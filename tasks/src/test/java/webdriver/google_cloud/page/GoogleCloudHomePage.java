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

  @FindBy(name = "q")
  private WebElement searchInput;

  public GoogleCloudHomePage(WebDriver driver) {
    super(driver);
  }

  public GoogleCloudHomePage openPage() {
    logger.info("Open " + HOMEPAGE_URL + " page");
    driver.get(HOMEPAGE_URL);
    return this;
  }

  public GoogleCloudHomePage clickSearchButton() {
    logger.info("Click on the search button");
    waitElementToBeClickable(searchInput).click();
    return this;
  }

  public GoogleCloudHomePage typeSearchTerm() {
    logger.info("Type " + SEARCH_TERM + " in search line");
    waitForVisibility(searchInput).sendKeys(SEARCH_TERM + Keys.ENTER);
    return this;
  }

  public void findTerm() {
    logger.info("Found " + SEARCH_TERM + " in search line");
    new WebDriverWait(driver, TIME_OUT_IN_SECONDS)
        .until(driver -> driver.findElement(By.xpath(String.format(PATTERN_FIND_TERM, SEARCH_TERM))))
        .click();
  }
}

package webdriver.google_cloud.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class GoogleCloudAbstractPage {

  protected WebDriver driver;

  public GoogleCloudAbstractPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }
}

package taf.product.pastebin.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PastebinAbstractPage {
  protected WebDriver driver;

  protected PastebinAbstractPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }
}

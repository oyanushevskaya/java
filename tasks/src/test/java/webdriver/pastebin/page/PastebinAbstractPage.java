package webdriver.pastebin.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PastebinAbstractPage {
  protected WebDriver driver;

  protected abstract PastebinAbstractPage openPage();
  protected abstract PastebinAbstractPage typeNewPaste(String paste);
  protected abstract PastebinAbstractPage selectPasteExpiration(String value);
  protected abstract PastebinAbstractPage typePasteName(String name);
  protected abstract void clickPasteNewButton();

  protected PastebinAbstractPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }
}

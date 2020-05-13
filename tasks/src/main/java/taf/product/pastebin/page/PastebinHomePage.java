package taf.product.pastebin.page;

import static taf.product.pastebin.constants.Constants.HOMEPAGE_URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PastebinHomePage extends PastebinAbstractPage {
  private Select select;

  @FindBy(id = "paste_code")
  private WebElement newPasteInput;
  @FindBy(name = "paste_expire_date")
  private WebElement pasteExpirationDropdown;
  @FindBy(name = "paste_name")
  private WebElement pasteNameInput;
  @FindBy(id = "submit")
  private WebElement createNewPasteButton;
  @FindBy(name = "paste_format")
  private WebElement syntaxHighlightingDropdown;
  @FindBy(xpath = "//a[contains(@href,'bash')]")
  private WebElement bushLink;
  @FindBy(xpath = "//ol")
  private WebElement pasteDataTextarea;

  public PastebinHomePage(WebDriver driver) {
    super(driver);
  }

  public String getSyntaxText() {
    return bushLink.getText();
  }

  public String getPasteText() {
    return pasteDataTextarea.getText();
  }

  public PastebinHomePage openPage() {
    driver.get(HOMEPAGE_URL);
    return this;
  }

  public PastebinHomePage typeNewPaste(String paste) {
    newPasteInput.sendKeys(paste);
    return this;
  }

  public PastebinHomePage selectSyntaxHighlighting(String value) {
    select = new Select(syntaxHighlightingDropdown);
    select.selectByValue(value);
    return this;
  }

  public PastebinHomePage selectPasteExpiration(String value) {
    select = new Select(pasteExpirationDropdown);
    select.selectByValue(value);
    return this;
  }

  public PastebinHomePage typePasteName(String name) {
    pasteNameInput.sendKeys(name);
    return this;
  }

  public void clickPasteNewButton() {
    createNewPasteButton.click();
  }
}

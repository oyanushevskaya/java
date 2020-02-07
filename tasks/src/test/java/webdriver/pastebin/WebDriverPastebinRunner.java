package webdriver.pastebin;

import static webdriver.pastebin.constants.Constants.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import webdriver.pastebin.page.PastebinHomePage;

public class WebDriverPastebinRunner {
  public static void main(String[] args) {
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    new PastebinHomePage(driver)
        .openPage();
    createNewPaste(driver);
    driver.quit();
  }

  public static void createNewPaste(WebDriver driver) {
    new PastebinHomePage(driver)
        .openPage()
        .typeNewPaste(NEW_PASTE)
        .selectPasteExpiration(PASTE_EXPIRATION)
        .typePasteName(TITLE_NAME)
        .clickPasteNewButton();
  }
}

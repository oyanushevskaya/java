package taf.product.pastebin.runner;

import static taf.product.pastebin.data.DataStorage.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import taf.product.pastebin.page.PastebinHomePage;

public class WebDriverPastebin {
  public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
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

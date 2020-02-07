package webdriver.pastebin;

import static webdriver.pastebin.constants.Constants.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import webdriver.pastebin.page.PastebinHomePage;
import webdriver.pastebin.service.PastebinService;

public class WebDriverPastebinTest {
  private WebDriver driver;

  @BeforeMethod(alwaysRun = true)
  public void browserSetup() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
  }

  @Test(description = "Pastebin insert new paste")
  public void verifyPastebinDetails() {
    new PastebinHomePage(driver)
        .openPage();
    new PastebinService()
         .createNewPaste(driver);
    SoftAssert softAssert = new SoftAssert();
    softAssert.assertTrue(driver.getTitle().contains(PASTE_NAME),
        ERROR_TITLE);
    softAssert.assertTrue(new PastebinHomePage(driver).getSyntaxText().equals(BASH_NAME),
        ERROR_SYNTAX);
    softAssert.assertTrue(new PastebinHomePage(driver).getPasteText().equals(TEXT_FOR_PASTE),
        ERROR_PASTE_TEXT);
    softAssert.assertAll();
  }

  @AfterMethod(alwaysRun = true)
  public void browserTearDown() {
    driver.quit();
  }
}

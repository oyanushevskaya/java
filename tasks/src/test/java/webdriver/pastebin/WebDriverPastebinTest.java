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

  @BeforeMethod(alwaysRun = true, description = "Google Chrome browser opens")
  public void browserSetup() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    new PastebinService()
        .createNewPaste(driver);
  }

  @Test(description = "Pastebin insert new paste")
  public void verifyPastebinDetails() {
    SoftAssert softAssert = new SoftAssert();
    softAssert.assertEquals(driver.getTitle(), ACTUAL_TITLE, ERROR_TITLE);
    softAssert.assertEquals(new PastebinHomePage(driver).getSyntaxText(),BASH_NAME, ERROR_SYNTAX);
    softAssert.assertEquals(new PastebinHomePage(driver).getPasteText(),TEXT_FOR_PASTE,
        ERROR_PASTE_TEXT);
    softAssert.assertAll();
  }

  @AfterMethod(alwaysRun = true, description = "Google Chrome browser closes")
  public void browserTearDown() {
    driver.quit();
  }
}

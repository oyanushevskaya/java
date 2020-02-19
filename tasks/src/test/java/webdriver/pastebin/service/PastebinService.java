package webdriver.pastebin.service;

import static webdriver.pastebin.constants.Constants.*;

import org.openqa.selenium.WebDriver;
import webdriver.pastebin.page.PastebinHomePage;

public class PastebinService {
  public void createNewPaste(WebDriver driver) {
    new PastebinHomePage(driver)
        .openPage()
        .typeNewPaste(TEXT_FOR_PASTE)
        .selectSyntaxHighlighting(SYNTAX_HIGHLIGHTING)
        .selectPasteExpiration(PASTE_EXPIRATION)
        .typePasteName(PASTE_NAME)
        .clickPasteNewButton();
  }
}

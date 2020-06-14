package taf.product.pastebin.service;

import static taf.product.pastebin.constants.Constants.*;

import org.openqa.selenium.WebDriver;
import taf.product.pastebin.page.PastebinHomePage;

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

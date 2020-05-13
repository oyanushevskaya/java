package taf.product.pastebin.constants;

public class Constants {

  public static final String HOMEPAGE_URL = "https://pastebin.com";

  public static final String NEW_PASTE = "Hello from WebDriver";
  public static final String PASTE_EXPIRATION = "10M";
  public static final String TITLE_NAME = "helloweb";

  public static final String TEXT_FOR_PASTE =
      "git config --global user.name 'New Sheriff in Town'\n"
          + "git reset $(git commit-tree HEAD^{tree} -m 'Legacy code')\n"
          + "git push origin master --force";
  public static final String PASTE_NAME = "how to gain dominance among developers";
  public static final String BASH_NAME = "Bash";
  public static final String ACTUAL_TITLE = "["+ BASH_NAME +"] "+ PASTE_NAME +" - Pastebin.com";
  public static final String SYNTAX_HIGHLIGHTING = "8";

  public static final String ERROR_TITLE = "Titles are not equals";
  public static final String ERROR_SYNTAX = "Syntax not highlighting as Bash";
  public static final String ERROR_PASTE_TEXT = "Text not equals";
}

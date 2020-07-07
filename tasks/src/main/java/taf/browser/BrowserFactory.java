package taf.browser;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import taf.runner.Parameters;

public class BrowserFactory {
  public static WebDriver createInstance() {
    WebDriver driver;
    switch (Parameters.instance().getBrowserType()) {
      case FIREFOX:
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        break;
      case CHROME:
        WebDriverManager.chromedriver().setup();
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        driver = new ChromeDriver();
        break;
      default:
        throw new IllegalStateException(
            "Unexpected value: " + Parameters.instance().getBrowserType());
    }
    driver.manage().window().maximize();
    return driver;
  }
}

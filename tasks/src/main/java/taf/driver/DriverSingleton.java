package taf.driver;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {
  private static WebDriver driver;

  private DriverSingleton() {
  }

  public static WebDriver getDriver() {
    if (driver == null) {
      switch (System.getProperty("browser")) {
        case FIREFOX : {
          WebDriverManager.firefoxdriver().setup();
          driver = new FirefoxDriver();
          break;
        }
        case CHROME : {
          WebDriverManager.chromedriver().setup();
          System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
          driver = new ChromeDriver();
          break;
        }
      }
      driver.manage().window().maximize();
    }
    return driver;
  }

  public static void closeDriver() {
    driver.quit();
    driver = null;
  }
}

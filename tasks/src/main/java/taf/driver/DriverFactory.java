package taf.driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
  private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
  private static DriverFactory instance = new DriverFactory();

  private DriverFactory() {
  }

  public static DriverFactory getInstance() {
    return instance;
  }

  public static WebDriver getDriver() {
    return driver.get();
  }

  public static void setDriver(WebDriver driverParameter) {
    driver.set(driverParameter);
  }

  public static void closeDriver() {
    driver.get().quit();
    driver.remove();
  }
}
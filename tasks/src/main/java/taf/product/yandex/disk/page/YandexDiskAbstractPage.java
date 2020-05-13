package taf.product.yandex.disk.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class YandexDiskAbstractPage {
  protected WebDriver driver;

  protected YandexDiskAbstractPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }
}

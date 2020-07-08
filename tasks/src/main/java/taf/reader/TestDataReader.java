package taf.reader;

import java.util.ResourceBundle;
import taf.runner.Parameters;

public class TestDataReader {
  private static final ResourceBundle resourceBundle = ResourceBundle
      .getBundle(Parameters.instance().getEnvironment());

  public static String getTestData(String key) {
    return resourceBundle.getString(key);
  }
}

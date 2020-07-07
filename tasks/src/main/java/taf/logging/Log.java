package taf.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
  private static final Logger LOGGER = LogManager.getRootLogger();

  public static void info(String  message) {
    LOGGER.info(message);
  }

  public static void error(String message) {
    LOGGER.error(message);
  }

}

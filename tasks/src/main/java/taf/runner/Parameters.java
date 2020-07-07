package taf.runner;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.remote.BrowserType;
import org.testng.xml.XmlSuite.ParallelMode;

public final class Parameters {
  private static Parameters instance;
  private static final String PATH_TO_RESOURCES = "./src/main/resources/";

  @Parameter(
      names = "--suite",
      description = "Path to xml with tests"
  )
  private String pathToSuiteXml = PATH_TO_RESOURCES + "yandex/testng.xml";

  @Parameter(
      names = {"-b", "--browser"},
      description = "Browser type"
  )
  private String browserType = BrowserType.CHROME;

  @Parameter(
      names = "--log",
      description = "Path to log config file"
  )
  private String pathToLogConfig = PATH_TO_RESOURCES + "log4j2.xml";

  @Parameter(
      names = {"-en", "--environment"},
      description = "Environment"
  )
  private String environment = "yandex";

  @Parameter(
      names = "--parallel",
      description = "Parallel execution"
  )
  private boolean parallel = true;

  @Parameter(
      names = "--mode",
      description = "Parallel mode"
  )
  private ParallelMode parallelMode = ParallelMode.TESTS;

  @Parameter(
      names = "--thread",
      description = "Thread count"
  )
  private int threadCount = 2;

  public static synchronized Parameters instance() {
    if (instance == null) {
      instance = new Parameters();
    }
    return instance;
  }

  public String getPathToSuiteXml() {
    return pathToSuiteXml;
  }

  public String getBrowserType() {
    return browserType;
  }

  public String getEnvironment() {
    return environment;
  }

  public String getPathToLogConfig() {
    return pathToLogConfig;
  }

  public boolean isParallel() {
    return parallel;
  }

  public ParallelMode getParallelMode() {
    return parallelMode;
  }

  public int getThreadCount() {
    return threadCount;
  }
}

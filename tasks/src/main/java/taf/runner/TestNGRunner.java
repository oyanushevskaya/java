package taf.runner;

import com.beust.jcommander.*;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.log4j.PropertyConfigurator;
import taf.listener.*;
import taf.logging.Log;
import org.testng.TestNG;

public class TestNGRunner {

  public static void main(String[] args) {
    Log.info("Parse cli");
    parseCli(args);
    Log.info("Run application");
    createTestNG();
    Log.info("End application");
  }

  public static void parseCli(String[] args) {
    JCommander jCommander = new JCommander(Parameters.instance());
    jCommander.usage();
    Log.info(String.format("Parsing program arguments %s with JCommander", Arrays.toString(args)));
    try {
      jCommander.parse(args);
    } catch (ParameterException e) {
      Log.error(e.getMessage());
      System.exit(1);
    }
  }

  public static void createTestNG() {
    PropertyConfigurator.configureAndWatch(Parameters.instance().getPathToLogConfig());

    TestNG testNG = new TestNG();
    List<String> files = Collections.singletonList(Parameters.instance().getPathToSuiteXml());
    testNG.setTestSuites(files);
    testNG.addListener(new TestListener());
    testNG.addListener(new SuiteListener());
    testNG.run();
  }
}
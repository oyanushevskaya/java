package taf.listener;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import taf.logging.Log;
import taf.runner.Parameters;

public class SuiteListener implements ISuiteListener {

  @Override
  public void onStart(ISuite iSuite) {
    Log.info(String.format("%s suite started", iSuite.getName()));
    if (Parameters.instance().isParallel()) {
      iSuite.getXmlSuite().setParallel(Parameters.instance().getParallelMode());
      iSuite.getXmlSuite().setThreadCount(Parameters.instance().getThreadCount());
    }
  }

  @Override
  public void onFinish(ISuite iSuite) {
    Log.info(String.format("%s suite finished", iSuite.getName()));
  }
}

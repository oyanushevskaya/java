package webdriver.google_cloud.service;

import webdriver.google_cloud.model.ComputeEngine;

public class ComputeEngineFactory {
  public final static String TESTDATA_NUMBER_OF_INSTANCE = "testdata.computeengine.numberofinstance";
  public final static String TESTDATA_OPERATION_SYSTEM = "testdata.computeengine.operationsystem";
  public final static String TESTDATA_MACHINE_CLASS = "testdata.computeengine.machineclass";
  public final static String TESTDATA_MACHINE_TYPE = "testdata.computeengine.machinetype";
  public final static String TESTDATA_NUMBER_OF_GPUS = "testdata.computeengine.numberofgpus";
  public final static String TESTDATA_GPU_TYPE = "testdata.computeengine.gputype";
  public final static String TESTDATA_LOCAL_SSD = "testdata.computeengine.localssd";
  public final static String TESTDATA_DATACENTER_LOCATION = "testdata.computeengine.datacenterlocation";
  public final static String TESTDATA_COMMITTED_USAGE = "testdata.computeengine.committedusage";

  public static ComputeEngine withCredentialsFromProperty() {
    return new ComputeEngine(TestDataReader.getTestData(TESTDATA_NUMBER_OF_INSTANCE),
        TestDataReader.getTestData(TESTDATA_OPERATION_SYSTEM),
        TestDataReader.getTestData(TESTDATA_MACHINE_CLASS),
        TestDataReader.getTestData(TESTDATA_MACHINE_TYPE),
        TestDataReader.getTestData(TESTDATA_NUMBER_OF_GPUS),
        TestDataReader.getTestData(TESTDATA_GPU_TYPE),
        TestDataReader.getTestData(TESTDATA_LOCAL_SSD),
        TestDataReader.getTestData(TESTDATA_DATACENTER_LOCATION),
        TestDataReader.getTestData(TESTDATA_COMMITTED_USAGE));
  }
}

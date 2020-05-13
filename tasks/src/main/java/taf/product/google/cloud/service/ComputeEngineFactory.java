package taf.product.google.cloud.service;

import taf.product.google.cloud.model.ComputeEngine;
import taf.reader.TestDataReader;

public class ComputeEngineFactory {
  public static final String TESTDATA_NUMBER_OF_INSTANCE = "testdata.computeengine.numberofinstance";
  public static final String TESTDATA_OPERATION_SYSTEM = "testdata.computeengine.operationsystem";
  public static final String TESTDATA_MACHINE_CLASS = "testdata.computeengine.machineclass";
  public static final String TESTDATA_MACHINE_TYPE = "testdata.computeengine.machinetype";
  public static final String TESTDATA_NUMBER_OF_GPUS = "testdata.computeengine.numberofgpus";
  public static final String TESTDATA_GPU_TYPE = "testdata.computeengine.gputype";
  public static final String TESTDATA_LOCAL_SSD = "testdata.computeengine.localssd";
  public static final String TESTDATA_DATACENTER_LOCATION = "testdata.computeengine.datacenterlocation";
  public static final String TESTDATA_COMMITTED_USAGE = "testdata.computeengine.committedusage";

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

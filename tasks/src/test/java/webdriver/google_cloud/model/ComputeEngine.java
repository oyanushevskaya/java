package webdriver.google_cloud.model;

public class ComputeEngine {
  private String numberOfInstances;
  private String operatingSystem;
  private String machineClass;
  private String machineType;
  private String numberOfGPUs;
  private String GPUType;
  private String localSSD;
  private String datacenterLocation;
  private String committedUsage;

  public ComputeEngine(String numberOfInstances, String operatingSystem, String machineClass,
      String machineType, String numberOfGPUs, String GPUType, String localSSD,
      String datacenterLocation, String committedUsage) {
    this.numberOfInstances = numberOfInstances;
    this.operatingSystem = operatingSystem;
    this.machineClass = machineClass;
    this.machineType = machineType;
    this.numberOfGPUs = numberOfGPUs;
    this.GPUType = GPUType;
    this.localSSD = localSSD;
    this.datacenterLocation = datacenterLocation;
    this.committedUsage = committedUsage;
  }

  public String getNumberOfInstances() {
    return numberOfInstances;
  }

  public String getOperatingSystem() {
    return operatingSystem;
  }

  public String getMachineClass() {
    return machineClass;
  }

  public String getMachineType() {
    return machineType;
  }

  public String getNumberOfGPUs() {
    return numberOfGPUs;
  }

  public String getGPUType() {
    return GPUType;
  }

  public String getLocalSSD() {
    return localSSD;
  }

  public String getDatacenterLocation() {
    return datacenterLocation;
  }

  public String getCommittedUsage() {
    return committedUsage;
  }
}

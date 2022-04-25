package framework.Hardcore.model;

import java.util.Objects;

public class VirtualMachine {
    private String numberOfInstances;
    private String osType;
    private String vmClass;
    private String series;
    private String instanceType;
    private String gpuType;
    private String numberOfGPUs;
    private String localSSD;
    private String datacenterLocation;
    private String CommittedUsage;

    public VirtualMachine(String numberOfInstances,
                          String osType,
                          String vmClass,
                          String series,
                          String instanceType,
                          String gpuType,
                          String numberOfGPUs,
                          String localSSD,
                          String datacenterLocation,
                          String CommittedUsage) {
        this.numberOfInstances = numberOfInstances;
        this.osType = osType;
        this.vmClass = vmClass;
        this.series = series;
        this.instanceType = instanceType;
        this.gpuType = gpuType;
        this.numberOfGPUs = numberOfGPUs;
        this.localSSD = localSSD;
        this.datacenterLocation = datacenterLocation;
        this.CommittedUsage = CommittedUsage;

    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public String getVmClass() {
        return vmClass;
    }

    public void setVmClass(String vmClass) {
        this.vmClass = vmClass;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    public String getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public void setNumberOfGPUs(String numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public void setDatacenterLocation(String datacenterLocation) {
        this.datacenterLocation = datacenterLocation;
    }

    public String getCommittedUsage() {
        return CommittedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        CommittedUsage = committedUsage;
    }

    @Override
    public String toString() {
        return "VirtualMachine{" +
                "numberOfInstances='" + numberOfInstances + '\'' +
                ", osType='" + osType + '\'' +
                ", vmClass='" + vmClass + '\'' +
                ", series='" + series + '\'' +
                ", instanceType='" + instanceType + '\'' +
                ", gpuType='" + gpuType + '\'' +
                ", numberOfGPUs='" + numberOfGPUs + '\'' +
                ", localSSD='" + localSSD + '\'' +
                ", datacenterLocation='" + datacenterLocation + '\'' +
                ", CommittedUsage='" + CommittedUsage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VirtualMachine that = (VirtualMachine) o;
        return Objects.equals(getNumberOfInstances(), that.getNumberOfInstances()) && Objects.equals(getOsType(), that.getOsType()) && Objects.equals(getVmClass(), that.getVmClass()) && Objects.equals(getSeries(), that.getSeries()) && Objects.equals(getInstanceType(), that.getInstanceType()) && Objects.equals(getGpuType(), that.getGpuType()) && Objects.equals(getNumberOfGPUs(), that.getNumberOfGPUs()) && Objects.equals(getLocalSSD(), that.getLocalSSD()) && Objects.equals(getDatacenterLocation(), that.getDatacenterLocation()) && Objects.equals(getCommittedUsage(), that.getCommittedUsage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumberOfInstances(), getOsType(), getVmClass(), getSeries(), getInstanceType(), getGpuType(), getNumberOfGPUs(), getLocalSSD(), getDatacenterLocation(), getCommittedUsage());
    }
}

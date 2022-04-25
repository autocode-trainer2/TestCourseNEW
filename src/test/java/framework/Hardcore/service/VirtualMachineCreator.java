package framework.Hardcore.service;

import framework.Hardcore.model.VirtualMachine;
import framework.Hardcore.test.TestDataReader;

public class VirtualMachineCreator {
    protected static final String NUMBER_OF_INSTANCE = "testdata.vm.numberOfInstance";
    protected static final String OS_TYPE = "testdata.vm.osType";
    protected static final String VM_CLASS = "testdata.vm.vmClass";
    protected static final String SERIES = "testdata.vm.series";
    protected static final String INSTANCE_TYPE = "testdata.vm.instanceType";
    protected static final String GPU_TYPE = "testdata.vm.gpuType";
    protected static final String NUMBER_OF_GPUS = "testdata.vm.numberOfGPUs";
    protected static final String LOCAL_SSD = "testdata.vm.localSSD";
    protected static final String DATACENTER_LOCATION = "testdata.vm.datacenterLocation";
    protected static final String COMMITTED_USAGE = "testdata.vm.committedUsage";

    public static VirtualMachine withCredentialsFromProperties(){
        return new VirtualMachine(TestDataReader.getTestData(NUMBER_OF_INSTANCE),
                TestDataReader.getTestData(OS_TYPE),
                TestDataReader.getTestData(VM_CLASS),
                TestDataReader.getTestData(SERIES),
                TestDataReader.getTestData(INSTANCE_TYPE),
                TestDataReader.getTestData(GPU_TYPE),
                TestDataReader.getTestData(NUMBER_OF_GPUS),
                TestDataReader.getTestData(LOCAL_SSD),
                TestDataReader.getTestData(DATACENTER_LOCATION),
                TestDataReader.getTestData(COMMITTED_USAGE));
    }
}

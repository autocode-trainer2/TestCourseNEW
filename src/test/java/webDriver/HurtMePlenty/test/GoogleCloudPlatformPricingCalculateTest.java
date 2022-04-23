package webDriver.HurtMePlenty.test;

import webDriver.HurtMePlenty.page.CalculateResultPage;
import webDriver.HurtMePlenty.page.GoogleCloudHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleCloudPlatformPricingCalculateTest {
    private static final String NUMBER_OF_INSTANCE = "4";
    private static final String OS_TYPE = "Free: Debian";
    private static final String VM_CLASS = "Regular";
    private static final String SERIES = "N1";
    private static final String INSTANCE_TYPE = "n1-standard-8";
    private static final String GPU_TYPE = "NVIDIA Tesla V100";
    private static final String NUMBER_OF_GPUS = "1";
    private static final String LOCAL_SSD = "2x375 G";
    private static final String DATACENTER_LOCATION = "Frankfurt";
    private static final String COMMITTED_USAGE = "1 Year";
    private static CalculateResultPage resultsOfCalculate;
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\webdrivers\\yandexdriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void GoogleCloudPlatformPricingCalculatorTest(){

            resultsOfCalculate = new GoogleCloudHomePage(driver)
                    .openPage()
                    .searchForPricingCalculator()
                    .goToPricingCalculator()
                    .setInstanceNumbers(NUMBER_OF_INSTANCE)
                    .setOSType(OS_TYPE)
                    .setVMClass(VM_CLASS)
                    .setSeries(SERIES)
                    .setInstanceType(INSTANCE_TYPE)
                    .checkAddGPUs()
                    .setGPUType(GPU_TYPE)
                    .setGPUNumber(NUMBER_OF_GPUS)
                    .setLocaleSSD(LOCAL_SSD)
                    .setDatacenter(DATACENTER_LOCATION)
                    .setCommittedUsage(COMMITTED_USAGE)
                    .estimate();

        Assert.assertTrue(resultsOfCalculate.getItem("Region").contains(DATACENTER_LOCATION),
                "FAIL: Datacenter region");
        Assert.assertTrue(resultsOfCalculate.getItem("Commitment term").contains(COMMITTED_USAGE),
                "FAIL: Committed term");
        Assert.assertTrue(resultsOfCalculate.getItem("VM class").contains(VM_CLASS.toLowerCase()),
                "FAIL: VM class");
        Assert.assertTrue(resultsOfCalculate.getItem("Instance type").contains(INSTANCE_TYPE),
                "FAIL: Instance type");
        Assert.assertTrue(resultsOfCalculate.getItem("Local SSD").contains(LOCAL_SSD),
                "FAIL: Local SSD");
        Assert.assertTrue(resultsOfCalculate.getItem("Total Estimated Cost").contains("1,082.77"),
                "FAIL: Total Estimated Cost");

    }

    @AfterMethod(alwaysRun = true)
    public void stopDriver(){
        driver.quit();
        driver = null;
    }
}

package webDriver.HurtMePlenty.test;

import org.testng.asserts.SoftAssert;
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
        System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver");
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
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(resultsOfCalculate.getItem("Region"), DATACENTER_LOCATION,
                "Datacenter region didn't mismatch");
        softAssert.assertEquals(resultsOfCalculate.getItem("Commitment term"), COMMITTED_USAGE,
                "Committed term didn't mismatch");
        softAssert.assertEquals(resultsOfCalculate.getItem("VM class"), VM_CLASS.toLowerCase(),
                "VM class didn't mismatch");
        softAssert.assertEquals(resultsOfCalculate.getItem("Instance type"), INSTANCE_TYPE,
                "Instance type didn't mismatch");
        softAssert.assertEquals(resultsOfCalculate.getItem("Local SSD"), LOCAL_SSD,
                "Local SSD didn't mismatch");
        softAssert.assertEquals(resultsOfCalculate.getItem("Total Estimated Cost"), "1,082.77",
                "Total Estimated Cost didn't mismatch");

    }

    @AfterMethod(alwaysRun = true)
    public void stopDriver(){
        driver.quit();
        driver = null;
    }
}

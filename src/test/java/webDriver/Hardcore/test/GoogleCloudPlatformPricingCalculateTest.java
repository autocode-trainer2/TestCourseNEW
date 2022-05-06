package webDriver.Hardcore.test;

import org.testng.annotations.AfterMethod;
import webDriver.Hardcore.page.CalculateResultPage;
import webDriver.Hardcore.page.GoogleCloudHomePage;
import webDriver.Hardcore.page.YopmailHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver");
        driver = new ChromeDriver();
    }

    @Test
    public void GoogleCloudPlatformPricingCalculatorTest(){

        CalculateResultPage resultPages = new GoogleCloudHomePage(driver)
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
                .estimate()
                .emailEstimateClick();
        String calculatorTab = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        String yopmailTab = driver.getWindowHandle();
        YopmailHomePage yopmailEmail = new YopmailHomePage(driver)
                .openYapmailPage();
        String email = yopmailEmail
                .generateAndCopyRandomEmail();
        driver.switchTo().window(calculatorTab);
        String costFromCalculator = new CalculateResultPage(driver)
                .enterEmail(email)
                .sendEmailClick()
                .getEstimateCostsFromCalculator();
        driver.switchTo().window(yopmailTab);
        String costFromEmail = new YopmailHomePage(driver)
                .checkInbox()
                .getEstimatedCostsFromEmail();
        Assert.assertEquals(costFromEmail, costFromCalculator, "FAIL: Total Cost results are different");
    }


    @AfterMethod(alwaysRun = true)
    public void stopDriver(){
        driver.quit();
        driver = null;
    }
}

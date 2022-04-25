package framework.Hardcore.test;

import framework.Hardcore.model.Email;
import framework.Hardcore.model.VirtualMachine;
import framework.Hardcore.page.CalculateResultPage;
import framework.Hardcore.page.GoogleCloudHomePage;
import framework.Hardcore.page.YopmailHomePage;
import framework.Hardcore.service.VirtualMachineCreator;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleCloudPlatformPricingCalculateTest extends CommonConditions{

    @Test
    public void GoogleCloudPlatformPricingCalculatorTest(){
        VirtualMachine testVirtualMachine = VirtualMachineCreator.withCredentialsFromProperties();
        String calculatorResult = new GoogleCloudHomePage(driver)
                .openPage()
                .searchForPricingCalculator()
                .goToPricingCalculator()
                .fillVirtualMachineData(testVirtualMachine)
                .estimate()
                .getEstimateCostsFromCalculator();

        String calculatorTab = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        String yopmailTab = driver.getWindowHandle();

        Email email = new Email(new YopmailHomePage(driver)
                .openPage()
                .generateTemporaryEmail());

        String emailResult = new CalculateResultPage(driver.switchTo().window(calculatorTab))
                .emailEstimateClick()
                .enterEmailField(email.getEmail())
                .sendEmailClick()
                .checkInbox(driver.switchTo().window(yopmailTab))
                .getEstimatedCostsFromEmail();

     Assert.assertEquals(emailResult, calculatorResult, "FAIL: Total Cost results are different");

    }

}

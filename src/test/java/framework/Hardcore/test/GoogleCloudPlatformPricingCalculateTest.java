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

public class GoogleCloudPlatformPricingCalculateTest extends CommonConditions {
    private VirtualMachine testVirtualMachine;
    private Email email;
    private String calculatorTab;
    private String yopmailTab;


    @Test(description = "Price comparison test")
    public void pricingCalculate() {
        testVirtualMachine = VirtualMachineCreator.withCredentialsFromProperties();
        String calculatorResult = getCalculatorResult();
        calculatorTab = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        yopmailTab = driver.getWindowHandle();
        email = new Email(new YopmailHomePage(driver)
                .openPage()
                .generateTemporaryEmail());
        Assert.assertEquals(getEmailResult(), calculatorResult, "Total Cost results are different");
    }

    private String getCalculatorResult() {
        return new GoogleCloudHomePage(driver)
                .openPage()
                .searchForPricingCalculator()
                .goToPricingCalculator()
                .fillVirtualMachineData(testVirtualMachine)
                .estimate()
                .getEstimateCostsFromCalculator();
    }

    private String getEmailResult() {
        return new CalculateResultPage(driver.switchTo().window(calculatorTab))
                .emailEstimateClick()
                .enterEmailField(email.getEmail())
                .sendEmailClick()
                .checkInbox(driver.switchTo().window(yopmailTab))
                .getEstimatedCostsFromEmail();
    }

}

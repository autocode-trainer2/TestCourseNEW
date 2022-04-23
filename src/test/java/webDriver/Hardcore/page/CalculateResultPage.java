package webDriver.Hardcore.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculateResultPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@ng-controller='CloudCartCtrl as cloudCartCtrl']")
    private WebElement resultBlock;

    @FindBy(id = "email_quote")
    private WebElement emailEstimateButton;

    @FindBy(xpath = "//*[@type='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@ng-click='emailQuote.emailQuote(true); emailQuote.$mdDialog.hide()']")
    private WebElement sendEmailButton;

    @FindBy(xpath = "//*[@id='cloud-site']/devsite-iframe/iframe")
    private WebElement webFrame;

    @FindBy(xpath = "//iframe[@id='myFrame']")
    private WebElement calculateFrame;

    public CalculateResultPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getItem(String item){
        return resultBlock.findElement(By.xpath("//*[contains(.,'" + item + "')]")).getText();
    }

    public String getEstimateCostsFromCalculator(){
        String costText = resultBlock.findElement(By.xpath("//*[contains(text(),'Total Estimated Cost:')]")).getText();
        String[] results = costText.split(":");
        return results[1].split(" ")[2];
    }

    public CalculateResultPage emailEstimateClick(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(emailEstimateButton));
        emailEstimateButton.click();
        return this;
    }

    public CalculateResultPage enterEmail(String email){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(webFrame));
        driver.switchTo().frame(webFrame);
        driver.switchTo().frame(calculateFrame);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(emailInput));

        emailInput.click();
        emailInput.sendKeys(email);
        return this;
    }

    public CalculateResultPage sendEmailClick(){
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.elementToBeClickable(sendEmailButton));
        sendEmailButton.click();
        return this;
    }
}

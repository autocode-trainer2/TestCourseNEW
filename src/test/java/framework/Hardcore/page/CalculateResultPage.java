package framework.Hardcore.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    private Logger logger = LogManager.getRootLogger();

    public CalculateResultPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getEstimateCostsFromCalculator(){
        String costText = resultBlock.findElement(By.xpath("//*[contains(text(),'Total Estimated Cost:')]")).getText();
        String[] results = costText.split(":");
        String result = results[1].split(" ")[2];
        logger.info("Total Estimated Cost in Calculator: " + result);
        return result;
    }

    public CalculateResultPage emailEstimateClick(){
        driver.switchTo().frame(webFrame);
        driver.switchTo().frame(calculateFrame);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(emailEstimateButton));
        emailEstimateButton.click();
        return this;
    }


    public CalculateResultPage enterEmailField(String emailAddress){

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(emailInput));

        emailInput.click();
        emailInput.sendKeys(emailAddress);
        return this;
    }

    public CalculateResultPage sendEmailClick(){
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.elementToBeClickable(sendEmailButton));
        sendEmailButton.click();
        return this;
    }

    public YopmailInboxPage checkInbox(WebDriver driver){
        return new YopmailInboxPage(driver);
    }
}

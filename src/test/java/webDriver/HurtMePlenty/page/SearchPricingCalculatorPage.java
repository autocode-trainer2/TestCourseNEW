package webDriver.HurtMePlenty.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPricingCalculatorPage {
    private WebDriver driver;

    @FindBy(linkText = "Google Cloud Platform Pricing Calculator")
    WebElement searchResult;

    @FindBy(xpath = "//*[@id='cloud-site']/devsite-iframe/iframe")
    private WebElement webFrame;

    @FindBy(xpath = "//iframe[@id='myFrame']")
    private WebElement calculateFrame;

    public SearchPricingCalculatorPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PricingCalculatorPage goToPricingCalculator(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(searchResult));
        searchResult.click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(webFrame));
        driver.switchTo().frame(webFrame);
        driver.switchTo().frame(calculateFrame);
        return new PricingCalculatorPage(driver);
    }
}

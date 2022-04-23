package webDriver.Hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudHomePage {
    private static final String HOMEPAGE_URL = "https://cloud.google.com";
    private WebDriver driver;

    @FindBy(name = "q")
    private WebElement searchInput;

    public GoogleCloudHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudHomePage openPage(){
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(searchInput));
        return this;
    }

    public SearchPricingCalculatorPage searchForPricingCalculator(){
        searchInput.sendKeys(  "Google Cloud Platform Pricing Calculator\n");
        return new SearchPricingCalculatorPage(driver);
    }
}

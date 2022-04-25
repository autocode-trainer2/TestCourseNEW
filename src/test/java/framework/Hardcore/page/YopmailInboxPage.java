package framework.Hardcore.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YopmailInboxPage {
    private WebDriver driver;

    private Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//*[text()='Total Estimated Monthly Cost']/../../td[2]")
    private WebElement cost;

    @FindBy(xpath = "//button[@onclick='egengo();']")
    private WebElement inboxButton;

    @FindBy(id = "ifinbox")
    private WebElement inboxFrame;

    @FindBy(id = "ifmail")
    private WebElement mailFrame;

    public YopmailInboxPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getEstimatedCostsFromEmail(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(inboxButton));
        inboxButton.click();

        driver.switchTo().frame(mailFrame);
        while (true) {
            try {
                new WebDriverWait(driver, Duration.ofSeconds(5))
                        .until(ExpectedConditions
                                .presenceOfElementLocated(By.xpath("//*[contains(text(),'noreply@google.com')]")));
                break;
            } catch (WebDriverException e) {
                driver.navigate().refresh();
                driver.switchTo().frame(mailFrame);
            }
        }
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(cost));
        String result = cost.getText().split(" ")[1];
        logger.info("Total Estimated Cost in Email: " + result);
        return result;
    }
}

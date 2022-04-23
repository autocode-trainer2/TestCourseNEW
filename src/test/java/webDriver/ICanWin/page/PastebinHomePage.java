package webDriver.ICanWin.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinHomePage {
    private static final String HOMEPAGE_URL = "http://pastebin.com";
    private WebDriver driver;
    private JavascriptExecutor executor;

    @FindBy(id = "postform-text")
    private WebElement newPasteInput;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement newPastExpiration;

    @FindBy(id = "postform-name")
    private WebElement newPasteTitleInput;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement newPasteButton;

    @FindBy(className = "post-view")
    private WebElement pasteView;

    public PastebinHomePage(WebDriver driver){
        this.driver = driver;
        executor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public PastebinHomePage openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public PastebinHomePage addPasteText(String pasteText){
        newPasteInput.sendKeys(pasteText);
        return this;
    }

    public PastebinHomePage setExpiration(String expiration){

        executor.executeScript("arguments[0].click();", newPastExpiration);
        newPastExpiration.click();
        WebElement option = driver.findElement(By.xpath("//li[text()='" + expiration + "']"));
        option.click();
        return this;
    }

    public PastebinHomePage setPasteTitle(String title){
        newPasteTitleInput.sendKeys(title);
        return this;
    }

    public PastebinHomePage submitNewPasteCreation(){
        newPasteButton.click();
        return this;
    }

    public Boolean isNewPasteCreated(){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(pasteView));
            return true;
        } catch (WebDriverException e){
            return false;
        }
    }

}
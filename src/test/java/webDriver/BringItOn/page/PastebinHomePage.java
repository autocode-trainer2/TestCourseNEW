package webDriver.BringItOn.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinHomePage {
    private static final String HOMEPAGE_URL = "http://pastebin.com";
    private WebDriver driver;
    private JavascriptExecutor executor;

    @FindBy(id = "postform-text")
    private WebElement newPasteInput;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement pastExpiration;

    @FindBy(id = "select2-postform-format-container")
    private WebElement syntaxHighlighting;

    @FindBy(id = "postform-name")
    private WebElement pasteTitleInput;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement createPasteButton;

    @FindBy(className = "post-view")
    private WebElement pasteView;

    @FindBy(xpath = "//vli[@class='vliIgnore']")
    WebElement closeAds;

    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
        executor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public PastebinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }

    public PastebinHomePage addPasteText(String pasteText) {
        newPasteInput.sendKeys(pasteText);
        return this;
    }

    public PastebinHomePage setExpiration(String expiration) {

        pastExpiration.click();
        WebElement option = driver.findElement(By.xpath("//li[text()='" + expiration + "']"));
        option.click();
        return this;
    }

    public PastebinHomePage setHighlighting(String highlighting) {

        if (closeAds.isDisplayed()) closeAds.click();
        syntaxHighlighting.click();
        WebElement option = driver.findElement(By.xpath("//li[text()='" + highlighting + "']"));
        option.click();
        return this;
    }

    public PastebinHomePage setPasteTitle(String title) {
        pasteTitleInput.sendKeys(title);
        return this;
    }

    public PasteViewPage submitNewPasteCreation() {
        createPasteButton.click();
        return new PasteViewPage(driver);
    }


}
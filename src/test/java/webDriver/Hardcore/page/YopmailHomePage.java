package webDriver.Hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YopmailHomePage {
    private WebDriver driver;
    private final String HOMEPAGE_URL = "https://yopmail.com/en";

    @FindBy(xpath = "//b[text()='Random Email Address']")
    private WebElement randomEmail;

    @FindBy(id = "egen")
    private WebElement email;

    @FindBy(id = "cprnd")
    private WebElement copyButton;

    @FindBy(xpath = "//button[@onclick='egengo();']")
    private WebElement inboxButton;

    public YopmailHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public YopmailHomePage openYapmailPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public String generateAndCopyRandomEmail() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(randomEmail));
        randomEmail.click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(email));
        return email.getText();
    }

    public YopmailInboxPage checkInbox() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(inboxButton));
        inboxButton.click();
        return new YopmailInboxPage(driver);
    }

}

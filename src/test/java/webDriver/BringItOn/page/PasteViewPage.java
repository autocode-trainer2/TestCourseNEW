package webDriver.BringItOn.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasteViewPage {
    private WebDriver driver;
    @FindBy(className = "source")
    private WebElement paste;

    @FindBy(xpath = "//div[@class='source']/ol")
    WebElement highlightStyle;

    public PasteViewPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public String getPasteText(){
        return paste.getText();
    }

    public String getPageTitle(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(paste));
        return driver.getTitle();
    }

    public String SyntaxHighlightStyle(){
        return highlightStyle.getAttribute("class");
    }
}

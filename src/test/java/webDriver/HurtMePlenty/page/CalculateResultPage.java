package webDriver.HurtMePlenty.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculateResultPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@ng-controller='CloudCartCtrl as cloudCartCtrl']")
    private WebElement resultBlock;

    @FindBy(xpath = "//*[contains(.,'Region')]")
    private WebElement region;

    public CalculateResultPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getItem(String item){
        return resultBlock.findElement(By.xpath("//*[contains(.,'" + item + "')]")).getText();
    }
}

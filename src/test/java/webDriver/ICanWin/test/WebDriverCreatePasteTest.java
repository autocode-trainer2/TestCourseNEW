package webDriver.ICanWin.test;

import webDriver.ICanWin.page.PastebinHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverCreatePasteTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver");
        driver = new ChromeDriver();
    }


    @Test(description = "Creating New Paste")
    public void createPasteTest() {
        Boolean createPaste = new PastebinHomePage(driver)
                .openPage()
                .addPasteText("Hello from WebDriver")
                .setPasteTitle("helloweb")
                .setExpiration("10 Minutes")
                .submitNewPasteCreation()
                .isNewPasteCreated();

        Assert.assertTrue(createPaste, "FAIL: Paste created error");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}

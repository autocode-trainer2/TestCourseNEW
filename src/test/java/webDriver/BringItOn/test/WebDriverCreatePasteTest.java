package webDriver.BringItOn.test;

import webDriver.BringItOn.page.PasteViewPage;
import webDriver.BringItOn.page.PastebinHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverCreatePasteTest {
    private WebDriver driver;
    private String CODE_TEXT = "git config --global user.name  \"New Sheriff in Town\"\n" +
                               "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                               "git push origin master --force";
    private String PASTE_NAME = "how to gain dominance among developers";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "D:\\webdrivers\\yandexdriver.exe");
        driver = new ChromeDriver();
    }

    @Test(description = "Creating New Paste")
    public void CreatePasteTest() {
        PasteViewPage paste = new PastebinHomePage(driver)
                .openPage()
                .addPasteText(CODE_TEXT)
                .setHighlighting("Bash")
                .setExpiration("10 Minutes")
                .setPasteTitle(PASTE_NAME)
                .submitNewPasteCreation();

        Assert.assertTrue(paste.getPageTitle().contains(PASTE_NAME), "FAIL: Page title did not mismatch");
        Assert.assertTrue(paste.getPasteText().contains(CODE_TEXT), "FAIL: Paste code did not mismatch");
        Assert.assertTrue(paste.SyntaxHighlightStyle().contains("bash"), "FAIL: Paste syntax highlight is not light");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}

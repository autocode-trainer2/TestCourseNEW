package webDriver.BringItOn.test;

import org.testng.asserts.SoftAssert;
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
    private final String CODE_TEXT = "git config --global user.name  \"New Sheriff in Town\"\n" +
                               "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                               "git push origin master --force";
    private String PASTE_NAME = "how to gain dominance among developers";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver");
        driver = new ChromeDriver();
    }

    @Test(description = "Creating New Paste")
    public void createPasteTest() {
        PasteViewPage paste = new PastebinHomePage(driver)
                .openPage()
                .addPasteText(CODE_TEXT)
                .setHighlighting("Bash")
                .setExpiration("10 Minutes")
                .setPasteTitle(PASTE_NAME)
                .submitNewPasteCreation();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(paste.getPageTitle(), PASTE_NAME, "FAIL: Page title did not mismatch");
        softAssert.assertEquals(paste.getPasteText(), CODE_TEXT, "FAIL: Paste code did not mismatch");
        softAssert.assertEquals(paste.SyntaxHighlightStyle(),"bash", "FAIL: Paste syntax highlight is not light");
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}

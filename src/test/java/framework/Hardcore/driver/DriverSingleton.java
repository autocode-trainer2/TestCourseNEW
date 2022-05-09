package framework.Hardcore.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {
    private static WebDriver driver;

    public DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            System.out.println("========================= browser: " + System.getProperty("browser") + " ====================");
            System.out.println("========================= environment: " + System.getProperty("environment") + " ====================");
            System.out.println("========================= surefire.suiteXmlFiles: " + System.getProperty("surefire.suiteXmlFiles") + " ====================");

            switch (System.getProperty("browser")) {
                case "firefox": {
                    System.out.println("========== firefox ==============");
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
                case "chrome": {
                    System.out.println("========== chrome ==============");

                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                }
                case "edge": {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                }
                default: {
                    System.out.println("========== default ==============");

                    System.setProperty("webdriver.chrome.driver", "src\test\resources\yandexdriver.exe");

                    driver = new ChromeDriver();
                    break;
                }
            }

            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}

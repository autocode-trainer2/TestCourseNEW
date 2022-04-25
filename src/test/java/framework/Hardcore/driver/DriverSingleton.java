package framework.Hardcore.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {
    private static WebDriver driver;

    public DriverSingleton(){}

    public static WebDriver getDriver(){
        if (driver==null){

            switch (System.getProperty("browser")) {
                case "firefox":{
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                } case "chrome":{
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                } case "edge":{
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                }

                default: {
                    System.setProperty("webdriver.chrome.driver", "d:\\webdrivers\\yandexdriver.exe");
                    driver = new ChromeDriver();
                }
            }

            driver.manage().window().maximize();
        }
        return driver;
    }
    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}

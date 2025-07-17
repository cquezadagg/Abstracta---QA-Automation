package utils;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
   private static WebDriver driver; 
   
   public static WebDriver getDriver() {

        if (driver == null) {
            if (OS.isName("Windows")) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
            } else if (OS.isName("Linux")) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
            }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

        }
        return driver;
    }
}

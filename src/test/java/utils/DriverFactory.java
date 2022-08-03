package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;

public class DriverFactory {

    private static WebDriver driver;
    private final static String DRIVER_PATH = "src/test/resources/";

    public static WebDriver getDriver(Browser browser) {
        switch (browser) {
            case FF:
                File file = new File(DRIVER_PATH + "/geckodriver");
                System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
                driver = new FirefoxDriver(new FirefoxOptions().addArguments("--headless"));
                break;
            case CHROME:
                file = new File(DRIVER_PATH + "/chromedriver");
                System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                driver = new ChromeDriver();
                break;
        }
        return driver;
    }
}

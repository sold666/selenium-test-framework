package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import steps.SearchSteps;
import utils.DriverFactory;
import utils.PropertyReader;

import java.time.Duration;

public class BaseSelenium {

    private static WebDriver driver;
    SearchSteps searchSteps;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver(PropertyReader.getBrowser());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get(PropertyReader.getBaseUrl());
        searchSteps = new SearchSteps();
    }

    @AfterMethod
    public void goBack() {
        driver.navigate().back();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "dataProvider")
    public Object[][] defaultProviderMethod() {
        return new Object[][]{{"dl spbstu"}};
    }
}

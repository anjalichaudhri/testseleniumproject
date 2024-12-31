package com.qa.seleniumproject.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.seleniumproject.base.BrowserFactory;
import com.qa.seleniumproject.utils.ConfigReader;
import com.qa.seleniumproject.utils.WaitUtils;


public class HomePageTest {
    WebDriver driver;
    WaitUtils waitUtils;

    @BeforeMethod
    public void setup() {
        String browser = ConfigReader.getProperty("browser");
        String baseUrl = ConfigReader.getProperty("baseURL");
        int explicitWait = Integer.parseInt(ConfigReader.getProperty("explicitWait"));

        System.out.println(browser);
        System.out.println(baseUrl);
        driver = BrowserFactory.getFactoryDriver(browser);
        driver.get(baseUrl);
        waitUtils = new WaitUtils(driver, explicitWait);
    }

    @Test
    public void validateHomePageTitle() {
        String expectedTitle = "Example Domain";
        waitUtils.waitForTitle("Example Domain");

        String actualTitle = driver.getTitle();
        assert actualTitle.equals(expectedTitle) : "Title mismatch! Expected: " + expectedTitle + ", but got: " + actualTitle;
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

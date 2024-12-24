package com.qa.seleniumproject.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.seleniumproject.base.BrowserFactory;
import com.qa.seleniumproject.utils.ConfigReader;


public class HomePageTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        String browser = ConfigReader.getProperty("browser");
        String baseUrl = ConfigReader.getProperty("baseUrl");

        driver = BrowserFactory.getFactoryDriver(browser);
        driver.get(baseUrl);
    }

    @Test
    public void validateHomePageTitle() {
        String expectedTitle = "Example - Home";
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

package com.qa.seleniumproject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginWebsite {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserSingleton.getDriver();
    }
    
    @Test
    public void testOpenWebsite() {
        driver.get("https://www.example.com");

        System.out.println("Page Title: " + driver.getTitle());

        // maximize the window
        driver.manage().window().maximize();
        System.out.println("Page current url: " + driver.getCurrentUrl()); 
    }

    @Test
    public void testOpenAnotherWebsite() {
        driver.get("https://www.test.com");
        Assert.assertTrue(driver.getTitle().contains("Test"));
    }

    // Clean up after tests
    @AfterMethod
    public void tearDown() {
        BrowserSingleton.closeDriver(); // Close the WebDriver instance
    }
}

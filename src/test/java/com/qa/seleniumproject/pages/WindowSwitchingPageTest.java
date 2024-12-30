package com.qa.seleniumproject.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.seleniumproject.base.BrowserFactory;
import com.qa.seleniumproject.utils.ConfigReader;

public class WindowSwitchingPageTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        String browser = ConfigReader.getProperty("browser");
        String demoWebsiteUrl = ConfigReader.getProperty("demoWebsiteUrl");

        System.out.println(browser);
        System.out.println(demoWebsiteUrl);
        driver = BrowserFactory.getFactoryDriver(browser);
        driver.get(demoWebsiteUrl);
    }

    @Test
    public void TestWindowSwitchingInteraction() {
        // get the current window handle
        String mainWindowHandle = driver.getWindowHandle();

        //click a button or link that opens a new window/tab
        WebElement openWindowButton = driver.findElement(By.id("openwindow"));
        openWindowButton.click();

        // wait for the new window to appear if necessary.
        //Get all window handles
        Set<String> allWindowHandles = driver.getWindowHandles();

        // switch to the new window
        for(String handle: allWindowHandles) {
            if(!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        // perform action in new window
        // WebElement newWindowElement = driver.findElement(By.)

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


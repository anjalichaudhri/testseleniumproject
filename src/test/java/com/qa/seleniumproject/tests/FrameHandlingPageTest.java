package com.qa.seleniumproject.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.seleniumproject.base.BrowserFactory;
import com.qa.seleniumproject.utils.ConfigReader;

public class FrameHandlingPageTest {
    WebDriver driver;

    // public FrameHandlingPageTest(WebDriver driver) {
    //     this.driver = driver;
    // }

    @BeforeMethod
    public void setup() {
        String browser = ConfigReader.getProperty("browser");
        String demoWebsiteUrl = ConfigReader.getProperty("demoQAWebsiteFrameUrl");

        System.out.println(browser);
        System.out.println(demoWebsiteUrl);
        driver = BrowserFactory.getFactoryDriver(browser);
        driver.get(demoWebsiteUrl);
    }

    // HANDLING FRAMES
    @Test
    public void testFrameInteraction() {
        // switch to frame using index.
        driver.switchTo().frame(3);

        // perform actions in the frame
        String frameElement = driver.findElement(By.id("sampleHeading")).getText();

        // verify text inside the frame
        Assert.assertEquals("This is a sample page", frameElement);

        driver.switchTo().defaultContent();

        WebElement mainContentHeading = driver.findElement(By.cssSelector("a[href='https://demoqa.com']"));

        Assert.assertTrue(mainContentHeading.isDisplayed());
    }

    // HANDLING MULTIPLE FRAMES
    @Test
    public void testSwitchingFrameByNameOrElement() {
        // switch to a frame by name.
        driver.switchTo().frame("frame2");

        // perform actions in the frame
        String frameElement = driver.findElement(By.id("sampleHeading")).getText();
        Assert.assertEquals("This is a sample page", frameElement);

        driver.switchTo().defaultContent();

        //switch to another frame by css selector

        WebElement webElement = driver.findElement(By.cssSelector("#frame1"));

        driver.switchTo().frame(webElement);
        // perform actions in the frame
        String anotherFrameElement = driver.findElement(By.id("sampleHeading")).getText();
        Assert.assertEquals("This is a sample page", anotherFrameElement);

        driver.switchTo().defaultContent();
        WebElement mainContentHeading = driver.findElement(By.cssSelector("a[href='https://demoqa.com']"));

        Assert.assertTrue(mainContentHeading.isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

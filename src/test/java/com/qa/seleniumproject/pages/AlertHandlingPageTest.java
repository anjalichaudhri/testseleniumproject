package com.qa.seleniumproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// import org.openqa.selenium.WebDriver.Window;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.seleniumproject.base.BrowserFactory;
import com.qa.seleniumproject.utils.AlertUtils;
import com.qa.seleniumproject.utils.ConfigReader;
import com.qa.seleniumproject.utils.DynamicElementUtils;
// import com.qa.seleniumproject.utils.WaitUtils;

// NOTE:- need to add scrolling till the element visible code, to make them work

public class AlertHandlingPageTest {
    WebDriver driver;
    AlertUtils alertUtils;
    DynamicElementUtils dynamicElementUtils;

    @BeforeMethod
    public void setup() {
        String browser = ConfigReader.getProperty("browser");
        String demoWebsiteUrl = ConfigReader.getProperty("demoQAWebsiteAlertUrl");

        driver = BrowserFactory.getFactoryDriver(browser);
        driver.get(demoWebsiteUrl);
        alertUtils = new AlertUtils(driver);
        dynamicElementUtils = new DynamicElementUtils(driver);
    }

    @Test
    public void SimpleAlertTest() { 
        // WebElement alertButton = driver.findElement(By.id("alertButton"));
        WebElement alertButton = dynamicElementUtils.waitForElementToBeClickable(By.id("alertButton"), 20);

        // driver.manage().window().maximize();

        alertButton.click();

        String alertText = alertUtils.handleSimpleAlert();

        String expectedAlertText = "You clicked a button";

        // assert alert text
        Assert.assertEquals(expectedAlertText, alertText);

        // driver.switchTo().defaultContent(); // not necessary for alerts, however if it is in frame, please make sure you are dealing with the correct context.
    }

    @Test
    public void confirmationAlertTest() {
        WebElement alertButton = driver.findElement(By.id("confirmButton"));
        alertButton.click();

        String alertText = alertUtils.handleConfirmationAlert(false);

        String expectedAlertText = "Do you confirm action?";

        // assert alert text
        Assert.assertEquals(alertText, expectedAlertText);
    }

    @Test
    public void promptAlertsTest() {
        WebElement promptAlertButton = driver.findElement(By.id("promtButton"));
        promptAlertButton.click();
        
        String alertText = alertUtils.handlePromptAlert("Anjali", true);
        String expectedAlertText = "Please enter your name";

        //Assert alert text
        Assert.assertEquals(alertText, expectedAlertText);
    }

    @Test
    public void TimedAlertsTest() {
        WebElement timedAlertButtton = driver.findElement(By.id("timerAlertButton"));
        timedAlertButtton.click();

        String alertText = alertUtils.handleTimerAlert();
        String expectedAlert = "This alert appeared after 5 seconds";

        // Assert timer alert text
        Assert.assertEquals(alertText, expectedAlert);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

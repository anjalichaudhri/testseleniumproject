package com.qa.seleniumproject.tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
// import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.seleniumproject.base.BrowserFactory;
import com.qa.seleniumproject.utils.ConfigReader;
import com.qa.seleniumproject.utils.ShadowDomUtils;

public class ShadowDomTest {
    private WebDriver driver;
    ShadowDomUtils shadowDomUtils;

    @BeforeClass
    public void setUp() {
        String browser = ConfigReader.getProperty("browser");
        driver = BrowserFactory.getFactoryDriver(browser);

        shadowDomUtils = new ShadowDomUtils(driver);        
    }

    // @Test
    // public void testShadowDomInteraction() {
    //     // Open the demo website with shadow DOM
    //     driver.get("https://www.webcomponents.org/");

    //     // Wait for the shadow DOM element to be available
    //     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    //     // Find the host element that contains the shadow root
    //     WebElement shadowHost = driver.findElement(By.cssSelector("your-shadow-host-selector"));

    //     // Access the shadow root using JavaScript execution
    //     WebElement shadowRoot = expandShadowRoot(shadowHost);

    //     // Now interact with elements inside the shadow DOM
    //     WebElement shadowElement = shadowRoot.findElement(By.cssSelector("your-shadow-element-selector"));

    //     // Example action: Click on an element inside the shadow DOM
    //     shadowElement.click();

    //     // Wait for some result or interaction
    //     wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("your-result-selector")));

    //     // Assert that the interaction produced the expected result
    //     Assert.assertTrue(driver.findElement(By.cssSelector("your-result-selector")).isDisplayed(), "Expected result not displayed");
    // }

    // // Method to expand the shadow DOM and return the shadow root
    // public WebElement expandShadowRoot(WebElement shadowHost) {
    //     JavascriptExecutor js = (JavascriptExecutor) driver;
    //     WebElement shadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost);
    //     return shadowRoot;
    // }

    @Test
    public void testShoelaceShadowDomButton() {
        // Open the Shoelace Components page
        driver.get("https://shoelace.style/");

        // Wait for the button to be rendered (can also use other waits if necessary)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Locate the shadow host for the button (Shoelace button)
        WebElement shadowHost = driver.findElement(By.tagName("sl-button"));

        // Use the utility method to click on the button inside the shadow DOM
        shadowDomUtils.clickElementInShadowDom(shadowHost, "button");

        // Wait for the expected action to complete, in this case, an alert appears
        wait.until(ExpectedConditions.alertIsPresent());

        // Verify that an alert appeared after clicking the button
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Button clicked!");
        alert.accept(); // Close the alert
    }

    @AfterClass
    public void tearDown() {
        // Close the driver
        if (driver != null) {
            driver.quit();
        }
    }
    
}

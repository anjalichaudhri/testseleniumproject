package com.qa.seleniumproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameHandlingPageTest {
    private WebDriver driver;

    public FrameHandlingPageTest(WebDriver driver) {
        this.driver = driver;
    }

    // HANDLING FRAMES
    @Test
    public void testFrameInteraction() {
        // switch to frame using index.
        driver.switchTo().frame(0);

        // perform actions in the frame
        String frameInput = driver.findElement(By.id("sampleHeading")).getText();

        // verify text inside the frame
        Assert.assertEquals("This is a sample page", frameInput);

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
        WebElement frameElement = driver.findElement(By.id("sampleHeading"));
        Assert.assertEquals("This is a sample page", frameElement);

        driver.switchTo().defaultContent();

        //switch to another frame by css selector

        WebElement webElement = driver.findElement(By.cssSelector("#frame2"));

        driver.switchTo().frame(webElement);
        // perform actions in the frame
        WebElement anotherFrameElement = driver.findElement(By.id("sampleHeading"));
        Assert.assertEquals("This is a sample page", anotherFrameElement);

        driver.switchTo().defaultContent();
        WebElement mainContentHeading = driver.findElement(By.cssSelector("a[href='https://demoqa.com']"));

        Assert.assertTrue(mainContentHeading.isDisplayed());
    }
}

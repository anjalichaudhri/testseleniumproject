package com.qa.seleniumproject.utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Apply Explicit waits - create reusable functions for wait - to make the code more cleaner and maintainable 
public class WaitUtils {
    @SuppressWarnings("unused")
    private WebDriver driver;
    private WebDriverWait wait;

    public WaitUtils(WebDriver driver, int timeoutInSeconds) {
        // create driver
        this.driver = driver;
        // create webdriver wait and pass driver and explicitely mentioned time 
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForTitle(String expectedTitle) {
        // use wait variable to pass expected conditions to test.
        wait.until(ExpectedConditions.titleIs(expectedTitle));
    }

    public void waitForElementToBeVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForElementToBePresent(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Please take a reference to this method to modify others
    public Alert waitForAlertToBePresent() {

        return wait.until(ExpectedConditions.alertIsPresent());
    }

    /**
     * Waits for a custom condition defined by a lambda function.
     * @param condition The condition to wait for.
     * @param <T> The type of the expected condition.
     */
    public <T> void waitForCondition(ExpectedCondition<T> condition) {
        wait.until(condition);
    }
}

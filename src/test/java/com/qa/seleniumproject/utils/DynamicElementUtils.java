package com.qa.seleniumproject.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicElementUtils {
    private WebDriver driver;

    public DynamicElementUtils(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Waits for an element to become visible (for dynamic elements).
     * 
     * @param locator The By locator for the element.
     * @param timeoutInSeconds The timeout in seconds.
     * @return The WebElement when it becomes visible.
     */
    public WebElement waitForElementToBeVisible(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits for an element to be clickable (for dynamic elements).
     * 
     * @param locator The By locator for the element.
     * @param timeoutInSeconds The timeout in seconds.
     * @return The WebElement when it becomes clickable.
     */
    public WebElement waitForElementToBeClickable(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Waits for a dynamic element to disappear.
     * 
     * @param locator The By locator for the element.
     * @param timeoutInSeconds The timeout in seconds.
     * @return True if the element disappears, otherwise false.
     */
    public boolean waitForElementToDisappear(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}

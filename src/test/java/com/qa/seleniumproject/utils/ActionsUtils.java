package com.qa.seleniumproject.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtils {
    private WebDriver driver;
    private Actions actions;

    public ActionsUtils(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    /**
     * Performs a mouse hover action on the given element.
     *
     * @param locator The locator of the element to hover over.
     */
    public void mouseHover(By locator) {
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element).perform();
    }

    /**
     * Performs a right-click (context-click) on the given element.
     *
     * @param locator The locator of the element to right-click.
     */
    public void rightClick(By locator) {
        WebElement element = driver.findElement(locator);
        actions.contextClick(element).perform();
    }

    /**
     * Performs a drag-and-drop action from the source element to the target element.
     *
     * @param sourceLocator The locator of the element to drag.
     * @param targetLocator The locator of the element to drop on.
     */
    public void dragAndDrop(By sourceLocator, By targetLocator) {
        WebElement source = driver.findElement(sourceLocator);
        WebElement target = driver.findElement(targetLocator);
        actions.dragAndDrop(source, target).perform();
    }

    /**
     * Sends special keys to the currently focused element.
     *
     * @param keys The special keys to send.
     */
    public void sendKeys(CharSequence... keys) {
        actions.sendKeys(keys).perform();
    }
}

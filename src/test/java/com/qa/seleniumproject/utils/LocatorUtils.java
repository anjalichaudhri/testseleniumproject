package com.qa.seleniumproject.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorUtils {
    private WebDriver driver;

    public LocatorUtils(WebDriver driver) {
        this.driver = driver;
    }

    public By findElementByIdLocator(String id) {
        By webElementId = By.id(id);
        return webElementId;
    }

    public By findElementByNameLocator(String name) {
        By webElementName = By.name(name);
        return webElementName;
    }

    public By findElementByClassNameLocator(String name) {
        By webElementName = By.className(name);
        return webElementName;
    }

    public By findElementByCSS(String name) {
        By webElementName = By.cssSelector(name);
        return webElementName;
    }

    public By findElementByXpath(String name) {
        By webElementName = By.xpath(name);
        return webElementName;
    }

    public void selectElementById(String id) {
        By webElementId = By.id(id);
        WebElement webElement = driver.findElement(webElementId);
        webElement.click();
    }

    public void selectElementByName(String name) {
        By webElementId = By.name(name);
        WebElement webElement = driver.findElement(webElementId);
        webElement.click();
    }

    public void selectElementByClassName(String className) {
        By webElementId = By.className(className);
        WebElement webElement = driver.findElement(webElementId);
        webElement.click();
    }

    public void selectElementByTagName(String tagName) {
        By webElementId = By.tagName(tagName);
        WebElement webElement = driver.findElement(webElementId);
        webElement.click();
    }

    public void selectElementByCSS(String id) {
        By webElementId = By.cssSelector(id);
        WebElement webElement = driver.findElement(webElementId);
        webElement.click();
    }

    public void selectElementByXpath(String id) {
        By webElementId = By.xpath(id);
        WebElement webElement = driver.findElement(webElementId);
        webElement.click();
    }
}

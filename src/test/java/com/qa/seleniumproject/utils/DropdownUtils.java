package com.qa.seleniumproject.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownUtils {
    private WebDriver driver;

    public DropdownUtils(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Selects an option by visible text from a dropdown.
     * 
     * @param locator The By locator for the dropdown.
     * @param visibleText The visible text of the option to select.
     */
    public void selectByVisibleText(By locator, String visibleText) {
        WebElement dropdownElement = driver.findElement(locator);
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(visibleText);
    }

    /**
     * Selects an option by value from a dropdown.
     * 
     * @param locator The By locator for the dropdown.
     * @param value The value attribute of the option to select.
     */
    public void selectByValue(By locator, String value) {
        WebElement dropdownElement = driver.findElement(locator);
        Select select = new Select(dropdownElement);
        select.selectByValue(value);
    }

    /**
     * Selects an option by index from a dropdown.
     * 
     * @param locator The By locator for the dropdown.
     * @param index The index of the option to select.
     */
    public void selectByIndex(By locator, int index) {
        WebElement dropdownElement = driver.findElement(locator);
        Select select = new Select(dropdownElement);
        select.selectByIndex(index);
    }

    /**
     * Deselects all selected options from a dropdown (if it's a multi-select dropdown).
     * 
     * @param locator The By locator for the dropdown.
     */
    public void deselectAll(By locator) {
        WebElement dropdownElement = driver.findElement(locator);
        Select select = new Select(dropdownElement);
        select.deselectAll();
    }

    /**
     * Gets the selected option from a dropdown.
     * 
     * @param locator The By locator for the dropdown.
     * @return The selected option as a WebElement.
     */
    public WebElement getSelectedOption(By locator) {
        WebElement dropdownElement = driver.findElement(locator);
        Select select = new Select(dropdownElement);
        return select.getFirstSelectedOption();
    }
}

package com.qa.seleniumproject.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxUtils {
    private WebDriver driver;

    public CheckboxUtils(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks on a checkbox if it's not already selected.
     * 
     * @param locator The By locator for the checkbox.
     */
    public void selectCheckbox(By locator) {
        WebElement checkbox = driver.findElement(locator);

        if(!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    /**
     * Unchecks a checkbox if it's selected.
     * 
     * @param locator The By locator for the checkbox.
     */
    public void deselectCheckbox(By locator) {
        WebElement checkbox = driver.findElement(locator);
        if (checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public boolean isCheckboxSelected(By locator) {
        WebElement checkbox = driver.findElement(locator);
        return checkbox.isSelected();
    }

    /**
     * Selects a radio button.
     * 
     * @param locator The By locator for the radio button.
     */
    public void selectRadioButton(By locator) {
        WebElement radioButton = driver.findElement(locator);
        if (!radioButton.isSelected()) {
            radioButton.click();
        }
    }
}

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
import com.qa.seleniumproject.utils.DropdownUtils;
import com.qa.seleniumproject.utils.DynamicElementUtils;
import com.qa.seleniumproject.utils.LocatorUtils;
import com.qa.seleniumproject.utils.CheckboxUtils;

public class PracticePageTest {
    WebDriver driver;
    DropdownUtils dropdownUtils;
    CheckboxUtils checkboxUtils;
    LocatorUtils locatorUtils;
    DynamicElementUtils dynamicElementUtils;

    @BeforeMethod
    public void setup() {
        String browser = ConfigReader.getProperty("browser");
        String demoWebsiteUrl = ConfigReader.getProperty("demoWebsiteUrl");

        System.out.println(browser);
        System.out.println(demoWebsiteUrl);
        driver = BrowserFactory.getFactoryDriver(browser);
        driver.get(demoWebsiteUrl);
        dropdownUtils = new DropdownUtils(driver);
        checkboxUtils = new CheckboxUtils(driver);
        locatorUtils = new LocatorUtils(driver);
        dynamicElementUtils = new DynamicElementUtils(driver);
    }

    @Test
    public void validatePracticePageTitle() {
        String expectedTitle = "Practice Page";
        // waitUtils.waitForTitle("Example Domain");

        String actualTitle = driver.getTitle();
        assert actualTitle.equals(expectedTitle)
                : "Title mismatch! Expected: " + expectedTitle + ", but got: " + actualTitle;
    }

    @Test
    public void selectDropdownFromSelectOptions() {
        // Select an option by visible text
        dropdownUtils.selectByVisibleText(By.id("dropdown-class-example"), "Option1");

        // Get the selected option from the dropdown
        WebElement selectedOption = dropdownUtils.getSelectedOption(By.id("dropdown-class-example"));

        // Assert that the selected option is the one we expected
        String selectedText = selectedOption.getText();
        Assert.assertEquals("Option1", selectedText);

        // Optionally, assert that the dropdown menu's value matches the selected option
        String dropdownValue = selectedOption.getDomAttribute("value");
        Assert.assertEquals("option1", dropdownValue); // Assuming "option1" is the value attribute
    }

    @Test
    public void testCheckboxSelection() {
        By checkboxLocator = By.id("checkbox1"); // Replace with your locator

        checkboxUtils.selectCheckbox(checkboxLocator);
        Assert.assertTrue(checkboxUtils.isCheckboxSelected(checkboxLocator));
    }

    @Test
    public void testDeSelectCheckbox() {
        By checkboxLocator = locatorUtils.findElementByIdLocator("checkBoxOption1");
        By checkboxLocator1 = locatorUtils.findElementByNameLocator("checkBoxOption1");
        By checkboxLocator2 = locatorUtils
                .findElementByCSS("input[id='checkBoxOption2'][value='option2'][name='checkBoxOption2']");
        By checkboxLocator3 = locatorUtils
                .findElementByXpath("//input[@id='checkBoxOption3'][@name='checkBoxOption3'][@name='checkBoxOption3']");
        
        checkboxUtils.deselectCheckbox(checkboxLocator);

        Assert.assertFalse(checkboxUtils.isCheckboxSelected(checkboxLocator));

        // Waiting for a dynamic element to become visible
        WebElement dynamicElement = dynamicElementUtils.waitForElementToBeVisible(By.id("checkBoxOption2"), 10);

        dynamicElement.click();
        // Waiting for a dynamic element to be clickable
        WebElement clickableElement = dynamicElementUtils.waitForElementToBeClickable(By.id("checkBoxOption2"), 10);

        clickableElement.click();

        Assert.assertTrue(checkboxUtils.isCheckboxSelected(checkboxLocator2));

        // Waiting for a dynamic element to disappear
        boolean isElementInvisible = dynamicElementUtils.waitForElementToDisappear(By.id("checkBoxOption3"), 10);
        Assert.assertFalse(isElementInvisible);
        Assert.assertFalse(checkboxUtils.isCheckboxSelected(checkboxLocator3));
        Assert.assertFalse(checkboxUtils.isCheckboxSelected(checkboxLocator1));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

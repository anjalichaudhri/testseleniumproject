package com.qa.seleniumproject.pages;

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

public class PracticePageTest {
    WebDriver driver;
    DropdownUtils dropdownUtils;

    @BeforeMethod
    public void setup() {
        String browser = ConfigReader.getProperty("browser");
        String demoWebsiteUrl = ConfigReader.getProperty("demoWebsiteUrl");

        System.out.println(browser);
        System.out.println(demoWebsiteUrl);
        driver = BrowserFactory.getFactoryDriver(browser);
        driver.get(demoWebsiteUrl);
        dropdownUtils = new DropdownUtils(driver);
    }

    @Test
    public void validatePracticePageTitle() {
        String expectedTitle = "Practice Page";
        // waitUtils.waitForTitle("Example Domain");

        String actualTitle = driver.getTitle();
        assert actualTitle.equals(expectedTitle) : "Title mismatch! Expected: " + expectedTitle + ", but got: " + actualTitle;
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

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

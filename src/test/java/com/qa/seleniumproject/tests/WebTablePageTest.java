package com.qa.seleniumproject.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.seleniumproject.base.BrowserFactory;
import com.qa.seleniumproject.utils.ConfigReader;
import com.qa.seleniumproject.utils.WebTableUtils;

public class WebTablePageTest {
    WebDriver driver;
    WebTableUtils tableUtils;

    @BeforeMethod
    public void setup() {
        String browser = ConfigReader.getProperty("browser");
        // String baseUrl = ConfigReader.getProperty("baseUrl");

        driver = BrowserFactory.getFactoryDriver(browser);
        tableUtils = new WebTableUtils(driver);

        // open website page to test
        driver.get("https://the-internet.herokuapp.com/tables");
    }

    @Test
    public void webTableTest() {
        // Locator for the table
        By tableLocator = By.id("table1");

        // Get the number of rows and columns
        int rowCount = tableUtils.getRowCount(tableLocator);
        int colCount = tableUtils.getColumnCount(tableLocator);
        System.out.println("Rows: " + rowCount + ", Columns: " + colCount);

        // Get a specific cell value
        String cellValue = tableUtils.getCellValue(tableLocator, 2, 3); // 2nd row, 3rd column
        System.out.println("Cell value at (2,3): " + cellValue);

        // Get all values in a specific column
        List<String> columnValues = tableUtils.getColumnValues(tableLocator, 2); // 2nd column
        System.out.println("Column 2 values: " + columnValues);

        // Get all values in a specific row
        List<String> rowValues = tableUtils.getRowValues(tableLocator, 3); // 3rd row
        System.out.println("Row 3 values: " + rowValues);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}

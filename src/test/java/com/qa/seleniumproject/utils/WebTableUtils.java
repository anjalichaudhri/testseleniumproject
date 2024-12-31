package com.qa.seleniumproject.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTableUtils {
    private WebDriver driver;

    public WebTableUtils(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Get the number of rows in a table.
     *
     * @param tableLocator Locator for the table element.
     * @return Number of rows in the table.
     */
    public int getRowCount(By tableLocator) {
        WebElement table = driver.findElement(tableLocator);
        return table.findElements(By.tagName("tr")).size();
    }

    /**
     * Get the number of columns in a table.
     *
     * @param tableLocator Locator for the table element.
     * @return Number of columns in the table.
     */
    public int getColumnCount(By tableLocator) {
        WebElement table = driver.findElement(tableLocator);
        WebElement headerRow = table.findElements(By.tagName("tr")).get(0); // Assumes first row is the header
        return headerRow.findElements(By.tagName("th")).size();
    }

    /**
     * Get the cell value at a specific row and column.
     *
     * @param tableLocator Locator for the table element.
     * @param row Row index (1-based).
     * @param col Column index (1-based).
     * @return Cell value as a String.
     */
    public String getCellValue(By tableLocator, int row, int col) {
        WebElement table = driver.findElement(tableLocator);
        WebElement cell = table.findElement(By.xpath(".//tr[" + row + "]/td[" + col + "]"));
        return cell.getText();
    }

    /**
     * Get all values in a specific column.
     *
     * @param tableLocator Locator for the table element.
     * @param col Column index (1-based).
     * @return List of values in the specified column.
     */
    public List<String> getColumnValues(By tableLocator, int col) {
        List<String> columnValues = new ArrayList<>();
        WebElement table = driver.findElement(tableLocator);
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (int i = 1; i < rows.size(); i++) { // Start from 1 to skip the header
            WebElement cell = rows.get(i).findElement(By.xpath(".//td[" + col + "]"));
            columnValues.add(cell.getText());
        }
        return columnValues;
    }

    /**
     * Get all values in a specific row.
     *
     * @param tableLocator Locator for the table element.
     * @param row Row index (1-based).
     * @return List of values in the specified row.
     */
    public List<String> getRowValues(By tableLocator, int row) {
        List<String> rowValues = new ArrayList<>();
        WebElement table = driver.findElement(tableLocator);
        List<WebElement> cells = table.findElements(By.xpath(".//tr[" + row + "]/td"));
        for (WebElement cell : cells) {
            rowValues.add(cell.getText());
        }
        return rowValues;
    }
}

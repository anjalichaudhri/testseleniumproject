package com.qa.seleniumproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// Singleton design Pattern used in selenium project for driver instantiation.
public class BrowserSingleton {
    // 1. private static instance of class - volatile to give the threads proper copy of data
    private volatile static WebDriver driver;

    // 2. private static constructor to prevent instantiation of the object
    private BrowserSingleton() {
        if (driver != null) {
            throw new IllegalArgumentException("object already exists");
        }
    }

    // 3. public static method to provide access to the instance/object
    public static WebDriver getDriver() {
        if (driver == null) {
            synchronized (BrowserSingleton.class) {
                String browser = System.getProperty("browser", "chrome"); // default to chrome
                if (browser.equalsIgnoreCase("chrome")) {
                    driver = new ChromeDriver();
                } else if (browser.equalsIgnoreCase("firefox")) {
                    driver = new FirefoxDriver();
                }

            }

        }

        return driver;
    }

    // Method to close the WebDriver
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Clean up the WebDriver instance
        }
    }

}

/*
 * KEY POINTS:
 * 
 * The WebDriverSingleton class ensures only one WebDriver instance is created
 * during the lifetime of the test execution.
 * 
 * The getDriver() method checks if the WebDriver instance is already created;
 * if not, it creates one.
 * 
 * The closeDriver() method ensures that the WebDriver is closed after tests to
 * free up resources.
 * 
 * The Singleton pattern helps avoid the overhead of creating multiple instances
 * of the WebDriver, which can slow down the execution.
 * 
 * This approach makes it easy to manage the WebDriver instance, particularly in
 * large test suites, and ensures efficient resource management.
 */
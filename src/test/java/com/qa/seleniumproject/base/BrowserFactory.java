package com.qa.seleniumproject.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// factory design pattern - interface usage to provide abstraction.
public class BrowserFactory {
    public static WebDriver getFactoryDriver(String browser) {
        WebDriver driver = null;

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser: " + browser);
        }

        return driver;
    }

    public static WebDriver getFactoryDriver(String browser, ChromeOptions chromeOptions) {
        WebDriver driver = null;

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser: " + browser);
        }

        return driver;
    }
}

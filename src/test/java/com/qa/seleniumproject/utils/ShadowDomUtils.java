package com.qa.seleniumproject.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShadowDomUtils {
    private WebDriver driver;

    public ShadowDomUtils(WebDriver driver) {
        this.driver = driver;
    }

    // Method to expand the shadow DOM and return the shadow root
    public WebElement expandShadowRoot(WebElement shadowHost) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement shadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost);
        return shadowRoot;
    }

    // Method to click an element inside the shadow DOM
    public void clickElementInShadowDom(WebElement shadowHost, String cssSelector) {
        WebElement shadowRoot = expandShadowRoot(shadowHost);
        WebElement element = shadowRoot.findElement(By.cssSelector(cssSelector));
        element.click();
    }

    // Method to get text from an element inside the shadow DOM
    public String getTextFromShadowDom(WebElement shadowHost, String cssSelector) {
        WebElement shadowRoot = expandShadowRoot(shadowHost);
        WebElement element = shadowRoot.findElement(By.cssSelector(cssSelector));
        return element.getText();
    }
}

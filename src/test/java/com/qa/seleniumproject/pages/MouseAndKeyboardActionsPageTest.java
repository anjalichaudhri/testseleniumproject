package com.qa.seleniumproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.seleniumproject.base.BrowserFactory;
import com.qa.seleniumproject.utils.ActionsUtils;
import com.qa.seleniumproject.utils.ConfigReader;

public class MouseAndKeyboardActionsPageTest  {
    WebDriver driver;
    ActionsUtils actionsUtils;

    @BeforeMethod
    public void setup() {
        String browser = ConfigReader.getProperty("browser");
        String baseUrl = ConfigReader.getProperty("demoQAWebsiteDroppableUrl");

        System.out.println(browser);
        System.out.println(baseUrl);
        driver = BrowserFactory.getFactoryDriver(browser);
        driver.get(baseUrl);

        actionsUtils = new ActionsUtils(driver);
    }

    @Test
    public void mouseHoverTest() {
        driver.navigate().to("https://demoqa.com/tool-tips");
        actionsUtils.mouseHover(By.id("toolTipButton"));
        System.out.println("Mouse hover performed on tooltip button.");
    }

    @Test
    public void rightClickTest() {
        // Perform Right-Click
        driver.navigate().to("https://demoqa.com/buttons");
        actionsUtils.rightClick(By.id("rightClickBtn"));
        System.out.println("Right-click performed.");
    }

    @Test
    public void dragAndDropTest() {
        // Perform Drag and Drop
        driver.navigate().to("https://demoqa.com/droppable");
        actionsUtils.dragAndDrop(By.id("draggable"), By.id("droppable"));
        System.out.println("Drag-and-drop performed.");
    }

    @Test
    public void keyboardActionsTest() {
        // Perform Keyboard Actions (Sending special keys)
        driver.navigate().to("https://demoqa.com/text-box");
        WebElement textBox = driver.findElement(By.id("userName"));
        textBox.click();
        actionsUtils.sendKeys("Test User", "\uE007"); // \uE007 is the ENTER key
        System.out.println("Special keys sent.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }    
}

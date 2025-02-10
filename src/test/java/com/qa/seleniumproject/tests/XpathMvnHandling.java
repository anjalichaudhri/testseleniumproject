package com.qa.seleniumproject.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.seleniumproject.base.BrowserFactory;
import com.qa.seleniumproject.utils.ConfigReader;

public class XpathMvnHandling {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        String browser = ConfigReader.getProperty("browser");
        driver = BrowserFactory.getFactoryDriver(browser);
    }

    @Test 
    public void navigateToMvnWebsite() {
        driver.get("https://mvnrepository.com/");

        //find element by id
        WebElement searchField = driver.findElement(By.id("query"));
        searchField.sendKeys("selenium");

    }

    @Test 
    public void findElementByClassName() {
        driver.get("https://mvnrepository.com/");

        //find element by id
        WebElement searchField = driver.findElement(By.className("q"));
        searchField.sendKeys("selenium");

    }

    @Test 
    public void findElementByName() {
        driver.get("https://mvnrepository.com/");

        //find element by id
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("selenium");
    }

    @Test 
    public void findElementByXpathId() {
        driver.get("https://mvnrepository.com/");

        //find element by id
        WebElement searchField = driver.findElement(By.xpath("//input[@id='query']"));
        searchField.sendKeys("selenium");
    }

    @Test 
    public void findElementByXpathClass() {
        driver.get("https://mvnrepository.com/");

        //find element by id
        WebElement searchField = driver.findElement(By.xpath("//input[@class='q']"));
        searchField.sendKeys("selenium");
    }

    @Test 
    public void findElementByXpathName() {
        driver.get("https://mvnrepository.com/");

        //find element by id
        WebElement searchField = driver.findElement(By.xpath("//input[@name='q']"));
        searchField.sendKeys("selenium");
    }

    @Test 
    public void findElementByXpathPlaceholder() {
        driver.get("https://mvnrepository.com/");

        //find element by id
        WebElement searchField = driver.findElement(By.xpath("//input[@placeholder='Search for groups, artifacts, categories']"));
        searchField.sendKeys("selenium");
    }

    @Test 
    public void findElementByXpathRole() {
        driver.get("https://mvnrepository.com/");

        //find element by id
        WebElement searchField = driver.findElement(By.xpath("//input[@role='searchbox']"));
        searchField.sendKeys("selenium");
    }

    @Test 
    public void findElementByXpathValue() {
        driver.get("https://mvnrepository.com/");

        //find element by id
        WebElement searchField = driver.findElement(By.xpath("//input[@maxlength='100']"));
        searchField.sendKeys("selenium");
    }

    @Test 
    public void findElementByXpathContainsMethod() {
        driver.get("https://mvnrepository.com/");

        //find element by id
        WebElement searchField = driver.findElement(By.xpath("//input[contains(@id, 'query')]"));
        searchField.sendKeys("selenium");
    }

    @Test 
    public void findElementByXpathContainsMethodClass() {
        driver.get("https://mvnrepository.com/");

        //find element by id
        WebElement searchField = driver.findElement(By.xpath("//input[contains(@class, 'textfield')]"));
        searchField.sendKeys("selenium");
    }

    @Test 
    public void findElementByXpathContainsMethodText() {
        driver.get("https://mvnrepository.com/");

        //find element by id
        WebElement searchField = driver.findElement(By.xpath("//input[contains(@id, 'query')]"));
        searchField.sendKeys("selenium");

        //find element by contains method using text method
        WebElement element = driver.findElement(By.xpath("//input[contains(text(), 'usages')]"));
        String actualText = element.getText();

        Assert.assertNotEquals(actualText, "text");
    }

    @Test 
    public void findElementByXpathPositionMethod() {
        driver.get("https://mvnrepository.com/");

        //find element by id
        WebElement searchField = driver.findElement(By.xpath("//input[position()=1]"));
        searchField.sendKeys("selenium");
    }

    @Test 
    public void findElementByXpathTextMethod() {
        driver.get("https://mvnrepository.com/");

        //find element by id
        WebElement searchField = driver.findElement(By.xpath("//input[contains(@id, 'query')]"));
        searchField.sendKeys("selenium");

        //find element by id
        WebElement element = driver.findElement(By.xpath("//input[text()='Selenium Java']"));
        element.click();
    }

    @Test 
    public void findElementByXpathFollowingSibling() {
        driver.get("https://mvnrepository.com/");

        //find element by id
        WebElement searchField = driver.findElement(By.xpath("//input[contains(@id, 'query')]"));
        searchField.sendKeys("selenium");

        //find element by id
        WebElement usageElement = driver.findElement(By.xpath("//a[text()='Selenium Java']/following-sibling::a[.='1,839 usages']"));
        String actualUsageElementText = usageElement.getText();

        String expectedString = "1,839 usages";

        Assert.assertEquals(expectedString, actualUsageElementText);
    }

    @Test 
    public void findElementByXpathMultipleElementsOrMethod() {
        driver.get("https://mvnrepository.com/");

        //find element by id
        WebElement searchField = driver.findElement(By.xpath("//input[contains(@id, 'query')]"));
        searchField.sendKeys("selenium");

        //find element by id
        List<WebElement> elements = driver.findElements(By.xpath("//a[@class='im-usage'] | //p[@class='im-subtitle']"));

        for(WebElement element: elements) {
            System.out.println(element.getText());
        }

        for(int index = 0; index < elements.size(); index++) {
            System.out.println(elements.get(index).getText());
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

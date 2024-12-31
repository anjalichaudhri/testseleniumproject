package com.qa.seleniumproject.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.seleniumproject.base.BrowserFactory;
import com.qa.seleniumproject.utils.ConfigReader;
import com.qa.seleniumproject.utils.FileUtils;

public class FileHandlingPageTest {
    WebDriver driver;
    FileUtils fileUtils;

    String downloadDir = System.getProperty("user.dir") + "\\src\\test\\java\\com\\qa\\seleniumproject\\resourses\\download";
    String downloadFileName = "bb.txt";

    @BeforeMethod
    public void setup() {
        // configuration files
        String browser = ConfigReader.getProperty("browser");
        String baseUrl = ConfigReader.getProperty("herokuappUrl");

        // Configure ChromeOptions for file download
        ChromeOptions chromeOptions= FileUtils.configureChromeDownload(downloadDir);
        driver = BrowserFactory.getFactoryDriver(browser, chromeOptions); // driver instantiation.
        
        // instantiate file utils
        fileUtils = new FileUtils(driver);

        // open website
        driver.get(baseUrl);
    }

    @Test
    public void fileUploadTest() {

        // get the current directory of the project
        String uploadFilePath = System.getProperty("user.dir")
                + "\\src\\test\\java\\com\\qa\\seleniumproject\\resourses\\upload\\myFile.txt";
        System.out.println("Current Directory: " + uploadFilePath);

        fileUtils.uploadFile(By.id("file-upload"), uploadFilePath);
        driver.findElement(By.id("file-submit")).click();

        // Validate upload success
        WebElement uploadedFile = driver.findElement(By.id("uploaded-files"));
        if (uploadedFile.getText().equals("myFile.txt")) {
            System.out.println("File upload successful.");
        } else {
            System.out.println("File upload failed.");
        }
    }

    @Test
    public void fileDownloadTest() throws InterruptedException {
        // Test File Download

        // delete pre existing file with same name
        fileUtils.deletePreExistingFile(downloadDir, downloadFileName);

        // Navigate to the test website
        driver.get("https://the-internet.herokuapp.com/download");

        // download file and validate file location
        fileUtils.downloadFile(downloadFileName, downloadDir);
        
        // Wait for download to complete (manual validation)
        // System.out.println("File download initiated. Check the download directory: " + downloadDir);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

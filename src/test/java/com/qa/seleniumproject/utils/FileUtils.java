package com.qa.seleniumproject.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

public class FileUtils {
    private WebDriver driver;

    public FileUtils(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Uploads a file by sending the file path to an input element.
     *
     * @param locator The locator of the file input element.
     * @param filePath The absolute path of the file to upload.
     */
    public void uploadFile(By locator, String filePath) {
        WebElement fileInput = driver.findElement(locator);
        fileInput.sendKeys(filePath);
    }

    /**
     * Configures Chrome browser preferences for file download.
     *
     * @param downloadDir The directory where files should be downloaded.
     * @return ChromeOptions with the configured preferences.
     */
    public static ChromeOptions configureChromeDownload(String downloadDir) {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", Paths.get(downloadDir).toAbsolutePath().toString());
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.directory_upgrade", true);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        return options;
    }

    public void deletePreExistingFile(String downloadDir, String fileName) {
        // Define the download directory
        Path downloadedFilePath = Path.of(downloadDir, fileName);

        // Handle pre-existing file with the same name
        try {
            if (Files.exists(downloadedFilePath)) {
                Files.delete(downloadedFilePath); // Delete the existing file
                System.out.println("Existing file deleted: " + downloadedFilePath);
            }
        } catch (IOException e) {
            System.err.println("Error deleting existing file: " + e.getMessage());
            return; // Exit if the file cannot be deleted
        }
    }

    public void downloadFile(String downloadFileName, String downloadDir){
        try {
            // Trigger file download by clicking the download link
            driver.findElement(By.linkText(downloadFileName)).click();

            // Wait for the file to download (simple wait or advanced validation)
            Path downloadedFilePath = Path.of(downloadDir, downloadFileName);
            
            int maxWaitTimeInSeconds = 10; // Max time to wait for the file download
            for (int i = 0; i < maxWaitTimeInSeconds; i++) {
                if (Files.exists(downloadedFilePath)) {
                    System.out.println("File downloaded successfully: " + downloadedFilePath);
                    break;
                }
                Thread.sleep(1000); // Wait for 1 second
            }

            // Check if file was not downloaded within the time limit
            if (!Files.exists(downloadedFilePath)) {
                System.out.println("File download failed or took too long." + downloadedFilePath);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

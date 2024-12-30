package com.qa.seleniumproject.utils;

import org.openqa.selenium.Alert;
// import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;

public class AlertUtils {
    private WebDriver driver;
    WaitUtils waitUtils;
    Alert alert;
    String alertText;

    public AlertUtils(WebDriver driver) {
        this.driver = driver;
    }

    // handle simple alert
    public String handleSimpleAlert() {
        alert = driver.switchTo().alert();
        alertText = alert.getText();
        alert.accept();

        return alertText;
    }  
    
    // handle confirmation alert with ok and cancel
    public String handleConfirmationAlert(boolean accept) {
        alert = driver.switchTo().alert();
        alertText = alert.getText();

        if(accept) {
            alert.accept();
        }else{
            alert.dismiss();
        }

        return alertText;
    }

    // handle a prompt alert
    public String handlePromptAlert(String inputText, boolean accept) {
        alert = driver.switchTo().alert();
        alertText = alert.getText();
        alert.sendKeys(inputText);

        if(accept) {
            alert.accept();
        }else {
            alert.dismiss();
        }

        return alertText;
    }

    // handle a prompt alert
    public String handleTimerAlert() {
        waitUtils = new WaitUtils(driver, 10);
        
        alert = waitUtils.waitForAlertToBePresent();

        alertText = alert.getText();
        alert.accept();
        
        // if(accept) {
        //     alert.accept();
        // }else {
        //     alert.dismiss();
        // }

        return alertText;
    }
}

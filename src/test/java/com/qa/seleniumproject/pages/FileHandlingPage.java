package com.qa.seleniumproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileHandlingPage extends BasePage {

    // Web elements with @FindBy annotations
    @FindBy(id = "file-upload")
    private WebElement fileUploadInputField;

    @FindBy(id = "file-submit")
    private WebElement fileSubmitButton;

    @FindBy(id = "uploaded-files")
    private WebElement uploadedFilesElement;

    public FileHandlingPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFileInputElement() {
        return fileUploadInputField;
    }

    public WebElement getFileSubmitElement() {
        return fileSubmitButton;
    }

    public void clickFileSubmitButton() {
        fileSubmitButton.click();
    }

    public WebElement getFileUploadVerificationElement() {
        return uploadedFilesElement;
    }





    // FOR REFERENCE:--------------------------------------------------------------------------------
    // @FindBy(id = "username") // Using ID
    // private WebElement usernameField;

    // @FindBy(name = "password") // Using Name
    // private WebElement passwordField;

    // @FindBy(className = "login-btn") // Using Class Name
    // private WebElement loginButton;

    // @FindBy(css = "button[type='submit']") // Using CSS Selector
    // private WebElement submitButton;

    // @FindBy(xpath = "//div[@id='flash']") // Using XPath
    // private WebElement flashMessage;

    // @FindBy(tagName = "a") // Using Tag Name
    // private WebElement firstLink;

    // @FindBy(linkText = "Forgot Password?") // Using Link Text
    // private WebElement forgotPasswordLink;

    // @FindBy(partialLinkText = "Forgot") // Using Partial Link Text
    // private WebElement partialForgotLink;
    //-------------------------------------------------------------------------------------------------
}

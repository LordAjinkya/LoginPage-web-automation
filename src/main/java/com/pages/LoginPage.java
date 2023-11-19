package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
	
		
	WebDriver driver;

    // Constructor to initialize the WebDriver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By usernameField = By.name("user-name");
    private final By passwordField = By.name("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.xpath("//*[@id=\"login_button_container\"]/div/form/h3");

    // Methods for interaction with the page

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

}

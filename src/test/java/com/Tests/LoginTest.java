package com.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest{
	WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        // Set up WebDriver and open the application
//    	ChromeOptions options = new ChromeOptions();
//    	options.setBinary("C:\\Users\\Dell1\\Downloads\\chrome-win64");
//    	WebDriver driver = new ChromeDriver(options);
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell1\\Downloads\\chromedriver-win64");
    	WebDriverManager.chromedriver();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");
        

        // Initialize Page Object
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority=1)
    public void loginWithValidCredentials() {
        loginPage.login("standard_user", "secret_sauce");

       
    }

    @Test(priority=2)
    public void loginWithInvalidCredentials() {
        loginPage.login("standard", "secret");

        // Verify that an error message is displayed
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, "Epic sadface: Username and password do not match any user in this service");
    }

    @Test(priority=3)
    public void loginWithEmptyFields() {
        loginPage.login("", "");

        // Verify that an error message is displayed for empty fields
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, "Epic sadface: Username is required");
    }
    
    @Test(priority=4)
    public void loginWithInvalidUsername() {
        loginPage.login("standard", "secret_sauce");

        // Verify that an error message is displayed for an invalid username
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, "Epic sadface: Username and password do not match any user in this service");
    }

    @Test(priority=5)
    public void loginWithInvalidPassword() {
        loginPage.login("standard_user", "secret");

        // Verify that an error message is displayed for an invalid password
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, "Epic sadface: Username and password do not match any user in this service");
    }

    @Test(priority=6)
    public void loginWithIncorrectCredentialsMultipleTimes() {
        // Attempt to log in with incorrect credentials multiple times
        for (int i = 0; i < 3; i++) {
            loginPage.login("standard", "secret");

            // Verify error message
            String actualErrorMessage = loginPage.getErrorMessage();
            Assert.assertEquals(actualErrorMessage, "Epic sadface: Username and password do not match any user in this service");
        }
    }

}

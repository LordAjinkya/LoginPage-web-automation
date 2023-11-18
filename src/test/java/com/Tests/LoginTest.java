package com.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.LoginPage;

public class LoginTest{
	WebDriver driver;
    LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        // Set up WebDriver and open the application
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell1\\Downloads\\chromedriver-win64\\chromedriver-win64");
        driver = new ChromeDriver();
        driver.get("https://classic.freecrm.com/");

        // Initialize Page Object
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void loginWithValidCredentials() {
        loginPage.login("validUsername", "validPassword");

       
    }

    @Test
    public void loginWithInvalidCredentials() {
        loginPage.login("invalidUsername", "invalidPassword");

        // Verify that an error message is displayed
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, "Invalid credentials. Please try again.");
    }

    @Test
    public void loginWithEmptyFields() {
        loginPage.login("", "");

        // Verify that an error message is displayed for empty fields
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, "Username and password are required.");
    }
    
    @Test
    public void loginWithInvalidUsername() {
        loginPage.login("invalidUsername", "validPassword");

        // Verify that an error message is displayed for an invalid username
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, "Invalid username. Please try again.");
    }

    @Test
    public void loginWithInvalidPassword() {
        loginPage.login("validUsername", "invalidPassword");

        // Verify that an error message is displayed for an invalid password
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, "Invalid password. Please try again.");
    }

    @Test
    public void loginWithIncorrectCredentialsMultipleTimes() {
        // Attempt to log in with incorrect credentials multiple times
        for (int i = 0; i < 3; i++) {
            loginPage.login("invalidUsername", "invalidPassword");

            // Verify error message
            String actualErrorMessage = loginPage.getErrorMessage();
            Assert.assertEquals(actualErrorMessage, "Invalid credentials. Please try again.");
        }
    }

}

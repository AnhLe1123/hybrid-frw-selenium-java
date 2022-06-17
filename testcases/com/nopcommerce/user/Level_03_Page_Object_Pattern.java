package com.nopcommerce.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Level_03_Page_Object_Pattern {
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private String projectPath = System.getProperty("user.dir");
    private String firstName, lastName, validEmailAddress, validPassword, invalidEmail, invalidPassword;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        firstName = "Automation";
        lastName = "Testing";
        validEmailAddress = "autotest" + generateNumber() + "@mail.com";
        validPassword = "123456";
        invalidEmail = "abc@";
        invalidPassword = "123";

        driver.get("https://demo.nopcommerce.com/");
        homePage = new HomePageObject(driver);
        registerPage = new RegisterPageObject(driver);
    }

    @Test
    public void User_01_Register_With_Empty_Data() {
        System.out.println("HomePage - Step 01: Click to Register link");
        homePage.clickToRegisterLink();

        System.out.println("RegisterPage - Step 02: Click to Register button");
        registerPage.clickToRegisterButton();

        System.out.println("RegisterPage - Step 03: Verify error messages displayed");
        Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
        Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
        Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");
        Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");
        Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");
    }

    @Test
    public void User_02_Register_With_Invalid_Email() {
        System.out.println("HomePage - Step 01: Click to Register link");
        homePage.clickToRegisterLink();

        System.out.println("RegisterPage - Step 02: Input to Email textbox with value: " + invalidEmail);
        registerPage.inputToEmailTextbox(invalidEmail);

        System.out.println("RegisterPage - Step 03: Click to Register button");
        registerPage.clickToRegisterButton();

        System.out.println("RegisterPage - Step 04: Verify error messages displayed");
        Assert.assertEquals(registerPage.getEmailErrorMessage(), "Wrong email");
    }

    @Test
    public void User_03_Register_With_Valid_Info() {
        System.out.println("HomePage - Step 01: Click to Register link");
        homePage.clickToRegisterLink();

        System.out.println("RegisterPage - Step 02: Input to Firstname textbox with value: " + firstName);
        registerPage.inputToFirstNameTextbox(firstName);

        System.out.println("RegisterPage - Step 03: Input to LastName textbox with value: " + lastName);
        registerPage.inputToLastNameTextbox(lastName);

        System.out.println("RegisterPage - Step 04: Input to Email textbox with value: " + validEmailAddress);
        registerPage.inputToEmailTextbox(validEmailAddress);

        System.out.println("RegisterPage - Step 05: Input to Password textbox with value: " + validPassword);
        registerPage.inputToPasswordTextbox(validPassword);

        System.out.println("RegisterPage - Step 06: Input to ConfirmPassword textbox with value: " + validPassword);
        registerPage.inputToConfirmPasswordTextbox(validPassword);

        System.out.println("RegisterPage - Step 07: Click to Register button");
        registerPage.clickToRegisterButton();

        System.out.println("RegisterPage - Step 08: Verify register success messages displayed");
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

        System.out.println("RegisterPage - Step 08: Click to Logout link");
        registerPage.clickToLogoutLink();
    }

    @Test
    public void User_04_Register_With_Existing_Email() {
        System.out.println("HomePage - Step 01: Click to Register link");
        homePage.clickToRegisterLink();

        System.out.println("RegisterPage - Step 02: Input to Firstname textbox with value: " + firstName);
        registerPage.inputToFirstNameTextbox(firstName);

        System.out.println("RegisterPage - Step 03: Input to LastName textbox with value: " + lastName);
        registerPage.inputToLastNameTextbox(lastName);

        System.out.println("RegisterPage - Step 04: Input to Email textbox with value: " + validEmailAddress);
        registerPage.inputToEmailTextbox(validEmailAddress);

        System.out.println("RegisterPage - Step 05: Input to Password textbox with value: " + validPassword);
        registerPage.inputToPasswordTextbox(validPassword);

        System.out.println("RegisterPage - Step 06: Input to ConfirmPassword textbox with value: " + validPassword);
        registerPage.inputToConfirmPasswordTextbox(validPassword);

        System.out.println("RegisterPage - Step 07: Click to Register button");
        registerPage.clickToRegisterButton();

        System.out.println("RegisterPage - Step 08: Verify existing email error messages displayed");
        Assert.assertEquals(registerPage.getExistingEmailErrorMessage(), "The specified email already exists");
    }

    @Test
    public void User_05_Register_With_Password_Less_Than_6_Chars() {
        System.out.println("HomePage - Step 01: Click to Register link");
        homePage.clickToRegisterLink();

        System.out.println("RegisterPage - Step 02: Input to Password textbox with value: " + invalidPassword);
        registerPage.inputToPasswordTextbox(invalidPassword);

        System.out.println("RegisterPage - Step 03: Click to Register button");
        registerPage.clickToRegisterButton();

        System.out.println("RegisterPage - Step 04: Verify error messages displayed");
        Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password must meet the following rules:\nmust have at least 6 characters");
    }

    @Test
    public void User_06_Register_With_Unmatched_Confirm_Password() {
        System.out.println("HomePage - Step 01: Click to Register link");
        homePage.clickToRegisterLink();

        System.out.println("RegisterPage - Step 02: Input to Password textbox with value: " + validPassword);
        registerPage.inputToPasswordTextbox(validPassword);

        System.out.println("RegisterPage - Step 03: Input to Confirm Password textbox with value: 654321");
        registerPage.inputToConfirmPasswordTextbox("654321");

        System.out.println("RegisterPage - Step 04: Click to Register button");
        registerPage.clickToRegisterButton();

        System.out.println("RegisterPage - Step 05: Verify error messages displayed");
        Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "The password and confirmation password do not match.");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public int generateNumber() {
        Random rand = new Random();
        return rand.nextInt(9999);
    }
}

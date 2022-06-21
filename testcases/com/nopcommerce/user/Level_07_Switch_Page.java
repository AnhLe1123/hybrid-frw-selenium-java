package com.nopcommerce.user;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.*;

import java.util.Random;

public class Level_07_Switch_Page extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObject loginPage;
    private OrdersPageObject ordersPage;
    private RegisterPageObject registerPage;
    private AddressesPageObject addressesPage;
    private RewardPointsPageObject rewardPointsPage;
    private CustomerInfoPageObject customerInfoPage;
    private String firstName, lastName, emailAddress, password;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);
        firstName = "Automation";
        lastName = "Testing";
        emailAddress = "autotest" + generateNumber() + "@mail.com";
        password = "123456";
    }

    @Test
    public void User_01_Register() {
        registerPage = homePage.clickToRegisterLink();
        registerPage.inputToFirstNameTextbox(firstName);
        registerPage.inputToLastNameTextbox(lastName);
        registerPage.inputToEmailTextbox(emailAddress);
        registerPage.inputToPasswordTextbox(password);
        registerPage.inputToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
        homePage = registerPage.clickToLogoutLink();
    }

    @Test
    public void User_02_Login() {
        loginPage = homePage.clickToLoginLink();
        loginPage.inputToEmailTextbox(emailAddress);
        loginPage.inputToPasswordTextbox(password);
        homePage = loginPage.clickToLoginButton();
        Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
        customerInfoPage = homePage.clickToMyAccountLink();
        Assert.assertEquals(customerInfoPage.getPageHeader(), "My account - Customer info");
    }

    @Test
    public void User_03_Switch_Page() {
        addressesPage = customerInfoPage.openAddressesPage(driver);
        ordersPage = addressesPage.openOrdersPage(driver);
        rewardPointsPage = ordersPage.openRewardPointsPage(driver);
        addressesPage = rewardPointsPage.openAddressesPage(driver);
        customerInfoPage = addressesPage.openCustomerInfoPage(driver);
        rewardPointsPage = customerInfoPage.openRewardPointsPage(driver);
        ordersPage = rewardPointsPage.openOrdersPage(driver);
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

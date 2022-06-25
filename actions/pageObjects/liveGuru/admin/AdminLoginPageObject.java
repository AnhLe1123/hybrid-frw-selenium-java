package pageObjects.liveGuru.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.liveGuru.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
    private WebDriver driver;

    public AdminLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToUserNameTextbox(String adminUserName) {
        waitForElementVisible(driver, AdminLoginPageUI.USERNAME_TEXTBOX);
        sendkeyToElement(driver, AdminLoginPageUI.USERNAME_TEXTBOX, adminUserName);
    }

    public void inputToPasswordTextbox(String adminPassword) {
        waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, adminPassword);
    }

    public AdminManageCustomersPageObject clickToLoginButton() {
        waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
        return AdminPageGeneratorManager.getAdminManageCustomersPage(driver);
    }
}

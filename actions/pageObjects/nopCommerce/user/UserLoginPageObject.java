package pageObjects.nopCommerce.user;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
    private WebDriver driver;

    public UserLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public UserHomePageObject clickToLoginButton() {
        waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getUserHomePage(driver);
    }

    public String getErrorMessageAtEmailTextbox() {
        waitForElementVisible(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
        return getWebElementText(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
    }

    public void clickToLoginLink() {
        waitForElementClickable(driver, UserLoginPageUI.LOGIN_LINK);
        clickToElement(driver, UserLoginPageUI.LOGIN_LINK);
    }

    public void inputToEmailTextbox(String email) {
        waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, email);
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public String getUnsuccessfulErrorMessage() {
        waitForElementVisible(driver, UserLoginPageUI.UNSUCCESS_ERROR_MESSAGE);
        return getWebElementText(driver, UserLoginPageUI.UNSUCCESS_ERROR_MESSAGE);
    }

    public UserHomePageObject loginAsUser(String email, String password) {
        inputToEmailTextbox(email);
        inputToPasswordTextbox(password);
        return clickToLoginButton();
    }
}

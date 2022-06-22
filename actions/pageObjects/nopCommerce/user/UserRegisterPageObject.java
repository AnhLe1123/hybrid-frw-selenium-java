package pageObjects.nopCommerce.user;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.user.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
    private WebDriver driver;

    public UserRegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
    }

    public String getFirstNameErrorMessage() {
        waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
        return getWebElementText(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
    }

    public String getLastNameErrorMessage() {
        waitForElementVisible(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
        return getWebElementText(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
    }

    public String getEmailErrorMessage() {
        waitForElementVisible(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
        return getWebElementText(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
    }

    public String getPasswordErrorMessage() {
        waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
        return getWebElementText(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
    }

    public String getConfirmPasswordErrorMessage() {
        waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
        return getWebElementText(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
    }

    public void inputToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    public void inputToFirstNameTextbox(String firstName) {
        waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void inputToLastNameTextbox(String lastName) {
        waitForElementVisible(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX, lastName);
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    public void inputToConfirmPasswordTextbox(String password) {
        waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
    }

    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
        return getWebElementText(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public String getExistingEmailErrorMessage() {
        waitForElementVisible(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
        return getWebElementText(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
    }

    public void clickToRegisterLink() {
        waitForElementClickable(driver, UserRegisterPageUI.REGISTER_LINK);
        clickToElement(driver, UserRegisterPageUI.REGISTER_LINK);
    }
}

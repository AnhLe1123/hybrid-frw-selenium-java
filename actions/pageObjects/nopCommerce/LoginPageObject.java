package pageObjects.nopCommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public HomePageObject clickToLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getHomePage(driver);
    }

    public String getErrorMessageAtEmailTextbox() {
        waitForElementVisible(driver,LoginPageUI.EMAIL_ERROR_MESSAGE);
        return getWebElementText(driver,LoginPageUI.EMAIL_ERROR_MESSAGE);
    }

    public void clickToLoginLink() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_LINK);
        clickToElement(driver, LoginPageUI.LOGIN_LINK);
    }

    public void inputToEmailTextbox(String email) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public String getUnsuccessfulErrorMessage() {
        waitForElementVisible(driver,LoginPageUI.UNSUCCESS_ERROR_MESSAGE);
        return getWebElementText(driver,LoginPageUI.UNSUCCESS_ERROR_MESSAGE);
    }
}

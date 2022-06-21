package pageObjects.nopCommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.CustomerInfoPageUI;
import pageUIs.HomePageUI;

public class CustomerInfoPageObject extends BasePage {
    private WebDriver driver;

    public CustomerInfoPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageHeader() {
        waitForElementVisible(driver, CustomerInfoPageUI.PAGE_TITLE);
        return getWebElementText(driver, CustomerInfoPageUI.PAGE_TITLE);
    }
}

package pageObjects.jQuery;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jQuery.HomePageUI;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void openPagingByPageNumber(String pageNumber) {
        waitForElementClickable(driver, HomePageUI.PAGING_BY_PAGE_NUMBER, pageNumber);
        clickToElement(driver, HomePageUI.PAGING_BY_PAGE_NUMBER, pageNumber);
    }

    public boolean isActivePageByNumber(String pageNumber) {
        waitForElementVisible(driver, HomePageUI.PAGING_ACTIVE_BY_PAGE_NUMBER, pageNumber);
        return isElementDisplayed(driver, HomePageUI.PAGING_ACTIVE_BY_PAGE_NUMBER, pageNumber);
    }

    public void inputToHeaderTextboxByField(String fieldName, String value) {
        waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_FIELD_NAME, fieldName);
        sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_FIELD_NAME, value, fieldName);
        pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_FIELD_NAME, Keys.ENTER, fieldName);
    }

    public Set<String> getValuesAtColumnByKey(String countryName) {
        waitForAllElementsVisible(driver, HomePageUI.PAGINATIONS);
        int pagesSize = getWebElementSize(driver, HomePageUI.PAGINATIONS);
        Set<String> valuesAtAllPages = new HashSet<>();

        for (int i = 1; i <= pagesSize; i++) {
            waitForElementClickable(driver, HomePageUI.PAGING_BY_INDEX, String.valueOf(i));
            clickToElement(driver, HomePageUI.PAGING_BY_INDEX, String.valueOf(i));

            List<WebElement> allValuesAtEachPage = getListWebElement(driver, HomePageUI.VALUES_AT_COLUMN_KEY, countryName);
            for (WebElement element: allValuesAtEachPage) {
                valuesAtAllPages.add(element.getText());
                System.out.println(element.getText());
            }
        }
        return valuesAtAllPages;
    }
}

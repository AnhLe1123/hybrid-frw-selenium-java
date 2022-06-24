package com.jquery.datatable;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;

import java.util.Random;
import java.util.Set;

public class Level_10_DataTable_DataGrid extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private Set<String> actualCountries;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String pageUrl) {
        driver = getBrowserDriver(browserName, pageUrl);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void Table_01_Paging() {
        homePage.openPagingByPageNumber("5");
        Assert.assertTrue(homePage.isActivePageByNumber("5"));
        homePage.sleepInSecond(1);

        homePage.openPagingByPageNumber("10");
        Assert.assertTrue(homePage.isActivePageByNumber("10"));
        homePage.sleepInSecond(1);

        homePage.openPagingByPageNumber("15");
        Assert.assertTrue(homePage.isActivePageByNumber("15"));
        homePage.sleepInSecond(1);

        homePage.openPagingByPageNumber("20");
        Assert.assertTrue(homePage.isActivePageByNumber("20"));
        homePage.sleepInSecond(1);
    }

    @Test
    public void Table_02_Enter_To_Header() {
        homePage.refreshCurrentPage(driver);
        homePage.inputToHeaderTextboxByField("Country", "Argentina");
        homePage.inputToHeaderTextboxByField("Females", "338282");
        homePage.inputToHeaderTextboxByField("Males", "349238");
        homePage.inputToHeaderTextboxByField("Total", "687522");
        homePage.sleepInSecond(2);
    }

    @Test
    public void Table_03_Get_Table_Values() {
        homePage.refreshCurrentPage(driver);
        actualCountries = homePage.getValuesAtColumnByKey("country");
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

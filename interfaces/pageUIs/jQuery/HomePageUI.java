package pageUIs.jQuery;

public class HomePageUI {
    public static final String PAGING_BY_PAGE_NUMBER = "xpath=//li[@class='qgrd-pagination-page']//a[text()='%s']";
    public static final String PAGING_ACTIVE_BY_PAGE_NUMBER = "xpath=//a[@class='qgrd-pagination-page-link active' and text()='%s']";
    public static final String HEADER_TEXTBOX_BY_FIELD_NAME = "xpath=//div[@class='qgrd-header-text' and text()='%s']//parent::div//following-sibling::input";
    public static final String PAGINATIONS = "xpath=//ul[@class='qgrd-pagination-ul']//li";
    public static final String PAGING_BY_INDEX = "xpath=//ul[@class='qgrd-pagination-ul']//li[%s]//a";
    public static final String VALUES_AT_COLUMN_KEY = "xpath=//tr//td[@data-key='%s']";
}

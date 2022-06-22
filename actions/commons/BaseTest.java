package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;

    protected WebDriver getBrowserDriver(String browserName) {
        if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browserName.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        } else if (browserName.equals("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();

        } else if (browserName.equals("brave")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            if (GlobalConstants.OS_NAME.contains("Mac")) {
                options.setBinary("/Applications/Brave Browser.app/Contents/MacOS/Brave Browser");
            }
            driver = new ChromeDriver(options);

        } else if (browserName.equals("CocCoc")) {
            WebDriverManager.chromedriver().driverVersion("101.0.4951.15").setup();
            ChromeOptions options = new ChromeOptions();
            if (GlobalConstants.OS_NAME.contains("Mac")) {
                options.setBinary("/Applications/CocCoc.app/Contents/MacOS/CocCoc");
            }
            driver = new ChromeDriver(options);

        } else if (browserName.equals("h_chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(true);
            options.addArguments("window-size=1920x1080");
            driver = new ChromeDriver(options);

        } else if (browserName.equals("h_firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(true);
            options.addArguments("window-size=1920x1080");
            driver = new FirefoxDriver(options);

        } else {
            throw new RuntimeException("Invalid browser driver");
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");

        return driver;
    }

    protected WebDriver getBrowserDriver(String browserName, String environmentName) {
        if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browserName.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        } else if (browserName.equals("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();

        } else if (browserName.equals("brave")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            if (GlobalConstants.OS_NAME.contains("Mac")) {
                options.setBinary("/Applications/Brave Browser.app/Contents/MacOS/Brave Browser");
            }
            driver = new ChromeDriver(options);

        } else if (browserName.equals("CocCoc")) {
            WebDriverManager.chromedriver().driverVersion("101.0.4951.15").setup();
            ChromeOptions options = new ChromeOptions();
            if (GlobalConstants.OS_NAME.contains("Mac")) {
                options.setBinary("/Applications/CocCoc.app/Contents/MacOS/CocCoc");
            }
            driver = new ChromeDriver(options);

        } else if (browserName.equals("h_chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(true);
            options.addArguments("window-size=1920x1080");
            driver = new ChromeDriver(options);

        } else if (browserName.equals("h_firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(true);
            options.addArguments("window-size=1920x1080");
            driver = new FirefoxDriver(options);

        } else {
            throw new RuntimeException("Invalid browser driver");
        }

        driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(getPageUrlByEnv(environmentName));

        return driver;
    }

    private String getPageUrlByEnv(String environmentName) {
        switch (environmentName) {
            case "DEV":
                return GlobalConstants.DEV_USER_PAGE_URL;
            case "TESTING":
                return GlobalConstants.TESTING_USER_PAGE_URL;
            case "STAGING":
                return GlobalConstants.STAGING_USER_PAGE_URL;
            default:
                throw new RuntimeException("Invalid environment");
        }
    }
}

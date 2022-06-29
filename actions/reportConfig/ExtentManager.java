package reportConfig;

import java.io.File;

import commons.GlobalConstants;
import org.openqa.selenium.Platform;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;
    private static Platform platform;
    private static String reportFileName = "ExtentReportV3Results.html";
    private static String reportFileLoc = GlobalConstants.EXTENT_REPORT_V3 + reportFileName;

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }

    // Create an extent report instance
    public static ExtentReports createInstance() {
        String fileName = getReportFileLocation();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("Bank Guru HTML Report");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Bank Guru HTML Report");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        return extent;
    }

    // Select the extent report file location
    private static String getReportFileLocation() {
        createReportPath(GlobalConstants.EXTENT_REPORT_V3);
        return reportFileLoc;
    }

    // Create the report path if it does not exist
    private static void createReportPath(String path) {
        File testDirectory = new File(path);
        if (!testDirectory.exists()) {
            if (testDirectory.mkdir()) {
                System.out.println("Directory: " + path + " is created!");
            } else {
                System.out.println("Failed to create directory: " + path);
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
    }
}

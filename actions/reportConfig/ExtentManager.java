package reportConfig;

import com.relevantcodes.extentreports.ExtentReports;
import commons.GlobalConstants;

public class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            extent = new ExtentReports(GlobalConstants.PROJECT_PATH + "/ExtentReportV2/ExtentReportV2Results.html", true);
        }
        return extent;
    }
}

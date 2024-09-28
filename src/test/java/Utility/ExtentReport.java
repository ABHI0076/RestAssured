package Utility;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.api.RestAssuredTraining.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	public static ExtentReports report=null;
	public ExtentTest test=null;
	
	
	// Initialize the Extent report classes.
	@BeforeSuite
	public void initializeReporter() {

		if (report == null) {
			report = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(BaseTest.getProperties().getProperty("ExtentReport_Path"));
			spark.config().setDocumentTitle("Test Result");
			spark.config().setReportName("Automation Test Report");
			report.attachReporter(spark);
			report.setSystemInfo("os", "Windows");

		}
	}

	// Flush the report.
	@AfterSuite
	public void flushReport() {
		report.flush();
	}

}

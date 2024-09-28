package com.api.RestAssuredTraining;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utility.ExtentReport;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseTest extends ExtentReport{
	
	static public FileInputStream fis = null;
	static public Properties prop = null;

	public Logger logger = null;

	static RequestSpecBuilder builder = null;
	static RequestSpecification reqSpec = null;
	static String card_Id = null;

	// Initialize logger and test classes.
	@BeforeClass
	public void setLoggerAndCreateTest() {
		
		logger = LogManager.getLogger(this.getClass().getName());
		test = report.createTest(this.getClass().getName());
	}

	// Setting up the prerequisites which are common for all the request.
	@BeforeSuite()
	public void setRequestSpecs() {
		
		if (builder == null) {
			builder = new RequestSpecBuilder();
			builder.setBaseUri(prop.getProperty("URL")).setContentType("application/json")
			.addQueryParam("key", prop.getProperty("Key")).addQueryParam("token",
					prop.getProperty("Token"));

			reqSpec = builder.build();
		}
		
		
	}
	
	// Logging the test status in the extent report.
	@AfterMethod
	public void ststusOfTest(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() +" <b>PASSED</b>", ExtentColor.GREEN));
		}else if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() +" <b>FAILED</b>", ExtentColor.RED));
		}else if(result.getStatus()==ITestResult.SKIP){
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() +" <b>SKIPPED</b>", ExtentColor.YELLOW));
		}
	}
	
	public static Properties getProperties() {
		if(fis==null) {
			try {
				fis= new FileInputStream(System.getProperty("user.dir")+"/Data/data.properties");
				prop = new Properties();
				prop.load(fis);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return prop;
	}

}

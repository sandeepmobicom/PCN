package com.mobicom.tests;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.mobicom.helpers.GetDriver;

public class BaseTest {
	WebDriver driver;
	ExtentReports extent;
	ExtentTest logger;

	public void initTest(String testName) throws MalformedURLException {
		driver = GetDriver.returnDriver(testName);
		extent = GetDriver.returnExtent();
	}

	@BeforeMethod
	public void beginTest(Method method) {
		logger = extent.createTest(method.getName(), this.getClass().getSimpleName());
	}

	@AfterMethod
	public void exportReports(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, "Test case failed is " + result.getName());
			logger.log(Status.FAIL, "Failure exeption is " + result.getThrowable());
			logger.log(Status.INFO, "Test Class: " + this.getClass().toGenericString());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, "Test case passed is " + result.getName());
			logger.log(Status.INFO, "Test Class: " + this.getClass().getCanonicalName());
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP, "Test case skipped is " + result.getName());
			logger.log(Status.INFO, "Test Class: " + this.getClass().toGenericString());
		}
	}

}
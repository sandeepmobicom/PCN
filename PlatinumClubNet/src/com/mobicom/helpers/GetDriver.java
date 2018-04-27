package com.mobicom.helpers;

import java.io.File;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class GetDriver {

	public static WebDriver driver;
	public static ExtentReports extent;
	static ExtentHtmlReporter htmlReporter;
	File filepath=new File("/Users/sandeep/Desktop/Report.html");
	static Logger log = Logger.getLogger(GetDriver.class);
	public static String activeTest = "";
	public static DesiredCapabilities caps;

	public static WebDriver returnDriver(String testName) throws MalformedURLException {
		if (driver == null || activeTest != testName) {
			getDriver(testName);
			activeTest = testName;
			driver.get("https://platinum-stage.oneclubnet.com/login");
			driver.manage().window().maximize();
			return driver;
		} else {
			activeTest = testName;
			return driver;
		}
	}
	
	public static ExtentReports returnExtent() throws MalformedURLException {
		if (extent == null) {
			getExtent();
			return extent;
		} else {
			return extent;
		}
	}

	public static void getDriver(String testName) throws MalformedURLException {
		switch (testName) {
		case "Chrome on mac":
			System.setProperty("webdriver.chrome.driver", "/Volumes/Development/MerchantCmsAutomation/chromedriver");
			driver = new ChromeDriver();
//			caps=DesiredCapabilities.chrome();
//			caps.setPlatform(Platform.MAC);
//			caps.setBrowserName("chrome");
//			driver=new RemoteWebDriver(new URL("http://192.168.0.103:4444/wd/hub"),caps);
			break;

		case "Firefox on mac":
			System.setProperty("webdriver.gecko.driver", "/Users/sandeep/Downloads/geckodriver");
			driver = new FirefoxDriver();
//			caps=DesiredCapabilities.firefox();
//			caps.setPlatform(Platform.MAC);
//			caps.setBrowserName("firefox");
//			driver=new RemoteWebDriver(new URL("http://192.168.0.103:4444/wd/hub"),caps);
			break;
			
		case "Safari on mac":
//			System.setProperty("webdriver.gecko.driver", "/Users/sandeep/Downloads/geckodriver");
			driver = new SafariDriver();
//			caps=DesiredCapabilities.firefox();
//			caps.setPlatform(Platform.MAC);
//			caps.setBrowserName("firefox");
//			driver=new RemoteWebDriver(new URL("http://192.168.0.103:4444/wd/hub"),caps);
			break;

		default:
			System.out.println("");
			break;
		}

	}
	
	public static void getExtent() {
		extent=new ExtentReports();
		extent.attachReporter(getHtmlReporter());
		extent.setSystemInfo("Host Name","Sandeep Shetty");
		extent.setSystemInfo("Environment", "Test Automation");
		extent.setSystemInfo("User", "Sandeep");
	}
	
	public static ExtentHtmlReporter getHtmlReporter() {
		htmlReporter=new ExtentHtmlReporter("/Users/sandeep/Desktop/Report.html");
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.setAppendExisting(false);
		htmlReporter.config().setDocumentTitle("Report");
		htmlReporter.config().setReportName("Automation Testing Report");
		return htmlReporter;
	}

}
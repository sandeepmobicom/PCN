package com.mobicom.helpers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;

public class Utility {
	protected static Logger log = Logger.getLogger(Utility.class);
	private static final double SLEEP_TIME = 1000;
	protected static WebDriver driver;

	public Utility(WebDriver driver) {
		Utility.driver = driver;
	}

	public static void nap(double duration) {
		try {
			Thread.sleep((int) (SLEEP_TIME * duration));
		} catch (InterruptedException e) {
			log.info("Sleep interrupted");
		}
	}

	public static void waitForElement(int timeUnits, By webElementName) {
		WebDriverWait wait = new WebDriverWait(driver, timeUnits);
		wait.until(ExpectedConditions.elementToBeClickable(webElementName));
	}

	public static void waitForElementVisible(int timeUnits, By webElementName) {
		WebDriverWait wait = new WebDriverWait(driver, timeUnits);
		wait.until(ExpectedConditions.visibilityOfElementLocated(webElementName));

	}

	public static WebElement findElement(By elementToBeFound) {
		waitForElement(10, elementToBeFound);
		return driver.findElement(elementToBeFound);
	}

	public static WebElement findElementVisible(By elementToBeFound) {
		waitForElementVisible(30, elementToBeFound);
		return driver.findElement(elementToBeFound);
	}

	public WebElement clickAnElement(By elementToBeClicked, By elementToBeReturned) {
		findElement(elementToBeClicked).click();
		return findElement(elementToBeReturned);
	}

	public static List<WebElement> getMultipleElements(By element) {
		return driver.findElements(element);
	}

	public static boolean isElementVisible(By elementToBeFound) {
		try {
			WebElement elementFound = findElementVisible(elementToBeFound);
			return elementFound.isDisplayed();
		} catch (TimeoutException e) {
			return false;
		}
	}

	public static boolean isElementDisplayed(By elementToBeFound) {
		try {
			return findElement(elementToBeFound).isDisplayed();
		} catch (TimeoutException e) {
			return false;
		}
	}
	
	public static void generateReport(ITestResult result,ExtentTest logger) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, "Test case failed is " + result.getName());
			logger.log(Status.FAIL, "Failure exeption is " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, "Test case passed is " + result.getName());
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP, "Test case skipped is " + result.getName());
		}
	}


}

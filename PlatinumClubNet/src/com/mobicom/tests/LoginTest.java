package com.mobicom.tests;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mobicom.helpers.Utility;
import com.mobicom.pages.LoginPage;

public class LoginTest extends BaseTest {
	LoginPage obj;

	@Parameters("testItem")
	@BeforeClass
	public void beforeTheClass(@Optional("Chrome on mac") String param) throws MalformedURLException {
		initTest(param);
		obj = new LoginPage(driver);
	}

	@DataProvider(name = "loginPageElements")
	public Object[][] getLoginPageelements() {
		Object[][] input = { { obj.username, "Username field not found" }, { obj.password, "Password field not found" },
				{ obj.loginButton, "Login button not found" } };
		return input;
	}

	@Test(priority = 1, dataProvider = "loginPageElements")
	public void testLoginPageElements(By element, String str) {
		assertTrue(Utility.isElementDisplayed(element), str);
	}

	@Test(priority = 2)
	public void loginToClub() {
		Utility.findElement(obj.username).sendKeys("royalmanor");
		Utility.findElement(obj.password).sendKeys("welcome");
		Utility.findElement(obj.loginButton).click();
		assertTrue(Utility.isElementDisplayed(obj.pageHeader), "Login failed");
	}

	@AfterTest
	public void endTest() {
		extent.flush();
		// driver.quit();
	}
}
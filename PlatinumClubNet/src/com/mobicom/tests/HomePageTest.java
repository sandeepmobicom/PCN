package com.mobicom.tests;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mobicom.helpers.Utility;
import com.mobicom.pages.LoginPage;

public class HomePageTest extends BaseTest {
	LoginPage loginObject;

	@Parameters("testItem")
	@BeforeClass
	public void beforeTheClass(@Optional("Chrome on Mac") String param) throws MalformedURLException {
		initTest(param);
		loginObject = new LoginPage(driver);
	}

	@DataProvider(name = "homePageElements")
	public Object[][] getHomePageelements() {
		Object[][] input = { { loginObject.pageHeader, "Page header not found" },
				{ loginObject.yearFoundedLabel, "Year founded label not found" },
				{ loginObject.yearFoundedValue, "Year founded value not found" } };
		return input;
	}

	@Test(priority = 51, dataProvider = "homePageElements")
	public void testHomePageElements(By element, String str) {
		assertTrue(Utility.isElementDisplayed(element), str);
	}

	@Test(priority = 52)
	public void clickDashboardInMenu() {
		Utility.findElement(loginObject.dashBoardMenu).click();
		assertTrue(Utility.isElementDisplayed(loginObject.dashBoardHeader), "Dashboard header not found");
		assertTrue(Utility.isElementDisplayed(loginObject.memberAccessDashBoardOption),
				"Member access bookings not found");
	}

	@Test(priority = 53)
	public void clickClubProfileInMenu() throws InterruptedException {
		Thread.sleep(2000);
		Utility.findElement(loginObject.myClubSubMenu).click();
		assertTrue(Utility.isElementDisplayed(loginObject.clubProfileMenu), "Club profile not found");
		assertTrue(Utility.isElementDisplayed(loginObject.clubFacilitiesSubMenu), "Club facilities not found in menu");
	}

	@Test(priority = 54)
	public void clickBasicInfoInMenu() {
		Utility.findElement(loginObject.clubProfileMenu).click();
		assertTrue(Utility.isElementDisplayed(loginObject.clubImage), "Club image not found");
		assertTrue(Utility.isElementDisplayed(loginObject.clubName), "Club name not found");
	}

	@Test(priority = 55, enabled=false)
	public void clickClubFacilitiesInMenu() {
		Utility.findElement(loginObject.clubProfileMenu).click();
		Utility.findElement(loginObject.clubFacilitiesSubMenu).click();
		assertTrue(Utility.isElementDisplayed(loginObject.clubFacilitiesTitle), "Club facilities not loaded");
	}

}

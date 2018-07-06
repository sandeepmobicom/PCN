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

public class ClubProfileTest extends BaseTest {
	LoginPage loginObject;

	@Parameters("testItem")
	@BeforeClass
	public void beforeTheClass(@Optional("Chrome on Mac") String param) throws MalformedURLException {
		initTest(param);
		loginObject = new LoginPage(driver);
	}

	@Test(priority = 51)
	public void clickDashboardInMenu() {
		assertTrue(Utility.isElementDisplayed(loginObject.dashBoardHeader), "Dashboard header not found");
		assertTrue(Utility.isElementDisplayed(loginObject.memberAccessDashBoardOption),
				"Member access bookings not found");
	}

	@Test(priority = 52)
	public void clickClubProfileInMenu() throws InterruptedException {
		Utility.findElement(loginObject.myClubSubMenu).click();
		assertTrue(Utility.isElementDisplayed(loginObject.clubProfileMenu), "Club profile not found");
		assertTrue(Utility.isElementDisplayed(loginObject.clubFacilitiesSubMenu), "Club facilities not found in menu");
	}

	@Test(priority = 53)
	public void clickBasicInfoInMenu() {
		Utility.findElement(loginObject.clubProfileMenu).click();
		assertTrue(Utility.isElementDisplayed(loginObject.clubImage), "Club image not found");
		assertTrue(Utility.isElementDisplayed(loginObject.clubName), "Club name not found");
	}

	@DataProvider(name = "homePageElements")
	public Object[][] getHomePageelements() {
		Object[][] input = { { loginObject.pageHeader, "Page header not found" },
				{ loginObject.yearFoundedLabel, "Year founded label not found" },
				{ loginObject.yearFoundedValue, "Year founded value not found" },
				{ loginObject.clubTypeLabel, "Club type label not found" },
				{ loginObject.clubTypeValue, "Club type value not found" },
				{ loginObject.totalMembersLabel, "Total members label not found" },
				{ loginObject.totalMembersValue, "Total members value not found" },
				{ loginObject.clubUrlLabel, "Club URL label not found" },
				{ loginObject.clubUrlValue, "Club URL value not found" },
				{ loginObject.locationLabel, "Location label not found" },
				{ loginObject.locationValue, "Location value not found" },
				{ loginObject.phoneFieldLabel, "Phone field label not found" },
				{ loginObject.phoneFieldValue, "Phone field value not found" },
				{ loginObject.emailLabel, "Email label not found" },
				{ loginObject.emailValue, "Email value value not found" },
				{ loginObject.aboutUsTab, "About us tab not found" },
				{ loginObject.affiliatedClubsTab, "Affiliated Clubs tab not found" },
				{ loginObject.boardMembersTab, "Board members tab not found" } };
		return input;
	}

	@Test(priority = 54, dataProvider = "homePageElements")
	public void testProfilePageElements(By element, String str) {
		assertTrue(Utility.isElementDisplayed(element), str);
	}

	@Test(priority = 55, enabled = false)
	public void clickClubFacilitiesInMenu() {
		Utility.findElement(loginObject.clubProfileMenu).click();
		Utility.findElement(loginObject.clubFacilitiesSubMenu).click();
		assertTrue(Utility.isElementDisplayed(loginObject.clubFacilitiesTitle), "Club facilities not loaded");
	}

}

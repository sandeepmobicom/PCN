package com.mobicom.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.mobicom.helpers.Utility;
import com.mobicom.pages.AddCurateEventPage;
import com.mobicom.pages.AddFacilityPage;
import com.mobicom.pages.LoginPage;
import com.mobicom.pages.MemberAccessPage;

public class MemberAccessTest extends BaseTest {
	MemberAccessPage memberAccessObject;
	JavascriptExecutor js;
	Alert alert;
	int publishedItems = 0;

	@Parameters("testItem")
	@BeforeClass
	public void beforeTheClass(@Optional("Chrome on Mac") String param) throws MalformedURLException {
		initTest(param);
		memberAccessObject = new MemberAccessPage(driver);
		js = (JavascriptExecutor) driver;
	}

	@Test(priority = 200)
	public void clickMemberAccessInMenu() {
		Utility.findElement(memberAccessObject.memberAccessInMenu).click();
		assertTrue(Utility.isElementDisplayed(memberAccessObject.memberAccessPageHeader),
				"Member access page not found");
	}

	@DataProvider(name = "memberAccessPageElements")
	public Object[][] getMemberAccessPageElements() {
		Object[][] input = { { memberAccessObject.memberAccessPageHeader, "Header not found" },
				{ memberAccessObject.clubImage, "Club image not found" },
				{ memberAccessObject.clubCity, "Club city not found" },
				{ memberAccessObject.clubName, "Club name not found" },
				{ memberAccessObject.clubCountry, "Club country not found" },
				{ memberAccessObject.greenToggle, "Allow access button not found" } };
		return input;
	}

	@Test(priority = 201, dataProvider = "memberAccessPageElements")
	public void verifyMemberAccessPageElements(By element, String str) {
		assertTrue(Utility.isElementDisplayed(element), str);
	}

	@Test(priority = 202)
	public void clickGreenToggle() {
		Utility.findElement(memberAccessObject.greenToggle).click();
		assertTrue(Utility.isElementDisplayed(memberAccessObject.allowAccessPageHeader), "Allow access page not found");
	}

	@DataProvider(name = "allowAccessPageElements")
	public Object[][] getAllowMemberAccessPageElements() {
		Object[][] input = { { memberAccessObject.allowAccessPageHeader, "Header not found" },
				{ memberAccessObject.aboutClubTab, "aboutClubTab not found" },
				{ memberAccessObject.facilitiesTab, "facilitiesTab not found" },
				{ memberAccessObject.moreInfo, "moreInfo button found" },
				{ memberAccessObject.closeButton, "closeButton not found" },
				{ memberAccessObject.nextButton, "nextButton not found" },
				{ memberAccessObject.aboutUs, "aboutUs section not found" } };
		return input;
	}

	@Test(priority = 203, dataProvider = "allowAccessPageElements")
	public void verifyBlockMemberAccessPageElements(By element, String str) {
		assertTrue(Utility.isElementDisplayed(element), str);
	}
	
	@Test(priority = 204)
	public void clickNextButton() {
		Utility.findElement(memberAccessObject.nextButton).click();
		assertTrue(Utility.isElementDisplayed(memberAccessObject.previousButton), "Previous button not found");
		assertTrue(Utility.isElementDisplayed(memberAccessObject.blockingRequestsInDetail), "Allow access button not found");
	}
	
	@Test(priority = 205)
	public void clickBlockingRequestsButton() {
		Utility.findElement(memberAccessObject.blockingRequestsInDetail).click();		
		assertTrue(Utility.isElementDisplayed(memberAccessObject.blockingConfirmationMessage), "Confirmation alert not displayed");
		assertTrue(Utility.isElementDisplayed(memberAccessObject.okButton), "OK button not displayed");
	}
	
	@Test(priority = 206)
	public void clickOkButton() throws InterruptedException {
		Utility.findElement(memberAccessObject.okButton).click();
		assertTrue(Utility.isElementDisplayed(memberAccessObject.redToggle), "Blocking is not successful");
	}
	
	
	
	//TODO
	//Remove access
	
	
	
	@Test(priority = 215)
	public void clickRedToggle() {
		Utility.findElement(memberAccessObject.redToggle).click();
		assertTrue(Utility.isElementDisplayed(memberAccessObject.allowAccessPageHeader), "Allow access page not found");
	}

	@Test(priority = 216, dataProvider = "allowAccessPageElements")
	public void verifyAllowMemberAccessPageElements(By element, String str) {
		assertTrue(Utility.isElementDisplayed(element), str);
	}
	
	@Test(priority = 217)
	public void clickNextButtonInRemoveAccess() {
		Utility.findElement(memberAccessObject.nextButton).click();
		assertTrue(Utility.isElementDisplayed(memberAccessObject.previousButton), "Previous button not found");
		assertTrue(Utility.isElementDisplayed(memberAccessObject.acceptingRequestsInDetail), "Accepting Requests button not found");
	}
	
	@Test(priority = 218)
	public void clickAcceptingRequestsButton() {
		Utility.findElement(memberAccessObject.acceptingRequestsInDetail).click();		
		assertTrue(Utility.isElementDisplayed(memberAccessObject.greenToggleAfterApproval), "Accepting requests is not successful");
	}

}

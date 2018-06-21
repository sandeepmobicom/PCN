package com.mobicom.tests;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.mobicom.helpers.Utility;
import com.mobicom.pages.ManageAdminsPage;

public class ManageAdminsTest extends BaseTest {
	ManageAdminsPage manageAdminsObject;
	Alert alert;
	
	@Parameters("testItem")
	@BeforeClass
	public void beforeTheClass(@Optional("Chrome on Mac") String param) throws MalformedURLException {
		initTest(param);
		manageAdminsObject = new ManageAdminsPage(driver);
	}

	@Test(priority = 300)
	public void clickManageAdminsInMenu() {
		Utility.findElement(manageAdminsObject.manageAdminsOptionInMenu).click();
		assertTrue(Utility.isElementDisplayed(manageAdminsObject.adminListingHeader),
				"Manage admin page not found");
	}

	@DataProvider(name = "manageAdmminsPageElements")
	public Object[][] getAdminsPageElements() {
		Object[][] input = { { manageAdminsObject.adminListingHeader, "Header not found" },
				{ manageAdminsObject.serialNumberColumn, "Serial number column not found" },
				{ manageAdminsObject.addAdminButton, "Add admin button not found" },
				{ manageAdminsObject.firstNameColumn, "First name column not found" },
				{ manageAdminsObject.lastNameColumn, "Last name column not found" },
				{ manageAdminsObject.registeredColumn, "Registered column not found" },
				{ manageAdminsObject.actionColumn, "Action column not found" }
				};
		return input;
	}
	
	@Test(priority=301,dataProvider="manageAdmminsPageElements")
	public void checkManageAdminPageElements(By element, String str) {
		assertTrue(Utility.isElementDisplayed(element), str);
	}

	@Test(priority = 302)
	public void clickAddAdminButton() {
		Utility.findElement(manageAdminsObject.addAdminButton).click();
		assertTrue(Utility.isElementDisplayed(manageAdminsObject.addAdminPageHeader), "Add admin page not displayed");
	}
	
	@DataProvider(name = "addAdmminsPageElements")
	public Object[][] getAddAdminPageElements() {
		Object[][] input = { { manageAdminsObject.firstNameField, "First name field not found" },
				{ manageAdminsObject.lastnameField, "Last name field not found" },
				{ manageAdminsObject.emailField, "Email field not found" },
				{ manageAdminsObject.cancelButton, "Cancel button not found" },
				{ manageAdminsObject.AddAdminButtonInDetail, "Add admin button not found" }
				};
		return input;
	}
	
	@Test(priority=303,dataProvider="addAdmminsPageElements")
	public void checkAddAdminPageElements(By element, String str) {
		assertTrue(Utility.isElementDisplayed(element), str);
	}
	


}

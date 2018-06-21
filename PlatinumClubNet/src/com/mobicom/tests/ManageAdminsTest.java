package com.mobicom.tests;

import static org.testng.Assert.assertFalse;
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
import com.mobicom.pages.ManageMembersPage;

public class ManageAdminsTest extends BaseTest {
	ManageAdminsPage manageAdminsObject;
	Alert alert;
	
	@Parameters("testItem")
	@BeforeClass
	public void beforeTheClass(@Optional("Chrome on Mac") String param) throws MalformedURLException {
		initTest(param);
		manageAdminsObject = new ManageAdminsPage(driver);
	}

	@Test(priority = 250)
	public void clickManageMembersInMenu() {
		Utility.findElement(manageAdminsObject.manageMembersOptionInMenu).click();
		assertTrue(Utility.isElementDisplayed(manageAdminsObject.memberListingHeader),
				"Manage Member page not found");
	}

	@DataProvider(name = "manageMembersPageElements")
	public Object[][] getMemberAccessPageElements() {
		Object[][] input = { { manageAdminsObject.memberListingHeader, "Header not found" },
				{ manageAdminsObject.sendInvitationButton, "Send invitation button not found" },
				{ manageAdminsObject.bulkUploadButton, "Bulk upload button not found" },
				{ manageAdminsObject.serialNumberColumn, "Serial number column not found" },
				{ manageAdminsObject.membershipNumberColumn, "Membership number column not found" },
				{ manageAdminsObject.prefixColumn, "Prefix column not found" },
				{ manageAdminsObject.firstNameColumn, "First name column not found" },
				{ manageAdminsObject.lastNameColumn, "Last name column not found" },
				{ manageAdminsObject.emailIdColumn, "Email id column not found" },
				{ manageAdminsObject.registeredColumn, "Registered column not found" }
				};
		return input;
	}
	
	@Test(priority=251,dataProvider="manageMembersPageElements")
	public void checkmanageMembersPageElements(By element, String str) {
		assertTrue(Utility.isElementDisplayed(element), str);
	}

	@Test(priority = 252)
	public void clickBulkUploadButton() {
		Utility.findElement(manageAdminsObject.bulkUploadButton).click();
		assertTrue(Utility.isElementDisplayed(manageAdminsObject.chooseFileButton), "Choose file button not found");
		assertTrue(Utility.isElementDisplayed(manageAdminsObject.uploadMembersButton), "Upload button not found");
	}
	
	@Test(priority = 253)
	public void chooseAnExcelFile() {
		Utility.findElement(manageAdminsObject.chooseFileButton).sendKeys("C:\\Users\\Admin\\Downloads\\MemberTemplate.xls");
		Utility.findElement(manageAdminsObject.uploadMembersButton).click();
		assertTrue(Utility.isElementDisplayed(manageAdminsObject.errorMessage), "Error not displayed");
	}
	
	@Test(priority = 254)
	public void clickSendInvitatinButton() {
		Utility.findElement(manageAdminsObject.sendInvitationButton).click();
		assertTrue(Utility.isElementDisplayed(manageAdminsObject.confirmationHeader), "Confirmation header not displayed");
	}
	
	@DataProvider(name = "emailConfirmationPopupElements")
	public Object[][] getEmailConfirmationPopupElements() {
		Object[][] input = { { manageAdminsObject.confirmationHeader, "Header not found" },
				{ manageAdminsObject.confirmationText, "Confirmation text not found" },
				{ manageAdminsObject.okButtonInConfirmationMessage, "Ok button not found" },
				{ manageAdminsObject.closeButtonInConfirmationMessage, "Close button not found" }
				};
		return input;
	}
	
	@Test(priority=255,dataProvider="emailConfirmationPopupElements")
	public void checkEmailConfirmationPopupElements(By element, String str) {
		assertTrue(Utility.isElementDisplayed(element), str);
	}
	
	@Test(priority = 260)
	public void clickOkButtonInMessageConfirmation() {
		Utility.findElement(manageAdminsObject.okButtonInConfirmationMessage).click();
		assertTrue(Utility.isElementDisplayed(manageAdminsObject.messageAfterConfirmation), "Confirmation message not displayed");
	}
	
	@Test(priority = 261)
	public void clickClosekButtonInMessageConfirmation() {
		Utility.findElement(manageAdminsObject.closeButtonInConfirmationMessage).click();
		Utility.nap(1);
		assertFalse(Utility.isElementDisplayed(manageAdminsObject.confirmationHeader), "Confirmation message still displayed");
	}

}

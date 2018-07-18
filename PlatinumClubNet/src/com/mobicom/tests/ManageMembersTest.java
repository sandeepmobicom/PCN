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
import com.mobicom.pages.ManageMembersPage;

public class ManageMembersTest extends BaseTest {
	ManageMembersPage manageMemberObject;
	Alert alert;
	
	@Parameters("testItem")
	@BeforeClass
	public void beforeTheClass(@Optional("Chrome on Mac") String param) throws MalformedURLException {
		initTest(param);
		manageMemberObject = new ManageMembersPage(driver);
	}

	@Test(priority = 250)
	public void clickManageMembersInMenu() {
		Utility.findElement(manageMemberObject.manageMembersOptionInMenu).click();
		assertTrue(Utility.isElementDisplayed(manageMemberObject.memberListingHeader),
				"Manage Member page not found");
	}

	@DataProvider(name = "manageMembersPageElements")
	public Object[][] getMemberAccessPageElements() {
		Object[][] input = { { manageMemberObject.memberListingHeader, "Header not found" },
				{ manageMemberObject.sendInvitationButton, "Send invitation button not found" },
				{ manageMemberObject.bulkUploadButton, "Bulk upload button not found" },
				{ manageMemberObject.serialNumberColumn, "Serial number column not found" },
				{ manageMemberObject.membershipNumberColumn, "Membership number column not found" },
				{ manageMemberObject.prefixColumn, "Prefix column not found" },
				{ manageMemberObject.firstNameColumn, "First name column not found" },
				{ manageMemberObject.lastNameColumn, "Last name column not found" },
				{ manageMemberObject.emailIdColumn, "Email id column not found" },
				{ manageMemberObject.registeredColumn, "Registered column not found" }
				};
		return input;
	}
	
	@Test(priority=251,dataProvider="manageMembersPageElements")
	public void checkmanageMembersPageElements(By element, String str) {
		assertTrue(Utility.isElementDisplayed(element), str);
	}

	@Test(priority = 252,enabled =false)
	public void clickBulkUploadButton() {
		Utility.findElement(manageMemberObject.bulkUploadButton).click();
		assertTrue(Utility.isElementDisplayed(manageMemberObject.chooseFileButton), "Choose file button not found");
		assertTrue(Utility.isElementDisplayed(manageMemberObject.uploadMembersButton), "Upload button not found");
	}
	
	@Test(priority = 253,enabled =false)
	public void chooseAnExcelFile() {
		manageMemberObject.updateMemberExcel();
		Utility.findElement(manageMemberObject.chooseFileButton).sendKeys("/Volumes/Development/Pcn_Auto/PCN/PlatinumClubNet/MemberTemplate.xls");
		Utility.findElement(manageMemberObject.uploadMembersButton).click();
		assertTrue(Utility.isElementDisplayed(manageMemberObject.confirmationMessage), "Confirmation message not displayed");
	}
	
	@Test(priority = 254,enabled =false)
	public void clickSendInvitatinButton() {
		Utility.findElement(manageMemberObject.sendInvitationButton).click();
		assertTrue(Utility.isElementDisplayed(manageMemberObject.confirmationHeader), "Confirmation header not displayed");
	}
	
	@DataProvider(name = "emailConfirmationPopupElements")
	public Object[][] getEmailConfirmationPopupElements() {
		Object[][] input = { { manageMemberObject.confirmationHeader, "Header not found" },
				{ manageMemberObject.confirmationText, "Confirmation text not found" },
				{ manageMemberObject.okButtonInConfirmationMessage, "Ok button not found" },
				{ manageMemberObject.closeButtonInConfirmationMessage, "Close button not found" }
				};
		return input;
	}
	
	@Test(priority=255,dataProvider="emailConfirmationPopupElements",enabled =false)
	public void checkEmailConfirmationPopupElements(By element, String str) {
		assertTrue(Utility.isElementDisplayed(element), str);
	}
	
	@Test(priority = 260,enabled =false)
	public void clickOkButtonInMessageConfirmation() {
		Utility.findElement(manageMemberObject.okButtonInConfirmationMessage).click();
		assertTrue(Utility.isElementDisplayed(manageMemberObject.messageAfterConfirmation), "Confirmation message not displayed");
	}
	
	@Test(priority = 261,enabled =false)
	public void clickCloseButtonInMessageConfirmation() {
		Utility.findElement(manageMemberObject.closeButtonInConfirmationMessage).click();
		Utility.nap(1);
		assertFalse(driver.findElement(manageMemberObject.confirmationHeader).isDisplayed());
//		assertFalse(Utility.isElementDisplayed(manageMemberObject.confirmationHeader), "Confirmation message still displayed");
	}

}

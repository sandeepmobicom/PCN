package com.mobicom.tests;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	String todaysDate=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	
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
	
	@Test(priority = 304)
	public void fillFirstName() {
		Utility.findElement(manageAdminsObject.firstNameField).sendKeys("Admin "+todaysDate);
		assertTrue(Utility.findElement(manageAdminsObject.firstNameField).getAttribute("value").equals("Admin "+todaysDate));
	}
	
	@Test(priority = 305)
	public void fillLastName() {
		Utility.findElement(manageAdminsObject.lastnameField).sendKeys("Test");
		assertTrue(Utility.findElement(manageAdminsObject.lastnameField).getAttribute("value").equals("Test"));
	}
	
	@Test(priority = 306)
	public void fillEmail() {
		Utility.findElement(manageAdminsObject.emailField).sendKeys("admin"+todaysDate+"@testmail.com");
		assertTrue(Utility.findElement(manageAdminsObject.emailField).getAttribute("value").equals("admin"+todaysDate+"@testmail.com"));
	}
	
	@Test(priority = 307)
	public void clickAddAdmin() {
		Utility.findElement(manageAdminsObject.AddAdminButtonInDetail).click();
		assertTrue(Utility.isElementDisplayed(By.xpath("//td[text()='Admin "+todaysDate+"']")));
	}
	
	@Test(priority = 308)
	public void clickSettingsButton() {
		Utility.findElement(By.xpath("//td[text()='Admin "+todaysDate+"']/following-sibling::td/div/i[contains(@class,'dropdown-toggle')]")).click();
		assertTrue(Utility.isElementDisplayed(By.xpath("//td[text()='Admin "+todaysDate+"']/following-sibling::td/div/i[contains(@class,'dropdown-toggle')]/following-sibling::ul/li/a[text()='DELETE']")));
		assertTrue(Utility.isElementDisplayed(By.xpath("//td[text()='Admin "+todaysDate+"']/following-sibling::td/div/i[contains(@class,'dropdown-toggle')]/following-sibling::ul/li/a[text()='MODIFY']")));
	}
	
	@Test(priority = 309)
	public void clickDeleteButton() {
		Utility.findElement(By.xpath("//td[text()='Admin "+todaysDate+"']/following-sibling::td/div/i[contains(@class,'dropdown-toggle')]/following-sibling::ul/li/a[text()='DELETE']")).click();
		assertTrue(Utility.isElementDisplayed(manageAdminsObject.deleteConfirmationMessage));
		assertTrue(Utility.isElementDisplayed(manageAdminsObject.continueButton));
	}
	
	@Test(priority = 310)
	public void clickContinueButton() {
		Utility.findElement(manageAdminsObject.continueButton).click();
		Utility.nap(1);
		assertFalse(Utility.isElementDisplayed(By.xpath("//td[text()='Admin "+todaysDate+"']")));
	}
	


}

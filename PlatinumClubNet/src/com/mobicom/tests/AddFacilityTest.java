package com.mobicom.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.mobicom.helpers.Utility;
import com.mobicom.pages.AddFacilityPage;
import com.mobicom.pages.LoginPage;

public class AddFacilityTest extends BaseTest {
	AddFacilityPage addFacilityObject;
	Alert alert;
	int publishedItems=0;

	@Parameters("testItem")
	@BeforeClass
	public void beforeTheClass(@Optional("Chrome on Mac") String param) throws MalformedURLException {
		initTest(param);
		addFacilityObject = new AddFacilityPage(driver);
	}

	@Test(priority = 89)
	public void clickClubFacilitiesInMenu() {
		Utility.findElement(addFacilityObject.myClubInMenu).click();
		Utility.findElement(addFacilityObject.clubFacilitiesSubMenu).click();
		assertTrue(Utility.isElementDisplayed(addFacilityObject.clubFacilitiesTitle), "Club facilities not loaded");
	}

	@DataProvider(name = "clubFacilitiesElements")
	public Object[][] getClubFacilitiesElements() {
		Object[][] input = { { addFacilityObject.addfacilityButton, "Add facilities button not found" },
				{ addFacilityObject.addedFacility, "Added facility not found" },
				{ addFacilityObject.deleteButton, "Delete button not found" } };
		return input;
	}

	@Test(priority = 90, dataProvider = "clubFacilitiesElements")
	public void verifyClubFacilitiesElements(By element, String str) {
		assertTrue(Utility.isElementDisplayed(element), str);
	}

	@Test(priority = 91)
	public void clickAddFacilitiesInMenu() {
		publishedItems=Utility.getMultipleElements(addFacilityObject.publishedLabel).size();
		Utility.findElement(addFacilityObject.addfacilityButton).click();
		assertTrue(Utility.isElementDisplayed(addFacilityObject.selectImagesButton), "Select images button not found");
	}

	@Test(priority = 92)
	public void clickSelectImage() {
		Utility.findElement(addFacilityObject.selectImagesButton).click();
		assertTrue(Utility.isElementDisplayed(addFacilityObject.newImage), "Image not found");
		assertTrue(Utility.isElementDisplayed(addFacilityObject.useImage), "use Image button not found");
	}

	@Test(priority = 93)
	public void selectAnImage() {
		Utility.findElement(addFacilityObject.newImage).click();
		Utility.findElement(addFacilityObject.useImage).click();
		assertTrue(Utility.isElementDisplayed(addFacilityObject.selectedThumbnail), "Image not selected");
	}

	@Test(priority = 94)
	public void enterFacilityName() throws InterruptedException {
		Utility.findElement(addFacilityObject.facilityNameField).sendKeys("AutoFacility");
		assertEquals(Utility.findElement(addFacilityObject.facilityNameField).getAttribute("value"), "AutoFacility");
	}

	@Test(priority = 95)
	public void selectFacilityCategory() {
		Select select = new Select(Utility.findElement(addFacilityObject.facilityCategory));
		select.selectByVisibleText("Accommodation");
		System.out.println(select.getFirstSelectedOption().getText());
	}

	@Test(priority = 106)
	public void enterFacilityDescription() {
		driver.switchTo().frame(Utility.findElement(addFacilityObject.facilityDescriptionIframe));
		Utility.findElement(addFacilityObject.facilityDescription).sendKeys("Test Description");
		assertEquals(Utility.findElement(addFacilityObject.facilityDescription).getText(), "Test Description");
		driver.switchTo().defaultContent();
	}

	@Test(priority = 107)
	public void enterFacilityRules() {
		driver.switchTo().frame(Utility.findElement(addFacilityObject.facilityRulesIframe));
		Utility.findElement(addFacilityObject.facilityDescription).sendKeys("Test Rules");
		assertEquals(Utility.findElement(addFacilityObject.facilityDescription).getText(), "Test Rules");
		driver.switchTo().defaultContent();
	}

	@Test(priority = 108)
	public void enterFacilityCancellationPolicy() {
		driver.switchTo().frame(Utility.findElement(addFacilityObject.facilityCancellationIframe));
		Utility.findElement(addFacilityObject.facilityDescription).sendKeys("Test Cancellation Policy");
		assertEquals(Utility.findElement(By.xpath(
				"//html/body[contains(@class,\"cke_editable cke_editable_themed cke_contents_ltr cke_show_borders\")]"))
				.getText(), "Test Cancellation Policy");
		driver.switchTo().defaultContent();
	}

	@Test(priority = 109)
	public void clickDaysOfWeekButton() {
		Utility.findElement(addFacilityObject.daysOfWeek).click();
		assertTrue(Utility.isElementDisplayed(addFacilityObject.selectAllDays), "Select all days not displayed");
	}

	@Test(priority = 110)
	public void clickSaveButton() throws InterruptedException {
		Utility.findElement(addFacilityObject.selectAllDays).click();
		Thread.sleep(1000);
		Utility.findElement(addFacilityObject.saveButton).click();
		assertTrue(Utility.isElementDisplayed(addFacilityObject.addfacilityButton), "Not navigated to facility list");
		assertTrue(Utility.isElementDisplayed(addFacilityObject.newFacility), "Facility not saved");
		assertEquals(Utility.getMultipleElements(addFacilityObject.publishedLabel).size(),publishedItems,"Facility is already published");
	}
	
	@Test(priority = 111)
	public void publishNewfacility() {
		Utility.findElement(addFacilityObject.newFacility).click();
		Utility.findElement(addFacilityObject.publishButton).click();
		assertTrue(Utility.isElementDisplayed(addFacilityObject.addfacilityButton), "Not navigated to facility list");
		assertTrue(Utility.isElementDisplayed(addFacilityObject.newFacility), "Facility not published");
		assertTrue(Utility.getMultipleElements(addFacilityObject.publishedLabel).size() > publishedItems,"Facility is not published");
	}
	
	@Test(priority = 112)
	public void deleteFacility() throws InterruptedException {
		Utility.findElement(addFacilityObject.deleteFacility).click();
		alert=driver.switchTo().alert();
		alert.accept();
		assertTrue(Utility.isElementDisplayed(addFacilityObject.deleteSuccessMessage), "Facility not deleted");
		Thread.sleep(2000);
		assertEquals(Utility.getMultipleElements(addFacilityObject.publishedLabel).size(),publishedItems,"Facility is already published");
	}

}

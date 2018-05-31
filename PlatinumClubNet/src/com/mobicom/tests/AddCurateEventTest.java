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

public class AddCurateEventTest extends BaseTest {
	AddCurateEventPage addCurateObject;
	JavascriptExecutor js;
	Alert alert;
	int publishedItems = 0;

	@Parameters("testItem")
	@BeforeClass
	public void beforeTheClass(@Optional("Chrome on Mac") String param) throws MalformedURLException {
		initTest(param);
		addCurateObject = new AddCurateEventPage(driver);
		js = (JavascriptExecutor) driver;
	}

	@Test(priority = 150)
	public void clickCurateEventsInMenu() {
		Utility.findElement(addCurateObject.curateFacilitiesInMenu).click();
		assertTrue(Utility.isElementDisplayed(addCurateObject.clubFacilitiesInMenu),
				"Club facilities option not found");
		assertTrue(Utility.isElementDisplayed(addCurateObject.curateEventQuestionnaire), "Questionnaire option not found");
		assertTrue(Utility.isElementDisplayed(addCurateObject.statusInMenu), "Status option not found");
	}

	@Test(priority = 151)
	public void clickListOfCurateEventsInMenu() {
		Utility.findElement(addCurateObject.clubFacilitiesInMenu).click();
		assertTrue(Utility.isElementDisplayed(addCurateObject.curateFacilitiesHeader),
				"Curate events section not loaded");
	}

	@DataProvider(name = "curateEventsPageElements")
	public Object[][] getCurateEventsPageElements() {
		Object[][] input = { { addCurateObject.curateFacilitiesHeader, "Curate facilities header not found" },
				{ addCurateObject.curateFacilitiesDescription, "Description not found" },
				{ addCurateObject.addCurateEvents, "Add curate events button not found" } };
		return input;
	}

	@Test(priority = 152, dataProvider = "curateEventsPageElements")
	public void verifyCurateEventsPageElements(By element, String str) {
		assertTrue(Utility.isElementDisplayed(element), str);
	}

	@Test(priority = 153)
	public void clickAddCurateEvent() {
		Utility.findElement(addCurateObject.addCurateEvents).click();
		assertTrue(Utility.isElementDisplayed(addCurateObject.addCurateEventHeader),
				"Add curate event page not loaded");
	}

	@DataProvider(name = "addCurateEventsPageElements")
	public Object[][] getAddCurateEventsPageElements() {
		Object[][] input = { { addCurateObject.addCurateEventHeader, "Header not found" },
				{ addCurateObject.facilityDropDown, "Facility drop down not found" },
				{ addCurateObject.addFacilityButton, "Add facility button not found" },
				{ addCurateObject.startDateField, "Start date field not found" },
				{ addCurateObject.endDateField, "End date field not found" },
				{ addCurateObject.startTimeField, "Start time field not found" },
				{ addCurateObject.endTimeField, "End time field not found" },
				{ addCurateObject.cancelButton, "Cancel button not found" },
				{ addCurateObject.saveButton, "Save button not found" },
				{ addCurateObject.publishButton, "Publish button not found" } };
		return input;
	}

	@Test(priority = 154, dataProvider = "addCurateEventsPageElements")
	public void verifyAddCurateEventsPageElements(By element, String str) {
		assertTrue(Utility.findElementVisible(element).isDisplayed(), str);
	}

	@Test(priority = 155)
	public void selectFacility() {
		Select select = new Select(Utility.findElement(addCurateObject.facilityDropDown));
		select.selectByVisibleText("OTHER");
		System.out.println(select.getFirstSelectedOption().getText());
		assertEquals(Utility.findElementVisible(addCurateObject.facilityName).getAttribute("value"),
				"OTHER");
	}

	@Test(priority = 156)
	public void updateRemarks() {
		driver.switchTo().frame(Utility.findElement(addCurateObject.remarksFieldIframe));
		Utility.findElement(addCurateObject.remarksField).sendKeys("Test Remarks");
		assertEquals(Utility.findElement(addCurateObject.remarksField).getText(), "Test Remarks");
		driver.switchTo().defaultContent();
	}

	@Test(priority = 157)
	public void enterStartDate() {
		js.executeScript("document.getElementsByClassName('datepicker')[1].value='30/04/2018'");
		assertEquals(Utility.findElement(addCurateObject.startDateField).getAttribute("value"), "30/04/2018");
	}

	@Test(priority = 158)
	public void enterEndDate() throws InterruptedException {
		js.executeScript("document.getElementsByClassName('datepicker')[1].value='30/05/2019'");
		assertEquals(Utility.findElement(addCurateObject.endDateField).getAttribute("value"), "30/05/2019");
	}

	@Test(priority = 159)
	public void enterStartTime() {
		Utility.findElement(addCurateObject.startTimeField).clear();
		Utility.findElement(addCurateObject.startTimeField).sendKeys("10:00");
		assertEquals(Utility.findElement(addCurateObject.startTimeField).getAttribute("value"), "10:00");
	}

	@Test(priority = 160)
	public void enterEndTime() {
		Utility.findElement(addCurateObject.endTimeField).clear();
		Utility.findElement(addCurateObject.endTimeField).sendKeys("15:00");
		assertEquals(Utility.findElement(addCurateObject.endTimeField).getAttribute("value"), "15:00");
	}

	@Test(priority = 161)
	public void clickSaveButton() {
		Utility.findElement(addCurateObject.saveButton).click();
		assertTrue(Utility.isElementDisplayed(addCurateObject.addedCurateEvent), "Curate event not saved");
	}

	@Test(priority = 162)
	public void modifyEvent() {
		Utility.findElement(addCurateObject.settingsButtonForAddedEvent).click();
		Utility.findElement(addCurateObject.modifyButton).click();
		assertTrue(Utility.findElementVisible(addCurateObject.facilityName).isDisplayed(),
				"Curate event detail not displayed");
	}

	@Test(priority = 163)
	public void clickPublishButton() {
		Utility.findElement(addCurateObject.publishButton).click();
		assertTrue(Utility.isElementDisplayed(addCurateObject.addedCurateEvent), "Curate event not published");
	}

	@Test(priority = 164)
	public void deleteCurateEvent() throws InterruptedException {
		Utility.findElement(addCurateObject.settingsButtonForAddedEvent).click();
		Utility.findElement(addCurateObject.deleteButton).click();
		alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);
		assertEquals(Utility.getMultipleElements(addCurateObject.addedCurateEvent).size(), 0,
				"Curate event not deleted");
	}

}

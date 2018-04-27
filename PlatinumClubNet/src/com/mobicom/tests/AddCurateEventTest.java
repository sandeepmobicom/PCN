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
import com.mobicom.pages.AddCurateEventPage;
import com.mobicom.pages.AddFacilityPage;
import com.mobicom.pages.LoginPage;

public class AddCurateEventTest extends BaseTest {
	AddCurateEventPage addCurateObject;
	Alert alert;
	int publishedItems = 0;

	@Parameters("testItem")
	@BeforeClass
	public void beforeTheClass(@Optional("Chrome on Mac") String param) throws MalformedURLException {
		initTest(param);
		addCurateObject = new AddCurateEventPage(driver);
	}

	@Test(priority = 150)
	public void clickCurateEventsInMenu() {
		Utility.findElement(addCurateObject.curateFacilitiesInMenu).click();
		assertTrue(Utility.isElementDisplayed(addCurateObject.listOfFacilitiesInMenu),
				"List of facilities option not found");
		assertTrue(Utility.isElementDisplayed(addCurateObject.statusInMenu), "Status option not found");
	}

	@Test(priority = 151)
	public void clickListOfCurateEventsInMenu() {
		Utility.findElement(addCurateObject.listOfFacilitiesInMenu).click();
		assertTrue(Utility.isElementDisplayed(addCurateObject.curateFacilitiesHeader),
				"Curate events section not loaded");
	}

	@DataProvider(name = "curateEventsPageElements")
	public Object[][] getCurateEventsPageElements() {
		Object[][] input = { { addCurateObject.curateFacilitiesHeader, "Curate facilities header not found" },
				{ addCurateObject.curateFacilitiesDescription, "Description not found" },
				{ addCurateObject.addCurateEvents, "Add curate events button not found" },
				{ addCurateObject.editCurateEventQuestionnaire, "Edit curate events questionnaire button not found" } };
		return input;
	}
	
	@Test(priority = 152, dataProvider = "curateEventsPageElements")
	public void verifyCurateEventsPageElements(By element, String str) {
		assertTrue(Utility.isElementDisplayed(element), str);
	}
	
	

}

package com.mobicom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mobicom.helpers.Utility;

public class AddCurateEventPage extends Utility {

	WebDriver driver;
	
	public By curateFacilitiesInMenu=By.xpath("//span[text()='Curated Events']");
	public By clubFacilitiesInMenu=By.xpath("//a[@id='menu_curatedEvents']/span[text()='Club Facilities']");
	public By statusInMenu=By.xpath("//a[@id='menu_report_curate-facility-event']/span[text()='Status']");
	public By curateFacilitiesHeader=By.xpath("//h3[text()='Curated Events']");
	public By curateFacilitiesDescription=By.xpath("//div[@class='text-justify']/p");
	public By addCurateEvents=By.xpath("//span[text()='Add Facilities For Curated Events']");
	public By curateEventQuestionnaire=By.xpath("//a[@id='menu_curate_event_questionnaire']/span[text()='Curation Profile']");
	public By facilityDropDown=By.id("facility_id");
	public By addFacilityButton=By.xpath("//a[@class='btn submit-btn facility_choice_add']");
	public By remarksFieldIframe=By.xpath("//iframe[@title='Rich Text Editor, sponsor_desc_id']");
	public By remarksField = By.xpath("//html/body[contains(@class,'cke_editable cke_editable_themed cke_contents_ltr cke_show_borders')]");
	public By startDateField=By.xpath("//input[@name='start_date[0]']");
	public By endDateField=By.xpath("//input[@name='end_date[0]']");
	public By startTimeField=By.xpath("//input[@name='start_time[0]']");
	public By endTimeField=By.xpath("//input[@name='end_time[0]']");
	public By addCurateEventHeader=By.xpath("//h3[text()='Add Curated Event']");
	public By cancelButton = By.xpath("//a[@class='btn cancel-btn btn-sha btn-ad1 btnwidth nav_action nav_cancel']");
	public By saveButton = By.id("action_save");
	public By publishButton = By.id("action_publish");
	public By facilityName = By.xpath("//input[@id='facility_name']");
	public By addedCurateEvent = By.xpath("//td[contains(text(),'DEMO')]");
	public By settingsButtonForAddedEvent = By.xpath("//td[contains(text(),'DEMO')]/following-sibling::td/div/i[contains(@class,'dropdown-toggle')]");
	public By modifyButton = By.xpath("//a[text()='MODIFY']");
	public By deleteButton = By.xpath("//a[text()='DELETE']");

	public AddCurateEventPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
}
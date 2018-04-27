package com.mobicom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mobicom.helpers.Utility;

public class AddFacilityPage extends Utility {

	WebDriver driver;

	public By clubProfileMenu = By.xpath("//span[text()='Club Profile']");
	public By clubFacilitiesSubMenu = By.xpath("//span[text()='Club Facilities']");
	public By clubFacilitiesTitle = By.xpath("//h3[text()='Facilities on Your Club Profile']");
	public By addfacilityButton = By.xpath("//p[@class=\"card-header\"]/b");
	public By addedFacility = By.xpath("//div[@class=\"card-header ellip\"]/b[text()='New Test Facility']");
	public By deleteButton = By.xpath("//a[@title='Delete']");
	public By selectImagesButton = By.xpath("//a[text()='select Images']");
	public By newImage = By.xpath("//img[@title='newImage']");
	public By useImage = By.id("use_me");
	public By selectedThumbnail=By.xpath("//div[@class='oneclub thumbnail']");
	public By addImage = By.xpath("//img[@alt='add image']");
	public By facilityNameField = By.id("facility_name");
	public By facilityCategory = By.id("facilityId");
	public By facilityDescription = By.xpath("//html/body[contains(@class,'cke_editable cke_editable_themed cke_contents_ltr cke_show_borders')]");
	public By facilityDescriptionIframe = By.xpath("//iframe[@title='Rich Text Editor, DescriptionID']");
	public By facilityRulesIframe = By.xpath("//iframe[@title='Rich Text Editor, rulesID']");
	public By facilityCancellationIframe = By.xpath("//iframe[@title='Rich Text Editor, cancellationPolicy']");
	public By daysOfWeek = By.xpath("//span[@class='multiselect-selected-text']");
	public By selectAllDays = By.xpath("//input[@value='multiselect-all' and @type='checkbox']");
	public By cancelButton = By.xpath("//a[@data-original-title='Click here to go back to facility']");
	public By saveButton = By.id("action_save");
	public By publishButton = By.id("action_publish");
	public By newFacility=By.xpath("//div[@class='card-header ellip']/b[text()='AutoFacility']");
	public By publishedLabel=By.xpath("//a/b[text()='Published']");
	public By deleteFacility=By.xpath("//b[text()='AutoFacility']/../following-sibling::a");
	public By deleteSuccessMessage=By.xpath("//div[@class='alert alert-success hide-alert-message']");

	public AddFacilityPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	
}
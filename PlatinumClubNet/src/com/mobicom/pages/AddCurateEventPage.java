package com.mobicom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mobicom.helpers.Utility;

public class AddCurateEventPage extends Utility {

	WebDriver driver;
	
	public By curateFacilitiesInMenu=By.xpath("//span[text()='Curate - Facilities for Social Events']");
	public By listOfFacilitiesInMenu=By.xpath("//a[@id='menu_curatedEvents']/span[text()='List of Facilities']");
	public By statusInMenu=By.xpath("//a[@id='menu_report_curate-facility-event']/span[text()='Status']");
	public By curateFacilitiesHeader=By.xpath("//h3[text()='Curate - Facilities for Social Events']");
	public By curateFacilitiesDescription=By.xpath("//div[@class='text-justify']/p");
	public By addCurateEvents=By.xpath("//span[text()='Add Facilities For Curated Events']");
	public By editCurateEventQuestionnaire=By.xpath("//span[text()='Add Facilities For Curated Events']");
	
	
	
	

	public AddCurateEventPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	
}
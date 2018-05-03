package com.mobicom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mobicom.helpers.Utility;

public class MemberAccessPage extends Utility {

	WebDriver driver;
	
	public By memberAccessInMenu=By.xpath("//span[text()='PlatinumClubNet Discretionary Reciprocity']");
	public By memberAccessPageHeader=By.xpath("//h3[text()='PlatinumClubNet Member Access']");
	public By clubImage=By.xpath("//img[contains(@class,'club-image')]");
	public By clubName=By.xpath("//h5[text()='Amazon Valley']");
	public By clubCity=By.xpath("//h5[text()='Amazon Valley']/../p/span[text()='City: Bangalore ']");
	public By clubCountry=By.xpath("//h5[text()='Amazon Valley']/../p/span[text()='City: Bangalore ']/following-sibling::span[text()='Country: India']");
	public By clubType=By.xpath("//h5[text()='Amazon Valley']/../p/span[text()='Club Type: Yacht Club ']");
	public By clubMembers=By.xpath("//h5[text()='Amazon Valley']/../p/span[text()='Club Type: Yacht Club ']/following-sibling::span[contains(text(),'Members')]");
	public By allowAccess=By.xpath("//h5[text()='Amazon Valley']/../../following-sibling::div/div/div/p/kbd[text()='Allow Access']");
	public By allowAccessPageHeader=By.xpath("//div[text()='Amazon Valley']");
	
	public By aboutClubTab=By.xpath("//a[text()='ABOUT CLUB']");
	public By facilitiesTab=By.xpath("//a[text()='ABOUT CLUB']");
	public By moreInfo=By.xpath("//span[text()='More Information']");
	public By closeButton=By.xpath("//div[@class=\"modal-title\"]/../button[@class='close' and text()='×']");
	public By nextButton=By.id("nextTab");
	public By previousButton=By.id("prevTab");
	public By aboutUs=By.xpath("//h4[text()='ABOUT US']");
	public By allowAccessInDetail=By.id("popupWhitelist");
	

	public MemberAccessPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
}
package com.mobicom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mobicom.helpers.Utility;

public class MemberAccessPage extends Utility {

	WebDriver driver;
	
	public By memberAccessInMenu=By.xpath("//span[text()='Manage Network Clubs']");
	public By memberAccessPageHeader=By.xpath("//h3[text()='PlatinumClubNet Member Access']");
	public By clubImage=By.xpath("//img[contains(@class,'club-image')]");
	public By clubName=By.xpath("//h5[text()='Club Domino']");
	public By clubCity=By.xpath("//h5[text()='Club Domino']/following-sibling::p[contains(@class,'club-city-type ellip')]/span[text()='Bangalore']");
	public By clubCountry=By.xpath("//h5[text()='Club Domino']/following-sibling::p[contains(@class,'club-city-type ellip')]/span[contains(text(),'India')]");
	public By greenToggle=By.xpath("//div[@data-club-name='Club Domino']/following-sibling::div/div/div/label/span[@class='checked slider round']");
	public By greenToggleAfterApproval=By.xpath("//div[@data-club-name='Club Domino']/following-sibling::div/div/div/label/span[@class='slider round checked']");
	public By redToggle=By.xpath("//div[@data-club-name='Club Domino']/following-sibling::div/div/div/label/span[@class='slider round']");
	public By allowAccessPageHeader=By.xpath("//div[text()='Club Domino']");
	public By aboutClubTab=By.xpath("//a[text()='ABOUT CLUB']");
	public By facilitiesTab=By.xpath("//a[text()='FACILITIES']");
	public By moreInfo=By.xpath("//span[text()='More Information']");
	public By closeButton=By.xpath("//div[@class='modal-title']/../button[@class='close' and text()='×']");
	public By nextButton=By.id("nextTab");
	public By previousButton=By.id("prevTab");
	public By aboutUs=By.xpath("//h4[text()='ABOUT US']");
	public By acceptingRequestsInDetail=By.id("popupWhitelist");
	public By blockingRequestsInDetail=By.id("popupWhitelist");
	public By closeButtonInDetail=By.xpath("//a[text()='Add Facility']/preceding-sibling::button[@class='close']");
	public By blockingConfirmationMessage=By.xpath("//h5[contains(text(),'Are you sure you want to block?')]");
	public By okButton=By.id("alert-box");
	public By confirmationMessageForAllowAccess=By.xpath("//span[text()='Club whitelisted successfully!']");
	public By confirmationMessageForRemoveAccess=By.xpath("//span[text()='Club whitelisted successfully!']");
	

	public MemberAccessPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
}
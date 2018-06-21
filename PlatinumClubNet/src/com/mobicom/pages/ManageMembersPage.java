package com.mobicom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mobicom.helpers.Utility;

public class ManageMembersPage extends Utility {

	WebDriver driver;
	
	public By manageMembersOptionInMenu=By.xpath("//span[text()='Manage Members']");
	public By memberListingHeader=By.xpath("//h3[text()='Member Listing']");
	public By sendInvitationButton=By.id("invite-all");
	public By bulkUploadButton=By.xpath("//button[@data-target='#myUpload']");
	public By serialNumberColumn=By.xpath("//th[text()='Sr.No.']");
	public By membershipNumberColumn=By.xpath("//th[contains(text(),'Membership Number')]");
	public By prefixColumn=By.xpath("//th[contains(text(),'Prefix')]");
	public By firstNameColumn=By.xpath("//th[contains(text(),'First Name')]");
	public By lastNameColumn=By.xpath("//th[contains(text(),'Last Name')]");
	public By emailIdColumn=By.xpath("//th[contains(text(),'Email ID')]");
	public By registeredColumn=By.xpath("//th[contains(text(),'Registered?')]");
	public By chooseFileButton=By.id("upload-file");
	public By uploadMembersButton=By.xpath("//button[text()='Upload Members']");
	public By errorMessage=By.xpath("//div/strong[contains(text(),'Error')]");
	public By confirmationHeader=By.xpath("//strong[contains(text(),'Invitation email to Members')]");
	public By confirmationText=By.xpath("//div[contains(text(),'Click \"OK\" to send an email')]");
	public By okButtonInConfirmationMessage=By.xpath("//button[@id='mailUserForReg']");
	public By closeButtonInConfirmationMessage=By.xpath("//strong[contains(text(),'Invitation email to Members')]/../preceding-sibling::button[text()='×']");
	public By messageAfterConfirmation=By.xpath("//div[contains(text(),'Mail successfully sent')]");
	
	public ManageMembersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
}
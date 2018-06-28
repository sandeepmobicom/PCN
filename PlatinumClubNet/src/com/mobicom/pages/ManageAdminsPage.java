package com.mobicom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mobicom.helpers.Utility;

public class ManageAdminsPage extends Utility {

	WebDriver driver;
	
	public By manageAdminsOptionInMenu=By.xpath("//span[text()='Manage Admins']");
	public By adminListingHeader=By.xpath("//h3[text()='Sub Admin Listing']");
	public By addAdminButton=By.xpath("//span[contains(text(),'Add Admin')]");
	public By serialNumberColumn=By.xpath("//th[text()='Sr.No']");
	public By firstNameColumn=By.xpath("//th[contains(text(),'First Name')]");
	public By lastNameColumn=By.xpath("//th[contains(text(),'Last Name')]");
	public By registeredColumn=By.xpath("//th[contains(text(),'Registered?')]");
	public By actionColumn=By.xpath("//th[contains(text(),'Action')]");
	public By addAdminPageHeader=By.xpath("//h3[contains(text(),'Add Admin')]");
	public By firstNameField=By.id("first_name");
	public By lastnameField=By.id("last_name");
	public By emailField=By.id("email");
	public By cancelButton=By.xpath("//a[text()='Cancel']");
	public By AddAdminButtonInDetail=By.xpath("//button[contains(text(),'Add Admin')]");
	public By confirmationMessage=By.xpath("//div[contains(text(),'Admin updated successfully!')]");
	public By deleteButton=By.xpath("//a[text()='DELETE']");
	public By modifyButton=By.xpath("//a[text()='MODIFY']");
	public By deleteConfirmationMessage=By.xpath("//h5[contains(text(),'Are you sure to continue?')]");
	public By continueButton=By.xpath("//a[contains(text(),'Continue')]");
	
	public ManageAdminsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
}
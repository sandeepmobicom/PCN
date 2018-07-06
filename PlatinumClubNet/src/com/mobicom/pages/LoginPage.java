package com.mobicom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mobicom.helpers.Utility;

public class LoginPage extends Utility {

	WebDriver driver;

	public By username = By.xpath("//input[@name='username']");
	public By password = By.xpath("//input[@name='password']");
	public By loginButton = By.xpath("//button[@id='proceed-btn']");
	public By pageHeader = By.xpath("//h4[text()='Club Management System']");
	public By clubViewHeader = By.xpath("//h4[text()='Club Management System']");
	public By clubImage = By.xpath("//img[@class='profile-user-img img-responsive']");
	public By clubName = By.xpath("//h3[@class='profile-username text-center']");
	public By yearFoundedLabel = By.xpath("//b[text()='Year Founded']");
	public By yearFoundedValue = By.xpath("//b[text()='Year Founded']/following-sibling::a");
	public By clubTypeLabel = By.xpath("//b[text()='Year Founded']");
	public By clubTypeValue = By.xpath("//a[text()='Country Club']");
	public By totalMembersLabel = By.xpath("//b[text()='Total Members']");
	public By totalMembersValue = By.xpath("//b[text()='Total Members']/following-sibling::a");
	public By clubUrlLabel = By.xpath("//b[text()='Club URL']");
	public By clubUrlValue = By.xpath("//div[contains(@class,'ClubUrl')]");
	public By locationLabel = By.xpath("//strong[contains(text(),'Location')]");
	public By locationValue = By.xpath("//strong[contains(text(),'Location')]/following-sibling::div[contains(text(),'Bangalore')]");
	public By phoneFieldLabel = By.xpath("//strong[contains(text(),'Phone')]");
	public By phoneFieldValue = By.xpath("//strong[contains(text(),'Phone')]/../p[contains(text(),'9844098440')]");
	public By emailLabel = By.xpath("//strong[contains(text(),'Email')]");
	public By emailValue = By.xpath("//strong[contains(text(),'Email')]/../p");
	public By aboutUsTab = By.xpath("//a[contains(text(),'About Us')]");
	public By affiliatedClubsTab = By.xpath("//a[contains(text(),'Affiliated Clubs')]");
	public By boardMembersTab = By.xpath("//a[contains(text(),'Board Members')]");
	
	
	public By clubProfileMenu = By.xpath("//span[text()='Club Profile']");
	public By myClubSubMenu = By.xpath("//span[text()='My Club']");
	public By clubFacilitiesSubMenu = By.xpath("//span[text()='Club Facilities']");
	public By clubFacilitiesTitle = By.xpath("//h3[text()='Facilities on Your Club Profile']");
	public By dashBoardMenu = By.xpath("//span[text()='Dashboard']");
	public By dashBoardHeader = By.xpath("//h3[text()='Dashboard']");
	public By memberAccessDashBoardOption = By.xpath("//a[contains(text(),'Member Requests')]");
	public By addfacilityButton=By.xpath("//p[@class=\"card-header\"]/b");

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
package com.mobicom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mobicom.helpers.Utility;

public class ManageAdminsPage extends Utility {

	WebDriver driver;
	
	public By manageAdminsOptionInMenu=By.xpath("//span[text()='Manage Members']");

	
	public ManageAdminsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
}
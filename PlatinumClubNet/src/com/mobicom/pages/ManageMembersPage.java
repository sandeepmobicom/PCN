package com.mobicom.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mobicom.helpers.Utility;

public class ManageMembersPage extends Utility {

	WebDriver driver;
	File file = new File("./MemberTemplate.xls");
	FileInputStream inputstream;
	HSSFWorkbook workbook;
	String todaysDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

	public By manageMembersOptionInMenu = By.xpath("//span[text()='Manage Members']");
	public By memberListingHeader = By.xpath("//h3[text()='Member Listing']");
	public By sendInvitationButton = By.id("invite-all");
	public By bulkUploadButton = By.xpath("//button[@data-target='#myUpload']");
	public By serialNumberColumn = By.xpath("//th[text()='Sr.No.']");
	public By membershipNumberColumn = By.xpath("//th[contains(text(),'Membership Number')]");
	public By prefixColumn = By.xpath("//th[contains(text(),'Prefix')]");
	public By firstNameColumn = By.xpath("//th[contains(text(),'First Name')]");
	public By lastNameColumn = By.xpath("//th[contains(text(),'Last Name')]");
	public By emailIdColumn = By.xpath("//th[contains(text(),'Email ID')]");
	public By registeredColumn = By.xpath("//th[contains(text(),'Registered?')]");
	public By chooseFileButton = By.id("upload-file");
	public By uploadMembersButton = By.xpath("//button[text()='Upload Members']");
	public By confirmationMessage = By.xpath("//div/strong[contains(text(),'Success')]");
	public By confirmationHeader = By.xpath("//strong[contains(text(),'Invitation email to Members')]");
	public By confirmationText = By.xpath("//div[contains(text(),'Click \"OK\" to send an email')]");
	public By okButtonInConfirmationMessage = By.xpath("//button[@id='mailUserForReg']");
	public By closeButtonInConfirmationMessage = By
			.xpath("//strong[contains(text(),'Invitation email to Members')]/../preceding-sibling::button[text()='×']");
	public By messageAfterConfirmation = By.xpath("//div[contains(text(),'Mail successfully sent')]");

	public ManageMembersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void updateMemberExcel() {

		try {
			inputstream = new FileInputStream(file);
			workbook = new HSSFWorkbook(inputstream);
			HSSFSheet sheet = workbook.getSheet("MemberList");
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.err.println("Row count " + rowCount);
			for (int i = 1; i < rowCount; i++) {
				Row row = sheet.getRow(i);
				int cellCount = row.getPhysicalNumberOfCells();
				System.err.println("Cell count " + cellCount);
				row.getCell(0).setCellValue("Mr");
				row.getCell(1).setCellValue("Sandeep");
				row.getCell(2).setCellValue("Shetty");
				row.getCell(3).setCellValue("sandeepa" + todaysDate + "@mobicom.com");
				row.getCell(4).setCellValue(todaysDate);

				// System.err.println(cell.getStringCellValue());
				// for(int j=0;j<cellCount;j++) {
				// Cell cell=row.getCell(j);
				//// System.err.println(cell.getStringCellValue());
				// cell.setCellValue("test value");
				// }
			}
			workbook.write(file);

		} catch (IOException e) {
			log.error("Excel not updated");
		}

	}

}
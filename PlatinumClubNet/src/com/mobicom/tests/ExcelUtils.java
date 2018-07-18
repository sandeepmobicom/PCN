package com.mobicom.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.Test;


public class ExcelUtils {
	File file = new File("./MemberTemplate.xls");
	FileInputStream inputstream;
	HSSFWorkbook workbook;
	String todaysDate=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

	@Test
	public void updateMemberExcel() throws IOException {
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
			row.getCell(3).setCellValue("sandeepa"+todaysDate+"@mobicom.com");
			row.getCell(4).setCellValue(todaysDate);

			// System.err.println(cell.getStringCellValue());
			// for(int j=0;j<cellCount;j++) {
			// Cell cell=row.getCell(j);
			//// System.err.println(cell.getStringCellValue());
			// cell.setCellValue("test value");
			// }
		}
		
		workbook.write(file);

	}

}
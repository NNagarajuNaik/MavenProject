package excelFileHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.Test;

public class OlderExcelFileHandling {

	@Test
	public void countRowAndCells() throws Throwable {

		// read path of excel file
		FileInputStream fi = new FileInputStream("./src/test/resources/excelFiles/HSSF.xls");

		// get wb form file
		HSSFWorkbook workbook = new HSSFWorkbook(fi);

		// get sheet from wb
		HSSFSheet sheet = workbook.getSheet("Login");

		// get first row from sheet
		HSSFRow row = sheet.getRow(0);

		// count no of rows in sheet
		int rc = sheet.getLastRowNum();

		// count no of cells in first row
		int cc = row.getLastCellNum();

		System.out.println("No of rows are::" + rc + "    " + "No  of cells in first row::" + cc);

		fi.close();
		workbook.close();
	}

	@Test
	public void readData() throws Throwable {
		
		// read excel path
		FileInputStream fi = new FileInputStream("./src/test/resources/excelFiles/HSSF.xls");

		// get wb from file
		HSSFWorkbook wb = new HSSFWorkbook(fi);

		// get sheet from wb
		HSSFSheet ws = wb.getSheet("Login");

		// print second row first cell data
		String username = ws.getRow(1).getCell(0).getStringCellValue();

		// print second row second cell data
		String password = ws.getRow(1).getCell(1).getStringCellValue();

		System.out.println(username + "     " + password);

		fi.close();
		wb.close();
	}
}

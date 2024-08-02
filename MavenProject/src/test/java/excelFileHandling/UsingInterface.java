package excelFileHandling;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class UsingInterface {

	
	@Test
	void oldExcel() throws IOException {
		
		FileInputStream fi = new FileInputStream("./src/test/resources/excelFiles/HSSF.xls");

		// get wb from file
		Workbook workbook = WorkbookFactory.create(fi);

		// get sheet from wb
		Sheet worksheet = workbook.getSheet("Login");

		// get first row from login sheet
		Row row = worksheet.getRow(0);

		// count no of rows in a login sheet
		int rc = worksheet.getLastRowNum();

		// count no of cells in first row
		int cc = row.getLastCellNum();

		System.out.println("No of rows are::" + rc );
		System.out.println("No of cells in first row::" + cc);
		fi.close();
		workbook.close();
		
	}
	
	@Test
	void newExcel() throws IOException {
		
		FileInputStream fi = new FileInputStream("./src/test/resources/excelFiles/XSSF.xlsx");

		// get wb from file
		Workbook workbook = WorkbookFactory.create(fi);

		// get sheet from wb
		Sheet worksheet = workbook.getSheet("Login");

		// get first row from login sheet
		Row row = worksheet.getRow(0);
		
		// count no of rows in a login sheet
		int rc = worksheet.getLastRowNum();

		// count no of cells in first row
		int cc = row.getLastCellNum();

		System.out.println("No of rows are::" + rc );
		System.out.println("No of cells in first row::" + cc);
		fi.close();
		workbook.close();
		
	}
}

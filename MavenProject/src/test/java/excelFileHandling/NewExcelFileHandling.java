package excelFileHandling;

import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class NewExcelFileHandling {

	@Test
	public void countRowAndCells() throws Throwable {
		// read path of excel file
		FileInputStream fi = new FileInputStream("./src/test/resources/excelFiles/XSSF.xlsx");

		// get wb form file
		XSSFWorkbook wb = new XSSFWorkbook(fi);

		// get sheet from wb
		XSSFSheet ws = wb.getSheet("login");

		// get first row from sheet
		XSSFRow row = ws.getRow(0);

		// count no of rows in sheet
		int rc = ws.getLastRowNum();

		// count no of cells in first row
		int cc = row.getLastCellNum();

		System.out.println("No of rows are::" + rc + "    " + "No  of cells in first row::" + cc);

		fi.close();
		wb.close();

	}

	@Test
	public void readData() throws Throwable {

		// read excel path
		FileInputStream fi = new FileInputStream("./src/test/resources/excelFiles/XSSF.xlsx");

		// get wb from file
		XSSFWorkbook wb = new XSSFWorkbook(fi);

		// get sheet from wb
		XSSFSheet ws = wb.getSheetAt(0);

		// count no of rows in shgeet
		int rc = ws.getLastRowNum();

		System.out.println("No of rows are ::" + rc);

		// print second row first cell data
		String username = ws.getRow(1).getCell(0).getStringCellValue();

		// print second row second cell data
		String password = ws.getRow(1).getCell(1).getStringCellValue();

		System.out.println(username + "     " + password);

		fi.close();
		wb.close();

	}

	@Test
	public void readAllData() throws Throwable {

		// read excel path
		FileInputStream fi = new FileInputStream("./src/test/resources/excelFiles/XSSF.xlsx");

		// get wb from file
		XSSFWorkbook wb = new XSSFWorkbook(fi);

		// get sheet from wb
		XSSFSheet ws = wb.getSheetAt(0);

		// get row from sheet
		XSSFRow row = ws.getRow(0);

		int rc = ws.getLastRowNum();
		int cc = row.getLastCellNum();

		System.out.println(rc + "    " + cc);

		for (int i = 1; i <= rc; i++) {

			String username = ws.getRow(i).getCell(0).getStringCellValue();
			String password = ws.getRow(i).getCell(1).getStringCellValue();

			System.out.println(username + "   " + password);

		}

		fi.close();
		wb.close();
	}

	@Test
	public void readNumData() throws Throwable {

		// read excel path
		FileInputStream fi = new FileInputStream("./src/test/resources/excelFiles/Res.xlsx");

		// get wb from file
		XSSFWorkbook wb = new XSSFWorkbook(fi);

		// get sheet from wb
		XSSFSheet ws = wb.getSheetAt(0);

		// get row from sheet
		XSSFRow row = ws.getRow(0);

		int rc = ws.getLastRowNum();
		int cc = row.getLastCellNum();

		System.out.println(rc + "    " + cc);

//		String data1 = ws.getRow(1).getCell(1).toString();
//		
//		System.out.println(data1);

		for (int i = 1; i <= rc; i++) { // row

			for (int j = 0; j <= cc - 1; j++) { // cell

				String data = "";

				if (ws.getRow(i).getCell(j).getCellType() == CellType.NUMERIC) {

					int celldata = (int) ws.getRow(i).getCell(j).getNumericCellValue();

					data = String.valueOf(celldata);

				} else {

					data = ws.getRow(i).getCell(j).getStringCellValue();
				}

				System.out.print(data + " ");
			}
			System.out.println();
		}

		fi.close();
		wb.close();
	}

	@Test
	public void handlingemptyCell() throws Throwable {

		// read excel path
		FileInputStream fi = new FileInputStream("./src/test/resources/excelFiles/XSSF.xlsx");

		// get wb from file
		XSSFWorkbook wb = new XSSFWorkbook(fi);

		// get sheet from wb
		XSSFSheet ws = wb.getSheetAt(0);

		// get row from sheet
		XSSFRow row = ws.getRow(0);

		int rc = ws.getLastRowNum();

		int cc = row.getLastCellNum();

		System.out.println(rc + "    " + cc);

//		String data1 = ws.getRow(1).getCell(1).toString();
//		
//		System.out.println(data1);

		for (int i = 1; i <= rc; i++) {

			for (int j = 0; j <= cc - 1; j++) {

				String data = "";

				if (ws.getRow(i).getCell(j).getCellType() == CellType.NUMERIC) {

					int celldata = (int) ws.getRow(i).getCell(j).getNumericCellValue();

					data = String.valueOf(celldata);

				} else {

					data = ws.getRow(i).getCell(j).getStringCellValue();
				}

				System.out.print(data + " ");
			}
			System.out.println();
		}

		fi.close();
		wb.close();
	}

	@Test
	public void write() throws IOException {

		FileInputStream fi = new FileInputStream("./src/test/resources/excelFiles/XSSF.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fi);

		XSSFSheet worksheet = workbook.getSheetAt(0);

		worksheet.getRow(1).createCell(2).setCellValue("Pass");

		for (int i = 1; i <= worksheet.getLastRowNum(); i++) {

			String data = "pass";
			
			// wrting data
			worksheet.getRow(i).createCell(2).setCellValue(data);

			
			if (data.equalsIgnoreCase("pass")) {
				
				XSSFFont font = workbook.createFont();
				
				font.setColor(IndexedColors.GREEN.index);
				font.setBold(true);

				CellStyle style = workbook.createCellStyle();
				style.setFont(font);
				
				worksheet.getRow(i).getCell(2).setCellStyle(style);
			}

		}

		FileOutputStream fo = new FileOutputStream("./src/test/resources/excelFiles/XSSF.xlsx");

		workbook.write(fo);

		fo.close();
		fi.close();
		workbook.close();
	}

}

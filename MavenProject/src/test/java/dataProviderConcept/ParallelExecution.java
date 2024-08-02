package dataProviderConcept;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParallelExecution {
	


	@DataProvider(name = "Excel data",parallel = true)
	public String[][] getData() throws Exception {

		// read path of excel
		FileInputStream fi = new FileInputStream("./src/test/resources/excelFiles/ExcelData.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		
		XSSFSheet ws = wb.getSheetAt(0);
		
		XSSFRow row = ws.getRow(0);
		
		int rc = ws.getLastRowNum();
		
		int cc = row.getLastCellNum();
		
		System.out.println(rc + "   " + cc);
		
		String[][] data = new String[rc][cc];
		
		for (int i = 0; i < rc; i++) {   // row  1  2  3
			
			for (int j = 0; j < cc; j++) {  // cell  3 0   3 1    3 2

				if (ws.getRow(i).getCell(j).getCellType() == CellType.NUMERIC) {
					
					int celldata = (int) ws.getRow(i + 1).getCell(j).getNumericCellValue();
					data[i][j] = String.valueOf(celldata);
					
				} else {
					
					data[i][j] = ws.getRow(i + 1).getCell(j).getStringCellValue();
					
				}

			}
			System.out.println();
		}
		fi.close();
		wb.close();
		
		return data;

	}
	
	@Test(dataProvider = "Excel data")
	public void demo(String username, String password) throws InterruptedException {

		System.out.println(username + " and " + password);

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://primusbank.qedgetech.com/");
		Thread.sleep(2000);
		
		driver.findElement(By.id("txtuId")).sendKeys(username);
		Thread.sleep(2000);
		driver.findElement(By.id("txtPword")).sendKeys(password);
		Thread.sleep(2000);
		
		driver.close();

	}




}

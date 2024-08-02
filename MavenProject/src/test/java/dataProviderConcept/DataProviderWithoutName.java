package dataProviderConcept;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWithoutName {

	@DataProvider
	public String[][] data() {
		
		String[][]  data = new String[5][2];
		
		data[0][0] = "Admin";
		data[0][1] = "Admin";
		
		data[1][0] = "Admin123";
		data[1][1] = "Admin";
		
		data[2][0] = "Admin";
		data[2][1] = "Admin123";
		
		data[3][0] = "Admin123";
		data[3][1] = "Admin123";
		
		data[4][0] = "Admin";
		data[4][1] = "Admin";
		
		return data;
		
	}
	
	@Test(dataProvider = "data")
	public void validatelogin(String username,String password) throws Throwable {
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://primusbank.qedgetech.com/");
		Thread.sleep(5000);
		
		System.out.println(username+ "  "+password);
		
		driver.findElement(By.id("txtuId")).sendKeys(username);
		Thread.sleep(5000);
		driver.findElement(By.id("txtPword")).sendKeys(username);
		Thread.sleep(5000);
		
		
		driver.close();
		
	}
}

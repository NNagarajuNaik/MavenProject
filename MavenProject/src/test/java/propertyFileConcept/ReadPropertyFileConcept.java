package propertyFileConcept;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class ReadPropertyFileConcept {

	WebDriver driver;

	@Test
	public void login() throws IOException, IOException, InterruptedException {

		// To handle property file we are using Properties class
		Properties pro = new Properties();

		// Load the file we are using load()
		pro.load(new FileInputStream("./src/test/resources/propertyFiles/login.property"));

		// To read data we are using getProperty()
		if (pro.getProperty("browser").equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			
		} else if (pro.getProperty("browser").equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();

		} else if (pro.getProperty("browser").equalsIgnoreCase("ie")) {
			
			driver = new InternetExplorerDriver();
			driver.manage().deleteAllCookies();
		}
		
		driver.get(pro.getProperty("url"));
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(pro.getProperty("userlocator"))).sendKeys(pro.getProperty("username"));
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(pro.getProperty("passwordlocater"))).sendKeys(pro.getProperty("password"));
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(pro.getProperty("loginlocator"))).click();
		
		Thread.sleep(3000);
		driver.close();
	}

}

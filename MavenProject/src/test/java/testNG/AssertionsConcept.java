package testNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AssertionsConcept {

	@Test
	public void validating() throws Throwable {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("http://primusbank.qedgetech.com/");

		Thread.sleep(5000);

		String expected1 = "Government purchased 25%";

		String element = driver.findElement(By.xpath("(//p[@class='style7'])[3]")).getText();

		boolean result1 = element.contains(expected1);

		assertTrue(result1, "Element is not prasent");
		
		String expeceted2 = "to Admin";
		
		String data1 =driver.findElement(By.xpath("(//p[@class='style7'])[3]")).getText();
		
		boolean result2 = data1.contains(expeceted2);
		
		assertFalse(result2, "Element is there");

		String expectedData = "Primus Bank";
		String actualData = driver.findElement(By.xpath("//span[text()='Primus Bank']")).getText();

		assertEquals(actualData, expectedData,"Data is not matching");
		
		System.out.println("Data is there");
		
		System.out.println(result1);

		driver.close();

	}

}

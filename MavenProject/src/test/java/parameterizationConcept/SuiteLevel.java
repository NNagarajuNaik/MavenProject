package parameterizationConcept;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SuiteLevel {

	@Parameters({ "URL","usernameID","passwordID","username","password" })
	@Test
	public void m(String url,String userId,String passwordID,String user,String password) throws Throwable {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(url);
		Thread.sleep(3000);
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.id(userId)).sendKeys(user);
		Thread.sleep(3000);
		
		driver.findElement(By.id(passwordID)).sendKeys(password);
		
		
		Thread.sleep(2000);
		driver.close();

	}

}

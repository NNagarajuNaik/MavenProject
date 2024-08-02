package parameterizationConcept;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestLevel {

	@Parameters({ "URL" })
	@Test
	public void m(String url) throws Throwable {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(url);
		Thread.sleep(3000);
		
		System.out.println(driver.getTitle());
		
		Thread.sleep(2000);
		driver.close();

	}

}

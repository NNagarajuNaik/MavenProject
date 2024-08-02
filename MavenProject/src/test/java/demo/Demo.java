package demo;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo {

	@Test
	public void handlingWindow() throws Throwable {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/");

		driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("iphone");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);

		List<WebElement> items = driver.findElements(By.xpath("(//div[@id='wikipedia-search-result-link']//a)"));

		for (WebElement item : items) {
			
			item.click();
			Thread.sleep(3000);
			
		}

		Set<String> allWindows = driver.getWindowHandles();

		for (String window : allWindows) {

			String url = driver.switchTo().window(window).getCurrentUrl();
			System.out.println(url);
			Thread.sleep(2000);
			driver.close();

		}

		Thread.sleep(5000);
		driver.quit();

	}
}

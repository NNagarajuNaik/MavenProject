package testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeAndAfterMethodConcept {

	@BeforeTest
	public void beforeTest() {
		System.out.println("This is before test");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("This is after test");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is before method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("This is after method");
	}
	
	@Test
	public void m1() {
		System.out.println("This is method one");
	}
	
	@Test
	public void m2() {
		System.out.println("This is method two");
	}
	
	@Test
	public void m3() {
		System.out.println("This is method three");
	}
	
	@Test
	public void m4() {
		System.out.println("This is method four");
	}
	
}

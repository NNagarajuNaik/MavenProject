package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BeforeAndAfterClass {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("This is before suite");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("This is after suite");
	}
	
	@BeforeClass
	public void beforeMethod() {
		System.out.println("This is before class");
	}
	
	@AfterClass
	public void afterMethod() {
		System.out.println("This is after class");
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

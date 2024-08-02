package otherConcept;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class DependsOnMethodConcept {
	
	
	
	@Test()
	public void m1() {
		System.out.println("This is method one");
		
		assertTrue(true);
		//assertTrue(false);
	}
	
	@Test(dependsOnMethods = {"m1"})
	public void m2() {
		System.out.println("This is method two");
	}
	
	@Test()
	public void m3() {
		System.out.println("This is method three");
	}

}

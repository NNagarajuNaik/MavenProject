package otherConcept;

import org.testng.annotations.Test;

public class PriorityConcept {

	@Test(priority = 1)
	void m3() {
		System.out.println("This is method three");
	}
	
	@Test(priority = 2)
	void m1() {
		System.out.println("This is method one");
	}
	
	@Test(priority = 0)
	void m2() {
		System.out.println("This is method two");
	}
	
	
}

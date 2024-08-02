package groupsExecution;

import org.testng.annotations.Test;

public class Class3 {

	@Test(groups = {"smoke"})
	void m1() {
		System.out.println("This is class three method one");
	}
	
	@Test(groups = {"sanity"})
	void m2() {
		System.out.println("This is class three method two");
	}
	
	@Test(groups = {"regression"})
	void m3() {
		System.out.println("This is class three method three");
	}
}

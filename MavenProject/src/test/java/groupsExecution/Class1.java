package groupsExecution;

import org.testng.annotations.Test;

public class Class1 {

	@Test(groups = {"smoke","class1","m1"})
	void m1() {
		System.out.println("This is class one method one");
	}
	
	@Test(groups = {"sanity","class1","m2"})
	void m2() {
		System.out.println("This is class one method two");
	}
	
	@Test(groups = {"regression","class1","m3"})
	void m3() {
		System.out.println("This is class one method three");
	}
}

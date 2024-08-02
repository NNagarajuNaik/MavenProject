package otherConcept;

import org.testng.annotations.Test;

public class TimeOutConcept {

	// To pass test
	@Test(timeOut = 5000)
	public void m() throws InterruptedException {

		Thread.sleep(4000);
		System.out.println("Walmart");

	}

	// To fail test
	@Test(timeOut = 3000)
	public void m1() throws InterruptedException {

		Thread.sleep(4000);
		System.out.println("Walmart");

	}

}

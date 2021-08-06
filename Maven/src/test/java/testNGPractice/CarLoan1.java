package testNGPractice;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CarLoan1 {
	@Test
	public void CarLoan_1()
	{
		System.out.println("CarLoan1_1");
	}
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Before Test");
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("After Test");
	}
	
	@Test
	public void CarLoan_2()
	{
		System.out.println("CarLoan1_2");
	}
	
	@Test(groups = {"smoke"})
	public void CarLoan3()
	{
		System.out.println("CarLoan1_3 smoke");
	}
	
}

package testNGPractice;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CarLoan2 {
	@Test(priority = 0)
	public void CarLoan()
	{
		System.out.println("CarLoan2");
	}
	@Test(priority = -1)
	public void CarLoan_2()
	{
		System.out.println("CarLoan2_2");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Method");
	}
	
	
	@Test(groups = {"smoke"})
	public void CarLoan_3()
	{
		System.out.println("CarLoan2_3 Smoke");
		
	
	}
	
}

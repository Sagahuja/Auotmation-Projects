package testNGPractice;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PersonalLoan1 {
	@Test
	public void PersonalLoan()
	{
		System.out.println("PersonalLoan1");
	}
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Before Suite");
	}
	
}

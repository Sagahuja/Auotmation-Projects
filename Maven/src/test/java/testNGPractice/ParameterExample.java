package testNGPractice;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterExample {
	
	@Parameters({"TestName"})
	@Test
	public void sampleTest(String value)
	{
		System.out.println("Paramter TestNG : "+value);
	}
	
	

}

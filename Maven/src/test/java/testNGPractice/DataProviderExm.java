package testNGPractice;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
public class DataProviderExm {
	
	
	@Test(dataProvider = "getData")
	public void sampleTest(String firstName,String lastName)
	{
		System.out.println("DataProvider TestNG : "+firstName + " "+lastName);
	}
	
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data= new Object[2][2];
		
		data[0][0]="Yogesh";
		data[0][1]="Bansal";
		
		data[1][0]="Preeti";
		data[1][1]="Bansal";
		return data;
	}
	

}

package tests;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.LoginPage;
import utilities.BaseClass;

public class LoginPageTest extends BaseClass {

	@BeforeTest
	public void Driver() throws IOException
	{
		driver=inilizeDriver();
		driver.get(prop.getProperty("url_login"));
	}
	 @Test(dataProvider = "getTestDate")
	 public void checkLogin(String email, String password)
	 {
		
			
		 LoginPage loginObject= new LoginPage(driver);
		 
		 loginObject.getEmail().sendKeys(email);
		 loginObject.getPassword().sendKeys(password);
		 loginObject.getLoginButton().click();
		 
	 }
	
	 @DataProvider
	 public Object[][] getTestDate()
	 {
		 Object[][] data= new Object[1][2];
		 data[0][0]="TestEmail";
		 data[0][1]="TestPassword";
		 return data;
	 }
	 @AfterTest
	 public void closeBrowsesr()
	 {
		 driver.quit();
	 }
	 
}

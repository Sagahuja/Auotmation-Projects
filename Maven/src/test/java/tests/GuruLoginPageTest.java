package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DriverCommand;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.GuruLoginPage;
import pageobjects.GuruMangerPage;
import utilities.BaseClass;
import utilities.ExcelUtility;
public class GuruLoginPageTest extends BaseClass {

	WebDriver driver;
	ExcelUtility excelobject= new ExcelUtility();
	public boolean isAlertPresent(WebDriver driver) 
	{ 
	    try 
	    { 
	        driver.switchTo().alert(); 
	        return true; 
	    }   // try 
	    catch (NoAlertPresentException Ex) 
	    { 
	        return false; 
	    }   // catch 
	}
	@BeforeMethod
	public void inilizeBrowser() throws IOException
	{
		driver=inilizeDriver();
		driver.get(prop.getProperty("guru_URL"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(dataProvider = "getTestData")
	public void VerifyLoginSection(String username,String password) throws InterruptedException
	{
		GuruMangerPage manager=new GuruMangerPage(driver);
		GuruLoginPage login = new GuruLoginPage(driver);
		System.out.println(username +" "+ password);
		login.getLoginText().sendKeys(username);
		login.getPasswordText().sendKeys(password);
		login.enterLoginButton().click();
		Thread.sleep(3000);
		if(isAlertPresent(driver))
		{
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
		}
		else
		{
			System.out.println(driver.getTitle());
			
		}
	}
	
	@AfterMethod
	public void closeBrowesr() {
		driver.close();
	}
	@DataProvider
	public Object[][] getTestData() throws IOException
	{
		int rows= excelobject.getRowCount();
		int columns=excelobject.getColumnCount();
		System.out.println(rows);
		Object[][] data=new Object[rows][columns];
		
		for(int i=1; i<=rows; i++) {
			for(int j=0; j<columns; j++) {
				data[i-1][j]=excelobject.getCell("D:\\Downloads\\LoginData_1.xlsx", "Sheet1", i, j);
			}
		}
		
		return data;
		
		
	}
	
}

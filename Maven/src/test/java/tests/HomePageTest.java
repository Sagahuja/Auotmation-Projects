package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import utilities.BaseClass;

public class HomePageTest extends BaseClass {

	@BeforeTest
	public void Driver() throws IOException
	{
		driver=inilizeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void testTitle() throws IOException {
	
		
		
		HomePage home= new HomePage(driver);
		System.out.println(home.getTitle().getText());
		Assert.assertEquals(home.getTitle().getText(), "Featured Courses");
		
	}
	@Test(dependsOnMethods = {"testTitle"})
	public void testLogin() throws IOException {
		
		HomePage home= new HomePage(driver);
		home.getLogin().click();
		
	}
	
}

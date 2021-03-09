package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageobjects.PageSample;
import utilities.BaseClass;

public class SampleTest extends BaseClass {

	
	@Test
	public void test() throws IOException {
		driver=inilizeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		PageSample object= new PageSample(driver);
		object.checkbox2().click();
		

		
	}
	@Test
	public void test1() throws IOException   {
		
		System.out.println(prop.getProperty("browser"));
		
		System.out.println(prop.getProperty("url"));
		
		
	}
	
}

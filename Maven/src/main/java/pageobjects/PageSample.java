package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageSample {
	
	
	WebDriver driver;
	
	public PageSample(WebDriver driver)
	{
		//Concept of Page model
		//this.driver=driver;
		
		
		//Concept of page factory we use FindBy annotation
		PageFactory.initElements(driver, this);
	}
	//Concept of Page model
	/*
	 * By checkbox1=By.xpath("//*[@id='checkBoxOption1']");
	 * 
	 * public WebElement checkbox1() { return driver.findElement(checkbox1); }
	 */
	
	
	//Concept of page factory we use FindBy annotation
	
	
	@FindBy(xpath="//*[@id='checkBoxOption1']")
	WebElement checkbox2;
	public WebElement checkbox2()
	{
		return checkbox2;
	}
	
	
	
	
	

}

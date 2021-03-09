package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage  {
	WebDriver driver;
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	By title= By.xpath("//*[text()=\"Featured Courses\"]");
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	By login= By.cssSelector("a[href*='sign_in']");
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
		
	
	

}

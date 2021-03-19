package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GuruLoginPage { 
	
	WebDriver driver;
	
	public GuruLoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	By login= By.cssSelector("[name='uid']");
	public WebElement getLoginText()
	{
		return driver.findElement(login);
	}
	By password= By.cssSelector("[name='password']");
	public WebElement getPasswordText()
	{
		return driver.findElement(password);
	}
	By loginButton= By.cssSelector("[name='btnLogin']");
	public WebElement enterLoginButton()
	{
		return driver.findElement(loginButton);
	}


}

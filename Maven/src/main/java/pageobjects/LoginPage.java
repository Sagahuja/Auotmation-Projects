package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	By email= By.cssSelector("#user_email");
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	By password=By.cssSelector("#user_password");
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	By loginButton= By.cssSelector("input[type='submit']");
	public WebElement getLoginButton()
	{
		return driver.findElement(loginButton);
	}
	
	
}

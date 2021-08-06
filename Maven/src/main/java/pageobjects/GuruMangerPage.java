package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.BaseClass;

public class GuruMangerPage extends BaseClass {

	WebDriver driver;
	public GuruMangerPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By managerLink= By.cssSelector("a[href *='Managerhomepage.php']");
	
	public WebElement getManagerLink()
	{
		return driver.findElement(managerLink);
	}
	By managerId= By.xpath("//td[contains(text(),'Manger Id :')]");
	public WebElement getManagerId()
	{
		return driver.findElement(managerId);
	}
}

package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.LoginPage;
import utilities.BaseClass;

public class LoginPageTest extends BaseClass {
	WebDriver driver;
	LoginPage loginObject;

	@BeforeTest
	public void Driver() throws IOException {
		driver = inilizeDriver();
		driver.get(prop.getProperty("url_login"));
		loginObject = new LoginPage(driver);
	}

	@Test(dataProvider = "getTestDate")
	public void checkLogin(String email, String password) {

		

		loginObject.getEmail().sendKeys(email);
		loginObject.getPassword().sendKeys(password);
		loginObject.getLoginButton().click();

	}
	@Test
	public void checkWrongAlert() {
		
		Assert.assertEquals(loginObject.getcheckMsg().getText(), "Invalid email or password.");
	}

	@DataProvider
	public Object[][] getTestDate() {
		Object[][] data = new Object[1][2];
		data[0][0] = "TestEmail";
		data[0][1] = "TestPassword";
		return data;
	}

	@AfterTest
	public void closeBrowsesr() {
		driver.quit();
	}

}

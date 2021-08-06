package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FIS {
		public static void main(String[] args) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\src\\main\\java\\tools\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.google.co.in/");
			
			
			
		}

}

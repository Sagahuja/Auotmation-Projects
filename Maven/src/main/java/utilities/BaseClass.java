package utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//import Tests.ExcelDataDriven;

public class BaseClass {
	public Properties prop;
	public WebDriver driver;
	public ExtentReports er;
	public static Logger logs = LogManager.getLogger(BaseClass.class.getName());
	public WebDriver inilizeDriver() throws IOException {

		System.setProperty("webdriver.chrome.driver", "D:\\Downloads\\driver\\chromedriver.exe");
		System.out.println("test");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\think\\eclipse-workspace\\Maven\\resources\\Data.properties");
		prop.load(fis);
		return driver;
	}
	public String takeScreenShot(WebDriver driver,String testCaseName) throws IOException
	{
		TakesScreenshot ss= (TakesScreenshot)driver;
		File takenScreenShot= ss.getScreenshotAs(OutputType.FILE);
		String screenShotLocation= System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(takenScreenShot, new File(screenShotLocation));
		return screenShotLocation;
	}
	public ExtentReports generateReports() {
		
		String path=System.getProperty("user.dir")+"\\reports\\report.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Report");
		reporter.config().setReportName("Yogesh");
		reporter.config().setReportName("Web Automation Test Report");
		 er= new ExtentReports();
		 er.setSystemInfo("Tester", "Yogesh");
		er.attachReporter(reporter);
		return er;
	}

}

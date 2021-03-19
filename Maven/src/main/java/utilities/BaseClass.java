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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

//import Tests.ExcelDataDriven;

public class BaseClass {
	public Properties prop;
	public WebDriver driver;
	public ExtentReports er;
	public static Logger logs = LogManager.getLogger(BaseClass.class.getName());

	public WebDriver inilizeDriver() throws IOException {
		WebDriverManager.chromedriver().setup();
		//WebDriverManager.iedriver().setup();
		String browserName = System.getProperty("browser");
		System.out.println(browserName);
		ChromeOptions options = new ChromeOptions();
		if (browserName.contains("chrome")) {

			/*System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\tools\\chromedriver.exe");*/

			if (browserName.contains("headless")) {
				options.addArguments("headless");
				
			}

			driver = new ChromeDriver(options);
			//driver= new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\resources\\Data.properties");
		prop.load(fis);
		return driver;
	}

	public String takeScreenShot(WebDriver driver, String testCaseName) throws IOException {
		TakesScreenshot ss = (TakesScreenshot) driver;
		File takenScreenShot = ss.getScreenshotAs(OutputType.FILE);
		String screenShotLocation = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(takenScreenShot, new File(screenShotLocation));
		return screenShotLocation;
	}

	public ExtentReports generateReports() {

		String path = System.getProperty("user.dir") + "\\reports\\report.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Report");
		reporter.config().setReportName("Yogesh");
		reporter.config().setReportName("Web Automation Test Report");
		er = new ExtentReports();
		er.setSystemInfo("Tester", "Yogesh");
		er.attachReporter(reporter);
		return er;
	}

}

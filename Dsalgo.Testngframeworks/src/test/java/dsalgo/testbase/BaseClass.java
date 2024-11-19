package dsalgo.testbase;

import java.time.Duration;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import dsalgo.driverfactory.DriverFactory;
import dsalgo.utilities.ConfigReader;

import java.util.Date;

public class BaseClass {
	public WebDriver driver;
	public Logger logger;

	
	@BeforeMethod
	public void setUp() {

		DriverFactory.initializeBrowser(ConfigReader.getProperty("browser"));
		
		//String browser = ConfigReader.getBrowserType(); //for crossbrowser testing
		//DriverFactory.initializeBrowser(browser);
		
		driver = DriverFactory.getDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		//driver.get(ConfigReader.getProperty("appHomeURL"));
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void tearDown() {
		//driver.manage().deleteAllCookies();
		driver.quit();
	}

	
	
	
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public String randomNumber() {
		String generatedString = RandomStringUtils.randomNumeric(10);
		return generatedString;
	}

	public String randomAlphaNumeric() {
		String str = RandomStringUtils.randomAlphabetic(5);
		String num = RandomStringUtils.randomNumeric(3);

		return (str + "@" + num);

	}

	public String timeStamp() {
		Date date = new Date();
		String dateText = date.toString().replace(" ", "_").replace(":", "_");
		return dateText;
	}
	

}
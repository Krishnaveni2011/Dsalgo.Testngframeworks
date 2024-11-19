package dsalgo.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dsalgo.driverfactory.DriverFactory;
import dsalgo.pageobjects.HomePage;
import dsalgo.testbase.BaseClass;
import dsalgo.utilities.ConfigReader;


public class HomePageTest extends BaseClass {
	//WebDriver driver;
	ConfigReader reader = new ConfigReader();
	HomePage homepage;
	
	@BeforeMethod
	void setup() throws Throwable {
//		String browser = "chrome";// ConfigReader.getBrowserType();
//		DriverFactory.initializeBrowser(browser);
//		driver = DriverFactory.getDriver();
		
		//driver = DriverFactory.getDriver();	
		//HomePage_POM homepage = new HomePage_POM();
		homepage = new HomePage(driver);
    }
	
	@Test(priority=1)
	void testLandingPage() {	
		driver.get(reader.getProperty("appURL"));
		Assert.assertTrue(driver.getTitle().contains("Numpy Ninja"));
		System.out.println(homepage.isGetStartedpage());
		Assert.assertTrue(homepage.isGetStartedpage().contains("Preparing for the Interviews"));
		homepage.click_getstarted();
		Assert.assertTrue(driver.getTitle().contains("NumpyNinja"));
	}

	@Test(priority=2)
	void testDropdownOptionsInHomePage() {
		driver.get(reader.getProperty("appHomeURL"));
		//homepage.click_getstarted();
		String expectedDropdownOptions []= {"Arrays", "Linked List", "Queue", "Tree", "Stack","Graph"};
		for(int i = 0; i < expectedDropdownOptions.length;i++ ) {
			homepage.getdropdown(expectedDropdownOptions[i]);
			Assert.assertEquals(homepage.getalertmsg(),"You are not logged in");
		}	
	}
	
	@Test(priority=3)
	void testDSCardOptionsInHomePage() {
		driver.get(reader.getProperty("appHomeURL"));
	    //homepage.click_getstarted();
		String expectedDropdownOptions []= {"Data Structure-Introduction", "Arrays", "Linked List", "Queue", "Tree", "Stack","Graph"};
		for(int i = 0; i < expectedDropdownOptions.length;i++ ) {
			homepage.getstarted(expectedDropdownOptions[i]);
			Assert.assertEquals(homepage.getalertmsg(),"You are not logged in");
		}	
	}
	@Test(priority=4)
	void testRegisterform() {
		driver.get(reader.getProperty("appHomeURL"));
		homepage.click_register();
		Assert.assertEquals(homepage.registertitle(),"Registration");
		Assert.assertTrue(homepage.isRegistrationButtonPresent());
	}
	@Test(priority=5)
	void testSignInform() {
		driver.get(reader.getProperty("appHomeURL"));
		homepage.click_signin();
		Assert.assertEquals(driver.getTitle(),"Login");
		Assert.assertTrue(homepage.isloginbuttonpresent());
	}
//	@AfterClass
//	void tearDown() {
//		driver.quit();
//	}
	
	
}

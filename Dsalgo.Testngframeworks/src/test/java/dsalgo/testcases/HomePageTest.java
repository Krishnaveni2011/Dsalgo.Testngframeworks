package dsalgo.testcases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import dsalgo.pageobjects.HomePage;
import dsalgo.testbase.BaseClass;
import dsalgo.utilities.ConfigReader;



public class HomePageTest extends BaseClass {

	ConfigReader reader = new ConfigReader();
	HomePage homepage;
	
	@BeforeMethod
	void setup() throws Throwable {

		homepage = new HomePage();
    }
	
	@Test(priority=1)
	void testLandingPage() {	
		driver.get(reader.getProperty("appURL"));
		Assert.assertTrue(driver.getTitle().contains("Numpy Ninja"));
		Assert.assertTrue(homepage.isGetStartedpage().contains("Preparing for the Interviews"));
		homepage.click_getstarted();
		Assert.assertTrue(driver.getTitle().contains("NumpyNinja"));
	}

		
	@Test(dataProvider = "data-structures", dataProviderClass = DataProviderClass.class, priority=2)
	void testDropdownOptionsInHomePage(String option) {
		driver.get(reader.getProperty("appHomeURL"));
		homepage.getdropdown(option);
		Assert.assertEquals(homepage.getalertmsg(),"You are not logged in");
		
	}
	
	@Test(dataProvider = "data-structures", dataProviderClass = DataProviderClass.class, priority=3)
	void testDSCardOptionsInHomePage(String option) {
		driver.get(reader.getProperty("appHomeURL"));
		homepage.getstarted(option);
		Assert.assertEquals(homepage.getalertmsg(), "You are not logged in");
	    
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
	
}

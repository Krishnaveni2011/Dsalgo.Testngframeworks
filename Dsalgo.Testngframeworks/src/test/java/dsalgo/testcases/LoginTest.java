package dsalgo.testcases;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import dsalgo.utilities.ConfigReader;
import dsalgo.pageobjects.HomePage;
import dsalgo.pageobjects.LoginPage;
import dsalgo.testbase.BaseClass;
import dsalgo.driverfactory.DriverFactory;
import dsalgo.utilities.Loggerload;
import dsalgo.utilities.ExcelReader;

public class LoginTest extends BaseClass {
//		WebDriver driver = DriverFactory.getDriver();
	ConfigReader reader = new ConfigReader();
    HomePage homepage;

	LoginPage sign = new LoginPage();

//		@Parameters("browser")
//		@BeforeTest
//		public void OpenBrowser() throws Throwable {
//
//			String browser = "chrome";
//			DriverFactory.initializeBrowser(browser);
//			driver = DriverFactory.getDriver();
//
//		}
//
//		@AfterTest
//		public void Teardown() {
//			driver.close();
//
//		}

//		@BeforeClass
//		public void Launchapp() {
//
//			driver.get(ConfigReader.getProperty("appURL"));
//			
//
//		}
	
	@BeforeMethod
	public void signin () {
		driver.get(ConfigReader.getProperty("appURL"));	
		HomePage homepage = new HomePage();
		homepage.clickOnGetStartedButton();
	}
	
	@Test(priority = 1,dataProvider = "ValidLoginData", dataProviderClass = DataProviderClass.class)
	public void verify_validLogin(String username, String password, String expectedMessage) {
		HomePage homepage = new HomePage();
		LoginPage sign = new LoginPage();
		sign.signInclick();

		Loggerload.info("User Enter Login credential with username as \" " + username + "\" and password as\" "
				+ password + "\" ");
		if (username != null || password != null) {
			sign.setUsername(username);
			sign.setLoginPassword(password);
			sign.loginBtnclick();			
		}

		Assert.assertEquals(sign.getLoginValidationMessage(), expectedMessage);
		Loggerload.info("The user is on the " + driver.getTitle() + " home page and successfully logged in.");
	}
	
	@Test(priority = 2)
	public void Signout() {
		LoginPage sign = new LoginPage();
        sign.signOutlink();
	} 
		
	@Test(priority = 3, dataProvider = "InValidLoginData", dataProviderClass = DataProviderClass.class)
	public void verify_inValidLogin(String username, String password, String expectedMessage) {
		
		driver.get(ConfigReader.getProperty("appURL"));
		
		HomePage homepage = new HomePage();
		homepage.clickOnGetStartedButton();
		LoginPage sign = new LoginPage();		
		sign.signInclick();

		if (username != null || password != null) {
			sign.setUsername(username);
			sign.setLoginPassword(password);
			sign.loginBtnclick();
		}

		Loggerload.info("User Enter Login credential with username as \" " + username + "\" and password as\" "
				+ password + "\" ");
		String userNameValidationMessage = sign.getUserNameValidationMessage();
		String passwordValidationMessage = sign.getPasswordNameValidationMessage();
		if (username.isEmpty() && password.isEmpty()) {
			Assert.assertEquals(sign.getUserNameValidationMessage(), expectedMessage);
			Loggerload.error("The username textfield alert : " + expectedMessage);
		} else if (username.isEmpty() && !password.isEmpty()) {
			Assert.assertEquals(userNameValidationMessage, expectedMessage);
			Loggerload.error("The username textfield alert : " + expectedMessage);
		} else if (!username.isEmpty() && password.isEmpty()) {
			Assert.assertEquals(passwordValidationMessage, expectedMessage);
			Loggerload.error("The password textfield alert : " + expectedMessage);
		} else if (!username.isEmpty() && !password.isEmpty()) {
			String invalidgetMessage = sign.getInvalidLoginValidationMessage();
			Assert.assertEquals(invalidgetMessage, expectedMessage);
			if (expectedMessage.equals("Invalid Username and Password")) {
				Loggerload.info("If you don't have an account, please Register");
				sign.loginpageRegisterlinkclick();
				driver.navigate().back();
			}
			
		 else {
			Loggerload.info("User can able to register");
		}
		}
	}
}

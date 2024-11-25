package dsalgo.testcases;

import static org.testng.Assert.assertEquals;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dsalgo.pageobjects.HomePage;
import dsalgo.pageobjects.QueuePage;
import dsalgo.pageobjects.RegisterPage;
import dsalgo.testbase.BaseClass;
import dsalgo.utilities.ConfigReader;
import dsalgo.utilities.ExcelReader;
import dsalgo.utilities.Loggerload;
import dsalgo.utilities.Utils;

public class RegisterTest extends BaseClass {
	HomePage homepage;
	RegisterPage register;

	@BeforeMethod
	public void setup() {
		driver.get(ConfigReader.getProperty("appHomeURL"));
		homepage = new HomePage();
		register = new RegisterPage();
	}

	@Test(priority = 1)
	public void registersWithEmptyFields() {
		homepage.click_register();
		register.clickOnRegisterButton();

		Loggerload.info("User clicks on register button with empty fields");

		String errorMsg = register.emptyUserErrorMsg();
		assertEquals(errorMsg, "Please fill out this field.", "Error message mis match");
	}

	@Test(priority = 2)
	public void registerWithUsername() {

		homepage.click_register();
		register.enterUserName(ConfigReader.getProperty("username"));
		register.clickOnRegisterButton();

		Loggerload.info("User enter username and other fields empty");

		String errorMsg = register.emptyPwdErrorMsg();
		assertEquals(errorMsg, "Please fill out this field.", "Error message mis match");

	}

	@Test(priority = 3)
	public void registerWithUserAndPwd() {
		homepage.click_register();
		register.enterUserName(ConfigReader.getProperty("username"));
		register.enterPwd(ConfigReader.getProperty("password"));
		register.clickOnRegisterButton();

		Loggerload.info("User enter username, password & Pwd confirmation empty");

		String errorMsg = register.emptyPwdConfirmErrorMsg();
		assertEquals(errorMsg, "Please fill out this field.", "Error message mis match");

	}

	@Test(priority = 4)
	public void registerWithValidDetails() {
		homepage.click_register();
		register.enterUserName(randomAlphaNumeric());
		String user = register.getUserText();
		System.out.println(user);
		register.enterPwd(ConfigReader.getProperty("password"));
		register.enterPwdConfirm(ConfigReader.getProperty("password"));
		register.clickOnRegisterButton();

		Loggerload.info("User registers with valid details");

		String accCreationMsg = homepage.accountCreationMsg();
		assertEquals(accCreationMsg, "New Account Created. You are logged in as " + user,
				"Account creation msg is incorrect");
		
		homepage.clickSignOut();

	}

	@Test(priority = 5, dataProvider = "LoginData", dataProviderClass = DataProviderClass.class)
	public void loginWithValidDetails(String username,String pwd) {
		homepage.click_signin();
		homepage.enterUsername(username);
		homepage.enterLoginPwd(pwd);
		homepage.clickOnLoginBtn();

		Loggerload.info("User logins with valid details");

		assertEquals(register.getPageTitle(), "NumpyNinja", "Title mis match");
		
		homepage.clickSignOut();

	}
	

	@Test(priority = 6, dataProvider = "RegisterInvalidData", dataProviderClass = DataProviderClass.class)
	public void registerWithInvalidDetails(String username, String pwd, String pwdConfirm, String errorMsg) {
		
		homepage.click_register();
		register.enterUserName(username);
		register.enterPwd(pwd);
		register.enterPwdConfirm(pwdConfirm);
		register.clickOnRegisterButton();

		assertEquals(errorMsg, "password_mismatch:The two password fields didn’t match.", "Error message mis match");

	}
	
}

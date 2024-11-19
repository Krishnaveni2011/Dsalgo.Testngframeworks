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

public class RegisterTest extends BaseClass {
	HomePage homepage;
	RegisterPage register;
	QueuePage queuepage;

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
		register.enterUserName("numpy_rock");
		register.clickOnRegisterButton();

		Loggerload.info("User enter username and other fields empty");

		String errorMsg = register.emptyPwdErrorMsg();
		assertEquals(errorMsg, "Please fill out this field.", "Error message mis match");

	}

	@Test(priority = 3)
	public void registerWithUserAndPwd() {
		homepage.click_register();
		register.enterUserName("numpy_rock");
		register.enterPwd("testpass123");
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
		register.enterPwd("testpass@123");
		register.enterPwdConfirm("testpass@123");
		register.clickOnRegisterButton();

		Loggerload.info("User registers with valid details");

		String accCreationMsg = homepage.accountCreationMsg();
		assertEquals(accCreationMsg, "New Account Created. You are logged in as " + user,
				"Account creation msg is incorrect");

	}

	@Test(priority = 5, dataProvider = "LoginData")
	public void loginWithValidDetails(String username,String pwd) {
		homepage.click_signin();
		
		homepage.enterUsername(username);
		homepage.enterLoginPwd(pwd);
		homepage.clickOnLoginBtn();

		Loggerload.info("User logins with valid details");

		assertEquals(register.getPageTitle(), "NumpyNinja", "Title mis match");

	}
	
	@DataProvider(name="LoginData")
	public Object[][] logindata(){
		Object[][] data=ExcelReader.getTestDataFromExcel("logindata");
		return data ;
	}

	
	

	@Test(priority = 6, dataProvider = "InvalidData")
	public void registerWithInvalidDetails(String username, String pwd, String pwdConfirm, String errorMsg) {
		
		homepage.click_register();
		register.enterUserName(username);
		register.enterPwd(pwd);
		register.enterPwdConfirm(pwdConfirm);
		register.clickOnRegisterButton();

		assertEquals(errorMsg, "password_mismatch:The two password fields didn’t match.", "Error message mis match");

	}
	
	
	
	@DataProvider(name="InvalidData")
	public Object[][] getData(){
		Object[][] data=ExcelReader.getTestDataFromExcel("registerpage");
				
				return data;
	}
	



}

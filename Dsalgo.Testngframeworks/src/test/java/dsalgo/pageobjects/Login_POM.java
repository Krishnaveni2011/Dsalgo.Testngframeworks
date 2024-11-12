package dsalgo.pageobjects;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dsalgo.driverfactory.DriverFactory;
import dsalgo.utilities.ConfigReader;
import dsalgo.utilities.Loggerload;

public class Login_POM {
	WebDriver driver = DriverFactory.getDriver();
	
	boolean isRequired;
	
	
	@FindBy (xpath="/html/body/div[1]/div/div/a/button") WebElement getstarted;
	@FindBy (xpath="//*[@id=\"navbarCollapse\"]/div[2]/ul/a[3]") WebElement signin_button;	
	@FindBy (xpath="//*[@id='id_username']")static WebElement user;
	@FindBy (xpath="//*[@id='id_password']")static WebElement pwd;
	@FindBy (xpath="//*[@value='Login']")WebElement login_button;
	@FindBy (xpath="//div[@class='alert alert-primary']")WebElement alert;
	@FindBy (xpath="//a[@href='/register']")WebElement register;
	@FindBy (xpath="//a[@href='/logout']")WebElement signout;
	
	public Login_POM() {

		PageFactory.initElements(driver, this);
	}

	
	public void getstarted_button_link() {
		try
		{

			getstarted.click();
		}
		catch(Exception ex)
		{
			Loggerload.error("Error in getstarted method "+ex.getMessage());
		
		}

	}
	
	public String home_page() {
		
		String Title="";
		try
		{

		 Title = driver.getTitle();
		}
		catch(Exception ex)
		{
			Loggerload.error("Error in home_page method "+ex.getMessage());
		
		}
		return Title;
	}
	
	public void signin_button_link() {
		try
		{

			signin_button.click();
		}
		catch(Exception ex)
		{
			Loggerload.error("Error in signin page method "+ex.getMessage());
		
		}

	}
	
	public String signin_page() {
		
		String Title="";
		try
		{

		 Title = driver.getTitle();
		}
		catch(Exception ex)
		{
			Loggerload.error("Error in signin_page method "+ex.getMessage());
		
		}
		return Title;
	}


	public  Boolean doLogin (String username, String password) {
	
		try
		{			
			user.clear();
			user.sendKeys(username);
			pwd.clear();
			pwd.sendKeys(password);
	
			// To check empty fields , we need to check "required" field is on an attribute
			if (username.isBlank()) {
				JavascriptExecutor js_user = (JavascriptExecutor) driver;
				isRequired = (Boolean) js_user.executeScript("return arguments[0].required;", user);
				return isRequired;
			} else if (password.isBlank()) {
				JavascriptExecutor js_password = (JavascriptExecutor) driver;
				isRequired = (Boolean) js_password.executeScript("return arguments[0].required;", pwd);
				return isRequired;
	
			}
		}
		catch(Exception ex)
		{
			Loggerload.error("Error in doLogin method "+ex.getMessage());
		
		}
		return isRequired;
	}


	// input fields empty -click login
		public void login_button() {
			try
			{

				login_button.click();
			}
			catch(Exception ex)
			{
				Loggerload.error("Error in login_button method "+ex.getMessage());
			
			}

		}

		// login for excel sheet data
		public String click_login() {
			String msg="";
			try
			{

				login_button.click();
				 msg = alert.getText();
				
			}
			catch(Exception ex)
			{
				Loggerload.error("Error in click_login method "+ex.getMessage());
			
			}
			return msg;
		}

		public void register_link() {
			try
			{

				register.click();
			}
			catch(Exception ex)
			{
				Loggerload.error("Error in register_link method "+ex.getMessage());
			
			}
		}

		public String register_page() {
			String Title="";
			try
			{

			 Title = driver.getTitle();
			}
			catch(Exception ex)
			{
				Loggerload.error("Error in register_page method "+ex.getMessage());
			
			}
			return Title;
		}

		public void signout() {
			try
			{
				signout.click();
			}
			catch(Exception ex)
			{
				Loggerload.error("Error in signout method "+ex.getMessage());
			
			}
		}

	}



	



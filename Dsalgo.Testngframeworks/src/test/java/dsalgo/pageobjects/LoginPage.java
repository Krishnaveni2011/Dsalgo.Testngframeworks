package dsalgo.pageobjects;

//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dsalgo.driverfactory.DriverFactory;
//import dsalgo.utilities.ConfigReader;
//import dsalgo.utilities.Loggerload;

public class LoginPage {
	
WebDriver driver = DriverFactory.getDriver();
	
	@FindBy(xpath = "//a[text()='Sign in']")
	WebElement signIn;

	@FindBy(xpath = "//input[@id='id_username']")
	WebElement username;

	@FindBy(xpath = "//input[@id='id_password']")
	WebElement loginPassword;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginbtn;

	@FindBy(xpath = "//div[@class='alert alert-primary']")
	WebElement alertInvalidcredentials;
	
	@FindBy(xpath = "//div[@class='alert alert-primary']")
	WebElement alertLogoutcredentials;

	@FindBy(xpath = "//div[@class='alert alert-primary']")
	WebElement validcredentialstext;

	@FindBy(xpath = "//a[text()='Register!']")
	WebElement loginpageRegisterlink;

	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement registerLink;
	
	@FindBy (xpath="//a[@href='/logout']")WebElement signout;
	
	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

public String home_page() { 
		
		String Title="";
		 Title = driver.getTitle();		
		return Title;
	}
	public void signInclick() {		
		signIn.click();
	}
	
	public void signOutlink() {		
		signout.click();
	}

	public void setUsername(String userName) {
		username.sendKeys(userName);
	}

	public void setLoginPassword(String passWord) {
		loginPassword.sendKeys(passWord);
	}

	public void loginBtnclick() {
		loginbtn.click();
	}

	public String getLoginValidationMessage() {
		return validcredentialstext.getText();
	}
	

	public String getInvalidLoginValidationMessage() {
		return alertInvalidcredentials.getText();
	}
	
	public String getInvalidLogOutValidationMessage() {
		return alertLogoutcredentials.getText();
	}

	public String getActualTitle() {
		return driver.getTitle();
	}

	public void loginpageRegisterlinkclick() {
		loginpageRegisterlink.click();
	}

	public void registerLinkclick() {
		registerLink.click();
	}

	public String getUserNameValidationMessage() {
		return username.getAttribute("validationMessage");
	}

	public String getPasswordNameValidationMessage() {
		return loginPassword.getAttribute("validationMessage");
	}

	
}




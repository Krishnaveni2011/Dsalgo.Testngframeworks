package dsalgo.pageobjects;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dsalgo.driverfactory.DriverFactory;
import dsalgo.utilities.ConfigReader;
import io.cucumber.datatable.DataTable;

public class RegisterPage {

	WebDriver driver = DriverFactory.getDriver();

	@FindBy(id = "id_username")
	WebElement userName;
	@FindBy(id = "id_password1")
	WebElement pwd;
	// @FindBy(xpath="//input[@id='id_password']'") WebElement loginPwd;
	@FindBy(id = "id_password2")
	WebElement pwdConfirm;
	@FindBy(xpath = "//input[@value='Register']")
	WebElement registerBtn;
	@FindBy(xpath = "//div[@class='alert alert-primary']")
	WebElement errorMsg;

	public RegisterPage() {

		PageFactory.initElements(driver, this);
	}
	

	public String getUserText() {
		return userName.getAttribute("value");
	}

	public String getErrorMsg() {
		String msg = errorMsg.getText();
		return msg;
	}

	public void navigateToRegisterPage() {

		driver.get(ConfigReader.getProperty("registerUrl"));
	}

	public void enterUserName(String user) {
		userName.sendKeys(user);
	}

	public void enterPwd(String password) {
		pwd.sendKeys(password);
	}

	public void enterPwdConfirm(String pwdCon) {
		pwdConfirm.sendKeys(pwdCon);
	}

	public void clickOnRegisterButton() {
		registerBtn.click();

	}

	public String emptyUserErrorMsg() {
		return userName.getAttribute("validationMessage");
	}

	public String emptyPwdErrorMsg() {
		return pwd.getAttribute("validationMessage");
	}

	public String emptyPwdConfirmErrorMsg() {
		return pwdConfirm.getAttribute("validationMessage");
	}

	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public void enterValidUserName(DataTable dataTable) {
		List<Map<String, String>> dataMap = dataTable.asMaps(String.class, String.class);

		userName.sendKeys(dataMap.get(0).get("username"));

		// or

//		for (Map<String, String> data : dataMap) {
//			String user = data.get("username");
//			userName.sendKeys(user);
//			
//			
//		}

//			Map<String, String> data = dataTable.asMap(String.class, String.class);
//			userName.sendKeys(data.get("username"));

	}

	public void enterValidPwd(DataTable dataTable) {
		List<Map<String, String>> dataMap = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> data : dataMap) {
			String pass = data.get("password");
			pwd.sendKeys(pass);
		}
	}

	public void enterValidPasswordConfirm(DataTable dataTable) {
		List<Map<String, String>> dataMap = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> data : dataMap) {
			String passConfirm = data.get("passwordconfirm");
			pwdConfirm.sendKeys(passConfirm);

		}
	}

	public void getUserNameText() {
		userName.getText();
	}

}

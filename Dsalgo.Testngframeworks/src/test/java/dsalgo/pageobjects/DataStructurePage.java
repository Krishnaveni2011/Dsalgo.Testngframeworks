package dsalgo.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dsalgo.driverfactory.DriverFactory;

import dsalgo.utilities.Utils;

public class DataStructurePage {

	WebDriver driver = DriverFactory.getDriver();
	Utils eleUtil = new Utils();
	JavascriptExecutor jse = (JavascriptExecutor) driver;

	@FindBy(xpath = "/html/body/div[2]/div[1]/div/div/a")
	WebElement dsIntrolink;
	@FindBy(xpath = "/html/body/div[2]/ul/a")
	WebElement dstimecomplexity;
	@FindBy(xpath = "/html/body/div[2]/div/div[2]/a")
	WebElement dstryhere;
	@FindBy(xpath = "/html/body/div[2]/div/div[1]/div/a")
	WebElement dspracticequestion;
	@FindBy(xpath = "//*[@id=\"answer_form\"]/button")
	WebElement dsrunbutton;
	@FindBy(xpath = "//*[@id=\"answer_form\"]/div/div/div[6]/div[1]/div/div/div/div[5]/div/pre")
	WebElement dstryEditoranswer;
	@FindBy(xpath = "//*[@id='id_username']")
	static WebElement user;
	@FindBy(xpath = "//*[@id='id_password']")
	static WebElement pwd;
	@FindBy(xpath = "//*[@value='Login']")
	WebElement login_button;
	@FindBy(xpath = "/html/body/div[1]/div/div/a/button")
	WebElement getstarted;
	@FindBy(xpath = "//*[@id=\"answer_form\"]/div/div/div[1]/textarea")
	WebElement pythoninput;
	@FindBy(xpath = "//*[@id=\"output\"]")
	WebElement output;

	public DataStructurePage() {

		PageFactory.initElements(driver, this);
	}

	public void dsalgo_loginpage() {

		driver.get("https://dsportalapp.herokuapp.com/login");
	}

	public void Login(String username, String password) {

		user.clear();
		user.sendKeys("Rockstars_Numpy");
		pwd.clear();
		pwd.sendKeys("Numpy@Rock123");
	}

	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public void login_button() {

		login_button.click();
	}

	public void DS_getstarted() {

		dsIntrolink.click();

	}

	public void ds_timecomplexity() {

		dstimecomplexity.click();
	}

	public void ds_tryeditor() {

		dstryhere.click();
	}

	public void ds_tryeditoranswer() {

		dstryEditoranswer.click();

	}

	public void setCodepositive(String code) {
		dstryEditoranswer.click();
		pythoninput.sendKeys(code);
	}

	public void setCodenegative(String code) {
		// dstryEditoranswer.click();
		pythoninput.sendKeys(code);
	}

	public void ds_run() {

		dsrunbutton.click();
	}

	public String getAlertbox() {
		String errorMsg = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return errorMsg;
	}

	public void dsalgo_Timecomplexitypage()

			throws InterruptedException {

		try {
			jse.executeScript("window.scrollBy(0, 600)");
			dstimecomplexity.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void TimecomplexitypageTryEditor()

			throws InterruptedException {

		try {
			jse.executeScript("window.scrollBy(0, 600)");
			dstryhere.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigatetobackbutton() {
		driver.navigate().back();
	}

	public String getOutput() {

		return output.getText();
	}

	public void ds_practicequestion() throws InterruptedException {

		try {
			jse.executeScript("window.scrollBy(0, -600)");
			dspracticequestion.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

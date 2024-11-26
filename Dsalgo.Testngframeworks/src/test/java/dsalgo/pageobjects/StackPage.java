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
import dsalgo.utilities.Utils;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;


public class StackPage {
	
	WebDriver driver = DriverFactory.getDriver();
	Utils eleUtil = new Utils();
		
	JavascriptExecutor jse = (JavascriptExecutor) driver;
		
	@FindBy(xpath = "//a[@href='stack']")
	WebElement stack_getstarted;
	@FindBy(xpath = "/html/body/div[2]/ul[1]/a")
	WebElement operationinstack;
	@FindBy(xpath = "//a[@href='/tryEditor']")
	WebElement tryhere_operationinstack;	
	@FindBy(xpath = "//*[@id=\"answer_form\"]/div/div/div[6]/div[1]/div/div/div/div[5]/div/pre")
	WebElement answer;
	@FindBy(xpath = "//*[@id=\"output\"]")
	WebElement output;
	@FindBy(xpath = "//*[@id=\"answer_form\"]/button")
	WebElement runbutton;
	@FindBy(xpath = "/html/body/div[2]/ul[2]/a")
	WebElement implemenation_stack;	
	@FindBy(xpath = "/html/body/div[2]/ul[3]/a")
	WebElement application_stack;	
	@FindBy (xpath="//*[@id=\"content\"]/a") WebElement Question_Stack;
    @FindBy(xpath="//textarea[@tabindex='0']") WebElement Stack_pythoninput;
    @FindBy(id = "answer_form") WebElement answerForm;
	
    public StackPage() { 

		PageFactory.initElements(driver, this);
	}

	public String getStackPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public String getAlertbox() {
		String errorMsg = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return errorMsg;
	}
	
	public void navigatetobackbutton() {
		driver.navigate().back();
	}
	
	public void navigatetoStackpage() {
		driver.get(ConfigReader.getProperty("Stackpage"));
	}
	
	public void navigatetooperationStack() {
		driver.get(ConfigReader.getProperty("OperationsinStackpage"));
	} 
	
	public void navigatetoTryeditor() {
		driver.get(ConfigReader.getProperty("tryeditorurl"));
	}
	public void navigatetoimplementation() {
		driver.get(ConfigReader.getProperty("StackImplementationpage"));
	}
	public void navigatetoapplication() {
		driver.get(ConfigReader.getProperty("Applicationstackpage"));
	}
	public void navigatetorefresh() {
		driver.navigate().refresh();
	}
	
	public void setvalidcode(String code) {
		answerForm.click();
		Stack_pythoninput.sendKeys(code);
	}

	public void setinvalidcode(String code) {
		answerForm.click();
		Stack_pythoninput.sendKeys(code);
	}
	
	public String getActualResult() {
	
		return output.getText();
	}

	public void getstarted_stack() {

		stack_getstarted.click();
	}

	public void Operation_stack() {

		operationinstack.click();
	}

	public void Tryeditor_stack() {

		tryhere_operationinstack.click();
	}
	
	public void answer_stack() {
		answer.click();
	}
			
	public void Run_stack() {
		runbutton.click(); 
	}

	public void Implementation_Stack() 
		
		throws InterruptedException
		{		
			
			try {
				jse.executeScript("window.scrollBy(0, -600)");
				Thread.sleep(3000);
				implemenation_stack.click();
			} catch (Exception e) {			
				e.printStackTrace();
			}
			
		
	}

	
	public void Applications_Stack() 
		    throws InterruptedException
			{		
				
				try {
					jse.executeScript("window.scrollBy(0, 500)");
					Thread.sleep(3000);
					application_stack.click();
				} catch (Exception e) {			
					e.printStackTrace();
				}
				}
	
	public void Tryeditor_Stack() 
		    throws InterruptedException
			{		
				
				try {
					jse.executeScript("window.scrollBy(0, 500)");
					Thread.sleep(3000);
					tryhere_operationinstack.click();
				} catch (Exception e) {			
					e.printStackTrace();
				}
				}
	
	
	public void practicequestion_Stack() {
		Question_Stack.click();	
	}

}




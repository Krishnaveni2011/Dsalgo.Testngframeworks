package dsalgo.pageobjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dsalgo.utilities.ConfigReader;
import dsalgo.utilities.ExcelReading;
import dsalgo.utilities.Utils;

public class LinkedlistPage {
	
	private WebDriver driver;
	private ConfigReader configObj = new ConfigReader();
	
	@FindBy (xpath = "//input[@id = 'id_username']") WebElement Username;
	@FindBy (xpath = "//input[@id = 'id_password']") WebElement Password;
	@FindBy (xpath = "//input[@value = 'Login']") WebElement Login;
	
	@FindBy (xpath = "//a[@class='nav-link dropdown-toggle']") WebElement dropdown;
	@FindBy (xpath = "//a[@href='/linked-list']") WebElement dropdown_Linkedlist;
	@FindBy (xpath = "//a[@href='linked-list']") WebElement getstarted_linkedlist;
	
	//Topics covered
	@FindBy (xpath = "//a[@href='introduction']") WebElement Introduction;
	@FindBy (xpath = "//a[@href='creating-linked-list']") WebElement Creating_Linkedlist;
	@FindBy (xpath = "//a[@href='types-of-linked-list']") WebElement Types_of_linkedlist;
	@FindBy (xpath = "//a[@href='implement-linked-list-in-python']") WebElement Implement_LL_python;
	@FindBy (xpath = "//a[@href = 'traversal']") WebElement Traversal;
	@FindBy (xpath = "//a[@href = 'insertion-in-linked-list']") WebElement Insertion;
	@FindBy (xpath = "//a[@href = 'deletion-in-linked-list']") WebElement Deletion;
	
	@FindBy (xpath = "//a[@href = '/tryEditor']") WebElement Try_here;
	@FindBy (xpath = "//button[text() = 'Run']") WebElement Run;
	@FindBy (xpath = "//div[@class = 'CodeMirror-scroll']") WebElement editor_area;
	@FindBy (id = "output") WebElement output;
	@FindBy (xpath = "//a[@href='/linked-list/practice']") WebElement Practise_Qtns;
		
	public LinkedlistPage(WebDriver browserDriver) {
		driver = browserDriver;
		PageFactory.initElements(driver,this);
		}
	public void login(String username, String pwd) {
		Username.sendKeys(username);
		Password.sendKeys(pwd);
		
	}
	public void click_Login() {
	     Login.click();
	}
	public void click_getstarted_linkedlist() {
		getstarted_linkedlist.click();
	}
	public String Linkedlisttitle() {
		return driver.getTitle();
	}
	
	public void click_linkedListOptions(String linkedListOptions) {
		System.out.println(linkedListOptions);
		switch(linkedListOptions) {
		case "Introduction":
			Introduction.click();
			break;
		case "Creating Linked LIst":
			Creating_Linkedlist.click();
			break;
		case "Types of Linked List":
			Types_of_linkedlist.click();
			break;
		case "Implement Linked List in Python":
			Implement_LL_python.click();
			break;
		case "Traversal":
			Traversal.click();
			break;
		case "Insertion":
			Insertion.click();
			break;
		case "Deletion":
			Deletion.click();
			break;
		default:
			break;
			
		}
	}
	
	public void click_Try_here() {
		Try_here.click();
	}

	public void click_run() {
		Run.click();
	}
	
	public String getScriptOutput() {
		return output.getText();
	}
	
	public String getOutput(String sheetname, int rownumber) throws InvalidFormatException, IOException  {
		Utils utils = new Utils();
		String result = utils.getOutputFromExcel(sheetname, rownumber);
		return result;
	}
	
	public void enterPythonCode(String sheetname, int rownumber) throws InvalidFormatException, IOException  {
		Utils utils = new Utils();
		String code = utils.getCodefromExcel(sheetname, rownumber);
		this.enterCode(code);
	}

	public void enterCode(String code) {
		new Actions(driver).sendKeys(editor_area, code).perform();
	}
	

	public void click_Practise_Qtns() {
		Practise_Qtns.click();
	}

	
	
	
	

}
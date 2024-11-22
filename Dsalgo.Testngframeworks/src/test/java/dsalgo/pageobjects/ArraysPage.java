package dsalgo.pageobjects;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dsalgo.utilities.Utils;

public class ArraysPage {
	
	private WebDriver driver;
	Utils utils = new Utils();
	
	// Locators
	@FindBy (xpath = "//input[@id = 'id_username']") WebElement Username;
	@FindBy (xpath = "//input[@id = 'id_password']") WebElement Password;
	@FindBy (xpath = "//input[@value = 'Login']") WebElement Login;
	
	@FindBy (xpath = "//a[@href='array']") WebElement getstarted_array;
	@FindBy (xpath = "//a[@href ='arrays-in-python']") WebElement arrays_in_python;
	@FindBy (xpath ="//a[@href ='arrays-using-list']") WebElement arrays_using_list;
	@FindBy (xpath ="//a[@href ='basic-operations-in-lists']") WebElement basic_operations_in_lists;
	@FindBy (xpath ="//a[@href ='applications-of-array']") WebElement applications_of_array;
	@FindBy (xpath ="//a[@href='/tryEditor']") WebElement try_here;
	@FindBy (xpath = "//div[@class = 'CodeMirror-scroll']") WebElement CodeEditor;
	@FindBy (id = "output")WebElement Codeoutput;
	
	@FindBy (xpath = "//a[@href = '/array/practice']") WebElement Practise_Qtns;
	@FindBy (xpath = "//a[@href = '/question/1']") WebElement Question1;
	@FindBy (xpath = "//a[@href = '/question/2']") WebElement Question2;
	@FindBy (xpath = "//a[@href = '/question/3']") WebElement Question3;
	@FindBy (xpath = "//a[@href = '/question/4']") WebElement Question4;
	
	@FindBy (xpath = "//textarea[@tabindex='0']")WebElement Question_Input;
	@FindBy (xpath = "//button[text() = 'Run']") WebElement Run;
	@FindBy (xpath = "//input[@type = 'submit']") WebElement Submit;
	@FindBy (id = "output") WebElement QtnOutPut;
	

	public ArraysPage(WebDriver browserDriver) {
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
	public void click_getstarted_array() {
		getstarted_array.click();
	}
	
	public String arraytitle() {
		return driver.getTitle();
	}
		
	public void click_arrayOptions(String arrayOptions) {
		System.out.println(arrayOptions);
		switch(arrayOptions) {
		case "Arrays in Python":
			arrays_in_python.click();break;
		case "Arrays Using List":
			arrays_using_list.click();break;
		case "Basic Operations in Lists":
			basic_operations_in_lists.click();break;
		case "Applications of Array":
			applications_of_array.click();break;
		case "Practice Questions":
			Practise_Qtns.click();break;
		default:
			break;
			}
		}
	
	public void click_try_here() {
		try_here.click();
	}
	public void click_Practise_Qtns() {
		Practise_Qtns.click();
	}
	
	public void click_PractiseQtnsOptions(String Questions) {
		System.out.println(Questions);
		switch (Questions) {
		case "Search the array":
			Question1.click();break;
		case "Max Consecutive Ones":
			Question2.click();break;
		case "Find Numbers with Even Number of Digits":
			Question3.click();break;
		case "Squares of  a Sorted Array":
			Question4.click();break;
		default:
			break;
			}
	}
	
	public String practiceqtnstitle() {
		return driver.getTitle();
	}
	public void click_Run() {
		Run.click();
	}
	
	public void click_Submit() {
		Submit.click();
	}
	public String getEditorOutput() {
		return Codeoutput.getText();
	}
	public String getQtnOutPut() {
		return QtnOutPut.getText();
	}
	public String getActualResult() {
		utils.waitForElement(QtnOutPut);
		return QtnOutPut.getText();

	}
	
	public void enterPythonCode(String sheetname, int rownumber) throws InvalidFormatException, IOException  {
		Utils utils = new Utils();
		String code = utils.getCodefromExcel(sheetname, rownumber);
		this.enterCode(code);
	}
	public void enterCode(String code) {
         new Actions(driver).sendKeys(CodeEditor, code).perform();
	}
	
	public String getCodeoutput(String sheetname, int rownumber) throws InvalidFormatException, IOException  {
		
		String result = utils.getOutputFromExcel(sheetname, rownumber);
		return result;
	}	
	
	public void enterPythonCodePractice(String sheetname, int rownumber) throws InvalidFormatException, IOException, InterruptedException {
		String code = utils.getCodefromExcel(sheetname, rownumber);
		utils.enterCodePractice(code, Question_Input, driver);
	}
	
	public String getQtnOutPut(String sheetname, int rownumber) throws InvalidFormatException, IOException  {
		Utils utils = new Utils();
		String result = utils.getOutputFromExcel(sheetname, rownumber);
		return result;
	}
}
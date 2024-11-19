package dsalgo.pageobjects;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mongodb.diagnostics.logging.Logger;

import dsalgo.driverfactory.DriverFactory;
import dsalgo.utilities.ConfigReader;
import dsalgo.utilities.Loggerload;
import dsalgo.utilities.Utils;


public class QueuePage {

	WebDriver driver = DriverFactory.getDriver();
	Utils utils = new Utils();

	// Home_Page
	@FindBy(xpath = "//a[contains(text(),'Data Structures')]")
	WebElement dropDown;
	@FindBy(xpath = "//a[normalize-space()='Queue']")
	WebElement queueDropDown;

	// Queue_Page
	@FindBy(linkText = "Implementation of Queue in Python")
	WebElement impl_queue_pythonLink;
	@FindBy(linkText = "Implementation using collections.deque")
	WebElement impl_using_collection_deque_link;
	@FindBy(linkText = "Implementation using array")
	WebElement impl_using_array_Link;
	@FindBy(linkText = "Queue Operations")
	WebElement queue_operations_link;
	@FindBy(xpath = "//a[contains(text(),'Practice')]")
	WebElement practice_questions_link;

	// try editor
	@FindBy(xpath = "//a[contains(text(),'Try here')]")
	WebElement try_here_button;
	@FindBy(xpath = "//textarea[@tabindex='0']")
	WebElement textbox_editor;
	@FindBy(xpath = "//button[contains(text(),'Run')]")
	WebElement run_button;
	@FindBy(id = "output")
	WebElement output;

	public QueuePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void alerHandling() {
		driver.switchTo().alert().accept();
	}
	
	public void navigateBackToQueuePage() {
		driver.navigate().to(ConfigReader.getProperty("queueUrl"));
	}
	public void enterCodeInTryEditor(String pythonCode) {
		textbox_editor.sendKeys(pythonCode);
	}
	
	public String getActualResult() {

		return output.getText();
	}
	
	public void expectedResult() {
		
	}
	
	public boolean runBtnIsDisplayed() {
		return run_button.isDisplayed();
	}

	public String getQueuePageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public void navigateToTryEditor() {
		Loggerload.info("User is navigated to TryEditor page");
		driver.get(ConfigReader.getProperty("tryEditorUrl"));
		
	}
	public void navigateToQueuePage() {
		driver.get(ConfigReader.getProperty("queueUrl"));
		Loggerload.info("User is on Queue Page");
	}
	
	public void navigateToImpOfQueueInPythonLink() {
		Loggerload.info("User is on Implementation of Queue In Python Link");
		driver.get(ConfigReader.getProperty("qImpQuInPyUrl"));
	}
	
	public void navigateToImpUsingCollecDequeLink() {
		Loggerload.info("User is on Implementation using Collections.deque");
		driver.get(ConfigReader.getProperty("qImpCollDeqUrl"));
	}
	public void navigateToImpUsingArrayLink() {
		Loggerload.info("User is on Implementation using Array");
		driver.get(ConfigReader.getProperty("qImpUsgArrayUrl"));
	}
	public void navigateToQueueOperationsLink() {
		Loggerload.info("User is on Queue Operations Link");
		driver.get(ConfigReader.getProperty("qQueuOperaUrl"));
	}
	public void navigateToPracticeQuestLink() {
		Loggerload.info("User is on Practice Questions Link");
		driver.get(ConfigReader.getProperty("qPracticeQUrl"));
	}

	public void navigateToHomePage() {
		Loggerload.info("User is on home page");
		driver.get(ConfigReader.getProperty("appHomeURL"));
		
	}

	public void dropdown_queue() {
		Loggerload.info("User clicked on Data Structures dropdown");
		dropDown.click();
		Loggerload.info("The user selects queue from Data Structures dropdown");
		queueDropDown.click();
	}

	public void clickOnImpQueuePythonLink() {
		Loggerload.info("User clicks on Implementation of Queue in Python Link");
		impl_queue_pythonLink.click();
	}

	public void clickOnImpUsingCollectionDequeLink() {
		Loggerload.info("User clicks on Implementation using collection.deque link");
		impl_using_collection_deque_link.click();
	}

	public void clickOnImpUsingArray() {
		Loggerload.info("User click on Implementation using array");
		impl_using_array_Link.click();
	}

	public void clickOnQueueOperationsLink() {
		Loggerload.info("User clicks on Queue Operations Link");
		queue_operations_link.click();
	}

	public void clickOnPracticeQuestionLink() {
		Loggerload.info("User clicks on Practice Questions Link");
		practice_questions_link.click();

	}

	public void clickOnTryHereButton() {
		Loggerload.info("User clicks on Try Here button");
		try_here_button.click();
	}

	
	public void clickOnRunButton() {
		Loggerload.info("Users clicks on Run Button");
		run_button.click();
	}

	public String outputText() {
		Loggerload.info("Users gets output text");
		return output.getText();
	}

	

	public void enterPythonCode(String sheetname, int rownumber) throws InvalidFormatException, IOException  {
		
		String code = utils.getCodefromExcel(sheetname, rownumber);
		utils.enterCode(code, textbox_editor);
		
	}
	
	public String getExpectedResult(String sheetname, int rownumber) throws InvalidFormatException, IOException  {
		String result = utils.getOutputFromExcel(sheetname, rownumber);
		return result;
	}
	
	
	
	


	

}

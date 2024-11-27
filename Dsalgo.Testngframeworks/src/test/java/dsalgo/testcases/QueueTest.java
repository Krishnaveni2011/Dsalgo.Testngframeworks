package dsalgo.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dsalgo.pageobjects.HomePage;
import dsalgo.pageobjects.QueuePage;
import dsalgo.pageobjects.RegisterPage;
import dsalgo.testbase.BaseClass;
import dsalgo.utilities.ConfigReader;

public class QueueTest extends BaseClass {
	HomePage homepage;
	RegisterPage register;
	QueuePage queuepage;
	String title;

	@BeforeClass
	public void signIn() {

		driver.get(ConfigReader.getProperty("appHomeURL"));
		homepage = new HomePage();
		register = new RegisterPage();
		queuepage = new QueuePage();

		homepage.click_signin();
		homepage.enterUsername(ConfigReader.getProperty("username"));
		homepage.enterLoginPwd(ConfigReader.getProperty("password"));
		homepage.clickOnLoginBtn();

		assertEquals(register.getPageTitle(), "NumpyNinja", "Title mis match");
	}


	public void validCodeTryEditor(String code[]) {

		String pythonCode = (String) code[0];
		String output = (String) code[1];
		queuepage.enterCodeInTryEditor(pythonCode);
		queuepage.clickOnRunButton();

		String actualMsg = queuepage.getActualResult();
		assertEquals(actualMsg, output, "Result mis matched");

	}

	public void inValidCodeTryEditor(String code[]) {

		queuepage.enterCodeInTryEditor(code[0]);
		queuepage.clickOnRunButton();
		queuepage.alerHandling();
	}

	public void clickTryHereButton() {

		queuepage.clickOnTryHereButton();
		assertTrue(queuepage.runBtnIsDisplayed());

	}

	// Queue Page
	@Test(priority = 1)
	public void navigateToQueuePage() {

		queuepage.navigateToHomePage();
		queuepage.dropdown_queue();
		title = queuepage.getQueuePageTitle();
		assertEquals("Queue", title, "Title mis match");
	}

	// Implementation of Queue in Python
	@Test(priority = 2, dataProvider = "ValidCode", dataProviderClass = DataProviderClass.class)
	public void validImplQueueInPython(String code[]) {
		queuepage.navigateToQueuePage();
		queuepage.clickOnImpQueuePythonLink();
		title = queuepage.getQueuePageTitle();
		assertEquals(title, "Implementation of Queue in Python", "Title mis match");

		clickTryHereButton();
		validCodeTryEditor(code);

	}

	@Test(priority = 3, dataProvider = "InvalidCode", dataProviderClass = DataProviderClass.class)
	public void invalidImplQueueInPython(String code[]) {
		queuepage.navigateToQueuePage();
		queuepage.clickOnImpQueuePythonLink();
		title = queuepage.getQueuePageTitle();
		assertEquals(title, "Implementation of Queue in Python", "Title mis match");

		clickTryHereButton();
		inValidCodeTryEditor(code);


	}

	// Implementation using collections.deque
	@Test(priority = 4, dataProvider = "ValidCode", dataProviderClass = DataProviderClass.class)
	public void validImplUsingCollectionsDequePage(String code[]) {
		queuepage.navigateBackToQueuePage();
		queuepage.clickOnImpUsingCollectionDequeLink();
		title = queuepage.getQueuePageTitle();
		assertEquals(title, "Implementation using collections.deque", "Title mis match");

		clickTryHereButton();
		validCodeTryEditor(code);

	}

	@Test(priority = 5, dataProvider = "InvalidCode", dataProviderClass = DataProviderClass.class)
	public void inValidImplUsingCollectionsDequePage(String code[]) {
		queuepage.navigateBackToQueuePage();
		queuepage.clickOnImpUsingCollectionDequeLink();
		title = queuepage.getQueuePageTitle();
		assertEquals(title, "Implementation using collections.deque", "Title mis match");

		clickTryHereButton();
		inValidCodeTryEditor(code);

	}

	// Implementation using Array

	@Test(priority = 6, dataProvider = "ValidCode", dataProviderClass = DataProviderClass.class)
	public void validImplUsingArrayPage(String code[]) {
		queuepage.navigateToQueuePage();
		queuepage.clickOnImpUsingArray();
		title = queuepage.getQueuePageTitle();
		assertEquals(title, "Implementation using array", "Title mis match");

		clickTryHereButton();
		validCodeTryEditor(code);

	}

	@Test(priority = 7, dataProvider = "InvalidCode", dataProviderClass = DataProviderClass.class)
	public void inValidImplUsingArrayPage(String code[]) {
		queuepage.navigateBackToQueuePage();
		queuepage.clickOnImpUsingArray();
		title = queuepage.getQueuePageTitle();
		assertEquals(title, "Implementation using array", "Title mis match");

		clickTryHereButton();
		inValidCodeTryEditor(code);

	}

	// Queue Operations

	@Test(priority = 8, dataProvider = "ValidCode", dataProviderClass = DataProviderClass.class)
	public void validQueueOperationPage(String code[]) {

		queuepage.navigateToQueuePage();
		queuepage.clickOnQueueOperationsLink();
		title = queuepage.getQueuePageTitle();
		assertEquals(title, "Queue Operations", "Title mis match");

		clickTryHereButton();
		validCodeTryEditor(code);

	}

	@Test(priority = 9, dataProvider = "InvalidCode", dataProviderClass = DataProviderClass.class)
	public void inValidQueueOperationPage(String code[]) {

		queuepage.navigateBackToQueuePage();
		queuepage.clickOnQueueOperationsLink();
		title = queuepage.getQueuePageTitle();
		assertEquals(title, "Queue Operations", "Title mis match");

		clickTryHereButton();
		inValidCodeTryEditor(code);

	}

	// Practice Questions
	@Test(priority = 10)
	public void clickOnPracticeQLink() {

		queuepage.navigateToQueueOperationsLink();
		queuepage.clickOnPracticeQuestionLink();
		title = queuepage.getQueuePageTitle();
		assertEquals(title, "Practice Questions", "Title mis match");

	}

}
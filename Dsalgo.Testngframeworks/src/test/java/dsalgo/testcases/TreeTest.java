package dsalgo.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dsalgo.pageobjects.HomePage;
import dsalgo.pageobjects.QueuePage;
import dsalgo.pageobjects.RegisterPage;
import dsalgo.pageobjects.TreePage;
import dsalgo.testbase.BaseClass;
import dsalgo.utilities.ConfigReader;

public class TreeTest extends BaseClass {

	HomePage homepage;
	TreePage treepage;
	RegisterPage register;
	QueuePage queuepage;
	String title;

	@BeforeClass
	public void setup() {

		driver.get(ConfigReader.getProperty("appHomeURL"));
		homepage = new HomePage();
		treepage = new TreePage();
		register = new RegisterPage();
		queuepage = new QueuePage();

		homepage.click_signin();
		homepage.enterUsername(ConfigReader.getProperty("username"));
		homepage.enterLoginPwd(ConfigReader.getProperty("password"));
		homepage.clickOnLoginBtn();

		assertEquals(register.getPageTitle(), "NumpyNinja", "Title mis match");

	}

	public void validCodeTryEditor(String code[]) {

		String pythonCode = code[0];
		String output = code[1];
		queuepage.enterCodeInTryEditor(pythonCode);
		queuepage.clickOnRunButton();

		String actualMsg = queuepage.getActualResult();
		assertEquals(actualMsg, output, "Result mis matched");
	}

	public void inValidCodeTryEditor(String code) {

		queuepage.enterCodeInTryEditor(code);
		queuepage.clickOnRunButton();
		queuepage.alerHandling();
	}

	public void clickOnTryhereButton() {

		treepage.clickOnTryHereButton();
		assertTrue(treepage.runBtnIsDisplayed());

	}

	// Tree
	@Test(priority = 1)
	public void navigateToTreePage() {

		treepage.navigateToHomePage();
		treepage.dropDownTree();
		title = treepage.getTreePageTitle();
		assertEquals("Tree", title, "Title mis-match");
	}

	// Overview of Trees
	@Test(priority = 2, dataProvider = "ValidCode", dataProviderClass = DataProviderClass.class)
	public void validOverviewofTreePage(String code[]) {

		treepage.navigateToTreePage();
		treepage.clickOnOverviewOfTreesLink();
		title = treepage.getTreePageTitle();
		assertEquals(title, "Overview of Trees", "Title mis match");

		clickOnTryhereButton();
		validCodeTryEditor(code);
		
	}

	@Test(priority = 3, dataProvider = "InvalidCode", dataProviderClass = DataProviderClass.class)
	public void inValidOverviewofTreePage(String code) {

		treepage.navigateBackToTreePage();
		treepage.clickOnOverviewOfTreesLink();
		title = treepage.getTreePageTitle();
		assertEquals(title, "Overview of Trees", "Title mis match");

		clickOnTryhereButton();
		inValidCodeTryEditor(code);
		
	}

	// Terminologies
	@Test(priority = 4, dataProvider = "ValidCode", dataProviderClass = DataProviderClass.class)
	public void validTerminologiesPage(String code[]) {

		treepage.navigateBackToTreePage();
		treepage.clickOnTerminaLink();
		title = treepage.getTreePageTitle();
		assertEquals(title, "Terminologies", "Title mis match");

		clickOnTryhereButton();
		validCodeTryEditor(code);

	}

	@Test(priority = 5, dataProvider = "InvalidCode", dataProviderClass = DataProviderClass.class)
	public void inValidTerminologiesPage(String code) {

		treepage.navigateBackToTreePage();
		treepage.clickOnTerminaLink();
		title = treepage.getTreePageTitle();
		assertEquals(title, "Terminologies", "Title mis match");

		clickOnTryhereButton();
		inValidCodeTryEditor(code);

	}

	// Types of Trees
	@Test(priority = 6, dataProvider = "ValidCode", dataProviderClass = DataProviderClass.class)
	public void validTypesOfTreesPage(String code[]) {

		treepage.navigateBackToTreePage();
		treepage.clickOnTypsOfTreesLink();
		title = treepage.getTreePageTitle();
		assertEquals(title, "Types of Trees", "Title mis match");

		clickOnTryhereButton();
		validCodeTryEditor(code);

	}

	@Test(priority = 7, dataProvider = "InvalidCode", dataProviderClass = DataProviderClass.class)
	public void inValidTypesOfTreesPage(String code) {

		treepage.navigateBackToTreePage();
		treepage.clickOnTypsOfTreesLink();
		title = treepage.getTreePageTitle();
		assertEquals(title, "Types of Trees", "Title mis match");

		clickOnTryhereButton();
		inValidCodeTryEditor(code);


	}

	// Tree Traversals
	@Test(priority = 8, dataProvider = "ValidCode", dataProviderClass = DataProviderClass.class)
	public void validTreeTraversalsPage(String code[]) {

		treepage.navigateBackToTreePage();
		treepage.clickOnTreeTraversalsLink();
		title = treepage.getTreePageTitle();
		assertEquals(title, "Tree Traversals", "Title mis match");

		clickOnTryhereButton();
		validCodeTryEditor(code);


	}

	@Test(priority = 9, dataProvider = "InvalidCode", dataProviderClass = DataProviderClass.class)
	public void inValidTreeTraversalsPage(String code) {

		treepage.navigateBackToTreePage();
		treepage.clickOnTreeTraversalsLink();
		title = treepage.getTreePageTitle();
		assertEquals(title, "Tree Traversals", "Title mis match");

		clickOnTryhereButton();
		inValidCodeTryEditor(code);


	}

	// Traversals-Illustration
	@Test(priority = 10, dataProvider = "ValidCode", dataProviderClass = DataProviderClass.class)
	public void validTraverIllustrationPage(String code[]) {

		treepage.navigateBackToTreePage();
		treepage.clickOnTraverIllusLink();
		title = treepage.getTreePageTitle();
		assertEquals(title, "Traversals-Illustration", "Title mis match");

		clickOnTryhereButton();
		validCodeTryEditor(code);

	}

	@Test(priority = 11, dataProvider = "InvalidCode", dataProviderClass = DataProviderClass.class)
	public void inValidTraverIllustrationPage(String code) {

		treepage.navigateBackToTreePage();
		treepage.clickOnTraverIllusLink();
		title = treepage.getTreePageTitle();
		assertEquals(title, "Traversals-Illustration", "Title mis match");

		clickOnTryhereButton();
		inValidCodeTryEditor(code);
		
	
	}

	// Binary Trees
	@Test(priority = 12, dataProvider = "ValidCode", dataProviderClass = DataProviderClass.class)
	public void validBinaryTreesPage(String code[]) {

		treepage.navigateBackToTreePage();
		treepage.clickOnBinaryTreesLink();
		title = treepage.getTreePageTitle();
		assertEquals(title, "Binary Trees", "Title mis match");

		clickOnTryhereButton();
		validCodeTryEditor(code);
		

	}

	@Test(priority = 13, dataProvider = "InvalidCode", dataProviderClass = DataProviderClass.class)
	public void inValidBinaryTreesPage(String code) {

		treepage.navigateBackToTreePage();
		treepage.clickOnBinaryTreesLink();
		title = treepage.getTreePageTitle();
		assertEquals(title, "Binary Trees", "Title mis match");

		clickOnTryhereButton();
		inValidCodeTryEditor(code);
		

	}

	// Types of Binary Trees
	@Test(priority = 14, dataProvider = "ValidCode", dataProviderClass = DataProviderClass.class)
	public void validTypesOfBnryTreesPage(String code[]) {

		treepage.navigateBackToTreePage();
		treepage.clickOnTypsOfBinaryTreesLink();
		title = treepage.getTreePageTitle();
		assertEquals(title, "Types of Binary Trees", "Title mis match");

		clickOnTryhereButton();
		validCodeTryEditor(code);
		

	}

	@Test(priority = 15, dataProvider = "InvalidCode", dataProviderClass = DataProviderClass.class)
	public void inValidTypesOfBnryTreesPage(String code) {

		treepage.navigateBackToTreePage();
		treepage.clickOnTypsOfBinaryTreesLink();
		title = treepage.getTreePageTitle();
		assertEquals(title, "Types of Binary Trees", "Title mis match");

		clickOnTryhereButton();
		inValidCodeTryEditor(code);
		

	}

	// Implementation in Python
	@Test(priority = 16, dataProvider = "ValidCode", dataProviderClass = DataProviderClass.class)
	public void validImplInPythonPage(String code[]) {

		treepage.navigateBackToTreePage();
		treepage.clickOnImpInPythonLink();
		title = treepage.getTreePageTitle();
		assertEquals(title, "Implementation in Python", "Title mis match");

		clickOnTryhereButton();
		validCodeTryEditor(code);

	}

	@Test(priority = 17, dataProvider = "InvalidCode", dataProviderClass = DataProviderClass.class)
	public void inValidImplInPythonPage(String code) {

		treepage.navigateBackToTreePage();
		treepage.clickOnImpInPythonLink();
		title = treepage.getTreePageTitle();
		assertEquals(title, "Implementation in Python", "Title mis match");

		clickOnTryhereButton();
		inValidCodeTryEditor(code);
		
	}

	// Binary Tree Traversals
	@Test(priority = 18, dataProvider = "ValidCode", dataProviderClass = DataProviderClass.class)
	public void validBinaryTreeTraverPage(String code[]) {

		treepage.navigateBackToTreePage();
		treepage.clickOnBinaryTreeTravesLink();
		title = treepage.getTreePageTitle();
		assertEquals(title, "Binary Tree Traversals", "Title mis match");

		clickOnTryhereButton();
		validCodeTryEditor(code);
		
	}

	@Test(priority = 19, dataProvider = "InvalidCode", dataProviderClass = DataProviderClass.class)
	public void inValidBinaryTreeTraverPage(String code) {

		treepage.navigateBackToTreePage();
		treepage.clickOnBinaryTreeTravesLink();
		title = treepage.getTreePageTitle();
		assertEquals(title, "Binary Tree Traversals", "Title mis match");

		clickOnTryhereButton();
		inValidCodeTryEditor(code);
		
	}

	// Implementation of Binary Trees
	@Test(priority = 20, dataProvider = "ValidCode", dataProviderClass = DataProviderClass.class)
	public void validImplOfBinryTreesPage(String code[]) {

		treepage.navigateBackToTreePage();
		treepage.clickOnImplOfBinaryTreesLink();
		title = treepage.getTreePageTitle();
		assertEquals(title, "Implementation of Binary Trees", "Title mis match");

		clickOnTryhereButton();
		validCodeTryEditor(code);
		
	}

	@Test(priority = 21, dataProvider = "InvalidCode", dataProviderClass = DataProviderClass.class)
	public void inValidImplOfBinryTreesPage(String code) {

		treepage.navigateBackToTreePage();
		treepage.clickOnImplOfBinaryTreesLink();
		title = treepage.getTreePageTitle();
		assertEquals(title, "Implementation of Binary Trees", "Title mis match");

		clickOnTryhereButton();
		inValidCodeTryEditor(code);
		
	}

	// Applications of Binary trees
	@Test(priority = 22, dataProvider = "ValidCode", dataProviderClass = DataProviderClass.class)
	public void validAppOfBinaryTreesPage(String code[]) {

		treepage.navigateBackToTreePage();
		treepage.clickOnAppOfBinaryTreesLink();
		title = treepage.getTreePageTitle();
		assertEquals(title, "Applications of Binary trees", "Title mis match");

		clickOnTryhereButton();
		validCodeTryEditor(code);
		
	}

	@Test(priority = 23, dataProvider = "InvalidCode", dataProviderClass = DataProviderClass.class)
	public void inValidAppOfBinaryTreesPage(String code) {

		treepage.navigateBackToTreePage();
		treepage.clickOnAppOfBinaryTreesLink();
		title = treepage.getTreePageTitle();
		assertEquals(title, "Applications of Binary trees", "Title mis match");

		clickOnTryhereButton();
		inValidCodeTryEditor(code);
		
	}

	// Binary Search Trees
	@Test(priority = 24, dataProvider = "ValidCode", dataProviderClass = DataProviderClass.class)
	public void validBinarySearchTreePage(String code[]) {

		treepage.navigateBackToTreePage();
		treepage.clickOnBinarySearchTreesLink();
		title = treepage.getTreePageTitle();
		assertEquals(title, "Binary Search Trees", "Title mis match");

		clickOnTryhereButton();
		validCodeTryEditor(code);

	}

	@Test(priority = 25, dataProvider = "InvalidCode", dataProviderClass = DataProviderClass.class)
	public void inValidBinarySearchTreePage(String code) {

		treepage.navigateBackToTreePage();
		treepage.clickOnBinarySearchTreesLink();
		title = treepage.getTreePageTitle();
		assertEquals(title, "Binary Search Trees", "Title mis match");

		clickOnTryhereButton();
		inValidCodeTryEditor(code);

	}

	// Implementation Of BST
	@Test(priority = 26, dataProvider = "ValidCode", dataProviderClass = DataProviderClass.class)
	public void validImplOfBSTPage(String code[]) {

		treepage.navigateBackToTreePage();
		treepage.clickOnImplOfBSTLink();
		title = treepage.getTreePageTitle();
		assertEquals(title, "Implementation Of BST", "Title mis match");

		clickOnTryhereButton();
		validCodeTryEditor(code);

	}

	@Test(priority = 27, dataProvider = "InvalidCode", dataProviderClass = DataProviderClass.class)
	public void inValidImplOfBSTPage(String code) {

		treepage.navigateBackToTreePage();
		treepage.clickOnImplOfBSTLink();
		title = treepage.getTreePageTitle();
		assertEquals(title, "Implementation Of BST", "Title mis match");

		clickOnTryhereButton();
		inValidCodeTryEditor(code);

	}

	// Practice Questions
	@Test(priority = 28)
	public void practiceQuestionsPage() {

		treepage.navigateToImplOfBSTLink();
		treepage.clickOnPracticeQuestionLink();
		title = treepage.getTreePageTitle();
		assertEquals(title, "Practice Questions", "Title mis match");

	}

}

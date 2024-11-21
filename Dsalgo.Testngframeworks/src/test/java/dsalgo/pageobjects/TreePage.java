package dsalgo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dsalgo.driverfactory.DriverFactory;
import dsalgo.utilities.ConfigReader;
import dsalgo.utilities.Loggerload;

public class TreePage {


	WebDriver driver = DriverFactory.getDriver();

	// Home page
	@FindBy(xpath = "//a[contains(text(),'Data Structures')]")
	WebElement dropDown;
	@FindBy(xpath = "//a[text()='Tree']")
	WebElement treeDropDown;
	// (or) a[normalize-space()='Tree']
	
	@FindBy(xpath = "//a[contains(text(),'Try here')]")
	WebElement try_here_button;
	@FindBy(xpath = "//button[contains(text(),'Run')]")
	WebElement run_button;

	// Tree Page
	@FindBy(linkText = "Overview of Trees")
	WebElement overviewOfTreesLink;
	@FindBy(linkText = "Terminologies")
	WebElement terminologiesLink;
	@FindBy(linkText = "Types of Trees")
	WebElement typesOfTreesLink;
	@FindBy(linkText = "Tree Traversals")
	WebElement treeTraversalLink;
	@FindBy(linkText = "Traversals-Illustration")
	WebElement traversIllustLink;
	@FindBy(linkText = "Binary Trees")
	WebElement binaryTreesLink;
	@FindBy(linkText = "Types of Binary Trees")
	WebElement typsOfBinaryTreesLink;
	@FindBy(linkText = "Implementation in Python")
	WebElement implInPythonLink;
	@FindBy(linkText = "Binary Tree Traversals")
	WebElement binaryTreeTraverLink;
	@FindBy(linkText = "Implementation of Binary Trees")
	WebElement implOfBinaryTreesLink;
	@FindBy(linkText = "Applications of Binary trees")
	WebElement applOfBinaryTreesLink;
	@FindBy(linkText = "Binary Search Trees")
	WebElement binarySearchTreesLink;
	@FindBy(linkText = "Implementation Of BST")
	WebElement implOfBSTLink;
	@FindBy(xpath = "//a[contains(text(),'Practice')]")
	WebElement practice_questions_link;

	public TreePage() {
		PageFactory.initElements(driver, this);
	}

	public String getTreePageTitle() {
		
		String title = driver.getTitle();
		Loggerload.info("The page title is : "+title);
		return title;
	}
	
	public void clickOnTryHereButton() {
		Loggerload.info("User clicks on Try Here button");
		try_here_button.click();
	}
	public boolean runBtnIsDisplayed() {
		return run_button.isDisplayed();
	}

	public void navigateToHomePage() {
		driver.get(ConfigReader.getProperty("appHomeURL"));
		Loggerload.info("The user is navigated to Home Page : "+ConfigReader.getProperty("appHomeURL"));
	}
	
	public void dropDownTree() {
		Loggerload.info("The user clicks on Data Structures dropdown");
		dropDown.click();
		Loggerload.info("The user selects Tree from the drop down");
		treeDropDown.click();
	}

	public void navigateToTreePage() {
		 driver.get(ConfigReader.getProperty("treeUrl"));
		Loggerload.info("The is navigated to  Tree Page " );
	}
	
	public void navigateBackToTreePage() {
		 driver.get(ConfigReader.getProperty("treeUrl"));
		Loggerload.info("The is navigated to  Tree Page " );
	}

	public void navigateToOverviewTreeLink() {
		driver.get(ConfigReader.getProperty("OvrvieTreeUrl"));
		Loggerload.info("The is navigated to  Overview Tree Page " );
	}

	public void navigateToTerminaLink() {
		driver.get(ConfigReader.getProperty("TermiUrl"));
		Loggerload.info("The is navigated to  Terminologies page " );
	}

	public void navigateToTypsOfTreesLink() {
		driver.get(ConfigReader.getProperty("TypsOfTreeUrl"));
		Loggerload.info("The is navigated to Types of Tree Page " );
	}

	public void navigateToTreeTraversalsLink() {
		driver.get(ConfigReader.getProperty("TreeTraverUrl"));
		Loggerload.info("The is navigated to  Tree Traversals Page " );
	}

	public void navigateToTraverIllusLink() {
		driver.get(ConfigReader.getProperty("TraverIllusUrl"));
		Loggerload.info("The is navigated to  Traversals-Illustration page " );
	}

	public void navigateToBinaryTreesLink() {
		driver.get(ConfigReader.getProperty("BinryTreeUrl"));
		Loggerload.info("The is navigated to  Binary Trees Page " );
	}

	public void navigateToTypsOfBinaryTreesLink() {
		driver.get(ConfigReader.getProperty("TypsOfBnryTreeUrl"));
		Loggerload.info("The is navigated to  Types of BinaryTrees Page " );

	}

	public void navigateToImpInPythonLink() {
		driver.get(ConfigReader.getProperty("ImpInPythonUrl"));
		Loggerload.info("The is navigated to Implementation in Python Page " );
	}

	public void navigateToBinaryTreeTravesLink() {
		driver.get(ConfigReader.getProperty("BinryTreeTraverUrl"));
		Loggerload.info("The is navigated to  Binary Tree Traversals Page " );
	}

	public void navigateToImplOfBinaryTreesLink() {
		driver.get(ConfigReader.getProperty("ImpOfBnryTreeUrl"));
		Loggerload.info("The is navigated to  Implementation of Binary Trees Page " );
	}

	public void navigateToAppOfBinaryTreesLink() {
		driver.get(ConfigReader.getProperty("AppOfBnryTreeUrl"));
		Loggerload.info("The is navigated to Applications of Binary Trees Page " );
	}

	public void navigateToBinarySearchTreesLink() {
		driver.get(ConfigReader.getProperty("BnrySrchTreeUrl"));
		Loggerload.info("The is navigated to  Binary Search Trees Page " );
	}

	public void navigateToImplOfBSTLink() {
		driver.get(ConfigReader.getProperty("ImpOfBTSUrl"));
		Loggerload.info("The is navigated to Implementation of BST Page " );
	}

	public void clickOnOverviewOfTreesLink() {
		Loggerload.info("The user clicks on Overview of Trees Link");
		overviewOfTreesLink.click();
	}

	public void clickOnTerminaLink() {
		Loggerload.info("The user clicks on Terminologies Link ");
		terminologiesLink.click();
	}

	public void clickOnTypsOfTreesLink() {
		Loggerload.info("The user clicks on Types of Trees Link ");
		typesOfTreesLink.click();
	}

	public void clickOnTreeTraversalsLink() {
		Loggerload.info("The user clicks on Tree Traversals Link");
		treeTraversalLink.click();
	}

	public void clickOnTraverIllusLink() {
		Loggerload.info("The user clicks Traversals on Illustration Link ");
		traversIllustLink.click();
	}

	public void clickOnBinaryTreesLink() {
		Loggerload.info("The user clicks on Binary Trees Link ");
		binaryTreesLink.click();
	}

	public void clickOnTypsOfBinaryTreesLink() {
		Loggerload.info("The user clicks on Types of Binary Trees Link ");
		typsOfBinaryTreesLink.click();
	}

	public void clickOnImpInPythonLink() {
		Loggerload.info("The user clicks on Implementation in Python Link");
		implInPythonLink.click();
	}

	public void clickOnBinaryTreeTravesLink() {
		Loggerload.info("The user clicks on Binary Tree Traversals Link");
		binaryTreeTraverLink.click();
	}

	public void clickOnImplOfBinaryTreesLink() {
		Loggerload.info("The user clicks on Implementation of Binary Trees Link");
		implOfBinaryTreesLink.click();
	}

	public void clickOnAppOfBinaryTreesLink() {
		Loggerload.info("The user clicks on Applications of Binary Trees Link");
		applOfBinaryTreesLink.click();
	}

	public void clickOnBinarySearchTreesLink() {
		Loggerload.info("The user clicks on Binary Search Trees Link");
		binarySearchTreesLink.click();
	}

	public void clickOnImplOfBSTLink() {
		Loggerload.info("The user clicks on Implementation of BST Link");
		implOfBSTLink.click();
	}
	public void clickOnPracticeQuestionLink() {
		Loggerload.info("User clicks on Practice Questions Link");
		practice_questions_link.click();

	}
}
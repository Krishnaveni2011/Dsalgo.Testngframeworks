package dsalgo.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dsalgo.driverfactory.DriverFactory;

public class HomePage {

	private WebDriver driver = DriverFactory.getDriver();

	// 1.By locators
	@FindBy(xpath = "//h1[text()='Preparing for the Interviews']")
	WebElement Startpage;
	@FindBy(xpath = "//button[text()='Get Started']")
	WebElement getstarted;
	@FindBy(xpath = "//button[contains(text(),'Get Started')]")
	WebElement getStarted;
	// @FindBy (linkText = "//a[@class='navbar-brand']")WebElement text;

	// @Dropdown
	@FindBy(xpath = "//a[@class='nav-link dropdown-toggle']")
	WebElement dropdown;
	@FindBy(xpath = "//a[@class='dropdown-item']")
	List<WebElement> dropDownOptions;
	@FindBy(xpath = "//a[@href='/array']")
	WebElement dropdown_Arrays;
	@FindBy(xpath = "//a[@href='/linked-list']")
	WebElement dropdown_Linkedlist;
	@FindBy(xpath = "//a[@href='/stack']")
	WebElement dropdown_Stack;
	@FindBy(xpath = "//a[@href='/queue']")
	WebElement dropdown_Queue;
	@FindBy(xpath = "//a[@href='/tree']")
	WebElement dropdown_Tree;
	@FindBy(xpath = "//a[@href='/graph']")
	WebElement dropdown_Graph;

	// @Getstarted button
	@FindBy(xpath = "//a[@href='data-structures-introduction']")
	WebElement getstarted_datastructures;
	@FindBy(xpath = "//a[@href='array']")
	WebElement getstarted_array;
	@FindBy(xpath = "//a[@href='linked-list']")
	WebElement getstarted_linkedlist;
	@FindBy(xpath = "//a[@href='stack']")
	WebElement getstarted_stack;
	@FindBy(xpath = "//a[@href='queue']")
	WebElement getstarted_queue;
	@FindBy(xpath = "//a[@href='tree']")
	WebElement getstarted_tree;
	@FindBy(xpath = "//a[@href='graph']")
	WebElement getstarted_graph;
	@FindBy(xpath = "//div[@class='card h-100']")
	List<WebElement> DScards;

	// @alert message
	@FindBy(xpath = "//div[@class='alert alert-primary']")
	WebElement alertmsg;

	// @register
	@FindBy(linkText = "Register")
	WebElement Register;
	@FindBy(xpath = "//input[@value='Register']")
	WebElement RegisterBtn;
	@FindBy(linkText = "Sign in")
	WebElement Signin;
	@FindBy (linkText = "Sign out") 
	WebElement signOut;
	@FindBy(id = "id_username")
	WebElement loginUserName;
	@FindBy(id = "id_password")
	WebElement loginPwd;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement LoginBtn;
	@FindBy(xpath = "//div[contains(text(),'New Account Created.')]")
	WebElement newAccountMsg;

	// @constructor
	public HomePage() {
		PageFactory.initElements(driver, this);

	}

	// @page actions
	public void enterUsername(String username) {
		loginUserName.sendKeys(username);
	}

	public void enterLoginPwd(String pwd) {
		loginPwd.sendKeys(pwd);
	}

	public String accountCreationMsg() {
		return newAccountMsg.getText();
		// System.out.println(newAccountMsg.getText());
	}

	public void clickOnLoginBtn() {
		LoginBtn.click();
	}

	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public void clickOnGetStartedButton() {
		getStarted.click();
	}

	public void click_getstarted() {
		getstarted.click();
	}

	public String isGetStartedpage() {
		return Startpage.getText();
	}

	public int getTotalDataStructureCards() {
		return DScards.size();

	}

	public String hometitle() {
		return driver.getTitle();
	}

	public void click_dropdown() {
		dropdown.click();
	}

	public int getdropdowncount() {
		return dropDownOptions.size();
	}

	public void getdropdown(String dropdown_option) {

		System.out.println("Drop down option name: " + dropdown_option);
		dropdown.click();
		switch (dropdown_option) {
		case "Arrays":
			System.out.println("array case");
			dropdown_Arrays.click();
			break;
		case "Linked List":
			dropdown_Linkedlist.click();
			break;
		case "Stack":
			dropdown_Stack.click();
			break;
		case "Queue":
			dropdown_Queue.click();
			break;
		case "Tree":
			dropdown_Tree.click();
			break;
		case "Graph":
			dropdown_Graph.click();
			break;
		default:
			break;
		}
	}

	public void getstarted(String getstarted_options) {
		System.out.println(getstarted_options);
		switch (getstarted_options) {
		case "Data Structure-Introduction":
			getstarted_datastructures.click();
			break;
		case "Arrays":
			getstarted_array.click();
			break;
		case "Linked List":
			getstarted_linkedlist.click();
			break;
		case "Stack":
			getstarted_stack.click();
			break;
		case "Queue":
			getstarted_queue.click();
			break;
		case "Tree":
			getstarted_tree.click();
			break;
		case "Graph":
			getstarted_graph.click();
			break;
		default:
			break;
		}
	}

	public String getalertmsg() {
		return alertmsg.getText();
	}

	public boolean isalertmessageexist() {
		return alertmsg.isDisplayed();
	}

	public void click_register() {
		Register.click();
	}

	public String registertitle() {
		return driver.getTitle();
	}

	public boolean isRegistrationButtonPresent() {
		return RegisterBtn.isDisplayed();

	}

	public void click_signin() {
		Signin.click();
	}
	
	public void clickSignOut() {
		signOut.click();
	}
	
	public void navigateToBackPage() {
		driver.navigate().back();
	}

	public boolean isloginbuttonpresent() {
		return LoginBtn.isDisplayed();
	}

	public String signintitle() {
		return driver.getTitle();
	}

	// List<String>datastructures = new ArrayList<>();
//	public String[] datastructurecards() {
//		String[] datastructurecards = {"Data Structure-Introduction", "Arrays","Linked List","Stack","Queue","Tree","Graph"};
//		return datastructurecards;
//	}

}

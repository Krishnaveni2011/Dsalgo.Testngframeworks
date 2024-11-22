package dsalgo.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dsalgo.driverfactory.DriverFactory;
import dsalgo.pageobjects.HomePage;
import dsalgo.pageobjects.LinkedlistPage;
import dsalgo.testbase.BaseClass;
import dsalgo.utilities.ConfigReader;

public class LinkedListTest extends BaseClass {
	
	//WebDriver driver;
	ConfigReader reader = new ConfigReader();
	HomePage homepage;
	LinkedlistPage linkedList;
	
	@BeforeClass
	void userSignin() {
		linkedList = new LinkedlistPage(driver);
		driver.get(reader.getProperty("loginurl"));
		linkedList.login("Rockstars_Numpy", "Numpy@Rock123");
		linkedList.click_Login();
	}
	
	
	@BeforeMethod
	void setup() throws Throwable {
		driver.get(reader.getProperty("appHomeURL"));
		//linkedList.click_getstarted_linkedlist();
//		linkedList = new LinkedlistPage(driver);
//		driver.get(reader.getProperty("loginurl"));
//		linkedList.login("Rockstars_Numpy", "Numpy@Rock123");
//		linkedList.click_Login();
	}
	
	@Test(priority = 1)
	void testHomePage() {
		
		linkedList.click_getstarted_linkedlist();
		Assert.assertTrue(driver.getTitle().contains("Linked List"));
	}
	
	@Test(dataProvider = "linkedListOptions", dataProviderClass = DataProviderClass.class, priority = 2)
	void testLinkedListPage(String options, String Urls) {
		driver.get(reader.getProperty("Linkedlist_URL"));
		linkedList.click_linkedListOptions(options);
		Assert.assertTrue(driver.getCurrentUrl().contains(Urls));

	}
	@Test(dataProvider = "linkedListOptions", dataProviderClass = DataProviderClass.class, priority = 3)
	void testTryHereInLinkedList(String options,String Urls) {
		driver.get(Urls);
		linkedList.click_Try_here();
		Assert.assertEquals(driver.getCurrentUrl(), reader.getProperty("tryEditorUrl"));
		
	}
	@Test(dataProvider = "linkedListOptions", dataProviderClass = DataProviderClass.class, priority = 4)
	void testTryEditorRunEmpty(String options,String Urls) {
		driver.get(Urls);
		linkedList.click_Try_here();
		linkedList.click_run();
		Assert.assertEquals(linkedList.getScriptOutput(), "");
		
	}

	@Test(dataProvider = "excel-reader", dataProviderClass = DataProviderClass.class, priority = 5)
	void testTryEditorWithValidCode(String inputCode, String output, String url) {
		driver.get(url);
		linkedList.click_Try_here();
		linkedList.enterCode(inputCode);
        linkedList.click_run();
        Assert.assertEquals(output, linkedList.getScriptOutput());
	}
	@Test(dataProvider = "excel-reader", dataProviderClass = DataProviderClass.class, priority = 6)
	void testTryEditorWithInvalidCode(String inputCode, String output, String url) throws InvalidFormatException, IOException {
		driver.get(url);
		linkedList.click_Try_here();
        linkedList.enterCode(inputCode);
        linkedList.click_run();
        driver.switchTo().alert().accept();
        Assert.assertEquals(output,linkedList.getScriptOutput());

	}
	@Test(priority = 7)
	void testPracticeQuestionsInLL() {
		driver.get(reader.getProperty("Deletion_URL"));
		linkedList.click_Practise_Qtns();
		Assert.assertEquals(driver.getCurrentUrl(), reader.getProperty("PracticeQtns_URL"));
		
	}


}

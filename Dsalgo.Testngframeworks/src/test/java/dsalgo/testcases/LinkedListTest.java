package dsalgo.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
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
	
	@BeforeMethod
	void setup() throws Throwable {
//		String browser = "chrome";// ConfigReader.getBrowserType();
//		DriverFactory.initializeBrowser(browser);
		//driver = DriverFactory.getDriver();
		linkedList = new LinkedlistPage(driver);
		driver.get(reader.getProperty("loginurl"));
		linkedList.login("Rockstars_Numpy", "Numpy@Rock123");
		linkedList.click_Login();
	}
	
	@Test(priority = 1)
	void testHomePage() {
		
		linkedList.click_getstarted_linkedlist();
		Assert.assertTrue(driver.getTitle().contains("Linked List"));
		//driver.get(reader.getProperty("appHomeURL"));
	}
	
	@Test(priority = 2)
	void testLinkedListPage() {
		driver.get(reader.getProperty("Linkedlist_URL"));
		String expectedTopicOptions []= {"Introduction", "Creating Linked LIst", "Types of Linked List", "Implement Linked List in Python", "Traversal","Insertion", "Deletion"};
		String expectedTopicUrls [] = {
			reader.getProperty("Introduction_URL"),
			reader.getProperty("Creating_LL_URL"), 
			reader.getProperty("Types_of_LL_URL"), 
			reader.getProperty("Implement_LL_in_Python"), 
			reader.getProperty("Traversal_URL"), 
			reader.getProperty("Insertion_URL"), 
			reader.getProperty("Deletion_URL")
		};
		for(int i = 0; i < expectedTopicOptions.length; i++ ) {
			linkedList.click_linkedListOptions(expectedTopicOptions[i]);
			Assert.assertTrue(driver.getCurrentUrl().contains(expectedTopicUrls[i]));
		}
	}
	@Test(priority = 3)
	void testTryHereInLinkedList() {
		String expectedTopicUrls [] = {
			reader.getProperty("Introduction_URL"),
			reader.getProperty("Creating_LL_URL"), 
			reader.getProperty("Types_of_LL_URL"), 
			reader.getProperty("Implement_LL_in_Python"), 
			reader.getProperty("Traversal_URL"), 
			reader.getProperty("Insertion_URL"), 
			reader.getProperty("Deletion_URL")
		};
		for(int i = 0; i < expectedTopicUrls.length; i++ ) {
			driver.get(expectedTopicUrls[i]);
			linkedList.click_Try_here();
			Assert.assertEquals(driver.getCurrentUrl(), reader.getProperty("tryEditorUrl"));
			
		}
		
	}
	@Test(priority = 4)
	void testTryEditorRunEmpty() {
		String expectedTopicUrls [] = {
			reader.getProperty("Introduction_URL"),
			reader.getProperty("Creating_LL_URL"), 
			reader.getProperty("Types_of_LL_URL"), 
			reader.getProperty("Implement_LL_in_Python"), 
			reader.getProperty("Traversal_URL"), 
			reader.getProperty("Insertion_URL"), 
			reader.getProperty("Deletion_URL")
		};
		for(int i = 0; i < expectedTopicUrls.length; i++ ) {
			driver.get(expectedTopicUrls[i]);
			linkedList.click_Try_here();
			linkedList.click_run();
			Assert.assertEquals(linkedList.getScriptOutput(), "");
			}
	}
	
	@Test(priority = 5)
	void testTryEditorWithValidCode() throws InvalidFormatException, IOException {
		String expectedTopicUrls [] = {
				reader.getProperty("Introduction_URL"),
				reader.getProperty("Creating_LL_URL"), 
				reader.getProperty("Types_of_LL_URL"), 
				reader.getProperty("Implement_LL_in_Python"), 
				reader.getProperty("Traversal_URL"), 
				reader.getProperty("Insertion_URL"), 
				reader.getProperty("Deletion_URL")
			};
			for(int i = 0; i < expectedTopicUrls.length; i++ ) {
				driver.get(expectedTopicUrls[i]);
				linkedList.click_Try_here();
		        linkedList.enterPythonCode("Sheet1", 0);
		        linkedList.click_run();
		        Assert.assertEquals(linkedList.getOutput("Sheet1", 0),linkedList.getScriptOutput());
	        }
	}
	@Test(priority = 6)
	void testTryEditorWithInValidCode() throws InvalidFormatException, IOException {
		String expectedTopicUrls [] = {
				reader.getProperty("Introduction_URL"),
				reader.getProperty("Creating_LL_URL"), 
				reader.getProperty("Types_of_LL_URL"), 
				reader.getProperty("Implement_LL_in_Python"), 
				reader.getProperty("Traversal_URL"), 
				reader.getProperty("Insertion_URL"), 
				reader.getProperty("Deletion_URL")
			};
			for(int i = 0; i < expectedTopicUrls.length; i++ ) {
				driver.get(expectedTopicUrls[i]);
				linkedList.click_Try_here();
		        linkedList.enterPythonCode("Sheet1", 1);
		        linkedList.click_run();
		        driver.switchTo().alert().accept();
		        Assert.assertEquals(linkedList.getOutput("Sheet1", 1),linkedList.getScriptOutput());
	        }
	}
	@Test(priority = 7)
	void testPracticeQuestionsInLL() {
		driver.get(reader.getProperty("Deletion_URL"));
		linkedList.click_Practise_Qtns();
		Assert.assertEquals(driver.getCurrentUrl(), reader.getProperty("PracticeQtns_URL"));
		
	}
//	
//	@AfterClass
//	void tearDown() {
//		driver.quit();
//	}
	

}

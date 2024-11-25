package dsalgo.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import dsalgo.pageobjects.ArraysPage;
import dsalgo.pageobjects.HomePage;
import dsalgo.pageobjects.LinkedlistPage;
import dsalgo.testbase.BaseClass;
import dsalgo.utilities.ConfigReader;

public class ArraysTest extends BaseClass {
	
	//WebDriver driver;
	ConfigReader reader = new ConfigReader();
	HomePage homepage;
	LinkedlistPage linkedList;
	ArraysPage array;
	
	@BeforeClass
	void userSignin() {
		array = new ArraysPage(driver);
		driver.get(reader.getProperty("loginurl"));
		array.login("Rockstars_Numpy", "Numpy@Rock123");
		array.click_Login();
	}
	@BeforeMethod
	void setup() throws Throwable {
		
		driver.get(reader.getProperty("appHomeURL"));
	}

	@Test(priority = 1)
	void testHomePage() {
		array.click_getstarted_array();
		Assert.assertTrue(driver.getTitle().contains("Array"));
	}

	@Test(dataProvider = "arrayOptions", dataProviderClass = DataProviderClass.class, priority = 2)
	void testArrayPage(String options, String Urls) {
		driver.get(reader.getProperty("Arrays_URL"));
		array.click_arrayOptions(options);
    	Assert.assertTrue(driver.getCurrentUrl().contains(Urls));
	}

	@Test(dataProvider = "arrayOptions", dataProviderClass = DataProviderClass.class, priority = 3)
	void testTryHereInArrays(String options, String Urls) {
		driver.get(Urls);
		array.click_try_here();
		Assert.assertEquals(driver.getCurrentUrl(),reader.getProperty("tryEditorUrl"));
	}

	@Test(dataProvider = "arrayOptions", dataProviderClass = DataProviderClass.class, priority = 4)
	void testTryEditorRunEmpty(String options, String Urls) {
		driver.get(Urls);
		array.click_try_here();
		array.click_Run();
		Assert.assertEquals(array.getEditorOutput(),"");
	}

	@Test(dataProvider = "arrayexcel-reader", dataProviderClass = DataProviderClass.class, priority = 5)
	void testTryEditorWithValidCode(String inputCode, String output, String Urls) throws InvalidFormatException, IOException {
		driver.get(Urls);
		array.click_try_here();
		array.enterCode(inputCode);
		array.click_Run();
		Assert.assertEquals(output, array.getEditorOutput());
	}

	@Test(dataProvider = "arrayexcel-reader", dataProviderClass = DataProviderClass.class, priority = 6)
	void testTryEditorWithInvalidCode(String inputCode, String output, String Urls) throws InvalidFormatException, IOException {
		driver.get(Urls);
		array.click_try_here();
		array.enterCode(inputCode);
		array.click_Run();
		driver.switchTo().alert().accept();
		Assert.assertEquals(output, array.getEditorOutput());
	}

	@Test(priority = 7)
	void testPracticeQtnsInArrays() {
		driver.get(reader.getProperty("ApplicationsOfArray_URL"));
		 array.click_Practise_Qtns();
	}

	@Test(dataProvider = "arrayPracticeQtnsOptions", dataProviderClass = DataProviderClass.class, priority = 8)
	void testPracticeQtnsOptions(String options, String Urls) {
		driver.get(reader.getProperty("ArrayPracticeQtns_URL"));
		array.click_PractiseQtnsOptions(options);
		Assert.assertTrue(driver.getCurrentUrl().contains(Urls));

	}
	
	@Test(priority = 9)
	void testQtns1WithValidCodeAndRun() throws InvalidFormatException, IOException, InterruptedException {
			driver.get(reader.getProperty("ArrayPracticeQtns_URL"));
			driver.get(reader.getProperty("SearchTheArray_URL"));
			array.enterPythonCodePractice("Sheet1", 2);
			array.click_Run();
			Assert.assertEquals(array.getQtnOutPut("Sheet1", 2), array.getActualResult());	
	}
	
	@Test(priority = 10)
	void testQtns1WithValidCodeAndSubmit() throws InvalidFormatException, IOException, InterruptedException {
			driver.get(reader.getProperty("ArrayPracticeQtns_URL"));
			driver.get(reader.getProperty("SearchTheArray_URL"));
			array.enterPythonCodePractice("Sheet1", 3);
			array.click_Submit();
			Assert.assertEquals(array.getQtnOutPut("Sheet1", 3), array.getActualResult());	
	}
	
	@Test(priority = 11)
	void testQtns1WithInvalidCode() throws InvalidFormatException, IOException, InterruptedException {
		    driver.get(reader.getProperty("ArrayPracticeQtns_URL"));
			driver.get(reader.getProperty("SearchTheArray_URL"));
			array.enterPythonCodePractice("Sheet1", 1);
			array.click_Run();
			driver.switchTo().alert().accept();
			Assert.assertEquals(array.getQtnOutPut("Sheet1", 1), "");	
	}
	
	@Test(priority = 12)
	void testQtns2WithValidCodeAndRun() throws InvalidFormatException, IOException, InterruptedException {
			driver.get(reader.getProperty("ArrayPracticeQtns_URL"));
			driver.get(reader.getProperty("MaxConsecutiveOnes_URL"));
			array.enterPythonCodePractice("Sheet1", 4);
			array.click_Run();
			Assert.assertEquals(array.getQtnOutPut("Sheet1", 4), array.getActualResult());	
	}
	
	@Test(priority = 13)
	void testQtns2WithValidCodeAndSubmit() throws InvalidFormatException, IOException, InterruptedException {
			driver.get(reader.getProperty("ArrayPracticeQtns_URL"));
			driver.get(reader.getProperty("MaxConsecutiveOnes_URL"));
			array.enterPythonCodePractice("Sheet1", 5);
			array.click_Submit();
			Assert.assertEquals(array.getQtnOutPut("Sheet1", 5), array.getActualResult());	
	}
	
	@Test(priority = 14)
	void testQtns2WithInvalidCode() throws InvalidFormatException, IOException, InterruptedException {
		    driver.get(reader.getProperty("ArrayPracticeQtns_URL"));
			driver.get(reader.getProperty("MaxConsecutiveOnes_URL"));
			array.enterPythonCodePractice("Sheet1", 1);
			array.click_Run();
			driver.switchTo().alert().accept();
			Assert.assertEquals(array.getQtnOutPut("Sheet1", 1), "");	
	}
	
	@Test(priority = 15)
	void testQtns3WithValidCodeAndRun() throws InvalidFormatException, IOException, InterruptedException {
			driver.get(reader.getProperty("findNumbers_URL"));
			array.enterPythonCodePractice("Sheet1", 6);
			array.click_Run();
			Assert.assertEquals(array.getQtnOutPut("Sheet1", 6), array.getActualResult());	
	}
	
	@Test(priority = 16)
	void testQtns3WithValidCodeAndSubmit() throws InvalidFormatException, IOException, InterruptedException {
			driver.get(reader.getProperty("ArrayPracticeQtns_URL"));
			driver.get(reader.getProperty("findNumbers_URL"));
			array.enterPythonCodePractice("Sheet1", 7);
			array.click_Submit();
			Assert.assertEquals(array.getQtnOutPut("Sheet1", 7), array.getActualResult());	
	}
	
	@Test(priority = 17)
	void testQtns3WithInvalidCode() throws InvalidFormatException, IOException, InterruptedException {
		    driver.get(reader.getProperty("ArrayPracticeQtns_URL"));
			driver.get(reader.getProperty("findNumbers_URL"));
			array.enterPythonCodePractice("Sheet1", 1);
			array.click_Run();
			driver.switchTo().alert().accept();
			Assert.assertEquals(array.getQtnOutPut("Sheet1", 1), "");	
	}
	
	@Test(priority = 18)
	void testQtns4WithValidCodeAndRun() throws InvalidFormatException, IOException, InterruptedException {
		    driver.get(reader.getProperty("ArrayPracticeQtns_URL"));
			driver.get(reader.getProperty("sortedSquares_URL"));
			array.enterPythonCodePractice("Sheet1", 8);
			array.click_Run();
			Assert.assertEquals(array.getQtnOutPut("Sheet1", 8), array.getActualResult());	
	}
	
	@Test(priority = 19)
	void testQtns4WithValidCodeAndSubmit() throws InvalidFormatException, IOException, InterruptedException {
		    driver.get(reader.getProperty("ArrayPracticeQtns_URL"));
			driver.get(reader.getProperty("sortedSquares_URL"));
			array.enterPythonCodePractice("Sheet1", 9);
			array.click_Submit();
			Assert.assertEquals(array.getQtnOutPut("Sheet1", 9), array.getActualResult());	
	}
	
	@Test(priority = 20)
	void testQtns4WithInvalidCode() throws InvalidFormatException, IOException, InterruptedException {
			driver.get(reader.getProperty("ArrayPracticeQtns_URL"));
		    driver.get(reader.getProperty("sortedSquares_URL"));
			array.enterPythonCodePractice("Sheet1", 1);
			array.click_Run();
			driver.switchTo().alert().accept();
			Assert.assertEquals(array.getQtnOutPut("Sheet1", 1), "");	
	}
	
}

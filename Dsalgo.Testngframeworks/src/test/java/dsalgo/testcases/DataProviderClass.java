package dsalgo.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;

import dsalgo.utilities.ConfigReader;
import dsalgo.utilities.Utils;

public class DataProviderClass {
	
	ConfigReader reader = new ConfigReader();
	
	@DataProvider(name="LoginData")
	public Object[][] logindata(){
		Object[][] data=Utils.getTestDataFromExcel("logindata");
		return data;
	}
	
	@DataProvider(name="RegisterInvalidData")
	public Object[][] getData(){
		Object[][] data=Utils.getTestDataFromExcel("registerpage");		
		return data;
	}
	
	
	
	@DataProvider(name = "ValidCode")
	public static Object[][] validCode() {
		
		Object[][] data = Utils.getTestDataFromExcel("validcode");
		return data;

	}
	
	@DataProvider(name = "InvalidCode")
	public static Object[] invalidCode() {
		
		Object[] data = Utils.getTestDataFromExcel("invalidcode");
		return data;
	}
	
	@DataProvider (name = "data-structures")
	public Object[][] getDataStructures(Method m) {
		if (m.getName() == "testDropdownOptionsInHomePage") {
			return new Object[][] {{"Arrays"}, {"Linked List"}, {"Queue"}, {"Tree"}, {"Stack"}, {"Graph"}};
		} else if (m.getName() == "testDSCardOptionsInHomePage") {
			return new Object[][] {{"Data Structure-Introduction"}, {"Arrays"}, {"Linked List"}, {"Queue"}, {"Tree"}, {"Stack"}, {"Graph"}};
		}
		return null;
	}
	
	@DataProvider (name = "linkedListOptions")
	public Object[][] getLinkedListOptions(){
		
		return new Object[][] {
			{"Introduction", reader.getProperty("Introduction_URL")},
			{"Creating Linked LIst", reader.getProperty("Creating_LL_URL")},
			{"Types of Linked List", reader.getProperty("Types_of_LL_URL")},
			{"Implement Linked List in Python", reader.getProperty("Implement_LL_in_Python")},
			{"Traversal", reader.getProperty("Traversal_URL")},
			{"Insertion", reader.getProperty("Insertion_URL")},
			{"Deletion", reader.getProperty("Deletion_URL")},
		};
	}
	@DataProvider (name = "excel-reader")
	public Object[][] getCodeFromExcelSheet(Method m){
		Object[][] data = Utils.getTestDataFromExcel("Sheet1");
		String code = null;
		String output = null;
		if (m.getName() == "testTryEditorWithValidCode") {
			code = (String)data[0][0];
			output = (String)data[0][1];
		} else if (m.getName() == "testTryEditorWithInvalidCode") {
			code = (String)data[1][0];
			output = (String)data[1][1];
		}
		
		return new Object[][] {
			{code, output, reader.getProperty("Introduction_URL")},
			{code, output, reader.getProperty("Creating_LL_URL")},
			{code, output, reader.getProperty("Types_of_LL_URL")},
			{code, output, reader.getProperty("Implement_LL_in_Python")},
			{code, output, reader.getProperty("Traversal_URL")},
			{code, output, reader.getProperty("Insertion_URL")},
			{code, output, reader.getProperty("Deletion_URL")},
		};
	}
	
	@DataProvider (name = "arrayOptions")
	public Object[][] getArrayOptions(){
		return new Object[][] {
			{"Arrays in Python", reader.getProperty("ArrayInPython_URL")}, 
			{"Arrays Using List", reader.getProperty("ArraysUsingList_URL")}, 
			{"Basic Operations in Lists", reader.getProperty("BasicOperatnsInLists_URL")}, 
			{"Applications of Array", reader.getProperty("ApplicationsOfArray_URL")}
			};	
	}
	@DataProvider (name = "arrayexcel-reader")
	public Object[][] readCodeFromExcelSheet(Method m){
		Object[][] data = Utils.getTestDataFromExcel("Sheet1");
		String code = null;
		String output = null;
		if (m.getName() == "testTryEditorWithValidCode") {
			code = (String)data[0][0];
			output = (String)data[0][1];
		} else if (m.getName() == "testTryEditorWithInvalidCode") { 
			code = (String)data[1][0];
			output = (String)data[1][1];
		}
		
		return new Object[][] {
			{code, output, reader.getProperty("ArrayInPython_URL")},
			{code, output, reader.getProperty("ArraysUsingList_URL")},
			{code, output, reader.getProperty("BasicOperatnsInLists_URL")},
			{code, output, reader.getProperty("ApplicationsOfArray_URL")},
		};
	}
	

}

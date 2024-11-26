package dsalgo.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;
import dsalgo.utilities.ExcelReader;
import dsalgo.utilities.Utils;
import dsalgo.utilities.ConfigReader;


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
	
	@DataProvider (name = "arrayPracticeQtnsOptions")
	public Object[][] getArrayPracticeQtnOptions(){
		
		return new Object[][] {
			{"Search the array", reader.getProperty("SearchTheArray_URL")},
			{"Max Consecutive Ones", reader.getProperty("MaxConsecutiveOnes_URL")},
			{"Find Numbers with Even Number of Digits", reader.getProperty("findNumbers_URL")},
			{"Squares of  a Sorted Array", reader.getProperty("sortedSquares_URL")},
		};
	}
	

	@DataProvider(name = "TryEditorCode")
	public static Object[][] code(Method m) {

		Object[][] data = Utils.getTestDataFromExcel("tryeditorcode");

		Object[][] validCode = {{ data[0][0], data[0][1] } };

		Object[][] inValidCode = {{ data[1][0] } };

		System.out.println("Method Name: " + m.getName());

		switch (m.getName()) {

		case "validImplQueueInPython":
		case "validImplUsingCollectionsDequePage":
		case "validImplUsingArrayPage":
		case "validQueueOperationPage":

			return validCode;

		case "invalidImplQueueInPython":
		case "inValidImplUsingCollectionsDequePage":
		case "inValidImplUsingArrayPage":
		case "inValidQueueOperationPage":

			return inValidCode;
		
		default:
			return null;
		}

	}
	
	ExcelReader excelReader = new ExcelReader(ConfigReader.getExcelFilePath());
	@DataProvider(name = "ValidLoginData")
	public String[][] getValidLoginData() throws IOException {
		int totalrows = excelReader.getRowCount("Login");
		int totalcols = excelReader.getCellCount("Login", 1);
		System.out.println("The Total Rows : " + totalrows);
		System.out.println("The Total Coulmns : " + totalcols);
		String[][] validLoginData = new String[1][3];
		validLoginData[0][0] = excelReader.getCellData("Login", 1, 0);
		validLoginData[0][1] = excelReader.getCellData("Login", 1, 1);
		validLoginData[0][2] = excelReader.getCellData("Login", 1, 2);
		return validLoginData; 
	}

	@DataProvider(name = "InValidLoginData")
	public String[][] getInValidLoginData() throws IOException {
		int totalrows = excelReader.getRowCount("Login");
		int totalcols = excelReader.getCellCount("Login", 1);
		System.out.println("Total Rows = " + totalrows + ", Total Columns = " + totalcols);
		String[][] invalidLoginData = new String[totalrows-1][3];
		System.out.println("Invalid Login data " + invalidLoginData);
		for (int i = 2; i < 7; i++) {
			for (int j = 0; j < 3; j++) {
				invalidLoginData[i - 2][j] = excelReader.getCellData("Login", i, j);
				System.out.println(invalidLoginData[i - 2][j]);
			}
		}
		return invalidLoginData;
	}
	@DataProvider(name = "DataTryEditorValidCode")
	public String[][] getDataTryEditorPositive() throws IOException {
		String[][] validCode = new String[1][2];
		for (int i = 1; i < 2; i++) {
			validCode[i-1][0] = excelReader.getCellData("validcode", i, 0);
			validCode[i-1][1] = excelReader.getCellData("validcode", i, 1);
			System.out.println("The data is " + validCode[i-1][0] + ",");
			System.out.println("The data is " + validCode[i-1][1] + ",");
	}
		return validCode;
	}

	@DataProvider(name = "DataTryEditorInvalidCode")
	public String[][] getDataTryEditorNegative() throws IOException {
		String[][] inValidCode = new String[1][2];
		for (int i = 1; i < 2; i++) {			
			inValidCode[i-1][0] = excelReader.getCellData("invalidcodeveni", i, 0);
			inValidCode[i-1][1] = excelReader.getCellData("invalidcodeveni", i, 1);
			System.out.println("The data is " + inValidCode[i-1][0] + ",");
			System.out.println("The data is " + inValidCode[i-1][1] + ",");
		}
		
		return inValidCode;
	}
}





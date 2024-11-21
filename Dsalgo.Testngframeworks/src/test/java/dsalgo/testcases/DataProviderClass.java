package dsalgo.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import dsalgo.utilities.ExcelReader;
import dsalgo.utilities.Utils;
import dsalgo.utilities.ConfigReader;


public class DataProviderClass {
	

	@DataProvider(name="LoginData")
	public Object[][] logindata(){
		Object[][] data=Utils.getTestDataFromExcel("logindata");;
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
			inValidCode[i-1][0] = excelReader.getCellData("invalidcode", i, 0);
			inValidCode[i-1][1] = excelReader.getCellData("invalidcode", i, 1);
			System.out.println("The data is " + inValidCode[i-1][0] + ",");
			System.out.println("The data is " + inValidCode[i-1][1] + ",");
		}
		
		return inValidCode;
	}
	}





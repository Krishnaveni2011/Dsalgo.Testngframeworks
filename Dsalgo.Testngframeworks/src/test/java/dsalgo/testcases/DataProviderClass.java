package dsalgo.testcases;

import org.testng.annotations.DataProvider;

import dsalgo.utilities.Utils;

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

}

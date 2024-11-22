package dsalgo.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dsalgo.driverfactory.DriverFactory;

public class Utils {
	WebDriver driver = DriverFactory.getDriver();
	private ExcelReading reader = new ExcelReading();
	private ConfigReader configObj = new ConfigReader();
	String excelPath = configObj.getProperty("excelFilePath");
	
	
	public void waitForElement(WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));

	}
	public String getCodefromExcel(String sheetname, int rownumber) throws InvalidFormatException, IOException {
		List<Map<String, String>> testdata = reader.getData(excelPath, sheetname);
		String code = testdata.get(rownumber).get("pythonCode");
		return code;
	}
	
	public String getOutputFromExcel(String sheetname, int rownumber) throws InvalidFormatException, IOException {
		List<Map<String, String>> testdata = reader.getData(excelPath, sheetname);
		String result = testdata.get(rownumber).get("output");
		return result;
	}
	public void enterCode(String code, WebElement element) {

		new Actions(driver).sendKeys(element, code).perform();
	}
	public void enterCodePractice(String code, WebElement element, WebDriver driver) throws InterruptedException {
		new Actions(driver).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
		String[] str1 = code.split("\n");
		for (int i = 0; i < str1.length; i++) {
			if (str1[i].equalsIgnoreCase("\\b")) {
				element.sendKeys(Keys.BACK_SPACE);
			} else {
				element.sendKeys(str1[i]);
				element.sendKeys(Keys.RETURN);
			}
		}
	}
	

	public static Object[][] getTestDataFromExcel(String sheetName)  {
		FileInputStream fisExcel = null;
		try {
			fisExcel = new FileInputStream(ConfigReader.getProperty("excelFilePath"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(fisExcel);
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet=workbook.getSheet(sheetName);
		
		int rows=sheet.getLastRowNum();
		int cols=sheet.getRow(0).getLastCellNum();
		
		Object[][]data=new Object[rows][cols];
		for (int i=0;i<rows;i++) {
			XSSFRow row = sheet.getRow(i+1);
			
			for(int j=0;j<cols;j++) {
				
			 XSSFCell cell = row.getCell(j);
			 if ( cell == null ) continue;
			 CellType cellType = cell.getCellType();
			 switch(cellType) {
			 case STRING:
			 case BLANK:
			 data[i][j]=cell.getStringCellValue();
			 break;
			 case NUMERIC:
				 data[i][j]=Integer.toString((int)cell.getNumericCellValue());
				 break;
			 case BOOLEAN:
				 data[i][j]=cell.getBooleanCellValue();
				 break;
				 
			 }
				
			}
			
		}
		return data;
		
	
	}
}

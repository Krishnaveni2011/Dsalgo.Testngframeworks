package dsalgo.utilities;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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
}

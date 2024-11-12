package dsalgo.utilities;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties prop = null;
	private static String browserType = null;

	public static void setBrowserType(String browser) {
		browserType = browser;
	}
	
	public static String getBrowserType() throws Throwable {
		if (browserType != null)
			return browserType;
		else
			throw new RuntimeException("browser not specified in the testng.xml");
	}

	public static String getProperty(String key) {

		if (prop == null)
			intializeProperties();
		return prop.getProperty(key);

	}

	public static Properties intializeProperties() {

		prop = new Properties();

		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/Config/Config.properties");
			prop.load(fis);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}

	public static String registerPageUrl() {

		String url = prop.getProperty("registerUrl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified");

	}

	public static String getExcelFilePath() {
		String excelFilePath = ConfigReader.getProperty("excelFilePath");
		if (excelFilePath != null)
			return excelFilePath;
		else
			throw new RuntimeException("Excel file path not specified in the config.properties file");
	}

}

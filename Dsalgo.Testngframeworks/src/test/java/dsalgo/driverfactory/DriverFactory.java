package dsalgo.driverfactory;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public static WebDriver driver;
	
	public static ThreadLocal<WebDriver>tldriver = new ThreadLocal<>();
	
	public static WebDriver initializeBrowser(String browser) {
		System.out.println("browser value is: " +browser);
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
		}
		else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
	}
		else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			tldriver.set(new EdgeDriver());
	}
		else {
			System.out.println("Please pass the correct browser value: " +browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return getDriver();

}
	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}
	public static void quitDriver() {
		System.out.println("Quitting WebDriver");
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
}
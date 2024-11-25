package dsalgo.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
	public static ExtentReports generateExtentReport() {
		
		
		//File extentReporFile=new File(System.getProperty("user.dir")+"test-output/ExtentReports/ExtentReport.html");
		//ExtentSparkReporter sparkReporter=new ExtentSparkReporter(extentReporFile);
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName="Test-Report-"+timeStamp+".html";
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(".\\ExtentReports\\"+reportName);
		
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("DSAlgo TestNg Project Result");
		sparkReporter.config().setDocumentTitle("DSAlgo Automation Report");
		sparkReporter.config().setTimeStampFormat("MM/dd/yyyy hh:mm:ss");
		
		ExtentReports extentReport=new ExtentReports();
		extentReport.attachReporter(sparkReporter);
		
		extentReport.setSystemInfo("Application URL", ConfigReader.getProperty("appURL"));
		extentReport.setSystemInfo("Browser Name", ConfigReader.getProperty("browser"));
		extentReport.setSystemInfo("Operating Systen", System.getProperty("os.name"));
		extentReport.setSystemInfo("User Name",System.getProperty("user.name"));
		extentReport.setSystemInfo("Java Version",System.getProperty("java.version") );
		
		return extentReport;
		
		
	}

}

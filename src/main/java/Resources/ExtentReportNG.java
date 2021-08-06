package Resources;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	static ExtentReports extReports;

	@BeforeTest
	public static ExtentReports getReportObject() 
	{
		
		String filepath = System.getProperty("user.dir")+"\\ExtentReports\\index.html";
		
		ExtentSparkReporter extreporter = new ExtentSparkReporter(filepath);
		
		extreporter.config().setReportName("GK Web Automation");
		extreporter.config().setDocumentTitle("GK Test Results");
		
		extReports = new ExtentReports();
		extReports.attachReporter(extreporter);
		extReports.setSystemInfo("Tester", "Gaurav");
		
		return extReports;
	}
}

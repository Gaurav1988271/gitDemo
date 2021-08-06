package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.Base;
import Resources.ExtentReportNG;

public class ListenFailure extends Base implements ITestListener{
	
	ExtentTest test;
	ExtentReports extReports = ExtentReportNG.getReportObject();
	//For parallel execution
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		
		test = extReports.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}
	
	public void onTestFailure(ITestResult result) {
		
		extentTest.get().fail(result.getThrowable());
		
		WebDriver driver = null;
		
		String testMethodName = result.getMethod().getMethodName();
		
		try {
		driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchFieldException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			//to attach a screenshot with the failure method
			extentTest.get().addScreenCaptureFromPath(getScreenshot(testMethodName,driver), testMethodName);
			
			//getScreenshot(testMethodName,driver);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSuccess(ITestResult result) {
		
		extentTest.get().log(Status.PASS, "Test is Passed");
	}

	public void onFinish(ITestContext context) {
		
		extReports.flush();
	}

	
	
	

}

package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Base {
	
	public WebDriver driver;
	public Properties prop; 
	
	public WebDriver launchBrowser() throws IOException 
	{
	
		
		prop = new Properties();
		
		FileInputStream fis = new FileInputStream("C:\\Users\\kacholiy\\eclipse-workspace\\E2EProject\\src\\main\\java\\Resources\\globalData.properties");
		
		prop.load(fis);
		
		String BrowserName = prop.getProperty("browser");
		
		if(BrowserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\kacholiy\\Downloads\\estate\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		
		else if(BrowserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\kacholiy\\Downloads\\estate\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if(BrowserName.equals("Edge"))
		{	
			System.setProperty("webdriver.edge.driver", "C:\\Users\\kacholiy\\Downloads\\estate\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		return driver;
	}
	
	public String getScreenshot(String testMethodName, WebDriver driver) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File virtualsource = ts.getScreenshotAs(OutputType.FILE);
		//with Selenium-4 "apache common io" is not bundled so we have to add dependency to import FileUtils
		String destinationFile = System.getProperty("user.dir")+ "\\TakeShotScreenGK\\" +testMethodName+".png";
		//FileUtils.copyFile(virtualsource, new File(("user.dir")+ "\\TakeShotScreenGK\\"+testCaseName+".png"));
		FileUtils.copyFile(virtualsource, new File(destinationFile));
		return destinationFile;
	}

		
}

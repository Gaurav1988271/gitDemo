package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePage extends Base {
	
	public WebDriver driver;

	@BeforeMethod
	public void initialize() throws IOException {
		driver = launchBrowser();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "dataPro")
	public void basePageMethod(String usernames, String passwords) throws IOException {

		LandingPage lp = new LandingPage(driver);

		lp.cancel().click();
		lp.signUp().click();

		LoginPage logi = new LoginPage(driver);

		logi.enterEmail().sendKeys(usernames);
		logi.enterPassword().sendKeys(passwords);
		logi.clickLogin().click();

	}

	@DataProvider
	public Object[][] dataPro() {
		Object[][] data = new Object[2][2];

		// set1
		data[0][0] = "gaurav1";
		data[0][1] = "password1";

		// set2
		data[1][0]="gaurav2";
		data[1][1]="password2";

		// set3
		// data[2][0]="gaurav3";
		// data[2][1]="password3";

		return data;
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}

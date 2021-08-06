package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.LandingPage;

public class ValidateText extends Base {
	
	public WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {
		driver = launchBrowser();

		driver.get(prop.getProperty("url"));

		driver.manage().window().maximize();
	}

	@Test
	public void basePageText() {

		LandingPage lp = new LandingPage(driver);

		lp.cancel().click();
		Assert.assertEquals(lp.getTitle().getText(),"FEATURED COURSES");
		//Assert.assertTrue(lp.getTab().isDisplayed());
		Assert.assertEquals(lp.getTab().get(7).getText(), "CONTACT");

	}

	@AfterTest
	public void tearDown() {

		driver.close();
	}

}

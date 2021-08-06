package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		// super();
		this.driver = driver;
	}

	By NoThanks = By.xpath("//button[contains(text(),'NO THANKS')]");

	public WebElement cancel() {
		return driver.findElement(NoThanks);
	}
	
	By NavBar = By.xpath("//ul[@class='nav navbar-nav navbar-right']/li");

	public List<WebElement> getTab() {
		return driver.findElements(NavBar);
	}
	
	
	By SignIN = By.linkText("Login");
	//By SignIN = By.cssSelector("a[href='sign_in']");

	public WebElement signUp() {
		return driver.findElement(SignIN);
	}
	
	By TitleText = By.xpath("//h2[contains(text(),'Featured Courses')]");
	
	public WebElement getTitle() {
		return driver.findElement(TitleText);
	}

}

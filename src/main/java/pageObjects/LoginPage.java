package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		// super();
		this.driver = driver;
	}

	//By SignIN = By.cssSelector("a[href='sign_in']");
	By email = By.xpath("//input[@type='email']");

	public WebElement enterEmail() {
		return driver.findElement(email);
	}
	
	By password = By.xpath("//input[@type='password']");

	public WebElement enterPassword() {
		return driver.findElement(password);
	}
	
	By submit = By.xpath("//input[@type='submit']");

	public WebElement clickLogin() {
		return driver.findElement(submit);
	}

}

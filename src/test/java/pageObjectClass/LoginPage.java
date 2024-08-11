package pageObjectClass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends DriverInit {
	
//	 driver;
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmailAddress;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement btnLogin;
	
	JavascriptExecutor js =(JavascriptExecutor)driver;
	
	public void enterEmail(String email) {
		txtEmailAddress.sendKeys(email);
	}
	
	public void enterPassword(String pswd) {
		txtPassword.sendKeys(pswd);
	}
	
	public void clickLogin() {
//		btnLogin.click();
		js.executeScript("arguments[0].click()", btnLogin);
	}
	
	public void clearEmailTxt() {
		txtEmailAddress.clear();
	}
	
	public void clearPswdTxt() {
		txtPassword.clear();
	}
}

package pageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends DriverInit{
	
	public HomePage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement btnMyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegsiter;
	
//	@FindBy(xpath="//a[normalize-space()='Login']")
	@FindBy(linkText="Login")
	WebElement lnkLogin;
	
	
	
	public void clickMyAccount() {
		btnMyAccount.click();
	}
	
	public void clickRegister() {
		lnkRegsiter.click();
	}

	public void clickLogin() {
		lnkLogin.click();
	}
}

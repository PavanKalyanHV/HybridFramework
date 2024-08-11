package pageObjectClass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterPage extends DriverInit {
	
	public AccountRegisterPage(WebDriver driver) {
		super(driver);
	}
	
	//
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//label[normalize-space()='Yes']")
	WebElement chkSubscribeYes;
	
	@FindBy(xpath="//label[normalize-space()='No']")
	WebElement chkSubscribeNo;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkPrivacyPolicy;
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement btnContinue1;
	
	@FindBy(xpath="//a[normalize-space()='Continue']")
	WebElement btnContinue2;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirm;
	
	public void enterFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}
	
	public void enterLastName(String lname) {
		txtLastName.sendKeys(lname);
	}
	
	public void enterEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void enterPassword(String pswrd) {
		txtPassword.sendKeys(pswrd);
	}
	
	public void checkYesSubscribe() {
//		chkSubscribeYes.click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",chkSubscribeYes );
	}
	
	public void checkNoSubscribe() {
		chkSubscribeNo.click();
	}
	
	public void checkPrivacyPolicy() {
//		chkPrivacyPolicy.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",chkPrivacyPolicy );
	}
	
	public void continueBtn() {
//		btnContinue1.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",btnContinue1 );
	}
	
	public String getConfirmationMsg() {
		try {
			return(msgConfirm.getText());
		}
		catch(Exception e){
			return(e.getMessage());
		}
	}
	
	

}

package pageObjectClass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends DriverInit {
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement btnlogout;
	
	public boolean isMyAccountPageExist() {
		try {
			return msgHeading.isDisplayed();
		}
		catch(Exception e){
			return false;
		}
	}
	
	public void clickLogout(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", btnlogout);
//		btnlogout.click();
	}
	
	

}

package pageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DriverInit {
	
	WebDriver driver;
	
	public DriverInit(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

}

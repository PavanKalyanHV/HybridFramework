package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjectClass.AccountRegisterPage;
import pageObjectClass.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups="Sanity")
	public void verifyAccountRegistreation() {
		try {
			logger.info("**** Starting TC001_AccountRegistrationTest ****");
			HomePage home = new HomePage(driver);
			
			home.clickMyAccount();
			logger.info("Cliked on My Account...");
			
			home.clickRegister();	
			logger.info("Clicked on Register...");
			
			AccountRegisterPage regPage = new AccountRegisterPage(driver);
			
			regPage.enterFirstName("King");
			logger.info("Entered first name...");
			
			regPage.enterLastName("MannSab");
			logger.info("Entered last name...");
			
			regPage.enterEmail(randomString()+"@gmail.com");
			logger.info("Entered gmail...");
			
			regPage.enterPassword(randomStringPswd());
			logger.info("Entered password...");
			
			regPage.checkYesSubscribe();
			logger.info("Clicked on Yes checkbok for subscribe...");
			
			regPage.checkPrivacyPolicy();
			logger.info("Clicked on the checkbox for accepting privacy policy...");
			
			regPage.continueBtn();
			logger.info("Clicked on continue button...");
			
			String confMsg = regPage.getConfirmationMsg();
			Assert.assertEquals(confMsg,"Your Account Has Been Created!");
			logger.info("Validatinf the confirmation message....");
		}
		catch(Exception e) {
			logger.error("****Test Failed...****");
			logger.debug("Debug logs...");
			Assert.fail();
		}
	}
	

}

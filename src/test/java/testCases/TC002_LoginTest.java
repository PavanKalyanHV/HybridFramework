package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectClass.HomePage;
import pageObjectClass.LoginPage;
import pageObjectClass.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups={"Regression","Sanity"})
	public void verifyLogin() {
		try {
		logger.info("**** Starting TC002_LoginTest ****");
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.enterEmail("kaloramana12@gmail.com");
		lp.enterPassword("wer@123Nan$");
		lp.clickLogin();
		
		MyAccountPage myp = new MyAccountPage(driver);
		boolean targerPage = myp.isMyAccountPageExist();
		Assert.assertEquals(targerPage, true);
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("**** Finished TC002_LoginTest ****" );
	}

}

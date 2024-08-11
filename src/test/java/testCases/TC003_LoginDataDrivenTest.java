package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectClass.HomePage;
import pageObjectClass.LoginPage;
import pageObjectClass.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDataDrivenTest extends BaseClass {
	
	
	@Test(groups= {"Regression"},dataProvider="loginData",dataProviderClass=DataProviders.class)
	public void verifyLoginDTD(String email, String pswd, String res) {
		logger.info("**** Starting TC003_LoginDataDrivenTest ****");
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.enterEmail(email);
		lp.enterPassword(pswd);
		lp.clickLogin();
		
		MyAccountPage myp = new MyAccountPage(driver);
		boolean targetPage = myp.isMyAccountPageExist();
		System.out.print(res);
		if(res.equalsIgnoreCase("valid")) {
			if(targetPage==true) {
				myp.clickLogout();
				Assert.assertTrue(true);	
			}
			else {
				Assert.assertTrue(false);
				lp.clearEmailTxt();
				lp.clearPswdTxt();
				
			}
		}
		if(res.equalsIgnoreCase("invalid")) {
			if(targetPage==true) {	
				myp.clickLogout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
				lp.clearEmailTxt();
				lp.clearPswdTxt();
			}
			
		}
		
	}

}

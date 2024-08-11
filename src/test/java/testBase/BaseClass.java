package testBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public Logger logger;
	
	public WebDriver driver;
	
	public Properties prop;
	@BeforeClass(groups= {"Sanity","Regression"})
	@Parameters({"os","browser"})
	public void setUp(String os,String br) throws InterruptedException, IOException {
		
		//Loading CONFIG.PROPERTIES file
		prop = new Properties();
		FileReader file = new FileReader("D:\\Users\\Pavankalyanhv\\HybridFramework\\src\\test\\resources\\config.properties");
		prop.load(file);
		
		logger = LogManager.getLogger(this.getClass());
		switch(br.toLowerCase()){
		case "chrome": driver = new ChromeDriver(); break;
		case "edge" : driver = new EdgeDriver(); break;
		default:logger.info("**** Pass valid browser *****"); Assert.fail();return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(prop.getProperty("appURL1"));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"Sanity","Regression"})
	public void closeBrowser() {
		driver.quit();
	}
	
	public String randomString(){
		return(RandomStringUtils.randomAlphabetic(5));
	}
	
	public String randomNumber(){
		return(RandomStringUtils.randomNumeric(10));
	}
	
	public String randomStringPswd() {
		return(RandomStringUtils.randomAlphanumeric(6, 15)+"@$"+RandomStringUtils.randomNumeric(5));
	}
	
	public String captureScreen(String tname) {
		
		String timestamp = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());	
		TakesScreenshot screenshot =(TakesScreenshot) driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		String targetSourcePath=System.getProperty("user,dir")+"\\screenshots\\"+tname+"_"+timestamp;
		File targetfile = new File(targetSourcePath);
		sourceFile.renameTo(targetfile);	
		return targetSourcePath;
	}

}

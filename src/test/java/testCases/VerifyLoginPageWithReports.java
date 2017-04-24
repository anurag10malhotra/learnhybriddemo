package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LogInPage;

public class VerifyLoginPageWithReports {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;	
	
	@BeforeTest
	public void setUp()
	{
		report=new ExtentReports("C:\\Users\\anurag\\workspace\\com.framework2.hybrid\\reports\\LoginPageReport.html",true);
		
		logger=report.startTest("Verify Test login");
		
        driver=BrowserFactory.getBrowser("chrome");
		
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		
		logger.log(LogStatus.INFO, "App is up and running");
	}
	
	
	@Test
	public void testHomePage()
	{
		
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		String title=home.getApplicationTitle();
		
		Assert.assertTrue(title.contains("Store"), "nahin chala");
	
		logger.log(LogStatus.PASS, "Home page title verified");
		
		System.out.println("application title is "+ title);
		
		home.clickOnSignIn();
		
		logger.log(LogStatus.INFO, "click on sign in link");
		
				
		LogInPage login=PageFactory.initElements(driver, LogInPage.class);
		
		login.loginApplication(DataProviderFactory.getExcel().getData(0, 3, 0),DataProviderFactory.getExcel().getData(0, 3, 1));

		logger.log(LogStatus.INFO, "enter username and password to sign in");
		
		
		login.verifySignOutLink();
		
		logger.log(LogStatus.PASS, "sign out button is working");
		
	}

	@AfterTest
	public void tearDown()
	{
		BrowserFactory.closeBrowser(driver);
	    report.endTest(logger);
	    report.flush();
	}
	
	
}

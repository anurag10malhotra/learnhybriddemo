package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LogInPage;

public class VerifyLoginPage {

	WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		
        driver=BrowserFactory.getBrowser("chrome");
		
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		
	}
	
	
	@Test
	public void testHomePage()
	{
		
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		String title=home.getApplicationTitle();
		
		Assert.assertTrue(title.contains("Store"), "nahin chala");
		
		System.out.println("application title is "+ title);
		
		home.clickOnSignIn();
		
				
		LogInPage login=PageFactory.initElements(driver, LogInPage.class);
		
		login.loginApplication(DataProviderFactory.getExcel().getData(0, 3, 0),DataProviderFactory.getExcel().getData(0, 3, 1));

		login.verifySignOutLink();
	}

	@AfterTest
	public void tearDown()
	{
		BrowserFactory.closeBrowser(driver);
		
	}
	
	
}

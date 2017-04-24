package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;

public class VerifyHomePage {

	
	@Test
	public void testHomePage()
	{
		WebDriver driver=BrowserFactory.getBrowser("iePath");
		
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		String title=home.getApplicationTitle();
		
		Assert.assertTrue(title.contains("Store"), "fudu bc");
		
		System.out.println("application title is "+ title);
		
		BrowserFactory.closeBrowser(driver);
				

	}

	
	
}

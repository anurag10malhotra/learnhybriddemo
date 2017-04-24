package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver ldriver)
	{
		this.driver=ldriver;
		
	}
	
	
	@FindBy(css="a[class='login']") 
	WebElement signInLink;
	
	@FindBy(css="a[title*='shopping']") 
	WebElement cart;
	
	
	public void clickOnSignIn()
	{
		signInLink.click();
	}
	
	public void clickOnCart()
	{
		cart.click();
	}
	
	public String getApplicationTitle()
	{
		return driver.getTitle();
	}
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LogInPage {

	
	WebDriver driver;
	
	public LogInPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	
	@FindBy(css="input[id='email']")
	WebElement userid;
	
	
	@FindBy(css="input[id='passwd']")
	WebElement password;
	
	@FindBy(css="button[id='SubmitLogin']")
	WebElement submitSignIn;
	
	
	By signout=By.xpath("//*[@class='logout']");
	
	public void loginApplication(String uid, String pwd)
	{
		userid.sendKeys(uid);
		password.sendKeys(pwd);
		submitSignIn.click();
	}
	
	
	public void verifySignOutLink()
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement ele=wait.until(ExpectedConditions.presenceOfElementLocated(signout));
		
		String text=ele.getText();
		
		Assert.assertEquals(text, "Sign out","sign out link not verified");
	}
}

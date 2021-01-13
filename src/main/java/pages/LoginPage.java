package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	private WebDriver driver;
	
	//Object Repository using By locator technique
	
	//Login Page class elements
	
	//By locators
	
	private By EmailAddress=By.id("email");
	private By Password=By.id("passwd");
	private By SignInButton=By.id("SubmitLogin");
	private By ForgotPasswordLink=By.linkText("Forgot your password?");
	
	//Constructor of the Login Page class
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	/*
	 * Page Actions methods in Page class is written based on the steps written for 
	 * each scenario in the Login Feature File
	 */
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean isForgotPasswordLinkPresent()
	{
		WebElement element=driver.findElement(ForgotPasswordLink);
		return element.isDisplayed();
	}
	
	public void enterUsername(String username)
	{
		WebElement element=driver.findElement(EmailAddress);
		element.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		WebElement element=driver.findElement(Password);
		element.sendKeys(password);
	}
	
	public void clickOnSignIn()
	{
		WebElement element=driver.findElement(SignInButton);
		element.click();
	}
	
	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("login with: " + un + " and " + pwd);
		driver.findElement(EmailAddress).sendKeys(un);
		driver.findElement(Password).sendKeys(pwd);
		driver.findElement(SignInButton).click();
		return new AccountsPage(driver);
	}
	
	
	
	
	
	
	
	
	
	
	

}

package stepDefinitionFiles;

import org.junit.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginPageSteps 
{
	private String loginPageTitle;
	private LoginPage loginPage=new LoginPage(new DriverFactory().getDriverInstance());
	
	@Given("user is on login page")
	public void user_is_on_login_page() 
	{
		System.out.println("user is on login page");
	}

	@When("user gets the title of the login page")
	public void user_gets_the_title_of_the_login_page() 
	{
		String loginPageTitle=loginPage.getLoginPageTitle();
	    System.out.println("Login Page Title="+loginPageTitle);
	}

	@Then("login page title should be {string}")
	public void login_page_title_should_be(String expectedLoginPageTitle) 
	{
		Assert.assertTrue(loginPageTitle.contains(expectedLoginPageTitle));
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() 
	{
		Assert.assertTrue(loginPage.isForgotPasswordLinkPresent());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) 
	{
		loginPage.enterUsername(username);
	}

	@And("user enters password {string}")
	public void user_enters_password(String password) 
	{
		loginPage.enterPassword(password);
	}

	@And("user clicks on SignIn button")
	public void user_clicks_on_sign_in_button() 
	{
		loginPage.clickOnSignIn();
	}

	@When("user gets the title of the accounts page")
	public void user_gets_the_title_of_the_accounts_page() 
	{
	    System.out.println("Title of the Accounts Page");
	}

	@Then("accounts page title should be {string}")
	public void accounts_page_title_should_be(String string) 
	{
		System.out.println("Title of the Accounts Page should be something");
	}

	
	

}

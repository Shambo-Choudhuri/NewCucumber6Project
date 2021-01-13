package stepDefinitionFiles;


import java.util.List;
import java.util.Map;

import driverFactory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.AccountsPage;
import pages.LoginPage;

public class AccountsPageSteps {
	
	private LoginPage loginPage = new LoginPage(new DriverFactory().getDriverInstance());
	private AccountsPage accountsPage;
	
	@Given("user must login to the application")
	public void user_must_login_to_the_application(DataTable credTable)
	{
		List<Map<String, String>> credList = credTable.asMaps();
		String userName = credList.get(0).get("username");
		String password = credList.get(0).get("password");

		new DriverFactory().getDriverInstance()
		.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		accountsPage = loginPage.doLogin(userName, password);

	}
	
	@Given("user is on accounts page")
	public void user_is_on_accounts_page()
	{
		String title = accountsPage.getAccountsPageTitle();
		System.out.println("Accounts Page title is: " + title);
	}
	
	@Given("user gets accounts section")
	public void user_gets_account_section(DataTable sectionsTable)
	{
		List<String> expAccountSectionsList = sectionsTable.asList();
		
		System.out.println("Expected accounts section list: " + expAccountSectionsList);

		List<String> actualAccountSectionsList = accountsPage.getAccountsSectionsList();
		System.out.println("Actual accounts section list: " + actualAccountSectionsList);

		Assert.assertTrue(expAccountSectionsList.containsAll(actualAccountSectionsList));

	}
	
	@Given("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount)
	{
		Assert.assertTrue(accountsPage.getAccountsSectionCount() == expectedSectionCount);
	}
	
	
}

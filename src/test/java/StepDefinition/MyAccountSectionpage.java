package StepDefinition;

import java.util.*;


import org.junit.Assert;

import com.pages.AccountPage_POM;
import com.pages.LoginPage_POM;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class MyAccountSectionpage {

	private LoginPage_POM login_page = new LoginPage_POM(DriverFactory.get_driver());
	private AccountPage_POM accountsPage;
	public static String title;

	@Given("user is already logged into the application")
	public void user_is_already_logged_into_the_application(DataTable credTable) {
		List<Map<String, String>> credList = credTable.asMaps();
		String username = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		DriverFactory.get_driver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountsPage = login_page.doLogin(username, password); /* 25.15 */

	}

	@Given("user is on the accounts page")
	public void user_is_on_the_accounts_page() {
		DriverFactory.get_driver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		//AccnPage = login_page.doLogin(username, password);
		title = accountsPage.get_Account_page_title();
		System.out.println("Account page title is :" + title);

	}

	@Then("user gets account selection")
	public void user_gets_account_selection(DataTable SectionsTable) {
		List<String> expectedAccountSection = SectionsTable.asList();
		System.out.println("Expected Account section list :" + expectedAccountSection);
		List<String> ActulaAccountSection = accountsPage.getAcountList();
		System.out.println("Actual Account section list :" + ActulaAccountSection);

		Assert.assertTrue(expectedAccountSection.containsAll(ActulaAccountSection));
	}

	@Then("Account should count be {int}")
	public void account_should_count_be(Integer Expected_Sections) {
		Assert.assertTrue(accountsPage.getAccountSections() == Expected_Sections);
	}

}

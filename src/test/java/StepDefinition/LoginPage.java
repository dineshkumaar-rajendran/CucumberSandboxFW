package StepDefinition;

import org.junit.Assert;

import com.pages.LoginPage_POM;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.*;

public class LoginPage {
	public static String title;
	private LoginPage_POM login_page = new LoginPage_POM(DriverFactory.get_driver());

	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
		DriverFactory.get_driver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = DriverFactory.get_driver().getTitle();
		System.out.println("Page title is: " + title);

	}

	@Then("page title should be {string}")
	public void page_title_should_be(String Expectedtitle) {
		Assert.assertTrue(title.contains(Expectedtitle));
	}

	@Then("forget your password link should be visible")
	public void forget_your_password_link_should_be_visible() {

		Assert.assertTrue(login_page.isFrgtPassLinkExist());

	}

	@When("user enters the username {string}")
	public void user_enters_the_username(String username) {
		login_page.Enter_username(username);
	}

	@When("user enters the password {string}")
	public void user_enters_the_password(String password) {
		login_page.Enter_password(password);
	}

	@And("user clicks on the login button")
	public void user_clicks_on_the_login_button() {
		login_page.click_login();
	}

	

}

package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage_POM {

	private WebDriver driver;

	private By email = By.id("email");
	private By passwords = By.id("passwd");
	private By Loginbtn = By.id("SubmitLogin");
	private By FrgtPass = By.linkText("Forgot your password?!");

	public LoginPage_POM(WebDriver driver) {
		this.driver = driver;
	}

	public String get_login_page_title() {
		return driver.getTitle();

	}

	public boolean isFrgtPassLinkExist() {
		return driver.findElement(FrgtPass).isDisplayed();
	}

	public void Enter_username(String username) {
		driver.findElement(email).sendKeys(username);
	}

	public void Enter_password(String password) {
		driver.findElement(passwords).sendKeys(password);

	}

	public void click_login() {
		driver.findElement(Loginbtn).click();
	}

	public AccountPage_POM doLogin(String un, String pwd) {
		System.out.println("Login with :" + un + "and" + pwd);
		driver.findElement(email).sendKeys(un);
		driver.findElement(passwords).sendKeys(pwd);
		driver.findElement(Loginbtn).click();
		return new AccountPage_POM(driver);
		/*According to POM if particular method is landing in next page then method responsiblity give the object of accountspage @25.15 */
	}

}

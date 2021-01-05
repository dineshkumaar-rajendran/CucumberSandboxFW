package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage_POM {

	private WebDriver driver;
	

	private By Account_Sections = By.cssSelector("div#center_column span");

	public AccountPage_POM(WebDriver driver) {
		this.driver = driver;
	}
	
	public String get_Account_page_title() {
		return driver.getTitle();

	}

	public int getAccountSections() {
		int count = driver.findElements(Account_Sections).size();
		return count;
	}

	public List<String> getAcountList() {
		List<String> AccountList = new ArrayList<String>();
		List<WebElement> accountheaderList = driver.findElements(Account_Sections);
		for (WebElement ele : accountheaderList) {
			String text = ele.getText();
			System.out.println(text);
			AccountList.add(text);

		}

		return AccountList;
	}

}

package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();

	public WebDriver init_driver(String browser) {
		System.out.println("Browser value is :" + browser);

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
		}

		else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
		}

		else {
			System.out.println("Please pass the correct browser values!");
		}
		
		get_driver().manage().deleteAllCookies();
		get_driver().manage().window().maximize();
		
		return get_driver();
	}

	public static synchronized WebDriver get_driver() {

		return tldriver.get();

	}

}

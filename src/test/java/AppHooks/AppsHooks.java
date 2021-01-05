package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.utility.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppsHooks {

	private DriverFactory Dfactory;
	private WebDriver driver;
	private ConfigReader configRead;
	Properties prop;
	
	@Before(order =0)
	public void GetProp() {
		configRead = new ConfigReader();
		prop = configRead.init_prop();
	}
	
	@Before(order=1)
	public void LaunchBrowser() {
		String browserName = prop.getProperty("browser");
		Dfactory = new DriverFactory();
		driver =Dfactory.init_driver(browserName);
		
	}
	
	@After(order = 0)
	public void quit_browser() {
		driver.quit();
	}
	
	@After(order=1)
	public void teardown(Scenario scenario) {
		if(scenario.isFailed()) {
			String ScreenshotName = scenario.getName().replaceAll("", "_");
			byte[] SourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(SourcePath, "image/png", ScreenshotName);
		}
	}
	
}

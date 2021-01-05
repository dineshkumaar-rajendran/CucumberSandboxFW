package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = { "src/test/resources/AppFeatures/" },
		glue = { "StepDefinition", "AppHooks" }, 
		plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"timeline:test-output-thread/"}

)
public class MyTestRunner {

}

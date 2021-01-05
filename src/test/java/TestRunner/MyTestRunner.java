package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = { "src/test/resources/AppFeatures/MyAccount.feature" },
		glue = { "StepDefinition", "AppHooks" }, 
		plugin = {"pretty"}

)
public class MyTestRunner {

}

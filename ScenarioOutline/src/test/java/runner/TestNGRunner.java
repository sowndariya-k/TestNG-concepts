package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    plugin = {"pretty", "html:target/cucumber-reports/cucumber.html"},
	    features = "src/test/resources/features/login.feature",
	    glue = "stepDefinition",
	    tags="@Multiple_InvalidCredentials"
	)
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
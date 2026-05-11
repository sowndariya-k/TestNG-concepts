package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    plugin = {"pretty", "html:target/cucumber-reports/cucumber.html", "rerun:target/fail.txt"},
	    features = "src/test/resources/feature/Login.feature",
	    glue = "stepDefinition"
	    
	)
	public class TestNGRunner extends AbstractTestNGCucumberTests {

	}
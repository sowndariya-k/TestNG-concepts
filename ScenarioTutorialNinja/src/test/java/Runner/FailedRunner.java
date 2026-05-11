package Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "@target/fail.txt",
	    glue = "stepDefinition",
	    plugin = {
	        "pretty",
	        "html:target/rerun-reports/cucumber.html"
	    }
	)
	public class FailedRunner extends AbstractTestNGCucumberTests {

	}
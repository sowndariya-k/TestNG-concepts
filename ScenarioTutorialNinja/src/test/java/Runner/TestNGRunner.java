package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    plugin = {"pretty", "html:target/cucumber-reports/cucumber.html"},
	    features = "src/test/resources/feature/cart.feature",
	    glue = "stepDefinition"
	)
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
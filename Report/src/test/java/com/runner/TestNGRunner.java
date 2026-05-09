package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/feature/Login.feature",
		glue = "com.definition",
		plugin= {
				"pretty",
				"html:target/cucumber-reports/Cucumber.html",
				"json: target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		},
		monochrome=true)
	public class TestNGRunner extends AbstractTestNGCucumberTests{

}

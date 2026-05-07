package com.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty", "html:target/cucumber-report.html"},
    features = "src/test/resources/com.features/demoLogin.feature",
    glue = "com.stepDefinition",
    tags = "@ValidLogin"
)
public class JunitRunner {
}
package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src\\test\\resources\\com.features\\cart.feature",
        glue = {"com.stepDefinition", "com.base"},
        plugin = {"pretty", "html:target/cucumber-report.html"},
        tags = "@AddToCart or @ViewCart or @DeleteFromCart"
)
public class TestNGRunner extends AbstractTestNGCucumberTests {
}
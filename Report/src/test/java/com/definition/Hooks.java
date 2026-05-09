package com.definition;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TakesScreenshot;

import com.utilities.HelperClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;

public class Hooks {
	private static final Logger logger=LogManager.getLogger(Hooks.class);
	
	@Before
	public void setUp(Scenario scenario) {
	    HelperClass.setupDriver();
	    logger.info("Scenario started: {}", scenario.getName());
	}
	
	@After
	public void tearDown(Scenario scenario) {

	    if (scenario.isFailed()) {
	        try {

	            File src = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.FILE);
	            File dest = new File("./screenshots/"+ scenario.getName().replaceAll(" ", "_") + ".png");
	            FileUtils.copyFile(src, dest);
	            byte[] screenshotBytes=((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.BYTES);
	            scenario.attach(screenshotBytes,"images/png","FailureScreenshot");
				logger.error("Scenario failed:{}",scenario.getName());
			}
			catch(IOException e) {
				logger.error("Failed to save screenshot:{}",e.getMessage());
			}
			}
			else {
				logger.info("scenario passes:{}",scenario.getName());
			}
		HelperClass.tearDown();
	}
}

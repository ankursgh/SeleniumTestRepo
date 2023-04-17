package com.carriersedge.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.carriersedge.stepDefinitions.AbstractPageStepDefinition;
import io.cucumber.java.After;

public class Hooks extends AbstractPageStepDefinition {
	private static final Logger logger = LogManager.getLogger(Hooks.class);

	// @Before
	public void beforeScenario() {
		logger.info("Before Scenario executed.");
	}

	// uncomment below line if browser need to quit after scenario.
	@After
	public void afterScenario() {
		BrowserFactory.quitBrowser(driver);
		logger.info("After Scenario executed and quit the browser.");
	}
	/*
	 * public void afterTest() { if (scenario.isFailed()) { byte[] screenshot =
	 * ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	 * scenario.attach(screenshot, "image/png", "name"); } }
	 */

}

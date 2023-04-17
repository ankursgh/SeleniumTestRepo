package com.carriersedge.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		// features="classpath:features",
		// features="C:/Users/navra/Documents/workspace-spring-tool-suite-4-4.2.2.RELEASE/BddPageObjectDemo/src/main/java/com/nava/features/login.feature",
		features = "src/main/resources/features/loginRecovery.feature",
		// tags=
		// "@CarrierSettingsNotAllowedRecoverPassword",//"@multipleEmailValidUser",//"@EmailHasMultipleUsersAndUserNotIdentifiedAndRun4Times",
		glue = { "com/carriersedge/stepDefinitions" }, // provide the package of step definition files
		dryRun = false, // false for running test
		plugin = { "pretty", "html:test-output/carriersEdgeReport.html" // This makes html report in the test-output
																		// folder

		}

)
public class SelfServedLoginTestRunner {

}

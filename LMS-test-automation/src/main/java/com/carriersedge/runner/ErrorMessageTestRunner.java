package com.carriersedge.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "classpath:features/updateUser.feature",
		// features= {"classpath:features/second.feature",
		// "classpath:features/Future.feature"},// for multiple feature files
		// features= {"src/main/resources/features/second.feature",
		// "src/main/resources/features/Future.feature"},//this runner is run for two
		// feature file

		glue = { "com/carriersedge/stepDefinitions" }, // provide the package of step definition files
		dryRun = false, // false for running test
		// tags = "@validUserlogin" ,// @nonExistUser,
		plugin = { "pretty", "html:test-output/carriersEdgeReport.html" // This makes html report in the test-output
																		// folder

		}

)
public class ErrorMessageTestRunner {

}

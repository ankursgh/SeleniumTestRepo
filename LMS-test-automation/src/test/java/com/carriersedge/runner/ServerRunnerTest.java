package com.carriersedge.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		// features="classpath:features",
		// features="src/main/resources/features",
		// features= {"classpath:features/second.feature",
		// "classpath:features/Future.feature"},//this runner is run for two feature
		// file
		features = "src/main/resources/hlfeatures/HLTest.feature",glue={"com.carriersedge.stepDefinitions"}, // provide the package of step definition files
		dryRun = false, // false for running test
		// tags = " @nonExistUser",//"@addSingleUser",//" @userNoAllowChangePassword",
		//plugin = { "pretty", "html:test-output/TestReport.html" // This makes html report in the test-output // folder
		//}
		plugin = { "pretty",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }

)
public class ServerRunnerTest {

}

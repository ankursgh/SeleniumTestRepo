package com.carriersedge.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.carriersedge.pages.HomePage;
import com.carriersedge.pages.LoginPage;
import com.carriersedge.pages.MultiplePeopleAddPage;
import com.carriersedge.pages.PasswordRecoveryPage;
import com.carriersedge.pages.PeoplePage;
import com.carriersedge.pages.UserDetailsPage;
import com.carriersedge.pages.UserProfilePage;
import com.carriersedge.pages.VerificationPage;
import com.carriersedge.pages.YourContactInformationPage;
import com.carriersedge.util.BaseClass;
import com.carriersedge.util.BrowserFactory;

public class AbstractPageStepDefinition {

	protected static WebDriver driver;
	/*
	 * static LoginPage loginPage; static HomePage homePage; static
	 * PasswordRecoveryPage passwordRecoveryPage; static YourContactInformationPage
	 * yourContactInformationPage; static VerificationPage verificationPage; static
	 * UserDetailsPage userDetailsPage; static PeoplePage peoplePage; static
	 * UserProfilePage userProfilePage; static MultiplePeopleAddPage
	 * multiplePeopleAddPage;
	 */

	protected WebDriver getDriver() {
		if (driver == null) {
			driver = BrowserFactory.startApplication(driver, BaseClass.prop.getProperty("browserName"),
					BaseClass.prop.getProperty("url"));
		}
		return driver;
	}

}

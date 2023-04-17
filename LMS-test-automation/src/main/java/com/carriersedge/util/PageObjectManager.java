package com.carriersedge.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.carriersedge.pages.HomePage;
import com.carriersedge.pages.LoginPage;
import com.carriersedge.pages.PasswordRecoveryPage;
import com.carriersedge.pages.PeoplePage;
import com.carriersedge.pages.UserDetailsPage;
import com.carriersedge.pages.VerificationPage;
import com.carriersedge.pages.YourContactInformationPage;

public class PageObjectManager extends BaseClass {
	private static final Logger logger = LogManager.getLogger(PageObjectManager.class);
	private static PageObjectManager pageObjectManager = null;

	public static PageObjectManager getInstance() {
		if (pageObjectManager == null) {
			pageObjectManager = new PageObjectManager();
			logger.info("new page object is created");
		}

		return pageObjectManager;
	}

	// private static WebDriver driver;

	private LoginPage loginPage;

	private HomePage homePage;

	private PasswordRecoveryPage passwordRecoveryPage;

	private YourContactInformationPage yourContactInformationPage;

	private VerificationPage verificationPage;

	private UserDetailsPage userDetailsPage;

	private PeoplePage peoplePage;

	// public PageObjectManager(WebDriver driver) {
	// super();
	// this.driver = driver;
	// }

	public HomePage getHomePage(WebDriver driver) {

		return (homePage == null) ? homePage = new HomePage(driver) : homePage;

	}

	public LoginPage getLoginPage(WebDriver driver) {

		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;

	}

	public PasswordRecoveryPage getPasswordRecoveryPage(WebDriver driver) {

		return (passwordRecoveryPage == null) ? passwordRecoveryPage = new PasswordRecoveryPage(driver)
				: passwordRecoveryPage;

	}

	public YourContactInformationPage getYourContactInformationPage(WebDriver driver) {

		return (yourContactInformationPage == null)
				? yourContactInformationPage = new YourContactInformationPage(driver)
				: yourContactInformationPage;

	}

	public VerificationPage getVerificationPage(WebDriver driver) {

		return (verificationPage == null) ? verificationPage = new VerificationPage(driver) : verificationPage;

	}

	public UserDetailsPage getUserDetailsPage(WebDriver driver) {

		return (userDetailsPage == null) ? userDetailsPage = new UserDetailsPage(driver) : userDetailsPage;

	}

	public PeoplePage getPeoplePage(WebDriver driver) {

		return (peoplePage == null) ? peoplePage = new PeoplePage(driver) : peoplePage;

	}
}

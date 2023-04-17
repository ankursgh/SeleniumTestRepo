package com.carriersedge.stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.carriersedge.pages.HomePage;
import com.carriersedge.pages.LCVAdminPage;
import com.carriersedge.pages.LCVCarrierMembership;
import com.carriersedge.pages.LCVReportPage;
import com.carriersedge.pages.LoginPage;
import com.carriersedge.pages.MultiplePeopleAddPage;
import com.carriersedge.pages.PasswordRecoveryPage;
import com.carriersedge.pages.PeoplePage;
import com.carriersedge.pages.ProgramDetailsPage;
import com.carriersedge.pages.ProgramsPage;
import com.carriersedge.pages.UserDetailsPage;
import com.carriersedge.pages.UserProfilePage;
import com.carriersedge.pages.VerificationPage;
import com.carriersedge.pages.YourContactInformationPage;
import com.carriersedge.util.Myutilities;
import com.carriersedge.pages.LCVRenewReprintCertificatePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.carriersedge.pages.LCVRunDailyBatchPage;

public class LCVRenewandReprintCertStepDefinition extends AbstractPageStepDefinition {
	public LCVRenewandReprintCertStepDefinition() {
		super();
		logger.info("LCVRenewandReprintCertStepDefinition initialized");

	}

	private static final Logger logger = LogManager.getLogger(LCVRenewandReprintCertStepDefinition.class);
	LCVRenewReprintCertificatePage LCert;

	@Then("I expired the certificate.")
	public void i_expired_the_certificate() {
		if (LCert == null)
			LCert = new LCVRenewReprintCertificatePage(driver);
		LCert.Rnw1();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked on certification status.")
	public void i_clicked_on_certification_status() {
		if (LCert == null)
			LCert = new LCVRenewReprintCertificatePage(driver);
		LCert.Rnw2();
		Myutilities.sleepFor(2000);
	}

	@Then("I renew driver certificate.")
	public void i_renew_driver_certificate() {
		if (LCert == null)
			LCert = new LCVRenewReprintCertificatePage(driver);
		LCert.Rnw3();
		Myutilities.sleepFor(2000);
	}

	@Then("I verified the user.")
	public void i_verified_the_user() {
		if (LCert == null)
			LCert = new LCVRenewReprintCertificatePage(driver);
		LCert.Rnw4();
		Myutilities.sleepFor(2000);
	}

	@Then("I activted the certificate.")
	public void i_activted_the_certificate() {
		if (LCert == null)
			LCert = new LCVRenewReprintCertificatePage(driver);
		LCert.Rnw5();
		Myutilities.sleepFor(2000);
	}

	// *********Renew Instructor*********
	@Then("I expired the active certificate.")
	public void i_expired_the_active_certificate() {
		if (LCert == null)
			LCert = new LCVRenewReprintCertificatePage(driver);
		LCert.Rnw6();
		Myutilities.sleepFor(2000);
	}

	@Then("I renew instructor certificate.")
	public void i_renew_instructor_certificate() {
		if (LCert == null)
			LCert = new LCVRenewReprintCertificatePage(driver);
		LCert.Rnw7();
		Myutilities.sleepFor(2000);
	}

	@Then("I verified the instructor.")
	public void i_verified_the_instructor() {
		if (LCert == null)
			LCert = new LCVRenewReprintCertificatePage(driver);
		LCert.Rnw8();
		Myutilities.sleepFor(2000);
	}

	@Then("I activted the instructor certificate.")
	public void i_activted_the_instructor_certificate() {
		if (LCert == null)
			LCert = new LCVRenewReprintCertificatePage(driver);
		LCert.Rnw9();
		Myutilities.sleepFor(2000);
	}
	// **********Till Here***************
}

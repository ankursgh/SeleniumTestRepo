package com.carriersedge.stepDefinitions;

import static org.junit.Assert.assertFalse;
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
import com.carriersedge.util.Myutilities;
import com.carriersedge.pages.HomePage;
import com.carriersedge.pages.LCVAdminHomePage;
import com.carriersedge.pages.LCVAdminPage;
import com.carriersedge.pages.LCVCarrierMembership;
import com.carriersedge.pages.LCVEventsPage;
import com.carriersedge.pages.LCVReportPage;
import com.carriersedge.pages.LCVAdminhomeviewPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LCVAdminviewStepDefinition extends AbstractPageStepDefinition {
	public LCVAdminviewStepDefinition() {
		super();
		logger.info("LCVAdminPage2StepDefinition initialized");
	}

	private static final Logger logger = LogManager.getLogger(LCVAdminviewStepDefinition.class);
	LCVAdminhomeviewPage LCVadminpage;

	@Then("I clicked manage training plans.")
	public void i_clicked_manage_training_plans() {
		LCVadminpage = new LCVAdminhomeviewPage(driver);
		LCVadminpage.Mgcrt();
		Myutilities.sleepFor(2000);
	}

	@Then("I added new training plan.")
	public void i_added_new_training_plan() {
		LCVadminpage = new LCVAdminhomeviewPage(driver);
		LCVadminpage.Trpln();
		Myutilities.sleepFor(2000);
	}

	@Then("I verified module is assigned to the user.")
	public void i_verified_module_is_assigned_to_the_user() {
		LCVadminpage = new LCVAdminhomeviewPage(driver);
		LCVadminpage.Trpln1();
		Myutilities.sleepFor(2000);
	}

	@Then("I deleted training plan.")
	public void i_deleted_training_plan() {
		LCVadminpage = new LCVAdminhomeviewPage(driver);
		LCVadminpage.dlttp();
		Myutilities.sleepFor(2000);
	}

	@Then("I edited training plan.")
	public void i_edited_training_plan() {
		LCVadminpage = new LCVAdminhomeviewPage(driver);
		LCVadminpage.edtplan();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked manage certifications link.")
	public void i_clicked_manage_certifications_link() {
		LCVadminpage = new LCVAdminhomeviewPage(driver);
		LCVadminpage.Mngcrt();
		Myutilities.sleepFor(2000);
	}

	@Then("I selected training plan.")
	public void i_selected_training_plan() {
		LCVadminpage = new LCVAdminhomeviewPage(driver);
		LCVadminpage.Mngcrt1();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked add certification.")
	public void i_clicked_add_certification() {
		LCVadminpage = new LCVAdminhomeviewPage(driver);
		LCVadminpage.Mngcrt2();
		Myutilities.sleepFor(2000);
	}

	@Then("I edited the certificate.")
	public void i_edited_the_certificate() {
		LCVadminpage = new LCVAdminhomeviewPage(driver);
		LCVadminpage.Mngcrt3();
		Myutilities.sleepFor(2000);
	}

	@Then("I deleted the certificate.")
	public void i_deleted_the_certificate() {
		LCVadminpage = new LCVAdminhomeviewPage(driver);
		LCVadminpage.Mngcrt4();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked send email link.")
	public void i_clicked_send_email_link() {
		LCVadminpage = new LCVAdminhomeviewPage(driver);
		LCVadminpage.sndeml();
		Myutilities.sleepFor(2000);
	}

	@Then("I entered email subject.")
	public void i_entered_email_subject() {
		LCVadminpage = new LCVAdminhomeviewPage(driver);
		LCVadminpage.sndeml1();
		Myutilities.sleepFor(2000);
	}

	@Then("I entered email body.")
	public void i_entered_email_body() {
		LCVadminpage = new LCVAdminhomeviewPage(driver);
		LCVadminpage.sndeml2();
		Myutilities.sleepFor(2000);
	}

	@Then("I selected user and send the eamil.")
	public void i_selected_user_and_send_the_email() {
		LCVadminpage = new LCVAdminhomeviewPage(driver);
		LCVadminpage.sndeml3();
		Myutilities.sleepFor(2000);
	}
}

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

import com.carriersedge.pages.HomePage;
import com.carriersedge.pages.LCVAdminPage;
import com.carriersedge.pages.LCVCarrierMembership;
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
import com.carriersedge.pages.LCVReportPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LCVReportsStepDefinition extends AbstractPageStepDefinition {
	public LCVReportsStepDefinition() {
		super();
		logger.info("LCVReportStepDefinition initialized");

	}

	private static final Logger logger = LogManager.getLogger(LCVReportsStepDefinition.class);
	LCVReportPage LCReport;

	@Then("I select user activity.")
	public void i_select_user_activity() {
		if (LCReport == null)
			LCReport = new LCVReportPage(driver);
		LCReport.usrac();
		Myutilities.sleepFor(2000);
	}

	@Then("I select generate report button.")
	public void i_select_generate_report_button() {
		if (LCReport == null)
			LCReport = new LCVReportPage(driver);
		LCReport.swttab();

	}

	@Then("I select save to excel.")
	public void i_select_save_to_excel() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I select print button.")
	public void i_select_print_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I return to home page and reset filter.")
	public void i_return_to_home_page_and_reset_filter() {
		if (LCReport == null)
			LCReport = new LCVReportPage(driver);
		LCReport.rstflt();
		Myutilities.sleepFor(2000);
	}

	@Then("I selected all checkboxes and genrated report.")
	public void i_selected_all_checkboxes_and_genrated_report() {
		if (LCReport == null)
			LCReport = new LCVReportPage(driver);
		LCReport.slctcbx();
		Myutilities.sleepFor(2000);
	}

	@Then("I return to homepage and unselect all checkboxes.")
	public void i_return_to_homepage_and_unselect_all_checkboxes() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I clicked date box.")
	public void i_clicked_date_box() {
		if (LCReport == null)
			LCReport = new LCVReportPage(driver);
		LCReport.boxdte();
		Myutilities.sleepFor(2000);
	}

	@Then("I select date range with past week.")
	public void i_select_date_range_with_past_week() {
		if (LCReport == null)
			LCReport = new LCVReportPage(driver);
		LCReport.pstwk();
		Myutilities.sleepFor(2000);
	}

	@Then("I select date range with past month.")
	public void i_select_date_range_with_past_month() {
		if (LCReport == null)
			LCReport = new LCVReportPage(driver);
		LCReport.pstmth();
		Myutilities.sleepFor(2000);
	}

	@Then("I select date range with past quater.")
	public void i_select_date_range_with_past_quater() {
		if (LCReport == null)
			LCReport = new LCVReportPage(driver);
		LCReport.qtr();
		Myutilities.sleepFor(2000);
	}

	@Then("I select date range with past year.")
	public void i_select_date_range_with_past_year_and_genearted_report() {
		if (LCReport == null)
			LCReport = new LCVReportPage(driver);
		LCReport.year();
		Myutilities.sleepFor(2000);
	}

	@Then("I select users under report filter.")
	public void i_select_users_under_report_filter() {
		if (LCReport == null)
			LCReport = new LCVReportPage(driver);
		LCReport.user();
		Myutilities.sleepFor(2000);
	}

	@Then("I selected subcompany bubble and selected subcompany.")
	public void i_selected_subcompany_bubble_and_selected_subcompany() {
		if (LCReport == null)
			LCReport = new LCVReportPage(driver);
		LCReport.selsc();
		Myutilities.sleepFor(2000);
	}

	@Then("I selected location.")
	public void i_selected_location() {
		if (LCReport == null)
			LCReport = new LCVReportPage(driver);
		LCReport.locs();
		Myutilities.sleepFor(2000);
	}

	@Then("I selected individual user.")
	public void i_selected_individual_user() {
		if (LCReport == null)
			LCReport = new LCVReportPage(driver);
		LCReport.induser();
		Myutilities.sleepFor(2000);
	}

	@Then("I selected roles.")
	public void i_return_to_homepage_and_reset_filters_and_selected_roles() {
		if (LCReport == null)
			LCReport = new LCVReportPage(driver);
		LCReport.roles();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked Test Result.")
	public void i_clicked_test_result() {
		if (LCReport == null)
			LCReport = new LCVReportPage(driver);
		LCReport.Testresult();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked details on report.")
	public void i_clicked_details_on_report() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I selected modules under Report Filters.")
	public void i_selected_modules_under_report_filters() {
		if (LCReport == null)
			LCReport = new LCVReportPage(driver);
		LCReport.trainp();
		Myutilities.sleepFor(2000);
	}

	@Then("I selected Training Plans bubble icon and generated report.")
	public void i_selected_training_plans_bubble_icon_and_generated_report() {
		if (LCReport == null)
			LCReport = new LCVReportPage(driver);
		LCReport.userbox();
		Myutilities.sleepFor(2000);
	}

	@Then("I selected individual modules.")
	public void i_selected_individual_modules() {
		if (LCReport == null)
			LCReport = new LCVReportPage(driver);
		LCReport.invmod();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked User Transcripts.")
	public void i_clicked_user_transcripts() {
		if (LCReport == null)
			LCReport = new LCVReportPage(driver);
		LCReport.userTranscript();
		Myutilities.sleepFor(2000);
	}

	@Then("I select generate report button and clicked Print Certificate.")
	public void i_select_generate_report_button_and_clicked_print_certificate() {
		if (LCReport == null)
			LCReport = new LCVReportPage(driver);
		LCReport.utransrpt();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked User Compliance.")
	public void i_clicked_user_compliance() {
		if (LCReport == null)
			LCReport = new LCVReportPage(driver);
		LCReport.usrcomplaince();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked Manager compliance.")
	public void i_clicked_manager_compliance() {
		if (LCReport == null)
			LCReport = new LCVReportPage(driver);
		LCReport.mgrcomplaince();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked Events.")
	public void i_clicked_events() {
		LCReport = new LCVReportPage(driver);
		LCReport.mngevnts();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked Event Registration.")
	public void i_clicked_events_registration() {
		LCReport = new LCVReportPage(driver);
		LCReport.evntrpt();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked certifications.")
	public void i_clicked_certifications() {
		LCReport = new LCVReportPage(driver);
		LCReport.certifs();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked Transaction History.")
	public void i_clicked_transaction_history() {
		LCReport = new LCVReportPage(driver);
		LCReport.trsrpt();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked cert numbers.")
	public void i_clicked_cert_numbers() {
		LCReport = new LCVReportPage(driver);
		LCReport.certifs();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked User File Activity.")
	public void i_clicked_user_file_activity() {
		LCReport = new LCVReportPage(driver);
		LCReport.usractiv();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked LCV Instructor Workshop.")
	public void i_clicked_lcv_instructor_workshop() {
		LCReport = new LCVReportPage(driver);
		LCReport.lcvinst();
		Myutilities.sleepFor(2000);
	}

	// **************LCV add contact Step def
	@Then("I clicked register contact.")
	public void i_clicked_register_contact() {
		LCReport = new LCVReportPage(driver);
		LCReport.lcvlnk();
		Myutilities.sleepFor(2000);
	}

	@Then("I entered the first name.")
	public void i_entered_the_first_name() {
		LCReport = new LCVReportPage(driver);
		LCReport.fstnm();
		Myutilities.sleepFor(2000);
	}

	@Then("I entered the last name.")
	public void i_entered_the_last_name() {
		LCReport = new LCVReportPage(driver);
		LCReport.lsame();
		Myutilities.sleepFor(2000);
	}

	@Then("I entered the email.")
	public void i_entered_the_email() {
		LCReport = new LCVReportPage(driver);
		LCReport.elsm();
		Myutilities.sleepFor(2000);
	}

	@Then("I entered title.")
	public void i_entered_title() {
		LCReport = new LCVReportPage(driver);
		LCReport.title();
		Myutilities.sleepFor(2000);
	}

	@Then("I entered driving license.")
	public void i_entered_driving_license() {
		LCReport = new LCVReportPage(driver);
		LCReport.drlnse();
		Myutilities.sleepFor(2000);
	}

	@Then("I selected the location.")
	public void i_selected_the_location() {
		LCReport = new LCVReportPage(driver);
		LCReport.locst();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked the checkbox.")
	public void i_clicked_the_checkbox() {
		LCReport = new LCVReportPage(driver);
		LCReport.dclr();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked submit button.")
	public void i_clicked_submit_button() {
		LCReport = new LCVReportPage(driver);
		LCReport.smt();
		Myutilities.sleepFor(2000);
	}
	@Then("I clicked the new contact and deleted.")
	public void i_clicked_the_new_contact_and_deleted() {
		LCReport = new LCVReportPage(driver);
		LCReport.uDels();
		Myutilities.sleepFor(2000);
	}
	@Then("I clicked new contact and deleted.")
	public void i_clicked_new_contact_and_deleted() {
		LCReport = new LCVReportPage(driver);
		LCReport.udlts();
		Myutilities.sleepFor(2000);
	}
	// ******************* Till here

}

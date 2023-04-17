package com.carriersedge.stepDefinitions;

import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.carriersedge.pages.CourseContentPage;
import com.carriersedge.pages.HomePage;
import com.carriersedge.pages.LoginPage;
import com.carriersedge.pages.MultiplePeopleAddPage;
import com.carriersedge.pages.PasswordRecoveryPage;
import com.carriersedge.pages.PeoplePage;
import com.carriersedge.pages.ProgramDetailsPage;
import com.carriersedge.pages.ProgramsPage;
import com.carriersedge.pages.ProgressPage;
import com.carriersedge.pages.ShowEventsPage;
import com.carriersedge.pages.ShowModulesPage;
import com.carriersedge.pages.UserDetailsPage;
import com.carriersedge.pages.UserProfilePage;
import com.carriersedge.pages.VerificationPage;
import com.carriersedge.pages.YourContactInformationPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgressStepDefinitions extends AbstractPageStepDefinition {

	public ProgressStepDefinitions() {
		super();
		logger.info("ProgressStepDefinitions initialized");
	}

	LoginPage loginPage;
	HomePage homePage;
	PasswordRecoveryPage passwordRecoveryPage;
	YourContactInformationPage yourContactInformationPage;
	VerificationPage verificationPage;
	UserDetailsPage userDetailsPage;
	PeoplePage peoplePage;
	UserProfilePage userProfilePage;
	MultiplePeopleAddPage multiplePeopleAddPage;
	ProgramsPage programsPage;
	CourseContentPage courseContentPage;
	ProgramDetailsPage programDetailsPage;
	ShowModulesPage showModulesPage;
	ShowEventsPage showEventsPage;
	ProgressPage progressPage;

	private static final Logger logger = LogManager.getLogger(ProgressStepDefinitions.class);

	@Then("I clicked on Progress in the navigation bar main menu.")
	public void i_clicked_on_progress_in_the_navigation_bar_main_menu() {
		if (homePage == null)
			homePage = new HomePage(driver);
		homePage.clickProgressMainMenu();
	}

	@When("I clicked on the Activities icon on the Progress page.")
	public void i_clicked_on_the_activities_icon_on_the_progress_page() {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		progressPage.clickActivitiesIcon();
	}

	@When("I clicked on the people: All or progress people number on the progress page.")
	public void i_clicked_on_the_all_or_progress_people_number_on_the_progress_page() {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		progressPage.clickProgressPeopleNumber();
	}

	@When("I clicked on the Period: None, or other display options of the Period on the progress page.")
	public void i_clicked_on_the_period_none_or_other_display_options_of_the_period_on_the_progress_page() {
		progressPage.clickPeriod();
	}

	@When("I verified that the Grade of the user {string} was complete.")
	public void i_verified_that_the_grade_of_the_user_was_complete(String string) {
		String grade = progressPage.getGrade(string);
		logger.info("Grade: " + grade);
		logger.info(grade.equalsIgnoreCase("Complete"));
		assertTrue(grade.equalsIgnoreCase("Complete"));
	}

	@When("I clicked on the certificate of the user {string} on the progress page.")
	public void i_clicked_on_the_certificate_of_the_user_on_the_progress_page(String string) {
		progressPage.clickUserCertificate(string);
	}

	@Then("I verified that the certificate contained the name {string} on completion of module {string} on {string}.")
	public void i_verified_that_the_certificate_contained_the_name_on_completion_of_module_on(String string,
			String string2, String string3) {
		Boolean boo = progressPage.certificateContained(string, string2, string3);
		logger.info("Overall bool :" + boo);
		assertTrue(boo);
	}

	@When("I hover over on the date or Status of the module {string} on the user homepage.")
	public void i_hover_over_on_the_date_or_status_of_the_module_on_the_user_homepage(String string) {
		if (homePage == null)
			homePage = new HomePage(driver);
		homePage.hoverOverOnModuleStatusOrDate(string);
	}

	@Then("I verified that the guide text on Status or date showed {string} when hovering over.")
	public void i_verified_that_the_guide_text_on_status_or_date_showed_when_hovering_over(String string) {
		String guideText = homePage.getGuideTextOnStatusOrDateOnHover();
		logger.info("App Guide text:" + guideText);
		logger.info("Arg: " + string);
		Boolean boo = guideText.equalsIgnoreCase(string);
		logger.info(boo);
		assertTrue(boo);
	}
	@Then("I clicked on wallet card.")
	public void i_clicked_on_wallet_card() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.walletClick();
	}
	@Then("I clicked on period.")
	public void i_clicked_on_period() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions period
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.period();
	}
	@Then("I clicked on edit card.")
	public void i_clicked_on_edit_card() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.editClick();
	}
	@Then("I select the period Week.")
	public void i_select_the_period_week() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.periodWeek();
	}

	@Then("I select the period Month.")
	public void i_select_the_period_month() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.periodMonth();
	}

	@Then("I select the period Quarter.")
	public void i_select_the_period_quarter() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.periodQuarter();
	}

	@Then("I select the period Year.")
	public void i_select_the_period_year() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.periodYear();
	}
	@Then("I selected the option Include usernames as well.")
	public void i_selected_the_option_include_usernames_as_well() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.includeuname();
	}
	@Then("I selected the option Include personal information.")
	public void i_selected_the_option_include_personal_information() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.swPersonal();
	}
	@Then("I selected the option Include people with no data.")
	public void i_selected_the_option_include_people_with_no_data() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.inPeople();
	}
	@Then("I selected the option Include deleted people.")
	public void i_selected_the_option_include_deleted_people() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.deletePeople();
	}
	@Then("I selected the option Show Programs that are not currently assigned.")
	public void i_selected_the_option_show_programs_that_are_not_currently_assigned() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.progAssgn();
	}
	@Then("I selected option Show Programs that are not currently assigned.")
	public void i_selected_option_show_programs_that_are_not_currently_assigned() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.showProg();
	}
	@Then("I selected the option Show the individual language variations for each module.")
	public void i_selected_the_option_show_the_individual_language_variations_for_each_module() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.progAssn();
	}
	@Then("I selected the option Show detailed results.")
	public void i_selected_the_option_show_detailed_results() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.detResul();
	}
	@Then("I selected the option Show only the latest results in the module for each person.")
	public void i_selected_the_option_show_only_the_latest_results_in_the_module_for_each_person() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.deRes();
	}
	@Then("I selected the option Show all results for each person.")
	public void i_selected_the_option_show_all_results_for_each_person() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.showRes();
	}
	@Then("I selected the option Show only the results that include tests.")
	public void i_selected_the_option_show_only_the_results_that_include_tests() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.showRestest();
	}
	@Then("I selected the option Show only the modules that have been completed.")
	public void i_selected_the_option_show_only_the_modules_that_have_been_completed() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.showMod();
	}
	@When("I clicked on the Status icon on the Progress page.")
	public void i_clicked_on_the_status_icon_on_the_progress_page() {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.clickStatusIcon();
	}
	@Then("I clicked on programs.")
	public void i_clicked_on_programs() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.clkProg();
	}

	@Then("I selected the program.")
	public void i_selected_the_program() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.slctProg();
	}
	@Then("I clicked on the all program.")
	public void i_clicked_on_the_all_program() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.clkalProg1();
	}
	@Then("I clicked on the program.")
	public void i_clicked_on_the_program() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.clkalProg();
	}
	@Then("I selected all program.")
	public void i_selected_all_program() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.clkalProg1();
	}

	@Then("I selected the people.")
	public void i_selected_the_people() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.clkalProg1();
	}

	@Then("I selected other option.")
	public void i_selected_other_option() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.clkopt();
	}
	@Then("I selected the other option.")
	public void i_selected_the_other_option() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.clkOpti();
	}
	@Then("I selected the option Include the usernames as well.")
	public void i_selected_the_option_include_the_usernames_as_well() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.inclnme();
	}
	@Then("I selected the option Include the deleted people.")
	public void i_selected_the_option_include_the_deleted_people() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.deltPple();
	}
	@When("I clicked on the Progress icon on the Progress page.")
	public void i_clicked_on_the_progress_icon_on_the_progress_page() {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.clickProgressIcon();
	}
	@When("I clicked on the Survey icon on the Progress page.")
	public void i_clicked_on_the_survey_icon_on_the_progress_page() {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.clickSurveyIcon();
	}
	@Then("I clicked on Surveys.")
	public void i_clicked_on_surveys() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.clkProg();
	}

	@Then("I selected the survey.")
	public void i_selected_the_survey() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.slctSurvey();
	}
	@When("I clicked on the Program certificate icon on the Progress page.")
	public void i_clicked_on_the_program_certificate_icon_on_the_progress_page() {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.clickCertIcon();
	}
	@Then("I clicked on Program certificate.")
	public void i_clicked_on_program_certificate() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.programCert();
	}

	@Then("I selected certificate and generated report.")
	public void i_selected_certificate_and_generated_report() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.saveButton();
	}
	@Then("I selected people.")
	public void i_selected_people() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.peopleSelect();
	}
	@Then("I generated the report.")
	public void i_generated_the_report() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.saveButton();
	}
	@Then("I selected include deleted people option.")
	public void i_selected_include_deleted_people_option() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.otherOptions();
	}

	@Then("I selected Show expired program certificates.")
	public void i_selected_show_expired_program_certificates() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.expiredCertificates();
	}

	@Then("I selected Show deleted program certificates.")
	public void i_selected_show_deleted_program_certificates() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.deletedCertificates();
	}

	@Then("I selected Show users in progress.")
	public void i_selected_show_users_in_progress() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.userProgress();
	}

	@Then("I selected Show Region.")
	public void i_selected_show_region() throws InterruptedException {
		if (progressPage == null)
			progressPage = new ProgressPage(driver);
		    progressPage.showRegion();
	}

}

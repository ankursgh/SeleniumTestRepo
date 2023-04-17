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
import com.carriersedge.pages.LCVAdminPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LCVAdminStepDefinition extends AbstractPageStepDefinition {

	public LCVAdminStepDefinition() {
		super();
		logger.info("LCVAdminStepDefinition initialized");
	}

	private static final Logger logger = LogManager.getLogger(LCVAdminStepDefinition.class);
	LCVAdminPage Lcadmin;

	@Then("I closed the dashboard.")
	public void i_closed_the_dashboard() {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		/*
		 * String winHandleBefore = driver.getWindowHandle(); for(String winHandle :
		 * driver.getWindowHandles()){ driver.switchTo().window(winHandle);
		 * //driver.close(); driver.switchTo().window(winHandleBefore);
		 * System.out.println(winHandle); }
		 */

		Lcadmin.supportDashboardClose1();
	}

	@Then("I clicked carriers.")
	public void i_clicked_carriers() {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.ClkCarrier();
	}

	@Then("I clicked All.")
	public void i_clicked_all() throws IOException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.Clkall();
	}

	@Then("I clicked on delete button")
	public void i_clicked_on_delete_button() throws InterruptedException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.Clkdlt();

	}

	@Then("I clicked add subcompany.")
	public void i_clicked_add_subcompany() {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.ClkSubcompany();
	}

	@When("I Entered subcompany details.")
	public void i_entered_subcompany_details() throws InterruptedException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.AddSubcompany();
	}

	@When("clicked submit button.")
	public void clicked_submit_button() throws InterruptedException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.save();
	}

	// **************Location
	@Then("I clicked on Home.")
	public void i_clicked_on_home() {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.Homeclk();
	}

	@Then("search for subcompany.")
	public void search_for_subcompany() {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.Search();
	}

	@Then("I clicked Location.")
	public void i_clicked_location() {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.locationclk();
	}

	@Then("I clicked all on location.")
	public void i_clicked_all_on_location() throws IOException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.clkal();
	}

	@When("I clicked Edit button.")
	public void i_clicked_edit_button() {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.Editclk();
	}

	@Then("I saw subcompay field is empty.")
	public void i_saw_subcompay_field_is_empty() throws InterruptedException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.subcomp();
	}

	@Then("I clicked add location.")
	public void i_clicked_add_location() {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.Addlclk();
	}

	@Then("I added new location.")
	public void i_added_new_location() {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.Addloca();
	}

	@Then("I click All on location.")
	public void i_click_all_on_location() throws IOException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.Lclkall();
	}

	@Then("I clicked delete location.")
	public void i_clicked_delete_location() throws IOException, InterruptedException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.Dltloc();
	}

	@Then("I search deleted location.")
	public void i_search_deleted_location() throws IOException, InterruptedException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.serchlocation();
	}

	// ******** ********8 ***************
	@Then("I clicked search user by company.")
	public void i_clicked_search_user_by_company() throws InterruptedException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.searchcompany();
	}

	@Then("I selected company.")
	public void i_selected_company() throws InterruptedException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.selectcompany();
	}

	@Then("I selected user.")
	public void i_selected_user() throws InterruptedException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.sUser();
	}

	@Then("I verified cretificate print button.")
	public void i_verified_cretificate_print_button() throws InterruptedException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.btnCert();
	}

	@Then("I clicked user profile.")
	public void i_clicked_user_profile() throws InterruptedException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.viewprofile();
	}

	@Then("verified all details unique.")
	public void verified_all_details_unique() throws InterruptedException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.details();
	}

	@Then("I clicked view button on supporting document.")
	public void i_clicked_view_button_on_supporting_document() throws InterruptedException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.viewdoc();
	}

	@Then("I clicked exit button.")
	public void i_clicked_exit_button() throws InterruptedException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.clbtn();
	}

	@Then("I clicked location box.")
	public void i_clicked_location_box() throws InterruptedException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.edtl();
	}

	@Then("I clicke close botton on location.")
	public void i_clicke_close_botton_on_location() throws InterruptedException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.clbtn();
	}

	@Then("I search instructor.")
	public void i_search_instructor() throws InterruptedException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.sInst();
	}

	@Then("I verified insturctor cretificate print button.")
	public void i_verified_insturctor_cretificate_print_button() throws InterruptedException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.ibtnCert();
	}

	@Then("I clicked on instructor profile.")
	public void i_clicked_on_instructor_profile() throws InterruptedException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.instprofile();
	}

	@Then("I selected different time period from the Experience Date dropdown.")
	public void i_selected_different_time_period_from_the_experience_date_dropdown() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I closed instructor profile.")
	public void i_closed_instructor_profile() throws InterruptedException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.clbtn();
	}

	@Then("I clicked select user by role.")
	public void i_clicked_select_user_by_role() throws InterruptedException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.slcusr();
	}

	@Then("I selected user and mouse hover them.")
	public void i_selected_user_and_mouse_hover_them() throws InterruptedException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.lckusr();
	}

	@Then("I selected Lock this individual in the program.")
	public void i_selected_lock_this_individual_in_the_program() throws InterruptedException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.lck();
	}

	@Then("I verified user account is locked.")
	public void i_verified_user_account_is_locked() {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.vlck();
	}

	@Then("I serched locked user.")
	public void i_serched_locked_user() throws InterruptedException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.unlckusr();
	}

	@Then("I unlocked the user.")
	public void i_unlocked_the_user() throws InterruptedException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.lck();
	}

	@Then("I clicked logout button.")
	public void i_clicked_logout_button() throws InterruptedException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.logoutclk();
	}

	@When("I assigned modules to user.")
	public void i_assigned_modules_to_user() throws InterruptedException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.modulesusr();
	}

	// ********
	@Then("I closed popup.")
	public void i_closed_popupr() throws InterruptedException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.clspup();
	}

	@Then("I verified module is assigned to user.")
	public void i_verified_module_is_assigned_to_user() throws InterruptedException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.vrfmodule();
	}

	@Then("I delete user.")
	public void i_delete_user() throws InterruptedException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.dltuser();
	}

	@Then("I undeleted user.")
	public void i_undeleted_user() throws InterruptedException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.undelete();
	}

	// **** License validation ******
	@Then("I entered angency name {string}.")
	public void i_entered_angency_name(String unme) {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.agencynme(unme);
	}

	@Then("I entered badge number {string}.")
	public void i_entered_badge_number(String bdgn) {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.bgnumber(bdgn);
	}

	@Then("I entered certificate number {string}.")
	public void i_entered_certificate_number(String ctn) {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.crtno(ctn);
	}

	@Then("I entered name {string}.")
	public void i_entered_name(String nmc) {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.nme(nmc);
	}

	@Then("I verified invalid licence.")
	public void i_verified_invalid_licence() {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.vrlse();
	}

	@Then("I clicked on search button.")
	public void i_clicked_on_search_button() {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.svbtn();
	}

	@Then("I verified valid licence.")
	public void i_verified_valid_licence() {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.vldse();
	}

	@Then("I clicked on more link.")
	public void i_clicked_on_more_link() {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.mrlnk();
	}

	@Then("I clicked on outside search link.")
	public void i_clicked_on_outside_search_link() {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.outsearch();
	}

	@Then("I clicked boxdate.")
	public void i_clicked_boxdate() {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.bxdte();
	}

	@Then("I clicked pastweek.")
	public void i_clicked_pastweek() {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.pstwk();
	}

	@Then("I clicked on report.")
	public void i_clicked_on_report() {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.rptclk();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked reset filter.")
	public void i_clicked_reset_filter() {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.rstf();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked select all dates.")
	public void i_clicked_select_all_dates() {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.chkb();

	}

	// LCV Add Admin step definition
	@Then("I clicked on admin.")
	public void i_clicked_on_admin() {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.adclk();
	}

	@Then("I entered first name.")
	public void i_entered_first_name() {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.ftnme();
	}

	@Then("I entered last name.")
	public void i_entered_last_name() {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.lsnme();
	}

	@Then("I entered email.")
	public void i_entered_email() {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.uemail();
	}

	@Then("I entered password.")
	public void i_entered_password() {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.paswd();
	}

	@Then("I entered password hint.")
	public void i_entered_password_hint() {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.paswdh();
	}

	@Then("I clicked save button.")
	public void i_clicked_save_button() {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.bsve();
	}

	@Then("I checked the username.")
	public void i_checked_the_username() {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.gtuname();
	}

	@Then("I select role admin.")
	public void i_select_role_admin() {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.rolasn();
	}

	@Then("I select newly created user.")
	public void i_select_newly_created_user() throws InterruptedException {
		if (Lcadmin == null)
			Lcadmin = new LCVAdminPage(driver);
		Lcadmin.srcusr();
	}
	// Till here

}

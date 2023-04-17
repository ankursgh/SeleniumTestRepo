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
import com.carriersedge.pages.LCVAdminPage;
import com.carriersedge.pages.LCVCarrierMembership;
import com.carriersedge.pages.LCVEventsPage;
import com.carriersedge.pages.LCVReportPage;
import com.carriersedge.pages.LCVAdminHomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LCVAdminHomePageStepDefinition extends AbstractPageStepDefinition {
	public LCVAdminHomePageStepDefinition() {
		super();
		logger.info("LCVAdminPageStepDefinition initialized");
	}

	private static final Logger logger = LogManager.getLogger(LCVAdminHomePageStepDefinition.class);
	LCVAdminHomePage LCVadmin;

	@Then("I undelete the contact.")
	public void i_undelete_the_contact() throws InterruptedException {
		LCVadmin = new LCVAdminHomePage(driver);
		LCVadmin.srchusr();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked LCV contact link.")
	public void i_clicked_lcv_contact_link() {
		LCVadmin = new LCVAdminHomePage(driver);
		LCVadmin.lcvcnt();
		Myutilities.sleepFor(2000);
	}

	@Then("I selected primary contact checkbox.")
	public void i_selected_primary_contact_checkbox() {
		LCVadmin = new LCVAdminHomePage(driver);
		LCVadmin.prmcont();
		Myutilities.sleepFor(2000);
	}

	@Then("I deleted primary contact.")
	public void i_deleted_primary_contact() throws InterruptedException {
		LCVadmin = new LCVAdminHomePage(driver);
		LCVadmin.sdltusr();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked the supporting document link.")
	public void i_clicked_the_supporting_document_link() {
		LCVadmin = new LCVAdminHomePage(driver);
		LCVadmin.Spdoc();
		Myutilities.sleepFor(2000);
	}

	@Then("I changed document status.")
	public void i_changed_document_status() {
		LCVadmin = new LCVAdminHomePage(driver);
		LCVadmin.chgsts();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked document view.")
	public void i_clicked_document_view() {
		LCVadmin = new LCVAdminHomePage(driver);
		LCVadmin.pdoc();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked currently online users.")
	public void i_clicked_currently_online_users() {
		LCVadmin = new LCVAdminHomePage(driver);
		LCVadmin.conli();
		Myutilities.sleepFor(2000);
	}

	@Then("I logged out.")
	public void i_logged_out() {
		LCVadmin = new LCVAdminHomePage(driver);
		LCVadmin.lgot();
		Myutilities.sleepFor(2000);
	}

	// Wallet Print functionality
	@Then("I clicked wallet link.")
	public void i_clicked_wallet_link() {
		LCVadmin = new LCVAdminHomePage(driver);
		LCVadmin.walnk();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked show next six month button.")
	public void i_clicked_show_next_six_month_button() {
		LCVadmin = new LCVAdminHomePage(driver);
		LCVadmin.nxtmth();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked Dit link.")
	public void i_clicked_dit_link() {
		LCVadmin = new LCVAdminHomePage(driver);
		LCVadmin.Dit();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked preview button.")
	public void i_clicked_preview_button() {
		LCVadmin = new LCVAdminHomePage(driver);
		LCVadmin.Ditfn();
		Myutilities.sleepFor(2000);
	}

	// Till Here
	// Manage section
	@Then("I searched company by alphabet.")
	public void i_searched_company_by_alphabet() {
		LCVadmin = new LCVAdminHomePage(driver);
		LCVadmin.aphas();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked all button.")
	public void i_clicked_all_button() {
		LCVadmin = new LCVAdminHomePage(driver);
		LCVadmin.aphas1();
		Myutilities.sleepFor(2000);
	}

	@Then("I searched deleted company.")
	public void i_searched_deleted_company() {
		LCVadmin = new LCVAdminHomePage(driver);
		LCVadmin.aphas2();
		Myutilities.sleepFor(6000);
	}

	@Then("I searched location by alphabet.")
	public void i_searched_location_by_alphabet() {
		LCVadmin = new LCVAdminHomePage(driver);
		LCVadmin.aphas();
		Myutilities.sleepFor(2000);
	}

	@Then("I searched deleted location.")
	public void i_searched_deleted_location() {
		LCVadmin = new LCVAdminHomePage(driver);
		LCVadmin.aphas2();
		Myutilities.sleepFor(6000);
	}

	// Manage section till here
	// *********Manage Org structure
	@When("I clicked org structure.")
	public void i_clicked_org_structure() {
		LCVadmin = new LCVAdminHomePage(driver);
		LCVadmin.org1();
		Myutilities.sleepFor(2000);
	}

	@Then("I selected the user and clicked.")
	public void i_selected_the_user_and_clicked() {
		LCVadmin = new LCVAdminHomePage(driver);
		LCVadmin.org2();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked the users assigned.")
	public void i_clicked_the_users_assigned() {
		LCVadmin = new LCVAdminHomePage(driver);
		LCVadmin.org3();
		Myutilities.sleepFor(2000);
	}

	@Then("I moved user to new admin.")
	public void i_moved_user_to_new_admin() {
		LCVadmin = new LCVAdminHomePage(driver);
		LCVadmin.org4();
		Myutilities.sleepFor(2000);
	}

	// *********Till here
	// ************* LCV manage module
	@Then("I clicked manage module link.")
	public void i_clicked_manage_module_link() {
		LCVadmin = new LCVAdminHomePage(driver);
		LCVadmin.Mng1();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked add module.")
	public void i_clicked_add_module() {
		LCVadmin = new LCVAdminHomePage(driver);
		LCVadmin.Mng2();
		Myutilities.sleepFor(2000);
	}

	@Then("I added new module.")
	public void i_added_new_module() {
		LCVadmin = new LCVAdminHomePage(driver);
		LCVadmin.Mng3();
		Myutilities.sleepFor(2000);
	}

	@Then("I deleted newly created module.")
	public void i_deleted_newly_created_module() {
		LCVadmin = new LCVAdminHomePage(driver);
		LCVadmin.Mng4();
		Myutilities.sleepFor(2000);
	}
	// ************* LCV manage module
}

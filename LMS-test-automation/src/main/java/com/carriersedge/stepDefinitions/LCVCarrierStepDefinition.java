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
import com.carriersedge.pages.LCVAdminPage;
import com.carriersedge.pages.LCVCarrierMembership;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LCVCarrierStepDefinition extends AbstractPageStepDefinition {
	public LCVCarrierStepDefinition() {
		super();
		logger.info("LCVCarrierStepDefinition initialized");

	}

	private static final Logger logger = LogManager.getLogger(LCVAdminStepDefinition.class);
	LCVCarrierMembership LCmember;

	@Then("I selected carrier.")
	public void i_selected_carrier() {
		if (LCmember == null)
			LCmember = new LCVCarrierMembership(driver);
		LCmember.carrierslc();
	}

	@Then("I clicked on status.")
	public void i_clicked_on_status() {
		if (LCmember == null)
			LCmember = new LCVCarrierMembership(driver);
		LCmember.status();
	}

	@Then("I selected non member.")
	public void i_selected_non_member() {
		if (LCmember == null)
			LCmember = new LCVCarrierMembership(driver);
		LCmember.slcnon();
	}

	@Then("I selected member.")
	public void i_selected_member() {
		if (LCmember == null)
			LCmember = new LCVCarrierMembership(driver);
		LCmember.slcmem();
	}

	@Then("I clicked on save.")
	public void i_clicked_on_save() {
		if (LCmember == null)
			LCmember = new LCVCarrierMembership(driver);
		LCmember.svbn();
	}

	@Then("I clicked on save button.")
	public void i_clicked_on_save_button() {
		if (LCmember == null)
			LCmember = new LCVCarrierMembership(driver);
		LCmember.svsbn();
	}

	@Then("I clicked register driver.")
	public void i_clicked_register_driver() {
		if (LCmember == null)
			LCmember = new LCVCarrierMembership(driver);
		LCmember.rgsdriver();
	}

	@Then("I clicked checkbox.")
	public void i_clicked_checkbox() {
		if (LCmember == null)
			LCmember = new LCVCarrierMembership(driver);
		LCmember.driverdts();
	}

	@Then("I created driver user.")
	public void i_created_driver_user() {
		if (LCmember == null)
			LCmember = new LCVCarrierMembership(driver);
		LCmember.usrdriver();
	}

	// Second driver user
	@Then("I clicked accept checkbox.")
	public void i_clicked_accept_checkbox() {
		if (LCmember == null)
			LCmember = new LCVCarrierMembership(driver);
		LCmember.mdriverdts();
	}

	@Then("I created second driver user.")
	public void i_created_second_driver_user() {
		if (LCmember == null)
			LCmember = new LCVCarrierMembership(driver);
		LCmember.musrdriver();
	}

	// ***** here
	@Then("I searched user.")
	public void i_searched_user() {
		if (LCmember == null)
			LCmember = new LCVCarrierMembership(driver);
		LCmember.susers();
	}

	@Then("I deleted user.")
	public void i_deleted_user() {
		if (LCmember == null)
			LCmember = new LCVCarrierMembership(driver);
		LCmember.delus();
	}

	// second user search and delete
	@Then("I searched second user.")
	public void i_searched_second_user() {
		if (LCmember == null)
			LCmember = new LCVCarrierMembership(driver);
		LCmember.seusers();
	}

	@Then("I deleted second user.")
	public void i_deleted_second_user() {
		if (LCmember == null)
			LCmember = new LCVCarrierMembership(driver);
		LCmember.sdelus();
	}
	// ****here

}

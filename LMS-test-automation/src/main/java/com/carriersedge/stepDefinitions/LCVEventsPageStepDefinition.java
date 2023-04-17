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
import com.carriersedge.pages.LCVEventsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LCVEventsPageStepDefinition extends AbstractPageStepDefinition {
	public LCVEventsPageStepDefinition() {
		super();
		logger.info("LCVEventsPageStepDefinition initialized");
	}

	private static final Logger logger = LogManager.getLogger(LCVEventsPageStepDefinition.class);
	LCVEventsPage LCVEvent;

	@Then("I clicked on All Training Events.")
	public void i_clicked_on_all_training_events() {
		if (LCVEvent == null)
			LCVEvent = new LCVEventsPage(driver);
		LCVEvent.Eventlnk();
	}

	@Then("I clicked on update button.")
	public void i_clicked_on_update_button() {
		if (LCVEvent == null)
			LCVEvent = new LCVEventsPage(driver);
		LCVEvent.updatebn();
	}

	@Then("I selected complete.")
	public void i_selected_complete() {
		if (LCVEvent == null)
			LCVEvent = new LCVEventsPage(driver);
		LCVEvent.Stts();
	}

	@Then("I verifed training is completed.")
	public void i_verifed_training_is_completed() {
		if (LCVEvent == null)
			LCVEvent = new LCVEventsPage(driver);
		LCVEvent.Vfsts();
	}

	@Then("I selected incomplete.")
	public void i_selected_incomplete() {
		if (LCVEvent == null)
			LCVEvent = new LCVEventsPage(driver);
		LCVEvent.Stts1();
	}

	@Then("I verifed training is incompleted.")
	public void i_verifed_training_is_incompleted() {
		if (LCVEvent == null)
			LCVEvent = new LCVEventsPage(driver);
		LCVEvent.Vfincom();
	}

	@Then("I selected did not attend.")
	public void i_selected_did_not_attend() {
		if (LCVEvent == null)
			LCVEvent = new LCVEventsPage(driver);
		LCVEvent.Stts2();
	}

	@Then("I verifed training is not started.")
	public void i_verifed_training_is_not_started() {
		if (LCVEvent == null)
			LCVEvent = new LCVEventsPage(driver);
		LCVEvent.Vfincom1();
	}

	@Then("I clicked schedule training.")
	public void i_clicked_schedule_training() {
		if (LCVEvent == null)
			LCVEvent = new LCVEventsPage(driver);
		LCVEvent.strns();
	}

	@Then("I entered training details.")
	public void i_entered_training_details() {
		if (LCVEvent == null)
			LCVEvent = new LCVEventsPage(driver);
		LCVEvent.evtsdta();
	}

	@Then("I verified event is created.")
	public void i_verified_event_is_created() {
		if (LCVEvent == null)
			LCVEvent = new LCVEventsPage(driver);
		LCVEvent.evtvry();
	}

	@Then("I deleted the event.")
	public void i_deleted_the_event() {
		if (LCVEvent == null)
			LCVEvent = new LCVEventsPage(driver);
		LCVEvent.evtvy();
	}

	@Then("I clicked on Manage Events.")
	public void i_clicked_on_manage_event() {
		if (LCVEvent == null)
			LCVEvent = new LCVEventsPage(driver);
		LCVEvent.mgevt();
	}

	@Then("I clicked on edit event.")
	public void i_clicked_on_edit_event() {
		if (LCVEvent == null)
			LCVEvent = new LCVEventsPage(driver);
		LCVEvent.edevt();
	}

	@Then("I assigned users.")
	public void i_assigned_users() {
		if (LCVEvent == null)
			LCVEvent = new LCVEventsPage(driver);
		LCVEvent.asevt();
	}

	@Then("I unassigned users.")
	public void i_unassigned_users() {
		if (LCVEvent == null)
			LCVEvent = new LCVEventsPage(driver);
		LCVEvent.rmvusr();
	}

	// *****Update practical ******
	@Then("I added the driver.")
	public void i_added_the_driver() {
		if (LCVEvent == null)
			LCVEvent = new LCVEventsPage(driver);
		LCVEvent.rgdrv();
	}

	@Then("I unlocked driver user.")
	public void i_unlocked_driver_user() {
		if (LCVEvent == null)
			LCVEvent = new LCVEventsPage(driver);
		LCVEvent.activateuser();
	}

	@Then("I activated DIT certificate.")
	public void i_activated_DIT_certificate() {
		if (LCVEvent == null)
			LCVEvent = new LCVEventsPage(driver);
		LCVEvent.Rnw61();
	}

	@Then("I update the practical activity.")
	public void i_update_the_practical_activity() {
		if (LCVEvent == null)
			LCVEvent = new LCVEventsPage(driver);
		LCVEvent.upprc();
	}

	@Then("I deleted the new driver.")
	public void i_deleted_the_new_driver() {
		if (LCVEvent == null)
			LCVEvent = new LCVEventsPage(driver);
		LCVEvent.dlsdr();
	}
	// ********Update*****

}

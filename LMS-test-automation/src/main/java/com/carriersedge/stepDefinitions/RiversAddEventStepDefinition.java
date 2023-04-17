package com.carriersedge.stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.carriersedge.pages.CourseContentPage;
import com.carriersedge.pages.HomePage;
import com.carriersedge.pages.LoginPage;
import com.carriersedge.pages.MultiplePeopleAddPage;
import com.carriersedge.pages.PasswordRecoveryPage;
import com.carriersedge.pages.PeoplePage;
import com.carriersedge.pages.ProgramDetailsPage;
import com.carriersedge.pages.ProgramsPage;
import com.carriersedge.pages.ShowEventsPage;
import com.carriersedge.pages.ShowModulesPage;
import com.carriersedge.pages.UserDetailsPage;
import com.carriersedge.pages.UserProfilePage;
import com.carriersedge.pages.VerificationPage;
import com.carriersedge.pages.YourContactInformationPage;
import com.carriersedge.pages.LCVEventsPage;
import com.carriersedge.pages.LCVReportPage;
import com.carriersedge.util.Myutilities;
import com.google.common.base.CharMatcher;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RiversAddEventStepDefinition extends AbstractPageStepDefinition {
	public RiversAddEventStepDefinition() {
		super();
		logger.info("EventStepDefinitions initialized");
	}

	private static final Logger logger = LogManager.getLogger(RiversAddEventStepDefinition.class);
	ShowEventsPage showEvt;

	@Then("I clicked show events.")
	public void i_clicked_show_events() {
		if (showEvt == null)
			showEvt = new ShowEventsPage(driver);
		showEvt.clickShowEvents();
	}

	@Then("I hover over on the Events in the Program page.")
	public void i_hover_over_on_the_events_in_the_program_page() {
		if (showEvt == null)
			showEvt = new ShowEventsPage(driver);
		showEvt.clickShowEvents();
	}

	@Then("I clicked add event.")
	public void i_clicked_add_event() {
		if (showEvt == null)
			showEvt = new ShowEventsPage(driver);
		showEvt.addEventClicks1();
	}

	@Then("I added event details.")
	public void i_added_event_details() {
		if (showEvt == null)
			showEvt = new ShowEventsPage(driver);
		showEvt.addEventDetails();
	}

	@Then("I saved the event.")
	public void i_saved_the_event() {
		if (showEvt == null)
			showEvt = new ShowEventsPage(driver);
		showEvt.saveEvent();
	}

	@Then("I clicked past events.")
	public void i_clicked_past_events() {
		if (showEvt == null)
			showEvt = new ShowEventsPage(driver);
		showEvt.pastEvent();
	}

	@Then("I added past event details.")
	public void i_added_past_event_details() {
		if (showEvt == null)
			showEvt = new ShowEventsPage(driver);
		showEvt.pastEventDetails();
	}

	@Then("I searched the past event.")
	public void i_searched_the_past_event() {
		if (showEvt == null)
			showEvt = new ShowEventsPage(driver);
		showEvt.searchEvent();
	}

	@Then("I searched the future event.")
	public void i_searched_the_future_event() {
		if (showEvt == null)
			showEvt = new ShowEventsPage(driver);
		showEvt.searchFtrEvent();
	}

	@Then("I deleted the events.")
	public void i_deleted_the_events() {
		if (showEvt == null)
			showEvt = new ShowEventsPage(driver);
		showEvt.deleteEvent();
	}

	@Then("I clicked the event.")
	public void i_clicked_the_event() {
		if (showEvt == null)
			showEvt = new ShowEventsPage(driver);
		showEvt.clickFutureEvt();
	}

	@Then("I clicked the modified event.")
	public void i_clicked_the_modified_event() {
		if (showEvt == null)
			showEvt = new ShowEventsPage(driver);
		showEvt.clickmodifiedEvt();
	}

	@Then("I modified event details.")
	public void i_modified_event_details() {
		if (showEvt == null)
			showEvt = new ShowEventsPage(driver);
		showEvt.modifyFutureEvt();
	}

	@Then("I assign place to event.")
	public void i_assign_place_to_event() {
		if (showEvt == null)
			showEvt = new ShowEventsPage(driver);
		showEvt.assignPlace();
	}

	@Then("I unassign all users from event.")
	public void i_unassign_all_users_from_event() {
		if (showEvt == null)
			showEvt = new ShowEventsPage(driver);
		showEvt.unassignUsers();
	}

	@Then("I clicked the past event.")
	public void i_clicked_the_past_event() {
		if (showEvt == null)
			showEvt = new ShowEventsPage(driver);
		showEvt.clickPastEvt();
	}

	@When("I entered username <Username> and password <Password>.")
	public void i_entered_username_username_and_password_password() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I modified past event details.")
	public void i_modified_past_event_details() {
		if (showEvt == null)
			showEvt = new ShowEventsPage(driver);
		showEvt.modifyPstEvent();
	}

}

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
import com.carriersedge.pages.LCVRunDailyBatchPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LCVRunDailyBatchStepDefinition extends AbstractPageStepDefinition {
	public LCVRunDailyBatchStepDefinition() {
		super();
		logger.info("LCVRunDailyBatchStepDefinition initialized");

	}

	private static final Logger logger = LogManager.getLogger(LCVRunDailyBatchStepDefinition.class);
	LCVRunDailyBatchPage LCBatch;

	@Then("I clicked Run batch job.")
	public void i_clicked_run_batch_job() {
		if (LCBatch == null)
			LCBatch = new LCVRunDailyBatchPage(driver);
		LCBatch.dailybtc1();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked run button.")
	public void i_clicked_run_button() {
		if (LCBatch == null)
			LCBatch = new LCVRunDailyBatchPage(driver);
		LCBatch.dailybtc2();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked on past event.")
	public void i_clicked_on_past_event() {
		if (LCBatch == null)
			LCBatch = new LCVRunDailyBatchPage(driver);
		LCBatch.dailybtc3();
		Myutilities.sleepFor(2000);
	}

	@Then("I verified waiting list user removed.")
	public void i_verified_waiting_list_user_removed() {
		if (LCBatch == null)
			LCBatch = new LCVRunDailyBatchPage(driver);
		LCBatch.dailybtc4();
		Myutilities.sleepFor(2000);
	}

	@Then("I searched instructor.")
	public void i_searched_instructor() {
		if (LCBatch == null)
			LCBatch = new LCVRunDailyBatchPage(driver);
		LCBatch.dailybtc5();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked user certification.")
	public void i_clicked_user_certification() {
		if (LCBatch == null)
			LCBatch = new LCVRunDailyBatchPage(driver);
		LCBatch.dailybtc6();
		Myutilities.sleepFor(2000);
	}

	@Then("I certified user.")
	public void i_certified_user() {
		if (LCBatch == null)
			LCBatch = new LCVRunDailyBatchPage(driver);
		LCBatch.dailybtc7();
		Myutilities.sleepFor(2000);
	}
	

}

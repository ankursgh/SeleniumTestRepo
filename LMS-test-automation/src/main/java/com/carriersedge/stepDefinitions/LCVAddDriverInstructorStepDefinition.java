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
import com.carriersedge.pages.LCVAddDriverInstructorPage;
import com.carriersedge.pages.LCVAdminPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LCVAddDriverInstructorStepDefinition extends AbstractPageStepDefinition {
	public LCVAddDriverInstructorStepDefinition() {
		super();
		logger.info("LCVAddDriverandInstructor initialized");
	}

	private static final Logger logger = LogManager.getLogger(LCVAddDriverInstructorStepDefinition.class);
	LCVAddDriverInstructorPage Lcdriver;

	@Then("I registered previously certified instructor.")
	public void i_registered_previously_certified_instructor() throws InterruptedException {
		if (Lcdriver == null)
			Lcdriver = new LCVAddDriverInstructorPage(driver);
		Lcdriver.PreRtgsInstruc();
	}

	@Then("I register the new instructor.")
	public void i_register_the_new_instructor() throws InterruptedException {
		if (Lcdriver == null)
			Lcdriver = new LCVAddDriverInstructorPage(driver);
		Lcdriver.RtgsInsr();
	}

	@Then("I added a new driver.")
	public void i_added_a_new_driver() throws InterruptedException {
		if (Lcdriver == null)
			Lcdriver = new LCVAddDriverInstructorPage(driver);
		Lcdriver.rtgsdrvr();
	}

	@Then("I deleted first insturctor user.")
	public void i_deleted_first_insturctor_user() throws InterruptedException {
		if (Lcdriver == null)
			Lcdriver = new LCVAddDriverInstructorPage(driver);
		Lcdriver.deltbyuser();
	}

	@Then("I deleted first instructor.")
	public void i_deleted_first_instructor() {
		if (Lcdriver == null)
			Lcdriver = new LCVAddDriverInstructorPage(driver);
		Lcdriver.delt1();
	}

	@Then("I deleted second insturctor.")
	public void i_deleted_second_insturctor() throws InterruptedException {
		if (Lcdriver == null)
			Lcdriver = new LCVAddDriverInstructorPage(driver);
		Lcdriver.delt2();
	}

	@Then("I deleted new driver.")
	public void i_deleted_new_driver() throws InterruptedException {
		if (Lcdriver == null)
			Lcdriver = new LCVAddDriverInstructorPage(driver);
		Lcdriver.deltbyuser();
	}

	@Then("I refershed page.")
	public void i_refershed_page() throws InterruptedException {
		if (Lcdriver == null)
			Lcdriver = new LCVAddDriverInstructorPage(driver);
		Lcdriver.refersh();
	}

	// ************
	@Then("I clicked supporting document link.")
	public void i_clicked_supporting_document_link() {
		if (Lcdriver == null)
			Lcdriver = new LCVAddDriverInstructorPage(driver);
		Lcdriver.spptdoc();
	}

	@Then("I accepted the supporting documents.")
	public void i_accepted_the_supporting_documents() {
		if (Lcdriver == null)
			Lcdriver = new LCVAddDriverInstructorPage(driver);
		Lcdriver.sptdchk();
	}

	@Then("I clicked recent registrations.")
	public void i_clicked_recent_registrations() {
		if (Lcdriver == null)
			Lcdriver = new LCVAddDriverInstructorPage(driver);
		Lcdriver.rstreg();
	}

	@Then("I verified the new registration.")
	public void i_verified_the_new_registration() {
		if (Lcdriver == null)
			Lcdriver = new LCVAddDriverInstructorPage(driver);
		Lcdriver.resg();
	}

	@Then("I clicked on locked user.")
	public void i_clicked_on_locked_user() {
		if (Lcdriver == null)
			Lcdriver = new LCVAddDriverInstructorPage(driver);
		Lcdriver.lckur();
	}

	@Then("I unlocked the instructor.")
	public void i_unlocked_the_instructor() {
		if (Lcdriver == null)
			Lcdriver = new LCVAddDriverInstructorPage(driver);
		Lcdriver.ulckur();
	}

	@Then("I clicked certify user link.")
	public void i_clicked_certify_user_link() {
		if (Lcdriver == null)
			Lcdriver = new LCVAddDriverInstructorPage(driver);
		Lcdriver.cfyusr();
	}

	@Then("I certified the new user.")
	public void i_certified_the_new_user() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
	// ************
}

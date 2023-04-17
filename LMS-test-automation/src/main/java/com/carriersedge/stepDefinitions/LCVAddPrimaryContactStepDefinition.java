package com.carriersedge.stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import com.carriersedge.pages.LCVAddCarrierPrimaryContact;
import com.carriersedge.pages.LCVAdminPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LCVAddPrimaryContactStepDefinition extends AbstractPageStepDefinition {
	public LCVAddPrimaryContactStepDefinition() {
		super();
		logger.info("LCVAdd Primary contact initialized");

	}

	private static final Logger logger = LogManager.getLogger(LCVAdminStepDefinition.class);
	LCVAddCarrierPrimaryContact Pcontact;

	@Then("I clicked LCV Contact link.")
	public void i_clicked_lcv_contact_link() {
		if (Pcontact == null)
			Pcontact = new LCVAddCarrierPrimaryContact(driver);
		Pcontact.Registercont();
	}

	@Then("I entered carrier name.")
	public void i_entered_carrier_name() {
		if (Pcontact == null)
			Pcontact = new LCVAddCarrierPrimaryContact(driver);
		Pcontact.Crrname();
		Myutilities.sleepFor(1000);
	}

	@Then("I entered cvor.")
	public void i_entered_cvor() {
		if (Pcontact == null)
			Pcontact = new LCVAddCarrierPrimaryContact(driver);
		Pcontact.Cvors();
		Myutilities.sleepFor(1000);
	}

	@Then("I entered OTA acct.")
	public void i_entered_ota_acct() {
		if (Pcontact == null)
			Pcontact = new LCVAddCarrierPrimaryContact(driver);
		Pcontact.accts();
		Myutilities.sleepFor(1000);
	}

	@Then("I entered phone.")
	public void i_entered_phone() {
		if (Pcontact == null)
			Pcontact = new LCVAddCarrierPrimaryContact(driver);
		Pcontact.phne();
		Myutilities.sleepFor(1000);
	}

	@Then("I entered Fax.")
	public void i_entered_fax() {
		if (Pcontact == null)
			Pcontact = new LCVAddCarrierPrimaryContact(driver);
		Pcontact.Fxs();
		Myutilities.sleepFor(1000);
	}

	@Then("I enterd website.")
	public void i_enterd_website() {
		if (Pcontact == null)
			Pcontact = new LCVAddCarrierPrimaryContact(driver);
		Pcontact.Wbs();
		Myutilities.sleepFor(1000);
	}

	@Then("I entered company code.")
	public void i_entered_company_code() {
		if (Pcontact == null)
			Pcontact = new LCVAddCarrierPrimaryContact(driver);
		Pcontact.scd();
		Myutilities.sleepFor(1000);
	}

	@Then("I entered address1.")
	public void i_entered_address1() {
		if (Pcontact == null)
			Pcontact = new LCVAddCarrierPrimaryContact(driver);
		Pcontact.stt1();
		Myutilities.sleepFor(1000);
	}

	@Then("I entered address2")
	public void i_entered_address2() {
		if (Pcontact == null)
			Pcontact = new LCVAddCarrierPrimaryContact(driver);
		Pcontact.stt2();
		Myutilities.sleepFor(1000);
	}

	@Then("I entered city.")
	public void i_entered_city() {
		if (Pcontact == null)
			Pcontact = new LCVAddCarrierPrimaryContact(driver);
		Pcontact.ctt();
		Myutilities.sleepFor(1000);
	}

	@Then("I selected provience.")
	public void i_selected_provience() {
		if (Pcontact == null)
			Pcontact = new LCVAddCarrierPrimaryContact(driver);
		Pcontact.provs();
		Myutilities.sleepFor(1000);
	}

	@Then("I entered postal.")
	public void i_entered_postal() {
		if (Pcontact == null)
			Pcontact = new LCVAddCarrierPrimaryContact(driver);
		Pcontact.pstl();
		Myutilities.sleepFor(1000);
	}

	@Then("i choose registration form.")
	public void i_choose_registration_form() {
		if (Pcontact == null)
			Pcontact = new LCVAddCarrierPrimaryContact(driver);
		Pcontact.atfls();
		Myutilities.sleepFor(1000);
	}

	@Then("I entered firstname.")
	public void i_entered_firstname() {
		if (Pcontact == null)
			Pcontact = new LCVAddCarrierPrimaryContact(driver);
		Pcontact.frtn();
		Myutilities.sleepFor(1000);
	}

	@Then("I enterd lastname.")
	public void i_enterd_lastname() {
		if (Pcontact == null)
			Pcontact = new LCVAddCarrierPrimaryContact(driver);
		Pcontact.lsnm();
		Myutilities.sleepFor(1000);
	}

	@Then("I entered the title.")
	public void i_entered_the_title() {
		if (Pcontact == null)
			Pcontact = new LCVAddCarrierPrimaryContact(driver);
		Pcontact.tls();
		Myutilities.sleepFor(1000);
	}

	@Then("I entered the email address.")
	public void i_entered_the_email_address() {
		if (Pcontact == null)
			Pcontact = new LCVAddCarrierPrimaryContact(driver);
		Pcontact.ems();
		Myutilities.sleepFor(1000);
	}

	@Then("I entered the fax.")
	public void i_entered_the_fax() {
		if (Pcontact == null)
			Pcontact = new LCVAddCarrierPrimaryContact(driver);
		Pcontact.fx2();
		Myutilities.sleepFor(1000);
	}

	@Then("I entered phonenumber.")
	public void i_entered_phonenumber() {
		if (Pcontact == null)
			Pcontact = new LCVAddCarrierPrimaryContact(driver);
		Pcontact.phs();
		Myutilities.sleepFor(1000);
	}

	@Then("I enterd driver license.")
	public void i_enterd_driver_license() {
		if (Pcontact == null)
			Pcontact = new LCVAddCarrierPrimaryContact(driver);
		Pcontact.drvrlns();
		Myutilities.sleepFor(1000);
	}

	@Then("I clicked submit.")
	public void i_clicked_submit() {
		if (Pcontact == null)
			Pcontact = new LCVAddCarrierPrimaryContact(driver);
		Pcontact.subst();
		Myutilities.sleepFor(2000);
	}

	@Then("I selected newly created user and deleted.")
	public void i_selected_newly_created_user_and_deleted() throws InterruptedException {
		if (Pcontact == null)
			Pcontact = new LCVAddCarrierPrimaryContact(driver);
		Pcontact.srhusr();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked All and verifed carrier.")
	public void i_clicked_all_and_verifed_carrier() throws InterruptedException, IOException {
		if (Pcontact == null)
			Pcontact = new LCVAddCarrierPrimaryContact(driver);
		Pcontact.dvl1();
		Myutilities.sleepFor(2000);
	}

	@Then("I clicked all and verfied location.")
	public void i_clicked_all_and_verifed_location() throws InterruptedException, IOException {
		if (Pcontact == null)
			Pcontact = new LCVAddCarrierPrimaryContact(driver);
		Pcontact.dvl2();
		Myutilities.sleepFor(2000);
	}

	// ********************Add Secondory user SD****
	@Then("I clicked register instructor.")
	public void i_clicked_register_instructor() {
		if (Pcontact == null)
			Pcontact = new LCVAddCarrierPrimaryContact(driver);
		Pcontact.Registerinstruc();
		Myutilities.sleepFor(2000);
	}

	@Then("I register the instructor.")
	public void i_register_the_instructor() throws InterruptedException {
		if (Pcontact == null)
			Pcontact = new LCVAddCarrierPrimaryContact(driver);
		Pcontact.RtgsIns();
		Myutilities.sleepFor(2000);
	}

	@Then("I register the insturctor for another carrier.")
	public void i_register_the_instructor_for_another_carrier() throws InterruptedException {
		if (Pcontact == null)
			Pcontact = new LCVAddCarrierPrimaryContact(driver);
		Pcontact.RtgsInstruc();
		Myutilities.sleepFor(2000);
	}
	// ************here*********
}

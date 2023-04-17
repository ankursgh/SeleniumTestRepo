package com.carriersedge.stepDefinitions;

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
import com.carriersedge.pages.LCVUpgradeUser;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpgradeUserStepDefinition extends AbstractPageStepDefinition {
	public UpgradeUserStepDefinition() {
		super();
		logger.info("UpgradeUserStepDefinition initialized");
	}

	private static final Logger logger = LogManager.getLogger(UpgradeUserStepDefinition.class);
	LCVUpgradeUser LCUpgrade;

	@Then("I select user.")
	public void i_select_user() throws InterruptedException {
		if (LCUpgrade == null)
			LCUpgrade = new LCVUpgradeUser(driver);
		LCUpgrade.udlt();
	}

	@Then("I selected the user.")
	public void i_selected_the_user() throws InterruptedException {
		if (LCUpgrade == null)
			LCUpgrade = new LCVUpgradeUser(driver);
		LCUpgrade.susd();
	}

	@Then("I clicked certificate print button.")
	public void i_clicked_certificate_print_button() throws InterruptedException {
		if (LCUpgrade == null)
			LCUpgrade = new LCVUpgradeUser(driver);
		LCUpgrade.bCertclk();
	}

	@Then("I filled shipping and payment information.")
	public void i_filled_shipping_and_payment_information() throws InterruptedException {
		if (LCUpgrade == null)
			LCUpgrade = new LCVUpgradeUser(driver);
		LCUpgrade.pinfo();
	}

	@Then("I clicked changed or upgrade this individual registration status.")
	public void i_clicked_changed_or_upgrade_this_individual_registration_status() throws InterruptedException {
		if (LCUpgrade == null)
			LCUpgrade = new LCVUpgradeUser(driver);
		LCUpgrade.upgrd();
	}

	@Then("I clicked Rush Delivery New LCV Driver.")
	public void i_clicked_rush_delivery_new_lcv_driver() throws InterruptedException {
		if (LCUpgrade == null)
			LCUpgrade = new LCVUpgradeUser(driver);
		LCUpgrade.rgsdrv();
	}

	@Then("I clicked LCV contact.")
	public void i_clicked_lcv_contact() throws InterruptedException {
		if (LCUpgrade == null)
			LCUpgrade = new LCVUpgradeUser(driver);
		LCUpgrade.rgcont();
	}

	@Then("I clicked Instructor link.")
	public void i_clicked_instructor_link() throws InterruptedException {
		if (LCUpgrade == null)
			LCUpgrade = new LCVUpgradeUser(driver);
		LCUpgrade.rginst();
	}

	@Then("I register instructor.")
	public void i_register_instructor() throws InterruptedException {
		if (LCUpgrade == null)
			LCUpgrade = new LCVUpgradeUser(driver);
		LCUpgrade.registerinst();
	}
}

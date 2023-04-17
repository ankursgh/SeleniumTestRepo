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
import com.carriersedge.util.Myutilities;
import com.google.common.base.CharMatcher;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RiversAddModulesStepDefinition extends AbstractPageStepDefinition{
	public RiversAddModulesStepDefinition() {
		super();
		logger.info("EventStepDefinitions initialized");
	}
	private static final Logger logger = LogManager.getLogger(RiversAddEventStepDefinition.class);
	ShowModulesPage showMdl;
	
	@When("I clicked on the show Modules icon on the program page.")
	public void i_clicked_on_the_show_modules_icon_on_the_program_page() {
		if (showMdl == null)
			showMdl = new ShowModulesPage(driver);
		showMdl.clickShowModules();
	}
	@When("I clicked the add module.")
	public void i_clicked_the_add_module() {
		if (showMdl == null)
			showMdl = new ShowModulesPage(driver);
		showMdl.addModuleClick();
	}
	@Then("I added the module details.")
	public void i_added_the_module_details() {
		if (showMdl == null)
			showMdl = new ShowModulesPage(driver);
		showMdl.addModule();
	}
	@Then("I searched the module and deleted.")
	public void i_searched_the_module_and_deleted() {
		if (showMdl == null)
			showMdl = new ShowModulesPage(driver);
		showMdl.deleteModule();
	}
	@Then("I search module names start with Test and delete them.")
	public void i_search_module_names_start_with_test_and_delete_them() {
		if (showMdl == null)
			showMdl = new ShowModulesPage(driver);
		showMdl.searchTempmoduleAndDelete1();
	}
	//**** Program certificate
	@Then("I hover over on the Program certificate in the Program page.")
	public void i_hover_over_on_the_program_certificate_in_the_program_page() {
		if (showMdl == null)
			showMdl = new ShowModulesPage(driver);
		showMdl.clickShowCertificate();
	}

	@Then("I clicked add certificate.")
	public void i_clicked_add_certificate() {
		if (showMdl == null)
			showMdl = new ShowModulesPage(driver);
		showMdl.addEcertificate();
	}

	@Then("I added certificate details.")
	public void i_added_certificate_details() {
		if (showMdl == null)
			showMdl = new ShowModulesPage(driver);
		showMdl.certificateDetails();
	}
	@Then("I clicked show certificate.")
	public void i_clicked_show_certificate() {
		if (showMdl == null)
			showMdl = new ShowModulesPage(driver);
		showMdl.showcert();
	}

	@Then("I selected certificated and deleted.")
	public void i_selected_certificated_and_deleted() {
		
		if (showMdl == null)
			showMdl = new ShowModulesPage(driver);
		showMdl.dltcert();
	}
	//****
	//****Practical Activity
	@Then("I clicked on practical activity.")
	public void i_clicked_on_practical_activity() {
		if (showMdl == null)
			showMdl = new ShowModulesPage(driver);
		showMdl.practicalActivity();
	}
	@Then("I added practical activity details.")
	public void i_added_practical_activity_details() {
		if (showMdl == null)
			showMdl = new ShowModulesPage(driver);
		showMdl.practicaldetails();
	}
	//
}

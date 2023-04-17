package com.carriersedge.stepDefinitions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PeopleStepDefinitions extends AbstractPageStepDefinition {

	public PeopleStepDefinitions() {
		super();
		logger.info("PeopleStepDefinitions initialized");
	}

	LoginPage loginPage;
	HomePage homePage;
	PasswordRecoveryPage passwordRecoveryPage;
	YourContactInformationPage yourContactInformationPage;
	VerificationPage verificationPage;
	UserDetailsPage userDetailsPage;
	PeoplePage peoplePage;
	UserProfilePage userProfilePage;
	MultiplePeopleAddPage multiplePeopleAddPage;
	ProgramsPage programsPage;
	ProgramDetailsPage programDetailsPage;

	private static final Logger logger = LogManager.getLogger(PeopleStepDefinitions.class);

	@When("I clicked on people at the navigation bar.")
	public void i_clicked_on_people_at_the_navigation_bar() {
		if (homePage == null)
			homePage = new HomePage(driver);
		homePage.clickPeopleMainMenu();

	}

	@When("I clicked on the home the main menu.")
	public void i_clicked_on_the_home_the_main_menu() {
		if (homePage == null)
			homePage = new HomePage(driver);
		homePage.clickHomeMainMenu();

	}

	@When("I hover over on People in people page.")
	public void i_hover_over_on_people_in_people_page() {
		if (peoplePage == null)
			peoplePage = new PeoplePage(driver);// PageObjectManager.getInstance().getPeoplePage(driver);
		peoplePage.mouseHoverOnPeople();
	}

	@When("I clicked on Add Someone icon.")
	public void i_clicked_on_add_someone_icon() {
		peoplePage.clickAddSomeone();
	}

	@When("I entered first name {string} in people page.")
	@When("I entered first name {string} in user`s profile window.")
	public void i_entered_first_name_in_people_page(String fname) {
		peoplePage.addPersonFirstName(fname);
	}

	@When("I entered last name {string} in people page.")
	@When("I entered last name {string} in user`s profile window.")
	public void i_entered_last_name_in_people_page(String lname) {
		// last name is auto change if user already exist in the system
		peoplePage.addPersonLastNameWithAutoSuggest(lname);
	}

	@Then("username is auto generated when the username is not specified.")
	@Then("I verified that the username is auto-generated when the username is not specified.")
	public void username_is_auto_generated_when_the_username_is_not_specified() {
		assertTrue(peoplePage.storeUsernameTemperory() != null);
	}

	@When("click on save button in people page.")
	@When("click on save button in user`s profile window.")
	public void click_on_save_button_in_people_page() {
		if (peoplePage == null)
			peoplePage = new PeoplePage(driver);
		peoplePage.clickSavebtn();
	}

	@Then("I clicked the Cancel button on the user profile window.")
	public void i_clicked_the_cancel_button_on_the_user_profile_window() {
		if (userProfilePage == null)
			userProfilePage = new UserProfilePage(driver);
		userProfilePage.clickCancelBtn();
	}

	@When("I entered first name {string} and last name {string}, which is already exist in system.")
	public void i_entered_first_name_and_last_name_which_is_already_exist_in_system(String fname, String lname) {
		peoplePage.addPersonFirstName(fname);
		peoplePage.addPersonLastName(lname + Keys.ALT);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Then("I saw errorMessage {string} in People page.")
	public void i_saw_error_message_in_people_page(String msg) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		peoplePage.userMatchErrorMsg(msg);
	}

	@When("I click on the `Click here` on the error message.")
	public void i_click_on_the_click_here_on_the_error_message() {
		peoplePage.clickOnChickhereOnErrorMessage();
	}

	@Then("I verified that the error message disappears.")
	public void i_verified_that_the_error_message_disappears() {
		peoplePage.noUsernameErrorMsg();
	}

	@When("I entered first name {string} and last name {string}, password {string} and Password Hint {string} in Add someone form.")
	public void i_entered_first_name_and_last_name_password_and_password_hint_in_add_someone_form(String fname,
			String lname, String pass, String hint) {
		peoplePage.addPersonFirstName(fname);
		peoplePage.addPersonLastNameWithAutoSuggest(lname);
		peoplePage.addPersonPassword(pass);
		peoplePage.addPersonPassHint(hint);
	}

	@When("I clicked on Email Notification and write email address {string}.")
	public void i_clicked_on_email_notification_and_write_email_address(String eamilAdds) {
		peoplePage.enterEmail(eamilAdds);

	}

	@Then("I Verified that the requestor’s carrier is defaulted in the Add user page.")
	public void i_verified_that_the_requestor_s_carrier_is_defaulted_in_the_add_user_page() {
		peoplePage.verifyDefaultCarrier();
	}

	@When("I selected the user role level is {string}.")
	public void i_selected_the_user_role_level_is(String role) {
		peoplePage.setPersonRole(role);

	}

	@When("I checked for the user role {string} option is not present in the dropdown.")
	public void i_checked_for_the_user_role_option_is_not_present_in_the_dropdown(String role) {

		assertFalse(peoplePage.isRolePresent(role));
	}

	@Then("I Verified that the user role is default set to Driver.")
	public void i_verified_that_the_user_role_is_default_set_to_driver() {
		assertTrue(peoplePage.getPersonRole().contains("driver"));
	}

	@When("location is not specified.")
	public void location_is_not_specified() {
		peoplePage.setAssignedPlace("-- Choose Location --");
	}

	@When("I choose the location {string}.")
	@When("I edited the current user`s place to {string}.")
	public void i_choose_the_location(String place) {
		peoplePage.setAssignedPlace(place);
		;
	}

	@Then("The user got conformation email from `support@carriersedge.com` about account created.")
	public void the_user_got_conformation_email_from_support_carriersedge_com_about_account_created() {
		String username = peoplePage.getLastCreatedUser().get("username");
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String Emsg = Myutilities.getSnippetFromEmailOfMultipleUser(peoplePage.getCarrier() + " / CarriersEdge account created for you");
		logger.info("username : " + username + " and Email Msg: " + Emsg + " Carrier: " + peoplePage.getCarrier());
		assertTrue(Emsg.contains(username));
		assertTrue(Emsg.contains("created an account for you in the CarriersEdge online training system"));
	}

	@Then("the user is seen in the people page.")
	public void the_user_is_seen_in_the_people_page() {
		if (peoplePage == null)
			peoplePage = new PeoplePage(driver);
		Boolean boo = peoplePage.getUsernameElement(peoplePage.getlastCreatedUsername()).isDisplayed();
		assertTrue(boo);
	}

	@When("I clicked the newly created user in people page.")
	public void i_clicked_the_newly_created_user_in_people_page() {
		if (peoplePage == null)
			peoplePage = new PeoplePage(driver);
		// retrieve newly created username and click the username in the people page
		peoplePage.getUsernameElement(peoplePage.getlastCreatedUsername()).click();

	}

	@Then("I clicked the {int} th newly created user in people page.")
	public void i_clicked_the_th_newly_created_user_in_people_page(Integer int1) {
		if (peoplePage == null)
			peoplePage = new PeoplePage(driver);
		if (multiplePeopleAddPage == null)
			multiplePeopleAddPage = new MultiplePeopleAddPage(driver);

		logger.info("newuser: " + multiplePeopleAddPage.getUserFName(int1 - 1));
		peoplePage.getUsernameElement(multiplePeopleAddPage.getUserFName(int1 - 1).toLowerCase() + "."
				+ multiplePeopleAddPage.getUserLName(int1 - 1).toLowerCase()).click();

	}

	@Then("I confirmed that the {int} th newly created user location is the same as the requestor location {string}.")
	public void i_confirmed_that_the_th_newly_created_user_location_is_the_same_as_the_requestor_location(Integer int1,
			String string) {
		if (peoplePage == null)
			peoplePage = new PeoplePage(driver);
		if (multiplePeopleAddPage == null)
			multiplePeopleAddPage = new MultiplePeopleAddPage(driver);

		logger.info("newuser: " + multiplePeopleAddPage.getUserFName(int1 - 1));
		String loc = peoplePage.getUserLocationElement(multiplePeopleAddPage.getUserFName(int1 - 1).toLowerCase() + "."
				+ multiplePeopleAddPage.getUserLName(int1 - 1).toLowerCase()).getText();
		logger.info("User location : " + loc);
		assertTrue(loc.contains(string));
	}

	@Then("the user name {string} is clicked on the people page.")
	@Then("I clicked the username {string} on the people page to open the user profile.")
	public void the_user_name_is_clicked_on_the_people_page(String string) {
		if (peoplePage == null)
			peoplePage = new PeoplePage(driver);
		try {
			peoplePage.getUsernameElement(string).click();
		} catch (Exception e) {
			try {
				peoplePage.clickPeopleIcon();
				Thread.sleep(1000);
				peoplePage.getUsernameElement(string).click();
			} catch (Exception ex) {
				peoplePage.searchName(string);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				peoplePage.getUsernameElement(string).click();
			}

			logger.info("username click on Exception");
		}

	}

	@Then("the user is notified by email with user credentials.")
	@Then("I saw a notification about a new user created on the user`s email address at `carriersedgemutiuserstest@gmail.com`.")
	public void the_user_is_notified_by_email_with_user_credentials() {

		String snippet = Myutilities.getSnippetFromEmailOfMultipleUser("ProcessAutomation2 - Rivers / CarriersEdge account created for you");
		logger.info("MultipleUser Email msg:  " + snippet);
		boolean contains = snippet.contains("Your login details are:");
		boolean contains2 = snippet.contains(peoplePage.getlastCreatedUsername());
		logger.info("Last Created username :  " + peoplePage.getlastCreatedUsername());
	}

	// ***************change for LMST-916
	@Then("I checked the available billed users.")
	public void i_checked_the_available_billed_users() {
		peoplePage = new PeoplePage(driver);
		try {
			peoplePage.getNoOfbilleduser();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("I clicked on total sapce available icon.")
	public void i_clicked_on_total_sapce_available_icon() {
		peoplePage = new PeoplePage(driver);

		try {
			peoplePage.clickavailablespace();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("I confirmed that the number that`s at `Billed user` is increased by {int}.")
	public void i_confirmed_that_the_number_that_s_at_billed_user_is_increased_by(Integer int1) {
		if (peoplePage == null)
			peoplePage = new PeoplePage(driver);
		assertTrue(peoplePage.isUsersIncrease());
	}

	// ********till LMST-916
	@When("I fill out the new password textBox with {string} and confirm Password with {string}.")
	public void i_fill_out_the_new_password_text_box_with_and_confirm_password_with(String password,
			String confirmPassword) {
		if (peoplePage == null)
			peoplePage = new PeoplePage(driver);
		peoplePage.addPersonPassword(password);
		peoplePage.WriteConformedPasswordAtProfileWindow(confirmPassword);
	}

	@Then("I verified that the programs\\/courses {string} assigned as per user location.")
	@Then("I checked the user`s profile and verified that the programs\\/courses {string} assigned to the user.")
	public void i_verified_that_the_programs_courses_assigned_as_per_user_location(String string) {
		if (userProfilePage == null)
			userProfilePage = new UserProfilePage(driver);
		boolean boo = userProfilePage.isModuleAssignedInProfile(string);
		logger.info("course present: " + boo);
		// ***** Change for LMST907
		// assertTrue(boo);
	}

	@Then("checked the user`s profile and verified that the programs\\/courses {string} is not assigned to the user.")
	@Then("I checked the user`s profile and verified that the programs\\/courses {string} is not assigned to the user.")
	@Then("I checked the user`s profile and verified that the module {string} is not present.")
	public void checked_the_user_s_profile_and_verified_that_the_programs_courses_is_not_assigned_to_the_user(
			String string) {
		if (userProfilePage == null)
			userProfilePage = new UserProfilePage(driver);
		boolean boo = !userProfilePage.isModuleAssignedInProfile(string);
		logger.info("course not present: " + boo);
		// ********LMS907 Change 1
		// assertTrue(boo);
	}

	@Then("I confirmed that `the total spaces available` are greater than or equal to `currently in use`\\(license checked).")
	public void i_confirmed_that_the_total_spaces_available_are_greater_than_or_equal_to_currently_in_use_license_checked() {
		if (peoplePage == null)
			peoplePage = new PeoplePage(driver);
		boolean boo = peoplePage.getNoOfAvailableUsers() >= peoplePage.getNoOfLicenseUsed();
		logger.info("Available>noOfUsedLicense: " + boo);
		assertTrue(boo);
	}

	@Then("I confirmed that the number that`s at `Currently in Use` is increased by {int}.")
	public void i_confirmed_that_the_number_that_s_at_currently_in_use_is_increased_by(Integer int1) {
		if (peoplePage == null)
			peoplePage = new PeoplePage(driver);
		assertTrue(peoplePage.isUsersIncreaseByOne());
	}

	@Then("I verified from the user profile that the assigned manager of the user is {string}.")
	public void i_verified_from_the_user_profile_that_the_assigned_manager_of_the_user_is(String string) {

		if (userProfilePage == null)
			userProfilePage = new UserProfilePage(driver);
		String mgr = userProfilePage.getManager();

		logger.info("Manager : " + mgr);
		logger.info(mgr.equalsIgnoreCase(string));
		assertTrue(mgr.equalsIgnoreCase(string));
	}

	@When("I set the current user`s manager to {string}.")
	public void i_set_the_current_user_s_manager_to(String string) {
		userProfilePage.setManager(string);
	}

	@When("I hover over on last created user on the people page.")
	public void i_hover_over_on_last_created_user_on_the_people_page() {
		WebElement usernameElement = peoplePage.getUsernameElement(peoplePage.getLastCreatedUsername());
		Actions actions = new Actions(driver);
		actions.moveToElement(usernameElement).perform();

	}

	@When("I hover over on user {string} on the people page.")
	public void i_hover_over_on_user_on_the_people_page(String string) {
		if (peoplePage == null)
			peoplePage = new PeoplePage(driver);
		WebElement usernameElement = peoplePage.getUsernameElement(string);
		Actions actions = new Actions(driver);
		actions.moveToElement(usernameElement).perform();
	}

	@When("I deleted the hovered user from the people page.")
	public void i_deleted_the_hovered_user_from_the_people_page() {
		peoplePage.deleteHoveredUser();
	}

	@When("I confirmed that the number that`s at `Currently in Use` is decreased and deleted people increase by {int}.")
	public void i_confirmed_that_the_number_that_s_at_currently_in_use_is_decreased_and_deleted_people_increase_by(
			Integer int1) {
		assertTrue(peoplePage.isCurrentlyInUseDecreasedByOne());
		assertTrue(peoplePage.isDeletedPeopleIncreasedByOne());

	}

	@When("I clicked on the multiple people add option.")
	public void i_clicked_on_the_multiple_people_add_option() {
		if (multiplePeopleAddPage == null)
			multiplePeopleAddPage = new MultiplePeopleAddPage(driver);
		multiplePeopleAddPage.selectMultiplePeopleAdd();

	}

	@When("I added {int} th user which have the first name {string} and the last name {string} in the carrier.")
	public void i_added_th_user_which_have_the_first_name_and_the_last_name_in_the_carrier(Integer serialNum,
			String firstName, String lastName) {
		if (multiplePeopleAddPage == null)
			multiplePeopleAddPage = new MultiplePeopleAddPage(driver);
		multiplePeopleAddPage.addFirstname(serialNum, firstName);
		multiplePeopleAddPage.addLastname(serialNum, lastName);
	}

	@Then("I clicked the save button on multiple people add user window.")
	public void i_clicked_the_save_button_on_multiple_people_add_user_window() {
		multiplePeopleAddPage.clickSaveBtn();
	}

	@Then("I clicked the cancel button on multiple people add user window.")
	public void i_clicked_the_cancel_button_on_multiple_people_add_user_window() {
		multiplePeopleAddPage.clickCancelBtn();
	}

	@Then("I added {int} th user first name {string} only.")
	public void i_added_th_user_first_name_only(Integer serialNum, String firstName) {
		multiplePeopleAddPage.addFirstname(serialNum, firstName);
	}

	@Then("I added {int} th user last name {string} only.")
	public void i_added_th_user_last_name_only(Integer serialNum, String firstName) {
		multiplePeopleAddPage.addLastname(serialNum, firstName);
	}

	@Then("I verified that the status is active.")
	public void i_verified_that_the_status_is_active() {
		if (userProfilePage == null)
			userProfilePage = new UserProfilePage(driver);
		boolean boo = userProfilePage.isStatusActive();
		logger.info("Status: " + boo);

	}

	@When("I verified that the status of user {string} on the people page is {string}.")
	public void i_verified_that_the_status_of_user_on_the_people_page_is(String userName, String status) {
		if (peoplePage == null)
			peoplePage = new PeoplePage(driver);
		int i = 0;
		while (driver.findElements(By.xpath("//div[@class='label'][contains(.,'Browse:')]")).size() == 0 && i < 5) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			logger.info("300 ms waited.");
			i++;
		}
		String sts = peoplePage.getUserStatusElement(userName).getText();
		logger.info("Status " + sts + " from arg " + status + " of user " + userName);

	}

	@Then("I added {int} random users from multiple People add form.")
	public void i_added_random_users_from_multiple_people_add_form(Integer int1) {
		if (multiplePeopleAddPage == null)
			multiplePeopleAddPage = new MultiplePeopleAddPage(driver);
		multiplePeopleAddPage.addMultipleUsers(int1);
	}

	@When("I clicked on upload a file to upload users from xls file.")
	public void i_clicked_on_upload_a_file_to_upload_users_from_xls_file() {
		if (multiplePeopleAddPage == null)
			multiplePeopleAddPage = new MultiplePeopleAddPage(driver);
		multiplePeopleAddPage.clickUploadFile();
		multiplePeopleAddPage.browseFile();
	}

	@When("I clicked on logged in as in the current user Link.")
	public void i_clicked_on_logged_in_as_in_the_current_user_link() {
		if (homePage == null)
			homePage = new HomePage(driver);
		homePage.clickloggedInAs();
	}

	@Then("I checked the current user`s first name {string} and last name {string}.")
	public void i_checked_the_current_user_s_first_name_and_last_name(String string, String string2) {
		if (userProfilePage == null)
			userProfilePage = new UserProfilePage(driver);
		assertTrue(userProfilePage.getFirstname().equalsIgnoreCase(string));
		assertTrue(userProfilePage.getLastname().equalsIgnoreCase(string2));
	}

	@When("I Edit the current user`s first name {string} and last name {string}.")
	public void i_edit_the_current_user_s_first_name_and_last_name(String string, String string2) {
		if (userProfilePage == null)
			userProfilePage = new UserProfilePage(driver);
		userProfilePage.editFirstName(string);
		userProfilePage.editLastName(string2);
	}

	@When("click on save button in user`s profile.")
	public void click_on_save_button_in_user_s_profile() {
		userProfilePage.clickSaveBtn();
	}

	@Then("I checked the email address of the current user is {string}.")
	public void i_checked_the_email_address_of_the_current_user_is(String string) {
		assertTrue(userProfilePage.getEmailAddress().equalsIgnoreCase(string));
	}

	@When("I edit the current user`s email address as {string}.")
	public void i_edit_the_current_user_s_email_address_as(String string) {
		userProfilePage.setEmailAddress(string);
	}

	@Then("I clecked current user role is {string} and found true.")
	public void i_clecked_current_user_role_is_and_found_true(String string) {
		String str = userProfilePage.getRole();
		assertTrue(str.equalsIgnoreCase(string));
	}

	@When("I edited the current user role to {string}.")
	public void i_edited_the_current_user_role_to(String string) {
		userProfilePage.setRole(string);
	}

	@Then("I verified that the language selection of the current user is {string}.")
	public void i_verified_that_the_language_selection_of_the_current_user_is(String string) {
		String lang = userProfilePage.getLanguage();
		assertTrue(lang.equalsIgnoreCase(string));
	}

	@When("I edited the current user`s language to {string}.")
	public void i_edited_the_current_user_s_language_to(String string) {
		userProfilePage.setLanguage(string);
	}

	@Then("I verified that the users {string} are selected to the program.")
	public void i_verified_that_the_users_selected_to_the_program(String string) {
		if (programDetailsPage == null)
			programDetailsPage = new ProgramDetailsPage(driver);
		String[] myArray = string.split(", ");
		for (String usr : myArray)
			logger.info("Arg: " + usr);

		String[] users = programDetailsPage.getSelectedUsers();
		for (String user : users)
			logger.info("App: " + user);
		Boolean boo = Arrays.asList(users).containsAll(Arrays.asList(myArray));
		logger.info("disable users contain :" + boo);
		assertTrue(boo);
	}

	@Then("I verified that the modules {string} are selected to the program.")
	public void i_verified_that_the_modules_are_selected_to_the_program(String string) {
		if (programDetailsPage == null)
			programDetailsPage = new ProgramDetailsPage(driver);
		String[] myArray = string.split(", ");
		for (String usr : myArray)
			logger.info("Arg: " + usr);

		String[] modules = programDetailsPage.getSelectedModules();
		for (String module : modules)
			logger.info("App: " + module);
		Boolean boo = Arrays.asList(modules).containsAll(Arrays.asList(myArray));
		logger.info("Matched? :" + boo);
		assertTrue(boo);
	}

	@When("I clicked on `x people assigned` to the {string} place.")
	public void i_clicked_on_x_people_assigned_to_the_program(String string) {
		if (peoplePage == null)
			peoplePage = new PeoplePage(driver);
		peoplePage.clickPeopleAssignedToPlace(string);
	}

}

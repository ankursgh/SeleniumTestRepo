package com.carriersedge.stepDefinitions;

import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.carriersedge.pages.HomePage;
import com.carriersedge.pages.LoginPage;
import com.carriersedge.pages.MultiplePeopleAddPage;
import com.carriersedge.pages.PasswordRecoveryPage;
import com.carriersedge.pages.PeoplePage;
import com.carriersedge.pages.UserDetailsPage;
import com.carriersedge.pages.VerificationPage;
import com.carriersedge.pages.YourContactInformationPage;
import com.carriersedge.util.Myutilities;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SelfServedLoginSteps extends AbstractPageStepDefinition {
	private static final Logger logger = LogManager.getLogger(SelfServedLoginSteps.class);

	LoginPage loginPage;
	HomePage homePage;
	PasswordRecoveryPage passwordRecoveryPage;
	YourContactInformationPage yourContactInformationPage;
	VerificationPage verificationPage;
	UserDetailsPage userDetailsPage;
	PeoplePage peoplePage;
	MultiplePeopleAddPage multiplePeopleAddPage;
	Alert alert;
	String randomName = "NavaAutomation" + Myutilities.getRandomName();
	String randomEmail = "NavaAutomation" + Myutilities.getRandomEmail();
	String tempVerificationCode;

	@Then("I saw the login page.")
	public void i_saw_login_page() {
		if (loginPage == null)
			loginPage = new LoginPage(driver);
		loginPage.checkLoginPageTitle();
		logger.info("I saw the login Page.");

	}

	@When("I Entered username {string} and password {string}.")
	@When("I entered username {string} and password {string}.")
	@When("I entered username {string} and password {string} as a customer support.")
	public void i_entered_username_and_password(String username, String password) {
		if (loginPage == null)
			loginPage = new LoginPage(driver);
		if (username.equalsIgnoreCase("validuser")) {
			loginPage.enterUserName("nava.abc");
		} else {
			loginPage.enterUserName(username);
		}
		if (password.equalsIgnoreCase("validpassword")) {
			loginPage.enterpassword("test");
		} else {
			loginPage.enterpassword(password);
		}

		logger.info("entered login username and password.");
	}

	@When("I Entered usrname {string} and pasword {string}.")
	// ***********LMST-917
	public void i_entered_usrname_and_pasword(String uname, String pwd) {
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
		if (loginPage == null)
			loginPage = new LoginPage(driver);
		if (uname.equalsIgnoreCase("validuser")) {

			loginPage.enterUsrName("nava.abc");

		} else {
			loginPage.enterUsrName(uname);
		}
		if (pwd.equalsIgnoreCase("validpassword")) {
			loginPage.enterpasword("test");
		} else {
			loginPage.enterpasword(pwd);
		}

		logger.info("entered login username and password.");
	}

	@When("I clicked on email.")
	public void i_clicked_on_email() {

		loginPage.clickonemail();

	}

	@When("clicked on here link.")
	public void clicked_on_here_link() {

		loginPage.clkhere();
	}

	@Then("clicked on link.")
	public void clicked_on_link() {

		loginPage.herelnk();
	}

	@Then("I verified title of recovery page.")
	public void i_verified_title_of_recovery_page() {
		loginPage.RecoveryPageTitle();
	}

	// **********LMST-917*********here
	@When("I enter as a newly created username and password {string}.")
	public void i_enter_as_a_newly_created_username_and_password(String string) {
		if (peoplePage == null)
			peoplePage = new PeoplePage(driver);
		String lastUsername = peoplePage.getlastCreatedUsername();
		logger.info("last created username: " + lastUsername);
		loginPage.enterUserName(lastUsername);

		loginPage.enterpassword(string);
	}

	@When("I log in as a {int} th newly created user in the application using the password as Firstname.")
	public void i_log_in_as_a_th_newly_created_user_in_the_application_using_the_password_as_firstname(Integer int1) {
		if (multiplePeopleAddPage == null)
			multiplePeopleAddPage = new MultiplePeopleAddPage(driver);

		loginPage.enterUserName(multiplePeopleAddPage.getUserFName(int1 - 1).toLowerCase() + "."
				+ multiplePeopleAddPage.getUserLName(int1 - 1).toLowerCase());
		loginPage.enterpassword(multiplePeopleAddPage.getUserFName(int1 - 1).toLowerCase());
		// loginPage.enterUserName(multiplePeopleAddPage.getTUser(int1-1));//.........temp
		// use remove later
		// loginPage.enterpassword("test");
	}

	@When("clicked Submit button on the login page.")
	public void clicked_submit_button_on_the_login_page() {
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		loginPage.clickedGoButton();
		logger.info("and clicked submit.");
	}

	@Then("I logged in successfully.")
	@Then("I logged in successfully which proved that the password is independent of the letter case.")
	public void i_logged_in_successfully() throws InterruptedException {
		if (homePage == null)
			homePage = new HomePage(driver);
		homePage.checkHomePageOpen();

		logger.info("I logged in successfully.");
	}

	@When("I Clicked Get help here link on the login page.")
	public void i_clicked_get_help_here_link_on_the_login_page() {
		loginPage.getHelpHereLinkClick();
		logger.info("I Click Get help here link.");
	}

	@Then("I negivated to the password recover page.")
	@Then("I navigated to the password recovery page.")
	public void i_negivated_to_the_password_recover_page() {
		passwordRecoveryPage = new PasswordRecoveryPage(driver);
		passwordRecoveryPage.checkPasswordRecoveryPage();
		logger.info(" negivated to the password recover page");
	}

	@Then("I saw a propUp message-{string} in login page.")
	public void i_saw_a_prop_up_message_in_login_page(String expectedMsg) {
		String msg = driver.switchTo().alert().getText();
		logger.info("prop msg :" + msg);
		assertTrue(msg.contains(expectedMsg));
	}

	@Then("I entered {string} in username field on login page")
	public void i_entered_in_username_field_on_login_page(String username) {
		String un = null;
		if (username.contains("random") || username.equalsIgnoreCase("randomname")) {
			un = randomName;
		} else {
			un = username;
		}

		loginPage.enterUserName(un);
		logger.info("user name :" + un + " taken");
	}

	@When("Clicked on Send button on the `Your Contact Information page`.")
	@When("I clicked the send button on the Your Contact Information page \\(contact support page).")
	public void clicked_on_send_button_on_the_your_contact_information_page() {

		yourContactInformationPage.clickSendBtn();
	}

	@Then("I saw a prop up message {string} in Your Contact Information page.")
	public void i_saw_a_prop_up_message_in_your_contact_information_page(String propMsg) {
		assertTrue(yourContactInformationPage.getPropUpMsg().contains(propMsg));
	}

	@When("I enter company name {string} on the `Your Contact Information page`.")
	public void i_enter_company_name_on_the_your_contact_information_page(String compName) {
		if (yourContactInformationPage == null)
			yourContactInformationPage = new YourContactInformationPage(driver);
		yourContactInformationPage.enterCompanyName(compName);

	}

	@When("I clicked Submit button without entering the Username or Email on the password recover form.")
	@When("I clicked Submit button on the password recover page.")
	public void i_clicked_submit_button_without_entering_the_username_or_email_on_the_password_recover_form() {

		passwordRecoveryPage.submitRecoveryRequest();
		logger.info("clicked submit button on password recover page");
	}

	@When("I enter non existing username or email {string} in password Recovery page.")
	@When("I entered my username Or Email as {string} for password recovery.")
	public void i_enter_non_existing_username_or_email_in_password_recovery_page(String usernameOrEmail) {
		String selected = usernameOrEmail;
		if (usernameOrEmail.equalsIgnoreCase("randomemail") || usernameOrEmail.contains("randomemail")) {
			selected = randomName;
			logger.info("Email " + selected + " taken");
		} else if (usernameOrEmail.equalsIgnoreCase("random") || usernameOrEmail.contains("random")) {
			selected = randomName;
			logger.info("username " + selected + " taken");
		}
		passwordRecoveryPage.enterUsernameOrEmail(selected);
		logger.info("the user was entered in the password recovery");
	}

	@When("I entered my username Or Email as `Random Name` for password recovery.")
	public void i_entered_my_username_or_email_as_random_name_for_password_recovery() {
		passwordRecoveryPage.enterUsernameOrEmail(randomName);
		logger.info("Random username: " + randomName + " was taken.");

	}

	@When("I entered my username Or Email as `Random Email` for password recovery.")
	public void i_entered_my_username_or_email_as_random_email_for_password_recovery() {
		passwordRecoveryPage.enterUsernameOrEmail(randomEmail);
		logger.info("Random Email: " + randomEmail + " was taken.");
	}

	@Then("I negivated to the Your Contact Information page.")
	@Then("I navigated to the Your Contact Information page.")
	public void i_negivated_to_the_your_contact_information_page() {
		yourContactInformationPage = new YourContactInformationPage(driver);
		String title = driver.getTitle();
		System.out.println("Title Page: " + title);
		logger.info("Title Page: " + title);
		assertTrue(title.contains("Forgot password - CarriersEdge"));

	}

	@Then("I checked an email in carriersedgetest@gmail.com for six digit verification code and I found it.")
	public void i_checked_an_email_in_carriersedgetest_gmail_com_for_six_digit_verification_code_and_i_found_it() {

		String code = Myutilities.getCodeFromEmail();
		tempVerificationCode = code;
		logger.info("the email code is: " + code);
		assertTrue(code.length() == 6);

	}

	@Then("I checked an email in carriersedgemutiuserstest@gmail.com for six digit verification code and I found it.")
	public void i_checked_an_email_in_carriersedgemutiuserstest_gmail_com_for_six_digit_verification_code_and_i_found_it() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String code = Myutilities.getCodeFromEmailOfMultipleUser();
		logger.info("the email code is: " + code);
		assertTrue(code.length() == 6);

	}

	@Then("I checked an email in processautomationshare@gmail.com for six digit verification code and I found it.")
	public void i_checked_an_email_in_processautomationshare_gmail_com_for_six_digit_verification_code_and_i_found_it() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String code = Myutilities.getCodeFromProcessAutomationShareEmail();
		logger.info("the email code is: " + code);
		assertTrue(code.length() == 6);
	}

	@Then("I verified code email content look like mockup_{int}.")
	public void i_verification_code_email_content_look_like_mockup(Integer int1) {
		assertTrue(Myutilities.matchEmailPattern());

	}

	@When("I Clicked Resend on verification page.")
	public void i_clicked_resend_on_verification_page() {
		verificationPage = new VerificationPage(driver);
		verificationPage.clickResendVerification();

	}

	@Then("I saw a message `A new code has been generated and sent to the user email`.")
	public void i_saw_a_message_a_new_code_has_been_generated_and_sent_to_the_user_email_automated_to_the_message_seen_text() {
		Boolean boo = verificationPage.verifyCodeResendconfirmation();
		logger.info("Resend code verify. " + boo);
		assertTrue(boo);

	}

	@When("I clicked ok butoon in verification page.")
	public void i_clicked_ok_butoon_in_verification_page() {
		if (verificationPage == null)
			verificationPage = new VerificationPage(driver);
		verificationPage.clickOkredirectBtn();
	}

	@When("I enter the code from email to the verification page.")
	@When("I enter the new code from email to the verification page.")
	public void i_enter_the_code_from_email_to_the_verification_page() {

		verificationPage.enterVerificationCode(Myutilities.getCodeFromEmail());

	}

	@Then("I enter the code from carriersedgemutiuserstest@gmail.com to the verification page.")
	public void i_enter_the_code_from_carriersedgemutiuserstest_gmail_com_to_the_verification_page() {
		verificationPage.enterVerificationCode(Myutilities.getCodeFromEmailOfMultipleUser());
	}

	@Then("I enter the code from processautomationshare@gmail.com to the verification page.")
	public void i_enter_the_code_from_processautomationshare_gmail_com_to_the_verification_page() {
		verificationPage.enterVerificationCode(Myutilities.getCodeFromProcessAutomationShareEmail());
	}

	@When("I submitted the verification code.")
	public void i_submitted_the_verification_code() {
		verificationPage.clickSubmitBtn();
	}

	@Then("The system redirected to Reset Password page mockup_{int}.")
	public void the_system_redirected_to_reset_password_page_mockup(Integer int1) {
		assertTrue(verificationPage.checkPasswordResetPage());

	}

	@When("I filled in the contact support page; company name as {string},full name as {string},Email as {string},phone as {string}.")
	public void i_filled_in_the_contact_support_page_company_name_as_full_name_as_email_as_phone_as(String companyName,
			String fullName, String email, String phoneNumber) {
		if (companyName.equalsIgnoreCase("random")) {
			yourContactInformationPage.enterCompanyName(randomName);
		} else {
			yourContactInformationPage.enterCompanyName(companyName);
		}
		if (fullName.equalsIgnoreCase("random")) {
			yourContactInformationPage.enterfullName(randomName);
		} else {
			yourContactInformationPage.enterfullName(fullName);
		}
		if (email.equalsIgnoreCase("random")) {
			yourContactInformationPage.enterEmail(randomEmail);
		} else {
			yourContactInformationPage.enterEmail(email);
		}

		yourContactInformationPage.enterPhoneNumber(phoneNumber);

	}

	@When("clicked cancel on the contact support page.")
	public void clicked_cancel_on_the_contact_support_page() {
		yourContactInformationPage.clickCancelBtn();
	}

	@Then("I verified that the contact support page was not submitted.")
	public void i_verified_that_the_contact_support_page_was_not_submitted() {
		// verifying that the login page is displayed.
		loginPage.checkLoginPageTitle();
	}

	@Then("I varified that a message {string} was displayed.")
	public void i_varified_that_a_message_was_displayed(String displayMsg) {
		yourContactInformationPage.sendReqConformMsgCheck(displayMsg);
	}

	@Then("I saw the page redirectid to \\(contact supppot)mockup_six showing message {string}.")
	public void i_saw_the_page_redirectid_to_mockup_six_contact_supppot_showing_message(String msgDisplay) {
		if (yourContactInformationPage == null) {
			yourContactInformationPage = new YourContactInformationPage(driver);
		}
		yourContactInformationPage.accntfoundButNotEmailMsg(msgDisplay);
	}

	@Then("I saw the page redirectid to \\(contact supppot)mockup_ten showing message {string}.")
	public void i_saw_the_page_redirectid_to_mockup_ten_contact_supppot_showing_message(String msgDisplay) {
		if (yourContactInformationPage == null) {
			yourContactInformationPage = new YourContactInformationPage(driver);
		}
		yourContactInformationPage.emailAddressAccountNotFoundMsg(msgDisplay);

	}

	@Then("I saw the page redirectid to \\(user details)Mockup_eleven showing message {string}.")
	public void i_saw_the_page_redirectid_to_user_details_mockup_eleven_showing_message(String msgDisplay) {
		if (userDetailsPage == null) {
			userDetailsPage = new UserDetailsPage(driver);
		}
		userDetailsPage.sameEmailAddressSeveralAccountsMsg(msgDisplay);

	}

	@When("I filled in the user details  Username as {string},First Name as {string},Last Name as {string}.")
	public void i_filled_in_the_user_details_username_as_first_name_as_last_name_as(String userName, String firstName,
			String lastName) {
		if (userDetailsPage == null) {
			userDetailsPage = new UserDetailsPage(driver);
		}

		if (userName.equalsIgnoreCase("random")) {
			userDetailsPage.enterUserName(randomName);
		} else {
			userDetailsPage.enterUserName(userName);
		}
		if (firstName.equalsIgnoreCase("random")) {
			userDetailsPage.enterFirstName(randomName);

		} else {
			userDetailsPage.enterFirstName(firstName);

		}
		if (lastName.equalsIgnoreCase("random")) {
			userDetailsPage.enterLsatName(randomName);
		} else {
			userDetailsPage.enterLsatName(lastName);
		}

	}

	@When("I clicked Submit Button on User Details page.")
	public void i_clicked_submit_button_on_user_details_page() {
		userDetailsPage.clickSubmitBtn();
	}

	@Then("I saw a message `An email with verification code has been sent`.")
	public void i_saw_a_message_an_email_with_verification_code_has_been_sent() {
		if (verificationPage == null) {
			verificationPage = new VerificationPage(driver);
		}
		assertTrue(verificationPage.isVerificationCodeSend());
	}

	@Then("I saw a message `A new verification code has been generated and sent to` and emails displayed on the forms are masked as {string}.")
	public void i_saw_a_message_an_email_with_verification_code_has_been_sent_and_emails_displayed_on_the_forms_are_masked_as(
			String maskedEmail) {
		if (verificationPage == null) {
			verificationPage = new VerificationPage(driver);
		}
		assertTrue(verificationPage.isVerificationCodeSend());
		verificationPage.checkMaskedEmailDisplay(maskedEmail);
	}

	@Then("I saw the system was redirected to Mock_{int} \\(user details) and showed the message {string}.")
	public void i_saw_the_system_was_redirected_to_mock_user_details_and_showed_the_message(Integer int1,
			String msgDisplay) {
		if (userDetailsPage == null) {
			userDetailsPage = new UserDetailsPage(driver);
		}
		userDetailsPage.userDetailMock_12MsgVerify(msgDisplay);
	}

	@When("I filled in again the user details with same above data Username as {string},First Name as {string},Last Name as {string}{double} times.")
	public void i_filled_in_again_the_user_details_with_same_above_data_username_as_first_name_as_last_name_as_times(
			String userName, String firstName, String lastName, Double double1) {
		if (userDetailsPage == null) {
			userDetailsPage = new UserDetailsPage(driver);
		}

		if (userName.equalsIgnoreCase("random")) {
			userDetailsPage.enterUserName(randomName);
		} else {
			userDetailsPage.enterUserName(userName);
		}
		if (firstName.equalsIgnoreCase("random")) {
			userDetailsPage.enterFirstName(randomName);
			;
		} else {
			userDetailsPage.enterFirstName(firstName);
			;
		}
		if (lastName.equalsIgnoreCase("random")) {
			userDetailsPage.enterLsatName(randomName);
		} else {
			userDetailsPage.enterLsatName(lastName);
		}
	}

	@When("I clicked Try Again Button on the User Details page.")
	public void i_clicked_try_again_button_on_the_user_details_page() {
		userDetailsPage.clickTryAgainBtn();
	}

	@Then("I saw a message {string} as MockUp_{int}.")
	public void i_saw_a_message_as_mock_up(String msgDisplay, Integer int1) {
		userDetailsPage.messageExceededAttemptsMsgMockUp14(msgDisplay);
	}

	@When("I clicked Contact Us button after {int} times Failed on the User Details page.")
	public void i_clicked_contact_us_button_after_times_failed_on_the_user_details_page(Integer int1) {
		if (userDetailsPage == null) {
			userDetailsPage = new UserDetailsPage(driver);
		}
		userDetailsPage.clickContactUsBtn();
	}

	@Then("I verified the user is {string}.")
	public void i_verified_the_user_is(String userName) {
		if (passwordRecoveryPage == null) {
			passwordRecoveryPage = new PasswordRecoveryPage(driver);
		}
		passwordRecoveryPage.passwordChangeUserNameConfirmation(userName);
	}

	@When("I entered new password and confirm new password in the password recovery page")
	public void i_entered_new_password_and_confirm_new_password_in_the_password_recovery_page() {
		if (passwordRecoveryPage == null)
			passwordRecoveryPage = new PasswordRecoveryPage(driver);
		passwordRecoveryPage.enterNewPassword("test");
		passwordRecoveryPage.enterConfirmNewPassword("test");
		logger.info("new password and conform password were entered");
	}

	@Then("I verified that both password right icon were present.")
	public void i_verified_that_both_password_right_icon_were_present() {
		passwordRecoveryPage.checkConformationPasswordMatch();
	}

	@When("I Clicked change button in the password recovery page.")
	public void i_clicked_change_button_in_the_password_recovery_page() {
		passwordRecoveryPage.clickChangeBtn();
	}

	@Then("I Got an email having subject: Password reset confirmation and the Body content {string}.")
	public void i_got_an_email_having_subject_password_reset_confirmation_and_the_body_content(String content) {
		String gmailMsg = Myutilities.getSnippetFromEmail("Password Reset Confirmation");
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("Password Reset Cof Msg : " + gmailMsg);
		assertTrue(gmailMsg.contains(content));

	}

	@Then("I saw message display about password successfully changed.")
	public void i_saw_message_display_about_password_successfully_changed() {
		passwordRecoveryPage.checkMsgPasswordScccessChange("The password for user");
		passwordRecoveryPage.checkMsgPasswordScccessChange("successfully changed");
	}

	@Then("I clicked ok button in the password successfully change message.")
	public void i_clicked_ok_button_in_the_password_successfully_change_message() {
		passwordRecoveryPage.clickOkInPasswardSuccessfullyMsg();
	}

	@When("I also entered full name {string} on the `Your Contact Information page`.")
	public void i_also_entered_full_name_on_the_your_contact_information_page(String fullName) {
		yourContactInformationPage.enterfullName(fullName);

	}

	@When("I entered email address  {string} on the `Your Contact Information page`.")
	public void i_entered_email_address_on_the_your_contact_information_page(String email) {
		yourContactInformationPage.enterEmail(email);
	}

	@When("I entered phone number {string} on the `Your Contact Information page`.")
	public void i_entered_phone_number_on_the_your_contact_information_page(String string) {
		yourContactInformationPage.enterPhoneNumber(string);

	}

	@When("I entered {string} \\(less then {int} characters) in new password field of password reset page.")
	public void i_entered_less_then_characters_in_new_password_field_of_password_reset_page(String newPassword,
			Integer int1) {
		passwordRecoveryPage.enterNewPassword(newPassword);

	}

	@When("I entered {string} in new password field of password reset page.")
	public void i_entered_in_new_password_field_of_password_reset_page(String newPassword) {
		passwordRecoveryPage.enterNewPassword(newPassword);
	}

	@When("I entered {string} in new confirm password test box field of password reset page.")
	public void i_entered_in_new_confirm_password_test_box_field_of_password_reset_page(String confirmPassword) {
		passwordRecoveryPage.enterConfirmNewPassword(confirmPassword);
	}

	@When("I entered the previous generated code to the verification page for the password recovery.")
	public void i_enter_the_old_code_to_the_verification_page_for_the_password_recovery() {
		logger.info("Last (expaired) verification code: " + tempVerificationCode);
		verificationPage.enterVerificationCode(tempVerificationCode);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("I click on Settings Main menu.")
	public void i_click_on_settings_main_menu() {
		homePage.clickSettingsMainMenu();
	}

	@When("I uncheck Everyone change their password check Box in Settings.")
	public void i_uncheck_everyone_change_their_password_check_box_in_settings() {
		homePage.uncheckOnPasswordChangeChkBxInSettings();
	}

	@Then("I Saved the Settings.")
	public void i_saved_the_settings() {
		homePage.clickSaveBtn();
	}

	@When("Log out From the Carriers.")
	public void log_out_from_the_carriers() {
		homePage.chickLogoutBtn();
	}

	@When("I clicked on user profile link.")
	public void i_clicked_on_user_profile_link() {
		homePage.chickOnUserProfileLink();
	}

	@When("I clicked on the change password link on the profile window.")
	public void i_clicked_on_the_change_password_link_on_the_profile_window() {
		if (peoplePage == null) {
			peoplePage = new PeoplePage(driver);
		}
		peoplePage.clickChangePasswordLink();
	}

	@When("I checked Everyone change their password check Box in Settings.")
	public void i_checked_everyone_change_their_password_check_box_in_settings() {
		homePage.checkOnPasswordChangeChkBxInSettings();
	}

	@Then("I got an error message `You have exceeded the number of allowed attempts. Please try again in {int} minutes`.")
	public void i_got_an_error_message_you_have_exceeded_the_number_of_allowed_attempts_please_try_again_in_minutes(
			Integer int1) {
		if (verificationPage == null)
			verificationPage = new VerificationPage(driver);
		verificationPage.checkTryAgainIn10MinBlockMsg(
				"You have exceeded the number of allowed attempts. Please try again in 10 minutes");

	}

	@Then("I clicked cancel button on Your Contact Information page.")
	public void i_clicked_cancel_button_on_your_contact_information_page() {
		if (yourContactInformationPage == null)
			yourContactInformationPage = new YourContactInformationPage(driver);
		yourContactInformationPage.clickCancelBtn();
	}

	@Then("I saw an error message `Sorry but there was an error.`")
	public void i_saw_an_error_message_sorry_but_there_was_an_error() {
		if (verificationPage == null)
			verificationPage = new VerificationPage(driver);
		verificationPage.checkErrorAfterLockout("Sorry but there was an error");
	}

	@Then("I got an error message `You have exceeded the number of allowed attempts. Please try again in {int} hours`.")
	public void i_got_an_error_message_you_have_exceeded_the_number_of_allowed_attempts_please_try_again_in_hours(
			Integer int1) {
		if (verificationPage == null)
			verificationPage = new VerificationPage(driver);
		verificationPage.checkTryAgainIn10MinBlockMsg(
				"You have exceeded the number of allowed attempts. Please try again in 24 hours");
		// The element msg is same for 24 hour and 10 minute block
	}

	@Then("I saw No permission password reset message {string}.")
	public void i_saw_no_permission_password_reset_message(String message) {
		if (verificationPage == null)
			verificationPage = new VerificationPage(driver);
		verificationPage.checkPasswardNoPermissionResetMsg(message);
	}

	@When("I clicked Contact Us button on the User Details window.")
	public void i_clicked_contact_us_button_on_the_user_details_window() {
		if (userDetailsPage == null) {
			userDetailsPage = new UserDetailsPage(driver);
		}
		userDetailsPage.clickContactUsBtn();
	}

	@Then("I saw not permission to reset password message {string} on the password recover page.")
	public void i_saw_not_permission_to_reset_password_message_on_the_password_recover_page(String msg) {
		if (yourContactInformationPage == null)
			yourContactInformationPage = new YourContactInformationPage(driver);
		yourContactInformationPage.doNotHavePermissionMsg(msg);

	}

}

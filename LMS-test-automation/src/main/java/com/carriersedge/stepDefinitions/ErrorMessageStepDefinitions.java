package com.carriersedge.stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import com.carriersedge.pages.HomePage;
import com.carriersedge.pages.LoginPage;
import com.carriersedge.pages.PasswordRecoveryPage;
import com.carriersedge.pages.UserDetailsPage;
import com.carriersedge.pages.VerificationPage;
import com.carriersedge.pages.YourContactInformationPage;
import com.carriersedge.util.BrowserFactory;
import com.carriersedge.util.Myutilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ErrorMessageStepDefinitions {
	private static final Logger logger = LogManager.getLogger(ErrorMessageStepDefinitions.class);
	Alert alert;
	public WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	PasswordRecoveryPage passwordRecoveryPage;
	private String browserName;
	YourContactInformationPage yourContactInformationPage;
	VerificationPage verificationPage;
	UserDetailsPage userDetailsPage;
	String randomName = "NavaAutomation" + Myutilities.getRandomName();
	String randomEmail = "NavaAutomation" + Myutilities.getRandomEmail();

	/*
	 * 
	 * @When("I opened the Rivers login page {string}.") public void
	 * i_opened_the_rivers_login_page(String appURL) { driver =
	 * BrowserFactory.startApplication(driver, "chrome", appURL);
	 * logger.info("Open the " + appURL + " page."); }
	 * 
	 * 
	 * 
	 * @Then("I saw a propUp message- Please enter your username") public void
	 * i_saw_a_prop_up_message_please_enter_your_username() { alert =
	 * driver.switchTo().alert();
	 * System.out.println("Enter your: "+alert.getText());
	 * alert.getText().contains("Please enter your username"); }
	 * 
	 * @Then("clicked OK button on prop up.") public void
	 * clicked_ok_button_on_prop_up() { alert.accept(); }
	 * 
	 * @Then("I entered username in username filed and clicked Submit button.")
	 * public void i_entered_username_in_username_filed_and_clicked_submit_button()
	 * { // Write code here that turns the phrase above into concrete actions throw
	 * new io.cucumber.java.PendingException(); }
	 * 
	 * @Then("I saw a propUp message- Please enter your password.") public void
	 * i_saw_a_prop_up_message_please_enter_your_password() { // Write code here
	 * that turns the phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 * 
	 * @Then("I clicked Ok button on prop up.") public void
	 * i_clicked_ok_button_on_prop_up() { // Write code here that turns the phrase
	 * above into concrete actions throw new io.cucumber.java.PendingException(); }
	 * 
	 * @When("I clicked Submit button without Username or Email.") public void
	 * i_clicked_submit_button_without_username_or_email() { // Write code here that
	 * turns the phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 * 
	 * @Then("I saw a prop up message-Please enter your username or email.") public
	 * void i_saw_a_prop_up_message_please_enter_your_username_or_email() { // Write
	 * code here that turns the phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 * 
	 * @When("I enter non existing username or email in password Recovery page")
	 * public void
	 * i_enter_non_existing_username_or_email_in_password_recovery_page() { // Write
	 * code here that turns the phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 * 
	 * @Then("I negivated to the Your Contact Information Form.") public void
	 * i_negivated_to_the_your_contact_information_form() { // Write code here that
	 * turns the phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 * 
	 * @Then("Clicked on Send button.") public void clicked_on_send_button() { //
	 * Write code here that turns the phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 * 
	 * @Then("I saw a prop up message- Plase enter your company name.") public void
	 * i_saw_a_prop_up_message_plase_enter_your_company_name() { // Write code here
	 * that turns the phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 * 
	 * @When("I enter company name {string}.") public void
	 * i_enter_company_name(String string) { // Write code here that turns the
	 * phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 * 
	 * //@When("Clicked on Send button.") //public void clicked_on_send_button() {
	 * // // Write code here that turns the phrase above into concrete actions //
	 * throw new io.cucumber.java.PendingException(); //}
	 * 
	 * @Then("I saw a prop up message- Please enter your full name.") public void
	 * i_saw_a_prop_up_message_please_enter_your_full_name() { // Write code here
	 * that turns the phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 * 
	 * @When("I also entered full name {string}.") public void
	 * i_also_entered_full_name(String string) { // Write code here that turns the
	 * phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 * 
	 * @Then("I saw a prop up message- Please enter a valid email address.") public
	 * void i_saw_a_prop_up_message_please_enter_a_valid_email_address() { // Write
	 * code here that turns the phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 * 
	 * @When("I also entered invalid email {string}.") public void
	 * i_also_entered_invalid_email(String string) { // Write code here that turns
	 * the phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 * 
	 * @When("I also entered valid email {string}.") public void
	 * i_also_entered_valid_email(String string) { // Write code here that turns the
	 * phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 * 
	 * @Then("I saw a prop up message- Please enter your contact phone number.")
	 * public void i_saw_a_prop_up_message_please_enter_your_contact_phone_number()
	 * { // Write code here that turns the phrase above into concrete actions throw
	 * new io.cucumber.java.PendingException(); }
	 * 
	 * @Given("I want to write a step with name1") public void
	 * i_want_to_write_a_step_with_name1() { // Write code here that turns the
	 * phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 * 
	 * @When("I check for the {int} in step") public void
	 * i_check_for_the_in_step(Integer int1) { // Write code here that turns the
	 * phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 * 
	 * @Then("I verify the success in step") public void
	 * i_verify_the_success_in_step() { // Write code here that turns the phrase
	 * above into concrete actions throw new io.cucumber.java.PendingException(); }
	 * 
	 * @Given("I want to write a step with name2") public void
	 * i_want_to_write_a_step_with_name2() { // Write code here that turns the
	 * phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 * 
	 * @Then("I verify the Fail in step") public void i_verify_the_fail_in_step() {
	 * // Write code here that turns the phrase above into concrete actions throw
	 * new io.cucumber.java.PendingException(); }
	 * 
	 * 
	 */

}

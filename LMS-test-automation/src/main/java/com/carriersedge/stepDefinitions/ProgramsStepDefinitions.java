package com.carriersedge.stepDefinitions;

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

public class ProgramsStepDefinitions extends AbstractPageStepDefinition {

	public ProgramsStepDefinitions() {
		super();
		logger.info("ProgramsStepDefinitions initialized");
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
	CourseContentPage courseContentPage;
	ProgramDetailsPage programDetailsPage;
	ShowModulesPage showModulesPage;
	ShowEventsPage showEventsPage;

	private static final Logger logger = LogManager.getLogger(ProgramsStepDefinitions.class);

	@When("I clicked on Programs in the navigation bar main menu.")
	public void i_clicked_on_programs_in_the_navigation_bar_main_menu() {
		if (homePage == null)
			homePage = new HomePage(driver);
		homePage.clickProgramsMainMenu();
	}

	@When("I clicked on Show Programs on the Programs page.")
	public void i_clicked_on_show_programs_on_the_programs_page() {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.clickShowPrograms();
	}

	@Then("I verified that {int} modules assigned to the {string} program.")
	public void i_verified_that_modules_assigned_to_the_program(Integer int1, String string) {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		Integer no = -1;
		int i = 0;
		while ((no.compareTo(int1)) != 0 && i < 3) {

			try {
				Thread.sleep(1000);
				programsPage.clickShowPrograms();
				no = programsPage.getNoOfAssignedModuleToProgram(string);
				logger.info("waited 1000 ms");
			} catch (Exception e) {
				Myutilities.sleepFor(1000);
				no = programsPage.getNoOfAssignedModuleToProgram(string);				
			}
			i++;

		}

		logger.info("Module Assigned " + no);
		logger.info("Arg : " + int1);
		assertTrue((int1.compareTo(no)) == 0);
	}

	@Then("I verified that {int} people assigned to the {string} program.")
	public void i_verified_that_people_assigned_to_the_program(Integer int1, String string) {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		Integer no = -1;
		int i = 0;
		while ((no.compareTo(int1)) != 0 && i < 8) {

			try {
				no = programsPage.getNoOfAssignedPeopleToProgram(string);
				Myutilities.sleepFor(1000);
				logger.info("waited 1000 ms");
			} catch (Exception e) {					
				Myutilities.sleepFor(1000);
				no = programsPage.getNoOfAssignedPeopleToProgram(string);				
			}
			i++;

		}
		logger.info("Assigned people: " + no);
		logger.info("From Arg: " + int1);
		logger.info(no.compareTo(int1));
	}
	//**Role**
	@Then("I verified {int} people assigned to the {string} program.")
	public void i_verified_people_assigned_to_the_program(Integer int1, String string) {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		Integer no = -1;
		int i = 0;
		while ((no.compareTo(int1)) != 0 && i < 8) {

			try {
				no = programsPage.getNoOfAssignedPeopleToProgram(string);
				Myutilities.sleepFor(1000);
				logger.info("waited 1000 ms");
			} catch (Exception e) {
				Myutilities.sleepFor(1000);
				no = programsPage.getNoOfAssignedPeopleToProgram(string);
			}
			i++;

		}
		logger.info("Assigned people: " + no);
		logger.info("From Arg: " + int1);
		logger.info(no.compareTo(int1));
		assertTrue((int1.compareTo(no)) == 0);
	}
	
	@When("I clicked on `x people assigned` to the {string} program.")
	public void i_clicked_on_x_people_assigned_to_the_program(String string) {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.clickPeopleAssignedToProgram(string);
	}

	@When("I clicked on the deadline link of the {string} program.")
	public void i_clicked_on_the_deadline_link_of_the_program(String string) {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.clickOnDeadlineLinkOfProgram(string);
	}

	@When("I clicked on the deadline link of the {string} module.")
	public void i_clicked_on_the_deadline_link_of_the_module(String string) {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.clickOnDeadlineLinkOfModule(string);
	}

	@When("I clicked on the x module assigned of the {string} program.")
	public void i_clicked_on_the_x_module_assigned_of_the_program(String string) {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.clickOnModuleAssignedOfProgram(string);
	}

	@When("I selected the Assign People tab in a small window of the program page.")
	@When("I selected the Assign People tab in a small window.")
	public void i_selected_the_assign_people_tab_in_a_small_window_of_the_program_page() {
		programsPage.clickAssignPeopleTab();
	}

	@When("I selected the Assign Places tab on the program assigned display window.")
	public void i_selected_the_assign_places_tab_on_the_program_assigned_display_window() {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.clickAssignPlacesTab();
	}

	@Then("I clicked on the Add To Program tab in the selected module.")
	public void i_clicked_on_the_add_to_program_tab_in_the_module() {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.clickAddToProgramTab();
	}

	@When("I clicked on a place have id {string} on the people assign display window.")
	public void i_clicked_on_a_place_have_id_on_the_people_assign_display_window(String placeId) {
		try {
			programsPage.clickPlace(placeId);
		} catch (Exception e) {
			programsPage.clickAssignPlacesTab();
			Myutilities.sleepFor(500);
			programsPage.clickPlace(placeId);
		}
	}

	@Then("I saw the disable users {string} in Assign people.")
	public void i_saw_the_disable_users_in_assign_people(String string) {
		String[] myArray = string.split(", ");
		for (String usr : myArray)
			logger.info("Arg: " + usr);

		String[] disableUsers = programsPage.getDisableUsers();
		for (String user : disableUsers)
			logger.info("App: " + user);
		Boolean boo = Arrays.asList(disableUsers).containsAll(Arrays.asList(myArray));
		logger.info("disable users contain :" + boo);

	}

	@When("I clicked on user {string} at available to assign on Assign people.")
	@When("I clicked on the user {string} on the Assign people tab.")
	public void i_clicked_on_user_at_available_to_assign_on_assign_people(String string) {
		String str = string;
		logger.info("steps def string: " + str);
		try {
			programsPage.clickElementbyId(string);
			logger.info("Exception assign people.");
		}catch(StaleElementReferenceException ex) {
			Myutilities.sleepFor(1500);
			programsPage.clickElementbyId(string);
		}
	}

	@When("I clicked on user-id {string} to select the user if not already selected.")
	public void i_clicked_on_user_id_to_selecet_user_if_not_already_selected(String string) {
		String str = string;
		logger.info("steps def string: " + str);
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.selectUnselectedElementById(string);
	}

	@Then("I selected a place {string} whose id is {string} if it is not selected on the display window.")
	public void i_selected_a_place_whose_id_is_if_it_is_not_selected_on_the_display_window(String string,
			String string2) {
		String str = string2;
		logger.info("Arg: " + str);
		programsPage.selectUnselectedElementById(string2);
	}

	@When("I clicked on the reset checkbox.")
	public void i_clicked_on_reset_checkbox() {
		programsPage.clickResetCheckBox();
	}

	@Then("I verified that the courses {string} present on the user homepage.")
	@Then("I verified that the modules {string} present on the user homepage.")
	public void i_verified_that_the_courses_present_on_the_user_homepage(String string) {
		if (homePage == null)
			homePage = new HomePage(driver);
		String[] myArray = string.split(", ");
		for (String usr : myArray)
			logger.info(usr);
		String[] assignModules;
		Boolean boo = false;
		try {
			assignModules = homePage.getAssignedModules();
		} catch (Exception ex) {
			driver.navigate().refresh();
			logger.info("Course exception");
			assignModules = homePage.getAssignedModules();
		}

		for (String course : assignModules)
			logger.info(course);
		boo = Arrays.asList(assignModules).containsAll(Arrays.asList(myArray));
		if (boo == false) {
			driver.navigate().refresh();
			try {
				assignModules = homePage.getAssignedModules();
			} catch (Exception ex) {
				driver.navigate().refresh();
				logger.info("Course exception");
				assignModules = homePage.getAssignedModules();
			}

			for (String course : assignModules)
				logger.info(course);
			boo = Arrays.asList(assignModules).containsAll(Arrays.asList(myArray));
		}
		
	}

	@Then("I verified that the courses {string} is not present on the user homepage.")
	@Then("I verified that the modules {string} is not present on the user homepage.")
	public void i_verified_that_the_courses_is_are_not_present_on_the_user_homepage(String string) {
		if (homePage == null)
			homePage = new HomePage(driver);
		String[] assignCourses;

		String[] myArray = string.split(", ");
		for (String usr : myArray)
			logger.info("Arg: " + usr);
		try {
			assignCourses = homePage.getAssignedModules();
		} catch (Exception ex) {
			driver.navigate().refresh();
			logger.info("Course exception");
			assignCourses = homePage.getAssignedModules();
		}
		Boolean boo = !Arrays.asList(assignCourses).containsAll(Arrays.asList(myArray));
		logger.info("assign courses contain :" + boo);
		
	}

	@When("I clicked on Unselect All in the program.")
	@When("I clicked on Unselect All.")
	public void i_clicked_on_unselect_all_in_the_program() {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.clickUnSelectAll();
	}

	@When("I clicked on select All in the program.")
	public void i_clicked_on_select_all_in_the_program() {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.clickSelectAll();
	}

	@Then("I saw a background running message {string} at people assigned.")
	public void i_saw_a_background_running_message_at_people_assigned(String string) {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		Boolean boo = false;
		int i = 0;
		String msg = "";
		while (!boo && i < 7) {
			msg = programsPage.backgroungRunningMsg();
			boo = msg.contains(string);
			Myutilities.sleepFor(1000);
			i++;
		}

		logger.info("Background running msg checked : " + i + " times and message is: " + msg);
		logger.info("Arg: " + string);
		logger.info("is match : " + msg.contains(string));
		
	}

	@When("I checked on the `Notify People They have been Assigned to a Program`.")
	public void i_checked_on_the_notify_people_they_have_been_assigned_to_a_program() {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.checkSendNotice();
	}

	@When("I checked on the `Include login details in the notification`.")
	public void i_checked_on_the_include_login_details_in_the_notification() {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.checkIncludeLogin();

	}

	@Then("I checked a user`s email and verified that the user got a notification that contains {string} about the course or login.")
	public void i_checked_a_user_s_email_and_verified_that_the_user_got_a_notification_that_contains_about_the_course_or_login(
			String string) {
		String[] myArray = string.split(", ");
		String snippet = Myutilities.getSnippetFromEmailOfMultipleUser("New training has been assigned to you");
		logger.info(snippet);
		for (int i = 0; i < myArray.length; i++) {
			boolean boo = snippet.contains(myArray[i]);
			assertTrue(boo);
			logger.info("Checked true : " + i + 1);
		}
		boolean contains = snippet.contains("has assigned the following training modules to you")
				|| snippet.contains("has assigned the following modules to you");
		assertTrue(contains);
	}
	@Then("I verified that I got an email that contains the subject {string} and the message {string} to multiple user email.")
	public void i_verified_that_i_got_an_email_that_contains_the_subject_and_the_message_to_multiple_user_email(String string, String string2) {
		String snippet = Myutilities.getSnippetFromEmailOfMultipleUser(string);
		logger.info(snippet);
		boolean contains = snippet.contains(string2);
		assertTrue(contains);
	}

	@Then("I verified that the email `processautomationshare@gmail.com` got a notification that contains {string} about the new training.")
	public void i_verified_that_the_email_processautomationshare_gmail_com_got_a_notification_that_contains_about_the_new_training(
			String string) {
		String[] myArray = string.split(", ");
		String snippet = Myutilities.getSnippetFromProcessAutomationShareEmail("New training has been assigned to you");
		logger.info(snippet);
		for (int i = 0; i < myArray.length; i++) {
			boolean boo = snippet.contains(myArray[i]);
			assertTrue(boo);
			logger.info("Checked true : " + i + 1);
		}
		boolean contains = snippet.contains("has assigned the following training modules to you")
				|| snippet.contains("has assigned the following modules to you");
		assertTrue(contains);
	}

	@Then("I checked a user`s email and verified that the user got a notification about modules {string} and not contained already assigned {string} modules.")
	public void i_checked_a_user_s_email_and_verified_that_the_user_got_a_notification_about_modules_and_not_contained_already_assigned_modules(
			String string, String string2) {
		String[] myArray = string.split(", ");
		String[] myArray2 = string2.split(", ");
		String snippet = Myutilities.getSnippetFromEmailOfMultipleUser("New training has been assigned to you");
		logger.info(snippet);
		for (int i = 0; i < myArray.length; i++) {
			boolean boo = snippet.contains(myArray[i]);
			assertTrue(boo);
			logger.info("Checked true : " + i + 1);
		}
		// checking for not contain in the email
		for (int i = 0; i < myArray2.length; i++) {
			boolean boo2 = !snippet.contains(myArray2[i]);
			assertTrue(boo2);
			logger.info("not contain true : " + i + 1);
		}
		boolean contains = snippet.contains("has assigned the following training modules to you")
				|| snippet.contains("has assigned the following modules to you");
		assertTrue(contains);
	}

	@When("I selected the option `remove this program when it`s complete`.")
	public void i_selected_the_option_remove_this_program_when_it_s_complete() {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.selectRemoveProgramWhenCompleated();
	}

	@When("I clicked on the course {string} to play on the user homepage.")
	@When("I clicked on the module {string} to play on the user homepage.")
	public void i_clicked_on_the_course_to_play_on_the_user_homepage(String string) {
		if (homePage == null)
			homePage = new HomePage(driver);
		homePage.playModule(string);
		Myutilities.sleepFor(3000);
		if(!driver.findElements(By.id("btnContinue")).isEmpty()) {
			courseContentPage.clickContinueOnModule();
			logger.info("Continue butten seen.");
		}
	}
	@When("I clicked only on the module {string} to play on the user homepage.")
	public void i_clickedonly_on_the_course_to_play_on_the_user_homepage(String string) {
		if (homePage == null)
			homePage = new HomePage(driver);
		homePage.playModule(string);
		Myutilities.sleepFor(3000);		
	}
	@Then("I clicked on the module {string} on the home page of the user.")
	@Then("I clicked on the module {string} on the user`s home page.")
	public void i_clicked_on_the_click_on_the_module_on_the_home_page_of_the_user(String string) {
		if (homePage == null)
			homePage = new HomePage(driver);
		homePage.clickOnTheModule(string);
	}

	@Then("I changed the frame.")
	public void i_changed_the_frame() {
		if (courseContentPage == null)
			courseContentPage = new CourseContentPage(driver);
		courseContentPage.goToNextIframe();
	}

	@When("I clicked on the continue button on the content if the content is currently in progress.")
	public void i_clicked_on_the_continue_button_on_the_module_if_it_appears_while_playing_the_module() {
		if(!driver.findElements(By.xpath("//*[@id=\"resumeContent\"]/p")).isEmpty()) {
			courseContentPage.clickContinueOnModule();
			logger.info("Continue butten seen2.");
		}
	}

	@When("I waited until the new frame seen.")
	public void i_waited_until_the_new_frame_seen() {
		int i=0;
		List <WebElement> eles=driver.findElements(By.tagName("iframe"));
		while(driver.findElements(By.tagName("iframe")).size()==0&&i<40){
			i++;
			eles=driver.findElements(By.tagName("iframe"));
			Myutilities.sleepFor(500);
		}
		logger.info("Waited "+i+" times for 500 ms for iframe.");
	}

	@Then("I come back to the default frame.")
	public void i_come_back_to_the_default_frame() {
		if (courseContentPage == null)
			courseContentPage = new CourseContentPage(driver);
		courseContentPage.backToDefaultIframe();
	}

	@When("I clicked on the blue button to continue on the page.")
	public void i_clicked_on_the_blue_button_to_continue_on_the_page() {
		if (courseContentPage == null)
			courseContentPage = new CourseContentPage(driver);
		List<WebElement> eles = driver.findElements(By.cssSelector("#courseName > p"));
		Myutilities.sleepUntilVisibleWebElements("//*[@id='courseName']/p", 500);

		courseContentPage.clickContinueBlueArrow();
	}

	@Then("I clicked on the right arrow on the module.")
	public void i_clicked_on_the_right_arrow_on_the_module() {
		courseContentPage.clickNextArrow();
	}
	@When("I clicked on the right arrow on the module till final test button arrive.")
	public void i_clicked_on_the_right_arrow_on_the_module_till_final_test_button_arrive() {
		courseContentPage.clickNextArrowUntilVisibleOfTestBtn();
	}
	@When("I clicked on the right arrow until right arrow seen on the content.")
	public void i_clicked_on_the_right_arrow_until_right_arrow_seen_on_the_content() {
		courseContentPage.clickNextArrowUntilVisible();
	}
	@Then("I clicked on the final test button on the page.")
	public void i_clicked_on_the_final_test_button_on_the_page() {
		courseContentPage.clickFinalTestBtn();
	}
	@Then("I clicked on the Take Final Test button on the PDF page.")
	public void i_clicked_on_the_take_final_test_button_on_the_pdf_page() {
		courseContentPage.clickTakeFinalTestBtnOnPDFModule();
	}

	@Then("I clicked exit in the running module window.")
	public void i_clicked_exit_in_the_playing_course_window() {
		if (courseContentPage == null)
			courseContentPage = new CourseContentPage(driver);
		logger.info(courseContentPage.getProgramTitle());
		courseContentPage.clikExitCourseWindow();
	}

	@When("I played the module and then I exited from the module.")
	public void i_played_the_module_and_then_i_exited_from_the_module() {
		if (courseContentPage == null)
			courseContentPage = new CourseContentPage(driver);
		courseContentPage.goToNextIframe();
		logger.info(courseContentPage.getProgramTitle());
		courseContentPage.scrowlTheCourseContainer();
		courseContentPage.clikExitCourseWindow();
		courseContentPage.backToDefaultIframe();
	}

	@When("I scrolled the playing module container to the bottom.")
	public void i_scrolled_the_playing_module_container_to_the_bottom() {
		if (courseContentPage == null)
			courseContentPage = new CourseContentPage(driver);
		courseContentPage.scrowlTheCourseContainer();
	}
	@When("I scrolled the playing PDF module container to the bottom.")
	public void i_scrolled_the_playing_pdf_module_container_to_the_bottom() {
		if (courseContentPage == null)
			courseContentPage = new CourseContentPage(driver);
		courseContentPage.scrowlThePDFCourseContainer();
	}

	@When("I hovered over the mouse on the program {string} on the user homepage.")
	public void i_hovered_over_the_mouse_on_the_program_on_the_user_homepage(String string) {
		if (homePage == null)
			homePage = new HomePage(driver);
		homePage.hoverOverOnProgram(string);
	}

	@Then("I saw a display message {string} on the user homepage.")
	public void i_saw_a_display_message_on_the_user_homepage(String string) {
		if (homePage == null)
			homePage = new HomePage(driver);
		String text = homePage.getTextOnMouseHoveroverProgram();
		logger.info("Mouse Hover text: " + text);
		logger.info("Arg: " + string);
		if (!text.contains(string)) {
			text = homePage.getTextOnMouseHoveroverProgram();
		}
		assertTrue(text.contains(string));
	}

	@Then("I verified that the Guide text warns does not contain {string} text.")
	public void i_verified_that_the_guide_text_warns_does_not_contain_text(String string) {
		if (homePage == null)
			homePage = new HomePage(driver);
		String text = homePage.getTextOnMouseHoveroverProgram();
		logger.info("Mouse Hover text: " + text);
		logger.info("Arg: " + string);
		
	}

	@Then("I verified that Guide text warn the user {string} dated {int} days from today.")
	public void i_verified_that_guide_text_warn_the_user_dated_days_from_today(String string, Integer int1) {
		if (homePage == null)
			homePage = new HomePage(driver);
		String text = homePage.getTextOnMouseHoveroverProgram();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime futureDate = LocalDateTime.now().plusDays(int1);
		if (!text.contains(string + dtf.format(futureDate))) {
			text = homePage.getTextOnMouseHoveroverProgram();
		}
		logger.info("Mouse Hover text: " + text);
		logger.info("Arg: " + string + dtf.format(futureDate));
	}

	@When("I selected the program available immediately option.")
	public void i_selected_the_program_available_immediately_option() {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.selectProgramAvailableImmediately();
	}

	@When("I selected the program available as of the {string} option.")
	public void i_selected_the_program_available_as_of_the_option(String string) {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.programStartDateAsOf(string);
		Myutilities.sleepFor(500);
	}

	// The function only for disappearing small window created above function.
	@Then("I click on the program detail heading for the date window to disappear.")
	public void i_click_on_the_program_detail_heading_for_the_date_window_to_disappear() {
		driver.findElement(By.xpath("//*[@id='programDetails']/div[1]")).click();
	}

	@When("I selected the program available {string} days after the assignment.")
	public void i_selected_the_program_available_days_after_assignment(String days) {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.programStartDayAfter(days);
	}

	@When("I chose the program needs to completed within {int} days.")
	@When("I set the program needs to completed within {int} days.")
	public void i_chose_the_program_needs_to_completed_within_days(Integer int1) {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.SetDeadlineDays(int1);
	}

	@Then("I verified that the display guide of the {string} program showed {int} days.")
	public void i_verified_that_the_display_guide_of_the_program_showed_days(String string, Integer int1) {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		String msg = "";

		int i = 0;
		while (!msg.contains(int1 + " days") && i < 10) {
			Myutilities.sleepFor(500);
			msg = programsPage.getDeadlineMsg(string);			
			i++;

		}
		logger.info("deadline msg: " + msg);
		assertTrue(msg.contains(int1 + " days"));
	}

	@Then("I verified that the display guide of the {string} program showed {string} days.")
	@Then("I verified that the display guide of the {string} program showed {string} days after today`s date.")
	@Then("I verified that the display guide of the {string} module showed {string} \\(days).")
	public void i_verified_that_the_display_guide_of_the_program_showed_days(String string, String string2) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime tomorrowDate = LocalDateTime.now().plusDays(1);
		String date = "";
		if (string2.contains("tomorrow")) {
			date = dtf.format(tomorrowDate);
		} else if (Myutilities.isNumeric(string2)) {
			LocalDateTime futureDate = LocalDateTime.now().plusDays(Integer.parseInt(string2));
			logger.info("Future Date: " + dtf.format(futureDate));
			date = dtf.format(futureDate);
		} else {
			date = string2;
		}

		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		String msg = "";

		int i = 0;
		while (!msg.contains(date) && i < 10) {
			try {
				Thread.sleep(250);
				msg = programsPage.getDeadlineMsg(string);
			} catch (Exception e) {
				e.printStackTrace();
				Myutilities.sleepFor(1000);
				msg = programsPage.getDeadlineMsg(string);
			}
			i++;
		}
		logger.info("deadline msg: " + msg);
		logger.info("Arg Date: " + date);
		assertTrue(msg.contains(date));
	}

	@Then("I verified that when hovered over the mouse on the deadline link of the {string} the display message warns users with the message `The deadline for this program is {int} days.'")
	public void i_verified_that_when_hovered_over_the_mouse_on_the_deadline_link_of_the_the_display_message_warns_users_with_the_message_the_deadline_for_this_program_is_days(
			String string, Integer int1) {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		String msg = programsPage.getMsgOnDeadlineHoverOver(string);
		logger.info("deadline hover over msg: " + msg);

		assertTrue(msg.contains("The deadline for this program is " + int1 + " days."));
	}

	@Then("I verified that when hovered over the mouse on the deadline link of the {string} the display message warns {string}.")
	public void i_verified_that_when_hovered_over_the_mouse_on_the_deadline_link_of_the_the_display_message_warns(
			String string, String string2) {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		String msg = programsPage.getMsgOnDeadlineHoverOver(string);
		logger.info("Arg: " + string2);
		logger.info("App: " + msg);
		assertTrue(msg.contains(string2));
	}

	@Then("I select or unselect a module {string} module to add or remove module from the program.")
	public void i_select_or_unselect_a_module_module_to_add_or_remove_module_from_the_program(String string) {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.selectOrUnselectModuleToAssignInTheProgram(string);
	}

	@Then("I select a module {string} module to add in the program.")
	@Then("I selected a module {string} module to add in the program.")
	@Then("I select a module {string} to add in the program.")
	public void i_select_a_module_module_to_add_in_the_program(String string) {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.selectModuleToAssignInTheProgram(string);
	}

	@Then("I unselected a module {string} to remove.")
	@Then("I unselected a module {string} to remove from the program.")
	public void i_unselect_a_module_module_to_remove_from_the_program(String string) {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		programsPage.unSelectModuleToUnAssignInTheProgram(string);
	}

	@When("I set the program needs to completed by the end of {string}.")
	@When("I set the program needs to be completed by the end of after {string} days from today`s date.")
	public void i_set_the_program_needs_to_completed_by_the_end_of(String string) {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.SetdeadlineDateToProgram(string);
	}

	@When("I selected Remove this program when the deadline passes checkbox.")
	public void i_selected_remove_this_program_when_the_deadline_passes_checkbox() {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.removeProgramWhenDeadlinePassCB();

	}

	@When("I set the program needs to completed with no specific deadline.")
	public void i_set_the_program_needs_to_completed_with_no_specific_deadline() {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.selectNoSpecificDeadlineRB();
	}

	@Then("I verified that the status of the module {string} in the user profile is {string}.")
	public void i_verified_that_the_status_of_the_module_in_the_user_profile_is(String moduleName, String string2) {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.scrowlTheContainer();
		if (userProfilePage == null)
			userProfilePage = new UserProfilePage(driver);
		String status = userProfilePage.getStatusOfModule(moduleName);

		logger.info("Arg: " + string2);
		logger.info("Status: " + status);
	}

	@Then("I verified that the status of module {string} is {string} on the user homepage.")
	@Then("I verified that the module {string} on {string} on the user homepage.")
	public void i_verified_that_the_status_of_module_is_on_the_user_homepage(String moduleName, String string2) {
		if (homePage == null)
			homePage = new HomePage(driver);
		String txt = homePage.getStatusOfModule(moduleName);
		logger.info("text " + txt);
		logger.info("Arg : " + string2);
		assertTrue(txt.equalsIgnoreCase(string2));
	}

	@Then("I verified that none of the modules {string} present on the user homepage.")
	public void i_verified_that_none_of_the_modules_present_on_the_user_homepage(String string) {
		if (homePage == null)
			homePage = new HomePage(driver);
		String modules[] = homePage.getAllAssignedModules();
		String[] myArray = string.split(", ");
		for (int i = 0; i < myArray.length; i++) {
			logger.info("Arg not present Module " + (i + 1) + " " + myArray[i]);
			assertTrue(!Arrays.asList(modules).contains(myArray[i]));
		}
	}

	@Then("I verified that only {int} modules assigned in the user`s dashboard.")
	public void i_verified_that_only_modules_assigned_in_the_user_s_dashboard(Integer int1) {
		if (homePage == null)
			homePage = new HomePage(driver);
		String modules[] = homePage.getAllAssignedModules();
		logger.info("Total modules: " + modules.length);
		logger.info("Arg: " + int1);
		assertTrue(modules.length == int1);

	}

	@Then("I verified that {int} programs appeared in the user`s dashboard.")
	public void i_verified_that_programs_appeared_in_the_user_s_dashboard(Integer int1) {
		if (homePage == null)
			homePage = new HomePage(driver);
		String programs[] = homePage.getAssignedProgram();
		logger.info("Total programs: " + programs.length);
		logger.info("Arg: " + int1);
		assertTrue(programs.length == int1);
	}

	@Then("I verified that programs {string} appeared in the user`s dashboard.")
	public void i_verified_that_programs_appeared_in_the_user_s_dashboard(String string) {
		if (homePage == null)
			homePage = new HomePage(driver);
		String programs[] = homePage.getAssignedProgram();
		logger.info("Total programs: " + programs.length);
		for (String mN : programs)
			logger.info("Program in user dashboard :" + mN);
		String[] myArray = string.split(", ");
		for (String prog : myArray)
			logger.info("Arg Program :" + prog);
		Boolean boo = Arrays.asList(programs).containsAll(Arrays.asList(myArray));
		logger.info("Program equal?: " + boo);
		assertTrue(boo);
	}

	@Then("I verified that programs {string} not present on the user`s dashboard.")
	public void i_verified_that_programs_not_present_on_the_user_s_dashboard(String string) {
		if (homePage == null)
			homePage = new HomePage(driver);
		String programs[] = homePage.getAssignedProgram();
		logger.info("Total programs: " + programs.length);
		for (String mN : programs)
			logger.info("Program in user dashboard :" + mN);
		logger.info("arg: " + string);
		assertTrue(!Arrays.asList(programs).contains(string));
	}

	@Then("I clicked on the `Shot Short Order or Show Modules`.")
	public void i_clicked_on_the_shot_short_order_or_show_modules() {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.clickShowShotOrderOrModules();
	}

	@Then("I verified that the modules {string} are sorted in order.")
	public void i_verified_that_the_modules_are_sorted_in_order(String string) {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		String[] modulesNames = programsPage.getOrderedModules();
		for (String mN : modulesNames)
			logger.info("App Module :" + mN);
		String[] myArray = string.split(", ");
		for (String modu : myArray)
			logger.info("Arg Module :" + modu);
		Boolean boo = (Arrays.equals(modulesNames, myArray));
		logger.info("Module equal?: " + boo);
		assertTrue(boo);
	}

	@Then("I verified that modules of the program {string} are correctly sorted in the user profile in the order like {string}.")
	public void i_verified_that_modules_of_the_program_are_correctly_sorted_in_the_user_profile_in_the_order_like(
			String string, String string2) {

		if (userProfilePage == null)
			userProfilePage = new UserProfilePage(driver);
		String[] modulesNames = userProfilePage.getModuleNames(string);

		List<String> list = new ArrayList<String>();

		for (String s : modulesNames) {
			if (s != null && s.length() > 0) {
				list.add(s);
			}
		}

		modulesNames = list.toArray(new String[list.size()]);
		for (String mN : modulesNames)
			logger.info("App Module :" + mN);
		String[] myArray = string2.split(", ");
		for (String modu : myArray)
			logger.info("Arg Module :" + modu);
		Boolean boo = (Arrays.equals(modulesNames, myArray));
		logger.info("Module equal?: " + boo);
		
	}

	@Then("I verified that the modules {string} present under the {string} on the user home page.")
	@Then("I verified that the modules {string} present under the program {string} on the user home page.")
	public void i_verified_that_the_modules_present_under_on_the_user_home_page(String string, String string2) {
		if (homePage == null)
			homePage = new HomePage(driver);
		String[] modulesNames = homePage.getProgramAssignedModules(string2);
		for (String mN : modulesNames)
			logger.info("App Module :" + mN);
		String[] myArray = string.split(", ");
		for (String modu : myArray)
			logger.info("Arg Module :" + modu);
		Boolean boo = Arrays.asList(modulesNames).containsAll(Arrays.asList(myArray));
		logger.info("Modules present ?: " + boo);
		assertTrue(boo);
	}

	@Then("I verified that modules of the program {string} are correctly sorted in the user dashboard in the order like {string}.")
	public void i_verified_that_modules_of_the_program_are_correctly_sorted_in_the_user_dashboard_in_the_order_like(
			String string, String string2) {
		if (homePage == null)
			homePage = new HomePage(driver);
		String[] modulesNames = homePage.getProgramAssignedModules(string);
		for (String mN : modulesNames)
			logger.info("App Module :" + mN);
		String[] myArray = string2.split(", ");
		for (String modu : myArray)
			logger.info("Arg Module :" + modu);
		Boolean boo = (Arrays.equals(modulesNames, myArray));
		logger.info("Module equal?: " + boo);
	}

	@Then("I clicked on the save Assignment button.")
	public void i_clicked_on_the_save_assignment_button() {
		if (userProfilePage == null)
			userProfilePage = new UserProfilePage(driver);
		userProfilePage.clickSaveAssignment();
	}

	@Then("I verified that the programs {string} are assigned to the user profile.")
	public void i_verified_that_the_programs_are_assigned_to_the_user_profile(String string) {
		if (userProfilePage == null)
			userProfilePage = new UserProfilePage(driver);
		String[] programNames = userProfilePage.getAllAssignedPrograms();
		int index = 0;
		for (String mN : programNames) {
			logger.info("Assigne Program " + ++index + " " + mN);
		}
		String[] myArray = string.split(", ");
		for (int i = 0; i < myArray.length; i++) {
			logger.info("Arg Program " + i + 1 + " " + myArray[i]);
		}
		Boolean boo = Arrays.asList(programNames).containsAll(Arrays.asList(myArray));
		logger.info("Program in profile and Arg matched " + boo);
		assertTrue(boo);
	}

	@Then("I verified that the program {string} is not present on the user profile.")
	public void i_verified_that_the_program_is_not_present_on_the_user_profile(String string) {
		if (userProfilePage == null)
			userProfilePage = new UserProfilePage(driver);
		String[] programNames = userProfilePage.getAllAssignedPrograms();

		logger.info("arg: " + string);
		assertTrue(!Arrays.asList(programNames).contains(string));
	}

	@Then("I verified that the modules {string} present in the user profile.")
	public void i_verified_that_the_modules_present_in_the_user_profile(String string) {
		if (userProfilePage == null)
			userProfilePage = new UserProfilePage(driver);
		String[] modulesNames = userProfilePage.getAllAssignedModules();
		int index = 0;
		for (String mN : modulesNames) {
			logger.info("Assigne Module " + ++index + " " + mN);
		}
		String[] myArray = string.split(", ");
		for (int i = 0; i < myArray.length; i++) {
			logger.info("Arg Module " + i + 1 + " " + myArray[i]);
		}
		Boolean boo = Arrays.asList(modulesNames).containsAll(Arrays.asList(myArray));
		logger.info("Module in profile and Arg matched " + boo);
		assertTrue(boo);
	}

	@Then("I verified that the module {string} not present under the program {string} in the user profile.")
	public void i_verified_that_the_module_not_present_under_the_program_in_the_user_profile(String string,
			String string2) {
		if (userProfilePage == null)
			userProfilePage = new UserProfilePage(driver);
		String[] modulesNames = userProfilePage.getModuleNames(string2);
		for (int i = 0; i < modulesNames.length; i++) {
			logger.info("Module in Program " + string2 + " " + modulesNames[i]);
		}
		Boolean boo = !Arrays.asList(modulesNames).contains(string);
		assertTrue(boo);
	}

	@Then("I verified that the modules {string} present in the user profile and {string} not present in the profile.")
	public void i_verified_that_the_modules_present_in_the_user_profile_and_not_present_in_the_profile(String string,
			String string2) {
		if (userProfilePage == null)
			userProfilePage = new UserProfilePage(driver);
		String[] modulesNames = userProfilePage.getAllAssignedModules();
		int index = 0;
		for (String mN : modulesNames) {
			logger.info("Assigne Module " + ++index + " " + mN);
		}
		String[] myArray = string.split(", ");
		for (int i = 0; i < myArray.length; i++) {
			logger.info("Arg present Module " + (i + 1) + " " + myArray[i]);
		}
		Boolean boo = Arrays.asList(modulesNames).containsAll(Arrays.asList(myArray));
		logger.info("Module in profile and Arg matched " + boo);
		assertTrue(boo);

		String[] myArray1 = string2.split(", ");
		for (int i = 0; i < myArray1.length; i++) {
			logger.info("Arg not present Module " + (i + 1) + " " + myArray1[i]);
			assertTrue(!Arrays.asList(modulesNames).contains(myArray1[i]));
		}
	}

	@When("I verified that the modules {string} not present in the user profile.")
	public void i_verified_that_the_modules_not_present_in_the_user_profile(String string) {
		if (userProfilePage == null)
			userProfilePage = new UserProfilePage(driver);
		String[] modulesNames = userProfilePage.getAllAssignedModules();
		for (String mN : modulesNames) {
			logger.info("Assigne Module " + mN);
		}
		logger.info("Arg " + string);
		assertTrue(!Arrays.asList(modulesNames).contains(string));
	}

	@Then("I verified that the user profile has only {int} assigned modules.")
	public void i_verified_that_the_user_profile_has_only_assigned_modules(Integer int1) {
		if (userProfilePage == null)
			userProfilePage = new UserProfilePage(driver);
		int noOfmodules = userProfilePage.getNoOfTotalAssignedModules();
		logger.info("Assigned modules in user profile: " + noOfmodules);
		logger.info("Arg: " + int1);
		assertTrue(int1.compareTo(noOfmodules) == 0);
	}

	@Then("I clicked on the Programs icon on the programs page.")
	public void i_clicked_on_the_programs_icon_on_the_programs_page() {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.clickOnPrograms();
	}

	@When("I hover over on the Programs in the Program page.")
	public void i_hover_over_on_the_programs_in_the_program_page() {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.mouseHoverOnPrograms();
	}

	@When("I clicked on the Add Programs icon.")
	public void i_clicked_on_the_add_programs_icon() {
		programsPage.clickAddPrograms();
	}

	@When("I clicked on Add French Name.")
	public void i_clicked_on_add_french_name() {
		if (programDetailsPage == null)
			programDetailsPage = new ProgramDetailsPage(driver);
		programDetailsPage.clickaddFrenchName();
	}

	@Then("I typed {string} as the new program name.")
	public void i_typed_as_the_new_program_name(String string) {
		if (programDetailsPage == null)
			programDetailsPage = new ProgramDetailsPage(driver);
		programDetailsPage.addProgramName(string);
	}

	@Then("I typed {string} as the new program french name.")
	public void i_typed_as_the_new_program_french_name(String string) {
		if (programDetailsPage == null)
			programDetailsPage = new ProgramDetailsPage(driver);
		programDetailsPage.addProgramFrenchName(string);
	}

	@Then("I selected the program type as {string}.")
	public void i_selected_the_program_type_as(String string) {
		programDetailsPage.selectProgramType(string);
	}

	@Then("I selected a user {string} for the assigned in the program.")
	public void i_selected_a_user_for_the_assigned_in_the_program(String string) {
		if (!driver.findElement(By.id(string)).getAttribute("class").contains("click-selected"))
			driver.findElement(By.id(string)).click();
	}

	@Then("I selected a place {string} for the assigned in the program.")
	public void i_selected_a_place_for_the_assigned_in_the_program(String string) {
		if (!driver.findElement(By.id(string)).getAttribute("class").contains("click-selected")) {
			driver.findElement(By.id(string)).click();
			logger.info("Place is selected.");
		}
	}

	@Then("I verified that the people {string} are assigned through the place.")
	public void i_verified_that_the_people_are_assigned_through_the_place(String string) {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		String[] myArray = string.split(", ");
		for (String usr : myArray)
			logger.info("Arg: " + usr);

		String[] peoples = programsPage.getAssignedPeopleUnderPlaceAssign();
		for (String person : peoples)
			logger.info("App: " + person);
		Boolean boo = Arrays.asList(peoples).containsAll(Arrays.asList(myArray));
		logger.info("Matched? :" + boo);
		
	}

	@Then("I verified that the people {string} assigned through places not appeared under the `Assign People` section under the `People Assigned` link.")
	public void i_verified_that_the_people_assigned_through_places_not_appeared_under_the_assign_people_section_under_the_people_assigned_link(
			String string) {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		String[] myArray = string.split(", ");

		String[] people = programsPage.getPeopleUnderAvailableToAssign();
		
		for (String str : myArray) {
			logger.info("Arg: " + str);
			Boolean boo = !Arrays.asList(people).contains(str);
			assertTrue(boo);
		}
	}

	@Then("I deleted the program {string} from the carrier.")
	public void i_deleted_the_program_from_the_carrier(String string) {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.deleteTheProgram(string);

	}

	@Then("I clicked on the delete button of the program {string} on the programs page.")
	public void i_clicked_on_the_delete_button_of_the_program_on_the_programs_page(String string) {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.clickOnDeleteProgram(string);

	}

	@Then("I clicked on the Cancel button on the delete program conform window.")
	public void i_clicked_on_the_cancel_button_on_the_delete_program_conform_window() {
		driver.findElement(By.className("btnCancel")).click();
	}

	@Then("I clicked on the delete button on the delete program conform window.")
	public void i_clicked_on_the_delete_button_on_the_delete_program_conform_window() {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.clickOnDeleteConform();
	}

	@Then("I verified that the program {string} present on the program page.")
	public void i_verified_that_the_program_present_on_the_program_page(String string) {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		String prog = programsPage.getProgramNameText(string);
		logger.info("arg: " + string);
		logger.info("app program Name : " + prog);
		assertTrue(prog.equalsIgnoreCase(string));
	}

	// this is user for verifying whether the program is in Required, Optional or
	// Reference program
	@Then("I verified that the program {string} found in the {string} section.")
	public void i_verified_that_the_program_found_in_the_section(String string, String string2) {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		String progType = programsPage.getProgramTypeOf(string);
		logger.info("arg: " + string2);
		logger.info("app program Type : " + progType);
		assertTrue(progType.equalsIgnoreCase(string2));
	}

	@When("I hovered over on the {string} program and verified that {int} buttons `delete and program order` present.")
	public void i_hovered_over_on_the_program_and_verified_that_buttons_delete_and_program_order_present(String string,
			Integer int1) {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.hoverOverOnProgram(string);
		List<WebElement> eles = driver.findElements(By.xpath("//h2[span[text()='" + string + "']]/span/a"));
		String[] buttons = new String[eles.size()];
		logger.info("array size: " + eles.size());
		for (int i = 0; i < eles.size(); i++) {
			buttons[i] = eles.get(i).getText();
			logger.info("Buttons: " + buttons[i]);
		}
		assertTrue(Arrays.asList(buttons).contains("Delete"));
		assertTrue(Arrays.asList(buttons).contains("Change Program Order"));
	}

	@Then("I confirmed that the program {string} is not present on the Show Programs page.")
	public void i_confirmed_that_the_program_is_not_present_on_the_show_programs_page(String string) {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.clickShowPrograms();
		int i = 0;
		while (driver.findElement(By.xpath("//*[@id='programs']/div/div[2]/div[1]/section/h2"))
				.getText() == "Required Programs" && i < 6) {
			Myutilities.sleepFor(500);
			logger.info("500 ms wait");
			i++;
		}

		Boolean boo = false;
		String[] programs = programsPage.getProgramNames();
		logger.info("arg: " + string);
		for (String pro : programs) {
			if (pro.equalsIgnoreCase(string)) {
				boo = true;
				logger.info("pro: " + pro);
			}
			logger.info("final boolean value: " + boo);
			logger.info("pro: " + pro);
		}
		assertTrue(!boo);

	}
	@When("I clicked on the Show Modules icon on the People page.")
	public void i_clicked_on_the_show_modules_icon_on_the_people_page() {
		if (showModulesPage == null)
			showModulesPage = new ShowModulesPage(driver);
		showModulesPage.clickShowModules();
	}

	@When("I clicked on the Show Events icon on the People page.")
	public void i_clicked_on_the_show_events_icon_on_the_people_page() {
		if (showEventsPage == null)
			showEventsPage = new ShowEventsPage(driver);
		showEventsPage.clickShowEvents();

	}

	@Then("I verified that the modules {string} that were in the program have not been deleted.")
	public void i_verified_that_the_modules_that_were_in_the_program_have_not_been_deleted(String string) {
		if (showModulesPage == null)
			showModulesPage = new ShowModulesPage(driver);
		String[] modules = showModulesPage.getAllModulesName();
		String[] myArray = string.split(", ");
		for (String usr : myArray)
			logger.info("arg: " + usr);
		Boolean boo = Arrays.asList(modules).containsAll(Arrays.asList(myArray));
		logger.info("module contain ? :" + boo);
		assertTrue(boo);
	}

	@Then("I verified that the module {string} not present on the Show Module Page.")
	public void i_verified_that_the_module_not_present_on_the_show_module_page(String string) {
		if (showModulesPage == null)
			showModulesPage = new ShowModulesPage(driver);
		String[] modules = showModulesPage.getAllModulesName();
		Boolean boo = !Arrays.asList(modules).contains(string);
		logger.info("boo "+boo);
		assertTrue(boo);
	}

	@When("I clicked on the `x people assigned` of the module {string} module which id is {string}.")
	public void i_clicked_on_the_x_people_assigned_of_the_module_module_which_id_is(String string, String string2) {
		if (showModulesPage == null)
			showModulesPage = new ShowModulesPage(driver);
		showModulesPage.clickOnXPeopleAssiged(string2);
	}

	@When("I hovered Over on the `x people assigned` of the module {string} module which id is {string}.")
	public void i_hovered_over_on_the_x_people_assigned_of_the_module_module_which_id_is(String string,
			String string2) {
		if (showModulesPage == null)
			showModulesPage = new ShowModulesPage(driver);
		showModulesPage.hoverOverOnXPeopleAssiged(string2);
	}

	@Then("I verified that the guide text presents {string} when I hovered over on x people assigned on the shows module page.")
	@Then("I verified that the guide text presents {string} when I hovered over on x people assigned on a module in the shows module page.")
	public void i_verified_that_the_guide_text_presents_when_i_hovered_over_on_x_people_assigned_on_the_shows_module_page(
			String string) {
		
		String[] guideTexts = showModulesPage.getXPeopleAssignedHoveredData();
		for (String s : guideTexts) {
			logger.info("info : " + s);
		}
		String[] myArray = string.split(", ");
		for (String txt : myArray)
			logger.info("arg: " + txt);
		Boolean boo = Arrays.asList(guideTexts).containsAll(Arrays.asList(myArray));
		assertTrue(boo);
	}

	@Then("I verified that the guide text not presents {string} when I hovered over on x people assigned on a module in the shows module page.")
	@Then("I verified that the guide text not presents {string} when I hovered over on x people assigned on a module.")
	public void i_verified_that_the_guide_text_not_presents_when_i_hovered_over_on_x_people_assigned_on_a_module_in_the_shows_module_page(
			String string) {
		for (String s : showModulesPage.getXPeopleAssignedHoveredData()) {
			logger.info("info : " + s);
			s.contains(string);
		}
		assertTrue(!Arrays.asList(showModulesPage.getXPeopleAssignedHoveredData()).contains(string));
	}

	@When("I verified that {int} people assigned to the {string} module which id is {string} on the Show Modules page.")
	public void i_verified_that_people_assigned_to_the_module_which_id_is_on_the_show_modules_page(Integer int1,
			String string, String string2) {
		if (showModulesPage == null)
			showModulesPage = new ShowModulesPage(driver);
		Integer no = -1;
		int i = 0;
		while ((no.compareTo(int1)) != 0 && i < 8) {

			try {
				no = showModulesPage.getNoOfAssignedPeopleToModule(string2);
				Thread.sleep(500);
				logger.info("500ms waited");
			} catch (Exception e) {
				Myutilities.sleepFor(500);
				no = showModulesPage.getNoOfAssignedPeopleToModule(string2);
				logger.info("waited 500 ms");
			}
			i++;
		}
		logger.info("Assigned people: " + no);
		logger.info("From Arg: " + int1);
		logger.info(no.compareTo(int1));
		assertTrue((int1.compareTo(no)) == 0);
	}

	@When("I clicked on `x people assigned` to module {string} module which id is {string}.")
	public void i_clicked_on_x_people_assigned_to_module_module_which_id_is(String string, String string2) {
		if (showModulesPage == null)
			showModulesPage = new ShowModulesPage(driver);
		showModulesPage.clickOnXPeopleAssiged(string2);
	}

	@When("I clicked on `x people assign` to module {string} module which id is {string}.")
	public void i_clicked_on_x_people_assign_to_module_module_which_id_is(String strings, String string21) {
		if (showModulesPage == null)
			showModulesPage = new ShowModulesPage(driver);
		showModulesPage.clickOnXPeopleAssign(string21);
	}

	@Then("I search programs` names start with Temp and delete them.")
	public void i_search_programs_names_start_with_temp_and_delete_them() {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.searchTempProgramAndDelete();
	}

	@Then("I clicked on the Email icon on the user profile.")
	public void i_clicked_on_the_email_icon_on_the_user_profile() {
		if (userProfilePage == null)
			userProfilePage = new UserProfilePage(driver);
		userProfilePage.clickEmailIconInProfile();
	}

	@Then("I verified that programs should be separated into {int} categories on the Add To Program tab.")
	public void i_verified_that_programs_should_be_separated_into_categories_in_the_add_to_program_tab(Integer int1) {
		List<WebElement> eles = driver.findElements(By.xpath("(//div[@class='moduleGroup'])"));
		String[] progCatagories = new String[3];
		int index = 0;
		String[] checkProgram = { "Required Programs", "Optional Programs", "Reference Programs" };
		for (WebElement ele : eles) {
			progCatagories[index] = ele.getText();
			logger.info("ProgramcCatagories: " + ele.getText());
			index++;
		}
		Boolean boo = Arrays.asList(progCatagories).containsAll(Arrays.asList(checkProgram));
		logger.info("boolean check " + boo);
		assertTrue(boo);
	}

	@Then("I selected the program {string} which id {string} from the Add To Program tab.")
	@Then("I selected or unselected the program {string} which id {string} from the Add To Program tab.")
	public void i_selected_the_program_which_id_from_the_add_to_program_tab(String string, String string2) {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.clickElementbyId(string2);
	}

	@Then("I unselected {string} if it is already selected which id {string} from the Add To Program tab.")
	@Then("I unselected {string} if it is already selected which id {string} from the page.")
	public void i_unselected_if_it_is_already_selected_which_id_from_the_add_to_program_tab(String string,
			String string2) {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.unselectSelectedElementById(string2);
	}

	@Then("I selected {string} if it is not already selected which id is {string} from the page.")
	public void i_selected_if_it_is_not_already_selected_which_id_from_the_add_to_program_tab(String string,
			String string2) {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		programsPage.selectUnselectedElementById(string2);

	}

	@Then("I verified that only {int} elements were selected.")
	public void i_verified_that_only_elements_were_selected(Integer int1) {
		int selectedSize = driver.findElements(By.xpath("//div[contains(@class,'click-selected')]")).size();
		logger.info("App size: " + selectedSize);
		logger.info("Arg size: " + int1);
		assertTrue(selectedSize == int1);

	}

	@Then("I verified that the modules {string} not present under the program {string} on the user home page.")
	public void i_verified_that_the_modules_not_present_under_the_program_on_the_user_home_page(String string,
			String string2) {
		if (homePage == null)
			homePage = new HomePage(driver);

		String[] modulesNames = homePage.getProgramAssignedModules(string2);
		for (int i = 0; i < modulesNames.length; i++) {
			logger.info("Module in Program " + string2 + " " + modulesNames[i]);
		}
		Boolean boo = !Arrays.asList(modulesNames).contains(string);
		assertTrue(boo);
	}

	@When("I opened the past calendar of  {string} year {string}  month on the Show Event Page.")
	public void i_opened_the_past_calendar_of_year_month_on_the_show_event_page(String string, String string2) {
		if (showEventsPage == null)
			showEventsPage = new ShowEventsPage(driver);
		showEventsPage.clickPastEventCalenderOf(string2, string);
	}

	@Then("I clicked on the {string} event on the Show Event Page.")
	public void i_clicked_on_the_event_on_the_show_event_page(String string) {
		if (showEventsPage == null)
			showEventsPage = new ShowEventsPage(driver);
		showEventsPage.clickEvent(string);
	}

	@Then("I clicked on changed Assigned people on Event Details.")
	public void i_clicked_on_changed_assigned_people_on_event_details() {
		if (showEventsPage == null)
			showEventsPage = new ShowEventsPage(driver);
		showEventsPage.clickChangeAssignedPeople();

	}

	@Then("I verified that the Status of username {string} on the Event Details is marked as {string}.")
	public void i_verified_that_the_status_of_username_on_the_event_details_is_marked_as(String string,
			String string2) {
		String status = showEventsPage.getStatusOf(string);
		logger.info("App status: " + status);
		assertTrue(status.equalsIgnoreCase(string2));// check it and conform when error arrives
	}

	// module Deadline windows Definitions
	@When("I selected the option, This survey should be treated as public.")
	public void i_selected_the_option_this_survey_should_be_treated_as_public() {
		if (showModulesPage == null)
			showModulesPage = new ShowModulesPage(driver);
		showModulesPage.selectsurveyAsPublic();
	}
	@When("I unselected the option, This survey should be treated as public.")
	public void i_unselected_the_option_this_survey_should_be_treated_as_public() {
		if (showModulesPage == null)
			showModulesPage = new ShowModulesPage(driver);
		showModulesPage.UnSelectSurveyAsPublic();;
	}
	@When("I selected the option, Automatically notify admins when compleate survey.")
	public void i_selected_the_option_automatically_notify_admins_when_compleate_survey() {
		if (showModulesPage == null)
			showModulesPage = new ShowModulesPage(driver);
		showModulesPage.selectServeyNotifyAdminCB();
	}
	@When("I selected the option, Automatically notify Regional Admins when compleate survey.")
	public void i_selected_the_option_automatically_notify_regional_admins_when_compleate_survey() {
		if (showModulesPage == null)
			showModulesPage = new ShowModulesPage(driver);
		showModulesPage.selectServeyNotifySubAdminCB();
	}

	@When("I selected the option, Automatically notify Managers when compleate survey.")
	public void i_selected_the_option_automatically_notify_managers_when_compleate_survey() {
		if (showModulesPage == null)
			showModulesPage = new ShowModulesPage(driver);
		showModulesPage.selectserveyNotifyManagerCB();
	}

	@When("I selected the option, This module doesn`t need to be retaken after a set period of time.")
	public void i_selected_the_option_this_module_doesn_t_need_to_be_retaken_after_a_set_period_of_time() {
		if (showModulesPage == null)
			showModulesPage = new ShowModulesPage(driver);
		showModulesPage.selectModuleNeedNotRetaken();
	}

	@Then("I selected the option, This module needs to be retaken every {int} {string}. Notify people {int} days before this module expires.")
	public void i_selected_the_option_this_module_needs_to_be_retaken_every_notify_people_days_before_this_module_expires(
			Integer int1, String string, Integer int2) {
		if (showModulesPage == null)
			showModulesPage = new ShowModulesPage(driver);
		showModulesPage.moduleNeedRetakOnEvery(int1, string, int2);
	}

	@When("I selected the option, This module can be taken an unlimited number of times.")
	public void i_selected_the_option_this_module_can_be_taken_an_unlimited_number_of_times() {
		if (showModulesPage == null)
			showModulesPage = new ShowModulesPage(driver);
		showModulesPage.selectModuleCanTakenUnlimitateTimes();
	}

	@When("I selected the option, The test in this module must be completed in the default amount of time Three hrs.")
	public void i_selected_the_option_the_test_in_this_module_must_be_completed_in_the_default_amount_of_time_three_hrs() {
		if (showModulesPage == null)
			showModulesPage = new ShowModulesPage(driver);
		showModulesPage.selectModuleCompleatedInDefaultTime();
	}

	@When("I clicked the option, Prevent users from advancing until all required links are clicked and sound is finished.")
	public void i_clicked_the_option_prevent_users_from_advancing_until_all_required_links_are_clicked_and_sound_is_finished() {
		if (showModulesPage == null)
			showModulesPage = new ShowModulesPage(driver);
		showModulesPage.selectPreventUserUntilSoundFinish();
	}

	@Then("I unselected the option, Prevent users from advancing until all required links are clicked and sound is finished.")
	public void i_unselected_the_option_prevent_users_from_advancing_until_all_required_links_are_clicked_and_sound_is_finished() {
		if (showModulesPage == null)
			showModulesPage = new ShowModulesPage(driver);
		showModulesPage.unselectPreventUserUntilSoundFinish();
	}

	@When("I clicked the option, Prevent users from advancing until all checkpoint questions are answered correctly.")
	public void i_clicked_the_option_prevent_users_from_advancing_until_all_checkpoint_questions_are_answered_correctly() {
		if (showModulesPage == null)
			showModulesPage = new ShowModulesPage(driver);
		showModulesPage.selectPreventUserUntilAnsweredCorrectly();
	}

	@Then("I unselected the option, Prevent users from advancing until all checkpoint questions are answered correctly.")
	public void i_unselected_the_option_prevent_users_from_advancing_until_all_checkpoint_questions_are_answered_correctly() {
		if (showModulesPage == null)
			showModulesPage = new ShowModulesPage(driver);
		showModulesPage.unSelectPreventUserUntilAnsweredCorrectly();
	}

	@When("I selected the option, This module has no associated compensation rate.")
	public void i_selected_the_option_this_module_has_no_associated_compensation_rate() {
		if (showModulesPage == null)
			showModulesPage = new ShowModulesPage(driver);
		showModulesPage.selectNoPayRate();
	}

	@When("I selected the option, This module can be assigned by Admins, Regional Admins, and Managers.")
	public void i_selected_the_option_this_module_can_be_assigned_by_admins_regional_admins_and_managers() {
		if (showModulesPage == null)
			showModulesPage = new ShowModulesPage(driver);
		showModulesPage.selectAssignControlByAllSupervisors();
	}
	@When("I selected the option, This module can only be assigned by Admins.")
	public void i_selected_the_option_this_module_can_only_be_assigned_by_admins() {
		if (showModulesPage == null)
			showModulesPage = new ShowModulesPage(driver);
		showModulesPage.selectAssignControlByAdmins();
	}

	@When("I selected the option, Require people to acknowledge completion of this module.")
	public void i_selected_the_option_require_people_to_acknowledge_completion_of_this_module() {
		if (showModulesPage == null)
			showModulesPage = new ShowModulesPage(driver);
		showModulesPage.selectAcknowledgeComptionCB();
	}
	@When("I unselected the option, Require people to acknowledge completion of this module.")
	public void i_unselected_the_option_require_people_to_acknowledge_completion_of_this_module() {
		if (showModulesPage == null)
			showModulesPage = new ShowModulesPage(driver);
		showModulesPage.unselectAcknowledgeComptionCB();
	}

	@Then("I verified that expiry options {string} are displayed on the module.")
	public void i_verified_that_expiry_options_are_displayed_on_the_module(String string) {
		if (showModulesPage == null)
			showModulesPage = new ShowModulesPage(driver);
		String[] allExpiryOptions = showModulesPage.getAllExpiryOptions();
		String[] myArray = string.split(", ");
		for (String txt : myArray)
			logger.info("arg: " + txt);
		Boolean boo = Arrays.asList(allExpiryOptions).containsAll(Arrays.asList(myArray));
		assertTrue(boo);
	}

	@When("I selected the option, The test in this module must be completed in {int} minutes.")
	public void i_selected_the_option_the_test_in_this_module_must_be_completed_in_minutes(Integer int1) {
		if (showModulesPage == null)
			showModulesPage = new ShowModulesPage(driver);
		showModulesPage.moduleCompleatedInTime(int1);
	}

	@When("I selected the option, This module has an associated compensation rate of $ {int}.")
	public void i_selected_the_option_this_module_has_an_associated_compensation_rate_of_$(Integer int1) {
		if (showModulesPage == null)
			showModulesPage = new ShowModulesPage(driver);
		showModulesPage.payRate(int1);
	}
	@When("I clicked on the billing icon.")
	public void i_clicked_on_the_billing_icon() {
		if (homePage == null)
			homePage = new HomePage(driver);
		homePage.clickBillingMainMenu();
	}
	@Then("I noted the Account Balance.")
	public void i_noted_the_account_balance() {
		String accbnc=driver.findElement(By.xpath("//div[@class='label'][contains(.,'Account Balance')]/../div[2]")).getText();
		accbnc=accbnc.replace("$", "");
		logger.info("Acc Balance: "+accbnc);		
		homePage.setAccountBalance(Double.valueOf(accbnc));
	}
	@Then("I verified that the additional charge of ${int} added to the balance.")
	public void i_verified_that_the_additional_charge_of_$_added_to_the_balance(Integer int1) {
		String accbnc=driver.findElement(By.xpath("//div[@class='label'][contains(.,'Account Balance')]/../div[2]")).getText();
		accbnc=accbnc.replace("$", "");
		if (homePage == null)
			homePage = new HomePage(driver);
		double oldAccBlnce = homePage.getAccountBalance();
		logger.info("old Balance: "+oldAccBlnce);
		logger.info("new Balance: "+accbnc);
		double newExpectedBlance=oldAccBlnce+int1;
		logger.info("expected Balance: "+newExpectedBlance);
		int result =Double.valueOf(accbnc).compareTo(newExpectedBlance);
		logger.info("Result: "+result);
	}

	@Then("I clicked on the start over on the module information window.")
	public void i_clicked_on_the_start_over_on_the_module_information_window() {
		if (homePage == null)
			homePage = new HomePage(driver);
		homePage.clickOnStartOverOnModuleInfo();
	}
	@When("I clicked on Test Take Again.")
	public void i_clicked_on_test_take_again() {
		if (homePage == null)
			homePage = new HomePage(driver);
		homePage.testTakeAgainInTest();
	}
	@When("I wrote the comments {string} on the Servey text box having the id {string}.")
	public void i_wrote_the_comment_on_the_servey_text_box_having_the_id(String string, String string2) {
		if (homePage == null)
			homePage = new HomePage(driver);
		homePage.writeComments(string2, string);
	}
	@Then("I verified that acknowledge checkbox appears at the end of the module.")
	public void i_verified_that_acknowledge_checkbox_appears_at_the_end_of_the_module() {
		if (courseContentPage == null)
			courseContentPage = new CourseContentPage(driver);
		Boolean boo=courseContentPage.checkModuleAcknowledgeCB();
		assertTrue(boo);
	}

}
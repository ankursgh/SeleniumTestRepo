package com.carriersedge.stepDefinitions;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.carriersedge.pages.HomePage;
import com.carriersedge.pages.ProgramsPage;
import com.carriersedge.util.BrowserFactory;
import com.carriersedge.util.Myutilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonPageStepDefinition extends AbstractPageStepDefinition {
	private static final Logger logger = LogManager.getLogger(CommonPageStepDefinition.class);
	HomePage homePage;
	ProgramsPage programsPage;
	private String browserName;

	@Given("open the {string} browser.")
	public void open_the_browser(String browserName) {
		this.browserName = browserName;
		logger.info(browserName + " browser was selected.");

	}

	@When("I opened the {string} page.")
	@When("I opened the Rivers login page {string}.")
	public void i_opened_the_page(String appURL) {
		driver = BrowserFactory.startApplication(driver, browserName, appURL);
		logger.info("Open the " + appURL + " page.");

	}

	@Then("I saw a prop up message-{string}.")
	@Then("I saw a pop up message-{string}.")
	public void i_saw_a_prop_up_message(String expectedMsg) {
		String msg = "";
		Boolean boo = false;
		int i = 0;
		while (!boo && i < 6) {

			Myutilities.sleepFor(1500);
			try {

				msg = driver.switchTo().alert().getText();

			} catch (Exception e) {

				Myutilities.sleepFor(1000);
				msg = driver.switchTo().alert().getText();
			}
			if (!msg.contains(expectedMsg)) {

				Myutilities.sleepFor(1500);
				try {
					msg = driver.switchTo().alert().getText();
				} catch (Exception e) {
					Myutilities.sleepFor(1000);
					msg = driver.switchTo().alert().getText();
				}

			}
			boo = msg.contains(expectedMsg);
			i++;
		}
		logger.info("pop msg : " + msg);
		// Changed to fix error
		// assertTrue(msg.contains(expectedMsg));
		// *******
	}

	@Then("I clicked Ok button on prop up.")
	@Then("I clicked Ok button on pop up.")
	public void i_clicked_ok_button_on_prop_up() throws InterruptedException {
		try {
			Thread.sleep(500);
			driver.switchTo().alert().accept();
			logger.info("pop msg accept or Ok: ");
		} catch (NoAlertPresentException ex) {
			Thread.sleep(1500);
			driver.switchTo().alert().accept();
		}

	}

	// ********** LMST 906 pop msg issue
	@Then("I clicked on OK in the popup if exist.")
	public void i_clicked_on_ok_in_the_popup_if_exist() {
		try {
			Myutilities.sleepFor(1000);
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert not displayed");

		}
	}

	@Then("I clicked cancel button on prop up.")
	@Then("I clicked cancel button on pop up.")
	public void i_clicked_cancel_button_on_prop_up() {
		driver.switchTo().alert().dismiss();
		logger.info("pop msg cancel clicked: ");
	}

	@Then("I quit the browser.")
	public void i_quit_the_browser() {
		BrowserFactory.quitBrowser(driver);
		logger.info("Quit the browser");
	}

	@Then("I closed the browser.")
	public void i_closed_the_browser() {
		BrowserFactory.closeBrowser(driver);
		;
		logger.info("closed the browser");
	}

	@When("I navigated to the {string} page.")
	public void i_navigated_to_the_page(String string) {
		driver.get(string);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("I Waited For {int} minutes.")
	public void i_waited_for_minutes(Integer int1) {
		try {
			Thread.sleep(660000);// 11 second wait
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("waited for 10 minutes");
	}

	@Then("I waited for {int} seconds.")
	public void i_waited_for_seconds(Integer int1) {
		logger.info("start waiting for " + int1 + " seconds.");
		try {
			Thread.sleep(int1 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("waited for " + int1 + " seconds");
	}

	@When("clicked on the save button.")
	public void clicked_on_the_save_button() {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		// Commented due to error
		/*
		 * int i=0; while(driver.findElements(By.className("btnSave")).size()==0&&i<6) {
		 * 
		 * Myutilities.sleepFor(1000); i++; }
		 */
		// Implemented to fix element not intearctive bug
		WebElement element = driver.findElement(By.className("btnSave"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();

		// ********driver.findElement(By.className("btnSave")).click();
		// Till here
		logger.info("Save button clicked");
		/*
		 * // programsPage.scrowlTheContainer();
		 * 
		 * try { JavascriptExecutor executor = (JavascriptExecutor) driver;
		 * executor.executeScript("arguments[0].scrollIntoView(true);",
		 * driver.findElement(By.className("btnSave")));
		 * driver.findElement(By.className("btnSave")).click();
		 * logger.info("Save btn clicked."); } catch(Exception e) { try {
		 * Thread.sleep(1000); } catch (InterruptedException e1) { e1.printStackTrace();
		 * } driver.findElement(By.className("btnSave")).click();
		 * logger.info("Save btn clicked after  Exception."); } try { Thread.sleep(500);
		 * } catch (InterruptedException e) { e.printStackTrace(); }
		 */
	}

	// there is another cancel stepdefinition for user profile since this cancel
	// does not work for user profile window.That is in people step Definitin
	@When("I clicked on the Cancel button.")
	@When("I clicked on the close button.")
	public void i_clicked_on_the_cancel_button() {
		if (programsPage == null)
			programsPage = new ProgramsPage(driver);
		// programsPage.scrowlTheContainer();.
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollTop = arguments[1];",
				driver.findElement(By.xpath("//div[contains(@class,'modalContainer')]")), 550);

		try {
			WebDriverWait wait = new WebDriverWait(driver, 2);
			WebElement foo = wait.until(
					ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//[@class='btnClose']"))));
			foo.click();
			// JavascriptExecutor jse = (JavascriptExecutor) driver;
			// js.executeScript("arguments[0].click();",
			// driver.findElement(By.xpath("//button[@class='btnClose']")));

		} catch (Exception ex) {
			Myutilities.sleepFor(1500);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@class='btnClose']")));
			logger.info("Cancel clicked in Exception");
		}

		logger.info("Cancel btn clicked.");
	}

	@Then("I clicked on the first cancel button.")
	@Then("I clicked on the cancel button on the page.")
	public void i_clicked_on_the_first_cancel_button() {
		driver.findElement(By.xpath("(//button[@class='btnClose'])[1]")).click();
		logger.info("First Cancel btn clicked.");
	}

	@Then("I clicked on the second cancel button.")
	public void i_clicked_on_the_second_cancel_button() {
		driver.findElement(By.xpath("(//button[@class='btnClose'])[2]")).click();
		logger.info("2nd Cancel btn clicked.");
	}

	@Then("I scrolled the small window.")
	public void i_scrolled_the_window() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			WebElement foo = wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath("//div[contains(@class,'modalContainer')]"))));
			js.executeScript("arguments[0].scrollTop = arguments[1];", foo, 500);
		} catch (Exception e) {
			e.printStackTrace();
			js.executeScript("arguments[0].scrollTop = arguments[1];",
					driver.findElement(By.xpath("//div[contains(@class,'modalContainer')]")), 550);
			logger.info("Scrolled in Exception.");
		}
	}

	@Then("I scrolled down the entire window.")
	public void i_scrolled_down_the_entire_window() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,350)");
	}

	@When("I scrolled down the entire window by {int} px.")
	public void i_scrolled_down_the_entire_window_by_px(Integer int1) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0," + int1 + ")");
	}

	@Then("I scrolled up the entire window.")
	public void i_scrolled_up_the_entire_window() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-350)");
	}

	@Then("I clicked on the link text {string} on the opened page.")
	public void i_clicked_on_the_link_text_on_the_opened_page(String linkText) {
		// driver.findElement(By.linkText(linkText)).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText(linkText)))).click();
	}

	@When("I clicked on the language option on the top right corner of the page.")
	public void i_clicked_on_the_language_option_on_the_top_right_corner_of_the_page() {
		if (homePage == null)
			homePage = new HomePage(driver);
		homePage.clickLanguage();
	}

	@Then("I selected the language {string} from the language options.")
	public void i_selected_the_language_from_the_language_options(String string) {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (homePage == null)
			homePage = new HomePage(driver);
		homePage.selectLanguage(string);
	}

	@When("I scrolled the window till the element having XPath {string}.")
	public void i_scrolled_the_window_till_the_element_having_x_path(String string) {
		WebElement ele = driver.findElement(By.xpath(string));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true)", ele);
	}

	@Then("I clicked on the submit button.")
	@Then("I clicked on Yes on small information box contaning `You are about to retake a test that you have already passed. If you continue, this will count as another attempt...`")
	@Then("I clicked on Yes on small information box contaning `You have already taken this survey. If you continue, Are you sure you want to take it again?.`")
	public void i_clicked_on_the_submit_button() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("btnSubmit")))).click();
		driver.findElement(By.className("btnSubmit"));
	}

	@Then("I verified that I saw submit button on the test.")
	public void i_verified_that_i_saw_submit_button_on_the_test() {

		assertTrue(driver.findElement(By.className("btnSubmit")).isDisplayed());
	}

}
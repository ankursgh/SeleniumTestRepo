package com.carriersedge.pages;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.carriersedge.util.BaseClass;

public class UserDetailsPage extends BaseClass {

	// public WebDriver driver;

	public UserDetailsPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logger.info("UserDetails Page initializes");

	}

	private static final Logger logger = LogManager.getLogger(UserDetailsPage.class);

	@FindBy(xpath = "//h1[contains(.,'User Details')]")
	WebElement userDetailsFormHeading;
	@FindBy(name = "username")
	WebElement usernameTB;
	@FindBy(name = "firstName")
	WebElement firstNameTB;
	@FindBy(name = "lastName")
	WebElement lastNameTB;
	@FindBy(xpath = "//button[contains(.,'Submit')]")
	WebElement submitBtn;
	@FindBy(xpath = "//button[contains(.,'Try Again')]")
	WebElement tryAgainBtn;
	@FindBy(id = "contactUsBtn")
	WebElement contactUsBtn;
	@FindBy(id = "cancelBtn")
	WebElement cancelBtn;

	public Boolean detailsHeadingCheck(String pageHeading) {
		String heading = userDetailsFormHeading.getText();
		logger.info("the heading is:" + heading);
		return heading.contains(pageHeading);
	}

	public void enterUserName(String userName) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(usernameTB));
		foo.sendKeys(userName);
		logger.info("Username entered: " + userName);
	}

	public void enterFirstName(String firstName) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(firstNameTB));
		foo.sendKeys(firstName);
		logger.info("Firstname entered: " + firstName);
	}

	public void enterLsatName(String lastName) {
		lastNameTB.sendKeys(lastName);
		logger.info("Lastname entered: " + lastName);
	}

	public void clickSubmitBtn() {
		submitBtn.click();
		logger.info("Submit Button was clicked.");
	}

	public void clickTryAgainBtn() {
		tryAgainBtn.click();
		logger.info("Try Again Button was clicked.");
	}

	public void clickContactUsBtn() {
		contactUsBtn.click();
		logger.info("Contact Us Button was clicked.");
	}

	public void sameEmailAddressSeveralAccountsMsg(String msgDisplay) {

		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		WebElement ele = driver.findElement(By.cssSelector("div#content > div > form > p"));

		String msg = ele.getText();
		logger.info("Page message: " + msg);
		assertTrue(msg.contains(msgDisplay));

	}

	public void userDetailMock_12MsgVerify(String msgDisplay) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		WebElement ele = driver.findElement(By.cssSelector("div#content > div > form > p:nth-of-type(2)"));
		String msg = ele.getText();
		logger.info("Page message: " + msg);
		assertTrue(userDetailsFormHeading.getText().contains("User Details"));
		logger.info("checked Head of the page is User Details.");
		assertTrue(msg.contains(msgDisplay));

	}

	public void clickCancelBtn() {
		cancelBtn.click();
		logger.info("Clicked Cancel Btn.");
	}

	public void messageExceededAttemptsMsgMockUp14(String msgDisplay) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		WebElement ele = driver.findElement(By.cssSelector("div#content > div > form > p:nth-of-type(2)"));
		String msg = ele.getText();
		logger.info("Page message: " + msg);
		logger.info("checked Head of the page is User Details.");
		assertTrue(msg.contains(msgDisplay));

	}

	public String[] getAssignedPrograms() {
		List<WebElement> eles = driver.findElements(By.xpath(" //*[@id=\"moduleAssign\"]//h2/span"));
		logger.info("array size: " + eles.size());
		String[] programs = new String[eles.size()];
		for (int i = 0; i < eles.size(); i++) {
			programs[i] = eles.get(i).getText();
		}
		return programs;
	}

}

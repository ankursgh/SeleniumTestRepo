package com.carriersedge.pages;

import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.carriersedge.util.BaseClass;

public class PasswordRecoveryPage extends BaseClass {

	// public WebDriver driver;

	public PasswordRecoveryPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logger.info("PasswordRecovery Page initializes");

	}

	private static final Logger logger = LogManager.getLogger(PasswordRecoveryPage.class);

	@FindBy(xpath = "//h1[contains(.,'Login / Password Recovery')]")
	WebElement passwordRecoveryFormHeading;
	// @FindBy(tagName ="h1") WebElement passwordRecoveryFormHeading;
	// @FindBy(xpath = "//*[@id=\"content\"]/div[1]/form/h1")

	@FindBy(name = "usernameAndEmail")
	WebElement usernameAndEmailTB;
	@FindBy(className = "btnLogin")
	WebElement submitButton;
	@FindBy(css = "div#content > div > form > p")
	WebElement passwordChangeUsername;

	@FindBy(xpath = "(//img[@src='../images/icn-check.svg'])[1]")
	WebElement passwordCheckImage1;
	@FindBy(xpath = "(//img[@src='../images/icn-check.svg'])[2]")
	WebElement passwordCheckImage2;
	@FindBy(xpath = "//button[contains(.,'Change')]")
	WebElement changeBtn;
	@FindBy(name = "password")
	WebElement newPasswordTB;
	@FindBy(name = "password2")
	WebElement confirmPasswordTB;
	@FindBy(css = "div#content > div > form > p")
	WebElement passwordChangeConfirmationMsg;
	@FindBy(id = "redirectBtn")
	WebElement OKBtnconformPasswordMsg;

	public void checkPasswordRecoveryPage() {
		// passwordRecoveryFormHeading.getText().contains("passwordRecoveryFormHeading");
		String formHeading = passwordRecoveryFormHeading.getAttribute("innerHTML");

		assertTrue(formHeading.contains("Login / Password Recovery"));
		logger.info("Password Recovery heading: " + formHeading);

	}

	public void enterUsernameOrEmail(String usernameOrEmail) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(usernameAndEmailTB));
		foo.sendKeys(usernameOrEmail);

	}

	public void submitRecoveryRequest() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
		foo.click();
	}

	public void passwordChangeUserNameConfirmation(String userName) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		String msg = passwordChangeUsername.getText();
		logger.info("Page message: " + msg);
		assertTrue(msg.contains(userName));
	}

	public void checkConformationPasswordMatch() {

		logger.info("passwordCheckImage1 was displayed. " + passwordCheckImage1.isDisplayed());

		logger.info("passwordCheckImage2 was displayed. " + passwordCheckImage2.isDisplayed());
		assertTrue(passwordCheckImage1.isDisplayed() && passwordCheckImage2.isDisplayed());
	}

	public void enterNewPassword(String newPassword) {
		// newPasswordTB.clear();//the clear is not working
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(newPasswordTB));
		foo.sendKeys(Keys.BACK_SPACE);
		foo.sendKeys(Keys.BACK_SPACE);
		foo.sendKeys(Keys.BACK_SPACE);
		foo.sendKeys(newPassword);
		logger.info("new password was entered");
	}

	public void enterConfirmNewPassword(String confirmPassword) {
		confirmPasswordTB.sendKeys(confirmPassword);
		logger.info("confirm Password was entered");
	}

	public void clickChangeBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(ExpectedConditions.elementToBeClickable(changeBtn));
		foo.click();
	}

	public void checkMsgPasswordScccessChange(String msgDisplay) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		String msg = passwordChangeConfirmationMsg.getText();
		logger.info("Page message: " + msg);
		assertTrue(msg.contains(msgDisplay));

	}

	public void clickOkInPasswardSuccessfullyMsg() {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(ExpectedConditions.elementToBeClickable(OKBtnconformPasswordMsg));
		foo.click();

	}

}

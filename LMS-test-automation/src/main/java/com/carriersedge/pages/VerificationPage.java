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

public class VerificationPage extends BaseClass {

	public VerificationPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logger.info("Verification Page initializes");

	}

	// public WebDriver driver;
	private static final Logger logger = LogManager.getLogger(VerificationPage.class);

	@FindBy(id = "resendVerificationBtn")
	WebElement resendVerificationBtn;
	@FindBy(id = "content")
	WebElement verificationCodeRecendconfirmationMsg;
	// *[@id="content"]/div[1]/form/p[2]
	@FindBy(name = "verificationCode")
	WebElement verificationCodeTB;
	@FindBy(xpath = "//button[contains(.,'Submit')]")
	WebElement submitBtn;
	@FindBy(id = "redirectBtn")
	WebElement okredirectBtn;

	@FindBy(xpath = "//h1[contains(.,'Reset Password')]")
	WebElement resetPasswordHeading;
	@FindBy(name = "password")
	WebElement newPasswordTB;
	@FindBy(name = "password2")
	WebElement conformNewPasswordTB;
	@FindBy(xpath = "//button[contains(.,'Change')]")
	WebElement changebtn;
	// @FindBy(xpath = "//*[@id=\"content\"]/div[1]/form[1]/p[1]") WebElement
	// passwordNoPermissionResetMsg;
	@FindBy(xpath = "//p[contains(.,'This email account is tied to multiple accounts. Some of these accounts have company settings which prevent password changes, so password reset may not be available.')]")
	WebElement passwordNoPermissionResetMsg;

	// this is also 24 hours lockout msg WeElement as well.
	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/form/p[2]")
	WebElement tryAgainIn10MinBlockMsg;

	public void clickResendVerification() {
		resendVerificationBtn.click();
		logger.info("resend verification was clicked.");
	}

	public Boolean isVerificationCodeSend() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		String verMsg = verificationCodeRecendconfirmationMsg.getText();
		logger.info("msg: " + verMsg);
		return verMsg.contains("An email with verification code has been sent");
	}

	public void checkMaskedEmailDisplay(String maskedEmail) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		String verMsg = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/form[1]/p[1]")).getText();
		// verificationCodeRecendconfirmationMsg.getText();
		logger.info("msg: " + verMsg);
		assertTrue(verMsg.contains(maskedEmail));

	}

	public Boolean verifyCodeResendconfirmation() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		String verMsg = verificationCodeRecendconfirmationMsg.getText();
		logger.info("msg: " + verMsg);
		return verMsg.contains("A new verification code has been generated and sent");
	}

	public void enterVerificationCode(String verCode) {
		for (int i = 0; i < 9; i++) {
			verificationCodeTB.sendKeys(Keys.BACK_SPACE);
		}
		logger.info("verification code: " + verCode + " is written.");
		verificationCodeTB.sendKeys(verCode);
	}

	public void clickSubmitBtn() {
		submitBtn.click();
		logger.info("submit btn clicked.");
	}

	public void clickOkredirectBtn() {
		okredirectBtn.click();
		logger.info("ok redirect Btn clicked- Ok.");
	}

	public Boolean checkPasswordResetPage() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(resetPasswordHeading));
		String passResetHead = foo.getText();
		logger.info("The heading is : " + passResetHead);
		return passResetHead.contains("Reset Password");

	}

	public void enterNewPassword(String password) {
		newPasswordTB.sendKeys(password);
		logger.info("New password was entered");
	}

	public void enterConformNewPassword(String password) {
		newPasswordTB.sendKeys(password);
		logger.info("Conformed New password was entered");
	}

	public void clickChangeBtn() {
		changebtn.click();
		logger.info("changed button was clicked.");
	}

	public void checkPasswardNoPermissionResetMsg(String message) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo = wait.until(ExpectedConditions.elementToBeClickable(passwordNoPermissionResetMsg));
		String msg = foo.getText();
		logger.info("No permissin msg :" + msg);
		assertTrue(msg.contains(message));
	}

	public void checkTryAgainIn10MinBlockMsg(String message) {
		// Mockup_22
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(tryAgainIn10MinBlockMsg));
		String msg = foo.getText();
		logger.info("No permissin for certain time ;" + msg);
		assertTrue(msg.contains(message));
	}

	public void checkErrorAfterLockout(String message) {
		WebElement ele = driver.findElement(By.xpath("//p[contains(.,'Sorry but there was an error.')]"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(ele));
		String msg = foo.getText();
		logger.info("After Blockout msg :" + msg);
		assertTrue(msg.contains(message));
	}

}

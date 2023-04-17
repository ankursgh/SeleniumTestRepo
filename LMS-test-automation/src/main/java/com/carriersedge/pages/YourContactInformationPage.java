package com.carriersedge.pages;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.carriersedge.util.BaseClass;

public class YourContactInformationPage extends BaseClass {

	// public WebDriver driver;

	public YourContactInformationPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logger.info("YourContactInformation Page initializes");

	}

	private static final Logger logger = LogManager.getLogger(YourContactInformationPage.class);

	@FindBy(xpath = "//h1[contains(.,'Your Contact Information')]")
	WebElement yourContactInformationFormHeading;
	@FindBy(name = "company")
	WebElement companyNameTB;
	@FindBy(name = "name")
	WebElement fullNameTB;
	@FindBy(id = "email")
	WebElement emailTB;
	@FindBy(id = "phone")
	WebElement phoneTB;
	@FindBy(id = "cancelBtn")
	WebElement cancelBtn;
	@FindBy(xpath = "//button[contains(.,'Send')]")
	WebElement sendBtn;
	@FindBy(xpath = "//p[contains(.,'The request has been successfully sent to the Support team')]")
	WebElement sendReqConformMsg;
	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/form/p")
	WebElement doNotHavePermissionMsg;

	// @FindBy(css = "div#content > div > form > p:nth-of-type(2)") WebElement
	// accfoundButNotEmailMsg;

	public void enterCompanyName(String companyName) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(companyNameTB));
		foo.sendKeys(companyName);
		logger.info("company Name entered: " + companyName);
	}

	public void enterfullName(String fullName) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(fullNameTB));
		foo.sendKeys(fullName);
		logger.info("Full name entered: " + fullName);
	}

	public void enterEmail(String email) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(emailTB));
		foo.sendKeys(email);
		logger.info("Email entered: " + email);
	}

	public void enterPhoneNumber(String phoneNumber) {
		phoneTB.sendKeys(phoneNumber);
		logger.info("Email entered: " + phoneNumber);
	}

	public void clickCancelBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(cancelBtn));
		foo.click();
		logger.info("cancel Button was clicked");
	}

	public void clickSendBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(sendBtn));
		foo.click();
		logger.info("Send Button was clicked");
	}

	public Boolean sendReqConformMsgCheck(String displayMsg) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(sendReqConformMsg));
		String msg = foo.getText();
		logger.info("Display msg: " + msg);
		return msg.contains(displayMsg);

	}

	public void doNotHavePermissionMsg(String displayMsg) {
		// looking for "You don't have permission to reset the password. Please contact
		// your manager".
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(doNotHavePermissionMsg));
		String msg = foo.getText();
		logger.info("Not permission msg: " + msg);
		assertTrue(msg.contains(displayMsg));

	}

	public void accntfoundButNotEmailMsg(String msgDisplay) {
		// looking for "We've found your account, but there's no email address
		// associated with it, so we can't mail you the login details. However, our
		// Support team will be happy to contact you and resolve the issue.".
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		WebElement ele = driver.findElement(By.cssSelector("div#content > div > form > p:nth-of-type(2)"));

		String msg = ele.getText();
		logger.info("page message: " + msg);
		assertTrue(msg.contains(msgDisplay));

	}

	public void emailAddressAccountNotFoundMsg(String msgDisplay) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		WebElement ele = driver.findElement(By.cssSelector("div#content > div > form > p:nth-of-type(2)"));
		String msg = ele.getText();
		logger.info("page message: " + msg);
		assertTrue(msg.contains(msgDisplay));

	}

	public String getPropUpMsg() {
		String msg = driver.switchTo().alert().getText();
		logger.info("prop up mag: " + msg);
		return msg;
	}

}

package com.carriersedge.pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.carriersedge.stepDefinitions.SelfServedLoginSteps;
import com.carriersedge.util.BaseClass;

public class LoginPage extends BaseClass {

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println("login page initilized with driver");
	}

	// public WebDriver driver;
	private static final Logger logger = LogManager.getLogger(LoginPage.class);

	@FindBy(xpath = "//h1[contains(.,'Welcome To CarriersEdge!')]")
	WebElement welcomeCarriersHeading;
	@FindBy(id = "j_username")
	WebElement loginTb;
	@FindBy(id = "j_password")
	WebElement passwordTb;
	@FindBy(className = "btnLogin")
	WebElement goButton;
	@FindBy(xpath = "//h1[contains(.,'Login Error')]")
	WebElement errorMsg;
	@FindBy(xpath = "//a[contains(.,'Get help here')]")
	WebElement getHelpHereLink;
	@FindBy(id = "identifierId")
	WebElement loginTb1;
	@FindBy(name = "password")
	WebElement passwordTb1;
	@FindBy(css = ".VfPpkd-LgbsSe-OWXEXe-k8QpJ > .VfPpkd-RLmnJb")
	WebElement nxtbtn;
	@FindBy(xpath = "/html/head/title")
	WebElement CarriersHeading;

	@FindBy(id = "//*[@id=\":68\"]/span")
	WebElement eml;

	public void enterUserName(String username) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("j_username")));
		foo.clear();
		foo.sendKeys(username);
		logger.info("login page username: " + username);

	}

	public void enterpassword(String password) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("j_password")));
		foo.clear();
		foo.sendKeys(password);
		logger.info("login page password: " + password);

	}

	public void clickedGoButton() {
		goButton.click();
		logger.info("login page Go Button Clicked");

	}

	// ***********LMST-917*******
	public void enterUsrName(String uname) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='identifierId']")));
		// input[@id='identifierId']
		foo1.clear();
		foo1.sendKeys(uname);
		WebElement foo12 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")));
		foo12.click();
		logger.info("login page username: " + uname);

	}

	public void enterpasword(String pwd) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		foo2.clear();
		foo2.sendKeys(pwd);
		WebElement foo12 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")));
		foo12.click();
		logger.info("login page password: " + pwd);

	}

	public void clickonemail() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("zE")));
		foo2.click();
		logger.info("email clicked");

	}

	public void clkhere() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ajT")));
		foo2.click();
		logger.info("button clicked");

	}

	public void herelnk() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("here")));
		foo2.click();
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		logger.info("button clicked");

	}

	public void RecoveryPageTitle() {
		try {
			logger.info("waiting to check heading...");
			Thread.sleep(1000);
		} catch (Exception e) {
			logger.error("Sleep interrupted: " + e);
		}
		// ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		// driver.switchTo().window(tabs2.get(1));

		String actualTitle = driver.getTitle();
		logger.info("actualtitle*****************" + actualTitle);
		assertTrue(driver.getTitle().contains("Forgot password - CarriersEdge"));
		logger.info("Checked Title of the displayed page");
	}

	// ***************LMST-917 till here*****************
	public void checkErrorMessage() {
		errorMsg.getText();
		assertEquals("Login Error", errorMsg.getText());
		logger.info("Error message display checked");

	}

	public void checkLoginPageTitle() {
		try {
			logger.info("waiting to check heading...");
			Thread.sleep(1000);
		} catch (Exception e) {
			logger.error("Sleep interrupted: " + e);
		}
		String heading = welcomeCarriersHeading.getText();
		logger.info("heading :" + heading);
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("CarriersEdge Login - CarriersEdge"));
		assertTrue(heading.contains("Welcome To CarriersEdge!"));
		logger.info("Checked Title of the displayed page");
	}

	public void getHelpHereLinkClick() {
		getHelpHereLink.click();

	}
}

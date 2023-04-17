package com.carriersedge.pages;

import static org.junit.Assert.assertTrue;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.carriersedge.util.BaseClass;

public class HomePage extends BaseClass {

	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logger.info("Home Page initializes");
}

private static final Logger logger = LogManager.getLogger(HomePage.class);
@FindBy(xpath = "//a[@href='lang']")
WebElement language;
@FindBy(xpath = "//span[contains(.,'PDF Test')]")
WebElement PDFTestHeading;
@FindBy(xpath = "(//a[contains(.,'Close')])[1]")
WebElement SupportDashboardclose;
@FindBy(id = "nav1")
WebElement homeMainMenu;
@FindBy(id = "nav2")
WebElement programsMainMenu;
@FindBy(id = "nav3")
WebElement peopleMainMenu;
@FindBy(id = "nav4")
WebElement progressMainMenu;
@FindBy(id = "topnav1")
WebElement topSettingsMainMenu;
@FindBy(id = "topnav2")
WebElement userNotificationMainMenu;
@FindBy(id = "topnav3")
WebElement notificationMainMenu;
@FindBy(id = "topnav4")
WebElement billingMainMenu;
@FindBy(id = "users_change_password")
WebElement passwordChangeChkBx;
@FindBy(id = "topnav7")
WebElement logOutBtn;
@FindBy(id = "topnav6")
WebElement supportBtn;
@FindBy(id = "topnav5")
WebElement languageBtn;
@FindBy(xpath = "//button[contains(.,'Save')]")
WebElement saveBtn;
@FindBy(xpath = "//*[@id=\"home\"]/div/div//a")
WebElement userProfileLink;
@FindBy(xpath = "//*[@id='home']//p[1]/a")
WebElement loggedInAs;
@FindBy(xpath = "(//a[contains(.,'Take Test Again')])[2]")
WebElement testTakeAgain;

@FindBy(xpath = "//*[@id='smallipop1']/div")
WebElement guideTextOnStatusOrDate;

private double accountBalance;

public double getAccountBalance() {
	return accountBalance;
}

public void setAccountBalance(double accountBalance) {
	this.accountBalance = accountBalance;
	logger.info("Current account balance set to: " + this.accountBalance);
}

// used to closed stay logged in information form if it is already open
public void stayLoggedInClosed() {
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {

		e.printStackTrace();
	}
	if (driver.findElements(By.xpath("//h1[contains(.,'Stay logged in?')]")).size() == 1) {
		driver.findElement(By.id("rememberMe2")).click();
		driver.findElement(By.xpath("//button[contains(.,'OK')]")).click();
	}
}

public void supportDashboardClose() {
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {

		e.printStackTrace();
	}

	if (driver.findElements(By.xpath("(//a[contains(@class,'btnClose')])[1]")).size() > 0) {
		logger.info("I saw support dashboard.");
		driver.findElement(By.xpath("(//a[contains(@class,'btnClose')])[1]")).click();
	}
}
// Page confirmation by checking test on the page "PDF Test".
/**
 * Check whether the home page open or not by checking log out button. if logout
 * button is seen, then the user is login successfully.
 */
public void checkHomePageOpen() {
	stayLoggedInClosed();
	supportDashboardClose();
	String pageTitle = driver.getTitle();
	logger.info("Login successfully: " + pageTitle);
	assertTrue(pageTitle.contains("- CarriersEdge"));
	if (!logOutBtn.isDisplayed()) {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	assertTrue(logOutBtn.isDisplayed());
}

public void clickHomeMainMenu() {
	WebDriverWait wait = new WebDriverWait(driver, 20);
	WebElement foo = wait.until(ExpectedConditions.visibilityOf(homeMainMenu));
	foo.click();
	logger.info("Home main menu clicked");
}

public void clickProgramsMainMenu() {
	WebDriverWait wait = new WebDriverWait(driver, 40);
	// *************Java script executor added for ElementClickInterceptedException
	// error
	try {
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(programsMainMenu));
		foo.click();
		logger.info("programs main menu clicked");
	} catch (ElementClickInterceptedException e) {
		logger.info("Exception occur");
		try {
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", programsMainMenu);
		} catch (Exception e1) {
			logger.info("Exception occur");
			new Actions(driver).click(programsMainMenu).perform();
		}

		logger.info("People main menu clicked in Exception");
	}
	// *****************
}

public void clickPeopleMainMenu() {
	WebDriverWait wait = new WebDriverWait(driver, 20);
	try {
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(peopleMainMenu));
		foo.click();
		logger.info("People main menu clicked");
	} catch (ElementClickInterceptedException e) {
		logger.info("Exception occur");
		try {
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", peopleMainMenu);
		} catch (Exception e1) {
			logger.info("Exception occur");
			new Actions(driver).click(peopleMainMenu).perform();
		}

		logger.info("People main menu clicked in Exception");
	}
}

public void clickProgressMainMenu() {
	progressMainMenu.click();
	logger.info("Progress main menu clicked");
}

public void clickSettingsMainMenu() {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	WebElement foo = wait.until(ExpectedConditions.elementToBeClickable(topSettingsMainMenu));
	Actions action = new Actions(driver);
	action.moveToElement(foo).build().perform();
	foo.click();
	logger.info("top Settings Main Menu clicked");
}

public void clickUserNotificationMainMenu() {
	userNotificationMainMenu.click();
	logger.info("top user Notification Main Menu clicked");
}

public void clickNotificationMainMenu() {
	notificationMainMenu.click();
	logger.info("top Notification Main Menu clicked");
}

public void clickBillingMainMenu() {
	billingMainMenu.click();
	logger.info("top user billing Main Menu clicked");
}

public void checkOnPasswordChangeChkBxInSettings() {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	WebElement foo = wait.until(ExpectedConditions.visibilityOf(passwordChangeChkBx));
	if (!foo.isSelected()) {
		foo.click();
		logger.info("password Change Chk Box checked");
	}
}

public void uncheckOnPasswordChangeChkBxInSettings() {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	WebElement foo = wait.until(ExpectedConditions.visibilityOf(passwordChangeChkBx));
	if (foo.isSelected()) {
		foo.click();
		logger.info("password Change Chk Box is unchecked.");
	}
}

/** Click log out Button to logout from the application */
public void chickLogoutBtn() {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	WebElement foo = wait.until(ExpectedConditions.elementToBeClickable(logOutBtn));
	foo.click();
	logger.info("Logout Button was Clicked.");
}

public void clickSaveBtn() {
	saveBtn.click();
	logger.info("Save Button was Clicked.");
}

public void chickOnUserProfileLink() {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	WebElement foo = wait.until(ExpectedConditions.elementToBeClickable(userProfileLink));
	foo.click();
	logger.info("User Profile Link was Clicked.");
}

/**
 * Click on Logged in as <User First Name User Last Name>
 */
public void clickloggedInAs() {
	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement foo = wait.until(ExpectedConditions.elementToBeClickable(loggedInAs));
	foo.click();
	logger.info("Logged in As clicked.");
}

/** Get all assigned modules from the user's home page */
public String[] getAssignedModules() {
	List<WebElement> courses = driver.findElements(By.xpath("//*[@id='home']//table/tbody/tr/td[1]/a"));
	String[] courseNames = new String[courses.size()];
	for (int i = 0; i < courses.size(); i++) {
		WebElement foo = courses.get(i);
		courseNames[i] = foo.getText();
		logger.info("App: " + courseNames[i]);
	}
	return courseNames;
}

/** Get all assigned Programs from the user's home page */
public String[] getAssignedProgram() {
	List<WebElement> eles = driver.findElements(By.xpath("//*[@id='home']//section/h2/span"));
	String[] programs = new String[eles.size()];
	logger.info("Program size: " + eles.size());
	for (int i = 0; i < eles.size(); i++) {
		programs[i] = eles.get(i).getText();
	}
	return programs;
}

/** Get all assigned modules in the assigned program(Argument). */
public String[] getProgramAssignedModules(String programName) {
	List<WebElement> eles = driver
			.findElements(By.xpath("//h2[span[contains(.,'" + programName + "')] ]/..//td[1]"));
	if (eles.size() == 0) {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	eles = driver.findElements(By.xpath("//h2[span[contains(.,'" + programName + "')] ]/..//td[1]"));
	String[] mod = new String[eles.size()];
	logger.info("Array size: " + eles.size());
	for (int i = 0; i < eles.size(); i++) {
		mod[i] = eles.get(i).getText();
	}
	return mod;
}

/** Get all assigned modules from the user's home page */
public String[] getAllAssignedModules() {
	List<WebElement> eles = driver.findElements(By.xpath("//*[@id='home']/div/div/section//td[1]/a"));
	String[] mod = new String[eles.size()];
	logger.info("Array size: " + eles.size());
	for (int i = 0; i < eles.size(); i++) {
		mod[i] = eles.get(i).getText();
	}
	return mod;
}

/** Click on the start blue button on the right side of the module. */
public void playModule(String moduleName) {
	WebDriverWait wait = new WebDriverWait(driver, 20);
	WebElement foo = wait.until(ExpectedConditions.visibilityOf(
	driver.findElement(By.xpath("//*[text()='" + moduleName + "']/ancestor::node()[2] /td[3]/a"))));
	foo.click();

}

/** Click on the module on the home page of the user. */
public void clickOnTheModule(String moduleName) {
	driver.findElement(By.xpath("//a[contains(.,'" + moduleName + "')]")).click();
}

// getSmallPopOnMsgOnProgram()
public String getGuideTextOnStatusOrDateOnHover() {
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	// return guideTextOnStatusOrDate.getText();
	return driver.findElement(By.id("smallipop1")).getText();
}

/**
 * Mouse over on the program name in the argument on the user home page if the
 * program is present.
 */
public void hoverOverOnProgram(String programName) {
	// ***** Modified for logging and take screenshot on fail
	File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	try {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement ele = wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//h2/span[contains(.,'" + programName + "')]"))));
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
	} catch (Exception e) {
		String page = driver.getPageSource();
		logger.info(page);
		try {
			FileUtils.copyFile(file, new File("./TestData/headless_screenshot.png"));
		} catch (IOException e1) {

			e1.printStackTrace();
		}
	}
	// Till here
}

/** Give guide text when mouse over on the program. */
public String getTextOnMouseHoveroverProgram() {
	List<WebElement> eles = driver.findElements(By.xpath("//*[@id='smallipop1']/div/p"));// (By.xpath("//*[@id=\"smallipop1\"]/div/p[1]"));
	String str = "";
	String temp;
	for (int i = 0; i < eles.size(); i++) {
		temp = eles.get(i).getText();
		logger.info("Line " + i + ": " + temp);
		str = str + " " + temp;
	}
	return str;
}

/** Get the status of the module (in argument) on the user's home page. */
public String getStatusOfModule(String moduleName) {
	return driver.findElement(By.xpath("//*[td[a[text()='" + moduleName + "']]]/td[2]")).getText();
}

public void hoverOverOnModuleStatusOrDate(String moduleName) {
	WebElement ele = driver.findElement(By.xpath("//*[td[a[text()='" + moduleName + "']]]/td[2]"));
	Actions action = new Actions(driver);
	action.moveToElement(ele).build().perform();
}

public void clickLanguage() {
	language.click();
}

/** Change language setting by passing the language name as an argument. */
public void selectLanguage(String language) {
	driver.findElement(By.xpath("//strong[contains(.,'" + language + "')]")).click();
}

public void clickOnStartOverOnModuleInfo() {
	driver.findElement(By.xpath("//a[contains(.,'Start Over')]")).click();
}

public void testTakeAgainInTest() {
	testTakeAgain.click();
}

/**
 * writes (Arg2)comments on any text box or text area heaving element id(Arg1).
 */
	public void writeComments(String id, String comments) {
		driver.findElement(By.id(id)).clear();
		driver.findElement(By.id(id)).sendKeys(comments);
	}

}

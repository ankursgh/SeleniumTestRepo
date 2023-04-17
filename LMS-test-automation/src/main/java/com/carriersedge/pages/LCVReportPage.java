package com.carriersedge.pages;

import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.carriersedge.stepDefinitions.SelfServedLoginSteps;
import com.carriersedge.util.BaseClass;
import com.carriersedge.util.Myutilities;

public class LCVReportPage extends BaseClass {
	public LCVReportPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logger.info("Report page initialized");
	}

	private static final Logger logger = LogManager.getLogger(LoginPage.class);

	public void usrac() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement userActivity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("User Activity")));
		userActivity.click();
		Myutilities.sleepFor(3000);
		logger.info("Link clicked");
	}

	public void gtrept() {
		Set<String> windows = driver.getWindowHandles();
		String winHandleBefore = driver.getWindowHandle();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementBuildReport = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buildReport")));
		elementBuildReport.click();
		Myutilities.sleepFor(10000);
		for (String handle : windows) {
			driver.switchTo().window(handle);
			System.out.println("switched to " + driver.getTitle() + "  Window");
			String pageTitle = driver.getTitle();
			if (pageTitle.equalsIgnoreCase("Report - OTA LCV Certification Program - CarriersEdge")) {
				Myutilities.sleepFor(4000);
				driver.close();
				System.out.println("Closed the  '" + pageTitle + "' Tab now ...");
			}

		}
		Myutilities.sleepFor(6000);
		driver.switchTo().window(winHandleBefore);
		// driver.navigate().refresh();
		logger.info("Report genarated");
	}

	public void swttab() {

		String originalHandle = driver.getWindowHandle();
		// Open new tabs
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementBuildReport = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buildReport")));
		elementBuildReport.click();
		Myutilities.sleepFor(4000);
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(handle);
				String pageTitle = driver.getTitle();
				if (pageTitle.equalsIgnoreCase("Report - OTA LCV Certification Program - CarriersEdge")) {
					driver.close();
					System.out.println("Closed the  '" + pageTitle + "' Tab now ...");
				}
			}
		}

		driver.switchTo().window(originalHandle);
	}

	public void rstflt() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementResetFilter = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"rptDone\"]/td[2]/table/tbody/tr[2]/td[2]/p[3]/a")));
		elementResetFilter.click();
		Myutilities.sleepFor(2000);
		logger.info("Reset filter");
	}

	public void slctcbx() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementShowVariation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showVariations")));
		elementShowVariation.click();

		WebElement elementShowUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showUsernames")));
		elementShowUsername.click();

		WebElement elementShowNoData = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showNoData")));
		elementShowNoData.click();

		WebElement elementShowDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showDetail")));
		elementShowDetails.click();
		
		WebElement elementShowInactive = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showInactive")));
		elementShowInactive.click();

		WebElement elementShowRecent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showRecent")));
		elementShowRecent.click();

		Myutilities.sleepFor(3000);
		logger.info("checkboxes clicked");
	}

	public void boxdte() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementBoxDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("boxDate")));
		elementBoxDate.click();
	}

	public void pstwk() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementPastWeek = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Past week")));
		elementPastWeek.click();
		logger.info("Past week report generated");
	}

	public void pstmth() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementPastMonth = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Past month")));
		elementPastMonth.click();
		logger.info("Past month report generated");
	}

	public void qtr() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementPastQuater = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Past quarter")));
		elementPastQuater.click();
		logger.info("Past quater report generated");
	}

	public void year() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementPastYear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Past year")));
		elementPastYear.click();
		logger.info("Past year report generated");
	}

	public void user() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementBoxDriver = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("boxDriver")));
		elementBoxDriver.click();
		WebElement elementDriverDetails = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#driverDetail td:nth-child(2) > input")));
		elementDriverDetails.click();
		logger.info("User clicked");
	}

	public void selsc() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementUserType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("userType")));
		elementUserType.click();
		{
			Select subcompanyDropdown = new Select(driver.findElement(By.id("subcompany")));
			Myutilities.sleepFor(2000);
			subcompanyDropdown.selectByValue("4411");
			// ********till here
		}
		logger.info("subcompay selected clicked");
	}

	public void locs() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement ele5 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#driverDetail td:nth-child(2) > input")));
		ele5.click();
		logger.info("location clicked");
	}

	public void induser() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement ele6 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("tr:nth-child(1) > td:nth-child(3) > input:nth-child(1)")));
		ele6.click();
		Select elementDriver = new Select(driver.findElement(By.id("drivers")));
		Myutilities.sleepFor(3000);
		elementDriver.selectByValue("automax.driver.lcv");
		logger.info("Invidual user clicked");
	}

	public void roles() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementBoxRoles = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("boxRole")));
		elementBoxRoles.click();
		{
			Select RoleDropdown = new Select(driver.findElement(By.id("roles")));
			RoleDropdown.selectByValue("driver");
			Myutilities.sleepFor(2000);
		}
		logger.info("Roles clicked");
	}

	public void Testresult() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementTestResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Test Results")));
		elementTestResult.click();
		Myutilities.sleepFor(3000);
		logger.info("Test Result clicked");
	}

	public void trainp() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementBoxCourse = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("boxCourse")));
		elementBoxCourse.click();
		logger.info("Modules clicked");
	}

	public void userbox() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementCourseDetails = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#courseDetail td:nth-child(2) > input")));
		elementCourseDetails.click();
		WebElement elementSelectCourse = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#courseDetail td:nth-child(2) > input")));
		elementSelectCourse.click();
		WebElement elementCouse = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("courseType")));
		elementCouse.click();
		logger.info("Training plan report clicked");
	}

	public void invmod() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementCourseDetails = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#courseDetail td:nth-child(2) > input")));
		elementCourseDetails.click();
		logger.info("Individual module report clicked");
	}

	public void userTranscript() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementTranscript = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("User Transcripts")));
		elementTranscript.click();
		Myutilities.sleepFor(3000);
		logger.info("Test Result clicked");
	}

	// for user transcript
	public void utransrpt() {

		String originalHandle = driver.getWindowHandle();
		// Open new tabs
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementBuildReport = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buildReport")));
		elementBuildReport.click();
		Myutilities.sleepFor(4000);

		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(handle);
				WebElement viewCert = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Print Certificate")));
				viewCert.click();
				String pageTitle = driver.getTitle();
				if (pageTitle.equalsIgnoreCase(
						"Certificate of Achievement - OTA LCV Certification Program - CarriersEdge")) {
					driver.close();
					System.out.println("Closed the  '" + pageTitle + "' Tab now ...");
				}
			}
		}
	}

	// *******
	public void usrcomplaince() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementUserCompliance = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("User Compliance")));
		elementUserCompliance.click();
		Myutilities.sleepFor(3000);
		logger.info("TUser Compliance clicked");
	}

	public void mgrcomplaince() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementCompliance = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Manager Compliance")));
		elementCompliance.click();
		Myutilities.sleepFor(3000);
		logger.info("TUser Compliance clicked");
	}

	public void mngevnts() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementEvent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Events")));
		elementEvent.click();
		Myutilities.sleepFor(3000);
		logger.info("Events clicked");
	}

	public void evntrpt() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementRegistration = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Event Registration")));
		elementRegistration.click();
		Myutilities.sleepFor(3000);
		logger.info("Event Registration clicked");
	}

	public void certifs() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementCert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Certifications")));
		elementCert.click();
		Myutilities.sleepFor(3000);
		logger.info("Certifications clicked");
	}

	public void trsrpt() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementTransactionHistory = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Transaction History")));
		elementTransactionHistory.click();
		Myutilities.sleepFor(3000);
		logger.info("Transaction History clicked");
	}

	public void crtnumbrs() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementCertNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Cert Numbers")));
		elementCertNo.click();
		Myutilities.sleepFor(3000);
		logger.info("Cert Numbers clicked");
	}

	public void usractiv() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementUserActivity = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("User File Activity")));
		elementUserActivity.click();
		Myutilities.sleepFor(3000);
		logger.info("User File Activity clicked");
	}

	public void lcvinst() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementInstructorWorkshp = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("LCV Instructor Workshop")));
		elementInstructorWorkshp.click();
		Myutilities.sleepFor(3000);
		logger.info("LCV Instructor Workshop clicked");
	}

	// LCV add contact Step definition
	public String generateRandomnum(int length) {

		return RandomStringUtils.randomNumeric(length);
	}

	public String generateRandomstr(int length) {
		return RandomStringUtils.randomAlphabetic(length);

	}

	public void lcvlnk() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementAddContact = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addLCVContact")));
		elementAddContact.click();
		Myutilities.sleepFor(3000);
		logger.info("LCV contact link clicked");
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	public void fstnm() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementFirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
		elementFirstName.click();
		elementFirstName.sendKeys("automation");
		Myutilities.sleepFor(2000);
		logger.info("first name entered");
	}

	public void lsame() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementLastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName")));
		elementLastName.click();
		elementLastName.sendKeys("" + generateRandomstr(6));
		Myutilities.sleepFor(3000);
		logger.info("lastname entered");
	}

	public void elsm() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		elementEmail.click();
		elementEmail.sendKeys("test@gmail.com");
		Myutilities.sleepFor(3000);
		logger.info("email entered");
	}

	public void title() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
		elementTitle.click();
		elementTitle.sendKeys("Mr");
		Myutilities.sleepFor(1000);
		logger.info("Title entered");
	}

	public void drlnse() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementDriverLicense = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("driverLicence")));
		elementDriverLicense.click();
		elementDriverLicense.sendKeys("" + generateRandomnum(6));
		Myutilities.sleepFor(1000);
		logger.info("Driver license entered");
	}

	public void locst() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementLocationId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("locationId")));
		elementLocationId.click();
		Myutilities.sleepFor(2000);
		{
			WebElement locationDropdown = driver.findElement(By.id("locationId"));
			locationDropdown.findElement(By.xpath("//option[. = 'Test automation - Test automation']")).click();
		}
		logger.info("Location selected");
	}

	public void dclr() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementDeclare = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("declare")));
		elementDeclare.click();
		Myutilities.sleepFor(2000);
		logger.info("delare clicked");
	}

	public void smt() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementSaveBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementSaveBtn.click();
		Myutilities.sleepFor(2000);
		logger.info("save button clicked");
	}

	public void udlts() {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Prime User")));
		Actions actions = new Actions(driver);
		actions.moveToElement(elementUser).build().perform();
		Myutilities.sleepFor(2000);
		WebElement elementSelectUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'prime') and @title='Remove this individual from the program.']")));
		elementSelectUser.click();
		logger.info("link clicked");
		Myutilities.sleepFor(2000);
		driver.switchTo().frame(0);
		WebElement elementSubmitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit_button")));
		elementSubmitButton.click();
		driver.switchTo().defaultContent();
		Myutilities.sleepFor(2000);
		logger.info("Prime User deleted");
		
	}
	public void uDels() {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementUserSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Aotmas")));
		Actions actions = new Actions(driver);
		actions.moveToElement(elementUserSearch).build().perform();
		Myutilities.sleepFor(2000);
		WebElement elementUserSrch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'aotmas') and @title='Remove this individual from the program.']")));
		elementUserSrch.click();
		logger.info("link clicked");
		Myutilities.sleepFor(2000);
		driver.switchTo().frame(0);
		WebElement elementSubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit_button")));
		elementSubmit.click();
		driver.switchTo().defaultContent();
		Myutilities.sleepFor(2000);
		logger.info("User Aotmas deleted");
	}
	
	// till here
}

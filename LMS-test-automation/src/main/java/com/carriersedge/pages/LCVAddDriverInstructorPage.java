package com.carriersedge.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
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
import com.carriersedge.util.BaseClass;

public class LCVAddDriverInstructorPage extends BaseClass {
	public LCVAddDriverInstructorPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logger.info("Add carrier and add driver page initialized");
	}

	private static final Logger logger = LogManager.getLogger(LCVAddDriverInstructorPage.class);

	public String Randomnums(int length) {
		return RandomStringUtils.randomNumeric(length);
	}

	public String Randomstrs(int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}

	public void RgsInst() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementRegisterInstructor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Register Instructor")));
		elementRegisterInstructor.click();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	public void PreRtgsInstruc() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement RegisterInstructor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Register Instructor")));
		RegisterInstructor.click();
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		// Below code is for scrolldown till end and accept checkbox
		WebElement InstructorTerms = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"instructorTerms\"]/p[16]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", InstructorTerms);
		// till here
		WebElement elementAcceptance = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acceptance")));
		elementAcceptance.click();
		WebElement elementSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementSave.click();
		WebElement elementShipping = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipping")));
		elementShipping.click();
		{
			WebElement elementShiping1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipping")));
			elementShiping1.findElement(By.xpath("//option[. = 'Pickup at OTA']")).click();
		}
		WebElement elementFirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
		elementFirstName.sendKeys("Automation1");
		WebElement elementLastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName")));
		elementLastName.sendKeys("" + Randomstrs(8));
		WebElement elementEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		elementEmail.sendKeys("ddt@tt.com");
		WebElement elementDrivingLicense = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("driverLicence")));
		elementDrivingLicense.sendKeys("" + Randomnums(6));

		WebElement elementProv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("prov")));
		{
			elementProv.findElement(By.xpath("//option[. = 'Alberta']")).click();
		}
		WebElement elementInstructorType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("instructorType3")));
		elementInstructorType.click();
		{
			Select elementInstructorCertify = new Select(driver.findElement(By.id("instructorCertifiedBy")));
			Myutilities.sleepFor(2000);
			elementInstructorCertify.selectByValue("Manitoba");
		}
		WebElement InstructorCertificate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("instructorCertificate")));
		InstructorCertificate.sendKeys("" + Randomnums(7));

		{
			Select driverCertifiedDropdown = new Select(driver.findElement(By.id("driverCertifiedBy")));
			Myutilities.sleepFor(2000);
			driverCertifiedDropdown.selectByValue("Manitoba");
		}
		WebElement elementdriverCertificate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("driverCertificate")));
		elementdriverCertificate.sendKeys("" + Randomnums(7));

		WebElement elementYear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("years0")));
		elementYear.sendKeys("48");

		WebElement elementMiles = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("milesMB")));
		elementMiles.sendKeys("1000");
		Myutilities.sleepFor(2000);

		{
			Select elemntEquipment = new Select(driver.findElement(By.id("equipment1")));
			Myutilities.sleepFor(2000);
			elemntEquipment.selectByValue("Turnpike");
		}
		{
			Select elementEquipmentDropdown = new Select(driver.findElement(By.id("equipment2")));
			Myutilities.sleepFor(2000);
			elementEquipmentDropdown.selectByValue("A-Train");
		}
		WebElement elementCompletedProg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("completedProg12")));
		elementCompletedProg.click();

		{
			Select eventDropdown = new Select(driver.findElement(By.id("eventId")));
			Myutilities.sleepFor(2000);
			//Event Name: Divya dtest R
			eventDropdown.selectByValue("6714");
		}
		WebElement elementHandlingTDG2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("handlingTDG2")));
		elementHandlingTDG2.click();
		{
			String path = System.getProperty("user.dir");
			WebElement elementFilename = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filename1")));
			elementFilename.sendKeys(path + "/TestData/sample.pdf");
		}
		WebElement elementDateCheck = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dateCheck")));
		elementDateCheck.click();
		WebElement elementDate = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-icon-circle-triangle-e")));
		elementDate.click();
		WebElement elementDay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("24")));
		elementDay.click();

		WebElement elementDeclare = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("declare")));
		elementDeclare.click();

		WebElement elementCardNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cardNumber")));
		elementCardNo.click();
		elementCardNo.sendKeys("5454545454545454");

		WebElement elementCardExp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cardExpiry")));
		elementCardExp.click();
		elementCardExp.sendKeys("0525");

		WebElement elementPrintReciept = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("printReceipt2")));
		elementPrintReciept.click();

		WebElement elementBtnSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementBtnSave.click();

		Myutilities.sleepFor(6000);
		driver.switchTo().window(winHandleBefore);
		String actalTitle = driver.getTitle();
		logger.info("actualtitle*" + actalTitle);
		assertTrue(driver.getTitle().contains("LCV Contact Home - OTA LCV Certification Program - CarriersEdge"));
		logger.info("**User creation successful**");
	}

	public void RtgsInsr() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement RegisterInstructor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Register Instructor")));
		RegisterInstructor.click();
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		// Below code is for scrolldown till end and accept checkbox
		WebElement instructorTerms = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"instructorTerms\"]/p[16]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", instructorTerms);
		// till here
		WebElement elementAcceptance = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acceptance")));
		elementAcceptance.click();
		WebElement elementSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementSave.click();
		WebElement elementShiping = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipping")));
		elementShiping.click();
		{
			WebElement elementShipping = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipping")));
			elementShipping.findElement(By.xpath("//option[. = 'Pickup at OTA']")).click();
		}
		WebElement elementFirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
		elementFirstName.sendKeys("Automation2");
		WebElement elementLastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName")));
		elementLastName.sendKeys("" + Randomstrs(8));
		WebElement elementEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		elementEmail.sendKeys("dd@tt.com");
		WebElement elementDrivingLicense = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("driverLicence")));
		elementDrivingLicense.sendKeys("" + Randomnums(6));

		WebElement elementProv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("prov")));
		{
			elementProv.findElement(By.xpath("//option[. = 'Alberta']")).click();
		}
		WebElement elementInstructorType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("instructorType2")));
		elementInstructorType.click();
		// 
		WebElement elementDtc_Res = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dtc_res")));
		elementDtc_Res.click();
		elementDtc_Res.sendKeys("test");

		WebElement elementDesRes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("des_res")));
		elementDesRes.click();
		elementDesRes.sendKeys("tests");

		WebElement elementHrsRes1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hrs_res1")));
		elementHrsRes1.click();
		elementHrsRes1.sendKeys("24");

		WebElement elementHrsRes2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hrs_res2")));
		elementHrsRes2.click();
		elementHrsRes2.sendKeys("34");

		WebElement elementOtq = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("otq_res")));
		elementOtq.click();
		elementOtq.sendKeys("Test 1");

		WebElement elementOte = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ote_res")));
		elementOte.click();
		elementOte.sendKeys("Test 11");

		WebElement elementEvent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("eventId")));
		elementEvent.click();
		{
			WebElement elementEventDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("eventId")));
			elementEventDate.findElement(By.xpath("//option[. = '2023-04-04 Dtest R']")).click();
		}
		String path = System.getProperty("user.dir");
		WebElement elementFileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filename11")));
		elementFileName.sendKeys(path + "/TestData/sample.pdf");

		WebElement elementDeclare = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("declare")));
		elementDeclare.click();

		WebElement elementCardNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cardNumber")));
		elementCardNo.click();
		elementCardNo.sendKeys("5454545454545454");

		WebElement elementCardExp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cardExpiry")));
		elementCardExp.click();
		elementCardExp.sendKeys("0525");

		WebElement elementPrintReciept = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("printReceipt2")));
		elementPrintReciept.click();

		WebElement elementBtnSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementBtnSave.click();

		Myutilities.sleepFor(6000);
		driver.switchTo().window(winHandleBefore);

		String actalTitle1 = driver.getTitle();
		logger.info("actualtitle**" + actalTitle1);
		assertTrue(driver.getTitle().contains("LCV Contact Home - OTA LCV Certification Program - CarriersEdge"));
		logger.info("*Second User creation successful**");
	}

	// **Driver registration**
	public void rtgsdrvr() {
		
		String winHandleBefore = driver.getWindowHandle();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement RegisterDriver = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Register Driver")));
		RegisterDriver.click();
		Myutilities.sleepFor(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		WebElement elementAcceptance = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acceptance")));
		elementAcceptance.click();
		Myutilities.sleepFor(2000);
		WebElement elementSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementSave.click();
		Myutilities.sleepFor(2000);
		// Select dropdown
		WebElement ShippingDropdown = driver.findElement(By.id("shipping"));
		ShippingDropdown.findElement(By.xpath("//option[. = 'Pickup at OTA']")).click();
		Myutilities.sleepFor(2000);
		// Webelement first name
		WebElement elementFirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
		elementFirstName.click();
		elementFirstName.sendKeys("Automation3");
		// WebElement last name
		WebElement elementLastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName")));
		elementLastName.click();
		elementLastName.sendKeys("" + Randomstrs(8));
		// WebElement DL
		WebElement elementDriverLicense = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("driverLicence")));
		elementDriverLicense.click();
		elementDriverLicense.sendKeys("" + Randomnums(6));
		// WebElement prov
		WebElement elementProv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("prov")));
		elementProv.click();
		// dropdown
		WebElement provDropdown = driver.findElement(By.id("prov"));
		provDropdown.findElement(By.xpath("//option[. = 'Alberta']")).click();
		Myutilities.sleepFor(2000);
		// WebElement Driver Type
		WebElement elementDriverType1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("driverType1")));
		elementDriverType1.click();
		WebElement eventDropdown = driver.findElement(By.id("eventId"));
		eventDropdown.findElement(By.xpath("//option[. = '2023-04-04 Evt 16']")).click();

		// Webelement checkbox
		WebElement elementHandlingTdg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("handlingTDG2")));
		elementHandlingTdg.click();
		Myutilities.sleepFor(2000);
		String path2 = System.getProperty("user.dir");
		WebElement elementFilename = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filename3a")));
		elementFilename.sendKeys(path2 + "/TestData/sample.pdf");
		Myutilities.sleepFor(2000);
		// WebElement date other
		WebElement elementDateNew = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dateOtherNew")));
		elementDateNew.click();
		// WebElement link click
		WebElement elementYear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("years2")));
		elementYear.click();
		elementYear.sendKeys("23");
		WebElement elemntLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("23")));
		elemntLink.click();
		// WebElement declare checkbox
		WebElement elementDeclare = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("declare")));
		elementDeclare.click();
		// WebElement card number
		WebElement elementCardNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cardNumber")));
		elementCardNo.sendKeys("5454545454545454");
		Myutilities.sleepFor(3000);
		// WebElement card exp
		WebElement elementCardExp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cardExpiry")));
		elementCardExp.sendKeys("0525");
		// WebElement prntchkbx
		WebElement elementprint = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("printReceipt2")));
		elementprint.click();
		// WebElement submit
		WebElement elementSaveBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementSaveBtn.click();
		Myutilities.sleepFor(16000);
		driver.switchTo().window(winHandleBefore);
		String actalTitle1 = driver.getTitle();
		logger.info("actualtitle***" + actalTitle1);
		assertTrue(driver.getTitle().contains("Instructor Home - OTA LCV Certification Program - CarriersEdge"));
		logger.info("**Third User creation successful*****");

	}
	// *****Delete user
	public void delt1() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Automation1")));
		Actions actions = new Actions(driver);
		actions.moveToElement(elementUser).perform();
		Myutilities.sleepFor(2000);
		WebElement elementDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'automation1') and @title='Remove this individual from the program.']")));
		actions.moveToElement(elementDelete).perform();
		elementDelete.click();
		logger.info("link clicked");
		Myutilities.sleepFor(2000);
		driver.switchTo().frame(0);
		WebElement elementSubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit_button")));
		elementSubmit.click();
		driver.switchTo().defaultContent();
		Myutilities.sleepFor(2000);
		logger.info("User 1 deleted");

	}

	public void delt2() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Automation2")));
		Actions actions = new Actions(driver);
		actions.moveToElement(elementUsername).perform();
		// Thread.sleep(4000);
		WebElement elementRemove = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'automation2') and @title='Remove this individual from the program.']")));
		elementRemove.click();
		logger.info("link clicked");
		Myutilities.sleepFor(2000);
		driver.switchTo().frame(0);
		WebElement elementSubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit_button")));
		elementSubmit.click();
		driver.switchTo().defaultContent();
		Myutilities.sleepFor(2000);
		logger.info("User 2 deleted");

	}

	public void deltbyuser() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementGetusr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Automation3")));
		Actions actions = new Actions(driver);
		actions.moveToElement(elementGetusr).perform();
		Myutilities.sleepFor(2000);
		WebElement elementDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'automation3') and @title='Remove this individual from the program.']")));
		elementDelete.click();
		logger.info("link clicked");
		driver.switchTo().frame(0);
		WebElement elementSubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit_button")));
		elementSubmit.click();
		driver.switchTo().defaultContent();
		Myutilities.sleepFor(2000);
		logger.info("User 3 deleted");
	}

	public void refersh() {
		driver.navigate().refresh();
	}

	public void spptdoc() {
		driver.findElement(By.linkText("Supporting Documents")).click();
		Myutilities.sleepFor(2000);
		driver.switchTo().frame(0);
	}

	public void sptdchk() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/div/div[2]/div[1]/div[6]/select")));
		elementCheckbox.click();
		Myutilities.sleepFor(1000);
		{
			elementCheckbox.findElement(By.xpath("//option[. = 'Accepted']")).click();
			Myutilities.sleepFor(2000);
		}
		WebElement sves = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		sves.click();
		Myutilities.sleepFor(1000);
		driver.switchTo().defaultContent();
	}

	public void rstreg() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementRecentRegistration = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Recent Registrations")));
		elementRecentRegistration.click();
		Myutilities.sleepFor(2000);
		driver.switchTo().frame(0);
	}

	public void resg() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementRegistration = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"regForm\"]/div[2]")));
		String els = elementRegistration.getText();
		// Assertions
		assertTrue(els.contains("Automation1"));
		Myutilities.sleepFor(2000);
		driver.switchTo().defaultContent();
		WebElement elementUser= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"hsId1\"]/div/div")));
		elementUser.click();
	}

	public void lckur() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementLockedUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Locked Users")));
		elementLockedUser.click();
		driver.switchTo().frame(0);
		Myutilities.sleepFor(1000);
		WebElement elementClose = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnClose")));
		elementClose.click();
		driver.switchTo().defaultContent();
	}

	public void ulckur() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		elementUsername.click();
		Myutilities.sleepFor(2000);
		WebElement elementSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementSave.click();
		Myutilities.sleepFor(1000);
		driver.switchTo().defaultContent();
	}

	public void cfyusr() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementCertification = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.linkText("You have users eligible for certification.")));
		elementCertification.click();
		Myutilities.sleepFor(1000);
	}
}

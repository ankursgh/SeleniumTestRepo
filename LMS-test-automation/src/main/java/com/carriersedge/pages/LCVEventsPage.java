package com.carriersedge.pages;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import org.openqa.selenium.TimeoutException;
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

public class LCVEventsPage extends BaseClass {
	public LCVEventsPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logger.info("Events page initialized");
	}

	private static final Logger logger = LogManager.getLogger(LCVEventsPage.class);

	public String Randomnms(int length) {

		return RandomStringUtils.randomNumeric(length);
	}

	public String Randomsts(int length) {
		return RandomStringUtils.randomAlphabetic(length);

	}

	public void Eventlnk() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementLink = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("All Training Events")));
		elementLink.click();
		logger.info("Event link clicked");
	}

	public void updatebn() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement updateLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Update")));
		updateLink.click();
		Myutilities.sleepFor(2000);
	}

	public void Stts() {
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		logger.info("Update link clicked");

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("status0")));
		elementStatus.click();
		Myutilities.sleepFor(2000);
		{
			elementStatus.findElement(By.xpath("//option[. = 'Complete']")).click();
			// Incomplete,Did not attend
			Myutilities.sleepFor(2000);
		}
		WebElement elementSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementSave.click();
		Myutilities.sleepFor(2000);
		driver.switchTo().window(winHandleBefore);
		WebElement elementHome = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Home")));
		elementHome.click();

	}

	public void Vfsts() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementDriver = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Automax Driver")));
		Actions actions = new Actions(driver);
		actions.moveToElement(elementDriver).perform();
		elementDriver.click();
		Myutilities.sleepFor(3000);
		driver.switchTo().frame(0);
		WebElement elementDrivername = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Training\"]/div/div[2 ]")));
		String expText = elementDrivername.getText();
		logger.info(expText);
		driver.switchTo().defaultContent();
		WebElement closeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".closebutton")));
		closeButton.click();
		logger.info(expText);
	}

	public void Stts1() {
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		logger.info("Update link clicked");

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementCourseStaus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("status0")));
		elementCourseStaus.click();
		Myutilities.sleepFor(2000);
		{
			elementCourseStaus.findElement(By.xpath("//option[. = 'Incomplete']")).click();
			// Incomplete,Did not attend
			Myutilities.sleepFor(2000);
		}
		WebElement elementBtnSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementBtnSave.click();
		Myutilities.sleepFor(2000);
		driver.switchTo().window(winHandleBefore);
		WebElement elementHomeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Home")));
		elementHomeButton.click();

	}

	public void Vfincom() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Automax Driver")));
		Actions actions = new Actions(driver);
		actions.moveToElement(elementLink).perform();
		elementLink.click();
		Myutilities.sleepFor(3000);
		driver.switchTo().frame(0);
		WebElement elementTraning = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Training\"]/div/div[2 ]")));
		String expText = elementTraning.getText();
		logger.info(expText);
		// Assertions
		// assertTrue(elvs.contains("Incomplete"));
		driver.switchTo().defaultContent();
		WebElement elementCloseButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".closebutton")));
		elementCloseButton.click();

	}

	public void Stts2() {
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		logger.info("Update link clicked");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementCorseStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("status0")));
		elementCorseStatus.click();
		Myutilities.sleepFor(2000);
		{
			elementCorseStatus.findElement(By.xpath("//option[. = 'Did not attend']")).click();
			// Incomplete,Did not attend
			Myutilities.sleepFor(2000);
		}
		WebElement elementButtonSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementButtonSave.click();
		Myutilities.sleepFor(2000);
		driver.switchTo().window(winHandleBefore);
		WebElement elementHomeLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Home")));
		elementHomeLink.click();
	}

	public void Vfincom1() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementLink1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Automax Driver")));
		Actions actions = new Actions(driver);
		actions.moveToElement(elementLink1).perform();
		elementLink1.click();
		Myutilities.sleepFor(3000);
		driver.switchTo().defaultContent();
		WebElement elementClose = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".closebutton")));
		elementClose.click();
	}

	public void strns() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementTraining = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Schedule Training")));
		elementTraining.click();
		Myutilities.sleepFor(2000);
	}

	public void evtsdta() {
		driver.switchTo().frame(0);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
		elementName.click();
		elementName.sendKeys("Automation");

		WebElement elementStartDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("start_date")));
		elementStartDate.click();

		WebElement elementLink2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-icon-circle-triangle-e")));
		elementLink2.click();

		WebElement elementLinkText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("12")));
		elementLinkText.click();

		WebElement elementMaxReg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("max_reg")));
		elementMaxReg.click();
		elementMaxReg.sendKeys("2");

		WebElement elementBtnsave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementBtnsave.click();

		driver.switchTo().defaultContent();
		Myutilities.sleepFor(2000);
	}

	public void evtvry() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementEvents = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Events\"]/div[1]/div[1]")));
		String Strs20 = elementEvents.getText();
		assertTrue(Strs20.contains("Automation"));
		Myutilities.sleepFor(2000);
	}

	public void evtvy() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementCancel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Cancel")));
		elementCancel.click();
		driver.switchTo().frame(0);
		WebElement elementSubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit_button")));
		elementSubmit.click();
		driver.switchTo().defaultContent();
		Myutilities.sleepFor(2000);
	}

	public void mgevt() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementManageEvent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Manage Events")));
		elementManageEvent.click();
		Myutilities.sleepFor(2000);
	}

	public void edevt() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementEvent2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"rightcolumn\"]/table[2]/tbody/tr[2]/td/table[1]/tbody/tr/td[4]/a[1]")));
			    
		elementEvent2.click();
		Myutilities.sleepFor(2000);
	}

	public void asevt() {
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		WebDriverWait wait = new WebDriverWait(driver, 20);

		{
			Select userSelectionDropdown = new Select(driver.findElement(By.id("userNotIn")));
			Myutilities.sleepFor(2000);
			userSelectionDropdown.selectByValue("at.aks.contact1.lcv");
		}
		Myutilities.sleepFor(1000);
		WebElement elementAddUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnAddUser")));
		elementAddUser.click();
		Myutilities.sleepFor(2000);
		WebElement SaveBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		SaveBtn.click();
		driver.switchTo().window(winHandleBefore);
	}

	public void rmvusr() {
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		{
			Select selectedUserDropdown = new Select(driver.findElement(By.id("userIn")));
			Myutilities.sleepFor(2000);
			selectedUserDropdown.selectByValue("at.aks.contact1.lcv");
		}
		
		Myutilities.sleepFor(1000);
		WebElement elementRemoveUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnRemoveUser")));
		elementRemoveUser.click();
		Myutilities.sleepFor(2000);
		WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		saveButton.click();
		driver.switchTo().window(winHandleBefore);
		Myutilities.sleepFor(2000);

		// Window handle
		for (String winHandle1 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle1);
		}
		Myutilities.sleepFor(2000);
		// driver.switchTo().window(winHandleBefore);
	}

	// *************Upadate Practical activity***************
	public void rgdrv() {
		String winHandleBefore = driver.getWindowHandle();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement registerDriver = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Register Driver")));
		registerDriver.click();
		Myutilities.sleepFor(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		WebElement elementAccept = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acceptance")));
		elementAccept.click();
		Myutilities.sleepFor(2000);
		WebElement saveClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		saveClick.click();
		Myutilities.sleepFor(2000);
		// Select dropdown
		WebElement shippingDropdown = driver.findElement(By.id("shipping"));
		shippingDropdown.findElement(By.xpath("//option[. = 'Pickup at OTA']")).click();
		Myutilities.sleepFor(2000);
		// Webelement first name
		WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
		firstName.click();
		firstName.sendKeys("Asmoan");
		// WebElement last name
		WebElement lastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName")));
		lastName.click();
		lastName.sendKeys("" + Randomnms(8));
		;
		// WebElement DL
		WebElement driverLicense = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("driverLicence")));
		driverLicense.click();
		driverLicense.sendKeys("" + Randomsts(6));
		// WebElement prov
		WebElement elementProv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("prov")));
		elementProv.click();
		// dropdown
		WebElement provinceDropdown = driver.findElement(By.id("prov"));
		provinceDropdown.findElement(By.xpath("//option[. = 'Alberta']")).click();
		Myutilities.sleepFor(2000);
		// WebElement Driver Type
		WebElement driverType1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("driverType1")));
		driverType1.click();
		WebElement eventDropdown = driver.findElement(By.id("eventId"));
		eventDropdown.findElement(By.xpath("//option[. = '2023-04-04 Practical Test']")).click();
		// WebElement Instructor
		WebElement gh16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("instructor")));
		gh16.click();
		WebElement SelectInstructorDropdown = driver.findElement(By.id("instructor"));
		SelectInstructorDropdown.findElement(By.xpath("//option[. = 'Renew Instructor']")).click();
		// Webelement checkbox
		WebElement elementHandling = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("handlingTDG2")));
		elementHandling.click();
		Myutilities.sleepFor(2000);
		String path2 = System.getProperty("user.dir");
		WebElement elementFilename = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filename3a")));
		elementFilename.sendKeys(path2 + "/TestData/sample.pdf");
		Myutilities.sleepFor(2000);
		// WebElement date other
		WebElement elementDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dateOtherNew")));
		elementDate.click();
		// WebElement link click
		WebElement elementYear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("years2")));
		elementYear.click();
		elementYear.sendKeys("28");
		WebElement elementLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("28")));
		elementLink.click();
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
		WebElement elementPrintReceipt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("printReceipt2")));
		elementPrintReceipt.click();
		// WebElement submit
		WebElement elementSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementSave.click();
		Myutilities.sleepFor(16000);
		driver.switchTo().window(winHandleBefore);

		String actalTitle1 = driver.getTitle();
		logger.info("actualtitle*****************" + actalTitle1);
		assertTrue(driver.getTitle().contains("LCV Contact Home - OTA LCV Certification Program - CarriersEdge"));
		logger.info("********Third User creation successful*********");

	}

	public void activateuser() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elms3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Locked Users")));
		elms3.click();
		driver.switchTo().frame(0);
		Myutilities.sleepFor(2000);
		String expTxt = "Asmoan";
		WebElement unlockedUser = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"unlockUsersList\"]/div[2]/div[1]/div[2]")));
		String hgd = unlockedUser.getText();
		logger.info(hgd);
		// if (hgd.contains("Asmoan"));{}
		Assert.assertTrue(hgd.contains("Asmoan"));
		logger.info("******************************");
		// Assert.assertTrue(message, condition);True(hgd.contains("Asmoan"));
		WebElement elementUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		elementUsername.click();
		Myutilities.sleepFor(2000);
		WebElement elementBtnSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementBtnSave.click();
		Myutilities.sleepFor(1000);
		driver.switchTo().defaultContent();

	}

	public void Rnw61() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementCert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Certifications")));
		elementCert.click();
		logger.info("**Certifiction clicked*");
		Myutilities.sleepFor(2000);
		WebElement elementDriver = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("boxDriver")));
		elementDriver.click();
		logger.info("**Users clicked*");
		Myutilities.sleepFor(2000);
		WebElement elementCertList = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("tr:nth-child(1) > td:nth-child(3) > input:nth-child(1)")));
		elementCertList.click();
		Myutilities.sleepFor(2000);
		// Select ddn value by partial txt **** Below code selects element based on
		// partial text send

		WebElement elemntDriver = driver.findElement(By.id("drivers"));
		Select select = new Select(elemntDriver);
		String expectedDriverName = "Asmoan";
		List<WebElement> allDriverList = select.getOptions();
		for (WebElement option : allDriverList) {
			String currentDriverName = option.getText();
			if (currentDriverName.contains(expectedDriverName)) {
				select.selectByVisibleText(currentDriverName);
				break;
			}
		}
		// Till here
		Myutilities.sleepFor(2000);
		WebElement elementReport = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buildReport")));
		elementReport.click();
		Myutilities.sleepFor(7000);
		for (String win41 : driver.getWindowHandles()) {
			driver.switchTo().window(win41);
		}
		Myutilities.sleepFor(4000);
		// ****** selecting instructor * from webtable
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"rptCertifications\"]/tbody/tr"));
		int count = rows.size();
		logger.info(count);
		String before_xpath2 = "//*[@id=\"rptCertifications\"]/tbody/tr[";
		String after_xpath2 = "]/td[3]";
		for (int i = 2; i <= count; i++) {
			String instname2 = driver.findElement(By.xpath(before_xpath2 + i + after_xpath2)).getText();
			logger.info(instname2);
			// *************************** for excat match*******contentEquals***
			if (instname2.contentEquals("DIT (no TDG)")) {
				WebElement rpq37 = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//*[@id=\"rptCertifications\"]/tbody/tr[" + i + "]/td[8]/a/img")));
				rpq37.click();
			}
		}
		// *****
		
		Myutilities.sleepFor(2000);
		for (String win62 : driver.getWindowHandles()) {
			driver.switchTo().window(win62);
		}
		Myutilities.sleepFor(4000);
		WebElement elementIssueDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("issueDate")));
		elementIssueDate.click();
		Myutilities.sleepFor(2000);
		WebElement elementLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("6")));
		elementLink.click();
		Myutilities.sleepFor(2000);
		WebElement elementContnt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"formContent\"]/div[4]")));
		elementContnt.click();
		Myutilities.sleepFor(2000);
		WebElement elementCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checked")));
		elementCheckbox.click();
		Myutilities.sleepFor(2000);
		WebElement elementSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementSave.click();
		Myutilities.sleepFor(4000);
	}

	public void upprc() {
		try {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		// ***Current *Date***
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// get current date time with Date()
		Date date = new Date();
		// Now format the date
		String dateFormatted = dateFormat.format(date);
		// *******
		WebElement elementUpdateRoadTest = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("updateRoadTest")));
		elementUpdateRoadTest.click();
		driver.switchTo().frame(0);
		Myutilities.sleepFor(2000);
		WebElement elementUpdate = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/div[1]/form/div/div[2]/div[1]/div[4]/input")));
		// upd1.click();
		elementUpdate.sendKeys(dateFormatted);
		Myutilities.sleepFor(2000);
		String path2 = System.getProperty("user.dir");
		WebElement elementUpload = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/div[1]/form/div/div[2]/div[1]/div[5]/input")));
		elementUpload.sendKeys(path2 + "/TestData/sample.pdf");
		Myutilities.sleepFor(2000);
		WebElement elementDate = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/div[1]/form/div/div[2]/div[2]/div[4]/input")));
		elementDate.sendKeys(dateFormatted);
		WebElement elementUpload1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/div[1]/form/div/div[2]/div[2]/div[5]/input")));
		elementUpload1.sendKeys(path2 + "/TestData/sample.pdf");
		Myutilities.sleepFor(2000);
		WebElement elementRoadTest = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"roadTestTable\"]/div[2]/div[2]/div[2]")));
		elementRoadTest.click();
		WebElement elementSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementSave.click();
		Myutilities.sleepFor(2000);
		}
		catch (TimeoutException e) {
			e.printStackTrace();
			logger.info("Update practical activity option not found");
		}

	}

	public void dlsdr() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementGetuser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Asmoan")));
		Actions actions = new Actions(driver);
		actions.moveToElement(elementGetuser).perform();
		Myutilities.sleepFor(2000);
		WebElement elementDelete = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[@title='Remove this individual from the program.']")));
		elementDelete.click();
		logger.info("link clicked");
		driver.switchTo().frame(0);
		WebElement elementSubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit_button")));
		elementSubmit.click();
		driver.switchTo().defaultContent();
		Myutilities.sleepFor(2000);
		logger.info("User Asmoan deleted");

	}
	// ****Update activity***
}

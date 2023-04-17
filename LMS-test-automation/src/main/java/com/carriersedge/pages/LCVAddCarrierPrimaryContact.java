package com.carriersedge.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class LCVAddCarrierPrimaryContact extends BaseClass {
	public LCVAddCarrierPrimaryContact(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logger.info("Add carrier and primary contact page initialized");
	}

	private static final Logger logger = LogManager.getLogger(LoginPage.class);

	public String Randomnum(int length) {
		return RandomStringUtils.randomNumeric(length);
	}

	public String Randomstr(int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}

	public void Registercont() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement lcvContact = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Carrier/LCV Contact")));
		lcvContact.click();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	public void Crrname() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement carrierName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("carrierName")));
		carrierName.click();
		carrierName.sendKeys("Aautomation");
	}

	public void Cvors() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementCvor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cvor")));
		elementCvor.click();
		elementCvor.sendKeys("34545");
	}

	public void accts() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementAcct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountNumber")));
		elementAcct.click();
		elementAcct.sendKeys("QW765");
	}

	public void phne() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementPhone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone")));
		elementPhone.click();
		elementPhone.sendKeys("9878756567");
	}

	public void Fxs() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementFax = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fax")));
		elementFax.click();
		elementFax.sendKeys("7876785678");
	}

	public void Wbs() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementWebsite = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("website")));
		elementWebsite.click();
		elementWebsite.sendKeys("www.ats.com");
	}

	public void scd() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementScode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("companyCode")));
		elementScode.click();
		elementScode.sendKeys("" + Randomstr(8));
	}

	public void stt1() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementStreet = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address1")));
		elementStreet.click();
		elementStreet.sendKeys("Toranto");
	}

	public void stt2() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementStreet1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address2")));
		elementStreet1.click();
		elementStreet1.sendKeys("Toranto");
	}

	public void ctt() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementCity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("city")));
		elementCity.click();
		elementCity.sendKeys("Toranto Canada");
	}

	public void provs() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		{
			WebElement proviceDropdown = driver.findElement(By.id("province"));
			proviceDropdown.findElement(By.xpath("//option[. = 'Alberta']")).click();
		}
	}

	public void pstl() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementPostal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("postal")));
		elementPostal.click();
		elementPostal.sendKeys("M3C0C2");
	}

	public void atfls() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		// get current date time with Date()
		Date date = new Date();
		// Now format the date
		String dateFormatted = dateFormat.format(date);
		String path = System.getProperty("user.dir");
		WebElement elementFormcopy = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formCopy")));
		elementFormcopy.sendKeys(path + "/TestData/sample.pdf");
		WebElement elementCertification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wsib1")));
		elementCertification.click();
		Myutilities.sleepFor(2000);
		//Changed as default value is auto selected.
		//WebElement elementDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("issueDate")));
		//elementDate.sendKeys(dateFormatted);
		//Myutilities.sleepFor(2000);
		//WebElement elementBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
		//elementBody.click();
		Myutilities.sleepFor(2000);
	}
    //WSIB Compliance Certification
	
	public void frtn() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementFirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
		elementFirstName.click();
		elementFirstName.sendKeys("Automax");
	}

	public void lsnm() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementLastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName")));
		elementLastName.click();
		elementLastName.sendKeys("" + Randomstr(7));
	}

	public void tls() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("jobTitle")));
		elementTitle.click();
		elementTitle.sendKeys("Mr");
	}

	public void ems() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		elementEmail.click();
		elementEmail.sendKeys("ss@email.com");
	}

	public void phs() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementPhone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("adminPhone")));
		elementPhone.click();
		elementPhone.sendKeys("9898987898");
	}

	public void fx2() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementFax2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("adminFax")));
		elementFax2.click();
		elementFax2.sendKeys("6898987898");
	}

	public void drvrlns() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementDriverLicense = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("driversLicence")));
		elementDriverLicense.click();
		elementDriverLicense.sendKeys("" + Randomnum(7));
	}

	public void subst() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementSaveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementSaveButton.click();
	}

	public void srhusr() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementSearchUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchUsers")));
		elementSearchUser.click();
		elementSearchUser.sendKeys("Automax");
		elementSearchUser.sendKeys(Keys.DOWN);
		elementSearchUser.sendKeys(Keys.RETURN);
		WebElement elementContentUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Users\"]/table/tbody/tr/td[3]/a")));
		Actions actions = new Actions(driver);
		actions.moveToElement(elementContentUser).perform();
		WebElement elementContentUser1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Users\"]/table/tbody/tr/td[7]/a[3]")));
		elementContentUser1.click();
		Myutilities.sleepFor(2000);
		driver.switchTo().frame(0);
		WebElement elementSubmitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit_button")));
		elementSubmitButton.click();
		driver.switchTo().defaultContent();
	}

	public void dvl1() throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elemenLinkAll = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("All")));
		elemenLinkAll.click();
		WebElement subComapany = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_subcompanyList\"]/div[1]/div[1]/div[1]")));
		String expectedText = subComapany.getText();
		assertEquals("Aautomation", expectedText);
		logger.info("*Click all clicked**");
	}

	public void dvl2() throws IOException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("All")));
		elementLink.click();
		WebElement elementLocation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_location\"]/div[1]/div[1]/div[1]")));
		String expectedTxt = elementLocation.getText();
		assertEquals("Aautomation", expectedTxt);
		logger.info("*Click all location clicked*");
	}

	// Add secondary instructor*
	public void Registerinstruc() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementInstructor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Register Instructor")));
		elementInstructor.click();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	public void RtgsIns() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		// Below code is for scrolldown till end and accept checkbox
		WebElement instructorText = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"instructorTerms\"]/p[16]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", instructorText);
		// till here
		WebElement elementAcceptance = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acceptance")));
		elementAcceptance.click();
		WebElement elementSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementSave.click();
		WebElement elementShipping = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipping")));
		elementShipping.click();
		{
			WebElement elementShiping = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipping")));
			elementShiping.findElement(By.xpath("//option[. = 'Pickup at OTA']")).click();
		}
		WebElement elementFirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
		elementFirstName.sendKeys("Aotmas");
		WebElement elementLastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName")));
		elementLastName.sendKeys("" + Randomstr(8));
		WebElement elementEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		elementEmail.sendKeys("dd@tt.com");
		WebElement driverLisece = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("driverLicence")));
		driverLisece.sendKeys("" + Randomnum(6));
		WebElement elementProvince = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("prov")));
		{
			elementProvince.findElement(By.xpath("//option[. = 'Alberta']")).click();
		}
		WebElement instructorType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("instructorType2")));
		instructorType.click();

		WebElement elementDtcres = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dtc_res")));
		elementDtcres.click();
		elementDtcres.sendKeys("test");

		WebElement elementDesres = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("des_res")));
		elementDesres.click();
		elementDesres.sendKeys("tests");

		WebElement elementhrs1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hrs_res1")));
		elementhrs1.click();
		elementhrs1.sendKeys("24");

		WebElement elementhrs2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hrs_res2")));
		elementhrs2.click();
		elementhrs2.sendKeys("34");

		WebElement elementOtq = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("otq_res")));
		elementOtq.click();
		elementOtq.sendKeys("Test 1");

		WebElement elementOte = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ote_res")));
		elementOte.click();
		elementOte.sendKeys("Test 11");

		WebElement elementEventid = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("eventId")));
		elementEventid.click();
		{
			WebElement elemntEvent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("eventId")));
			elemntEvent.findElement(By.xpath("//option[. = '2023-04-04 Dtest R']")).click();
		}
		String path = System.getProperty("user.dir");
		WebElement elementFilename = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filename11")));
		elementFilename.sendKeys(path + "/TestData/sample.pdf");

		WebElement elementDeclare = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("declare")));
		elementDeclare.click();

		WebElement elementCardNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cardNumber")));
		elementCardNo.click();
		elementCardNo.sendKeys("5454545454545454");

		WebElement elementCardExp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cardExpiry")));
		elementCardExp.click();
		elementCardExp.sendKeys("0525");

		WebElement elementPrintRecipt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("printReceipt2")));
		elementPrintRecipt.click();

		WebElement elementSavebtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementSavebtn.click();
		Myutilities.sleepFor(6000);
	}

	public void RtgsInstruc() throws InterruptedException 
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		// Below code is for scrolldown till end and accept checkbox
		WebElement instructorTerm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"instructorTerms\"]/p[16]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", instructorTerm);
		// till here
		WebElement elementAccept = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acceptance")));
		elementAccept.click();
		WebElement elemtnSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elemtnSave.click();
		WebElement elementShipping = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipping")));
		elementShipping.click();
		{
			WebElement elementShipping1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipping")));
			elementShipping1.findElement(By.xpath("//option[. = 'Pickup at OTA']")).click();
		}
		WebElement elementFirstname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
		elementFirstname.sendKeys("Prime");
		WebElement elementLastname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName")));
		elementLastname.sendKeys("User");
		WebElement elementEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		elementEmail.sendKeys("ddt@tt.com");
		WebElement driverLicence = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("driverLicence")));
		driverLicence.sendKeys("" + Randomnum(6));

		WebElement elementProv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("prov")));
		{
			elementProv.findElement(By.xpath("//option[. = 'Alberta']")).click();
		}
		WebElement elementInstructorType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("instructorType3")));
		elementInstructorType.click();
		{
			Select instructorDropdown = new Select(driver.findElement(By.id("instructorCertifiedBy")));
			Myutilities.sleepFor(2000);
			instructorDropdown.selectByValue("Manitoba");
		}
		WebElement instructorCert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("instructorCertificate")));
		instructorCert.sendKeys("" + Randomnum(7));

		{
			Select driverCertBy = new Select(driver.findElement(By.id("driverCertifiedBy")));
			Myutilities.sleepFor(2000);
			driverCertBy.selectByValue("Manitoba");
		}
		WebElement driverCert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("driverCertificate")));
		driverCert.sendKeys("" + Randomnum(7));

		WebElement elementYears = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("years0")));
		elementYears.sendKeys("48");

		WebElement elementMiles = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("milesMB")));
		elementMiles.sendKeys("1000");
		Myutilities.sleepFor(2000);

		{
			Select equipment1Dropdown = new Select(driver.findElement(By.id("equipment1")));
			Myutilities.sleepFor(2000);
			equipment1Dropdown.selectByValue("Turnpike");
		}
		{
			Select equipment2Dropdown = new Select(driver.findElement(By.id("equipment2")));
			Myutilities.sleepFor(2000);
			equipment2Dropdown.selectByValue("A-Train");
		}
		WebElement elementcompletedProg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("completedProg12")));
		elementcompletedProg.click();

		{
			Select eventDropdown1 = new Select(driver.findElement(By.id("eventId")));
			Myutilities.sleepFor(2000);
			eventDropdown1.selectByValue("6714");
		}
		WebElement elementTDG2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("handlingTDG2")));
		elementTDG2.click();
		{
			String path = System.getProperty("user.dir");
			WebElement elementFilename1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filename1")));
			elementFilename1.sendKeys(path + "/TestData/sample.pdf");
		}
		WebElement elementDateCheck = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dateCheck")));
		elementDateCheck.click();
		WebElement elementCircle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-icon-circle-triangle-e")));
		elementCircle.click();
		WebElement elemntCalender = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("24")));
		elemntCalender.click();

		WebElement elementDeclare = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("declare")));
		elementDeclare.click();

		WebElement elemtCardNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cardNumber")));
		elemtCardNo.click();
		elemtCardNo.sendKeys("5454545454545454");

		WebElement elemtCardExp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cardExpiry")));
		elemtCardExp.click();
		elemtCardExp.sendKeys("0525");

		WebElement elemtPrintRecipt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("printReceipt2")));
		elemtPrintRecipt.click();

		WebElement ElementSaveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		ElementSaveButton.click();
		Myutilities.sleepFor(6000);
	}
}

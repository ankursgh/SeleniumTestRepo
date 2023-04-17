package com.carriersedge.pages;

import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import org.apache.commons.io.FileUtils;
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
import org.openqa.selenium.support.ui.WebDriverWait;
import com.carriersedge.stepDefinitions.SelfServedLoginSteps;
import com.carriersedge.util.BaseClass;
import com.carriersedge.util.Myutilities;

public class LCVCarrierMembership extends BaseClass {
	public LCVCarrierMembership(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logger.info("Carrier Membership page initialized");
	}

	private static final Logger logger = LogManager.getLogger(LoginPage.class);

	public void carrierslc() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement linkText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("A")));
		linkText.click();
	}

	public void status() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementAccountStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountStatus0")));
		Actions builder = new Actions(driver);
		builder.doubleClick(elementAccountStatus).perform();
	}

	public void slcnon() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.findElement(By.cssSelector("select")).click();
		{
			WebElement optionDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select")));
			optionDropdown.findElement(By.xpath("//option[. = 'Non-member']")).click();
		}
		Myutilities.sleepFor(2000);
	}

	public void slcmem() {
		WebDriverWait wait = new WebDriverWait(driver, 30);

		driver.findElement(By.cssSelector("select")).click();
		{
			WebElement selectDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select")));
			selectDropdown.findElement(By.xpath("//option[. = 'Member']")).click();
		}
		Myutilities.sleepFor(2000);
	}

	public void svbn() {
		String winHandleBefore = driver.getWindowHandle();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementSubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".editable-submit")));
		elementSubmit.click();
		Myutilities.sleepFor(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		WebElement elemntSaveBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elemntSaveBtn.click();
		Myutilities.sleepFor(2000);
		driver.switchTo().window(winHandleBefore);
	}

	public void svsbn() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementSubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".editable-submit")));
		elementSubmit.click();
		Myutilities.sleepFor(2000);
	}

	public void rgsdriver() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		String winHandleBefore = driver.getWindowHandle();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementRegisterDriver = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Register Driver")));
		elementRegisterDriver.click();
		Myutilities.sleepFor(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		WebElement elementAcceptence = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acceptance")));
		elementAcceptence.click();
		Myutilities.sleepFor(2000);

	}

	public float getDecimalRandomNumber() {
		// create instance of Random class
		Random rand = new Random();
		// Generate and return Random number with decimal
		return rand.nextInt();
	}

	public void driverdts() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementSaveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementSaveButton.click();
		Myutilities.sleepFor(2000);
		// Select dropdown
		WebElement shippingDropdown = driver.findElement(By.id("shipping"));
		shippingDropdown.findElement(By.xpath("//option[. = 'Pickup at OTA']")).click();
		Myutilities.sleepFor(2000);
		// Webelement first name
		WebElement elementfnme = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
		elementfnme.click();
		elementfnme.sendKeys("Test");
		// WebElement last name
		WebElement elementlastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName")));
		elementlastName.click();
		elementlastName.sendKeys("Lcv");
		// WebElement DL
		WebElement elementDrivingLicense = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("driverLicence")));
		elementDrivingLicense.click();
		elementDrivingLicense.sendKeys("" + getDecimalRandomNumber());
		// WebElement prov
		WebElement elementProv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("prov")));
		elementProv.click();
		// dropdown
		WebElement provinceDropdown = driver.findElement(By.id("prov"));
		provinceDropdown.findElement(By.xpath("//option[. = 'Alberta']")).click();
		Myutilities.sleepFor(2000);
		// WebElement Driver Type
		WebElement elementDriverType1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("driverType1")));
		elementDriverType1.click();
		WebElement eventDropdown = driver.findElement(By.id("eventId"));
		eventDropdown.findElement(By.xpath("//option[. = '2023-04-04 test ev']")).click();
		// Webelement checkbox
		WebElement ch1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("handlingTDG2")));
		ch1.click();
		Myutilities.sleepFor(2000);
	}

	public void usrdriver() {
		String path = System.getProperty("user.dir");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");

		WebElement elementFileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filename3a")));
		elementFileName.sendKeys(path + "/TestData/sample.pdf");
		Myutilities.sleepFor(2000);
		// WebElement date other
		WebElement elementDateOther = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dateOtherNew")));
		elementDateOther.click();
		// WebElement link click
		WebElement elementYear2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("years2")));
		elementYear2.click();
		elementYear2.sendKeys("23");
		WebElement elementdate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("23")));
		elementdate.click();
		// WebElement declare checkbox
		WebElement elementdeclare = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("declare")));
		elementdeclare.click();
		// WebElement card number
		WebElement elementCardNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cardNumber")));
		elementCardNo.sendKeys("5454545454545454");
		Myutilities.sleepFor(3000);
		// WebElement card exp
		WebElement elementCardExp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cardExpiry")));
		elementCardExp.sendKeys("0525");
		// WebElement prntchkbx
		WebElement elementPrintReceipt2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("printReceipt2")));
		elementPrintReceipt2.click();
		// WebElement submit
		WebElement btnSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		btnSave.click();
		Myutilities.sleepFor(16000);
	}

	// ****second driver carrier member
	public void mdriverdts() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementbtnSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementbtnSave.click();
		Myutilities.sleepFor(2000);
		// Select dropdown
		WebElement selectShipingDropdown = driver.findElement(By.id("shipping"));
		selectShipingDropdown.findElement(By.xpath("//option[. = 'Pickup at OTA']")).click();
		Myutilities.sleepFor(2000);
		// Webelement first name
		WebElement elementFirstname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
		elementFirstname.click();
		elementFirstname.sendKeys("Lcv");
		// WebElement last name
		WebElement elementLastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName")));
		elementLastName.click();
		elementLastName.sendKeys("Test");
		// WebElement DL
		WebElement elementDriverLicence = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("driverLicence")));
		elementDriverLicence.click();
		elementDriverLicence.sendKeys("" + getDecimalRandomNumber());
		// WebElement prov
		WebElement elementPro = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("prov")));
		elementPro.click();
		// dropdown
		WebElement selectProvince = driver.findElement(By.id("prov"));
		selectProvince.findElement(By.xpath("//option[. = 'Alberta']")).click();
		Myutilities.sleepFor(2000);
		// WebElement Driver Type
		WebElement elementDriverType1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("driverType1")));
		elementDriverType1.click();
		WebElement selectEvent = driver.findElement(By.id("eventId"));
		selectEvent.findElement(By.xpath("//option[. = '2023-04-04 test ev']")).click();
		// Webelement checkbox
		WebElement elementHandlingTDG = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("handlingTDG2")));
		elementHandlingTDG.click();
		Myutilities.sleepFor(2000);
	}

	public void musrdriver() {
		String path = System.getProperty("user.dir");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		WebElement elementFilename = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filename3a")));
		elementFilename.sendKeys(path + "/TestData/sample.pdf");
		Myutilities.sleepFor(2000);
		// WebElement date other
		WebElement elementOtherNew = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dateOtherNew")));
		elementOtherNew.click();
		// WebElement link click
		WebElement elementYear2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("years2")));
		elementYear2.click();
		elementYear2.sendKeys("23");
		WebElement elementDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("23")));
		elementDate.click();
		// WebElement declare checkbox
		WebElement elementDeclare = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("declare")));
		elementDeclare.click();
		// WebElement card number
		WebElement elementCardNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cardNumber")));
		elementCardNumber.sendKeys("5454545454545454");
		Myutilities.sleepFor(3000);
		// WebElement card exp
		WebElement elementCardExpiry = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cardExpiry")));
		elementCardExpiry.sendKeys("0524");
		// WebElement prntchkbx
		WebElement elementPrintRecipt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("printReceipt2")));
		elementPrintRecipt.click();
		// WebElement submit
		WebElement elementbtnSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementbtnSave.click();
		Myutilities.sleepFor(16000);
	}

	public void susers() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementSearchUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchUsers")));
		elementSearchUser.click();
		Myutilities.sleepFor(2000);
		elementSearchUser.sendKeys("Test LCV");
		elementSearchUser.sendKeys(Keys.DOWN);
		elementSearchUser.sendKeys(Keys.RETURN);
	}

	public void delus() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementUserList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Users\"]/table/tbody/tr/td[2]/a")));
		Actions actions = new Actions(driver);
		actions.moveToElement(elementUserList).perform();
		WebElement elementUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Users\"]/table/tbody/tr/td[7]/a[3]")));
		elementUser.click();
		driver.switchTo().frame(0);
		WebElement elementSubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit_button")));
		elementSubmit.click();
		driver.switchTo().defaultContent();
	}

	// Delete second driver
	public void seusers() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement searchUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchUsers")));
		searchUser.click();
		searchUser.sendKeys("Lcv Test");
		searchUser.sendKeys(Keys.DOWN);
		searchUser.sendKeys(Keys.RETURN);
	}

	public void sdelus() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementUserList1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Users\"]/table/tbody/tr/td[2]/a")));
		Actions actions = new Actions(driver);
		actions.moveToElement(elementUserList1).perform();
		WebElement elementUser1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Users\"]/table/tbody/tr/td[7]/a[3]")));
		elementUser1.click();
		driver.switchTo().frame(0);
		WebElement elementSubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit_button")));
		elementSubmit.click();
		driver.switchTo().defaultContent();
	}

}

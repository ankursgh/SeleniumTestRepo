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

public class LCVRenewReprintCertificatePage extends BaseClass {
	public LCVRenewReprintCertificatePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logger.info("LCV Renew Certificate Page Initialized");
	}

	private static final Logger logger = LogManager.getLogger(LCVRenewReprintCertificatePage.class);

	public void Rnw1() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementCertification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Certifications")));
		elementCertification.click();
		logger.info("**Certifiction clicked*");
		Myutilities.sleepFor(2000);
		WebElement elementDriver = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("boxDriver")));
		elementDriver.click();
		logger.info("**Users clicked*");
		Myutilities.sleepFor(2000);
		WebElement driverSelection = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("tr:nth-child(1) > td:nth-child(3) > input:nth-child(1)")));
		driverSelection.click();
		Myutilities.sleepFor(2000);
		{
			WebElement elementdriver1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("drivers")));
			elementdriver1.findElement(By.xpath("//option[. = 'LV2 Test']")).click();
		}
		Myutilities.sleepFor(2000);
		WebElement elementBuildRepot = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buildReport")));
		elementBuildRepot.click();
		Myutilities.sleepFor(3000);
		for (String win11 : driver.getWindowHandles()) {
			driver.switchTo().window(win11);
		}
		Myutilities.sleepFor(5000);
		WebElement elementCertReport = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"rptCertifications\"]/tbody/tr[2]/td[7]")));
		elementCertReport.click();
		String drivername = elementCertReport.getText();
		logger.info(drivername);
		Myutilities.sleepFor(2000);
        //Clicking second link on report page which is Driver(certificate-422)
		// if driver appears first in report click "/html[1]/body[1]/div[1]/table[2]/tbody[1]/tr[2]/td[8]/a[1]/img[1]"
		WebElement elementIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html[1]/body[1]/div[1]/table[2]/tbody[1]/tr[3]/td[8]/a[1]/img[1]")));
		elementIcon.click();
		Myutilities.sleepFor(2000);
		for (String win12 : driver.getWindowHandles()) {
			driver.switchTo().window(win12);
		}
		WebElement elementIssueDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("issueDate")));
		
		while(!elementIssueDate.getAttribute("value").equals("")){
			elementIssueDate.sendKeys(Keys.BACK_SPACE);
	    }
		Myutilities.sleepFor(2000);
		elementIssueDate.sendKeys("2021-07-13");
		Myutilities.sleepFor(2000);
		WebElement elementCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checked")));
		elementCheckbox.click();
		Myutilities.sleepFor(2000);
		WebElement elementSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementSave.click();
	}

	public void Rnw2() {
		try {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Myutilities.sleepFor(3000);
		WebElement elementCertStatus = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_CertStatus\"]/div/a")));
		elementCertStatus.click();
		Myutilities.sleepFor(2000);
		driver.switchTo().frame(0);
		Myutilities.sleepFor(2000);
		WebElement elementRenew = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Renew")));
		elementRenew.click();
		logger.info("**Renew certifiction clicked*");
		}
		catch (TimeoutException e) {
			e.printStackTrace();
			logger.info("an exception occurred.");
		}

	}

	public void Rnw3() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		for (String win13 : driver.getWindowHandles()) {
			driver.switchTo().window(win13);
		}
		WebElement elementAccept = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acceptance")));
		elementAccept.click();
		WebElement elementSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementSave.click();
		WebElement elementShipping = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipping")));
		elementShipping.click();
		{
			WebElement elementShiping = driver.findElement(By.id("shipping"));
			elementShiping.findElement(By.xpath("//option[. = 'Pickup at OTA']")).click();
		}
		Myutilities.sleepFor(2000);
		WebElement elementMiles = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("milesBC")));
		elementMiles.click();
		elementMiles.sendKeys("5000");
		Myutilities.sleepFor(2000);
		{
			Select equipmentDropdown = new Select(driver.findElement(By.id("equipment1")));
			Myutilities.sleepFor(2000);
			equipmentDropdown.selectByValue("Turnpike");
		}
		Myutilities.sleepFor(2000);
		{
			Select equipment2Dropdown = new Select(driver.findElement(By.id("equipment2")));
			Myutilities.sleepFor(2000);
			equipment2Dropdown.selectByValue("A-Train");
		}
		WebElement elemntCompletedProg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("completedProg12")));
		elemntCompletedProg.click();
		WebElement elemntRefTraning = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("refreshtraining1")));
		elemntRefTraning.click();
		WebElement elemntRefTraning2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("refreshtraining2")));
		elemntRefTraning2.click();
		Myutilities.sleepFor(2000);
		WebElement elementCheck1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("check1")));
		elementCheck1.click();
		WebElement elementCheck2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("check2")));
		elementCheck2.click();
		WebElement elementCheck3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("check3")));
		elementCheck3.click();
		WebElement elementCheck4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("check4")));
		elementCheck4.click();
		{
			String path = System.getProperty("user.dir");
			WebElement elementFilename = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filename3")));
			elementFilename.sendKeys(path + "/TestData/sample.pdf");
		}
		Myutilities.sleepFor(2000);
		WebElement elementDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("date3")));
		elementDate.click();
		WebElement elementLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("28")));
		elementLink.click();
		Myutilities.sleepFor(2000);
		{
			String path = System.getProperty("user.dir");
			WebElement elementFilname = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.id("filenameTDGCertificate")));
			elementFilname.sendKeys(path + "/TestData/sample.pdf");
		}
		Myutilities.sleepFor(2000);

		WebElement elementCertExp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dateTDGCertificateExpiry")));
		elementCertExp.click();
		WebElement elementDate2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("28")));
		elementDate2.click();
		WebElement elementDeclare = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("declare")));
		elementDeclare.click();
		Myutilities.sleepFor(2000);
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
	}

	public void Rnw4() {
		String winHandleBefore = driver.getWindowHandle();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Myutilities.sleepFor(2000);
		WebElement elementUsers = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.linkText("You have users eligible for certification.")));
		elementUsers.click();
		logger.info("*Users eligible for certificate link clicked*");
		Myutilities.sleepFor(2000);
		WebElement elementUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("LV2 Test")));
		elementUsername.click();
		Myutilities.sleepFor(3000);
		for (String win21 : driver.getWindowHandles()) {
			driver.switchTo().window(win21);
		}
		String expectedTxt = "lv2.test.lcv";
		WebElement elementUserSelect = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"one\"]/table/tbody/tr[1]/td[2]")));
		String ast = elementUserSelect.getText();
		assertEquals(expectedTxt, ast);
		WebElement elementBtnClose = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnClose")));
		elementBtnClose.click();
		driver.switchTo().window(winHandleBefore);
	}

	public void Rnw5() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		// Selecting LV2 user from webTable
		String before_xpath1 = "//*[@id=\"tblUserCertification\"]/tbody/tr[";
		String after_xpath1 = "]/td[2]/a";
		for (int i = 70; i <= 93; i++) {
			String instname1 = driver.findElement(By.xpath(before_xpath1 + i + after_xpath1)).getText();
			logger.info(instname1);
			if (instname1.contains("LV2 Test")) {
				WebElement elementCertList = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//*[@id=\"tblUserCertification\"]/tbody/tr[" + i + "]/td[5]/a")));
				elementCertList.click();
				
			}
		}
		WebElement elementEditIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/div[2]/div/div[3]/div[2]/div/table[2]/tbody/tr[85]/td[5]/a")));
		elementEditIcon.click();
		//
		logger.info("*Activate LV2 user *");
		Myutilities.sleepFor(2000);
		for (String win22 : driver.getWindowHandles()) {
			driver.switchTo().window(win22);
		}
		WebElement elementStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("status")));
		elementStatus.click();
		{
			WebElement elementStatus1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("status")));
			elementStatus1.findElement(By.xpath("//option[. = 'Active']")).click();
		}
		WebElement elementCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checked")));
		elementCheckbox.click();
		Myutilities.sleepFor(3000);
		WebElement elementBtnSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		Myutilities.sleepFor(4000);
		elementBtnSave.click();
		Myutilities.sleepFor(6000);
	}

	// ******************Renew Instructor**********
	public void Rnw6() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementCertification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Certifications")));
		elementCertification.click();
		logger.info("**Certifiction clicked*");
		Myutilities.sleepFor(2000);
		WebElement elementBoxDriver = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("boxDriver")));
		elementBoxDriver.click();
		logger.info("**Users clicked*");
		Myutilities.sleepFor(2000);
		WebElement elementDriver = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("tr:nth-child(1) > td:nth-child(3) > input:nth-child(1)")));
		elementDriver.click();
		Myutilities.sleepFor(2000);
		{
			WebElement elementDrivers = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("drivers")));
			elementDrivers.findElement(By.xpath("//option[. = 'Renew Instructor']")).click();
		}
		Myutilities.sleepFor(2000);
		WebElement elementBuildReport = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buildReport")));
		elementBuildReport.click();
		Myutilities.sleepFor(5000);
		for (String win41 : driver.getWindowHandles()) {
			driver.switchTo().window(win41);
		}
		Myutilities.sleepFor(4000);
		WebElement elementCertReport = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"rptCertifications\"]/tbody/tr[3]/td[7]")));
		// rv106.click();
		String mn = elementCertReport.getText();
		// logger.info(mn);
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
			if (instname2.contentEquals("Instructor *")) {
				WebElement elementCertifications = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//*[@id=\"rptCertifications\"]/tbody/tr[" + i + "]/td[8]/a/img")));
				elementCertifications.click();
				logger.info(instname2);
			}
		}
		// ******
		Myutilities.sleepFor(3000);
		for (String win62 : driver.getWindowHandles()) {
			driver.switchTo().window(win62);
		}
		WebElement elementIssueDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("issueDate")));
		while(!elementIssueDate.getAttribute("value").equals("")){
			elementIssueDate.sendKeys(Keys.BACK_SPACE);
	    }
		elementIssueDate.sendKeys("2020-03-01");
		WebElement elementCheckBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checked")));
		elementCheckBox.click();
		Myutilities.sleepFor(2000);
		WebElement elementBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementBtn.click();
		Myutilities.sleepFor(2000);
	}

	public void Rnw7() {
		try {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		for (String win113 : driver.getWindowHandles()) {
			driver.switchTo().window(win113);
		}
		// Below code is for scrolldown till end and accept checkbox
		WebElement emb12 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"instructorTerms\"]/p[16]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", emb12);
		// till here
		WebElement elementAcceptance = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acceptance")));
		elementAcceptance.click();
		WebElement elementSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementSave.click();
		WebElement elementShiping = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipping")));
		elementShiping.click();
		{
			WebElement elementShipping = driver.findElement(By.id("shipping"));
			elementShipping.findElement(By.xpath("//option[. = 'Pickup at OTA']")).click();
		}
		Myutilities.sleepFor(2000);
		WebElement elementMiles = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("milesBC")));
		elementMiles.click();
		elementMiles.sendKeys("5000");
		Myutilities.sleepFor(2000);
		{
			Select euipmentDropdown = new Select(driver.findElement(By.id("equipment1")));
			Myutilities.sleepFor(2000);
			euipmentDropdown.selectByValue("Turnpike");
		}
		Myutilities.sleepFor(2000);
		{
			Select euipment2Dropdown = new Select(driver.findElement(By.id("equipment2")));
			Myutilities.sleepFor(2000);
			euipment2Dropdown.selectByValue("A-Train");
		}
		WebElement equipmentCompletedProg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("completedProg12")));
		equipmentCompletedProg.click();
		Myutilities.sleepFor(2000);
		// WebElement rvs20=
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("refreshtraining1")));
		WebElement elementTraining = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".instructor #refreshtraining1")));
		elementTraining.click();
		WebElement elementTraining1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".instructor #refreshtraining2")));
		elementTraining1.click();
		Myutilities.sleepFor(2000);
		WebElement elementCheckbox1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("check1")));
		elementCheckbox1.click();
		WebElement elementCheckbox2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("check2")));
		elementCheckbox2.click();
		WebElement elementCheckbox3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("check3")));
		elementCheckbox3.click();
		WebElement elementCheckbox4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("check4")));
		elementCheckbox4.click();
		{
			String path = System.getProperty("user.dir");
			WebElement elementFilename = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filename3")));
			elementFilename.sendKeys(path + "/TestData/sample.pdf");
		}
		Myutilities.sleepFor(2000);
		WebElement elementDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("date3")));
		elementDate.click();
		WebElement elementDate2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("28")));
		elementDate2.click();
		Myutilities.sleepFor(2000);
		{
			String path = System.getProperty("user.dir");
			WebElement elementFilenameCert = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.id("filenameTDGCertificate")));
			elementFilenameCert.sendKeys(path + "/TestData/sample.pdf");
		}
		Myutilities.sleepFor(2000);
		WebElement elementDateTDG = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dateTDGCertificateExpiry")));
		elementDateTDG.click();
		WebElement elementLinkDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("28")));
		elementLinkDate.click();
		Myutilities.sleepFor(4000);
		WebElement elementDeclare = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("declare")));
		elementDeclare.click();
		Myutilities.sleepFor(2000);
		WebElement elementCardNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cardNumber")));
		elementCardNo.click();
		elementCardNo.sendKeys("5454545454545454");
		WebElement elementCardExp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cardExpiry")));
		elementCardExp.click();
		elementCardExp.sendKeys("0525");
		WebElement elementPrintReceipt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("printReceipt2")));
		elementPrintReceipt.click();
		WebElement elementSaveBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementSaveBtn.click();
		Myutilities.sleepFor(8000);
		}
		catch (TimeoutException e) {
			e.printStackTrace();
			logger.info("an exception occurred Since I am already on the same page so it is continuous.");
		}

	}

	public void Rnw8() {
		// String winHandleBefore = driver.getWindowHandle();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementUserCert = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.linkText("You have users eligible for certification.")));
		elementUserCert.click();
		logger.info("*Users eligible for certificate link clicked*");
		Myutilities.sleepFor(3000);
		
	}

	public void Rnw9() {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		// Belew is the code the select uniq element from web table; total 93 rows and
		// started loop from 70 to 93 to select Renew Instructor.
		String before_xpath = "//*[@id=\"tblUserCertification\"]/tbody/tr[";
		String after_xpath = "]/td[2]/a";
		
		for (int i = 80; i <= 113; i++) {
			String instname = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			logger.info(instname);
			if (instname.contains("Renew Instructor")) {
				WebElement elementUserCert = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//*[@id=\"tblUserCertification\"]/tbody/tr[" + i + "]/td[5]/a")));
				elementUserCert.click();
			}
			else {
				logger.info("Renew instructor not found");
			}
		}

		logger.info("*Activate Renew Instructor user *");
		Myutilities.sleepFor(2000);
		for (String wind22 : driver.getWindowHandles()) {
			driver.switchTo().window(wind22);
		}
		WebElement elementStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("status")));
		elementStatus.click();
		{
			WebElement elementStatus1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("status")));
			elementStatus1.findElement(By.xpath("//option[. = 'Active']")).click();
		}
		WebElement elementChecked = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checked")));
		elementChecked.click();
		WebElement elementBtnSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementBtnSave.click();
		

	}
	// **********Till Here*****
}

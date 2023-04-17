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

public class LCVUpgradeUser extends BaseClass {
	public LCVUpgradeUser(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logger.info("Upgrade user page initialized");
	}

	private static final Logger logger = LogManager.getLogger(LCVUpgradeUser.class);

	public void udlt() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement searchUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchUsers")));
		searchUser.click();
		searchUser.sendKeys("Lcv Test");
		searchUser.sendKeys(Keys.DOWN);
		searchUser.sendKeys(Keys.RETURN);
		WebElement elementUsers = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Users\"]/table/tbody/tr/td[3]/a")));
		Actions actions = new Actions(driver);
		actions.moveToElement(elementUsers).perform();
		WebElement elementUserClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Users\"]/table/tbody/tr/td[7]/a[2]")));
		elementUserClick.click();
		Myutilities.sleepFor(2000);
		driver.switchTo().frame(0);
		WebElement elementBtnSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementBtnSave.click();
		driver.switchTo().defaultContent();
	}

	public void susd() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementUserName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Lcv Test")));
		Actions actions = new Actions(driver);
		actions.moveToElement(elementUserName).perform();
		Thread.sleep(2000);
	}

	public void bCertclk() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementCertificatebtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Users\"]/table/tbody/tr[4]/td[5]/a[1]")));
		elementCertificatebtn.click();
		Myutilities.sleepFor(4000);
	}

	public void pinfo() throws InterruptedException {
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementShipping = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipping")));
		elementShipping.click();
		{
			WebElement shippingDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipping")));
			shippingDropdown.findElement(By.xpath("//option[. = 'Pickup at OTA']")).click();
		}
		WebElement elementCardNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cardNumber")));
		elementCardNo.sendKeys("5454545454545454");
		WebElement elementCardExp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cardExpiry")));
		elementCardExp.sendKeys("0525");
		WebElement elementPrintReceipt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("printReceipt2")));
		elementPrintReceipt.click();
		WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		saveButton.click();
		Myutilities.sleepFor(4000);
		driver.switchTo().window(winHandleBefore);
	}

	public void upgrd() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Lcv Test")));
		Actions actions = new Actions(driver);
		actions.moveToElement(elementUser).perform();
		Myutilities.sleepFor(2000);
		WebElement elementUpgrade = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Users\"]/table/tbody/tr[4]/td[7]/a[1]")));
		elementUpgrade.click();
		Myutilities.sleepFor(2000);

	}

	public void rgsdrv() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.switchTo().frame(0);
		WebElement elementLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Rush Delivery New LCV Driver")));
		elementLink.click();
		driver.switchTo().defaultContent();
		Myutilities.sleepFor(4000);
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		WebElement elementCardNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cardNumber")));
		elementCardNo.sendKeys("5454545454545454");
		WebElement elementCardExp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cardExpiry")));
		elementCardExp.sendKeys("0525");
		WebElement elementPrint2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("printReceipt2")));
		elementPrint2.click();
		WebElement elementBtnSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementBtnSave.click();
		Myutilities.sleepFor(4000);
		driver.switchTo().window(winHandleBefore);
	}

	public void rgcont() throws InterruptedException {
		driver.switchTo().frame(0);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementLcvContact = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("LCV Contact")));
		elementLcvContact.click();
		driver.switchTo().defaultContent();
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		WebElement elementDeclare = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("declare")));
		elementDeclare.click();
		WebElement elementbtnSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementbtnSave.click();
		Myutilities.sleepFor(4000);
		driver.switchTo().window(winHandleBefore);
	}

	public void rginst() throws InterruptedException {
		driver.switchTo().frame(0);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementInstructor = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Instructor - Restricted")));
		elementInstructor.click();
		driver.switchTo().defaultContent();
		Myutilities.sleepFor(2000);
	}

	public void registerinst() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		// Below code is for scrolldown till end and accept checkbox
		WebElement elementInstructor = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"instructorTerms\"]/p[16]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementInstructor);
		// till here
		WebElement elementAcceptance = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acceptance")));
		elementAcceptance.click();
		WebElement elementbtnSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementbtnSave.click();
		WebElement elementSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipping")));
		elementSave.click();
		{
			WebElement elementShipping = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shipping")));
			elementShipping.findElement(By.xpath("//option[. = 'Pickup at OTA']")).click();
		}
		WebElement elementEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		elementEmail.sendKeys("dd@tt.com");
		WebElement elementDtc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dtc_res")));
		elementDtc.click();
		elementDtc.sendKeys("test");
		WebElement elementDecRec = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("des_res")));
		elementDecRec.click();
		elementDecRec.sendKeys("tests");
		WebElement elementHrs = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hrs_res1")));
		elementHrs.click();
		elementHrs.sendKeys("24");
		WebElement elementHrsRes2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hrs_res2")));
		elementHrsRes2.click();
		elementHrsRes2.sendKeys("34");
		WebElement elementOtqRes1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("otq_res")));
		elementOtqRes1.click();
		elementOtqRes1.sendKeys("Test 1");
		WebElement elemenOteRes2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ote_res")));
		elemenOteRes2.click();
		elemenOteRes2.sendKeys("Test 11");
		WebElement als2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("eventId")));
		als2.click();
		{
			WebElement elementEvent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("eventId")));
			elementEvent.findElement(By.xpath("//option[. = '2023-04-04 Dtest R']")).click();
		}
		String path = System.getProperty("user.dir");
		WebElement elementFileName1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filename11")));
		elementFileName1.sendKeys(path + "/TestData/sample.pdf");
		WebElement elementDeclare = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("declare")));
		elementDeclare.click();
		WebElement elementCardNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cardNumber")));
		elementCardNo.click();
		elementCardNo.sendKeys("5454545454545454");
		WebElement elementCardExp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cardExpiry")));
		elementCardExp.click();
		elementCardExp.sendKeys("0525");
		WebElement elementPrintReceipt2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("printReceipt2")));
		elementPrintReceipt2.click();
		WebElement elementBtnSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementBtnSave.click();
		Myutilities.sleepFor(6000);
	}
}

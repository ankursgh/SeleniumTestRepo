package com.carriersedge.pages;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
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
import com.google.api.client.util.Lists;

public class LCVAdminhomeviewPage extends BaseClass {

	public LCVAdminhomeviewPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logger.info("LCV Admin homepageview initialized");
	}

	private static final Logger logger = LogManager.getLogger(LCVAdminhomeviewPage.class);

	public void Mgcrt() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement mgcrt1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Manage Training Plans")));
		mgcrt1.click();
		Myutilities.sleepFor(3000);
		logger.info("LCV Manage Training Plans");
	}

	public void Trpln() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement addTraining = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add New Training Plan")));
		addTraining.click();
		Myutilities.sleepFor(3000);
		logger.info("LCV Add training plan click");
		driver.switchTo().frame(0);
		WebElement elementTraining = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tPlanName")));
		elementTraining.click();
		elementTraining.sendKeys("Automation TSP");

		WebElement elementTraingPlan = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("label:nth-child(2)")));
		elementTraingPlan.click();
		
		WebElement elementAvailableUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("drvIn")));
		elementAvailableUser.click();
			Myutilities.sleepFor(3000);
		WebElement elementUserSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("drvNotIn")));
		{
			elementUserSelect.findElement(By.xpath("//option[. = 'Aks Driver - AKS_SC']")).click();
		}

		WebElement elementAddDriver = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnAddDrv")));
		elementAddDriver.click();

		WebElement elementSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementSave.click();
		driver.switchTo().defaultContent();
	}

	public void Trpln1() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement mgcrt8 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Training\"]/h2")));
		String exp3 = mgcrt8.getText();
		assertEquals("Automation TSP", exp3);
		Myutilities.sleepFor(3000);
		logger.info("Tarining plan assigned");
	}

	public void dlttp() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement dltc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Delete")));
		dltc.click();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			Myutilities.sleepFor(2000);
		}
		WebElement dlkok = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit_button")));
		dlkok.click();
	}

	public void edtplan() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement edt5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Edit")));
		edt5.click();
		{
			Actions builder = new Actions(driver);
			builder.moveToElement(edt5).perform();
		}
		{
			WebElement elements = driver.findElement(By.tagName("body"));
			Actions builder = new Actions(driver);
			builder.moveToElement(elements, 0, 0).perform();
		}
		driver.switchTo().frame(0);
		WebElement elementEdit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tPlanName")));
		elementEdit.click();
		elementEdit.clear();
		elementEdit.sendKeys("Automation TSP1");
		Myutilities.sleepFor(2000);

		WebElement elementCrossbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addCrss1")));
		elementCrossbtn.click();
		WebElement elementAvailableUsers = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("drvIn")));
		elementAvailableUsers.click();
		Myutilities.sleepFor(6000);
		WebElement elementSelectUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("drvNotIn")));
		elementSelectUser.click();
		Myutilities.sleepFor(2000);
		{
			elementSelectUser.findElement(By.xpath("//option[. = 'AKS Contact - AKS_SC']")).click();
		}
		WebElement edt9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnAddDrv")));
		edt9.click();
		Myutilities.sleepFor(2000);
		WebElement edt10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		edt10.click();
	}

	public void Mngcrt() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement mgc1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Manage Certifications")));
		mgc1.click();
	}

	public void Mngcrt1() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement mgc2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("box0")));
		mgc2.click();
		WebElement mgc3 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Currently Assigned Curriculums")));
		mgc3.click();
		WebElement mgc4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("2018 - New Driver (QC-T)")));
		mgc4.click();

		driver.switchTo().frame(0);

		WebElement mgc5 = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnClose")));
		// JavascriptExecutor executor = (JavascriptExecutor)driver;
		// executor.executeScript("arguments[0].click();", mgc5);
		mgc5.click();

		driver.switchTo().defaultContent();
		WebElement mgc21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("box0")));
		mgc21.click();

	}

	public void Mngcrt2() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement mgc6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add Certification")));
		mgc6.click();
		String parentWindowHandler1d = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			Myutilities.sleepFor(2000);
		}
		WebElement mgc7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
		mgc7.click();
		mgc7.sendKeys("Automation certification");

		WebElement mgc8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("expiry")));
		mgc8.click();
		mgc8.sendKeys("30");
		Myutilities.sleepFor(2000);
		// driver.switchTo().frame(0);
		WebElement mgc9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		mgc9.click();
		driver.switchTo().window(parentWindowHandler1d);
	}

	public void Mngcrt3() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement mgc11 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector(".heading4:nth-child(23) td:nth-child(2) > a:nth-child(1)")));
		mgc11.click();
		String parentWindowHandle = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			Myutilities.sleepFor(2000);
		}
		WebElement mgc12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("expiry")));
		mgc12.clear();
		mgc12.sendKeys("25");

		// driver.switchTo().frame(0);
		WebElement mgc13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		mgc13.click();

		driver.switchTo().window(parentWindowHandle);
		Myutilities.sleepFor(2000);
	}

	public void Mngcrt4() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement vfd2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"rightcolumn\"]/table[1]/tbody/tr[2]/td[1]/table[23]/tbody/tr/td[1]")));
		String vfdx2 = vfd2.getText();
		assertEquals("Automation certification", vfdx2);
		Myutilities.sleepFor(3000);
		logger.info("Certificate exsists");
		WebElement mgc14 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector(".heading4:nth-child(23) a:nth-child(2)")));
		mgc14.click();
		Myutilities.sleepFor(4000);
		for (String winHandlex22 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandlex22);
			Myutilities.sleepFor(3000);
		}
		WebElement mgc15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit_button")));
		mgc15.click();
	}

	public void sndeml() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement seml1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Send Email")));
		seml1.click();
	}

	public void sndeml1() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement seml2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subject")));
		seml2.click();
		seml2.sendKeys("Automation Email");
	}

	public void sndeml2() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.switchTo().frame(0);
		WebElement seml3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tinymce")));
		seml3.click();
		seml3.sendKeys("This is test email from automation.");
		driver.switchTo().defaultContent();
	}

	public void sndeml3() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement seml4 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/div[2]/div/div[3]/div[2]/div/form/table[2]/tbody/tr[3]/td[3]/input[2]")));
		seml4.click();
		WebElement mgcc16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit_button")));
		mgcc16.click();
		Myutilities.sleepFor(2000);
		for (String winHandlexi2 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandlexi2);
			Myutilities.sleepFor(3000);
		}
		WebElement mgcc15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit_button")));
		mgcc15.click();
		Myutilities.sleepFor(2000);
	}
}

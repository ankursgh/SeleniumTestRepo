package com.carriersedge.pages;

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
import com.google.api.client.util.Lists;

public class LCVAdminHomePage extends BaseClass {
	public LCVAdminHomePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logger.info("LCV Admin page initialized");
	}

	private static final Logger logger = LogManager.getLogger(LCVAdminHomePage.class);

	public void srchusr() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elxp0 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("status2")));
		elxp0.click();
		WebElement elxp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchUsers")));
		elxp.click();
		elxp.sendKeys("Automation GQtcCp");
		elxp.sendKeys(Keys.DOWN);
		elxp.sendKeys(Keys.RETURN);
		// ********
		WebElement elxp1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Users\"]/table/tbody/tr/td[2]/a")));
		// *[@id="contentbox_Users"]/table/tbody/tr/td[7]/a[2]
		Actions actions = new Actions(driver);
		actions.moveToElement(elxp1).perform();
		// Thread.sleep(4000);
		WebElement elxp2 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Users\"]/table/tbody/tr/td[7]/a[2]")));
		elxp2.click();
		Myutilities.sleepFor(2000);
		driver.switchTo().frame(0);
		WebElement elxp3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elxp3.click();
		driver.switchTo().defaultContent();
	}

	public void lcvcnt() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elm31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("LCV Contact")));
		elm31.click();
		Myutilities.sleepFor(3000);
		logger.info("LCV contact link clicked");
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	public void prmcont() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.switchTo().frame(0);
		WebElement plmt = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector(".bodyRow:nth-child(36) > .col5 > input")));
		plmt.click();
		Myutilities.sleepFor(3000);
		WebElement plmt1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		plmt1.click();
		driver.switchTo().defaultContent();
		logger.info("Primary contact clicked");
	}

	public void sdltusr() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elxp01 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("status1")));
		elxp01.click();
		WebElement elxp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchUsers")));
		elxp.click();
		elxp.sendKeys("Automation GQtcCp");
		Myutilities.sleepFor(3000);
		elxp.sendKeys(Keys.DOWN);
		elxp.sendKeys(Keys.RETURN);
		// ********
		WebElement elxp1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Users\"]/table/tbody/tr/td[2]/a")));
		// *[@id="contentbox_Users"]/table/tbody/tr/td[7]/a[2]
		Actions actions = new Actions(driver);
		actions.moveToElement(elxp1).perform();
		// Thread.sleep(4000);
		WebElement elxp2 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Users\"]/table/tbody/tr/td[7]/a[3]")));
		elxp2.click();
		Myutilities.sleepFor(2000);
		driver.switchTo().frame(0);
		WebElement elxp3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit_button")));
		elxp3.click();
		driver.switchTo().defaultContent();
		// **
	}

	public void Spdoc() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elms1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Supporting Documents")));
		elms1.click();
		logger.info("LCV supporting document link clicked");
		Myutilities.sleepFor(2000);
	}

	public void chgsts() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.switchTo().frame(0);
		WebElement elmsf1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("status31508")));
		elmsf1.click();
		Myutilities.sleepFor(2000);
		{
			elmsf1.findElement(By.xpath("//option[. = 'In Progress']")).click();
		}
		// driver.switchTo().defaultContent();
		WebElement Xp1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		Xp1.click();
		Myutilities.sleepFor(2000);
		driver.switchTo().defaultContent();
		WebElement zp1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Supporting Documents")));
		zp1.click();
		driver.switchTo().frame(0);
		WebElement elmsf2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("status31508")));
		elmsf2.click();
		{
			elmsf2.findElement(By.xpath("//option[. = 'Pending']")).click();
		}
		WebElement Xp2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		Xp2.click();
		driver.switchTo().defaultContent();
		Myutilities.sleepFor(2000);
		WebElement zp11 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Supporting Documents")));
		zp11.click();
		driver.switchTo().frame(0);
		WebElement elmsf3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("status31508")));
		elmsf3.click();
		{
			elmsf3.findElement(By.xpath("//option[. = 'Unchecked']")).click();
		}
		WebElement Xp3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		Xp3.click();
		Myutilities.sleepFor(2000);
	}

	public void pdoc() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elmss1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Supporting Documents")));
		elmss1.click();
		driver.switchTo().frame(0);
		WebElement elsv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("View")));
		elsv.click();
		logger.info("LCV supporting document link clicked");
		Myutilities.sleepFor(2000);
	}

	public void conli() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement bz = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Currently Online")));
		bz.click();
		driver.switchTo().frame(0);
		Myutilities.sleepFor(2000);
		WebElement Xp4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnClose")));
		Xp4.click();
		Myutilities.sleepFor(3000);
		driver.switchTo().defaultContent();
		logger.info("LCV currently online link clicked");
		Myutilities.sleepFor(3000);
	}

	public void lgot() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement Xp5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
		Xp5.click();
	}

	// Wallet Print functionality
	public void walnk() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement pwal1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Wallet")));
		pwal1.click();
	}

	public void nxtmth() {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.switchTo().frame(0);
		Myutilities.sleepFor(2000);
		WebElement pwal2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showOlder")));
		pwal2.click();
		Myutilities.sleepFor(2000);
		WebElement pwal3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("id")));
		pwal3.click();
		WebElement embs1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnPreview")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", embs1);
		WebElement pwal4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnPreview")));
		pwal4.click();
		Myutilities.sleepFor(2000);

		String parentWindowHandler = driver.getWindowHandle();
		String subWindowHandler = null;
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler);
		WebElement pwal5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnClose")));
		pwal5.click(); // do something
		driver.switchTo().window(parentWindowHandler);
		// driver.switchTo().window(Parent_Window);
		// Myutilities.sleepFor(2000);
		driver.switchTo().frame(0);
		WebElement pwal6 = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Select All")));
		pwal6.click();
		Myutilities.sleepFor(2000);
		WebElement embs12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnPreview")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", embs12);
		WebElement pwal14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnPreview")));
		pwal14.click();
		Myutilities.sleepFor(2000);
		String parentWindowHandler1 = driver.getWindowHandle();
		for (String winHandle1 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle1);
		}
		WebElement e1mbs12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnClose")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e1mbs12);
		WebElement p1wal14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnClose")));
		p1wal14.click();

		Myutilities.sleepFor(2000);
		driver.switchTo().window(parentWindowHandler1);
		driver.switchTo().frame(0);
		WebElement pwal69 = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Unselect All")));
		pwal69.click();
		WebElement pwal33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("id")));
		pwal33.click();
		WebElement pwal70 = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnPrint")));
		// ****************** Print popup close issue**********
		// pwal70.click();
		// ****************Till here *******************
	}

	public void Dit() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement dit1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("DIT")));
		dit1.click();
	}

	public void Ditfn() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.switchTo().frame(0);
		Myutilities.sleepFor(2000);
		WebElement dit2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showOlder")));
		dit2.click();
		Myutilities.sleepFor(2000);
		WebElement dit3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("id")));
		dit3.click();
		WebElement dit4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnPreview")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dit4);
		WebElement dit5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnPreview")));
		dit5.click();
		Myutilities.sleepFor(2000);

		String parentWindowHandlerd = driver.getWindowHandle();
		String subWindowHandlerd = null;
		Set<String> handles1 = driver.getWindowHandles();
		Iterator<String> iterator = handles1.iterator();
		while (iterator.hasNext()) {
			subWindowHandlerd = iterator.next();
		}
		driver.switchTo().window(subWindowHandlerd);
		WebElement dit6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnClose")));
		dit6.click();
		driver.switchTo().window(parentWindowHandlerd);
		;
		driver.switchTo().frame(0);
		WebElement dit7 = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Select All")));
		dit7.click();
		Myutilities.sleepFor(2000);
		WebElement dit8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnPreview")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dit8);
		WebElement dit9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnPreview")));
		dit9.click();
		Myutilities.sleepFor(2000);
		String parentWindowHandler12 = driver.getWindowHandle();
		for (String winHandle12 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle12);
		}
		WebElement dit10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnClose")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dit10);
		WebElement dit11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnClose")));
		dit11.click();
		Myutilities.sleepFor(2000);
		driver.switchTo().window(parentWindowHandler12);
		driver.switchTo().frame(0);
		WebElement dit12 = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Unselect All")));
		dit12.click();
		WebElement dit13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("id")));
		dit13.click();
		WebElement dit14 = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnPrint")));
		// ****************** Print popup close issue**********
		// dit14.click();
		// ****************Till here *******************
	}

	// Wallet Print functionality till here
	// *** LCV Manage section
	public void aphas() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement apha1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("A")));
		apha1.click();
	}

	public void aphas1() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement apha2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("All")));
		apha2.click();
	}

	public void aphas2() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement apha3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("status2")));
		apha3.click();
	}

	// *** LCV manage section till here
	// *** LCV Org structure
	public void org1() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement org1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Org Structure")));
		org1.click();
		Myutilities.sleepFor(2000);
	}

	public void org2() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement org2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("box0")));
		org2.click();
		Myutilities.sleepFor(2000);
		WebElement org3 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("#users0 .smallText:nth-child(1) strong")));
		org3.click();
		// driver.findElement(By.cssSelector("#users0 .smallText:nth-child(1)
		// strong")).click();
		Myutilities.sleepFor(2000);
		WebElement org4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".closebutton")));
		org4.click();
	}

	public void org3() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement org5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("2 assigned users")));
		org5.click();
		Myutilities.sleepFor(2000);
	}

	public void org4() {
		try {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		String parentWindowHandlerd21 = driver.getWindowHandle();
		for (String winHandle12 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle12);
		}
		WebElement elementUser = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#lstUsers tr:nth-child(3) input")));
		elementUser.click();

		// **********Auto admin dummy user moved to Automax three
		WebElement elementUserSelected = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tr:nth-child(69) input")));
		elementUserSelected.click();
		Myutilities.sleepFor(2000);
		WebElement elementSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementSave.click();
		Myutilities.sleepFor(3000);
		driver.switchTo().window(parentWindowHandlerd21);

		WebElement elementUser1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector(".heading4:nth-child(139) td:nth-child(5) > a")));
		elementUser1.click();

		Myutilities.sleepFor(2000);
		for (String winHandle121 : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle121);
		}
		WebElement elementUserSelected1 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#lstUsers tr:nth-child(2) input")));
		elementUserSelected1.click();
		Myutilities.sleepFor(2000);
		WebElement elementManager = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("manager")));
		elementManager.click();
		WebElement elemntSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elemntSave.click();
		Myutilities.sleepFor(3000);
		}
		catch(TimeoutException e) {
			e.printStackTrace();
			logger.info("an exception occurred Since I am already on the same page so it is continuous.");
		}

	}

	// *** LCV org structure till here.
	// ************* LCV manage module
	public void Mng1() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement mm1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Manage Modules")));
		mm1.click();
		Myutilities.sleepFor(2000);
	}

	public void Mng2() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement mm2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add Module")));
		mm2.click();
		Myutilities.sleepFor(2000);
	}

	@SuppressWarnings("null")
	public void Mng3() {
		for (String winHandlem : driver.getWindowHandles()) {
			driver.switchTo().window(winHandlem);
		}
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement mm3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
		mm3.sendKeys("Automation module");
		Myutilities.sleepFor(2000);
		driver.switchTo().frame(0);
		WebElement mm4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tinymce")));
		mm4.click();
		mm4.sendKeys("This is for the test.");
		Myutilities.sleepFor(2000);
		driver.switchTo().defaultContent();

		WebElement mm5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("courseObjective[]")));
		mm5.click();
		mm5.sendKeys("Automation testing");
		Myutilities.sleepFor(2000);
		WebElement mm6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("duration")));
		mm6.clear();
		mm6.sendKeys("30");

		WebElement mm7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("moduleExpiryDays")));
		mm7.clear();
		mm7.sendKeys("5");

		WebElement mm9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("moduleLimitDays")));
		mm9.clear();
		mm9.sendKeys("7");

		WebElement mm8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("moduleLimitTimes")));
		mm8.clear();
		mm8.sendKeys("7");

		Myutilities.sleepFor(2000);
		WebElement mm12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("contentTypeFile")));
		mm12.click();

		String path = System.getProperty("user.dir");
		WebElement mm10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fileName")));
		mm10.sendKeys(path + "/TestData/sample.pdf");
		Myutilities.sleepFor(3000);
		WebElement mm11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		mm11.click();
	}

	public void Mng4() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement mm12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Delete")));
		mm12.click();
		Myutilities.sleepFor(2000);
		for (String winHandlems : driver.getWindowHandles()) {
			driver.switchTo().window(winHandlems);
		}
		WebElement mm13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnDelete")));
		mm13.click();
	}
	// ************* LCV Manage modules
}

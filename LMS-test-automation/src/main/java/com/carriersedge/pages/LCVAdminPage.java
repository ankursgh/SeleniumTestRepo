package com.carriersedge.pages;

import static org.junit.Assert.assertEquals;

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
import org.openqa.selenium.support.ui.WebDriverWait;

import com.carriersedge.stepDefinitions.SelfServedLoginSteps;
import com.carriersedge.util.BaseClass;
import com.carriersedge.util.Myutilities;
import com.gargoylesoftware.htmlunit.javascript.host.Console;

public class LCVAdminPage extends BaseClass {
	public static String uss;

	public LCVAdminPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logger.info("Admin page initilized with driver");

	}

	private static final Logger logger = LogManager.getLogger(LoginPage.class);

	public void Homeclk() {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement hme = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Home")));
		hme.click();
		logger.info("Home page clicked");
	}

	public void Search() {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement srh = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchCompany")));
		srh.click();
		srh.sendKeys("AKS_Automation");
		// logger.info("Searc");
	}

	public void locationclk() {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement lc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Locations")));
		lc.click();
		logger.info("Location clicked");
	}

	public void Editclk() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement lc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Edit")));
		lc.click();
		// */
		logger.info("Edit button clicked");
	}

	public void subcomp() throws InterruptedException {

		driver.switchTo().frame(0);
		// driver.findElement(By.linkText("subcompany")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement sc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subcompany")));
		sc.click();
		driver.switchTo().defaultContent();
		// driver.findElement(By.cssSelector(".closebutton")).click();
		WebElement cbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".closebutton")));
		cbtn.click();
		logger.info("Subcompany serached");
	}

	public void Addlclk() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement adlk = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add Location")));
		adlk.click();
		logger.info("Add location button clicked");
	}

	public void Addloca() {
		{
			WebElement element = driver.findElement(By.linkText("Add Location"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		{
			WebElement element = driver.findElement(By.tagName("body"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element, 0, 0).perform();
		}
		driver.switchTo().frame(0);
		driver.findElement(By.id("locationName")).click();
		driver.findElement(By.id("locationName")).sendKeys("Aib_automation");
		driver.findElement(By.id("address1")).click();
		driver.findElement(By.id("address1")).sendKeys("B 52");
		driver.findElement(By.id("city")).click();
		driver.findElement(By.id("city")).sendKeys("Toranto");
		driver.findElement(By.id("province")).click();
		{
			WebElement dropdown = driver.findElement(By.id("province"));
			dropdown.findElement(By.xpath("//option[. = 'Alabama']")).click();
		}
		driver.findElement(By.id("btnSave")).click();
		driver.switchTo().defaultContent();
		logger.info("location added");
	}

	public void supportDashboardClose1() {
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

	public void ClkCarrier() {
		// driver.findElement(By.linkText("Carriers")).click();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement clk = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Carriers")));
		clk.click();
		logger.info("Carrier clicked");

	}

	public void ClkSubcompany() {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement clk = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add Subcompany")));
		clk.click();
		logger.info("Subcompany clicked");
	}

	public void AddSubcompany() throws InterruptedException {

		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			Thread.sleep(4000);
			// driver.findElement(By.id("btnClose")).click();
		}
		// Name
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
		name.click();
		name.sendKeys("AKS_Automation");
		Thread.sleep(2000);

		WebElement subce = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sub_code")));
		subce.click();
		subce.sendKeys("ER");
		Thread.sleep(3000);

		WebElement dropdown = driver.findElement(By.id("locNotIn"));
		dropdown.findElement(By.xpath("//option[. = 'Aic_automation']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btnAddLoc")).click();

		WebElement sve = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		Thread.sleep(4000);
		sve.click();
		driver.switchTo().window(winHandleBefore);
		logger.info("Subcompany Added");

	}

	public void save() throws InterruptedException {
		String winHandleBefore = driver.getWindowHandle();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement sve2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		sve2.click();
		driver.switchTo().window(winHandleBefore);
	}

	public void serchlocation() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement loc1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchLocation")));
		loc1.click();
		loc1.sendKeys("Aib_automation");

		WebElement loc2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Show")));
		loc2.click();
		logger.info("Location searched");

	}

	// *****************For Inner HTML****************
	public void Clkall() throws IOException {

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement allclk = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("All")));
			allclk.click();
			WebElement subcomapnytx = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"contentbox_subcompanyList\"]/div[1]/div[1]/div[1]")));
			String exp = subcomapnytx.getText();
			// Assert.assertTrue(driver.getTitle().equalsIgnoreCase("CarriersEdge Login -
			// CarriersEdge"));
			assertEquals("AKS_Automation", exp);
			logger.info("**************Click all clicked**************");

		} catch (Exception e) {
			String page = driver.getPageSource();

			logger.info(page);
			FileUtils.copyFile(file, new File("./Logs/headless_screenshot.png"));
		}
	}

	// *****************For Inner HTML****************
	public void Lclkall() throws IOException {

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			WebElement allclk1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("All")));
			allclk1.click();
			WebElement locs = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_location\"]/div[1]/div[1]/div[1]")));
			String exp2 = locs.getText();

			assertEquals("Aib_automation", exp2);
			logger.info("**************Click all location clicked**************");

		} catch (Exception e) {
			String page = driver.getPageSource();

			logger.info(page);
			FileUtils.copyFile(file, new File("./Logs/headless_screenshot.png"));
		}
	}

	public void clkal() throws IOException {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement allclk1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("All")));
		allclk1.click();
		logger.info("Click all on location clicked");

	}

	public void Clkdlt() throws InterruptedException {

		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement dlt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Delete")));
		dlt.click();

		Thread.sleep(4000);
		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			Thread.sleep(4000);
			// driver.findElement(By.id("btnClose")).click();
		}
		// Perform the actions on new window
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,450)", "");
		// WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement clks = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		clks.click();
		Thread.sleep(8000);
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		logger.info("Confirm Delete button clicked");

	}

	public void Dltloc() throws InterruptedException {

		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement dlts = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Delete")));
		dlts.click();
		Thread.sleep(4000);
		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			Thread.sleep(4000);
			// driver.findElement(By.id("btnClose")).click();
		}

		// Perform the actions on new window
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,450)", "");
		// WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement clks = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit_button")));
		clks.click();
		Thread.sleep(8000);
		driver.switchTo().window(winHandleBefore);
		logger.info("Confirm Delete location button clicked");
	}

	public void searchcompany() throws InterruptedException {

		driver.findElement(By.id("searchCompany")).click();
	}

	public void selectcompany() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement sltc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchCompany")));
		sltc.click();
		sltc.sendKeys("AKS_SC");
		Thread.sleep(2000);
		sltc.sendKeys(Keys.DOWN);
		sltc.sendKeys(Keys.RETURN);
		Thread.sleep(4000);

	}

	public void sUser() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement unt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Aks Driver")));
		Thread.sleep(2000);

	}

	public void btnCert() throws InterruptedException {
		String Expectedtooltip = "Order reprint of certificate";
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement btnc = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Users\"]/table/tbody/tr[2]/td[5]/a[1]")));

		String cert = btnc.getAttribute("title");
		// ***********************Get Tooltip Txt******************
		assertEquals(Expectedtooltip, cert);
		// tooltip action
		/*
		 * Actions actions = new Actions(driver); actions.moveToElement(btnc).perform();
		 * String cert=btnc.getAttribute("title"); logger.info(cert);
		 * Thread.sleep(4000); assertEquals("Order reprint of certificate", cert);
		 */
	}

	public void details() throws InterruptedException {

		String expt = "er.aks.driver.lcv";
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.switchTo().frame(0);
		WebElement dtl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fld_username")));
		dtl.click();
		Thread.sleep(2000);
		String tx = dtl.getText();
		assertEquals(expt, tx);
	}

	public void viewprofile() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement prof = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Aks Driver")));
		prof.click();
	}

	public void viewdoc() throws InterruptedException {

		String winHandleBefore = driver.getWindowHandle();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		// driver.switchTo().frame(0);
		WebElement dtl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("View")));
		dtl.click();
		Thread.sleep(2000);
		driver.switchTo().window(winHandleBefore);
		Thread.sleep(2000);
		// driver.findElement(By.cssSelector(".closebutton")).click();
		// Thread.sleep(3000);
		// String tx = dtl.getText();
		// assertEquals(expt, tx);

	}

	public void clbtn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement clb = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".closebutton")));
		clb.click();
	}

	public void edtl() throws InterruptedException {

		WebElement element = driver.findElement(By.xpath("//*[@id=\"contentbox_Users\"]/table/tbody/tr[2]/td[3]/a"));
		// Actions builder = new Actions(driver);
		// builder.moveToElement(element).perform();
		element.click();

	}

	// *******Instructor role***********
	public void sInst() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement sltc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchUsers")));
		sltc.clear();
		sltc.sendKeys("Dtest 863");
		Thread.sleep(2000);
		sltc.sendKeys(Keys.DOWN);
		sltc.sendKeys(Keys.RETURN);
		Thread.sleep(4000);
	}

	public void ibtnCert() throws InterruptedException {
		String Expectedtooltip = "Order reprint of certificate";
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement btnc = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Users\"]/table/tbody/tr[1]/td[5]/a[1]")));
		String cert = btnc.getAttribute("title");
		assertEquals(Expectedtooltip, cert);
	}

	public void instprofile() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement prof = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Dtest 863")));
		prof.click();
	}

	// **********ENd******************
	public void slcusr() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement usrol = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("A")));
		usrol.click();
		// WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement usrol1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("User")));
		usrol1.click();
		Myutilities.sleepFor(2000);
	}

	public void lckusr() throws InterruptedException {
		// *********Dynamic element
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0,600)");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement sw = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchUsers")));
		sw.click();
		sw.sendKeys("Aks Driver");
		sw.sendKeys(Keys.DOWN);
		sw.sendKeys(Keys.RETURN);

		// WebDriverWait wait = new WebDriverWait(driver,30);
		// *******gdgffdg
		WebElement lck = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Users\"]/table/tbody/tr/td[2]/a")));

		Actions actions = new Actions(driver);
		actions.moveToElement(lck).perform();
		// Thread.sleep(4000);
		WebElement lck1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Users\"]/table/tbody/tr/td[7]/a[3]")));

		lck1.click();
	}

	public void lck() throws InterruptedException {

		driver.switchTo().frame(0);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement lckclk = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		lckclk.click();
		driver.switchTo().defaultContent();

	}

	public void vlck() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		String Expectedtooltip = "Unlock this individual in the program.";
		WebElement alcks = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Users\"]/table/tbody/tr/td[2]/a")));
		Actions actions = new Actions(driver);
		actions.moveToElement(alcks).perform();
		Myutilities.sleepFor(4000);
		WebElement ulcks = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Users\"]/table/tbody/tr/td[7]/a[3]")));
		Myutilities.sleepFor(4000);
		String lckms = ulcks.getAttribute("title");
		assertEquals(Expectedtooltip, lckms);
	}

	public void unlckusr() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement alck = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Users\"]/table/tbody/tr/td[2]/a")));
		Actions actions = new Actions(driver);
		actions.moveToElement(alck).perform();
		// Thread.sleep(4000);
		WebElement lck2 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Users\"]/table/tbody/tr/td[7]/a[3]")));
		Thread.sleep(4000);
		lck2.click();
		// WebDriverWait wait = new WebDriverWait(driver,30);

	}

	public void logoutclk() throws InterruptedException {

		driver.findElement(By.linkText("Logout")).click();

	}

	public void modulesusr() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// Element AKS_LC
		WebElement plck = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Users\"]/table/tbody/tr[3]/td[3]/a")));
		Actions actions = new Actions(driver);
		actions.moveToElement(plck).perform();
		// Thread.sleep(4000);
		WebElement xlck1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Users\"]/table/tbody/tr[3]/td[7]/a[1]")));
		xlck1.click();
		Myutilities.sleepFor(2000);
		driver.switchTo().frame(0);
		WebElement chkb = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"confirmRefresher\"]/div[1]/div[4]/label")));
		chkb.click();
		Myutilities.sleepFor(2000);
		WebElement okclk = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		okclk.click();
		driver.switchTo().defaultContent();

	}

	public void vrfmodule() throws InterruptedException {

		String ExpTxt = "LCV Driver Examination 2018";
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement vTxt = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Training\"]/div/div[1]")));
		String vAct = vTxt.getText();
		assertEquals(ExpTxt, vAct);

	}

	public void clspup() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement cpop = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[1]/div/div[2]")));
		cpop.click();
	}

	public void dltuser() throws InterruptedException {
		// element AKS_LC dynamic element
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement hvr = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Users\"]/table/tbody/tr[3]/td[3]/a")));
		Actions actions = new Actions(driver);
		actions.moveToElement(hvr).perform();
		// Thread.sleep(4000);
		WebElement hvr1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Users\"]/table/tbody/tr[3]/td[7]/a[4]")));
		hvr1.click();
		Myutilities.sleepFor(2000);
		driver.switchTo().frame(0);
		WebElement okclk1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"confirmDeleteUser\"]/table[2]/tbody/tr[3]/td[2]/input")));
		okclk1.click();
		driver.switchTo().defaultContent();
		WebElement rdbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("status2")));
		rdbtn.click();
		Myutilities.sleepFor(4000);
	}

	public void undelete() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement rdbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("status2")));
		rdbtn.click();
		Myutilities.sleepFor(4000);
		// **********
		WebElement sws = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchUsers")));
		sws.click();
		sws.sendKeys("Aks Driver");
		sws.sendKeys(Keys.DOWN);
		sws.sendKeys(Keys.RETURN);

		// WebDriverWait wait = new WebDriverWait(driver,30);
		// *******gdgffdg
		WebElement lcks = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Users\"]/table/tbody/tr/td[2]/a")));

		Actions actions = new Actions(driver);
		actions.moveToElement(lcks).perform();
		// Thread.sleep(4000);
		WebElement lcsk1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Users\"]/table/tbody/tr/td[7]/a[3]")));

		lcsk1.click();
		// **********
		/*
		 * //******User AKS Driver** WebElement elm1 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//*[@id=\"contentbox_Users\"]/table/tbody/tr/td[3]/a"))); Actions actions =
		 * new Actions(driver); actions.moveToElement(elm1).perform();
		 * //Thread.sleep(4000); WebElement elm2 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//*[@id=\"contentbox_Users\"]/table/tbody/tr/td[7]/a[3]"))); elm2.click();
		 */
		// *******************
		Myutilities.sleepFor(2000);
		driver.switchTo().frame(0);
		WebElement clkok = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		clkok.click();
		driver.switchTo().defaultContent();
		// ********
	}

	// **** License validation
	public void agencynme(String unme) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement agy = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("agency")));
		agy.click();
		agy.sendKeys(unme);
	}

	public void bgnumber(String bdgn) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement bdg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("badge")));
		bdg.click();
		bdg.sendKeys(bdgn);
	}

	public void crtno(String ctn) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement crtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("certNumber")));
		crtn.click();
		crtn.sendKeys(ctn);
	}

	public void nme(String nmc) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement nme = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
		nme.click();
		nme.sendKeys(nmc);
	}

	public void svbtn() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement svbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		svbtn.click();
		logger.info("Save button clicked");

	}

	public void vrlse() {
		String Extxt = "Not Found";
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement ivld = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".invalid")));
		// ivld.getText();
		String ivlds = ivld.getText();
		assertEquals(Extxt, ivlds);
	}

	// *****vldse
	public void vldse() {
		String Extx = "Valid";
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement ivl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".valid")));
		// ivld.getText();
		String ilds = ivl.getText();
		assertEquals(Extx, ilds);
	}

	public void mrlnk() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement mrcl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("More...")));
		mrcl.click();
		logger.info("More link clicked");
	}

	public void outsearch() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement outsrch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Outside Searches")));
		outsrch.click();
		logger.info("Out side search clicked");
	}

	public void bxdte() {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement bxdte = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("boxDate")));
		bxdte.click();
	}

	public void pstwk() {
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript(script, args);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement psw = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"dateDetail\"]/td[2]/table/tbody/tr[2]/td/a[1]")));
		psw.click();
		logger.info("Past week report generated");
	}

	public void rptclk() {
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript(script, args);
		String winHandleBefore = driver.getWindowHandle();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement rpt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buildReport")));
		rpt.click();
		Myutilities.sleepFor(2000);
		driver.switchTo().window(winHandleBefore);
		logger.info("Report genarated");
	}

	public void rstf() {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement rst = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"rptDone\"]/td[2]/table/tbody/tr[2]/td[2]/p[3]/a")));
		rst.click();
		Myutilities.sleepFor(2000);
		// driver.switchTo().window(winHandleBefore);
	}

	public void chkb() {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement chkb = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dateAll")));
		chkb.click();
		Myutilities.sleepFor(2000);
		logger.info("checkbox clicked");
		// driver.switchTo().window(winHandleBefore);
	}
	// ***********LCV Add Admin page

	public String generateRandomString(int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}

	public void adclk() {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement admn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Admin")));
		admn.click();
		driver.switchTo().frame(0);
		Myutilities.sleepFor(2000);
		// driver.switchTo().window(winHandleBefore);
	}

	public void ftnme() {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement fsnme = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
		fsnme.click();
		fsnme.sendKeys("automation");
		Myutilities.sleepFor(2000);
	}

	public void lsnme() {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement lsnme = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName")));
		lsnme.click();
		lsnme.sendKeys("" + generateRandomString(5));
		Myutilities.sleepFor(2000);
	}

	public void uemail() {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement emls = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		emls.click();
		emls.sendKeys("test@email.com");
		Myutilities.sleepFor(2000);
	}

	public void paswd() {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		elementPassword.click();
		elementPassword.sendKeys("test");
		Myutilities.sleepFor(2000);
	}

	public void paswdh() {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementPasswordHint = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordHint")));
		elementPasswordHint.click();
		elementPasswordHint.sendKeys("test");
		Myutilities.sleepFor(2000);
	}

	public void bsve() {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement bve = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		bve.click();
		Myutilities.sleepFor(2000);
	}

	public String gtuname() {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement gtunms = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		uss = gtunms.getAttribute("value");
		logger.info(uss);
		Myutilities.sleepFor(2000);
		return uss;
	}

	public void rolasn() {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		WebElement rlas1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Organizational")));
		rlas1.click();
		Myutilities.sleepFor(2000);
		WebElement rlas2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("roles")));
		rlas2.click();
		{
			// WebElement dropdownx = driver.findElement(By.id("roles"));
			rlas2.findElement(By.xpath("//option[. = 'Admin']")).click();
		}
		Myutilities.sleepFor(2000);

	}

	public void srcusr() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement susrs = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchUsers")));
		susrs.click();
		logger.info(uss);
		susrs.sendKeys(uss);
		susrs.sendKeys(Keys.DOWN);
		susrs.sendKeys(Keys.RETURN);
		// ********
		WebElement els2 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Users\"]/table/tbody/tr/td[3]/a")));
		Actions actions = new Actions(driver);
		actions.moveToElement(els2).perform();
		// Thread.sleep(4000);
		WebElement els3 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Users\"]/table/tbody/tr/td[7]/a[3]")));

		els3.click();
		Myutilities.sleepFor(2000);
		driver.switchTo().frame(0);
		WebElement els4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit_button")));
		els4.click();
		driver.switchTo().defaultContent();
		// ********
	}
	// Till here
}
// Dynamic element AKS_Driver & AKS_LC
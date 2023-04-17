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

public class LCVRunDailyBatchPage extends BaseClass {
	public LCVRunDailyBatchPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logger.info("LCV Daily Batch Run Page Initialized");
	}

	private static final Logger logger = LogManager.getLogger(LCVRunDailyBatchPage.class);

	public void dailybtc1() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementRunButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Run Batch Jobs")));
		elementRunButton.click();
		Myutilities.sleepFor(2000);
		logger.info("Run Batch Jobs clicked");
	}

	public void dailybtc2() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementConfirm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tr:nth-child(10) .popUp")));
		elementConfirm.click();
		Myutilities.sleepFor(4000);
		for (String winHandlex : driver.getWindowHandles()) {
			driver.switchTo().window(winHandlex);
		}
		WebElement elementRunButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnRun")));
		elementRunButton.click();
		logger.info("Run button clicked");
	}

	public void dailybtc3() {
		try {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		// xpath of "Traing 1" event.
		WebElement elemenetEventName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"rightcolumn\"]/table[3]/tbody/tr[2]/td/table[1]/tbody/tr/td[1]")));																						 
																											
		String expText = elemenetEventName.getText();
		assertEquals("Traing 1", expText);													  
		WebElement elementEvent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"rightcolumn\"]/table[3]/tbody/tr[2]/td/table[1]/tbody/tr/td[1]/a")));
																									  
		elementEvent.click();
		logger.info("Past event clicked");
		Myutilities.sleepFor(2000);
		}
		catch(TimeoutException e) {
			e.printStackTrace();
			logger.info("an exception occurred..");
		}
	}

	public void dailybtc4() {
		try {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementEventUsers = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Currently Registered and Waiting Users")));
		elementEventUsers.click();
		WebElement rub4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"drivers2\"]/td/table/tbody/tr[2]/td[1]/a")));
		String expectedTxt = rub4.getText();
		assertEquals("Automax Driver", expectedTxt);
		logger.info("Waiting list user clicked");
		}
		catch (TimeoutException e) {
			e.printStackTrace();
			logger.info("an exception occurred...");
		}
	}

	public void dailybtc5() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementSearchUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchUsers")));
		elementSearchUser.click();
		Myutilities.sleepFor(2000);
		elementSearchUser.sendKeys("Test Instructor");
		elementSearchUser.sendKeys(Keys.DOWN);
		elementSearchUser.sendKeys(Keys.RETURN);
		WebElement elementUsers = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contentbox_Users\"]/table/tbody/tr/td[4]/div[1]")));
		Actions actions = new Actions(driver);
		actions.moveToElement(elementUsers).perform();
		Myutilities.sleepFor(2000);
		String expTooltip = "This certificate is valid and up to date.";
		String expectedText = elementUsers.getAttribute("title");
		System.out.println(expectedText);
		logger.info("Test Instructor selected");
	}

	public void dailybtc6() {
		try {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementAvailableUsers = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("You have users eligible for certification.")));
		elementAvailableUsers.click();
		WebElement elementCertUsers = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tblUserCertification\"]/tbody/tr[32]/td[2]/a")));
		elementCertUsers.click();
		Myutilities.sleepFor(2000);
		logger.info("User certification clicked");
		}
		catch (TimeoutException e) {
			e.printStackTrace();
			logger.info("an exception occurred...");
		}
	}

	public void dailybtc7() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementUserList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tr:nth-child(27) > .underlineSolid:nth-child(5) > a")));
		Actions builder = new Actions(driver);
		builder.moveToElement(elementUserList).perform();
		Myutilities.sleepFor(1000);
		elementUserList.click();
		Myutilities.sleepFor(3000);
		for (String win1 : driver.getWindowHandles()) {
			driver.switchTo().window(win1);
		}
		WebElement nvz4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("status")));
		nvz4.click();
		{
			WebElement statusDropdown = driver.findElement(By.id("status"));
			statusDropdown.findElement(By.xpath("//option[. = 'Active']")).click();
		}
		WebElement elementChecked = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checked")));
		elementChecked.click();
		WebElement elementBtnSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
		elementBtnSave.click();
		Myutilities.sleepFor(3000);
		logger.info("User clicked");
	}
	
}

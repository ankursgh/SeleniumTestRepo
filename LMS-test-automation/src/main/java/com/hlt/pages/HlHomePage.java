package com.hlt.pages;
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

public class HlHomePage extends BaseClass {
	public HlHomePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logger.info("Hl home page initialized");
	}

	private static final Logger logger = LogManager.getLogger(HlHomePage.class);
	public void cookiesHide() {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement cookieAccept = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("I understand, hide this message."))); 
		cookieAccept.click();
	
	}
	public void serviceLinkClick() {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement serviceLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("SERVICES")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", serviceLink);
		serviceLink.click();
		logger.info("Service Page clicked");
		
	}
	public void verifyServices() {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement findText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[2]/form[1]/div[3]/div[2]/div[2]/div[1]/div[1]/ul[1]/li[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h3[1]")));
		String expectedText = findText.getText();
		assertEquals("Houlihan Lokey is a global investment bank with expertise in mergers and acquisitions, capital markets, financial restructuring, and financial and valuation advisory.", expectedText);
	
	}
	public void industryCoveragePage() {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement industryCoverage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("INDUSTRY COVERAGE")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", industryCoverage);
		industryCoverage.click();
	
	}
	public void verifyIndustry() {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement findText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[2]/form[1]/div[3]/div[2]/div[2]/div[1]/div[1]/ul[1]/li[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h3[1]")));
		String expectedText = findText.getText();
		assertEquals("Our global industry coverage model brings sector-specific knowledge, experience, and relationships to every client we work with.", expectedText);
	
	}
}

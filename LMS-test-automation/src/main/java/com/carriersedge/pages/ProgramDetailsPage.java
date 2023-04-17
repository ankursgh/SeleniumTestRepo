package com.carriersedge.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.carriersedge.util.BaseClass;

public class ProgramDetailsPage extends BaseClass {

	public ProgramDetailsPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logger.info("ProgramDetailsPage initializes");
	}

	private static final Logger logger = LogManager.getLogger(ProgramDetailsPage.class);

	@FindBy(id = "tPlanName")
	WebElement programName;
	@FindBy(id = "tPlanNameFR")
	WebElement programFrenchName;
	@FindBy(xpath = "//a[@class='addFrenchName']")
	WebElement addfrenchName;
	@FindBy(id = "programType")
	WebElement programTypeDD;

	// @FindBy(id = "startDateType1") WebElement programStartDateImmediately; //the
	// same element is in programsPage so use it from programsPage
	public void addProgramName(String progName) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(programName));
		foo.clear();
		foo.sendKeys(progName);
		logger.info("New Program name typed: " + progName);
	}

	public void clickaddFrenchName() {
		addfrenchName.click();
	}

	public void addProgramFrenchName(String progName) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(programFrenchName));
		foo.clear();
		foo.sendKeys(progName);
		logger.info("New Program Name in french Typed: " + progName);
	}

	public void selectProgramType(String type) {
		new Select(programTypeDD).selectByVisibleText(type);
	}
	// the same function is in programsPage so use from programsPage
	/*
	 * public void selectProgramAvailableImmediately() {
	 * programStartDateImmediately.click(); }
	 */

	public String[] getSelectedUsers() {
		List<WebElement> eles = driver
				.findElements(By.xpath("//div[contains(@class,'click-selected') and contains(@id,'user')]"));
		logger.info("array size: " + eles.size());
		String[] names = new String[eles.size()];
		for (int i = 0; i < eles.size(); i++) {
			names[i] = eles.get(i).getText();
		}
		return names;
	}

	public String[] getSelectedModules() {
		List<WebElement> eles = driver
				.findElements(By.xpath("//div[contains(@class,'click-selected') and contains(@id,'module')]"));
		logger.info("array size: " + eles.size());
		String[] modules = new String[eles.size()];
		for (int i = 0; i < eles.size(); i++) {
			modules[i] = eles.get(i).getText();
		}
		return modules;
	}

}

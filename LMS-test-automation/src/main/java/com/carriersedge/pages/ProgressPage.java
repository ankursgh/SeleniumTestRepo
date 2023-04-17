package com.carriersedge.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.carriersedge.util.BaseClass;
import com.carriersedge.util.Myutilities;

public class ProgressPage extends BaseClass {

	public ProgressPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logger.info("Progress Page initializes");
	}

	private static final Logger logger = LogManager.getLogger(ProgressPage.class);

	// @FindBy(xpath = "//a[@href='progress/activity']") WebElement activities;
	@FindBy(xpath = "//a[@data-maintext='Activities']")
	WebElement activities;
	@FindBy(xpath = "//a[@href='selector?id=userProgress']")
	WebElement progressPeopleNumber;
	@FindBy(xpath = "//a[@href='selector?id=dateProgress']")
	WebElement dateProgressPeriod;
	@FindBy(xpath = "//a[@data-maintext='Status']")
	WebElement Status;
	@FindBy(xpath = "//a[@data-maintext='Progress']")
	WebElement Progress;
	@FindBy(xpath = "//a[@data-maintext='Survey']")
	WebElement Survey;
	@FindBy(xpath = "//a[@href='progress/certification']")
	WebElement Certificates;
	public void clickActivitiesIcon() {
		// WebDriverWait wait = new WebDriverWait(driver, 20);
		// WebElement ele = wait.until(ExpectedConditions.visibilityOf(activities));
		// ele.click();
		Actions action = new Actions(driver);
		action.moveToElement(activities).build().perform();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		activities.click();
	}
	
	public void clickStatusIcon() {
		
		Actions action = new Actions(driver);
		action.moveToElement(Status).build().perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Status.click();
	}
public void clickProgressIcon() {
		
		Actions action = new Actions(driver);
		action.moveToElement(Progress).build().perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Progress.click();
	}
public void clickSurveyIcon() {
	
	Actions action = new Actions(driver);
	action.moveToElement(Survey).build().perform();
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	Survey.click();
}
public void clickCertIcon() {
	
	Actions action = new Actions(driver);
	action.moveToElement(Certificates).build().perform();
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	Certificates.click();
}
	public void clickProgressPeopleNumber() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement ele = wait.until(ExpectedConditions.visibilityOf(progressPeopleNumber));
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		ele.click();
	}

	public void clickPeriod() {
		dateProgressPeriod.click();
	}

	public String getGrade(String userId) {
		int i = 0;
		while (i < 6 && driver.findElements(By.xpath("//a[@href='progress/activity?userProgress=user-" + userId
				+ "'] /ancestor::tr /td[contains(@class,'grade')]")).size() == 0) {
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			logger.info("250 ms waited");
			i++;
		}
		WebElement ele = driver.findElement(By.xpath("//a[@href='progress/activity?userProgress=user-" + userId
				+ "'] /ancestor::tr /td[contains(@class,'grade')]"));
		return ele.getText();
	}

	public void clickUserCertificate(String userId) {
		driver.findElement(By.xpath("//a[@href='progress/activity?userProgress=user-" + userId
				+ "']//ancestor::tr /td/a[contains(.,'View Certificate')]")).click();
	}

	public Boolean certificateContained(String name, String programName, String date) {
		int i = 0;
		while (i < 6 && driver.findElements(By.xpath("//div[@class='driverName']")).size() == 0) {
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			logger.info("250 ms waited");
			i++;
		}

		Boolean boo1 = driver.findElement(By.xpath("//div[@class='driverName']")).getText().equalsIgnoreCase(name);
		logger.info("Name: " + driver.findElement(By.xpath("//div[@class='driverName']")).getText());
		Boolean boo2 = driver.findElement(By.xpath("//div[@class='courseName']")).getText()
				.equalsIgnoreCase(programName);
		logger.info("Name: " + driver.findElement(By.xpath("//div[@class='courseName']")).getText());
		Boolean boo3 = driver.findElement(By.xpath("//span[@class='dateOnly']")).getText().equalsIgnoreCase(date);
		logger.info("Name: " + driver.findElement(By.xpath("//span[@class='dateOnly']")).getText());
		return boo1 && boo2 && boo3;
	}
	public void walletClick() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement wlt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".walletCard")));
		wlt.click();
		WebElement wlt1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnClose")));
		wlt1.click();
		Myutilities.sleepFor(3000);
	}
	public void editClick() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement evl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"progress\"]/div/div[2]/section/table/tbody/tr/td[9]")));
		Actions actions = new Actions(driver);
		actions.moveToElement(evl).build().perform();
		Myutilities.sleepFor(1000);
		WebElement ed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Edit")));
		ed.click();
		WebElement ed1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnClose")));
		ed1.click();
	}
    public void period() throws InterruptedException {
		
    	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement pers = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"progress\"]/div/div[1]/div/div[3]/div[2]/a")));
		pers.click();
		WebElement pers1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Year")));
		pers1.click();
		WebElement pers2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnSave")));
		pers2.click();
		Myutilities.sleepFor(3000);
	}
  public void periodWeek() throws InterruptedException {
		
    	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement pers4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"progress\"]/div/div[1]/div/div[3]/div[2]/a")));
		pers4.click();
		WebElement pers5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Week")));
		pers5.click();
		WebElement pers6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnSave")));
		pers6.click();
		Myutilities.sleepFor(3000);
	}
  public void periodMonth() throws InterruptedException {
		
  	    WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement pers4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"progress\"]/div/div[1]/div/div[3]/div[2]/a")));
		pers4.click();
		WebElement pers5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Month")));
		pers5.click();
		WebElement pers6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnSave")));
		pers6.click();
		Myutilities.sleepFor(3000);
	}
  public void periodQuarter() throws InterruptedException {
		
	  	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement pers4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"progress\"]/div/div[1]/div/div[3]/div[2]/a")));
		pers4.click();
		WebElement pers5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Quarter")));
		pers5.click();
		WebElement pers6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnSave")));
		pers6.click();
		Myutilities.sleepFor(3000);
		}
  public void periodYear() throws InterruptedException {
		
	  	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement pers4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"progress\"]/div/div[1]/div/div[3]/div[2]/a")));
		pers4.click();
		WebElement pers5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Year")));
		pers5.click();
		WebElement pers6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnSave")));
		pers6.click();
		Myutilities.sleepFor(3000);
		}
  public void includeuname() throws InterruptedException {
		
	  	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement pers7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("None")));
		pers7.click();
		WebElement pers8 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showUsernames")));
		pers8.click();
		Myutilities.sleepFor(2000);
		WebElement pers10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnSave")));
		pers10.click();
		Myutilities.sleepFor(3000);
		}
  public void swPersonal() throws InterruptedException {
		
	  	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement pers11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("1")));
		pers11.click();
		WebElement pers12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showUsernames")));
		pers12.click();
		WebElement pers13 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showPersonalInfo")));
		pers13.click();
		Myutilities.sleepFor(2000);
		WebElement pers14 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnSave")));
		pers14.click();
		Myutilities.sleepFor(3000);
		}
  public void inPeople() throws InterruptedException {
		
	  	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement pers15 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("1")));
		pers15.click();
		WebElement pers16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showPersonalInfo")));
		pers16.click();
		WebElement pers17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showNoData")));
		pers17.click();
		Myutilities.sleepFor(2000);
		WebElement pers18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnSave")));
		pers18.click();
		Myutilities.sleepFor(3000);
		}
  public void deletePeople() throws InterruptedException {
	  
	  	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement pers19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("1")));
		pers19.click();
		WebElement pers20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showNoData")));
		pers20.click();
		WebElement pers21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showInactive")));
		pers21.click();
		Myutilities.sleepFor(2000);
		WebElement pers22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnSave")));
		pers22.click();
		Myutilities.sleepFor(3000);
		}
  public void progAssgn() throws InterruptedException {
		
	  	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement pers23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("1")));
		pers23.click();
		WebElement pers24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showInactive")));
		pers24.click();
		WebElement pers25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showUnassignedPrograms")));
		pers25.click();
		Myutilities.sleepFor(2000);
		WebElement pers26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnSave")));
		pers26.click();
		Myutilities.sleepFor(3000);
		}
  public void showProg() throws InterruptedException {
		
	  	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement pers23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("1")));
		pers23.click();
		WebElement pers24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showUsernames")));
		pers24.click();
		WebElement pers25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showUnassignedPrograms")));
		pers25.click();
		Myutilities.sleepFor(2000);
		WebElement pers26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnSave")));
		pers26.click();
		Myutilities.sleepFor(3000);
		}
  public void progAssn() throws InterruptedException {
		
	  	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement pers27 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("1")));
		pers27.click();
		WebElement pers29 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showUnassignedPrograms")));
		pers29.click();
		WebElement pers30 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showVariations")));
		pers30.click();
		Myutilities.sleepFor(2000);
		WebElement pers31 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnSave")));
		pers31.click();
		Myutilities.sleepFor(3000);
		}
  public void detResul() throws InterruptedException {
		
	  	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement pers32 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("1")));
		pers32.click();
		WebElement pers33 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showVariations")));
		pers33.click();
		WebElement pers34 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showDetail")));
		pers34.click();
		Myutilities.sleepFor(2000);
		WebElement pers35 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnSave")));
		pers35.click();
		Myutilities.sleepFor(3000);
		}
  public void deRes() throws InterruptedException {
		
	  	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement pers36 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("1")));
		pers36.click();
		WebElement pers37 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showDetail")));
		pers37.click();
		WebElement pers38 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showRecent")));
		pers38.click();
		Myutilities.sleepFor(2000);
		WebElement pers39 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnSave")));
		pers39.click();
		Myutilities.sleepFor(3000);
		}
  public void showRes() throws InterruptedException {
		
	  	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement pers40 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("1")));
		pers40.click();
		WebElement pers41 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showRecent")));
		pers41.click();
		WebElement pers42 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showAllResults")));
		pers42.click();
		Myutilities.sleepFor(2000);
		WebElement pers43 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnSave")));
		pers43.click();
		Myutilities.sleepFor(3000);
		}
  public void showRestest() throws InterruptedException {
		
	  	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement pers44 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("1")));
		pers44.click();
		WebElement pers45 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showAllResults")));
		pers45.click();
		WebElement pers46 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showTests")));
		pers46.click();
		Myutilities.sleepFor(2000);
		WebElement pers47 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnSave")));
		pers47.click();
		Myutilities.sleepFor(3000);
		}
  public void showMod() throws InterruptedException {
		
	  	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement pers48 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("1")));
		pers48.click();
		WebElement pers49 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showTests")));
		pers49.click();
		WebElement pers50 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showCompleted")));
		pers50.click();
		Myutilities.sleepFor(2000);
		WebElement pers51 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnSave")));
		pers51.click();
		Myutilities.sleepFor(3000);
		}
  public void clkProg() throws InterruptedException {
		
	  	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementProgram = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("None")));
		Actions builder = new Actions(driver);
	    builder.moveToElement(elementProgram).perform();
	    elementProgram.click();
		Myutilities.sleepFor(3000);
		}
  public void slctProg() throws InterruptedException {
		
	  	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement sta2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("program-23238")));
	    sta2.click();
	    WebElement sta3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnSave")));
	    sta3.click();
		Myutilities.sleepFor(3000);
		}
  public void slctSurvey() throws InterruptedException {
		
	  	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementSurvey = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("module-2764")));
		elementSurvey.click();
	    WebElement elementSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnSave")));
	    elementSave.click();
		Myutilities.sleepFor(3000);
		}
  public void clkalProg() throws InterruptedException {
		
	  	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement sta2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("1 Program")));
		Actions builder2 = new Actions(driver);
	    builder2.moveToElement(sta2).perform();
	    sta2.click();
		Myutilities.sleepFor(3000);
		}
  
  public void clkalProg1() throws InterruptedException {
	  	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement sta4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("All")));
		Actions builder2 = new Actions(driver);
	    builder2.moveToElement(sta4).perform();
	    sta4.click();
		Myutilities.sleepFor(3000);
		WebElement stac2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-navaauto.476")));
	    stac2.click();
	    WebElement stax2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-navaauto.477")));
	    stax2.click();
		}
  public void clkopt() throws InterruptedException {
		
	  	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement stab2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"progress\"]/div/div[1]/div[1]/div[5]/div[2]/a")));
		Actions builder21 = new Actions(driver);
	    builder21.moveToElement(stab2).perform();
	    stab2.click();
		Myutilities.sleepFor(3000);
		}
  public void clkOpti() throws InterruptedException {
		
	  	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement stan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"progress\"]/div/div[1]/div/div[4]/div[2]/a")));
		Actions buildr21 = new Actions(driver);
		buildr21.moveToElement(stan).perform();
		stan.click();
	  
		Myutilities.sleepFor(3000);
		}
  public void inclnme() throws InterruptedException {
		
	  	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement pers48 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showUsernames")));
		pers48.click();
		Myutilities.sleepFor(2000);
		WebElement pers10 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnSave")));
		pers10.click();
		Myutilities.sleepFor(3000);
		}
  public void deltPple() throws InterruptedException {
	  
	  	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement pers19 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("1")));
		pers19.click();
		WebElement pers20 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showPersonalInfo")));
		pers20.click();
		WebElement pers21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showInactive")));
		pers21.click();
		Myutilities.sleepFor(2000);
		WebElement pers22 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnSave")));
		pers22.click();
		Myutilities.sleepFor(3000);
		}
  public void prgAsgn() throws InterruptedException {
		
	  	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement pers23 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("1")));
		pers23.click();
		WebElement pers24 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showInactive")));
		pers24.click();
		WebElement pers25 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showUnassignedPrograms")));
		pers25.click();
		Myutilities.sleepFor(2000);
		WebElement pers26 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnSave")));
		pers26.click();
		Myutilities.sleepFor(3000);
		}
  public void programCert() throws InterruptedException {
		
	  	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement progCertificate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"progress\"]/div/div[1]/div/div[1]/div[2]/a")));
		progCertificate.click();																		
		Myutilities.sleepFor(3000);
		}
  public void saveButton() throws InterruptedException {
		
	  	WebDriverWait wait = new WebDriverWait(driver, 20);
	  	WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnSave")));
	  	saveButton.click();
		Myutilities.sleepFor(3000);
		}
  public void peopleSelect() throws InterruptedException {
		
	  	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement selectPeople = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"progress\"]/div/div[1]/div/div[2]/div[2]/a")));
		selectPeople.click();																		
		Myutilities.sleepFor(3000);
		}
  public void otherOptions() throws InterruptedException {
		
	  	WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement otherOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("None")));
		otherOption.click();
		WebElement inactiveUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showInactiveUsers")));
		inactiveUser.click();
		Myutilities.sleepFor(2000);
		WebElement btnSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnSave")));
		btnSave.click();
		Myutilities.sleepFor(3000);
		}
  public void expiredCertificates() throws InterruptedException {
		
	  	WebDriverWait wait = new WebDriverWait(driver, 20);
	  	WebElement linkClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("1")));
	  	linkClick.click();
		WebElement inactiveUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showInactiveUsers")));
		inactiveUser.click();
		WebElement expiredCertificate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showExpiredCertifications")));
		expiredCertificate.click();
		Myutilities.sleepFor(2000);
		WebElement btnSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnSave")));
		btnSave.click();
		Myutilities.sleepFor(3000);
		}
  public void deletedCertificates() throws InterruptedException {
		
	  	WebDriverWait wait = new WebDriverWait(driver, 20);
	  	WebElement linkClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("1")));
	  	linkClick.click();
		WebElement expiredCert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showExpiredCertifications")));
		expiredCert.click();
		WebElement deletedCertificate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showDeletedCertifications")));
		deletedCertificate.click();
		Myutilities.sleepFor(2000);
		WebElement btnSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnSave")));
		btnSave.click();
		Myutilities.sleepFor(3000);
		}
  public void userProgress() throws InterruptedException {
		
	  	WebDriverWait wait = new WebDriverWait(driver, 20);
	  	WebElement linkClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("1")));
	  	linkClick.click();
		WebElement deletedCert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showDeletedCertifications")));
		deletedCert.click();
		WebElement userProgress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showCertificationsInProgress")));
		userProgress.click();
		Myutilities.sleepFor(2000);
		WebElement btnSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnSave")));
		btnSave.click();
		Myutilities.sleepFor(3000);
		}
  public void showRegion() throws InterruptedException {
		
	  	WebDriverWait wait = new WebDriverWait(driver, 20);
	  	WebElement linkClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("1")));
	  	linkClick.click();
		WebElement inProgressCert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showCertificationsInProgress")));
		inProgressCert.click();
		WebElement showRegion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showRegion")));
		showRegion.click();
		Myutilities.sleepFor(2000);
		WebElement btnSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnSave")));
		btnSave.click();
		Myutilities.sleepFor(3000);
		}
}
//}

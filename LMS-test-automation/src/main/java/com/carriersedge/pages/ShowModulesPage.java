package com.carriersedge.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.carriersedge.util.BaseClass;
import com.carriersedge.util.Myutilities;

public class ShowModulesPage extends BaseClass {

	public ShowModulesPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logger.info("ShowModules Page initializes");
	}

	private static final Logger logger = LogManager.getLogger(ShowModulesPage.class);
	@FindBy(xpath = "(//li[@class='subnav3'])[1]")
	WebElement showModules;

	@FindBy(xpath = "//li[@class='subnav4'][contains(.,'Add Module')]")
	WebElement addModule;
	@FindBy(xpath = "(//li[@class='subnav10'])[1]")
	WebElement showCertificate;
	@FindBy(xpath = "//li[@class='subnav11'][contains(.,'Add Program Certificate')]")
	WebElement Certificate;
	@FindBy(xpath = "//li[@class='subnav7'][contains(.,'Practical Activity')]")
	WebElement practical;
	@FindBy(id = "fileName")
	WebElement fname;
	@FindBy(name = "file_random.108_9506")
	WebElement fname1;
	@FindBy(name = "hours_random.108_9506")
	WebElement fname2;

	// module Deadline windows Elements
	// Module Options
	@FindBy(id = "public")
	WebElement surveyAsPublicCB;
	@FindBy(id = "notify_admin_completion")
	WebElement serveyNotifyAdminCB;
	@FindBy(id = "notify_subadmin_completion")
	WebElement serveyNotifySubAdminCB;
	@FindBy(id = "notify_manager_completion")
	WebElement serveyNotifyManagerCB;

	// Module Expiry / Retraining Interval
	@FindBy(id = "moduleExpiry")
	WebElement needNotRetakeRB;
	@FindBy(id = "moduleExpiry2")
	WebElement NeedRetakeRB;
	@FindBy(id = "moduleExpiryDays")
	WebElement moduleExpiryDaysTB;
	@FindBy(id = "moduleExpiryUnits")
	WebElement moduleExpiryUnitsDD;// dropdown list
	@FindBy(id = "expiryNotice")
	WebElement expiryNoticeDayTB;

	// Module Limits / Locks
	@FindBy(id = "moduleLimits")
	WebElement canTakenMultipleTimesRB;
	@FindBy(id = "moduleLimits2")
	WebElement canbeTakenCertainTimesRB;
	@FindBy(id = "moduleLimitTimes")
	WebElement moduleLimitTimesTB;
	@FindBy(id = "moduleLimitDays")
	WebElement moduleLimitDaysTB;

	// Test Time Limit
	@FindBy(id = "testLimits")
	WebElement testDefaultTimeLimitsRB;
	@FindBy(id = "testLimits2")
	WebElement testTimeLimitsRB;
	@FindBy(id = "testTimeout")
	WebElement testLimitsMinsTB;

	// Module Lockdown
	@FindBy(id = "forceNavigation")
	WebElement preventUntilSoundfinishCB;
	@FindBy(id = "forceQuiz")
	WebElement preventUntilAllAnsCorrectCB;

	// Module Pay Rate
	@FindBy(id = "payrate")
	WebElement noPayRB;
	@FindBy(id = "payrate2")
	WebElement yesPayRB;
	@FindBy(id = "payrateAmount")
	WebElement payRateTB;

	// Assignment Controls
	@FindBy(id = "adminsOnly")
	WebElement assignByAllSupervisorsRB;
	@FindBy(id = "adminsOnly2")
	WebElement assignByAdminsRB;

	// Module Completion
	@FindBy(id = "completion")
	WebElement acknowledgeComptionCB;

	public void clickShowModules() {
		try {
			// ***Chenged 4 to 10
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement showModule = wait.until(ExpectedConditions.visibilityOf(showModules));
			showModule.click();
		} catch (TimeoutException e) {
			e.printStackTrace();
			logger.info("an exception occurred Since I am already on the same page so it is continuous.");
		}
	}

	public String[] getAllModulesName() {
		List<WebElement> eles = driver.findElements(By.xpath("//*[@id='moduleGroups']//h2/span[2]"));
		// dynamic wait did not work so
		int j = 0;
		while (eles.size() == 0 && j < 6) {
			try {
				Thread.sleep(500);
				eles = driver.findElements(By.xpath("//*[@id='moduleGroups']//h2/span[2]"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			j++;
			logger.info("waiting time: 500 sec");
		}
		String[] modules = new String[eles.size()];
		logger.info("modules size: " + eles.size());
		for (int i = 0; i < eles.size(); i++) {
			modules[i] = eles.get(i).getText();
			logger.info("modules: " + i + " " + modules[i]);
		}
		return modules;
	}

	public void clickOnXPeopleAssiged(String moduleId) {
		int i = 0;
		while (driver.findElements(By.id("resetStatus")).size() == 0 && i < 8) {
			i++;
			try {
				driver.findElement(By.xpath("//section[contains(@class,'" + moduleId + "')]/div[3]")).click();
				Myutilities.sleepFor(4500);

			} catch (NoSuchElementException e) {

				Myutilities.sleepFor(1000);
				logger.info("x people assigned exception occur.");
			}
		}
	}

	// Method for x people assigned when reset check box is not there.
	public void clickOnXPeopleAssign(String moduleId) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			WebElement elementModule = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//section[contains(@class,'" + moduleId + "')]/div[3]")));
			elementModule.click();
			Myutilities.sleepFor(4000);

		} catch (NoSuchElementException e) {

			Myutilities.sleepFor(1000);
			logger.info("x people assigned exception occured.");
		}
	}

	public void hoverOverOnXPeopleAssiged(String moduleId) {
		Boolean excp = false;
		int i = 0;
		while (excp == false && i < 8) {
			try {
				Actions builder = new Actions(driver);
				builder.moveToElement(
						driver.findElement(By.xpath("//section[contains(@class,'" + moduleId + "')]/div[3]")))
				.perform();
				excp = true;
			} catch (NoSuchElementException e) {
				try {
					Thread.sleep(500);
					logger.info("500 ms waited.");
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				excp = false;
			}
			i++;
		}
		Myutilities.sleepFor(500);

	}

	public String[] getXPeopleAssignedHoveredData() {
		String getText = driver.findElement(By.xpath("//*[@id='smallipop1']/div")).getText();
		return getText.split("\\r?\\n");
	}

	/**
	 * Give the number of assigned people to the module when the module Id (in
	 * string) passes as an argument.
	 */
	public int getNoOfAssignedPeopleToModule(String moduleId) {
		// hoverOverOnXPeopleAssiged(moduleId);
		String str = "";
		int i = 0;
		while (driver.findElements(By.xpath("//section[contains(@class,'" + moduleId + "')]/div[3]")).size() == 0
				& i < 5) {
			Myutilities.sleepFor(500);
			i++;
		}
		try {
			str = driver.findElement(By.xpath("//section[contains(@class,'" + moduleId + "')]/div[3]")).getText();
		} catch (Exception e) {
			logger.info("An exception occurred in getting no of assigned people of the module.");
		}

		logger.error(moduleId + " Can't find or wrong module id");
		str = str.replaceAll("\\D+", "");
		logger.info("people assigned: " + str);
		
		int no = Integer.parseInt(str);
		return no;
	}

	// module Deadline windows functions
	// Module Options
	public void selectsurveyAsPublic() {
		if (!surveyAsPublicCB.isSelected()) {
			surveyAsPublicCB.click();
		}
	}

	public void UnSelectSurveyAsPublic() {
		if (surveyAsPublicCB.isSelected()) {
			surveyAsPublicCB.click();
		}
	}

	public void selectServeyNotifyAdminCB() {
		if (!serveyNotifyAdminCB.isSelected()) {
			serveyNotifyAdminCB.click();
		}
	}

	public void selectServeyNotifySubAdminCB() {
		if (!serveyNotifySubAdminCB.isSelected()) {
			serveyNotifySubAdminCB.click();
		}
	}

	public void selectserveyNotifyManagerCB() {
		if (!serveyNotifyManagerCB.isSelected()) {
			serveyNotifyManagerCB.click();
		}
	}

	public void unSelectServeyNotifyAdminCB() {
		if (serveyNotifyAdminCB.isSelected()) {
			serveyNotifyAdminCB.click();
		}
	}

	public void unSelectServeyNotifySubAdminCB() {
		if (serveyNotifySubAdminCB.isSelected()) {
			serveyNotifySubAdminCB.click();
		}
	}

	public void unSelectserveyNotifyManagerCB() {
		if (serveyNotifyManagerCB.isSelected()) {
			serveyNotifyManagerCB.click();
		}
	}

	// Module Expiry / Retraining Interval
	public void selectModuleNeedNotRetaken() {
		needNotRetakeRB.click();
	}

	/**
	 * Module need to retake on every (Arg1)Time and (Arg2)unit and notify
	 * (Arg3)days before expires
	 */
	public void moduleNeedRetakOnEvery(int timeLength, String timeUnit, int notifyDay) {
		NeedRetakeRB.click();
		Myutilities.sleepFor(1000);
		moduleExpiryDaysTB.clear();
		moduleExpiryDaysTB.sendKeys(String.valueOf(timeLength));
		new Select(moduleExpiryUnitsDD).selectByVisibleText(timeUnit);
		expiryNoticeDayTB.clear();
		expiryNoticeDayTB.sendKeys(String.valueOf(notifyDay));
	}

	// Module Limits / Locks
	public void selectModuleCanTakenUnlimitateTimes() {
		canTakenMultipleTimesRB.click();
	}

	public void moduleCanTakenInTimesDay(int times, int days) {
		canbeTakenCertainTimesRB.click();
		moduleLimitTimesTB.sendKeys(String.valueOf(times));
		;
		moduleLimitDaysTB.sendKeys(String.valueOf(days));
	}

	// Test Time Limit
	public void selectModuleCompleatedInDefaultTime() {
		testDefaultTimeLimitsRB.click();
	}

	public void moduleCompleatedInTime(int minutes) {

		testTimeLimitsRB.click();
		testLimitsMinsTB.clear();
		testLimitsMinsTB.sendKeys(String.valueOf(minutes));
	}

	// Module Lockdown
	public void selectPreventUserUntilSoundFinish() {
		if (!preventUntilSoundfinishCB.isSelected()) {
			preventUntilSoundfinishCB.click();
		}
	}

	public void unselectPreventUserUntilSoundFinish() {
		if (preventUntilSoundfinishCB.isSelected()) {
			preventUntilSoundfinishCB.click();
		}
	}

	public void selectPreventUserUntilAnsweredCorrectly() {
		if (!preventUntilAllAnsCorrectCB.isSelected()) {
			preventUntilAllAnsCorrectCB.click();
		}
	}

	public void unSelectPreventUserUntilAnsweredCorrectly() {
		if (preventUntilAllAnsCorrectCB.isSelected()) {
			preventUntilAllAnsCorrectCB.click();
		}
	}

	// Module Pay Rate
	public void selectNoPayRate() {
		noPayRB.click();
		;

	}

	public void payRate(int payRate) {
		yesPayRB.click();
		payRateTB.sendKeys(String.valueOf(payRate));
	}

	// Assignment Controls
	public void selectAssignControlByAllSupervisors() {
		assignByAllSupervisorsRB.click();
	}

	public void selectAssignControlByAdmins() {
		assignByAdminsRB.click();
	}

	// Module Completion
	public void selectAcknowledgeComptionCB() {
		if (!acknowledgeComptionCB.isSelected()) {
			acknowledgeComptionCB.click();
		}
	}

	public void unselectAcknowledgeComptionCB() {
		if (acknowledgeComptionCB.isSelected()) {
			acknowledgeComptionCB.click();
		}
	}

	public String[] getAllExpiryOptions() {

		List<WebElement> eles = driver
				.findElements(By.xpath("(//div[@class='field' or @class='field surveyModule']/div[@class='label'])"));
		int sz = eles.size();
		if (sz == 0) {
			try {
				Thread.sleep(2000);
				eles = driver.findElements(
						By.xpath("(//div[@class='field' or @class='field surveyModule']/div[@class='label'])"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		sz = eles.size();
		logger.info("Size:" + sz);
		String[] options = new String[eles.size()];
		for (int i = 0; i < sz; i++) {
			options[i] = eles.get(i).getText();
			logger.info("Expiry option: " + options[i]);
		}
		return options;

	}

	public void addModuleClick() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement elementAddModule = wait.until(ExpectedConditions.visibilityOf(addModule));
			elementAddModule.click();
			Myutilities.sleepFor(3000);
		} catch (TimeoutException e) {
			e.printStackTrace();
			logger.info("an exception occurred Since I am already on the same page so it is continuous.");
		}
	}

	public void addModule() {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement elementModuleName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("moduleName")));
		Myutilities.sleepFor(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(elementModuleName).click().build().perform();
		Myutilities.sleepFor(2000);
		elementModuleName.sendKeys("Test module");
		Myutilities.sleepFor(1000);
		driver.findElement(By.xpath("//html")).click();
		WebElement elementDuration = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("duration"))));
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(elementDuration).click().build().perform();
		elementDuration.sendKeys("9");
		Myutilities.sleepFor(2000);
		WebElement el = driver.findElement(By.xpath("//html"));
		el.click();
		String path3 = System.getProperty("user.dir");
		Actions builder = new Actions(driver);
		builder.moveToElement(fname).perform();
		Myutilities.sleepFor(2000);
		fname.sendKeys(path3 + "/TestData/sample.pdf");
		Myutilities.sleepFor(2000);
		driver.findElement(By.xpath("//html")).click();
		WebElement elementSave = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".btnSave:nth-child(2)"))));
		Actions action1 = new Actions(driver);
		action1.moveToElement(elementSave).click().build().perform();
		Myutilities.sleepFor(8000);
	}

	public void deleteModule() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement el = driver.findElement(By.xpath("//html"));
			el.click();
			Myutilities.sleepFor(2000);
			WebElement elementModuleSearch = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("moduleSearch"))));
			Actions actions1 = new Actions(driver);
			actions1.moveToElement(elementModuleSearch).click().build().perform();
			Myutilities.sleepFor(3000);
			elementModuleSearch.click();
			Myutilities.sleepFor(2000);
			driver.findElement(By.id("moduleSearch")).sendKeys("test modul");
			Myutilities.sleepFor(2000);
			WebElement linkDelete = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Delete"))));
			Actions actions14 = new Actions(driver);
			actions14.moveToElement(linkDelete).click().build().perform();
			Myutilities.sleepFor(2000);
			driver.findElement(By.cssSelector(".btnDelete:nth-child(2)")).click();
			Myutilities.sleepFor(3000);
		} catch (TimeoutException e) {
			e.printStackTrace();
			logger.info("an exception occurred Since I am already on the same page so it is continuous.");
		}
	}

	public void clickOnDeleteConform() {
		driver.findElement(By.xpath("//div[@class='actionButtons']/button[2]")).click();
	}

	public void hoverOverOnProgram(String moduleName) {
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("//h2[span[text()='" + moduleName + "']]"))).perform();
	}

	public void searchTempmoduleAndDelete1() {
		List<WebElement> eles1 = driver.findElements(By.xpath("//h2/span[contains(.,'Test module')]"));
		logger.info("Size : " + eles1.size());
		for (int i = 0; i < eles1.size(); i++) {
			try{
				String moduleName = eles1.get(i).getText();
				Myutilities.sleepFor(2000);
				hoverOverOnProgram(moduleName);
				logger.info("module Name: " + moduleName);

				WebDriverWait wait = new WebDriverWait(driver, 4);
				WebElement foo = wait.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("//h2[span[text()='" + moduleName + "']]/span/a[1]"))));
				foo.click();
				Myutilities.sleepFor(4000);
				clickOnDeleteConform();
				break;
			}
			catch(Exception e){
				e.getMessage();
			}


			Myutilities.sleepFor(4000);
		}

	}

	public void clickShowCertificate() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement elementShowCert = wait.until(ExpectedConditions.visibilityOf(showCertificate));
			elementShowCert.click();
			Myutilities.sleepFor(2000);
		} catch (TimeoutException e) {
			e.printStackTrace();
			logger.info("an exception occurred Since I am already on the same page so it is continuous.");
		}

	}

	public void addEcertificate() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement elementCert = wait.until(ExpectedConditions.visibilityOf(Certificate));
			elementCert.click();
			Myutilities.sleepFor(3000);
		} catch (TimeoutException e) {
			e.printStackTrace();
			logger.info("an exception occurred Since I am already on the same page so it is continuous.");
		}
	}

	public void certificateDetails() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement elementCertNme = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("certificationName")));
			elementCertNme.click();
			elementCertNme.sendKeys("Test Certificate");
			Myutilities.sleepFor(2000);
			WebElement elementProgram = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("program-23754")));
			elementProgram.click();
			Myutilities.sleepFor(2000);
			WebElement elementSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnSave")));
			elementSave.click();
			Myutilities.sleepFor(3000);
		} catch (TimeoutException e) {
			e.printStackTrace();
			logger.info("Error occurred");
		}
	}

	public void showcert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement elementShowCertificate = wait.until(ExpectedConditions.visibilityOf(showCertificate));
			elementShowCertificate.click();
			Myutilities.sleepFor(2000);
			driver.findElement(By.xpath("//html")).click();
			Myutilities.sleepFor(1000);
		} catch (TimeoutException e) {
			e.printStackTrace();
			logger.info("Exception occured");
		}
	}

	public void dltcert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement ElementProgramLink = wait.until(ExpectedConditions.visibilityOf(
					driver.findElement(By.xpath("//*[@id=\"programs\"]/div/section/section/h2/span[2]"))));
			Actions actions1 = new Actions(driver);
			actions1.moveToElement(ElementProgramLink).build().perform();
			Myutilities.sleepFor(2000);
			WebElement elementDelete = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Delete"))));
			elementDelete.click();
			Myutilities.sleepFor(2000);
			WebElement deleteClick = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".btnDelete:nth-child(2)"))));
			deleteClick.click();
			Myutilities.sleepFor(2000);
		} catch (TimeoutException e) {
			e.printStackTrace();
			logger.info("Exception occured");
		}
	}

	public void practicalActivity() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement elementParactical = wait.until(ExpectedConditions.visibilityOf(practical));
			elementParactical.click();
			Myutilities.sleepFor(3000);
		} catch (TimeoutException e) {
			e.printStackTrace();
			logger.info("an exception occurred Since I am already on the same page so it is continuous.");
		}
	}

	public void practicaldetails() {
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			// get current date time with Date()
			Date date = new Date();
			// Now format the date
			String dateFormatted = dateFormat.format(date);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement elementInstructor = wait
					.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("instructor_random.108_9506"))));
			elementInstructor.click();
			{
				WebElement selectInstructor = driver.findElement(By.name("instructor_random.108_9506"));
				selectInstructor.findElement(By.xpath("//option[. = 'Auto4 Admin']")).click();
			}
			Myutilities.sleepFor(2000);
			WebElement elementDatePicker = driver.findElement(By.name("datePicker_random.108_9506"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", elementDatePicker);
			Myutilities.sleepFor(2000);
			elementDatePicker.sendKeys(dateFormatted);
			WebElement elementModalBox = driver.findElement(By.xpath("//*[@id=\"modal1\"]/div/form/table/thead/tr/th[5]"));
			elementModalBox.click();
			Myutilities.sleepFor(2000);
			Actions action2 = new Actions(driver);
			action2.moveToElement(fname2).click().build().perform();
			fname2.sendKeys("4");
			String path3 = System.getProperty("user.dir");
			Actions builder = new Actions(driver);
			builder.moveToElement(fname1).perform();
			Myutilities.sleepFor(2000);
			fname1.sendKeys(path3 + "/TestData/sample.pdf");
			Myutilities.sleepFor(2000);
			WebElement elementDelte = wait.until(
					ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".btnSave:nth-child(2)"))));
			Actions actnsh = new Actions(driver);
			actnsh.moveToElement(elementDelte).click().build().perform();
			Myutilities.sleepFor(3000);
		} catch (TimeoutException e) {
			e.printStackTrace();
			logger.info("an exception occurred.");
		}
	}
}
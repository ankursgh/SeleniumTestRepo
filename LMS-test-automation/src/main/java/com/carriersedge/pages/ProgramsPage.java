package com.carriersedge.pages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.carriersedge.util.BaseClass;
import com.carriersedge.util.Myutilities;

public class ProgramsPage extends BaseClass {

	public ProgramsPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logger.info("ProgramsPage initializes");
	}

	private static final Logger logger = LogManager.getLogger(ProgramsPage.class);
	String programName = "";

	@FindBy(xpath = "//*[@id='nav2']/ul/li[1]")
	WebElement programsIcon;
	@FindBy(xpath = "//li[@class='subnav2'][contains(.,'Add Programs')]")
	WebElement addProgramsIcon;
	@FindBy(xpath = "//*[text()='AutoProgram']/../..//div[2]/a")
	WebElement peopleAssignedToAutoProgram;
	@FindBy(xpath = "//*[text()='AutoProgram']/../..//div[3]/a")
	WebElement moduleAssignedToAutoProgram;
	@FindBy(xpath = "//li[contains(@class,'btnView1')]/a")
	WebElement assignPeopleTab;
	@FindBy(xpath = "//li[contains(@class,'btnView2')]/a")
	WebElement assignPlacesTab;
	@FindBy(xpath = "//a[@href='#'][contains(.,'Add To Program')]")
	WebElement addToProgramTab;
	// *************Element Declared
	@FindBy(xpath = "//*[@id=\"programs\"]//div[1]/p")
	WebElement Tp;
	// *************Element Declared
	@FindBy(xpath = "//*[@class=\"locationUsers disabled\"]")
	WebElement disableUsers;
	@FindBy(id = "resetStatus")
	WebElement resetCB;
	@FindBy(id = "user-auto2.user")
	WebElement auto2User;
	@FindBy(xpath = "//a[@class='selectAll']")
	WebElement selectAll;
	@FindBy(xpath = "//a[@class='unselectAll']")
	WebElement unSelectAll;
	@FindBy(xpath = "//*[contains(text(),'A background process is')]")
	WebElement bulkUsersProcessMsg;
	@FindBy(id = "sendNotice")
	WebElement sendNotice;
	@FindBy(id = "includeLogin")
	WebElement incluceLogin;
	@FindBy(className = "modalContainer")
	WebElement peopleAssignWindow;
	@FindBy(id = "startDateType1")
	WebElement programStartDateImmediately;
	@FindBy(id = "startDate")
	WebElement programStartDateAsOf;
	@FindBy(id = "startDateDays")
	WebElement programStartDateDayAfter;
	@FindBy(id = "remove")
	WebElement removeProgramWhenCompleated;
	@FindBy(id = "deadlineDays")
	WebElement deadlineDays;
	@FindBy(id = "deadlineDate")
	WebElement deadlineDate;
	@FindBy(id = "deadlineType3")
	WebElement noSpecificDeadlineRB;
	@FindBy(id = "removeDeadline")
	WebElement removeProgramWhenDeadlinePassCB;

	public void clickShowPrograms() {
		int i = 0;
		int insideShowProgram = 0;
		while (insideShowProgram == 0 && i < 3) {
			i++;
			try {

				WebElement element = driver.findElement(By.xpath("//a[@href='programs/program/show']"));
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", element);
				// }

				Myutilities.sleepFor(1500);
				// logger.info(driver.findElement(By.xpath("//h2[contains(.,'Required
				// Programs')]")).getText());
				logger.info("clicked show program.");
			} catch (StaleElementReferenceException e) {
				Myutilities.sleepFor(1500);
			}
			insideShowProgram = driver.findElements(By.xpath("//h2[contains(.,'Required Programs')]")).size();
			Myutilities.sleepFor(1500);
			logger.info("show program showed if there is greater than zero " + insideShowProgram);

		}

	}

	public void clickPeopleAssignedToProgram(String programName) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		this.programName = programName;
		int i = 0;
		int check = 0;
		// driver.findElements(By.xpath("//li[contains(@class,'btnView1')]/a")).size()
		while (check == 0 && i <= 3) {
			WebElement foo;
			try {
				// WebDriverWait wait = new WebDriverWait(driver, 7);
				// foo =
				// wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//section[h2[span[text()='"
				// + programName +"']]]/div[2]/a"))));
				// foo.click();
				driver.findElement(By.xpath("//section[h2[span[text()='" + programName + "']]]/div[2]/a")).click();
				logger.info("Assigned people on " + programName + " Program clicked");
				Myutilities.sleepFor(1000);
				logger.info("Assign People tab shown before:"
						+ driver.findElements(By.xpath("//li[contains(@class,'btnView1')]/a")).size());
				if (driver.findElements(By.xpath("//li[contains(@class,'btnView1')]/a")).size() < 1) {
					logger.info(
							"Assign People tab shown after:" + driver.findElements(By.className("btnView1")).size());
					// click outside on the top text and click on the program
					// driver.findElement(By.xpath("//*[@id=\"programs\"]//div[1]/p")).click();
					// new WebDriverWait(driver,
					// 7).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"programs\"]//div[1]/p")))).click();;
					// ****************************** JS executor implemented
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", Tp);
					// ****************************** END
					logger.info("Clicked again on the program");
					new WebDriverWait(driver, 7)
							.until(ExpectedConditions.elementToBeClickable(driver.findElement(
									By.xpath("//span[text()='" + programName + "']/ancestor::node()/div[2]/a"))))
							.click();
					Myutilities.sleepFor(1000);
				}
			} catch (Exception ex) {

				Myutilities.sleepFor(2000);
				if (driver.findElements(By.xpath("//li[contains(@class,'btnView1')]/a")).size() == 0) {

					// driver.findElement(By.xpath("//*[@id=\"programs\"]//div[1]/p")).click();
					// ****************************** JS executor implemented
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", Tp);
					// *********************END*********
					new WebDriverWait(driver, 7)
							.until(ExpectedConditions.elementToBeClickable(driver.findElement(
									By.xpath("//span[text()='" + programName + "']/ancestor::node()/div[2]/a"))))
							.click();
					;
				}
				Myutilities.sleepFor(1000);
				logger.info("Clicked again on the program in Exception");
			}
			i++;
			check = driver.findElements(By.xpath("//li[contains(@class,'btnView1')]/a")).size();
			Myutilities.sleepFor(500);
		}
		logger.info("Clicked again on the program " + i + " times");
	}

	public void clickOnDeadlineLinkOfProgram(String programName) {
		this.programName = programName;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement foo;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			foo = wait.until(ExpectedConditions.elementToBeClickable(
					driver.findElement(By.xpath("//span[text()='" + programName + "']/ancestor::node()/div[1]/a"))));
			foo.click();

			Myutilities.sleepFor(1000);
			if (driver.findElements(By.id("startDateType1")).size() == 0) {
				// click outside on the top text and click on the program
				driver.findElement(By.xpath("//*[@id=\"programs\"]//div[1]/p")).click();
				logger.info("Clicked again on the Deadline link");
				foo.click();
			}
		} catch (Exception ex) {
			Myutilities.sleepFor(1000);
			if (driver.findElements(By.id("startDateType1")).size() == 0) {
				// clicking outside without affecting others
				driver.findElement(By.xpath("//*[@id=\"programs\"]//div[1]/p")).click();
			}
			driver.findElement(By.xpath("//span[text()='" + programName + "']/ancestor::node()/div[1]/a")).click();

			logger.info("Clicked again on the deadline link Exception");
		}

		logger.info("Clicked again on the Deadline link");
	}

	public void clickOnDeadlineLinkOfModule(String moduleName) {
		// this.programName=programName;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement foo;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			foo = wait.until(ExpectedConditions.elementToBeClickable(
					driver.findElement(By.xpath("//span[text()='" + moduleName + "']/ancestor::node()/div[1]/a"))));
			foo.click();
			Myutilities.sleepFor(1000);
		} catch (Exception ex) {
			Myutilities.sleepFor(1000);

			driver.findElement(By.xpath("//span[text()='" + moduleName + "']/ancestor::node()/div[1]/a")).click();

			logger.info("Clicked again on the deadline link Exception");
		}

		logger.info("Clicked again on the Deadline link");
	}

	public void clickOnModuleAssignedOfProgram(String programName) {
		this.programName = programName;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement foo;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			foo = wait.until(ExpectedConditions.elementToBeClickable(
					driver.findElement(By.xpath("//span[text()='" + programName + "']/ancestor::node()/div[3]/a"))));
			foo.click();
			// wait increased 500 to 1000
			Myutilities.sleepFor(1000);
			if (driver.findElements(By.id("programType")).size() == 0) {
				// click outside on the top text and click on the program
				driver.findElement(By.xpath("//*[@id=\"programs\"]//div[1]/p")).click();
				logger.info("Clicked again on the moduled assigned");
				foo.click();
			}
		} catch (Exception ex) {
			Myutilities.sleepFor(1000);

			if (driver.findElements(By.id("startDateType1")).size() == 0) {
				driver.findElement(By.xpath("//*[@id=\"programs\"]//div[1]/p")).click();
			}

			driver.findElement(By.xpath("//span[text()='" + programName + "']/ancestor::node()/div[3]/a")).click();
			logger.info("Clicked again on the moduled assigned Exception");
		}

		logger.info("Clicked again on the moduled assigned link");
	}

	public void clickShowShotOrderOrModules() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='bulkSelect']/a[2]"))));

		foo.click();
	}

	public String[] getOrderedModules() {
		List<WebElement> eles = driver.findElements(By.xpath("//*[contains(@class,'otherSelectorList')] /div"));
		String[] str = new String[eles.size()];
		for (int i = 0; i < eles.size(); i++) {
			str[i] = eles.get(i).getText();
		}
		return str;
	}

	public void clickModuleAssignedToAutoProgram() {
		moduleAssignedToAutoProgram.click();
	}

	public int getNoOfAssignedPeopleToProgram(String programName) {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		String str = "";
		try {
			str = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(
					driver.findElement(By.xpath("//span[text()='" + programName + "']/ancestor::node()[2]/div[2]/a"))))
					.getText();
		} catch (Exception e) {
			try {
				Thread.sleep(1000);
				str = new WebDriverWait(driver, 30)
						.until(ExpectedConditions.visibilityOf(driver.findElement(
								By.xpath("//span[text()='" + programName + "']/ancestor::node()[2]/div[2]/a"))))
						.getText();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

		}
		str = str.replaceAll("\\D+", "");
		int no = Integer.parseInt(str);
		logger.info("people assigned: " + str);
		return no;
	}

	public int getNoOfAssignedModuleToProgram(String programName) {

		WebElement foo;
		String str = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			foo = wait.until(ExpectedConditions.visibilityOf(
					driver.findElement(By.xpath("//span[text()='" + programName + "']/ancestor::node()[2]/div[3]/a"))));
			str = foo.getText();
		} catch (Exception e) {

			Myutilities.sleepFor(1000);
			foo = driver.findElement(By.xpath("//span[text()='" + programName + "']/ancestor::node()[2]/div[3]/a"));
			str = foo.getText();

		}
		str = str.replaceAll("\\D+", "");
		int no = Integer.parseInt(str);
		return no;

	}

	/** Click on 'Assign People' tab in the small window. */
	public void clickAssignPeopleTab() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(assignPeopleTab));
		foo.click();
	}

	/** Clicks 'Assign Places' tab in the small window. */
	public void clickAssignPlacesTab() {
		try {
			// assignPlacesTab.click();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement foo = wait.until(ExpectedConditions.visibilityOf(assignPlacesTab));
			foo.click();
			logger.info("clicked on the Assign Places tab");
		} catch (Exception e) {
			if (driver.findElements(By.className("btnView2")).size() == 0) {
				driver.findElement(By.xpath("//*[@id=\"programs\"]//div[1]/p")).click();
				logger.info("Again clicked on the Assign Places tab");
				driver.findElement(By.xpath("//span[text()='" + programName + "']/ancestor::node()/div[2]/a")).click();
				WebDriverWait wait = new WebDriverWait(driver, 20);
				WebElement foo = wait.until(ExpectedConditions
						.visibilityOf(driver.findElement(By.xpath("//li[contains(@class,'btnView2')]/a"))));
				foo.click();
			}
		}

	}

	/** Click on 'Add To Program' tab in a small window. */
	public void clickAddToProgramTab() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(addToProgramTab));
		foo.click();
	}

	public void clickPlace(String placeId) {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(placeId))));
		foo.click();
	}

	public String[] getDisableUsers() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(disableUsers));
		String str = foo.getText();
		String[] myArray = str.split("\\n");
		for (int i = 0; i < myArray.length; i++)
			myArray[i] = myArray[i].trim();
		return myArray;
	}

	public boolean checkLoadStatus() {
		System.out.println("*********load check function:**************");
		// WebDriverWait wait = new WebDriverWait(driver,40);
		// WebElement foo=wait.until(ExpectedConditions.visibilityOf(resetCB));
		if (resetCB != null) {
			System.out.println("*********load check true:**************");
			return true;
		} else {
			System.out.println("*********load chck false:**************");
			return false;
		}
	}

	public void clickResetCheckBox() {
		// Wait increased
		WebElement foo = null;
		try {
			// checkLoadStatus();
			// int redf;
			// redf=2/0;
			// JavascriptExecutor jse = (JavascriptExecutor)driver;
			// jse.executeScript("window.scrollBy(0,1000)");
			for (int iLoop = 0; iLoop < 5; iLoop++) {
				boolean loadstatus = checkLoadStatus();
				if (loadstatus = true) {
					driver.findElement(By.id("resetStatus")).click();

				} else {
					WebDriverWait wait = new WebDriverWait(driver, 40);
					System.out.println("*********wait loop:**************");
				}

			}
			WebDriverWait wait = new WebDriverWait(driver, 40);
			foo = wait.until(ExpectedConditions.visibilityOf(resetCB));
			// *******************************

			// jse.executeScript("arguments[0].scrollIntoView(true)", resetCB);
			if (!foo.isSelected()) {
				// Myutilities.sleepFor(500);
				foo.click();
				// *******************************
				logger.info("Reset Selected.");
			} else {
				logger.info("Reset Already selected :" + driver.findElement(By.id("resetStatus")).isSelected());
			}
			Myutilities.sleepFor(500);
		} catch (NoSuchElementException e) {
			System.out.println("*********Expected condition failed:**************");
		}

		logger.info("Reset selected :" + driver.findElement(By.id("resetStatus")).isSelected());

	}

	// select or unselect users in a program
	/**
	 * Select or click any element by id. This is the General function for clicking
	 * or selecting any element. Pass the element id as an argument and the element
	 * is clicked or selected.
	 */
	// Need to Modify
	public void clickElementbyId(String strId) {
		// driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		// Wait increased
		// commented due to error AS
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(strId))));
		// foo.click();
		// Till here
		// ***********************
		// WebElement element = driver.findElement(By.id("strId"));
		Actions actions = new Actions(driver);
		actions.moveToElement(foo).click().build().perform();
		// ***********************
	}

	public void unselectSelectedElementById(String strId) {
		int i = 0;
		while (driver.findElements(By.xpath("//*[@id='" + strId + "' and contains(@class, 'click-selected')]"))
				.size() == 0 && i < 3) {
			Myutilities.sleepFor(250);
			i++;
			scrowlTheContainer();
			logger.info("250 ms waited.");
		}
		if (driver.findElements(By.xpath("//*[@id='" + strId + "' and contains(@class, 'click-selected')]"))
				.size() > 0) {
			driver.findElement(By.xpath("//*[@id='" + strId + "' and contains(@class, 'click-selected')]")).click();
			logger.info("unselected id : " + strId);
		}
	}

	public void selectUnselectedElementById(String strId) {
		int i = 0;

		while (driver.findElements(By.xpath("//*[@id='" + strId + "' and not(contains(@class, 'click-selected'))]"))
				.size() == 0 && i < 3) {
			// Wait increased
			Myutilities.sleepFor(450);

			i++;
			logger.info("350 ms waited.");
		}
		if (driver.findElements(By.xpath("//*[@id='" + strId + "' and not(contains(@class, 'click-selected'))]"))
				.size() > 0) {
			driver.findElement(By.xpath("//*[@id='" + strId + "' and not(contains(@class, 'click-selected'))]"))
					.click();

			logger.info("selected id : " + strId);
		}
		// ********************Change for LMST907
		String windowId = driver.getWindowHandle();
		try {
			driver.switchTo().window("xyz");
		} catch (NoSuchWindowException e) {
			System.out.println("*********No Such window Got Hendled**************");
		}
		// ********************Change for LMST907
	}

	public void clickSelectAll() {
		scrowlTheContainer();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(selectAll));
		foo.click();
		try {
			foo.click();
		} catch (StaleElementReferenceException e) {
			Myutilities.sleepFor(1000);
			driver.findElement(By.xpath("//a[@class='selectAll']")).click();
		}

		logger.info("Select All clicked");
	}

	public void clickUnSelectAll() {
		scrowlTheContainer();

		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement foo = wait.until(ExpectedConditions.visibilityOf(unSelectAll));
			foo.click();
			unSelectAll.click();
			logger.info("Unselect All clicked");
		} catch (Exception e) {
			Myutilities.sleepFor(1000);
			driver.findElement(By.xpath("//a[@class='unselectAll']")).click();
			logger.info("Unselect All in exception clicked");
		}

	}

	public String backgroungRunningMsg() {
		WebElement foo;
		String msg = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			foo = wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath("//*[contains(text(),'A background process is')]"))));
			msg = foo.getText();
		} catch (Exception ex) {
			Myutilities.sleepFor(2000);
			msg = driver.findElement(By.xpath("//*[contains(text(),'A background process is')]")).getText();

		}
		return msg;

	}

	public void checkSendNotice() {
		if (!sendNotice.isSelected())
			sendNotice.click();
	}

	public void checkIncludeLogin() {
		if (!incluceLogin.isSelected())
			incluceLogin.click();
	}

	public void scrowlTheContainer() {
		int i = 0;
		while (driver.findElements(By.xpath("//div[contains(@class,'modalContainer')]")).size() == 0 & i < 6) {
			// Wait increased from 500 to 2000
			Myutilities.sleepFor(2000);
			i++;
		}
		EventFiringWebDriver efw = new EventFiringWebDriver(driver);
		WebElement container = driver.findElement(By.xpath("//div[contains(@class,'modalContainer')]"));
		try {
			efw.executeScript("arguments[0].scrollIntoView(true)", container);
		} catch (Exception e) {
			logger.info("No scroll bar");
		}
	}

	public void selectProgramAvailableImmediately() {
		if (!programStartDateImmediately.isSelected()) {
			programStartDateImmediately.click();
		}
	}

	public void programStartDateAsOf(String date) {
		programStartDateAsOf.clear();
		if (date.toLowerCase().contains("tomorrow")) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDateTime tomorrow = LocalDateTime.now().plusDays(1);
			logger.info("Tomorrow Date: " + dtf.format(tomorrow));
			programStartDateAsOf.sendKeys(dtf.format(tomorrow));
		} else if (date.toLowerCase().contains("today")) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDateTime today = LocalDateTime.now();
			logger.info("Today Date: " + dtf.format(today));
			programStartDateAsOf.sendKeys(dtf.format(today));
		} else {
			programStartDateAsOf.sendKeys(date);
			logger.info("date provided");
		}
	}

	public void programStartDayAfter(String day) {
		programStartDateDayAfter.clear();
		programStartDateDayAfter.sendKeys(day);
	}

	public void selectRemoveProgramWhenCompleated() {
		if (!removeProgramWhenCompleated.isSelected()) {
			removeProgramWhenCompleated.click();
			logger.info("Remove program when compleated selected.");
		}
	}

	public void SetDeadlineDays(int days) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(deadlineDays));
		foo.clear();
		foo.sendKeys(String.valueOf(days));
		logger.info("dead line set in " + days + " days.");
	}

	public void SetdeadlineDateToProgram(String date) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		deadlineDate.clear();
		if (date.toLowerCase().contains("tomorrow")) {

			LocalDateTime tomorrow = LocalDateTime.now().plusDays(1);
			logger.info("Tomrrow Date: " + dtf.format(tomorrow));
			deadlineDate.sendKeys(dtf.format(tomorrow));

		} else if (Myutilities.isNumeric(date)) {
			LocalDateTime futureDate = LocalDateTime.now().plusDays(Integer.parseInt(date));
			logger.info("Future Date: " + dtf.format(futureDate));
			deadlineDate.sendKeys(dtf.format(futureDate));
		}

		else {
			deadlineDate.sendKeys(date);
		}

	}

	public void selectNoSpecificDeadlineRB() {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", noSpecificDeadlineRB);

	}

	public void removeProgramWhenDeadlinePassCB() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(removeProgramWhenDeadlinePassCB));
		foo.click();
	}

	public String getDeadlineMsg(String programName) {
		WebElement foo;
		String msg;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			foo = wait.until(ExpectedConditions.elementToBeClickable(
					driver.findElement(By.xpath("//span[text()='" + programName + "']/ancestor::node()/div[1]/a"))));
			msg = foo.getText();
			logger.info("get Deadline link text");
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			msg = driver.findElement(By.xpath("//span[text()='" + programName + "']/ancestor::node()/div[1]/a"))
					.getText();
			logger.info("get  Deadline link text in Exception");
		}

		return msg;
	}

	public String getMsgOnDeadlineHoverOver(String programName) {
		WebElement foo;
		String msg;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			foo = wait.until(ExpectedConditions.elementToBeClickable(
					driver.findElement(By.xpath("//span[text()='" + programName + "']/ancestor::node()/div[1]/a"))));
			logger.info("get Deadline link hover text");
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			Myutilities.sleepFor(1000);
			foo = driver.findElement(By.xpath("//span[text()='" + programName + "']/ancestor::node()/div[1]/a"));
			logger.info("get  Deadline link hover text in Exception");
		}

		Actions builder = new Actions(driver);
		builder.moveToElement(foo).perform();
		Myutilities.sleepFor(1000);
		return driver.findElement(By.xpath("//*[@id=\"smallipop1\"]/div")).getText();
	}

	public void selectOrUnselectModuleToAssignInTheProgram(String moduleId) {

		driver.findElement(By.xpath("//*[@id=\"" + moduleId + "\"]")).click();
	}

	public void selectModuleToAssignInTheProgram(String moduleId) {
		if (!driver.findElement(By.xpath("//*[@id=\"" + moduleId + "\"]")).getAttribute("class")
				.contains("click-selected")) {
			driver.findElement(By.xpath("//*[@id=\"" + moduleId + "\"]")).click();
			logger.info("module Selected: " + moduleId);
		}

	}

	public void unSelectModuleToUnAssignInTheProgram(String moduleId) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement ele = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"" + moduleId + "\"]"))));
		ele.click();
		logger.info("module Unselected: " + moduleId);

	}

	public void selectRemoveProgramWhenDeadlinePass() {
		if (!removeProgramWhenDeadlinePassCB.isSelected())
			removeProgramWhenDeadlinePassCB.click();
	}

	public void mouseHoverOnPrograms() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(programsIcon));
		Actions actions = new Actions(driver);
		actions.moveToElement(foo).perform();
		logger.info("mouse hover on Programs Icon.");
	}

	public void clickOnPrograms() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(programsIcon));
		foo.click();
		logger.info("click in Programs Icon.");
	}

	public void clickAddPrograms() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(addProgramsIcon));
		foo.click();
		logger.info("Add Programs was clicked");
	}

	/**
	 * give assigned users through assign places by clicking x people assigned link
	 * in a program from programs page, user names were in shadow in the small
	 * window in Assign People tab
	 */
	public String[] getAssignedPeopleUnderPlaceAssign() {
		List<WebElement> eles = driver.findElements(By.xpath("//div[contains(@id,'locationUser')]"));
		String[] peoples = new String[eles.size()];
		logger.info("Array size: " + eles.size());
		for (int i = 0; i < eles.size(); i++) {
			peoples[i] = eles.get(i).getText();
		}
		return peoples;

	}

	/**
	 * give people names under Available to assign users from x people assigned link
	 * in a program from programs page, the names were in Assign People tab, these
	 * people are not from assign through place
	 */
	public String[] getPeopleUnderAvailableToAssign() {
		List<WebElement> eles = driver
				.findElements(By.xpath("//div[contains(@id,'user') and not(contains(@id,'locationUser'))]"));
		String[] peoples = new String[eles.size()];
		logger.info("Array size: " + eles.size());
		for (int i = 0; i < eles.size(); i++) {
			peoples[i] = eles.get(i).getText();
		}
		return peoples;

	}

	/**
	 * First click on red X button and again click on delete confirmation on small
	 * window.
	 */
	public void deleteTheProgram(String programName) {
		try {
			// WebDriverWait wait = new WebDriverWait(driver, 4);
			// WebElement foo =
			// wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//h2[span[text()='"+programName+"']]/span/a[1]"))));
			// foo.click();
			WebElement element = driver.findElement(By.xpath("//h2[span[text()='" + programName + "']]/span/a[1]"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			Myutilities.sleepFor(1000);
			driver.findElement(By.xpath("//h2[span[text()='" + programName + "']]/span/a[1]")).click();
		}

		Myutilities.sleepFor(2000);
		// this click on delete on small window for again confirmation.
		driver.findElement(By.xpath("//div[@class='actionButtons']/button[2]")).click();

	}

	public void clickOnDeleteProgram(String programName) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 4);
			WebElement foo = wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath("//h2[span[text()='" + programName + "']]/span/a[1]"))));
			foo.click();
		} catch (Exception e) {
			Myutilities.sleepFor(1000);
		}
	}

	public void clickOnDeleteConform() {
		driver.findElement(By.xpath("//div[@class='actionButtons']/button[2]")).click();
	}

	public String getProgramNameText(String programName) {

		Myutilities.sleepFor(1500);
		return driver.findElement(By.xpath("(//span[contains(.,'" + programName + "')])[1]")).getText();

	}

	public String getProgramTypeOf(String programName) {
		return driver.findElement(By.xpath("(//span[contains(.,'" + programName + "')])[1]/ancestor::node()[3]/h2"))
				.getText();
	}

	public void hoverOverOnProgram(String programName) {
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("//h2[span[text()='" + programName + "']]"))).perform();
	}

	/** Return all program names present on the Show Programs page . */
	public String[] getProgramNames() {
		String[] programs;
		try {
			List<WebElement> eles = driver.findElements(By.xpath("//*[@id='programs']//section/section/h2/span[2]"));
			programs = new String[eles.size()];
			logger.info("programs size: " + eles.size());
			for (int i = 0; i < eles.size(); i++) {
				programs[i] = eles.get(i).getText();
				logger.info("program: " + programs[i]);
			}
			return programs;

		} catch (StaleElementReferenceException e) {
			Myutilities.sleepFor(1500);
			logger.info("program exception executed");
			List<WebElement> eles = driver.findElements(By.xpath("//*[@id='programs']//section/section/h2"));
			programs = new String[eles.size()];
			logger.info("programs size: " + eles.size());
			for (int i = 0; i < eles.size(); i++) {
				programs[i] = eles.get(i).getText();
				logger.info("program : " + programs[i]);
			}
			return programs;
		}
	}

	public void searchTempProgramAndDelete() {
		List<WebElement> eles1 = driver.findElements(By.xpath("//h2/span[contains(.,'Temp')]"));
		logger.info("Size : " + eles1.size());
		for (int i = 0; i < eles1.size(); i++) {

			String programName = eles1.get(i).getText();
			hoverOverOnProgram(programName);
			logger.info("program Name: " + programName);

			WebDriverWait wait = new WebDriverWait(driver, 4);
			WebElement foo = wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath("//h2[span[text()='" + programName + "']]/span/a[1]"))));
			foo.click();
			Myutilities.sleepFor(4000);
			clickOnDeleteConform();
			Myutilities.sleepFor(4000);
		}

	}
}
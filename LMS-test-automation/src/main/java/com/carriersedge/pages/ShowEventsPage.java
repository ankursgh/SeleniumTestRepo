package com.carriersedge.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class ShowEventsPage extends BaseClass {

	public ShowEventsPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logger.info("ShowEvents Page initializes");
	}

	private static final Logger logger = LogManager.getLogger(ShowEventsPage.class);
	@FindBy(xpath = "(//li[@class='subnav5'])[1]")
	WebElement showEvents;
	@FindBy(xpath = "//li[@class='subnav6'][contains(.,'Add Event')]")
	WebElement addEvents;

	@FindBy(className = "changePeople")
	WebElement changeAssignPeople;

	public void clickShowEvents() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement showEvent = wait.until(ExpectedConditions.visibilityOf(showEvents));
			showEvent.click();
			Myutilities.sleepFor(2000);
		} catch (TimeoutException e) {
			e.printStackTrace();
			logger.info("an exception occurred Since I am already on the same page so it is continuous.");
		}

	}

	public void clickPastEventCalenderOf(String month, String year) {
		int i = 0;
		while (driver.findElements(By.xpath("//h2[contains(.,'" + month + " " + year + "')]")).size() == 0 && i < 20) {
			i++;
			driver.findElement(By.xpath("//button[@aria-label='prev']")).click();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void clickFutureEventCalenderOf(String month, String year) {
		int i = 0;
		while (driver.findElements(By.xpath("//h2[contains(.,'" + month + " " + year + "')]")).size() == 0 & i < 12) {

			driver.findElement(By.xpath("//button[@aria-label='next']")).click();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void clickEvent(String event) {
		driver.findElement(By.xpath("//span[@class='fc-title'][contains(.,'" + event + "')]")).click();
	}

	public void clickChangeAssignedPeople() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement elementAssignPeople = wait.until(ExpectedConditions.elementToBeClickable(changeAssignPeople));
		elementAssignPeople.click();
		// changeAssignPeople.click();
	}

	public String getStatusOf(String username) {

		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement elementStatus = wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//select[@id='status-" + username + "']"))));
		Select select = new Select(elementStatus);
		WebElement elementOption = select.getFirstSelectedOption();
		String selectedoption = elementOption.getText();
		return selectedoption;

	}

	public void mouseHoverOnevts() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement showEvent = wait.until(ExpectedConditions.visibilityOf(showEvents));
		Actions actions = new Actions(driver);
		actions.moveToElement(showEvent).perform();
		logger.info("mouse hover on Programs Icon.");
	}

	public String calFutureDate(int days) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days);
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String fDate = format1.format(cal.getTime());
		return fDate;
	}

	public String calPastDate(int day) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, day);
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String pDate = format1.format(cal.getTime());
		return pDate;
	}

	public void addEventDetails() {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementEventName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("eventName")));
		elementEventName.click();
		elementEventName.sendKeys("Auto future Event");

		WebElement elementCourseId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("courseId")));
		elementCourseId.click();
		{
			WebElement selectCourseDropdown = driver.findElement(By.id("courseId"));
			selectCourseDropdown.findElement(By.xpath("//option[. = 'Classroom Training 1']")).click();
		}
		WebElement elmt4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("locationId")));
		elmt4.click();

		{
			WebElement selectLocationDropdown = driver.findElement(By.id("locationId"));
			selectLocationDropdown.findElement(By.xpath("//option[. = 'Automation Station 2']")).click();
		}
		WebElement elementUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		elementUsername.click();

		{
			Select selectUsername = new Select(driver.findElement(By.id("username")));
			Myutilities.sleepFor(2000);
			selectUsername.selectByValue("navaraj.manager");
		}
		WebElement elementStartDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("start_date")));
		elementStartDate.click();
		elementStartDate.sendKeys(calFutureDate(2));
		WebElement elementEndDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("end_date")));
		elementEndDate.click();
		elementEndDate.sendKeys(calFutureDate(2));
		Myutilities.sleepFor(2000);
		WebElement elementUserList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-navaauto.476")));
		elementUserList.click();
		Myutilities.sleepFor(2000);
	}

	public void saveEvent() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementSaveBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnSave")));
		elementSaveBtn.click();
		Myutilities.sleepFor(2000);
	}

	public void addEventClicks1() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement addEvent = wait.until(ExpectedConditions.visibilityOf(addEvents));
			addEvent.click();
			Myutilities.sleepFor(3000);
		} catch (TimeoutException e) {
			e.printStackTrace();
			logger.info("an exception occurred Since I am already on the same page so it is continuous.");
		}
	}

	public void pastEvent() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementPastEvent = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".section-pastEvent")));
		elementPastEvent.click();
		Myutilities.sleepFor(2000);
	}

	public void pastEventDetails() {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementEventName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("eventName")));
		elementEventName.click();
		elementEventName.sendKeys("Auto Past Event");
		WebElement elementCourseId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("courseId")));
		elementCourseId.click();
		{
			WebElement selectCourse = driver.findElement(By.id("courseId"));
			selectCourse.findElement(By.xpath("//option[. = 'Classroom Training 1']")).click();
		}
		WebElement elementLocation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("locationId")));
		elementLocation.click();

		{
			WebElement selectLocation = driver.findElement(By.id("locationId"));
			selectLocation.findElement(By.xpath("//option[. = 'Automation Station 2']")).click();
		}
		WebElement elementUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		elementUsername.click();

		{
			Select selectusername = new Select(driver.findElement(By.id("username")));
			Myutilities.sleepFor(2000);
			selectusername.selectByValue("navaraj.manager");
		}

		WebElement elementStartDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("start_date")));
		elementStartDate.click();
		elementStartDate.sendKeys(calPastDate(-2));
		WebElement elementEndDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("end_date")));
		elementEndDate.click();
		elementEndDate.sendKeys(calPastDate(-2));
		WebElement elementStartTime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("start_end_time")));
		elementStartTime.click();
		Myutilities.sleepFor(2000);
		{
			WebElement elementAssignPeople = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Assign People")));
			Actions builder = new Actions(driver);
			builder.moveToElement(elementAssignPeople).perform();
		}
		WebElement elementUserclick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-navaauto.476")));
		elementUserclick.click();
		Myutilities.sleepFor(2000);

	}

	public void searchEvent() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementEventName = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Auto Past Event']")));
		Actions build = new Actions(driver);
		build.moveToElement(elementEventName).perform();
		Myutilities.sleepFor(2000);
	}

	public void searchFtrEvent() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elemntEventName = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Auto modified']")));
		Actions build = new Actions(driver);
		build.moveToElement(elemntEventName).perform();
		Myutilities.sleepFor(2000);
	}

	public void deleteEvent() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementDeleteBtn = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modalContainer .btnDelete")));
		elementDeleteBtn.click();
		Myutilities.sleepFor(2000);
		WebElement elementUserDelete = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnDelete:nth-child(2)")));
		elementUserDelete.click();
	}

	public void clickFutureEvt() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementFutureEvent = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Auto future Event']")));
		elementFutureEvent.click();
		Myutilities.sleepFor(2000);
	}

	public void clickmodifiedEvt() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementModifiedEvent = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Auto modified']")));
		elementModifiedEvent.click();
		Myutilities.sleepFor(2000);
	}

	public void modifyFutureEvt() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementEventName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("eventName")));
		elementEventName.clear();
		elementEventName.sendKeys("Auto modified");
		WebElement elementLocation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("locationId")));
		elementLocation.click();
		{
			Select selectLocation = new Select(driver.findElement(By.id("locationId")));
			Myutilities.sleepFor(2000);
			selectLocation.selectByValue("22028");
		}

		WebElement elementUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		elementUser.click();

		{
			Select userDropDown = new Select(driver.findElement(By.id("username")));
			Myutilities.sleepFor(2000);
			// dropd3.selectByValue("user-navaauto.477");
		}

		WebElement elementMax = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("max_reg")));
		elementMax.clear();
		elementMax.sendKeys("2");
		Myutilities.sleepFor(2000);
		{
			WebElement elementAssignPeople = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Assign People")));
			Actions builder = new Actions(driver);
			builder.moveToElement(elementAssignPeople).perform();
		}
		WebElement elementUserSelection1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-navaauto.476")));
		elementUserSelection1.click();
		WebElement elementUserSelection2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-navaauto.477")));
		elementUserSelection2.click();
	}

	public void assignPlace() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementAssignPlace = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Assign Places")));
		elementAssignPlace.click();
		WebElement elementPlace = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("place-22028")));
		elementPlace.click();
		Myutilities.sleepFor(2000);
	}

	public void unassignUsers() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementUnselect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Unselect All")));
		elementUnselect.click();
		Myutilities.sleepFor(2000);
	}

	public void clickPastEvt() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement elementPastEvnt = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Auto Past Event']")));
		elementPastEvnt.click();
		Myutilities.sleepFor(5000);
	}

	public void modifyPstEvent() {
		WebDriverWait wait = new WebDriverWait(driver, 30);

		{
			WebElement elementOpen = driver.findElement(By.cssSelector(".modalOpen"));
			Actions builder = new Actions(driver);
			builder.moveToElement(elementOpen).perform();
		}
		{
			WebElement element = driver.findElement(By.tagName("body"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element, 0, 0).perform();
		}
		WebElement elementSavebtn = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector(".actionButtons:nth-child(3) > .btnSave")));
		elementSavebtn.click();
		Myutilities.sleepFor(2000);
	}
}

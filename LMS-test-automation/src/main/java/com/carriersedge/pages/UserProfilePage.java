package com.carriersedge.pages;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

import com.carriersedge.util.BaseClass;
import com.carriersedge.util.Myutilities;

/*
 * Many web elements of the user profile are in PeoplePage, so when using the profile page,
 *  make sure the same web element is not defined in People Page.
 * */
public class UserProfilePage extends BaseClass {

	// public WebDriver driver;

	public UserProfilePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logger.info("UserProfile Page initializes");

	}

	private static final Logger logger = LogManager.getLogger(UserProfilePage.class);

	@FindBy(xpath = "//*[@id=\"moduleAssign\"]/div[1]/div[5]/section/h2/span")
	WebElement moduleDriverTesting;
	@FindBy(xpath = "//*[@id=\"moduleAssign\"]/div[1]/div[5]/section/div/table/tbody/tr/td[1]/a")
	WebElement placeCourseAssign;
	@FindBy(xpath = "//form/div/button[1]")
	WebElement cancelBtn;
	@FindBy(xpath = "//h2[contains(.,'Notifications')]")
	WebElement notifications;
	@FindBy(id = "status")
	WebElement status;

	@FindBy(id = "username")
	WebElement username;
	@FindBy(id = "firstname")
	WebElement firstame;
	@FindBy(id = "lastname")
	WebElement lastname;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "confirmPassword")
	WebElement conformedPasswordTB;
	@FindBy(id = "passHint")
	WebElement passwordHint;
	@FindBy(id = "email")
	WebElement email;
	@FindBy(id = "role")
	WebElement role;
	@FindBy(id = "managerId")
	WebElement manager;
	@FindBy(id = "locationId")
	WebElement place;
	@FindBy(id = "carrierId")
	WebElement assignedCarrier;
	@FindBy(id = "langPref")
	WebElement language;
	@FindBy(id = "billed")
	WebElement billed;
	// @FindBy(xpath = "//button[@class='btnSave']") WebElement saveBtn;
	@FindBy(xpath = "(//button[contains(.,'Save')])[4]")
	WebElement saveBtn;
	@FindBy(xpath = "//button[contains(text(),'Save Assignments')]")
	WebElement saveAssignmentsBtn;

	public Boolean isModuleAssignedInProfile(String moduleName) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(notifications));
		boolean find = false;

		String str = foo.getText();
		logger.info("Looking Notification for waiting user profile open: " + str);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> elements = driver.findElements(By.xpath("//*[@id='moduleAssign']//div/table/tbody/tr//a"));

		for (int i = 0; i < elements.size(); i++) {
			String temp = elements.get(i).getText();
			logger.info("course names: " + temp);
			logger.info("Arg: " + moduleName);
			if (temp.equalsIgnoreCase(moduleName)) {
				find = true;
				logger.info("inside " + find);
				break;
			}
		}
		return find;

	}

	public void clickCancelBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(cancelBtn));
		foo.click();
		logger.info("Cancel Button clicked");

	}

	public Boolean isStatusActive() {

		WebElement option = new Select(status).getFirstSelectedOption();
		String txt = option.getText();
		logger.info("status :" + txt);
		return txt.contains("Active");
	}

	public String getUsername() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(username));
		String un = username.getAttribute("value");
		logger.info("username: " + un);
		return un;

	}

	public String getFirstname() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(firstame));
		String str = foo.getAttribute("value");
		logger.info("Firstname: " + str);
		return str;
	}

	public String getLastname() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(lastname));
		String str = foo.getAttribute("value");
		logger.info("Lastname: " + str);
		return str;
	}

	public void editFirstName(String newFirstname) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(firstame));
		foo.clear();
		foo.sendKeys(newFirstname);
	}

	public void editLastName(String newLastname) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(lastname));
		foo.clear();
		foo.sendKeys(newLastname);
	}

	// this save is only for user profile window.
	public void clickSaveBtn() {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(saveBtn));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", foo);
		foo.click();
		logger.info("Save btn clicked.");
	}

	public String getEmailAddress() {
		String str = email.getAttribute("value");
		// String str=email.getText();
		logger.info("email: " + str);
		return str;
	}

	public void setEmailAddress(String emailAddress) {
		email.clear();
		email.sendKeys(emailAddress);
	}

	public String getRole() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(this.role));

		// String role = foo.getAttribute("value");//this will give value
		WebElement foo1 = new Select(foo).getFirstSelectedOption();
		String role = foo1.getText();
		logger.info("the role : " + role);
		return role;
	}

	public void setRole(String role) {
		new Select(this.role).selectByVisibleText(role);
		logger.info("Role set : " + role);
	}

	public String getLanguage() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(language));

		String str = new Select(foo).getFirstSelectedOption().getText();

		logger.info("the language : " + str);
		return str;

	}

	public void setLanguage(String selectedLanguage) {
		new Select(language).selectByVisibleText(selectedLanguage);
		logger.info("selectedLanguage is : " + selectedLanguage);

	}

	public void setManager(String manager) {
		new Select(this.manager).selectByVisibleText(manager);
		logger.info("Manager set : " + manager);

	}

	public String getManager() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(manager));
		return new Select(foo).getFirstSelectedOption().getText();

	}

	public String getStatusOfModule(String moduleName) {

		WebElement fns = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			fns = wait.until(ExpectedConditions.visibilityOf(driver.findElement(
					By.xpath("//tr[td[a[(text()='" + moduleName + "') and @class='modalLarger']]]/td[2]"))));

			// foo =
			// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText(moduleName)
			// )));
		}
		// Catch block modified to resolve no such element
		catch (Exception ex) {
			Myutilities.sleepFor(1500);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			fns = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText(moduleName))));
			// ****Modified to get page info in case of exception
			String page = driver.getPageSource();
			logger.info(page);
			logger.info("Exception in read element");
		}

		return fns.getText();
	}

	// ****New code for Log
	/*
	 * public String getStatusOfModule(String moduleName) {
	 * 
	 * WebElement fns = null; File file =
	 * ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); try {
	 * WebDriverWait wait = new WebDriverWait(driver, 20); fns =
	 * wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
	 * "//tr[td[a[(text()='"+moduleName+"') and @class='modalLarger']]]/td[2]"))));
	 * 
	 * }
	 * 
	 * catch (Exception ex) {
	 * 
	 * //****Modified to get page info in case of exception String page =
	 * driver.getPageSource(); logger.info(page);
	 * 
	 * try { FileUtils.copyFile(file, new File("./Logs/headless_screenshot.png")); }
	 * catch (IOException e1) {
	 * 
	 * e1.printStackTrace(); } }
	 * 
	 * return fns.getText(); } //***Here
	 */
	public String[] getModuleNames(String programName) {
		List<WebElement> eles = driver
				.findElements(By.xpath("//section[h2[span[contains(.,'" + programName + "')]]]/div//a"));
		String[] mod = new String[eles.size()];
		logger.info("Array size: " + eles.size());
		for (int i = 0; i < eles.size(); i++) {
			mod[i] = eles.get(i).getText();
		}
		return mod;

	}

	public String[] getAllAssignedModules() {
		List<WebElement> eles = driver.findElements(By.xpath("//*[@id=\"moduleAssign\"]//td[1]/a"));
		String[] mod = new String[eles.size()];
		logger.info("Array size: " + eles.size());
		for (int i = 0; i < eles.size(); i++) {
			mod[i] = eles.get(i).getText();
		}
		return mod;

	}

	public int getNoOfTotalAssignedModules() {
		List<WebElement> eles = driver.findElements(By.xpath("//*[@id=\"moduleAssign\"]//td[1]/a"));
		String[] mod = new String[eles.size()];
		logger.info("Array size: " + eles.size());
		for (int i = 0; i < eles.size(); i++) {
			mod[i] = eles.get(i).getText();
		}
		return eles.size();

	}

	public void clickSaveAssignment() {
		// driver.findElement(By.xpath(" //button[contains(text(),'Save
		// Assignments')]")).click();
		saveAssignmentsBtn.click();
		logger.info("Save Assignment Clicked.");
	}

	public String[] getAllAssignedPrograms() {

		// check for Module assignments and History heading, it checks loading the
		// profile.
		List<WebElement> eles1 = driver.findElements(By.xpath("//*[@id='moduleAssign']/h2"));
		int j = 0;
		while (eles1.size() == 0 && j < 6) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			eles1 = driver.findElements(By.xpath("//*[@id='moduleAssign']/h2"));
			logger.info("500 sec waited");
			j++;

		}
		List<WebElement> eles = driver.findElements(By.xpath("//*[@id=\"moduleAssign\"]//section/h2/span"));
		String[] programs = new String[eles.size()];
		logger.info("Array size: " + eles.size());
		for (int i = 0; i < eles.size(); i++) {
			programs[i] = eles.get(i).getText();
		}
		return programs;

	}

	public void clickEmailIconInProfile() {
		int i = 0;
		while (driver.findElements(By.xpath("//a[@href='#'][contains(.,'Email Login')]")).size() == 0 && i < 6) {
			i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			logger.info("1000 ms waited");
		}
		driver.findElement(By.xpath("//a[@href='#'][contains(.,'Email Login')]")).click();

	}

}

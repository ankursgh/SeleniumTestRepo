package com.carriersedge.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.carriersedge.util.BaseClass;

public class MultiplePeopleAddPage extends BaseClass {

	public MultiplePeopleAddPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logger.info("MultiplePeopleAdd Page initializes");
	}

	String lastCreatedUser = prop.getProperty("LastCreatedUser");
	static String[] userFNames = new String[5];
	static String[] userLNames = new String[5];
	String[] Tusers = { "navaauto.1", "navaauto.2", "navaauto.4", "navaauto.5", "navaauto.6" };

	private static final Logger logger = LogManager.getLogger(MultiplePeopleAddPage.class);
	// int serialNo=0;
	@FindBy(xpath = "//li[contains(.,'Multiple People')]")
	WebElement multiplePeopleAddSelect;
	// since all firstname id's are differ by a number only,so I used the way which
	// includes all firstnames in the page.
	@FindBy(id = "firstName1")
	WebElement firstName1;
	@FindBy(xpath = "//button[@class='btnSave']")
	WebElement saveBtn;
	@FindBy(className = "btnClose")
	WebElement cancelBtn;
	@FindBy(xpath = "(//a[contains(.,'upload a file')])[1]")
	WebElement uploadFileLink;
	@FindBy(id = "fileName")
	WebElement browseBtn;
	// @FindBy(xpath = "(//[contains(.,'Browse')])") WebElement browseBtn;

	public void selectMultiplePeopleAdd() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(multiplePeopleAddSelect));
		foo.click();
		logger.info("Multiple people Add selected.");
	}

	public void addFirstname(int serialNum, String firstName) {
		String id = "firstName" + serialNum;
		driver.findElement(By.id(id)).clear();
		userFNames[serialNum - 1] = firstName;
		driver.findElement(By.id(id)).sendKeys(firstName);
	}

	public void addLastname(int serialNum, String lastName) {
		String id = "lastName" + serialNum;
		driver.findElement(By.id(id)).clear();
		userLNames[serialNum - 1] = lastName;
		driver.findElement(By.id(id)).sendKeys(lastName);
	}

	public void setPassword(int serialNum, String passwrod) {
		String id = "password" + serialNum;
		driver.findElement(By.id(id)).sendKeys(passwrod);
	}

	public void setEmail(int serialNum, String email) {
		String id = "email" + serialNum;
		driver.findElement(By.id(id)).sendKeys(email);
	}

	public void setRole(int serialNum, String role) {
		String id = "role" + serialNum;
		new Select(driver.findElement(By.id(id))).selectByVisibleText(role);
	}

	public void setLocation(int serialNum, String location) {
		String id = "location" + serialNum;
		new Select(driver.findElement(By.id(id))).selectByVisibleText(location);
	}

	public void setManager(int serialNum, String manager) {
		String id = "manager" + serialNum;
		new Select(driver.findElement(By.id(id))).selectByVisibleText(manager);
	}

	public void clickCancelBtn() {
		cancelBtn.click();
		logger.info("Cancel Btn clicked");

	}

	public void clickSaveBtn() {
		saveBtn.click();
		logger.info("Save Btn clicked");

	}

	public static String increaseStringByOneAlphabet(String string) {
		if (string.length() == 1) {
			if (string.equals("z"))
				return "aa";
			else if (string.equals("Z"))
				return "Aa";
			else
				return (char) (string.charAt(0) + 1) + "";
		}
		if (string.charAt(string.length() - 1) != 'z') {
			return string.substring(0, string.length() - 1) + (char) (string.charAt(string.length() - 1) + 1);
		}
		return increaseStringByOneAlphabet(string.substring(0, string.length() - 1)) + "a";
	}

	public void logCreatedUserNames() {
		for (int i = 0; i < userFNames.length; i++) {
			logger.info(i + 1 + "th user " + userFNames[i] + "." + userLNames[i]);
		}
	}

	public void addMultipleUsers(int noOfUsers) {
		for (int i = 1; i < userFNames.length; i++) {
			addFirstname(i, "");
			addLastname(i, "");
		}
		addFirstname(1, increaseStringByOneAlphabet(lastCreatedUser));
		addLastname(1, "Multi");
		if (noOfUsers > 5) {
			userFNames = new String[noOfUsers];
			for (int i = 5; i < noOfUsers; i++)
				driver.findElement(By.xpath("//*[@id=\"multiList\"]/section/table/tbody//td/a")).click();
		}
		if (noOfUsers > 1) {
			for (int i = 2; i <= noOfUsers; i++) {
				addFirstname(i, increaseStringByOneAlphabet(userFNames[i - 2]));
				addLastname(i, "Multi");

			}
		}

		logger.info(noOfUsers + " users Added");
		prop.setProperty("LastCreatedUser", increaseStringByOneAlphabet(userFNames[noOfUsers - 1]));
		try {
			prop.store(new FileOutputStream("./Config/config.properties"), null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logCreatedUserNames();
	}

	public String getUserFName(int i) {
		return userFNames[i];
	}

	// public String getTUser(int i) {
	// return Tusers[i];
	// }
	//
	public String getUserLName(int i) {
		return userLNames[i];
	}

	public void clickUploadFile() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(uploadFileLink));
		foo.click();

		logger.info("clicked upload file link");
	}

	public void browseFile() {

		String filePath = System.getProperty("user.dir") + "\\TestData\\ExcelUpload.xls";
		logger.info("current path :" + filePath);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", browseBtn);

		StringSelection s = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
			robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
			robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
			robot.keyPress(java.awt.event.KeyEvent.VK_V);
			robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info("clicked browse file");
	}

}

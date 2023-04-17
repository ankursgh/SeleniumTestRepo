package com.carriersedge.pages;

import static org.junit.Assert.assertTrue;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.swing.JComboBox.KeySelectionManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.carriersedge.util.BaseClass;

public class PeoplePage extends BaseClass {

	public PeoplePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logger.info("People Page initializes");
	}

	private static final Logger logger = LogManager.getLogger(PeoplePage.class);
	private static String lastCreatedUsername;
	private String lastCreatedPassword;
	private String carriersName;
	// private int noOfLicense;
	private int noOfUsedLicense;//// noOfUsedLicense=getNoOfLicenseUsed();
	private int noOfDeletedUsers;
	private int noOfBilledUser;

	@FindBy(xpath = "//*[@id=\"nav3\"]/ul/li[1]")
	WebElement peopleIcon;
	// @FindBy(xpath = "//*[@id=\"nav3\"]/ul/li[1]") WebElement peopleIcon;
	@FindBy(xpath = "//li[@class='subnav3'][contains(.,'Add Someone')]")
	WebElement addSomeoneIcon;
	@FindBy(xpath = "//*[@id=\"nav3\"]/ul/li[2]")
	WebElement showOrgChartIcon;
	@FindBy(xpath = "//*[@id=\"nav3\"]/ul/li[3]")
	WebElement placesIcon;
	@FindBy(id = "username")
	WebElement addPersonUsername;
	@FindBy(id = "firstname")
	WebElement addPersonFName;
	@FindBy(id = "lastname")
	WebElement addPersonLName;
	@FindBy(id = "password")
	WebElement addPersonPassword;
	@FindBy(id = "confirmPassword")
	WebElement conformedPasswordTB;
	@FindBy(id = "passHint")
	WebElement addPersonPasswordHint;
	@FindBy(id = "email")
	WebElement addPersonEmail;
	@FindBy(xpath = "//div[@class='data error']")
	WebElement userMatchErrorMsg;
	@FindBy(id = "role")
	WebElement addPersonRole;
	@FindBy(id = "status")
	WebElement status;
	@FindBy(id = "managerId")
	WebElement assignedManager;
	@FindBy(id = "locationId")
	WebElement assignedPlace;
	@FindBy(id = "carrierId")
	WebElement assignedCarrier;
	@FindBy(id = "langPref")
	WebElement language;
	@FindBy(id = "billed")
	WebElement billed;
	@FindBy(xpath = "//a[contains(.,'Change Password')]")
	WebElement changePassword;
	@FindBy(xpath = "//a[contains(.,'Change Assignments')]")
	WebElement changeAssignments;
	@FindBy(xpath = "(//span[contains(.,'Auto')])[1]")
	WebElement placesAuto;
	@FindBy(xpath = "(//span[contains(.,'Head Office')])[1]")
	WebElement placesHeadOffice;
	@FindBy(xpath = "(//span[contains(.,'Defensive Driving - Straight Truck')])[4]")
	WebElement assignedCourseDefensiveDriving;
	@FindBy(xpath = "(//span[contains(.,'Fire Safety')])[3]")
	WebElement assignedCourseFireSafety;
	@FindBy(xpath = "//*[@id=\"people\"]/div[1]/div[2]/div[1]/section[3]/section[1]/div[3]/a[1]")
	WebElement AutoProgramAssigned;
	@FindBy(xpath = "//*[@id=\"people\"]/div[1]/div[2]/div[1]/section[3]/section[3]/div[3]/a[1]")
	WebElement HeadOfficeProgramAssigned;
	// @FindBy(xpath = "//*[@id=\"people\"]/div/div[1]/div/div[1]/div[2]/a")
	// WebElement availableSpace;

	@FindBy(xpath = "(//div[contains(.,'Total Spaces Available:')])[8]/../div[2]")
	WebElement availableSpace;
	@FindBy(xpath = "//*[@id=\"modal2\"]/div/div[7]/div[2]")
	WebElement BilledUser;

	// *[@id="modal2"]/div/div[7]/div[2]

	// @FindBy(xpath ="(//div[contains(.,'Currently in Use:')])[8]/../div[2]")
	// WebElement licenseUsed;
	@FindBy(xpath = "//div[contains(@class,'licensesUsed')]")
	WebElement licenseUsed;

	@FindBy(xpath = "(//div[contains(.,'Deleted People:')])[8]/../div[2]")
	WebElement deletedPeople;
	@FindBy(xpath = "//*[starts-with(@id,'modal')]/div/div[2]/button")
	WebElement userDeleteBtn;
	@FindBy(id = "search")
	WebElement searchName;

	@FindBy(xpath = "//button[@class='btnSave']")
	WebElement saveBtn;
	// if there is no property file than userNameMatchedRecordedtimes set to 0
	int userNameMatchedRecordedtimes = (prop.getProperty("userNameMatchedTimes") != null)
			? Integer.parseInt(prop.getProperty("userNameMatchedTimes"))
			: 0;
	int userNameMatchedtimes = 0;

	public void mouseHoverOnPeople() {
		// noOfLicense=getNoOfAvailableUsers();
		noOfUsedLicense = getNoOfLicenseUsed();
		noOfDeletedUsers = getNoOfDeletedPeople();
		// noOfBilledUser=getNoOfbilleduser();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(peopleIcon));
		logger.info("TagName : " + foo.getTagName());
		logger.info("text on people icon : " + foo.getText());

		// foo.click();

		Actions actions = new Actions(driver);
		// peopleIcon.click();
		// actions.moveToElement(foo).click().perform();
		actions.moveToElement(foo).perform();

		logger.info("mouse hover on people in People Icon.");
	}

	public void clickAddSomeone() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(addSomeoneIcon));
		foo.click();
		logger.info("Add Someone was clicked");
	}

	public String storeUsernameTemperory() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String username = addPersonUsername.getAttribute("value");
		logger.info("store username called: " + username);
		return username;
	}

	public void setUsername(String username) {
		addPersonUsername.sendKeys(username);
		logger.info("user name was set to: " + username);
	}

	public String userNameFormatChange(String username) {
		char[] chars = username.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '.')
				chars[i] = '-';
		}
		return String.valueOf(chars);
	}

	public void addPersonFirstName(String fname) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(addPersonFName));
		// for (int i = 0; i < 8; i++) {
		// foo.sendKeys(Keys.BACK_SPACE);
		// }
		foo.clear();
		foo.sendKeys(fname);
		logger.info("first name entered.");
	}

	public void addPersonLastNameWithAutoSuggest(String lname) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(addPersonLName));
		// for (int i = 0; i < 10; i++) {
		// foo.sendKeys(Keys.BACK_SPACE);
		// }
		foo.clear();
		foo.sendKeys(lname);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		int ln = userNameMatchedRecordedtimes;
		while (driver.findElements(By.xpath("//div[@class='data error']")).size() != 0) {
			ln = ln + 1;
			// for (int i = 0; i < 10; i++) {
			// foo.sendKeys(Keys.BACK_SPACE);
			// }
			foo.clear();
			foo.sendKeys((String.valueOf(ln)));
			foo.sendKeys(Keys.SPACE);
			foo.sendKeys(Keys.BACK_SPACE);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			userNameMatchedtimes = ln - userNameMatchedRecordedtimes;

		}
		// update record in property file
		if (ln > 1) {
			prop.setProperty("userNameMatchedTimes", String.valueOf(ln));
			try {
				prop.store(new FileOutputStream("./Config/config.properties"), null);
			} catch (IOException ex) {
				logger.info(ex);
			}
		}
	}

	public String getLastCreatedUsername() {
		logger.info("last saved username is :" + lastCreatedUsername);
		return lastCreatedUsername;
	}

	public void addPersonLastName(String lname) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(addPersonLName));
		// for (int i = 0; i < 10; i++) {
		// foo.sendKeys(Keys.BACK_SPACE);
		// }
		foo.clear();
		foo.sendKeys(lname);

		logger.info("last name entered.");

	}

	public void addPersonPassword(String pass) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(addPersonPassword));
		for (int i = 0; i < 8; i++) {
			foo.sendKeys(Keys.BACK_SPACE);
		}
		// This password saved for future use when need to open the added user.
		lastCreatedPassword = pass;
		foo.sendKeys(pass);
		logger.info("password entered.");
	}

	public void WriteConformedPasswordAtProfileWindow(String conformedPassword) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(conformedPasswordTB));
		for (int i = 0; i < 8; i++) {
			foo.sendKeys(Keys.BACK_SPACE);
		}

		foo.sendKeys(conformedPassword);
		logger.info("password conformed wrote.");
	}

	public void addPersonPassHint(String hint) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(addPersonPasswordHint));
		for (int i = 0; i < 8; i++) {
			foo.sendKeys(Keys.BACK_SPACE);
		}
		foo.sendKeys(hint);
		logger.info("Password Hint entered.");
	}

	public void userMatchErrorMsg(String msg) {
		int i = 0;
		if (driver.findElements(By.xpath("//div[@class='data error']")).size() == 0 && i < 8) {
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
			logger.info("250 ms waited.");
		}
		WebElement foo = userMatchErrorMsg;
		Boolean boo;
		try {
			boo = foo.getText().contains(msg);
		} catch (NoSuchElementException e) {
			logger.info("Exception occured");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			boo = foo.getText().contains(msg);

		}
		logger.info(" error msg: " + foo.getText());
		logger.info(" Arg msg: " + msg);
		assertTrue(boo);
		// assertTrue(foo.getText().contains(msg));

	}

	/** this method verify, there is no error message when cheating new username */
	public void noUsernameErrorMsg() {
		assertTrue(driver.findElements(By.xpath("//div[@class='data error']")).size() == 0);
	}

	public void clickOnChickhereOnErrorMessage() {
		driver.findElement(By.xpath("//div[@class='data error']/a")).click();
	}

	public void clickSavebtn() {
		if (storeUsernameTemperory() != null)
			lastCreatedUsername = storeUsernameTemperory();
		saveBtn.click();
		logger.info("save btn clicked.");
	}

	public void enterEmail(String eamilAdds) {
		addPersonEmail.sendKeys(eamilAdds);
		logger.info("email address set  : " + eamilAdds);
	}

	public void setPersonRole(String role) {
		new Select(addPersonRole).selectByVisibleText(role);
		logger.info("Role set : " + role);
	}

	public boolean isRolePresent(String role) {
		Boolean found = false;

		Select select = new Select(addPersonRole);
		List<WebElement> allOptions = select.getOptions();
		for (int i = 0; i < allOptions.size(); i++) {
			logger.info("role seen: " + allOptions.get(i).getText());
			if (allOptions.get(i).getText().equalsIgnoreCase(role)) {
				found = true;
				break;
			}
		}
		return found;
	}

	public String getPersonRole() {
		String role = addPersonRole.getAttribute("value");
		logger.info("the role : " + role);
		return role;
	}

	public String getAssignedManager() {
		return new Select(assignedManager).getFirstSelectedOption().getText();
	}

	public void setAssignedPlace(String place) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(assignedPlace));
		new Select(foo).selectByVisibleText(place);
		logger.info("Place set : " + place);
	}

	public String getAssignedCarrier() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String carrierName = new Select(assignedCarrier).getFirstSelectedOption().getText();
		String value = assignedCarrier.getAttribute("value");
		carriersName = carrierName;
		logger.info("assigned carrier value :" + value);
		logger.info("assigned carrier name :" + carrierName);
		return carrierName;

	}

	public String getCarrier() {
		logger.info("Carrier is : " + carriersName);
		return carriersName;
	}

	public void setAssignedCarrier(String carrierName) {
		new Select(assignedCarrier).selectByVisibleText(carrierName);
		carriersName = carrierName;
		logger.info("Carrier set : " + carrierName);
	}

	public String getBilled() {
		return billed.getAttribute("value");
	}

	public void setBilled(String bill) {
		new Select(billed).selectByVisibleText(bill);
		logger.info("Bill set : " + bill);
	}

	public Map<String, String> getLastCreatedUser() {
		Map<String, String> createdUser = new HashMap<String, String>();
		createdUser.put("username", lastCreatedUsername);
		createdUser.put("password", lastCreatedPassword);
		return createdUser;
	}

	public String getlastCreatedUsername() {
		logger.info("last username from get method: " + lastCreatedUsername);
		return lastCreatedUsername;
	}

	public void verifyDefaultCarrier() {
		String pageTitle = driver.getTitle();
		logger.info("Page Title: " + pageTitle);
		assertTrue(pageTitle.contains(getAssignedCarrier()));

	}

	public void clickChangeAssignment() {
		changeAssignments.click();
		logger.info("change Assignment Clicked");
	}

	public void clickPlacesIcon() {
		placesIcon.click();
		logger.info("Places Icon Clicked");
	}

	public void clickshowOrgChartIcon() {
		showOrgChartIcon.click();
		logger.info("showOrgChartIcon Clicked");
	}

	public void clickPlaces(String place) {
		if (place.equalsIgnoreCase("Auto")) {
			placesAuto.click();
		} else {
			placesHeadOffice.click();
		}
	}

	// hover over on the username in the peopel page.arg->username on the people
	// page.
	public void hoverOnUsernameLink(String username) {

		WebElement element = getUsernameElement(username);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		logger.info("hover over on the " + username);

	}

	public void clickOnUsername(String username) {
		getUsernameElement(username).click();
		logger.info("Click on the " + username);
	}

	/**
	 * Returns WebElement when argument is an username. ;)
	 */
	public WebElement getUsernameElement(String username) {
		// the code below functions were modified since they were giving exception on
		// server.
		noOfUsedLicense = getNoOfLicenseUsed();
		noOfDeletedUsers = getNoOfDeletedPeople();
		String text = userNameFormatChange(username);
		logger.info("Dash Username: " + text);
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"" + text + "\"]/td[6]/a"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(ele));
		return foo;
	}

	public WebElement getUserLocationElement(String username) {
		noOfUsedLicense = getNoOfLicenseUsed();
		noOfDeletedUsers = getNoOfDeletedPeople();
		String text = userNameFormatChange(username);
		logger.info("Dash Username: " + text);
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"" + text + "\"]/td[5]"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(ele));
		return foo;
	}

	public WebElement getFirstnameElement(String username) {
		String text = userNameFormatChange(username);
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"" + text + "\"]/td[3]/a"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(ele));
		return foo;
	}

	public WebElement getPlaceElement(String username) {
		String text = userNameFormatChange(username);
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"" + text + "\"]/td[5]"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(ele));
		return foo;
	}

	public WebElement getLastnameElement(String username) {
		String text = userNameFormatChange(username);
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"" + text + "\"]/td[4]/a"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(ele));
		return foo;
	}

	public WebElement getRoleElement(String username) {
		String text = userNameFormatChange(username);
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"" + text + "\"]/td[1]/a"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(ExpectedConditions.visibilityOf(ele));
		return foo;
	}

	public WebElement getUserStatusElement(String username) {
		String text = userNameFormatChange(username);
		if (driver.findElements(By.xpath("//*[@id=\"" + text + "\"]/td[7]/a")).size() == 0) {
			searchName(username);
		}

		WebElement ele = driver.findElement(By.xpath("//*[@id=\"" + text + "\"]/td[7]/a"));
		// WebDriverWait wait = new WebDriverWait(driver, 20);
		// WebElement foo = wait.until(ExpectedConditions.visibilityOf(ele));
		// return foo;
		return ele;
	}

	public void clickChangePasswordLink() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo = wait.until(ExpectedConditions.elementToBeClickable(changePassword));
		foo.click();
		logger.info("Clicked change Password in user profile");
	}

	public int getNoOfAvailableUsers() {
		int space;
		if (driver.findElements(By.xpath("//*[@id=\"people\"]/div/div[1]/div/div[1]/div[2]/span")).size() != 0) {
			WebElement foo = driver.findElement(By.xpath("//*[@id=\"people\"]/div/div[1]/div/div[1]/div[2]/span"));
			space = Integer.parseInt(foo.getText());

		} else {
			space = Integer.parseInt(availableSpace.getText());
		}
		logger.info("Available space: " + space);
		return space;
	}

	public int getNoOfLicenseUsed() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement foo = licenseUsed;

		logger.info("licenses Used:" + foo.getText());
		try {
			return Integer.parseInt(foo.getText());
		} catch (NumberFormatException e) {
			logger.info("NumberFormatException occur so 0 return " + e);
			return 0;
		}
	}

	public int getNoOfDeletedPeople() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("Deleted people:" + deletedPeople.getText());
		try {
			return Integer.parseInt(deletedPeople.getText());
		} catch (NumberFormatException e) {
			logger.info("NumberFormatException occur so 0 return " + e);
			return 0;
		}
		// return Integer.parseInt(deletedPeople.getText());
	}

	public Boolean isUsersIncreaseByOne() {
		logger.info("privious users number: " + noOfUsedLicense);
		logger.info("current users number: " + getNoOfLicenseUsed());

		return (noOfUsedLicense + 1 == getNoOfLicenseUsed());

	}

	public Boolean isCurrentlyInUseDecreasedByOne() {
		logger.info("privious users number: " + noOfUsedLicense);
		logger.info("current users number: " + getNoOfLicenseUsed());

		return (noOfUsedLicense - 1 == getNoOfLicenseUsed());
	}

	public Boolean isDeletedPeopleDecreaseByOne() {
		logger.info("privious deleted users: " + noOfDeletedUsers);
		logger.info("current deleted users: " + getNoOfDeletedPeople());
		return (noOfDeletedUsers - 1 == getNoOfDeletedPeople());
	}

	public Boolean isDeletedPeopleIncreasedByOne() {
		logger.info("privious deleted users: " + noOfDeletedUsers);
		logger.info("current deleted users: " + getNoOfDeletedPeople());
		return (noOfDeletedUsers + 1 == getNoOfDeletedPeople());
	}

	public void deleteHoveredUser() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement foo = wait.until(ExpectedConditions.elementToBeClickable(userDeleteBtn));
		foo.click();
		logger.info("User Delete clicked");
	}

	// protected void finalize() throws Throwable {
	// logger.info("PeoplePage Object Destroying");
	// }
	public void clickPeopleIcon() {
		peopleIcon.click();
	}

	// ********LMST-916*************************************************************
	public void clickavailablespace() {

		availableSpace.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int getNoOfbilleduser() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement foo = BilledUser;

		logger.info("BilledUser: " + foo.getText());
		try {
			return Integer.parseInt(foo.getText());
		} catch (NumberFormatException e) {
			logger.info("NumberFormatException occur so 0 return " + e);
			return 0;
		}
	}

	public Boolean isUsersIncrease() {
		logger.info("privious billed user: " + noOfBilledUser);
		logger.info("current billed user: " + getNoOfbilleduser());

		return (noOfBilledUser + 1 == getNoOfbilleduser());
	}

	// ****************************
	public void searchName(String nameOrID) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			WebElement foo = wait.until(ExpectedConditions.elementToBeClickable(this.searchName));
			foo.sendKeys(nameOrID);
			Thread.sleep(1000);
			foo.sendKeys(Keys.DOWN);
			foo.sendKeys(Keys.RETURN);
			Thread.sleep(500);
		} catch (Exception e) {
			logger.info("Exception occur");
		}
		// click on the first element of the search table
		logger.info("search " + nameOrID + " in people page.");
	}

	public void clickPeopleAssignedToPlace(String placeName) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// this.programName = programName;
		int i = 0;
		while ((driver.findElements(By.xpath("//li[contains(@class,'btnView1')]/a")).size() == 0 && i <= 3) || i == 0) {
			WebElement foo;
			try {
				WebDriverWait wait = new WebDriverWait(driver, 7);
				foo = wait.until(ExpectedConditions.elementToBeClickable(
						driver.findElement(By.xpath("//section[h2[span[text()='" + placeName + "']]]/div[2]/a"))));
				foo.click();
				logger.info("Assigned people on " + placeName + " Placed clicked");

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				logger.info("Assign People tab shown before:"
						+ driver.findElements(By.xpath("//li[contains(@class,'btnView1')]/a")).size());
				if ((driver.findElements(By.className("btnView1")).size()) < 1) {
					logger.info(
							"Assign People tab shown after:" + driver.findElements(By.className("btnView1")).size());
					// click outside on the top text and click on the program
					driver.findElement(By.xpath("//*[@id=\"people\"]//div[1]/p")).click();
					logger.info("Clicked again x people assigned");
					// driver.findElement(By.xpath("//span[text()='" + placeName +
					// "']/ancestor::node()/div[2]/a")).click();
					new WebDriverWait(driver, 7).until(ExpectedConditions.elementToBeClickable(driver
							.findElement(By.xpath("//span[text()='" + placeName + "']/ancestor::node()/div[2]/a"))))
							.click();

				}
			} catch (Exception ex) {
				try {
					Thread.sleep(2000);
					if (driver.findElements(By.xpath("//li[contains(@class,'btnView1')]/a")).size() == 0) {
						driver.findElement(By.xpath("//*[@id=\"people\"]//div[1]/p")).click();
						new WebDriverWait(driver, 7)
								.until(ExpectedConditions.elementToBeClickable(driver.findElement(
										By.xpath("//span[text()='" + placeName + "']/ancestor::node()/div[2]/a"))))
								.click();
						;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				logger.info("Clicked again on the x people assined in Exception");

			}
			i++;
		}
		logger.info("Clicked again on the place x people assigned " + i + " times");
	}

}

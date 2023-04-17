package com.carriersedge.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.carriersedge.util.BaseClass;
import com.carriersedge.util.Myutilities;

public class CourseContentPage extends BaseClass {

	public CourseContentPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logger.info("CourseContent Page initializes");
}

private static final Logger logger = LogManager.getLogger(CourseContentPage.class);
@FindBy(id = "btnTest")
WebElement takeFinalTestBtn;
@FindBy(id = "exit")
WebElement exitModuleWindow;
@FindBy(id = "pgTitle")
WebElement programTitle;
@FindBy(id = "acceptance")
WebElement moduleReadacknowledgeCB;

public void clikExitCourseWindow() {
	WebDriverWait wait = new WebDriverWait(driver, 20);
	WebElement foo = wait.until(ExpectedConditions.visibilityOf(exitModuleWindow));
	foo.click();
	logger.info("Exit module clicked");
}

public String getProgramTitle() {
	WebDriverWait wait = new WebDriverWait(driver, 20);
	WebElement foo = wait.until(ExpectedConditions.visibilityOf(programTitle));
	String str = foo.getText();

	logger.info("Program Title: " + str);
	return str;

}

public int getIframeSize() {
	int size = driver.findElements(By.tagName("iframe")).size();
	return size;
}

public void goToNextIframe() {

	WebDriverWait wait = new WebDriverWait(driver, 20);
	// WebElement foo=wait.until(ExpectedConditions.visibilityOf(programTitle));
	int size = driver.findElements(By.tagName("iframe")).size();
	logger.info("iframe size: " + size);
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("iframe")));
	driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
	try {

		Myutilities.sleepFor(500);
	} catch (NoSuchFrameException e) {
		logger.info("No such ********Frame*****");

	}
}

public void backToDefaultIframe() {
	driver.switchTo().defaultContent();
}

public void scrowlTheCourseContainer() {
	// if(!driver.findElements(By.id("btnContinue")).isEmpty()) {
	// clickContinueOnModule();
	// }
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
	JavascriptExecutor efw = new EventFiringWebDriver(driver);
	WebDriverWait wait = new WebDriverWait(driver, 20);
	WebElement foo = wait.until(
			ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"pf1\"]/div[1]/div[25]"))));

	try {
		efw.executeScript("arguments[0].scrollIntoView(true)", foo);
	} catch (Exception e) {
		logger.info(e.getSuppressed() + " No scroll bar");
	}
	driver.switchTo().parentFrame();
}

public void scrowlThePDFCourseContainer() {

	// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
	Myutilities.sleepFor(500);
	JavascriptExecutor efw = new EventFiringWebDriver(driver);

	try {

		efw.executeScript("document.getElementById('page-container').scrollTop= 450");
		// efw.executeScript("$(\"#page-container\").animate({ scrollTop: \"400px\"
		// })");

		logger.info("small scroll");
		// efw.executeScript("window.scrollBy(0,450)");

		// efw.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		logger.info("whole scroll");
	} catch (Exception e) {
		logger.info(" No scroll bar");
	}
	driver.switchTo().parentFrame();
}

/**
 * Clicks Continue button on the module when the continue option appears in the
 * module running window.
 */
public void clickContinueOnModule() {
	WebElement element = driver.findElement(By.id("btnContinue"));
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript("arguments[0].click();", element);
}

// **Click on the blue button on the module on the page.*/
public void clickContinueBlueArrow() {
	List<WebElement> eles = driver.findElements(By.cssSelector("#continue > img"));
	Myutilities.sleepUntilVisibleWebElements("//*[@id='continue']/img", 1000);
	WebElement ele = driver.findElement(By.cssSelector("#continue > img"));
	WebDriverWait wait = new WebDriverWait(driver, 20);
	WebElement foo = wait.until(ExpectedConditions.elementToBeClickable(ele));
	foo.click();
}

public void clickNextArrow() {
	// Selenium dynamic wait did not work, so I used my own dynamic wait
	Myutilities.sleepUntilVisibleWebElements("//*[@id='div_next']", 300);

	driver.findElement(By.id("div_next")).click();
}

public void clickNextArrowUntilVisibleOfTestBtn() {
	List<WebElement> eles = driver.findElements(By.cssSelector("#btnFinalTest > button"));
	int i = 0;
	while (eles.size() == 0 && i < 35) {
		i++;
		Myutilities.sleepFor(250);

		eles = driver.findElements(By.cssSelector("#btnFinalTest > button"));
		if (eles.size() < 1) {
			try {
				clickNextArrow();
			} catch (Exception e) {
				e.printStackTrace();
			}

			logger.info("clicked " + i + " times");
		}
	}
	logger.info("sleep " + i + "times and size " + eles.size());
}

public void clickFinalTestBtn() {
	driver.findElement(By.cssSelector("#btnFinalTest > button")).click();
}

public void clickTakeFinalTestBtnOnPDFModule() {
	takeFinalTestBtn.click();
}

public void clickNextArrowUntilVisible() {
	Myutilities.sleepFor(1000);
	List<WebElement> eles = driver.findElements(By.id("div_next"));
	logger.info("arrow seen " + eles.size());
	int i = 0;
	while (eles.size() == 1 && i < 35) {
		i++;
		Myutilities.sleepFor(200);
		eles = driver.findElements(By.id("div_next"));
		logger.info("arrow seen " + eles.size());

		if (eles.size() == 1) {
			try {

				clickNextArrow();
				logger.info("clicked on arrow");

			} catch (Exception e) {
				e.printStackTrace();
			}

			logger.info("clicked " + i + " times");
		}
	}
	logger.info("sleep " + i + "times and size " + eles.size());
	}

	public Boolean checkModuleAcknowledgeCB() {
		return moduleReadacknowledgeCB.isDisplayed();
	}

}

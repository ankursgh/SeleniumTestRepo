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

public class RiversAddEventPage extends BaseClass{
	public RiversAddEventPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logger.info("ProgramsPage initializes");
	}
	private static final Logger logger = LogManager.getLogger(RiversAddEventPage.class);
	
	public void clickOnEvents() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement evts1 = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Show Events"))));
		evts1.click();
	}
}

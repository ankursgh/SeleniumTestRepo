package com.carriersedge.util;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {
	private static final Logger logger = LogManager.getLogger(BrowserFactory.class);
	private static String OS = System.getProperty("os.name").toLowerCase();
	static String currentDir = System.getProperty("user.dir");

	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) {

		if (browserName.equalsIgnoreCase("Chrome"))

		{
			if (isMac()) {

				/*
				  //For Headless Browser 
				 System.setProperty("webdriver.chrome.driver",
				  "/Users/ankurshukla/ExternalJars/chromedriver"); ChromeOptions options=new
				  ChromeOptions(); options.addArguments("window-size=1400,800");
				  options.addArguments("window-size=1920,1080");
				  options.addArguments("--start-maximized");
				  options.addArguments("disable-infobars");
				  options.addArguments("--disable-extensions");
				  options.addArguments("--disable-web-security", "--user-data-dir=true",
				  "--allow-running-insecure-content"); 
				  options.addArguments("--headless");
				  options.addArguments("--disable--gpu");
				  options.addArguments("--allow-insecure-localhost");
				  
				  //options.addArguments("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.109 Safari/537.36" );
				  
				
				  options.setHeadless(true); driver= new ChromeDriver(options);
				  logger.info("chrome Browser lunched in headless browser mode in "+OS);
				 */

				//*
				System.setProperty("webdriver.chrome.driver", "/Users/ankurshukla/ExternalJars/chromedriver");

				driver = new ChromeDriver();
				// ((RemoteWebDriver) driver).setLogLevel(Level.INFO);
				logger.info("chrome Browser lunched in " + OS);

				 //*/
			} else if (isUnix()) {

				// For Headless Browser
				// /*
				System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--no-sandbox"); // Bypass OS security model
				options.addArguments("--start-maximized");
				options.addArguments("--disable-dev-shm-usage");
				options.addArguments("--headless"); // if not headless comment this line
				options.addArguments("window-size=1920,1080");
				driver = new ChromeDriver(options);
				logger.info("chrome Browser lunched in headless browser mode.in :" + OS);
				// */

				/*
				 * System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
				 * driver = new ChromeDriver(); logger.info("chrome Browser lunched in " + OS);
				 */
			}

		} else if (browserName.equalsIgnoreCase("Firefox")) {

			if (isWindows()) {
				System.setProperty("webdriver.gecko.driver", "/Users/ankurshukla/ExternalJars/geckodriver 4");
				driver = new FirefoxDriver();
				logger.info("Firefox Browser lunched in :" + OS);

			} else if (isUnix()) {
				// For Headless Browser

				FirefoxBinary firefoxBinary = new FirefoxBinary();
				firefoxBinary.addCommandLineOptions("--headless");
				System.setProperty("webdriver.gecko.driver", "/Users/ankurshukla/ExternalJars/geckodriver 4");
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.setBinary(firefoxBinary);
				driver = new FirefoxDriver(firefoxOptions);
				logger.info("Firefox Browser lunched in headless browser mode.in :" + OS);
			}

		} else if (browserName.equalsIgnoreCase("IE")) {
			logger.info("IE Browser lunched in :" + OS);
			System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
			logger.info("Property set.");

			driver = new InternetExplorerDriver();
			logger.info("IE Browser lunched in :" + OS);

		} else {
			logger.info("Error: The Browser is not specified. please specify the browser.");

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		logger.info("URL navigating");
		driver.get(appURL);
		// driver.navigate().to(appURL);
		// driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		return driver;
	}

	public static void quitBrowser(WebDriver driver) {

		driver.quit();
		driver = null;

	}

	public static void closeBrowser(WebDriver driver) {

		driver.close();

	}

	public static boolean isWindows() {

		return (OS.indexOf("win") >= 0);

	}

	public static boolean isMac() {

		return (OS.indexOf("mac") >= 0);

	}

	public static boolean isUnix() {

		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);

	}

	public static boolean isSolaris() {

		return (OS.indexOf("sunos") >= 0);

	}

}

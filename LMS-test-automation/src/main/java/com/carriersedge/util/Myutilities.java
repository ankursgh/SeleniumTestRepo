package com.carriersedge.util;

import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Myutilities extends BaseClass {

	public Myutilities(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logger.info("Home Page initializes");
	}

	private static final Logger logger = LogManager.getLogger(Myutilities.class);
	static String snippet;

	// Method used to extract 6 digit from a given string
	public static String extractDigits(final String in) {
		String regex = "(\\d{6})";
		final Pattern p = Pattern.compile(regex);
		final Matcher m = p.matcher(in);
		if (m.find()) {
			return m.group(0);
		}
		return "";
	}

	// use for matching the verification code email template to reset user password.
	public static Boolean matchEmailPattern() {
		if (snippet == null) {

			sleepFor(6000);
			snippet = GMail.getGmailSnipet("subject:Verification code to reset password");

		}
		String content = snippet;
		System.out.println("Email content " + content);
		String regex = "Hello .*, We have received a request to reset your password. Your verification code is (\\d{6}) This verification code is only valid for the next 12 hours..*";

		logger.info("Email Pattern matched: " + Pattern.matches(regex, content));
		return Pattern.matches(regex, content);
	}

	/**
	 * Return verification code in the string format from
	 * "carriersedgetest@gmail.com" email latest message, this email is used by only
	 * nava.abc user
	 */
	public static String getCodeFromEmail() {
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		snippet = GMail.getGmailSnipet("subject:Verification code to reset password");

		return extractDigits(snippet);
	}

	/**
	 * Return verification code in the string format from
	 * "carriersedgetest@gmail.com" email latest message, this email is used by only
	 * nava.abc user
	 */
	public static String getSnippetFromEmail(String subject) {
		sleepFor(8000);
		snippet = GMail.getGmailSnipet("subject:" + subject);
		logger.info("snippet :" + snippet);

		return snippet;
	}

	/**
	 * Return verification code in the string format from
	 * "carriersedgemutiuserstest@gmail.com" email latest message
	 */
	public static String getCodeFromEmailOfMultipleUser() {
		sleepFor(8000);
		snippet = GMailMultipleUsers.getGmailSnipet("subject:Verification code to reset password");
		logger.info("Email snippet multiple user email : " + snippet);

		return extractDigits(snippet);
	}

	/**
	 * Return small message portion from "carriersedgemutiuserstest@gmail.com" email
	 * latest message
	 */
	public static String getSnippetFromEmailOfMultipleUser(String subject) {

		sleepFor(10000);

		snippet = GMailMultipleUsers.getGmailSnipet("subject:" + subject);

		return snippet;
	}

	public static String getMultipleUsersEmailMessage(String subject) {
		return GMailMultipleUsers.getGmailAllMessage("subject:" + subject);

	}

	/**
	 * Return latest verification code from email:
	 * "processautomationshare@gmail.com" message*, the email used only for
	 * ProcessAutomation carrier
	 */
	public static String getCodeFromProcessAutomationShareEmail() {

		sleepFor(10000);

		snippet = GMailProcessAutomationShare.getGmailSnipet("subject:Verification code to reset password");
		logger.info("Email snippet multiple user email : " + snippet);

		return extractDigits(snippet);
	}

	/**
	 * Return String from G-mail of "processautomationshare@gmail.com", please use
	 * this email only for 'ProcessAutomation' users only if necessary
	 */
	public static String getSnippetFromProcessAutomationShareEmail(String subject) {

		sleepFor(10000);
		snippet = GMailProcessAutomationShare.getGmailSnipet("subject:" + subject);

		return snippet;
	}

	public static String getRandomName() {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 6;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String randomName = buffer.toString();

		// logger.info(randomName);
		return randomName;
	}

	public static String getRandomEmail() {
		return (getRandomName() + "@Carriersedge.com");
	}

	public static void main(String[] args) {
		// logger.info(getSnippetFromProcessAutomationShareEmail("Carriers, finish
		// setting up your new Google Account"));
		logger.info(getMultipleUsersEmailMessage("New training has been assigned to you"));
		logger.info(getSnippetFromEmailOfMultipleUser("New training has been assigned to you"));
		// System.out.println("SnippedFrom multiple :
		// "+getSnippetFromEmailOfMultipleUser("ABC Trucklines / CarriersEdge account
		// created for you"));

	}

	/**
	 * is Number return true only if the String Argument can be converted into
	 * double
	 */
	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static void sleepFor(int milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("Sleep for: " + milliSeconds + " ms");
	}

	// /**The dynamic sleep checks the (Arg1)WebElements for (Arg2) second, if it
	// finds any web element, it will stop sleeping; the maximum times of checking
	// is 8 times.*/
	// public static void sleepUntilVisibleWebElements(List<WebElement> eles,int
	// checkingTime) {
	// List<WebElement> eles1=eles;
	// int i=0;
	// while(eles1.size()==0&&i<8) {
	// i++;
	// sleepFor(checkingTime);
	// eles1=eles;
	// }
	// logger.info("Sleep for: "+i+" "+checkingTime+" ms");
	// }

	/**
	 * The dynamic sleep checks the (Arg1) xpath for (Arg2) seconds for web element,
	 * if it finds any web element, it will stop sleeping; the maximum times of
	 * checking is 8 times.
	 */
	public static void sleepUntilVisibleWebElements(String xpath, int checkingTime) {
		List<WebElement> eles = driver.findElements(By.xpath(xpath));
		int i = 0;
		while (eles.size() == 0 && i < 20) {
			i++;
			sleepFor(checkingTime);
			eles = driver.findElements(By.xpath(xpath));
			logger.info("until sleep for: " + checkingTime + " ms");
		}
		logger.info("until Sleep for: " + i + " " + checkingTime + " ms");
	}

}

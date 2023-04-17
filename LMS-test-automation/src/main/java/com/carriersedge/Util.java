package com.carriersedge;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Util {

	private static final Logger logger = LogManager.getLogger(Util.class);

	public static WebDriver driver;

	public static void main(String[] args) {

		// DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		// DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		// LocalDateTime tomorrow = LocalDateTime.now().plusDays(1);
		// System.out.println(dtf.format(tomorrow));
		// String str="12o";
		// int i=Integer.parseInt(str);

	}

	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}

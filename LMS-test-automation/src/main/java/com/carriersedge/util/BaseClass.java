package com.carriersedge.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;

	public BaseClass() {

		try {
			prop = new Properties();
			// FileInputStream ip = new
			// FileInputStream("C:\\Users\\navra\\git\\LMS-Test\\src\\main\\java\\com\\carriersedge\\config\\config.properties");
			//// "./Config/conf.properties");
			FileInputStream ip = new FileInputStream("./Config/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	// public void initializtion() {
	// driver=BrowserFactory.startApplication(driver,
	// prop.getProperty("browserName"), prop.getProperty("url"));
	// }

}

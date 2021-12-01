package com.neotech.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public static WebDriver driver;
	/**
	 *  This method will create the driver and return it
	 *  
	 * @return WebDriver driver
	 */

	public static WebDriver setUp() {

		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

		if (ConfigsReader.getPropertyFromProp("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
		} else if (ConfigsReader.getPropertyFromProp("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
			driver = new FirefoxDriver();
		}
        driver.manage().window().maximize();
		driver.get(ConfigsReader.getPropertyFromProp("url"));
		return driver;
	}

	/**
	 * This method will quit the browser
	 * 
	 */
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}   

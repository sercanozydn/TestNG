package com.neotech.lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class Homework extends CommonMethods {
	/*
	 * Homework 1: HRMS Application Negative Login:
	 * 
	 * 1. Open chrome browser 2. Go to “https://opensource-demo.orangehrmlive.com/”
	 * 3. Enter valid username 4. Leave password field empty 5. Verify error message
	 * with text “Password cannot be empty” is displayed.
	 */

	@BeforeMethod
	public void openBrowser() {
		setUp();
	}

	@AfterMethod
	public void quiteBrowser() {
		tearDown();
	}

	@Test
	public void validUsername() {
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getPropertyFromProp("AdminForOrange"));
		sendText(driver.findElement(By.id("txtPassword")), "");
		click(driver.findElement(By.id("btnLogin")));

		String expectedText = "Password cannot be empty";
		String actualText = driver.findElement(ByChained.id("spanMessage")).getText();

		if (actualText.equals(expectedText)) {
			System.out.println("Test is Passed. Because, Actual text is: " + actualText);
		} else {
			System.out.println("Test is Failed. Because, Actual text is: " + actualText);

		}

	}

}

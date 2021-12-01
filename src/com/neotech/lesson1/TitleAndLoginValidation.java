package com.neotech.lesson1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class TitleAndLoginValidation extends CommonMethods {

	@BeforeMethod
	public void openAndNavigate() {
		setUp();
	}

	@AfterMethod
	public void quiteBrowser() {
		tearDown();
	}

	@Test
	public void titleValidation() throws Exception {
		String expectedTitle = "OrangeHRM";
		String actualTitle = driver.getTitle();

		if (expectedTitle.equals(actualTitle)) {
			System.out.println("Title Validatiom Passed");
		} else {
			System.out.println("Title Validatiom Failed");
			throw new Exception();
		}

		wait(2);
	}

	@Test
	public void logoValidation() {
		WebElement logo = driver.findElement(By.xpath("//div[@id='divLogo']/img"));
		boolean isDisplayed = logo.isDisplayed();

		if (isDisplayed) {
			System.out.println("Logo Validation Passed!");
		} else {
			System.out.println("Logo Validation Falied!");
		}

		wait(2);
	}

	@Test
	public void loginValidation() {
		WebElement username = driver.findElement(By.id("txtUsername"));

		sendText(username, ConfigsReader.getPropertyFromProp("AdminForOrange"));
		wait(1);
		WebElement password = driver.findElement(By.id("txtPassword"));

		sendText(password, ConfigsReader.getPropertyFromProp("PasswordForOrange"));
		wait(1);
		click(driver.findElement(By.id("btnLogin")));

		wait(2);

		WebElement text = driver.findElement(By.id("welcome"));

		boolean appear = text.isEnabled();

		if (appear) {
			System.out.println("Test is pass");
		} else {
			System.out.println("Test is failed");
		}

	}

}

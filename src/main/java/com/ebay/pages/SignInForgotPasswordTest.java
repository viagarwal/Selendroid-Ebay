package com.ebay.pages;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInForgotPasswordTest extends SetUp {

	@Test
	public void testShouldBeAbleToEnterText() {

		if (driver.findElement(By.id("accept_btn")).isEnabled()
				&& driver.findElement(By.id("accept_btn")).isDisplayed()) {
			driver.findElement(By.id("accept_btn")).click();
		}
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("button_register")));
		driver.findElement(By.id("button_register")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.linkText("SIGN IN")));
		driver.findElement(By.linkText("SIGN IN")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("sign_in_forgot")));
		driver.findElement(By.id("sign_in_forgot")).click();
		// driver.findElement(By.id("register_button")).click();
		// driver.findElement(By.id("sign_in_username_entry")).sendKeys("Priyanka");
		// driver.findElement(By.id("sign_in_password_entry")).sendKeys("Agarwal");
		// driver.findElement(By.id("sign_in_button")).click();
	}

	@AfterClass
	public static void stopSelendroidServer() {

		if (driver != null) {
			driver.quit();
		}
		if (selendroidLucncher != null) {
			selendroidLucncher.stopSelendroid();
		}
	}

}

package com.ebay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class RegisterNewUser extends SetUp {

	@Test
	public void testShouldBeAbleToEnterText() {

		if (driver.findElement(By.id("accept_btn")).isEnabled()
				&& driver.findElement(By.id("accept_btn")).isDisplayed()) {
			driver.findElement(By.id("accept_btn")).click();
		}
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("button_register")));
		driver.findElement(By.id("button_register")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("register_button")));
		driver.findElement(By.id("register_button")).click();
		driver.switchTo().window("WEBVIEW");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By
				.id("progress_layout")));
		driver.findElement(By.id("firstname")).click();
		driver.findElement(By.id("firstname")).sendKeys("vipul");
		// Enter text in dayPhone
		driver.findElement(By.id("dayphone1")).click();
		driver.findElement(By.id("dayphone1")).sendKeys("9999999");
		driver.findElement(By.id("lastname")).sendKeys("agarwal");
		// Enter text in address1
		driver.findElement(By.id("address1")).sendKeys("kkkkkk");
		// Enter text in address2
		driver.findElement(By.id("address2")).sendKeys("jagadishnagar");
		// Enter text in zip
		driver.findElement(By.id("zip")).sendKeys("560075");
		// Enter text in city
		driver.findElement(By.id("city")).sendKeys("Bangalore");
		// Enter text in email
		driver.findElement(By.id("email")).sendKeys("vipul@gmail.com");

		// Click on PASSWORD
		driver.findElement(By.id("state")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Karnataka')]"))
				.click();
		driver.findElement(By.id("PASSWORD")).sendKeys("iluvbareilly");
		driver.findElement(By.className("re-pw9")).sendKeys("iluvbareilly");
		driver.findElement(By.id("sbtBtn")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Continue')]"))
				.click();
		;

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

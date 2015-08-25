package com.ebay.pages;

import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class EbaySearch extends SetUp {

	@Test
	public void testShouldBeAbleToEnterText() {

		if (driver.findElement(By.id("accept_btn")).isEnabled()
				&& driver.findElement(By.id("accept_btn")).isDisplayed()) {
			driver.findElement(By.id("accept_btn")).click();
		}
		WebElement inputField = driver.findElement(By.id("home_search_text"));
		inputField.clear();
		inputField.sendKeys("Ebay");
		driver.findElement(By.id("search_go_btn")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("search_go_btn")));
		
		WebElement list = driver.findElement(By.id("price_layout"));
		new TouchActions(driver).flick(list, 0, -100, 0).perform();
		
		List<WebElement> el = driver.findElements(By.tagName("RelativeLayout"));
		for (WebElement webElement : el) {
		if(webElement.findElement(By.tagName("TextView")).isDisplayed()){
		List<WebElement> ell =  webElement.findElements(By.tagName("TextView"));
		for (WebElement webElement2 : ell) {
		System.out.println(webElement2.getText());
		 if
		 ("Brand New Original LG Google Nexus 5".contains(webElement2.getText()))
		 {
		 driver.findElement(By.id("root_cell_layout")).click();
		 break;
		 }
		 }
		 }
		 break;
		 }

		// WebElement pages = driver.findElement(By.id("price_layout"));
		// TouchActions flick = new TouchActions(driver).flick(pages, -100, 0,
		// 0);
		// flick.perform();
		// driver.findElement(By.xpath("//*[@id='image_frame']))
		// driver.findElement(By.xpath("(//FrameLayout[@id='image_frame'])[1]")).click();
		// driver.findElement(By.xpath("//ImageViewPager[@id='image_view_pager']")).click();
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id<locator>));

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

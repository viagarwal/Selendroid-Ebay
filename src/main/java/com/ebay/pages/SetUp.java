package com.ebay.pages;

import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.standalone.SelendroidConfiguration;
import io.selendroid.standalone.SelendroidLauncher;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

public class SetUp {

	public static SelendroidLauncher selendroidLucncher = null;
	public static WebDriver driver = null;

	@BeforeSuite
	public static void startSelendroidServer() throws Exception {

		if (selendroidLucncher != null) {
			selendroidLucncher.stopSelendroid();
		}
		SelendroidConfiguration config = new SelendroidConfiguration();
		config.addSupportedApp("src/main/resources/ebaymobile2.7.0.118.apk");
		selendroidLucncher = new SelendroidLauncher(config);
		selendroidLucncher.launchSelendroid();
		SelendroidCapabilities caps = new SelendroidCapabilities(
				"com.ebay.mobile:2.7.0.118");
		driver = new SelendroidDriver(caps);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}

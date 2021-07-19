package com.ui.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public enum DriverType implements WebDriverSetup {

	CHROME {
		@Override
		public WebDriver getDriverObject(boolean isHeadless) {
			ChromeOptions options = new ChromeOptions();
			options.setHeadless(isHeadless);
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver(options);

		}
	},
	FIREFOX {
		@Override
		public WebDriver getDriverObject(boolean isHeadless) {

			FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(isHeadless);
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver(options);

		}
	}

}
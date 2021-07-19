package com.ui.automation.base;

import org.openqa.selenium.WebDriver;

import com.ui.automation.common.Constants;

public class DriverFactory {

	private WebDriver driver;
	private DriverType selectedDriverType;
	private String browser;
	private boolean isHeadless = false;

	public DriverFactory() {

		try {
			browser = System.getProperty(Constants.browser).toUpperCase();
			isHeadless = Boolean.getBoolean(Constants.headless);
			selectedDriverType = DriverType.valueOf(browser);

		} catch (IllegalArgumentException ex) {
			System.err.println("Unknown driver specified");

		} catch (NullPointerException ex) {
			System.err.println("No Driver Specified");
		}

	}

	public WebDriver getDriver() {
		if (null == driver) {
			webDriverInstantiate(selectedDriverType);
		}
		return driver;
	}

	private void webDriverInstantiate(DriverType driverType) {
		driver = driverType.getDriverObject(isHeadless);
	}

	void quitDriver() {
		if (null != driver) {
			driver.quit();
			driver = null;
		}
	}
}
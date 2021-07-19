package com.ui.automation.base;

import org.openqa.selenium.WebDriver;

public interface WebDriverSetup {

	WebDriver getDriverObject(boolean isHeadless);
}

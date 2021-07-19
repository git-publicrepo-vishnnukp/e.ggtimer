package com.ui.automation.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ui.automation.common.EnvEnums;

public class DriverBase {

	private static List<DriverFactory> webDriverThreadPool = Collections
			.synchronizedList(new ArrayList<DriverFactory>());

	private static ThreadLocal<DriverFactory> driverThread;

	@BeforeSuite(alwaysRun = true)
	public static void instantiateDriverObject() {
		driverThread = new ThreadLocal<DriverFactory>() {
			@Override
			protected DriverFactory initialValue() {
				DriverFactory webDriverThread = new DriverFactory();
				webDriverThreadPool.add(webDriverThread);
				return webDriverThread;
			}
		};
	}

	public static WebDriver getDriver() {
		return driverThread.get().getDriver();
	}

	@BeforeMethod(alwaysRun = true)
	public static void maximizeBrowser() {
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod(alwaysRun = true)
	public static void clearCookies() {
		getDriver().manage().deleteAllCookies();
	}

	@AfterSuite(alwaysRun = true)
	public static void closeDriverObjects() {
		for (DriverFactory webDriverThread : webDriverThreadPool) {
			System.out.println("Browser closed");
			webDriverThread.quitDriver();
		}
	}
}
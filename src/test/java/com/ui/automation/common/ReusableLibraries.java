package com.ui.automation.common;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ui.automation.data.PropertiesReader;

public abstract class ReusableLibraries {

	private WebDriver driver;
	private WebDriverWait wait;
	protected PropertiesReader props;

	public ReusableLibraries(WebDriver webDriver) {
		this.driver = webDriver;
		this.props = new PropertiesReader(System.getProperty(Constants.env));
	}

	protected void navigateUrl(String url) {
		try {
			driver.get(url);
		} catch (Exception ex) {
			System.err.println("Unable to load the url : " + url);
		}

	}

	protected void enterText(String locator, String text) {
		try {
			driver.findElement(By.xpath(locator)).clear();
			driver.findElement(By.xpath(locator)).sendKeys(text);
		} catch (NoSuchElementException ex) {
			throw new NoSuchElementException("Unable to locate element : " + locator);
		}
	}

	protected void click(String locator) {
		try {
			driver.findElement(By.xpath(locator)).click();
		} catch (NoSuchElementException ex) {
			throw new NoSuchElementException("Unable to locate element : " + locator);
		}
	}

	protected boolean waitForElementToBeVisible(String locator) {

		try {
			wait = new WebDriverWait(driver,
					Integer.parseInt(props.getKeyValue(EnvEnums.EXPLICIT_WAIT_TIME_IN_MILLISECONDS.getValue())));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
			return true;
		} catch (Exception ex) {
			throw new NoSuchElementException("Unable to locate element : " + locator);
		}
	}

	protected String getElementText(String locator) {
		try {
			return driver.findElement(By.xpath(locator)).getText();
		} catch (NoSuchElementException ex) {
			throw new NoSuchElementException("Unable to locate element : " + locator);
		}
	}
}
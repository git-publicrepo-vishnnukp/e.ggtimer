package com.ui.automation.pageobjects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.openqa.selenium.WebDriver;

import com.ui.automation.base.DriverBase;
import com.ui.automation.common.Locators;
import com.ui.automation.common.ReusableLibraries;

import io.qameta.allure.Step;

public class CountDownTimerPage extends ReusableLibraries {

	private WebDriver driver;

	public CountDownTimerPage() {
		super(DriverBase.getDriver());
		this.driver = DriverBase.getDriver();
	}

	public CountDownTimerPage and() {
		return this;
	}

	@Step("Wait for the count down timer to get started")
	public CountDownTimerPage countDownTimerProgressStarted() {
		assertThat(true, is(waitForElementToBeVisible(Locators.lbl_timerInProgress)));
		return this;
	}

	@Step("Verify count down timer works")
	public CountDownTimerPage countDownTimerWorking() {
		System.out.println(getElementText(Locators.lbl_timerInProgress));
		return this;
	}
}
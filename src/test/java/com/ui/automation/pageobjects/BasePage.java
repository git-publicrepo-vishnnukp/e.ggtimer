package com.ui.automation.pageobjects;

import org.openqa.selenium.WebDriver;

import com.ui.automation.base.DriverBase;
import com.ui.automation.common.EnvEnums;
import com.ui.automation.common.Locators;
import com.ui.automation.common.ReusableLibraries;

import io.qameta.allure.Step;

public class BasePage extends ReusableLibraries {

	private WebDriver driver;

	public BasePage() {
		super(DriverBase.getDriver());
		this.driver = DriverBase.getDriver();
	}

	@Step("Navigate to the e.ggtimer.com")
	public BasePage navigateToHomePage() {
		navigateUrl(props.getKeyValue(EnvEnums.APPLICATION_URL.getValue()));
		return this;
	}

	public BasePage and() {
		return this;
	}

	@Step("Enter the time for the count down timer")
	public BasePage enterCountDownTimer() {
		enterText(Locators.txt_countDownTime, props.getKeyValue("enter_time"));
		return this;
	}

	@Step("Start the timer")
	public BasePage startTheTimer() {
		click(Locators.btn_countDownStart);
		return this;
	}

}
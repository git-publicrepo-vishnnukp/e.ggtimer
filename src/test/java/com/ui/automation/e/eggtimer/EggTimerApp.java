package com.ui.automation.e.eggtimer;

import org.testng.annotations.Test;

import com.ui.automation.base.DriverBase;
import com.ui.automation.pageobjects.BasePage;
import com.ui.automation.pageobjects.CountDownTimerPage;

import io.qameta.allure.Description;
import io.qameta.allure.Story;

public class EggTimerApp extends DriverBase {

	@Story("Launch e.ggtimer.com and enter the count down timer and click start")
	@Description("Launching e.ggtimer page")
	@Test
	public void t1() {

		System.out.println("Thread process id : " + Thread.currentThread().getId());

		new BasePage().navigateToHomePage().enterCountDownTimer().and().startTheTimer();
		new CountDownTimerPage().countDownTimerProgressStarted().and().countDownTimerWorking();

	}
}
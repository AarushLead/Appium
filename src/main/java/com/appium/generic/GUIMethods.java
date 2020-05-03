package com.appium.generic;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class GUIMethods {

	public static void scrollToText(AndroidDriver<AndroidElement> driver, String text) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"))").click();

	}

	public static void scrollToTextByID(AndroidDriver<AndroidElement> driver, String text) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\""
						+ text + "\"))");
	}
}

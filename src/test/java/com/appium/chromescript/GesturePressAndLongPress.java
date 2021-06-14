package com.appium.chromescript;

import java.time.Duration;

import org.testng.annotations.Test;

import com.appium.baseother.SauceLabCloud;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class GesturePressAndLongPress extends SauceLabCloud{

	@SuppressWarnings("rawtypes")
	@Test(enabled=false,description="Will perform long press indirectly using press() method")
	public void longPressOnElement() {
		
		TouchAction action=new TouchAction(driver);
		action.press(ElementOption.element(driver.findElementByAccessibilityId("Content")))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(4000))).release().perform();
	}
	
	@SuppressWarnings("rawtypes")
	@Test(description="Will perform long press indirectly using longPress() method")
	public void longPressOnElement1() {
		
		TouchAction action=new TouchAction(driver);
		action.longPress(ElementOption.element(driver.findElementByAccessibilityId("Content")))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000))).release().perform();
				
	}
}

package com.appium.chromescript;

import org.testng.annotations.Test;

import com.appium.baseother.SauceLabCloud;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import  io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class GestureTap extends SauceLabCloud{

	@SuppressWarnings("rawtypes")
	@Test(enabled=false,description="to tap on element")
	public void tappingOnElement() {
		
		TouchAction action=new TouchAction(driver);
		action.tap(ElementOption.element(driver.findElement(MobileBy.AccessibilityId("Animation")))).perform();
	}
	        
	@SuppressWarnings("rawtypes")
	@Test(enabled=false,description="to tap on element")
	public void tappingOnCoordinates() {
		
		TouchAction action=new TouchAction(driver);
		action.tap(PointOption.point(549, 519)).perform();
	}
	@SuppressWarnings("rawtypes")
	@Test(description="to tap on element")
	public void tappingOnElementUsingTapOptions() throws InterruptedException {
		
		TouchAction action=new TouchAction(driver);
	 	action.tap(TapOptions.tapOptions().withElement(ElementOption.element(driver.findElementByAccessibilityId("Media")))).perform();
	   Thread.sleep(3000);
	}
	
}

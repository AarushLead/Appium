package com.appium.chromescript;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;

import com.appium.anums.Direction;
import com.appium.baseother.SauceLabCloud;
import static com.appium.generic.GUIMethods.scrollToText;
import static com.appium.generic.GUIMethods.scrollScreen;
import static com.appium.generic.GUIMethods.swipeByElements;
import static com.appium.generic.GUIMethods.pressHomekey;
import static com.appium.generic.GUIMethods.scrollToText2;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

public class GesturesSwipe extends SauceLabCloud {

	// To swipe form betton to up based on points

	@SuppressWarnings("rawtypes")
	@Test(enabled = true, description = "Swipe Vertically")
	public void SwipeVertically() throws InterruptedException {
		allowAppPermission();
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		Dimension size = driver.manage().window().getSize();
		int startX = size.width / 2;
		int endX = startX;
		int startY = (int) (size.height * 0.8);
		int endY = (int) (size.height * 0.2);

		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
				.moveTo(PointOption.point(endX, endY)).release().perform();

	}
	public void allowAppPermission(){
		 while (driver.findElements(MobileBy.xpath("//*[@class='android.widget.Button']")).size()>0) 

		 {  driver.findElement(MobileBy.xpath("//*[@class='android.widget.Button'][2]")).click();
		 }
		}
	
	// swipe from one element location to another element location
	@Test(enabled = false)
	public void swipeToElement() {
		By view = MobileBy.AccessibilityId("Views");
		By gallery = MobileBy.AccessibilityId("Gallery");
		By button = MobileBy.AccessibilityId("Buttons");

		driver.findElement(view).click();
		TouchAction action = new TouchAction(driver);
		action.press(ElementOption.element(driver.findElement(gallery)))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
				.moveTo(ElementOption.element(driver.findElement(button))).release().perform();

	}

	//swipe based on direction
	@Test(enabled = false)
	public void Swipegeneric() throws InterruptedException {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		scrollScreen(driver, Direction.UP);
		Thread.sleep(3000);
		scrollScreen(driver, Direction.DOWN);
	}
	
	
	@Test(enabled = false)
	public void SwipeByElement() throws InterruptedException {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		By gallery = MobileBy.AccessibilityId("Gallery");
		By button = MobileBy.AccessibilityId("Buttons");
		swipeByElements(driver,driver.findElement(gallery),driver.findElement(button));
	}
	
	@Test(enabled = false)
	public void testHomeKey() throws InterruptedException {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		Thread.sleep(3000);
		pressHomekey(driver);
		System.out.println("sgsggs");
	}
	
	@Test(enabled = false)
	public void swipetotext() throws InterruptedException {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		Thread.sleep(3000);
		scrollToText2(driver,"WebView");
		System.out.println("sgsggs");
	}
	
	@Test(enabled=false)
	public void scrollTillText() {
		By view = MobileBy.AccessibilityId("Views");
		driver.findElement(view).click();
		scrollToText(driver,"WebView");
	}
	
}
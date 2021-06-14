package com.appium.generic;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import com.appium.anums.Direction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class GUIMethods {

	public static void scrollToText(AppiumDriver driver, String text) {
		((FindsByAndroidUIAutomator)driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().textContains(\"" + text + "\"))").click();

	}

	public static void scrollToTextByID(AndroidDriver<AndroidElement> driver, String text) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().resourceId(\"parent-locator\")).scrollIntoView(new UiSelector().textMatches(\""
						+ text + "\"))");
	}
	public static void scrollToText2(AppiumDriver driver,String text) {
		((FindsByAndroidUIAutomator)driver)
				.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"+".scrollable(true).instance(0)).scrollIntoView("
		          +"new UiSelector().textContains(\""+text+"\").instance(0));");
	}

	@SuppressWarnings("rawtypes")
	public static void scrollScreen(AppiumDriver driver, Direction direction) {

		Dimension size = driver.manage().window().getSize();
		int startX = size.width / 2;
		int startY = 0;
		int endX = startX;
		int endY = 0;
		switch (direction) {
		case UP:
			startY = (int) (size.height * 0.8); //Find starty point which is at bottom side of screen.
			endY = (int) (size.height * 0.2);
			break;
		case DOWN:
			startY = (int) (size.height * 0.2);
			endY = (int) (size.height * 0.8);
			break;
		default:
			break;
		}
		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
				.moveTo(PointOption.point(endX, endY)).release().perform();
	}

	@SuppressWarnings("rawtypes")
	public static void swipeByElements(AppiumDriver driver, MobileElement startElement, MobileElement endElement) {
		int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
		int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);

		int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
		int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);

		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
				.moveTo(PointOption.point(endX, endY)).release().perform();
	}

	@SuppressWarnings("rawtypes")
	public static void pressHomekey(AppiumDriver driver) {

		AndroidDriver androidDriver = (AndroidDriver) driver;
		androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));

	}

}

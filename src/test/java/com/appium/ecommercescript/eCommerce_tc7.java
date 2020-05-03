package com.appium.ecommercescript;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.util.HashMap;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.appium.ecommercebase.EcommerceBaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

/* for switch in Web view*/
public class eCommerce_tc7 extends EcommerceBaseTest {
	@Test
	public void eCommerce_TC7() throws InterruptedException {
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("rahul");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		String var = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Bahrain\").instance(0))";
		Thread.sleep(2000);
		driver.findElementByAndroidUIAutomator(var).click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textContains(\"Converse All Star\"))");
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
		double sum = 0.00;
		for (int i = 0; i < count; i++) {
			String sumText = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(i).getText()
					.substring(1);
			sum = sum + Double.parseDouble(sumText);
		}
		Assert.assertEquals(sum, Double.parseDouble(
				driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().substring(1)),
				"Total sum is correct");
		MobileElement chkbx = driver.findElementByClassName("android.widget.CheckBox");
		TouchAction<?> t = new TouchAction<>(driver);
		t.tap(tapOptions().withElement(element(chkbx))).perform();
		MobileElement terms = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		t.longPress(longPressOptions().withElement(element(terms)).withDuration(ofSeconds(2))).release().perform();
		driver.findElementByAndroidUIAutomator("text(\"CLOSE\")").click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(7000);
		Set<String> context = driver.getContextHandles();
		for (String contextName : context) {

			System.out.println(contextName);
		}
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("hello");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		// driver.pressKey(new KeyEvent(AndroidKey.BACK));
		HashMap<String, Integer> keycode = new HashMap<String, Integer>();
		keycode.put("keycode", 4);
		((JavascriptExecutor) driver).executeScript("mobile: keyevent", keycode);
		driver.context("NATIVE_APP");

	}
}

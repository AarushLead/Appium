package com.appium.ecommercescript;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.appium.ecommercebase.EcommerceBaseTest;


/**
 * @author Shobhit Sharma
 * @purpose validate the toast message
 */
public class ecommerce_tc2  extends EcommerceBaseTest{
	@Test
	public void ecommerceInvalid_tc2() throws InterruptedException {
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		String var = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Bahrain\").instance(0))";
		Thread.sleep(2000);
		driver.findElementByAndroidUIAutomator(var).click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		String actualtoast = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		Assert.assertEquals(actualtoast, "Please enter your name");
	}
}

package com.appium.ecommercescript;

import org.openqa.selenium.By;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.appium.ecommercebase.EcommerceBaseTest;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;

/* for Performing Appium gesture */
public class eCommerce_tc6 extends EcommerceBaseTest {
	@Test
	public void eCommerce_TC6() throws InterruptedException
	{
	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("rahul");
	driver.hideKeyboard();
	driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
	driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
	String var = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Bahrain\").instance(0))";
	Thread.sleep(2000);
	driver.findElementByAndroidUIAutomator(var).click();
	driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
	driver.findElementByAndroidUIAutomator(
			"new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Converse All Star\"))"); 
	driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
	driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();	
	driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	Thread.sleep(3000);
	int count=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
	double sum=0.00;
	for (int i = 0; i < count; i++) {
		String sumText=driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(i).getText().substring(1);
		sum=sum+Double.parseDouble(sumText);
	}
	Assert.assertEquals(sum, Double.parseDouble(driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().substring(1)),"Total sum is correct");
	AndroidElement chkbx = driver.findElementByClassName("android.widget.CheckBox");
    TouchAction<?> t=new TouchAction<>(driver);
    t.tap(tapOptions().withElement(element(chkbx))).perform();
    AndroidElement terms = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
    t.longPress(longPressOptions().withElement(element(terms)).withDuration(ofSeconds(2))).release().perform();
    driver.findElementByAndroidUIAutomator("text(\"CLOSE\")").click();
    driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
    Thread.sleep(5000);
    System.out.println("success");
    
	
	}
}

package com.appium.ecommercescript;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.appium.ecommercebase.EcommerceBaseTest;
import io.appium.java_client.android.AndroidElement;


/**
 * @author Shobhit Sharma
 * @purpose add single product to cart 
 *
 */
public class ecommerce_tc3 extends EcommerceBaseTest{
	@Test
	public void eCommerce_tc3() throws InterruptedException {
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("rahul");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		String var = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Bahrain\").instance(0))";
		Thread.sleep(2000);
		driver.findElementByAndroidUIAutomator(var).click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		System.out.println("ecommercevalid_tc1 executed");
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Converse All Star\"))");
		 List<AndroidElement> products = driver.findElementsById("com.androidsample.generalstore:id/productName");
	     int count=products.size();
		 for (int i = 0; i < count; i++) {
			String productname = products.get(i).getText();
			System.out.println(productname);
			if (productname.equalsIgnoreCase("Converse All Star")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				break;
			}

		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		System.out.println("Added to cart");

	}
}

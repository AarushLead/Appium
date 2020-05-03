package com.appium.ecommercescript;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.appium.ecommercebase.EcommerceBaseTest;


/**
 * @author Shobhit Sharma
 * @purpose  validate the product in cart
 *
 */
public class eCommerce_tc4 extends EcommerceBaseTest{
	@Test
	public void validate_checkoutProduct() throws InterruptedException {
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
		int productcount = driver.findElementsById("com.androidsample.generalstore:id/productName").size();
		System.out.println(productcount);
		for (int i = 0; i < productcount; i++) {
			String productname = driver.findElementsById("com.androidsample.generalstore:id/productName").get(i)
					.getText();
			if (productname.equalsIgnoreCase("Converse All Star")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				break;
			}

		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		String productName = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals("Converse All Star", productName);
	}
	
}

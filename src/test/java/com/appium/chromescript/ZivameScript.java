package com.appium.chromescript;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import static com.appium.generic.GUIMethods.swipeByElements;

import com.appium.baseother.SauceLabCloud;

import io.appium.java_client.MobileElement;

public class ZivameScript extends AWSBase{
	
	@Test
	public void loginScript() {
		driver.findElement(By.className("android.widget.ImageButton")).isDisplayed();
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.widget.ImageButton"))).click();
		driver.findElement(By.id("com.zivame.consumer:id/menu_login_register_or_user_name_ll")).isDisplayed();
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("com.zivame.consumer:id/menu_login_register_or_user_name_ll"))).click();
		driver.findElement(By.id("com.zivame.consumer:id/llLoginWithEmail")).click();
		driver.findElement(By.id("com.zivame.consumer:id/edtEmail")).click();
		driver.findElement(By.id("com.zivame.consumer:id/edtEmail")).sendKeys("devicestagesanitycycle@gmail.com");
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("com.zivame.consumer:id/btnLogin"))).click();
		driver.findElement(By.id("com.zivame.consumer:id/edtPassword")).click();
		driver.findElement(By.id("com.zivame.consumer:id/edtPassword")).sendKeys("test1234");
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("com.zivame.consumer:id/btnLogin"))).click();
		driver.findElement(By.id("com.zivame.consumer:id/user_image")).isDisplayed();
		MobileElement start=driver.findElement(By.xpath("//android.widget.TextView[@text='MY FIT CODE']"));
		MobileElement end=driver.findElement(By.xpath("//android.widget.TextView[@text='MY WISHLISTS']"));
		swipeByElements(driver,start,end);
		driver.findElement(By.xpath("//*[@resource-id='com.zivame.consumer:id/logout_layout']/android.widget.TextView")).click();
		driver.findElement(By.className("android.widget.ImageButton")).isDisplayed();
	}
	@Test()
	public void clickOnCatagoryProduct() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("com.zivame.consumer:id/imgProductDisplay"))).click();
		driver.findElement(By.id("com.zivame.consumer:id/view_filterby")).isDisplayed();
		driver.findElement(By.xpath("(//*[@resource-id='com.zivame.consumer:id/product_name'])[2]")).click();
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("com.zivame.consumer:id/imgProductDisplay"))).isDisplayed();
	    (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("com.zivame.consumer:id/toolbar_title"))).click();
	}
}

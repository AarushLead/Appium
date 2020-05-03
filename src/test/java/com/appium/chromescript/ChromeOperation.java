package com.appium.chromescript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.appium.baseother.ChromeBaseTest;

public class ChromeOperation extends ChromeBaseTest
{   
	@Test(priority=1)
	public void facebook_login()
	{
		driver.get("https://m.facebook.com/");
		driver.findElement(By.id("m_login_email")).sendKeys("nishusharma772@gmail.com");
		driver.findElement(By.id("m_login_password")).sendKeys("mylovenonu");
		driver.findElement(By.name("login")).click();		
	}
	@Test(priority=2)
	public void crickbuzz()
	{
		driver.get("https://m.cricbuzz.com/");
		driver.findElementByXPath("//a[@href='#menu']").click();
		driver.findElement(By.cssSelector("a[title='Cricbuzz Home']")).click();	
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)","");
		System.out.println("sccrolling");
		Assert.assertTrue(driver.findElementByXPath("//h4[text()='Top Stories']").getAttribute("class").contains("header"));
        System.out.println("verify");
	}
}

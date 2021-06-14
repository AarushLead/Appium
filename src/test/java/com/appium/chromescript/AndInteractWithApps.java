package com.appium.chromescript;

import java.time.Duration;

import org.testng.annotations.Test;

import com.appium.baseother.SauceLabCloud;

import io.appium.java_client.android.appmanagement.AndroidInstallApplicationOptions;

public class AndInteractWithApps extends SauceLabCloud{

	@Test(enabled=false)
	public void terminateApp() throws InterruptedException {
		driver.findElementByAccessibilityId("Views").click();
		Thread.sleep(5000);
		driver.terminateApp("io.appium.android.apis"); //Basically this command will not exit the app but it will move the app in background
	}
	
	@Test(enabled=false)
	public void installApp() {
		//This will install and update the app
		driver.findElementByAccessibilityId("Views").click();
		driver.installApp(apm.getAbsPath(), new AndroidInstallApplicationOptions().withReplaceEnabled());
	}
	
	@Test(enabled=false)
	public void isAppInstalled() {
		//check if an app is already installed
	    boolean flag = driver.isAppInstalled("io.appium.android.apis");
	    System.out.println(flag);
	}
	
	@Test(enabled=true)
	public void runAppBackGround() {
		//send the app in background for specific time and then bring back to foreground
	   driver.findElementByAccessibilityId("Views").click();
	   driver.runAppInBackground(Duration.ofMillis(5000));
	}
}

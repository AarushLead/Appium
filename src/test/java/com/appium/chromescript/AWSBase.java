package com.appium.chromescript;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AWSBase {

	public static AppiumDriver<MobileElement> driver;

	@BeforeTest
	public void setUp(Method result) throws JSONException, UnirestException {
	
		try {
			String sauce_local_url="https://127.0.0.1:4723/wd/hub";
			driver = new AndroidDriver<>(new URL(sauce_local_url), new DesiredCapabilities());
			
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@AfterTest
	public void tearDown(ITestResult result) {
		if(driver!=null) {
			driver.closeApp();
		}
	}
}

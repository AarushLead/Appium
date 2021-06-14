package com.appium.baseother;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.appium.helper.ApiHelper;
import com.appium.utils.AppiumPropertyManager;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SauceLabCloud {

	public static AppiumDriver<MobileElement> driver;
	public static AppiumPropertyManager apm;
	public String  userName="shobhit110";
	public String  access_key="33961517-337f-4707-a2ea-e58dc1e7df3c";

	@BeforeMethod
	public void setUp(Method result) throws JSONException, UnirestException {
		
		JSONObject object=new JSONObject(ApiHelper.uploadApp("/D:/JAVAWORKSPACE/Appium/app/zivame.apk"));
		apm = new AppiumPropertyManager();
		DesiredCapabilities caps = DesiredCapabilities.android();
		caps.setCapability("appiumVersion", "1.18.1");
		caps.setCapability("deviceName","Samsung Galaxy S9 Plus HD GoogleAPI Emulator");
		caps.setCapability("deviceOrientation", "portrait");
		caps.setCapability("browserName", "");
		caps.setCapability("platformVersion","8.1");
		caps.setCapability("platformName","Android");
		caps.setCapability("appPackage", "com.zivame.consumer");
		caps.setCapability("appActivity","com.zivame.consumer.app.home.HomeActivity");
		caps.setCapability("name",result.getName());
		caps.setCapability("recordScreenshots",true); //optional
		caps.setCapability("autoGrantPermissions",true);  //optional
    	caps.setCapability("app","storage:"+object.getJSONObject("item").getString("id"));
		
		try {
			String sauce_remote_url="https://"+userName+":"+access_key+"@ondemand.us-west-1.saucelabs.com:443/wd/hub";
			driver = new AndroidDriver<>(new URL(sauce_remote_url), caps);
			
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown(ITestResult result)
	{  
		try {
			if(driver!=null) {
				((JavascriptExecutor) driver).executeScript("sauce:job-result="+(result.isSuccess()?"passed":"failed"));
			}
		}finally{
			driver.closeApp();
	}
  }
}

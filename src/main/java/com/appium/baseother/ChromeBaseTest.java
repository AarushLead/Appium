package com.appium.baseother;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.appium.utils.AppiumPropertyManager;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;

public class ChromeBaseTest {
	protected AndroidDriver<AndroidElement> driver;
	protected AppiumPropertyManager apm;

	@BeforeMethod
	public void setup() {
		apm = new AppiumPropertyManager();
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, apm.getAutomationName());
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, apm.getPlatformName());
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, apm.getPlatformVersion());
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, apm.getDeviceName());
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
		cap.setCapability(MobileCapabilityType.AUTO_WEBVIEW, apm.getAutoWebView());
		try {
			driver = new AndroidDriver<>(new URL("http://"+apm.getHostUrl()+apm.getPortNO()+"/wd/hub"), cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown() {
		 driver.closeApp();

	}

}

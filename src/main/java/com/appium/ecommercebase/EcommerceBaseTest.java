package com.appium.ecommercebase;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.appium.utils.AppiumPropertyManager;
import com.appium.utils.AppiumServerUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class EcommerceBaseTest {
//	private String runningDevice;
	protected AndroidDriver<AndroidElement> driver;
	protected AppiumPropertyManager apm = new AppiumPropertyManager();
	protected AppiumServerUtils appiumServer = new AppiumServerUtils();
	protected DesiredCapabilities cap;
	protected Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	@BeforeMethod
	public void setup() {
		cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, apm.getAutomationName());
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, apm.getPlatformName());
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, apm.getPlatformVersion());
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, apm.getDeviceName());
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		cap.setCapability(MobileCapabilityType.UDID, apm.getUdid());
		cap.setCapability(MobileCapabilityType.AUTO_WEBVIEW, apm.getAutoWebView());
	 	cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, apm.getNewCommandTimeOut());
		cap.setCapability(MobileCapabilityType.NO_RESET, apm.getNoReset());
		cap.setCapability(MobileCapabilityType.FULL_RESET, apm.getFullReset());
		cap.setCapability(MobileCapabilityType.APP, apm.getAbsPath());	
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, apm.getApplicationPackage());
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, apm.getApplicationActivity());
		try {
			driver = new AndroidDriver<>(new URL("http://"+apm.getHostUrl()+apm.getPortNO()+"/wd/hub"), cap);
		} catch (MalformedURLException e) {
			logger.error("Error :"+e.getStackTrace());
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown() {
		driver.closeApp();

	}
}

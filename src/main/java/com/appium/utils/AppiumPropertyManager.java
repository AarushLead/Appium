package com.appium.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AppiumPropertyManager {
	private final Properties prop;
	private final String projDir;
	private static String filePath;
	private FileInputStream fis;
	private String hostURl;
	private String platformName;
	private String platformVersion;
	private String deviceName;
	private String udid;
	private String automationName;
	private String appApk;
	private String appPath;
	private String appPackage;
	private String appActivity;
	private String deviceOrientation;
	private String newCommandTimeOut;
	private String browserName;
	private String portNo;
	private boolean noReset;
	private boolean fullReset;
	private boolean autoWebView;

	public AppiumPropertyManager() {
		this.prop = new Properties();
		this.projDir = System.getProperty("user.dir");
		filePath = projDir + "/src/test/resources/config.properties";
		this.loadConfig(filePath);
	}

	/* To load the configuration file */
	public void loadConfig(String path) {
		try {
			this.fis = new FileInputStream(new File(filePath));
		} catch (FileNotFoundException e1) {
			System.out.println(e1.getMessage());
		}
		try {
			if (this.fis != null) {
				this.prop.load(this.fis);
			}
		} catch (IOException e) {
			System.out.println(e.getStackTrace());
		}
	}

	/* To get the Appium server url */
	public String getHostUrl() {
		this.hostURl = prop.getProperty("appium.server.url");
		return this.hostURl;
	}

	public String getPortNO() {
		this.portNo = prop.getProperty("appium.server.port");
		return this.portNo;
	}

	public String getBrowserName() {
		this.browserName = prop.getProperty("browser.name");
		return this.browserName;
	}

	/* To get the platform name */
	public String getPlatformName() {
		this.platformName = prop.getProperty("android.platform");
		return this.platformName;
	}

	/* To get the platform version */
	public String getPlatformVersion() {
		this.platformVersion = prop.getProperty("android.platform.verion");
		return this.platformVersion;
	}

	/* To get the device name from property file */
	public String getDeviceName() {
		this.deviceName = prop.getProperty("android.device.name");
		return this.deviceName;

	}

	/* To get the device name from command prompt */
	public String getCommandDeviceName() {
		this.deviceName = System.getProperty("deviceName");
		return deviceName;

	}

	/* To get the device unique device identification number */
	public String getUdid() {
		this.udid = prop.getProperty("android.emulator.udid");
		return this.udid;
	}

	/* To get the Automation Name */
	public String getAutomationName() {
		this.automationName = prop.getProperty("automation.instumentation");
		return this.automationName;
	}

	/* To get the Application folder */
	public String getApplicationPath() {
		this.appPath = prop.getProperty("android.app.path");
		return this.appPath;
	}

	/* To get the Application Name */
	public String getApplicationApk() {
		this.appApk = prop.getProperty("android.app.name");
		return this.appApk;
	}

	/* To get the Application Package name */
	public String getApplicationPackage() {
		this.appPackage = prop.getProperty("android.generalStore.packageName");
		return this.appPackage;
	}

	/* To get the Application activity name */
	public String getApplicationActivity() {
		this.appActivity = prop.getProperty("android.generalStore.activityName");
		return this.appActivity;
	}

	public boolean getAutoWebView() {
		this.autoWebView = ("false".equals(prop.getProperty("AutoWebView"))) ? false : true;
		return this.autoWebView;
	}

	public boolean getNoReset() {
		this.noReset = ("false".equals(prop.getProperty("android.app.noreset"))) ? false : true;
		return this.noReset;
	}

	public boolean getFullReset() {
		this.fullReset = ("false".equals(prop.getProperty("android.app.fullreset"))) ? false : true;
		return this.fullReset;
	}

	/* To get the timeout of command */
	public int getNewCommandTimeOut() {
		this.newCommandTimeOut = prop.getProperty("new.command.timeout");
		return Integer.parseInt(newCommandTimeOut);
	}

	/* To get the orientation of device */
	public String getOrientation() {
		this.deviceOrientation = prop.getProperty("android.device.orientation");
		return this.deviceOrientation;
	}

	/* To get Absolute Path from Relative Path */
	public String getAbsPath() {
		File rootPath = new File(System.getProperty("user.dir"));
		File appFolder = new File(rootPath,getApplicationPath());
		File app = new File(appFolder, getApplicationApk());
		return app.getAbsolutePath();
	}
}

package com.appium.utils;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServerUtils {

	protected AppiumDriverLocalService service;
	protected AppiumServiceBuilder builder;
	protected Logger logger = Logger.getLogger(this.getClass().getSimpleName());

	/* This method will build the Appium service and then start the server */

	public void startServer(DesiredCapabilities capability, String ipAddress, String port) {
		logger.info("Trying to Start Appium Server");
		builder = new AppiumServiceBuilder();
		builder.withCapabilities(capability);
		builder.withIPAddress(ipAddress);
		builder.usingPort(Integer.parseInt(port));
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
		service = AppiumDriverLocalService.buildService(builder);
		service.start();
		logger.info(" Appium Server has Started ");
	}

	// 2nd Way to start Appium Server programatically
	public void startServer() {
		builder = new AppiumServiceBuilder();
		builder.withArgument(GeneralServerFlag.LOCAL_TIMEZONE); //To get logs in loacl time
		builder.withLogFile(new File(System.getProperty("user.dir")+"\\log\\application.txt"));
		builder.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"));
		builder.withAppiumJS(new File(
				"C:\\Users\\Shobhit Sharma\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"));
		service = AppiumDriverLocalService.buildService(builder);
		service.start();
	}

	/* This method will stop the Appium service */
	public void stopServer() {
		logger.info("Trying to Stop Appium Server");
		service.stop();
		logger.info("Appium Server is Stopped");

	}

	/* To get the Appium URL */
	public String getAppiumUrl() {
		return service.getUrl().toString();
	}

	/* this method will check the server is running or not */
	public boolean CheckIfServerRunning(String portNo) {
		boolean isServerRunning = false;
		ServerSocket socket;
		try {
			logger.info("Checking for Appium server Running or not ?");
			socket = new ServerSocket(Integer.parseInt(portNo));
			socket.close();
			logger.info("Your Appium server is not Running");
		} catch (IOException e) {
			isServerRunning = true;
			logger.info("Your Appium Server is already Running");
		} finally {
			socket = null;
		}
		return isServerRunning;
	}
}

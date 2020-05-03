package com.appium.utils;

import java.io.IOException;
import org.apache.log4j.Logger;

public class CommonUtil {

	protected Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	public  static void startEmulator() {
		try {
			Runtime.getRuntime().exec(System.getProperty("user.dir")+"/resources/startEmulator.bat");
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				System.out.println("Exception :"+e.getMessage());
			}
		} catch (IOException e) {
			System.out.println("Exception :"+e.getMessage());
		}
		
	}
	public static void stopEmulator() {
		try {
			Runtime.getRuntime().exec("adb -s emulator-5554 emu kill");
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				System.out.println("Exception :"+e.getMessage());
			}
		} catch (IOException e) {
			System.out.println("Exception :"+e.getMessage());
		}
		
	}
}

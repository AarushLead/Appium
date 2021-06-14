package com.appium.chromescript;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JsTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String jsPaths = null;

		String actualJSPath = null;

		String operatingSystem = System.getProperty("os.name");

		if (operatingSystem.contains("Win")) {

			String whereAppium = "where" + " " + "appium";
			Process p = Runtime.getRuntime().exec(whereAppium);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

			while ((jsPaths = stdInput.readLine()) != null) {

			actualJSPath = jsPaths.replace("appium", "node_modules\\appium\\build\\lib\\main.js");

			break;

			}

			p.waitFor();

			p.destroy();

			if (actualJSPath == null) {

			System.exit(0);

			}

			}
		else {

			actualJSPath = "//usr//local//lib//node_modules//appium//build//lib//main.js";

			}

			System.out.println(actualJSPath);

			}
}

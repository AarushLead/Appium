package com.appium.helper;

import java.io.File;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class ApiHelper {

	public static String uploadApp(String filePath) throws UnirestException {
	Unirest.setTimeouts(2000, 6000);
	HttpResponse<String> response = Unirest.post("https://api.us-west-1.saucelabs.com/v1/storage/upload")
	  .header("Authorization", "Basic c2hvYmhpdDExMDozMzk2MTUxNy0zMzdmLTQ3MDctYTJlYS1lNThkYzFlN2RmM2M=")
	  .field("payload", new File(filePath))
	  .field("name", "demos.apk")
	  .asString();
	return response.getBody();
	}

}

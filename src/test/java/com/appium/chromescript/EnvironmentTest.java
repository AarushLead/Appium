package com.appium.chromescript;

import java.util.Map;

public class EnvironmentTest {

	public static void main(String[] args) {
		Map<String, String> env = System.getenv(); 

    for (String envName : env.keySet()) { 
        String var=env.get(envName); 
        if(env.get(envName).contains("jdk")) {
        	System.out.println(var);
        	break;
        }
    } 
	}

}

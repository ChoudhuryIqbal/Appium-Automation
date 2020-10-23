package com.appium.mobileFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {
	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/ConfigResource/config.properties");
		prop.load(fis );
		//prop.get("GeneralStoreApp");
		File file=new File("AppContainer");
		File app=new File(file,(String) prop.get(appName));
			DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.get("device"));
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		AndroidDriver<AndroidElement> ad=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		return ad;
		
	}

}

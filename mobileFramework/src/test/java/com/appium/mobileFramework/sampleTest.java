package com.appium.mobileFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class sampleTest {
	
	@Test
	public void firstTest()throws IOException {
		AndroidDriver<AndroidElement> driver = Base.capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello");
		// Option to hide keyboard
		driver.hideKeyboard();
		driver.findElementByXPath("//android.widget.RadioButton[@text='Male']").click();
		driver.findElementById("android:id/text1").click();

		String scrollToCountry = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Angola\"));";

		driver.findElementByAndroidUIAutomator(scrollToCountry);
		driver.findElementByXPath("//*[@text='Angola']").click();

		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		/// toast message
		// android .widget.Toast[2]

		String toastMessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		// name attibute for toast messages will have content.
		System.out.println("Toast Mesaage is " + toastMessage);

	}

}

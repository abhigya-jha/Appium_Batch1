package com.w2a.appiumbatch1_ios_test;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;

public class Test {

	public static void main(String[] args) throws MalformedURLException {

		UiAutomator2Options options = new UiAutomator2Options().setPlatformName("iOS").setDeviceName("iPhone 16 Plus")
				.setUdid("C2CCBEA8-4F92-4F4D-BC5C-6812E9208014").setAutomationName("XCUITest")
				.setApp("/Users/abhigyajha/Downloads/iOS.Simulator.SauceLabs.Mobile.Sample.app.2.7.1.app");

		URL url = new URL("http://0.0.0.0:4723");
		IOSDriver driver = new IOSDriver(url, options);

		System.out.println("App Launched");
		
		//Enter UserName
		driver.findElement(AppiumBy.accessibilityId("test-Username")).sendKeys("standard_user");
		//Enter Password
		driver.findElement(AppiumBy.accessibilityId("test-Password")).sendKeys("secret_sauce");
		//CLick on Login Button
		driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();

		
	}

}

package com.w2a.Appium_Practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.LocksDevice;
import io.appium.java_client.android.AndroidDriver;

public class MMT {
	
static AndroidDriver driver;
	
	public static void main(String[] args) throws MalformedURLException {
		System.out.println("hi");
		launchApp();
	}
	
	public static void launchApp() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("appium:deviceName", "vivo V21 5G");
		cap.setCapability("appium:udid", "9646667755000HB");
		cap.setCapability("platformName", "Android");
		cap.setCapability("appium:platformVersion", "13");
		cap.setCapability("appium:automationName", "uiAutomator2");
		cap.setCapability("appium:app", "C:\\Users\\Admin\\Documents\\mmt.apk");
		cap.setCapability("appium:noReset", true);
		cap.setCapability("appium:fullReset", false);
		//cap.setCapability("appium:appPackage", "com.makemytrip");
		//cap.setCapability("appium:appActivity", "com.mmt.travel.app.home.ui.SplashActivity");
		
		
		
		URL url= new URL("http://127.0.0.1:4723/");
		driver= new AndroidDriver(url,cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("Application Launched!!!");
		
		driver.lockDevice(Duration.ofSeconds(5));		
		//((LocksDevice) driver).lockDevice();
		
		
	}

}

package com.w2a.Appium_Practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MakeMyTrip {
	
static AndroidDriver driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		System.out.println("hi");
		launchApp();
	}
	
	public static void launchApp() throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("appium:deviceName", "vivo V21 5G");
		cap.setCapability("appium:udid", "9646667755000HB");
		cap.setCapability("platformName", "Android");
		cap.setCapability("appium:platformVersion", "13");
		cap.setCapability("appium:automationName", "uiAutomator2");
		cap.setCapability("appium:autoGrantPermissions", true);//good to have
		cap.setCapability("appium:app", "C:\\Users\\Admin\\Documents\\Test.apk");
		//cap.setCapability("appium:noReset", true);//clear the cache of the app
		cap.setCapability("appium:fullReset", true);//do not install the app again
		
		
		//cap.setCapability("appium:appPackage", "com.facebook.katana");
		//cap.setCapability("appium:appActivity", "com.facebook.katana.LoginActivity");// Action Item on Me
		
		URL url= new URL("http://127.0.0.1:4723/");
		driver= new AndroidDriver(url,cap);
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("Application Launched!!!");
	
	
		
		
		
	}

}

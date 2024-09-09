package com.w2a.Appium_Practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class ShopersStop {
	
	static AndroidDriver driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		launchApp();
	}
	
	public static void launchApp() throws MalformedURLException, InterruptedException {
		
DesiredCapabilities cap = new DesiredCapabilities();
		System.out.println("Starting the Execution");
		cap.setCapability("appium:deviceName", "vivo V21 5G");//provide simulator device name
		cap.setCapability("appium:udid", "9646667755000HB");//provide simulator device id
		cap.setCapability("platformName", "Android");
		cap.setCapability("appium:platformVersion", "13");
		cap.setCapability("appium:automationName", "uiAutomator2");
		cap.setCapability("appium:autoGrantPermissions", true);//
		cap.setCapability("appium:app", "C:\\Users\\Admin\\Documents\\Test.apk");
		
		URL url= new URL("http://127.0.0.1:4723/");
		driver= new AndroidDriver(url,cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		System.out.println("App Launched");
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"ACCOUNT, Tab 5 of 5\"]")).click();
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"LOGIN\"]")).click();	
		Thread.sleep(5000);
		driver.activateApp("com.android.mms");
		
		//Assignement 1-> Enter the mobile Number and click on Proceed Button
		//Assigmenent 2-> CLick on Men Section -> Click On Shirt
		//Assignment 3-> Launch the Dialer App on your device -> try to call on  my number
		//Assigment 4-> Read the very first message available in your message box and print it
		
		//Always fetch the OTP through Login API if provided ->
		
		
	}

}

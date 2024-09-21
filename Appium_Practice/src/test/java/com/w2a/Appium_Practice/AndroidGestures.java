package com.w2a.Appium_Practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidGestures {

	public static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("appium:deviceName", "vivo V21 5G");
		cap.setCapability("appium:udid", "9646667755000HB");
		cap.setCapability("platformName", "Android");
		cap.setCapability("appium:platformVersion", "13");
		cap.setCapability("appium:automationName", "uiAutomator2");
		// cap.setCapability("appium:autoGrantPermissions", true);//good to have
		// cap.setCapability("appium:app", "C:\\Users\\Admin\\Documents\\Test.apk");
		//cap.setCapability("appium:appPackage", "io.appium.android.apis");
		//cap.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");
		 cap.setCapability("appium:appPackage", "com.google.android.apps.maps");
		 cap.setCapability("appium:appActivity", "com.google.android.maps.MapsActivity");

		URL url = new URL("http://127.0.0.1:4723/");
		driver = new AndroidDriver(url, cap);
		Thread.sleep(Duration.ofSeconds(3));

	
		// click on Views
		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		// Click on Drag and Drop
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

		// Find the Red Dot1 element WebElement element =
		driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

		// Long CLick on the First Red Circle dragAndDrop(element);

	}
	
	public static void zoomIn() {
		
		
		
		
	}
	

	public static void longCLick(WebElement element) {
		driver.executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(),
						"x", 200,
						"y", 585,
						"duration", 3000 

				));
	}

	public static void dragAndDrop(WebElement element) {
		driver.executeScript("mobile: dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "endX", 700, // It is the X
																								// coordinate where you
																								// want to Drop
						"endY", 1050, // It is the y coordinate where you want to Drop
						"speed", 500));

	}

	public static void dragAndDrop() {
		driver.executeScript("mobile: dragGesture", ImmutableMap.of(
				// elementId", ((RemoteWebElement) element).getId(),
				"startX", 200, // It is the X coordinate for the Element which you want to Drag
				"startY", 585, // It is the Y coordinate for the Element which you want to Drag
				"endX", 700, // It is the X coordinate where you want to Drop
				"endY", 1050, // It is the y coordinate where you want to Drop
				"speed", 500));

	}

}

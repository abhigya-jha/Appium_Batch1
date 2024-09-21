package com.w2a.Appium_Practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AppiumGestures2 {

	public static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("appium:deviceName", "vivo V21 5G");
		cap.setCapability("appium:udid", "9646667755000HB");
		cap.setCapability("platformName", "Android");
		cap.setCapability("appium:platformVersion", "13");
		cap.setCapability("appium:automationName", "uiAutomator2");
		cap.setCapability("appium:appPackage", "io.appium.android.apis");
		cap.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");

		URL url = new URL("http://127.0.0.1:4723/");
		driver = new AndroidDriver(url, cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Thread.sleep(Duration.ofSeconds(3));
		// click on Views
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		swipe();
		//String command=scrollToSpecificElement("Spinner");
		//driver.findElement(AppiumBy.androidUIAutomator(command)).click();
		//By el = AppiumBy.accessibilityId("Picker");
		//scrollToElement(el);
		//driver.findElement(AppiumBy.accessibilityId("Picker")).click();

		// Scroll();
		// zoomIn();
		// Thread.sleep(Duration.ofSeconds(3));
		// zoomOut();
	}
	
	public static void swipe() {
		WebElement element=driver.findElement(AppiumBy.xpath("//android.widget.Gallery[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[1]"));
		  
		driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),
			    "direction", "left",
			    "percent", 0.2
			));
		
		
		
	}

	public static String scrollToSpecificElement(String elementText) {
		String uiSelector = "new UiSelector().textMatches(\""+elementText+"\")";
		//System.out.println(uiSelector);

		String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + uiSelector
				+ ");";
		return command;
		
	}
	
	
	
	public static void scrollToElement(By by) {
		

		while (true) {
	
			try {
				WebElement element = driver.findElement(by);
				break;
			} catch (Exception e) {
				Scroll();
			}
		}

	}

	public static void Scroll() {

		boolean canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of("left", 100,
				"top", 100, "width", 600, "height", 600, "direction", "down", "percent", 1.0));

	}

	public static void ScrollToEnd() {
		boolean canScrollMore = true;

		while (canScrollMore) {

			canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of("left", 100, "top",
					100, "width", 600, "height", 600, "direction", "down", "percent", 1.0));
		}

	}

	public static void zoomIn() {
		driver.executeScript("mobile: pinchOpenGesture",
				ImmutableMap.of("left", 400, "top", 600, "width", 600, "height", 600, "percent", 0.75));
	}

	public static void zoomOut() {
		driver.executeScript("mobile: pinchCloseGesture",
				ImmutableMap.of("left", 800, "top", 800, "width", 200, "height", 200, "percent", 0.75));
	}

}

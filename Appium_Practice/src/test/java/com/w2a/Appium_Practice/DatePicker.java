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

public class DatePicker {

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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		// Thread.sleep(Duration.ofSeconds(3));
		// click on Views
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Date Widgets")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Dialog")).click();
		driver.findElement(AppiumBy.accessibilityId("change the date")).click();
		driver.findElement(AppiumBy.id("android:id/date_picker_header_year")).click();
		scrollToElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"2000\"]"));
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"2000\"]"))
				.click();
		String date="22";
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\""+date+"\")")).click();
		
		
		
		//System.out.println(driver.findElement(By.xpath("//android.view.View[@content-desc=\"01 September 2000\"]")).getAttribute("content-desc"));
		//11-October-2000

	}
	
	
	//month()-> Nov --> 11 --> Target Month
	//month()-> Sep -> 9 -> Current Month
	//Target Month< Current Month -> Left
	

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

		WebElement element = driver.findElement(By.id("android:id/date_picker_year_picker"));
		boolean canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
				// "left", 550,"top", 1050,
				"elementId", ((RemoteWebElement) element).getId(), "width", 600, "height", 600, "direction", "up",
				"percent", 1.0));

	}

}

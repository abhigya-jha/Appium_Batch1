package com.w2a.appiumbatch1_ios_test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;

public class IOSGestures {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		UiAutomator2Options options = new UiAutomator2Options().setPlatformName("iOS").setDeviceName("iPhone 16 Plus")
				.setUdid("C2CCBEA8-4F92-4F4D-BC5C-6812E9208014").setAutomationName("XCUITest")
				.setApp("/Users/abhigyajha/Downloads/iOS.Simulator.SauceLabs.Mobile.Sample.app.2.7.1.app");

		URL url = new URL("http://0.0.0.0:4723");
		IOSDriver driver = new IOSDriver(url, options);

		System.out.println("App Launched");

		// Enter UserName
		driver.findElement(AppiumBy.accessibilityId("test-Username")).sendKeys("standard_user");
		// Enter Password
		driver.findElement(AppiumBy.accessibilityId("test-Password")).sendKeys("secret_sauce");
		// CLick on Login Button
		driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();
		Thread.sleep(Duration.ofSeconds(3));

		WebElement element = driver.findElement(AppiumBy.accessibilityId("assets/src/img/footer-swagbot.png"));
		ScrollIntoElement(driver, element);

		/*
		 * // Adding First Product driver.findElement(AppiumBy.
		 * xpath("(//XCUIElementTypeOther[@name=\"test-ADD TO CART\"])[1]")).click();
		 * driver.findElement(AppiumBy.
		 * xpath("(//XCUIElementTypeOther[@name=\"test-ADD TO CART\"])[2]")).click();
		 * 
		 * // //XCUIElementTypeOther[@name="test-Cart"]/XCUIElementTypeOther
		 * 
		 * WebElement element =
		 * driver.findElement(AppiumBy.xpath("(//XCUIElementTypeOther[@name=\"2\"])[4]")
		 * );
		 * 
		 * int height = element.getSize().getHeight();// 51 int width =
		 * element.getSize().getWidth();// 51
		 * 
		 * Point point = element.getLocation();
		 * 
		 * System.out.println("X-->" + point.x);// 369 System.out.println("Y-->" +
		 * point.y);// 29
		 * 
		 * int desiredX = point.x + (width / 2); int desiredY = point.y + (height / 2) +
		 * 10; System.out.println("desiredX-->" + desiredX);// 369
		 * System.out.println("desiredY-->" + desiredY);// 29 tap(driver, desiredX,
		 * desiredY); Thread.sleep(Duration.ofSeconds(2)); doubleTap(driver, desiredX,
		 * desiredY);
		 */

	}

	public static void tap(IOSDriver driver, int x, int y) {

		// Create a Finger
		PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "Finger1");

		// Perform Sequence of Operations using the Finger

		Sequence sequence = new Sequence(finger1, 1)
				.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y))
				.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger1, Duration.ofMillis(200)))
				.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		driver.perform(Collections.singleton(sequence));

	}

	public static void doubleTap(IOSDriver driver, int x, int y) {

		// Create a Finger
		PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "Finger1");

		// Perform Sequence of Operations using the Finger
		Sequence sequence = new Sequence(finger1, 1)
				.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y))
				.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger1, Duration.ofMillis(100)))
				.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger1, Duration.ofMillis(100)))
				.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger1, Duration.ofMillis(100)))
				.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		driver.perform(Collections.singleton(sequence));

	}

	public static void scroll(IOSDriver driver) {
		Dimension size = driver.manage().window().getSize();

		int startX = size.getWidth() / 2;
		int startY = size.getHeight() / 2;

		int endX = startX;
		int endY = (int) (size.getHeight() * 0.3);

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

		Sequence sequence = new Sequence(finger, 1)
				.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
				.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger, Duration.ofMillis(200)))
				.addAction(finger.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), endX, endY))
				.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		driver.perform(Collections.singleton(sequence));

	}

	public static void ScrollIntoElement(IOSDriver driver, WebElement element) {
		while (!element.isDisplayed()) {
			scroll(driver);
		}
	}
}

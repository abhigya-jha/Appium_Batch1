package com.w2a.appiumbatch1_ios_test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.offset.PointOption;

public class SwagLabsCheckoutFlow {

	public static void main(String[] args) throws MalformedURLException {
		UiAutomator2Options option = new UiAutomator2Options();
		option.setPlatformName("iOS");
		option.setDeviceName("iPhone 16 Plus");
		option.setUdid("C2CCBEA8-4F92-4F4D-BC5C-6812E9208014");
		option.setAutomationName("XCUITest");
		option.setApp("/Users/abhigyajha/Downloads/iOS.Simulator.SauceLabs.Mobile.Sample.app.2.7.1.app");

		URL url = new URL("http://0.0.0.0:4723");

		IOSDriver driver = new IOSDriver(url, option);

		driver.findElement(AppiumBy.accessibilityId("test-Username")).sendKeys("standard_user");
		driver.findElement(AppiumBy.accessibilityId("test-Password")).sendKeys("secret_sauce");
		driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();

		// Adding First Product
		driver.findElement(AppiumBy.xpath("(//XCUIElementTypeOther[@name=\"test-ADD TO CART\"])[1]")).click();
		driver.findElement(AppiumBy.xpath("(//XCUIElementTypeOther[@name=\"test-ADD TO CART\"])[2]")).click();

		// //XCUIElementTypeOther[@name="test-Cart"]/XCUIElementTypeOther

		WebElement element = driver.findElement(AppiumBy.xpath("(//XCUIElementTypeOther[@name=\"2\"])[4]"));

		int height = element.getSize().getHeight();// 51
		int width = element.getSize().getWidth();// 51

		Point point = element.getLocation();

		System.out.println("X-->" + point.x);// 369
		System.out.println("Y-->" + point.y);// 29

		int desiredX = point.x + (width / 2);
		int desiredY = point.y + (height / 2)+10;
		System.out.println("desiredX-->" + desiredX);// 369
		System.out.println("desiredY-->" + desiredY);// 29

		tap(driver, desiredX, desiredY);
		
		driver.findElement(AppiumBy.accessibilityId("test-CHECKOUT")).click();
		
		
		driver.findElement(AppiumBy.accessibilityId("test-First Name")).sendKeys("Abhigya");
		driver.findElement(AppiumBy.accessibilityId("test-Last Name")).sendKeys("Jha");
		driver.findElement(AppiumBy.accessibilityId("test-Zip/Postal Code")).sendKeys("560103");
		
		driver.findElement(AppiumBy.accessibilityId("test-CONTINUE")).click();
		
		driver.findElement(AppiumBy.accessibilityId("test-FINISH")).click();
	}
	
	

	public static void tap(IOSDriver driver, int x, int y) {
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence sequence = new Sequence(finger, 1)
				.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y))
				.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger, Duration.ofMillis(150)))
				.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Collections.singletonList(sequence));
		System.out.println("Tap with Coordinates");
	}

}

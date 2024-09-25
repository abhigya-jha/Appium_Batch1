package com.w2a.Appium_Practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class WebView {

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
		// scrollToSpecificElement("WebView");

		Set<String> contextNames = driver.getContextHandles();//1
		
		String parentContext="";
		for(String s:contextNames) {
			parentContext=s;
		}

		// driver.context("");
		String command = scrollToSpecificElement("WebView");
		driver.findElement(AppiumBy.androidUIAutomator(command)).click();
		System.out.println("Parent Contect-->"+parentContext);
		System.out.println("==============================================");
		contextNames = driver.getContextHandles();//2
		String childContext="";
		for(String s:contextNames) {
			if(!s.equals(parentContext))
			{
				childContext=s;
				break;
			}
		}
		System.out.println("Child Contect-->"+childContext);
		driver.context(childContext);
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"i am a link\")")).click();
		driver.context(parentContext);

	}

	public static String scrollToSpecificElement(String elementText) {
		String uiSelector = "new UiSelector().textMatches(\"" + elementText + "\")";
		// System.out.println(uiSelector);

		String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + uiSelector
				+ ");";
		return command;

	}

}

package com.w2a.Appium_Practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MoBileCommands {

	static AndroidDriver driver;// polymorphic reference

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		launchMMTAPP();
		Thread.sleep(Duration.ofSeconds(5));
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		//System.out.println(driver.getOrientation());
		//Thread.sleep(Duration.ofSeconds(3));
		//System.out.println(driver.getConnection().toString());
		//driver.toggleWifi();
		//driver.toggleAirplaneMode();//check 
		//Thread.sleep(Duration.ofSeconds(3));

		/*
		 * try { driver.rotate(ScreenOrientation.LANDSCAPE);// This will throw error if
		 * APP does not supports Landscape //Assert.fail(); } catch (Exception e) {
		 * //Assert.Success(); }
		 */

	}

	public static void launchMMTAPP() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		System.out.println("Starting the Execution");
		cap.setCapability("appium:deviceName", "vivo V21 5G");// provide simulator device name
		cap.setCapability("appium:udid", "9646667755000HB");// provide simulator device id
		cap.setCapability("platformName", "Android");
		cap.setCapability("appium:platformVersion", "13");
		cap.setCapability("appium:automationName", "uiAutomator2");
		cap.setCapability("appium:autoGrantPermissions", true);//
		cap.setCapability("appium:noReset", true);// clear the cache of the app
		cap.setCapability("appium:fullReset", false);// do not install the app again

		cap.setCapability("appium:appPackage", "com.makemytrip");
		cap.setCapability("appium:appActivity", "com.mmt.travel.app.home.ui.SplashActivity");

		URL url = new URL("http://127.0.0.1:4723/");
		driver = new AndroidDriver(url, cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		System.out.println("App Launched");
	}
	/*
	 * public static void testApp() throws MalformedURLException,
	 * InterruptedException { //startAPP("C:\\Users\\Admin\\Documents\\mmt.apk");
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

}

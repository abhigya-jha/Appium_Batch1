package com.w2a.Appium_Practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class Test {
	
	static AppiumDriver driver;
	
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
		cap.setCapability("appium:autoGrantPermissions", false);
		//cap.setCapability("appium:app", "C:\\Users\\Admin\\Documents\\facebook.apk");
		
		cap.setCapability("appium:appPackage", "shoppersstop.shoppersstop");
		cap.setCapability("appium:appActivity", "com.shoppersstop.apps.ui.landing.LandingActivity");
		
		URL url= new URL("http://127.0.0.1:4723/");
		driver= new AppiumDriver(url,cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("Application Launched!!!");
		
		
		
		
		/*driver.findElement(By.xpath("(//*[@class='android.widget.EditText'])[1]")).sendKeys("Abhigya@gmail.com");
		
		driver.findElement(By.xpath("(//*[@class='android.widget.EditText'])[2]")).sendKeys("Password123");
		
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Log in\"]")).click();
		By ok=By.xpath("//android.widget.Button[@resource-id=\"com.facebook.katana:id/(name removed)\"]");
		By invalid=By.xpath("//android.widget.TextView[@text=\"Invalid username or password\"]");
		System.out.println(driver.findElement(ok).getText());
		System.out.println(driver.findElement(invalid).getText());*/
		
		// Wait for Wrong Credential Alert Message to appear
		// If Appeared -> Test CAse passed
		// If not appeared -> Test Case Failed
		
		//driver.findElement(By.id("com.android.permissioncontroller:id/permission_deny_button")).click();
		
		
		
		//driver.findElement(By.xpath("(//*[@class='android.widget.EditText'])[1]")).sendKeys("abc@gmail.com");
		//driver.findElement(By.xpath("(//*[@class='android.widget.EditText'])[2]")).sendKeys("Paasword1");
		
		//driver.findElement(By.xpath("//android.view.View[@content-desc=\"Log in\"]")).click();
		////android.widget.Button[@content-desc="Log in"]/android.view.ViewGroup
		
		//driver.findElement(By.id("Mobile number or email")).sendKeys("abc@gmail.com");
		
	}

}

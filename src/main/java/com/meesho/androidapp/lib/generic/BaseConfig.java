package com.meesho.androidapp.lib.generic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import com.meesho.androidapp.lib.init.GlobalVariables;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseConfig
{
	public static GlobalVariables gv = new GlobalVariables();
	@BeforeTest
	public void configFile() throws MalformedURLException
	{
		GlobalVariables.capabilities = new DesiredCapabilities();
		GlobalVariables.capabilities.setCapability("automationName", gv.automationName);
		GlobalVariables.capabilities.setCapability("port", gv.port);
		GlobalVariables.capabilities.setCapability("deviceName", gv.deviceName);
		GlobalVariables.capabilities.setCapability("platformName", gv.platformName);
		GlobalVariables.capabilities.setCapability("platformVersion", gv.platformVersion);
		GlobalVariables.capabilities.setCapability("UDID", gv.UDID);
		GlobalVariables.capabilities.setCapability("appPackage", gv.appPackage);
		GlobalVariables.capabilities.setCapability("appActivity", gv.appActivity);
		GlobalVariables.capabilities.setCapability("fullReset", false);
		GlobalVariables.capabilities.setCapability("noReset", true);
		GlobalVariables.capabilities.setCapability("autoGrantPermissions", true);
		GlobalVariables.capabilities.setCapability("autoAcceptAlerts", true);
		GlobalVariables.capabilities.setCapability("appWaitDuration", 20000);
		GlobalVariables.capabilities.setCapability("avdLaunchTimeout", 30000);
		GlobalVariables.capabilities.setCapability("avdReadyTimeout", 30000);
		GlobalVariables.capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		
		System.out.println("http://127.0.0.1:"+gv.port+"/wd/hub");

		GlobalVariables.driver = new AndroidDriver(new URL("http://127.0.0.1:"+gv.port+"/wd/hub"),GlobalVariables.capabilities);
		GlobalVariables.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
	}
}

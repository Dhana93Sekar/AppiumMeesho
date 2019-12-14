package com.meesho.androidapp.lib.init;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.meesho.androidapp.lib.generic.ResourceAccessLib;
import io.appium.java_client.android.AndroidDriver;

public class GlobalVariables
{
	public static AndroidDriver driver;
	public static DesiredCapabilities capabilities;
	
	public String port =ResourceAccessLib.getPropertyValue(Directories.dcFile, "port");
	public String deviceName = ResourceAccessLib.getPropertyValue(Directories.dcFile, "deviceName");
	public String platformName = ResourceAccessLib.getPropertyValue(Directories.dcFile, "platformName");
	public String platformVersion = ResourceAccessLib.getPropertyValue(Directories.dcFile, "platformVersion");
	public String UDID = ResourceAccessLib.getPropertyValue(Directories.dcFile, "avd");
	public String automationName = ResourceAccessLib.getPropertyValue(Directories.dcFile, "automationName");
	public String appPackage = ResourceAccessLib.getPropertyValue(Directories.dcFile, "appPackage");
	public String appActivity = ResourceAccessLib.getPropertyValue(Directories.dcFile, "appActivity");
	
}

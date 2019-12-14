package com.meesho.androidapp.lib.generic;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import com.meesho.androidapp.lib.init.Directories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class MobileActionUtils 
{
	public static void isElementDisplayed(AndroidDriver<?> driver,MobileElement element)
	{
		try {
			Thread.sleep(3000);
			element.isDisplayed();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void tapOnElement(AndroidDriver<?> driver, MobileElement element)
	{
		driver.tap(1, element, 1000);
	}
	public static void tapNTimes(AndroidDriver<?> driver, MobileElement element,int times)
	{
		for(int i=1;i<=times;i++)
		{
		driver.tap(1, element, 1000);
		}
	}

	public static void tapOnElement(AndroidDriver<?> driver, int x, int y)
	{
		driver.tap(1, x, y, 1000);
	}

	public static void scrollToElement(AndroidDriver<?> driver,String attName, String attValue)
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector())."
				+ "scrollIntoView("+attName+"(\""+attValue+ "\"))");
	}


	public static void swipeUp(AndroidDriver<?> driver)
	{
		Dimension dim = driver.manage().window().getSize();
		int x = dim.getHeight();
		int y = dim.getWidth();
		int starty = (int) (x*0.80);
		int endy = (int)(x*0.20);
		int startx = (int)(y*0.20);
		int endx = (int)(y*0.50);
		driver.swipe(startx,starty,endx,endy,3000);
	}

	public static void swipeDown(AndroidDriver<?> driver,int startx, int endx)
	{
		Dimension dim = driver.manage().window().getSize();
		int x = dim.getHeight();
		int starty = (int) (x*0.20);
		int endy = (int)(x*0.80);
		driver.swipe(startx,starty,endx,endy,1000);
	}

	public static void swipeRight(AndroidDriver<?> driver, int starty, int endy)
	{
		Dimension dim = driver.manage().window().getSize();
		int y = dim.getWidth();
		int startx = (int) (y*0.20);
		int endx = (int)(y*0.80);
		driver.swipe(startx,starty,endx,endy,1000);
	}

	public static void swipeLeft(AndroidDriver<?> driver, int starty, int endy)
	{
		Dimension dim = driver.manage().window().getSize();
		int y = dim.getWidth();
		int startx = (int)(y*0.80);
		int endx = (int)(y*0.20);
		driver.swipe(startx,starty,endx,endy,1000);
	}

	public static void hideKeyboard(AndroidDriver<?> driver)
	{
		driver.hideKeyboard();
	}

	public static void openNotifications(AndroidDriver<?> driver)
	{
		driver.openNotifications();
	}

	public static void isLocked(AndroidDriver<?> driver)
	{
		driver.isLocked();
	}

	public static void lockDevice(AndroidDriver<?> driver)
	{
		driver.lockDevice();
	}

	public static void unlockDevice(AndroidDriver<?> driver)
	{
		driver.unlockDevice();
	}

	public static void isAppInstalled(AndroidDriver<?> driver, String bundleId)
	{ 
		driver.isAppInstalled(bundleId);
	}

	public static void installApp(AndroidDriver<?> driver, String appPath)
	{
		driver.installApp(appPath);
	}

	public static void launchApp(AndroidDriver<?> driver)
	{
		driver.launchApp();
	}

	public static void seekBar(AndroidDriver<?> driver,MobileElement element, int level)
	{
		MobileActionUtils.isElementDisplayed(driver, element);
		TouchAction act1 = new TouchAction(driver);
		act1.press(element).release().perform();
		Point p = element.getLocation();
		int startx = p.getX();
		int starty = p.getY();
		Dimension dim = element.getSize();
		int endx = (int)(startx+dim.getWidth()*(level/100));
		int endy = starty;
		TouchAction act2 = new TouchAction(driver);
		act2.press(startx,starty).waitAction(1000).moveTo(endx, endy).release().perform();
	}

	public static void dragAndDrop(AndroidDriver<?> driver, MobileElement source, MobileElement destination)
	{
		TouchAction act = new TouchAction(driver);
		act.press(source).waitAction(2000).moveTo(destination).release().perform();
	}

	public static void runAppInBackaground(AndroidDriver<?> driver, int seconds)
	{
		driver.runAppInBackground(seconds);
	}

	public static void switchWindow(AndroidDriver<?> driver, String pageTitle)
	{
		Set<String> contexts = driver.getContextHandles();
		List<String> contextList = new ArrayList<String>(contexts);
		System.out.println("List Elements==>"+contextList);
		for(String s : contextList)
		{
			if(driver.getTitle().equals(s))
			{
				driver.context(contextList.get(1));
			}
		}
	}

	public static void pressBackBtn(AndroidDriver<?> driver)
	{
		driver.pressKeyCode(AndroidKeyCode.BACK);
	}

	public static String getText(MobileElement element)
	{
		return element.getText();
	}

	public static String captureScreenshot(AndroidDriver<?> driver,String screenshotName)
	{
		TakesScreenshot src = ((TakesScreenshot) driver);
		File srcFile = src.getScreenshotAs(OutputType.FILE);
		String dest = Directories.srceenshotPath+screenshotName+".png";
		File destFile = new File(dest);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dest;
	}
	
	public static void sendKeysAndClick(MobileElement element,String text)
	{
		try {
			Thread.sleep(2000);
			element.sendKeys(text);
			element.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void sendKeys(MobileElement element,String text)
	{
		try {
			Thread.sleep(2000);
			element.sendKeys(text);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static List<String> getList(List<MobileElement> results)
	{
		List<String> resultText=null;
		try {
			Thread.sleep(2000);
			resultText = new ArrayList<String>();
			for(MobileElement wb: results)
			{
				resultText.add(wb.getText());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultText;
	}
	
	public static void getListandClick(List<MobileElement> results,String text)
	{
		List<String> resultText=null;
		try {
			Thread.sleep(2000);
			resultText = new ArrayList<String>();
			for(MobileElement wb: results)
			{
				if(wb.getText().equalsIgnoreCase(text))
				{
					wb.click();
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getListandClick(List<MobileElement> results,int index)
	{
		
		try {
			Thread.sleep(2000);
			results.get(0).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void click(AndroidDriver<?> driver, MobileElement element) 
	{
		try {
			Thread.sleep(3000);
			MobileActionUtils.isElementDisplayed(driver, element);
			element.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	
	
	
	
	

}

package com.meesho.androidapp.lib.pomRepo;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;

import java.util.Map;
import com.meesho.androidapp.lib.generic.MobileActionUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage 
{
	public AndroidDriver<?> driver; 
	public HomePage(AndroidDriver<?> driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(id="com.meesho.supply:id/name")
	private MobileElement productName;
	
	@AndroidFindBy(id="com.meesho.supply:id/action_orders")
	private MobileElement OrderLink;

	/**
	 * @return the orderLink
	 */
	public MobileElement getOrderLink() {
		return OrderLink;
	}
	
	/**
	 * @return the productName
	 */
	public MobileElement getProductName() {
		return productName;
	}
	
	@AndroidFindBy(id="com.meesho.supply:id/whatsapp_share")
	private MobileElement shareNow_Btn;
	/**
	 * @return the driver
	 */
	public AndroidDriver<?> getDriver() {
		return driver;
	}

	/**
	 * @return the shareNow_Btn
	 */
	public MobileElement getShareNow_Btn() {
		return shareNow_Btn;
	}
	
	
	public void selectProduct(AndroidDriver<?> driver,int catalognum)
	{
		Map<String,Integer> count = new HashMap<String, Integer>();
		while(true)	
		{
			try {
			getShareNow_Btn();
			String text = getProductName().getText();
			if(! count.containsKey(text))
			{
				count.put(text, 1);
			}
			else
			{
				MobileActionUtils.swipeUp(driver);
			}
			if(count.size()==catalognum)
			{
			System.out.println(count);
			getProductName().click();
			break;
			}
			}
			catch(Exception e)
			{ 
				MobileActionUtils.swipeUp(driver);
			}
		}
	//	getProductName().click();
	}
	
	
}

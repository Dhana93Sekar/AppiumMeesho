package com.meesho.androidapp.lib.pomRepo;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.meesho.androidapp.lib.generic.MobileActionUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage 
{
	public AndroidDriver driver;
	MobileActionUtils utils = new MobileActionUtils();
	public CartPage(AndroidDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.meesho.supply:id/name")
	private List<MobileElement> paymentMethod;
	
	@AndroidFindBy(id="com.meesho.supply:id/proceed")
	private MobileElement proceed_Btn;
	
	@AndroidFindBy(id="com.meesho.supply:id/credits_option")
	private MobileElement meeshoCredits;

	/**
	 * @return the paymentMethod
	 */
	public List<MobileElement> getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * @return the proceed_Btn
	 */
	public MobileElement getProceed_Btn() {
		return proceed_Btn;
	}

	/**
	 * @return the meeshoCredits
	 */
	public MobileElement getMeeshoCredits() {
		return meeshoCredits;
	}
	
		
	
}

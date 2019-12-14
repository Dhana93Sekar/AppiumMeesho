package com.meesho.androidapp.lib.pomRepo;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddMarginPage
{
	AndroidDriver<?> driver;
	public AddMarginPage(AndroidDriver<?> driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(id="com.meesho.supply:id/amount_text")
	private MobileElement enterMargin;
	
	@AndroidFindBy(id="com.meesho.supply:id/proceed")
	private MobileElement proceedBtn;
	
	@AndroidFindBy(id="com.meesho.supply:id/marginPrice")
	private MobileElement marginPrice;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Order Total']/following-sibling::android.widget.TextView")
	private MobileElement orderPrice;
	/**
	 * @return the driver
	 */
	public AndroidDriver<?> getDriver() {
		return driver;
	}

	/**
	 * @return the enterMargin
	 */
	public MobileElement getEnterMargin() {
		return enterMargin;
	}

	/**
	 * @return the proceedBtn
	 */
	public MobileElement getProceedBtn() {
		return proceedBtn;
	}

	/**
	 * @return the marginPrice
	 */
	public MobileElement getMarginPrice() {
		return marginPrice;
	}

	/**
	 * @return the orderPrice
	 */
	public MobileElement getOrderPrice() {
		return orderPrice;
	}
	
	public String marginAmount(MobileElement element,int amount)
	{
		char arr[] = element.getText().toCharArray();
		String orderAmount="";
		for(char s : arr)
		{
			if(Character.isDigit(s))
			{
				orderAmount+=s;
			}
		}
		Integer i = Integer.parseInt(orderAmount);
		i = amount + i;
		return String.valueOf(i);
	}
	
}

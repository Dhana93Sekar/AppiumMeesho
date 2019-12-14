package com.meesho.androidapp.lib.pomRepo;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OrderPage 
{
	AndroidDriver<?> driver;
	public OrderPage(AndroidDriver<?> driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(className="com.meesho.supply:id/name")
	private MobileElement customerName;
	
	/**
	 * @return the customerName
	 */
	public MobileElement getCustomerName() {
		return customerName;
	}

	/**
	 * @return the mobileNumber
	 */
	public MobileElement getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @return the addressLine
	 */
	public MobileElement getAddressLine() {
		return addressLine;
	}

	/**
	 * @return the street
	 */
	public MobileElement getStreet() {
		return street;
	}

	/**
	 * @return the city
	 */
	public MobileElement getCity() {
		return city;
	}

	/**
	 * @return the state
	 */
	public MobileElement getState() {
		return state;
	}

	/**
	 * @return the pinCode
	 */
	public MobileElement getPinCode() {
		return pinCode;
	}

	/**
	 * @return the saveAddress
	 */
	public MobileElement getSaveAddress() {
		return saveAddress;
	}

	/**
	 * @return the placeOrder
	 */
	public MobileElement getPlaceOrder() {
		return placeOrder;
	}

	/**
	 * @return the dismissBtn
	 */
	public MobileElement getDismissBtn() {
		return DismissBtn;
	}

	/**
	 * @return the orderConfirmMsg
	 */
	public MobileElement getOrderConfirmMsg() {
		return orderConfirmMsg;
	}

	@AndroidFindBy(className="com.meesho.supply:id/mobile")
	private MobileElement mobileNumber;
	
	@AndroidFindBy(className="com.meesho.supply:id/address_line_1")
	private MobileElement addressLine;
	
	@AndroidFindBy(className="com.meesho.supply:id/address_line_2")
	private MobileElement street;
	
	@AndroidFindBy(className="com.meesho.supply:id/city")
	private MobileElement city;
	
	@AndroidFindBy(className="com.meesho.supply:id/state")
	private MobileElement state;
	
	@AndroidFindBy(className="com.meesho.supply:id/pin")
	private MobileElement pinCode;
	
	@AndroidFindBy(className="com.meesho.supply:id/proceed")
	private MobileElement saveAddress;
	
	@AndroidFindBy(id="com.meesho.supply:id/place_order")
	private MobileElement placeOrder;
	
	@AndroidFindBy(uiAutomator="text(\"Dismiss\")")
	private MobileElement DismissBtn;
	
	@AndroidFindBy(xpath="//androidx.recyclerview.widget.RecyclerView//android.widget.TextView[1]")
	private MobileElement orderConfirmMsg;
}

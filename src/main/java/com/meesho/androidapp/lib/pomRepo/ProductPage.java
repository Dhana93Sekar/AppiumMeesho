package com.meesho.androidapp.lib.pomRepo;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.meesho.androidapp.lib.generic.MobileActionUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductPage 
{
	AndroidDriver<?> driver;
	public ProductPage(AndroidDriver<?> driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(id="com.meesho.supply:id/product_image")
	private MobileElement product_Image;
	
	@AndroidFindBy(id="com.meesho.supply:id/product_title")
	private MobileElement product_Title;
	
	@AndroidFindBy(id="com.meesho.supply:id/add_to_cart")
	private MobileElement addToCart_Btn;
	
	@AndroidFindBy(id="com.meesho.supply:id/selectSize")
	private MobileElement selectSize_Option;
	
	@AndroidFindBy(className= "android.widget.RadioButton")
	private List<MobileElement> selectsize_Btn;
	
	@AndroidFindBy(id="com.meesho.supply:id/increment_qty")
	private MobileElement increment_Quantity;
	
	@AndroidFindBy(id="com.meesho.supply:id/btn_continue")
	private MobileElement continue_Btn;
	
	@AndroidFindBy(id="com.meesho.supply:id/cart_count")
	private MobileElement cart_count;
	
	
	/**
	 * @return the product_Image
	 */
	public MobileElement getProduct_Image() {
		return product_Image;
	}
	
	/**
	 * @return the product_Title
	 */
	public MobileElement getProduct_Title() {
		return product_Title;
	}

	/**
	 * @return the addToCart_Btn
	 */
	public MobileElement getAddToCart_Btn() {
		return addToCart_Btn;
	}

	/**
	 * @return the selectSize_Option
	 */
	public MobileElement getSelectSize_Option() {
		return selectSize_Option;
	}

	/**
	 * @return the selectsize_Btn
	 */
	public List<MobileElement> getSelectsize_Btn() {
		return selectsize_Btn;
	}

	/**
	 * @return the increment_Quantity
	 */
	public MobileElement getIncrement_Quantity() {
		return increment_Quantity;
	}

	/**
	 * @return the continue_Btn
	 */
	public MobileElement getContinue_Btn() {
		return continue_Btn;
	}

	/**
	 * @return the cart_count
	 */
	public MobileElement getCart_count() {
		return cart_count;
	}

	/**
	 * @return the checkOut_Btn
	 */
	public MobileElement getCheckOut_Btn() {
		return checkOut_Btn;
	}

	@AndroidFindBy(id="com.meesho.supply:id/checkout")
	private MobileElement checkOut_Btn;
	
	public void selectProduct(AndroidDriver<?> driver,int catalognum)
	{
		ArrayList<String> count = new ArrayList<String>();
		while(true)	
		{
			try {
			count.add(getProduct_Image().getText());
			if(count.size()==catalognum)
			{
			System.out.println(count);
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

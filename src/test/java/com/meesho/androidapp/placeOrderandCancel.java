package com.meesho.androidapp;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.meesho.androidapp.lib.generic.BaseConfig;
import com.meesho.androidapp.lib.generic.MobileActionUtils;
import com.meesho.androidapp.lib.pomRepo.AddMarginPage;
import com.meesho.androidapp.lib.pomRepo.CartPage;
import com.meesho.androidapp.lib.pomRepo.HomePage;
import com.meesho.androidapp.lib.pomRepo.OrderPage;
import com.meesho.androidapp.lib.pomRepo.ProductPage;

public class placeOrderandCancel extends BaseConfig
{
	@Test
	public void createOrderAndCancelTest()
	{
		MobileActionUtils utils = new MobileActionUtils();
		HomePage home = new HomePage(gv.driver);
		
		home.selectProduct(gv.driver, 5);
		
		ProductPage product = new ProductPage(gv.driver);
		product.selectProduct(gv.driver, 1);
		utils.click(gv.driver, product.getProduct_Image());
		utils.click(gv.driver, product.getAddToCart_Btn());
		utils.getListandClick(product.getSelectsize_Btn(),0);
		utils.tapNTimes(gv.driver, product.getIncrement_Quantity(), 2);
		utils.click(gv.driver, product.getContinue_Btn());
		System.out.println(utils.getText(product.getCart_count()));
		utils.click(gv.driver, product.getCheckOut_Btn());
		CartPage cart = new CartPage(gv.driver);
		utils.getListandClick(cart.getPaymentMethod(), "Cash on Delivery");
		utils.click(gv.driver, cart.getProceed_Btn());
		
		AddMarginPage margin = new AddMarginPage(gv.driver);
		utils.sendKeysAndClick(margin.getEnterMargin(),margin.marginAmount(margin.getOrderPrice(), 10));
		utils.hideKeyboard(gv.driver);
		utils.click(gv.driver, margin.getProceedBtn());
		utils.click(gv.driver, margin.getProceedBtn());
		OrderPage order = new OrderPage(gv.driver);
		utils.click(gv.driver,order.getPlaceOrder());
		utils.click(gv.driver, order.getDismissBtn());
		System.out.println(utils.getText(order.getOrderConfirmMsg()));
		utils.pressBackBtn(gv.driver);
		
		
		
		
	}
	
	
}

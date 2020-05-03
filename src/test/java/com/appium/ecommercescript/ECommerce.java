package com.appium.ecommercescript;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.appium.ecommercebase.EcommerceBaseTest;
import com.appium.pageObject.FormPagePO;
import com.appium.pageObject.ProductPagePO;


public class ECommerce extends EcommerceBaseTest{
	
	
	@Test(description="To verify the lets shop button is working")
	public void ecommercevalid_tc1() throws InterruptedException {
		FormPagePO fp=new FormPagePO(driver);
		fp.typeName("rahul");
		driver.hideKeyboard();
		fp.selectFemale();
		fp.selectCountry("Bahrain");
		ProductPagePO pp=fp.clickOnShopButton();
		Thread.sleep(4000);
		Assert.assertEquals(pp.getPageTitle(),"Products"," Page Title matched");
	}
	@Test(description="To add a single product to cart")
	public void eCommerce_tc3() throws InterruptedException 
	{   
		ProductPagePO pp=new ProductPagePO(driver);
		pp.backBtnClick();
		FormPagePO fp=new FormPagePO(driver);
		fp.typeName("rahul");
		driver.hideKeyboard();
		fp.selectFemale();
		fp.selectCountry("Bahrain");
		fp.clickOnShopButton();		
		pp.productNameClick("Converse All Star");
		pp.cartBtnClick();	
	}
	@Test(description="To verify the added product in cart",enabled=false)
	public void validate_checkoutProduct() throws InterruptedException 
	{
		FormPagePO fp=new FormPagePO(driver);
		fp.typeName("rahul");
		driver.hideKeyboard();
		fp.selectFemale();
		fp.selectCountry("Bahrain");
		fp.clickOnShopButton();
		ProductPagePO pp=new ProductPagePO(driver);
		pp.productNameClick("Converse All Star");
		pp.cartBtnClick();		
		Assert.assertEquals("Converse All Star", pp.getProductName());	
	}
	@Test
	public void validate_productSum() throws InterruptedException
	{  
		System.out.println("hhh");
	}
}

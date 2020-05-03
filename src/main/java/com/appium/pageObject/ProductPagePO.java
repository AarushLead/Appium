package com.appium.pageObject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import com.appium.generic.GUIMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductPagePO {
	protected Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	public AndroidDriver<AndroidElement> driver;

	@AndroidFindBy(xpath = "//*[@resource-id='com.androidsample.generalstore:id/productName']")
	private List<AndroidElement> products;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
	private List<AndroidElement> singleAddToCart;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private AndroidElement cartbnt;

	@AndroidFindBy(xpath = "//*[@text='ADD TO CART']")
	private List<AndroidElement> addToCartbtn;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
	private AndroidElement pageTitle;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_back")
	private AndroidElement backbtn;
	
	public ProductPagePO(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), ProductPagePO.class);
	}

	public List<AndroidElement> getProducts() {
		return products;
	}

	public List<AndroidElement> getAddToCart() {
		return singleAddToCart;
	}

	public AndroidElement pageTitle(){
		return pageTitle;

	}
	public AndroidElement getCartBnt() {
		return cartbnt;

	}
	public AndroidElement backBtn() {
		return backbtn;

	}
	
	public String getPageTitle()
	{   
		return pageTitle().getText();
	}
	public void backBtnClick()
	{  
		logger.info("Trying to find back button");
		if(backBtn().isDisplayed())
		logger.info("Back Button Displayed");
		backBtn().click();
		logger.info("click on Back button");
	}
	public void productNameClick(String text) throws InterruptedException {
		logger.info("Start Scrolling To Text:" + text);
		GUIMethods.scrollToTextByID(driver, text);
		int productcount = getProducts().size();
		if (productcount > 0) {
			for (int i = 0; i < productcount; i++) {
				if (getProducts().get(i).isDisplayed()) {
					String productname = getProducts().get(i).getText();
					if (productname.equalsIgnoreCase("Converse All Star")) {
						logger.info("Trying to find Add_to_cart Button");
						if (getAddToCart().get(i).isDisplayed()) {
							getAddToCart().get(i).click();
							logger.info(" Add_to_cart Button clicked");
							logger.info(text + " is added to cart");
							break;
						}
					}
				}

			}
		}

	}

	public void cartBtnClick() {

		logger.info("Trying to find CART button");
		if (getCartBnt().isDisplayed()) {
			logger.info("CART Button Displayed");
			getCartBnt().click();
			logger.info("click on CART button");
		}
	}

	public String getProductName() {
		int productcount = getProducts().size();
		String productname = null;
		for (int i = 0; i < productcount; i++) {
			productname = getProducts().get(i).getText();
		}
		return productname;

	}
}

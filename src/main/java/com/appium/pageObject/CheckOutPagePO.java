package com.appium.pageObject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckOutPagePO {
	
	protected Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	public AndroidDriver<AndroidElement> driver;

	@AndroidFindBy(xpath = "//*[@resource-id='com.androidsample.generalstore:id/productPrice']")
	private List<AndroidElement> productPrices;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	private AndroidElement total;

	public CheckOutPagePO(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), CheckOutPagePO.class);
	}

	public List<AndroidElement> getProductprices() {
		return productPrices;
	}

	public AndroidElement getTotal() {
		return total;
	}

	public double getAllProductPrice() {
		int productcount = getProductprices().size();
		double sum = 0.00;
		for (int i = 0; i < productcount; i++) {
			String sumText = getProductprices().get(i).getText().substring(1);
			sum = sum + Double.parseDouble(sumText);
		}
		return sum;
	}
	public double getProductTotal()
	{
		return Double.parseDouble(getTotal().getText().substring(1));	
	}
}

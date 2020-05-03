package com.appium.pageObject;


import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import com.appium.generic.GUIMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPagePO {
	protected Logger log = Logger.getLogger(this.getClass().getSimpleName());
	public AndroidDriver<AndroidElement> driver;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
    private AndroidElement nametxtbx;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
    private AndroidElement female_rd_btn;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private AndroidElement countrydrpdwn;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
    private AndroidElement shop_btn;
	
	public FormPagePO(AndroidDriver<AndroidElement> driver)
	{   
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	public AndroidElement getName()
	{
		return nametxtbx;
	}
	public AndroidElement getFemale()
	{
		return female_rd_btn;
	}
	public AndroidElement getcountry()
	{
		return countrydrpdwn;
	}
	public void typeName(String text)
	{   
		log.info("Trying to find name textbox");
		getName().clear();
		log.info("Clear the name textbox");
		getName().sendKeys(text);
		log.info("Typing the text:"+" "+text);
	}
	public void selectFemale()
	{  
		log.info("Trying to find Female Option");
		getFemale().click();
		log.info("Click on Female Option");
	}
	public void selectCountry(String cntry)
	{   
		log.info("Trying to find country dropdown");
		getcountry().click();
		log.info("click on country DropDown");
		GUIMethods.scrollToText(driver, cntry);
		log.info("Start Scrolling to the text: "+" "+cntry);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			log.error("Exeption:"+e.getMessage());
		}
	}
	public ProductPagePO clickOnShopButton()
	{   
		log.info("Trying to find let shop button");
		shop_btn.click();	
		log.info("Click on let shop button");
		return new ProductPagePO(driver);
		
    }

}

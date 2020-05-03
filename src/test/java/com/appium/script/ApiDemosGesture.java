package com.appium.script;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.appium.baseother.ApiDemosBase; 
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class ApiDemosGesture extends ApiDemosBase
{  
	
	@Test(priority=1)
	public void ScrollOps() throws InterruptedException
	{
		driver.findElementByAndroidUIAutomator("new UiSelector().description(\"Views\")").click();
		
	//	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"WebView\").instance(0))").click();
	    // OR
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))").click();
		Thread.sleep(2000);
	}
	@Test(priority=2)
    public void tapOperationAndLongPress() throws InterruptedException
    {   
    	TouchAction<?> t=new TouchAction<>(driver);
    	WebElement viewEle = driver.findElementByAndroidUIAutomator("new UiSelector().description(\"Views\")");       
    	t.tap(tapOptions().withElement(element(viewEle))).perform(); 
    	Thread.sleep(3000);
    	driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").instance(9)").click();
    	driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Custom Adapter\")").click();
    	WebElement people=driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
    	t.longPress(longPressOptions().withElement(element(people)).withDuration(ofSeconds(2))).release().perform();
    	System.out.println(driver.findElementByAndroidUIAutomator("text(\"Sample menu\")").isDisplayed());
    }
	@Test(priority=3)
	public void dragAndDropOps()
	{
		TouchAction<?> t=new TouchAction<>(driver);
    	WebElement viewEle = driver.findElementByAndroidUIAutomator("new UiSelector().description(\"Views\")"); 
	    t.tap(tapOptions().withElement(element(viewEle))).perform();
	    driver.findElementByAccessibilityId("Drag and Drop").click();
	    WebElement source = driver.findElementsByClassName("android.view.View").get(0);
	    WebElement destination = driver.findElementsByClassName("android.view.View").get(1);
	    t.longPress(element(source)).moveTo(element(destination)).release().perform(); //For Drag and Drop	    
	}
	@Test(priority=4)
	public void miscell()
	{
		 System.out.println(driver.currentActivity());
	     System.out.println(driver.getContext());
	     //views - Native , Hybrid, Webview
	     System.out.println(driver.getOrientation());
	     System.out.println(driver.isDeviceLocked());
	   //  driver.hideKeyboard();
	 	driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
	}
	@Test(priority=5)
	public void swipeOps() throws InterruptedException
	{
		TouchAction<?> t=new TouchAction<>(driver);
		Thread.sleep(1000);
    	driver.findElementByAndroidUIAutomator("new UiSelector().description(\"Views\")").click();
    	WebElement date=driver.findElementByAccessibilityId("Date Widgets");
    	t.tap(tapOptions().withElement(element(date))).perform();
    	driver.findElementByXPath("//android.widget.TextView[@text='2. Inline']").click();
    	driver.findElementByXPath("//*[@content-desc='9']").click();
    	WebElement fifteen=driver.findElementByXPath("//*[@content-desc='15']");
    	WebElement fourty=driver.findElementByXPath("//*[@content-desc='45']");
        t.longPress(longPressOptions().withElement(element(fifteen)).withDuration(ofSeconds(3))).moveTo(element(fourty)).release().perform();	    
       												//OR
    //  t.press(PointOption.point(fifteen.getLocation().getX(), fifteen.getLocation().getY())).waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000))).moveTo(PointOption.point(fourty.getLocation().getX(), fourty.getLocation().getY())).release().perform();
	}
    @Test(priority=6,enabled=false)
	public void preferenceClick() throws InterruptedException
	{   
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		Thread.sleep(4000);
		driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.CheckBox\")").click();
		driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.RelativeLayout\").instance(1)" ).click();	
		Thread.sleep(3000);
		driver.findElementByClassName("android.widget.EditText").sendKeys("Hello");
		driver.findElementByAndroidUIAutomator("text(\"OK\")").click();
	}
	@Test(priority=7)
	public void UiAutomatorExample_viewsClick()
	{
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Animation\")").click();
		driver.findElementByAndroidUIAutomator("new UiSelector().description(\"3D Transition\")").click();
	}
   
}

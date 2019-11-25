package eCommerceAPP;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecommerce_tc_1 extends base{

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Wing");
		driver.hideKeyboard();
		driver.findElementById("com.androidsample.generalstore:id/radioMale").click();
		driver.findElementById("android:id/text1").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"United States\"))");
		driver.findElementByXPath("//*[@text='United States']").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
	}

}

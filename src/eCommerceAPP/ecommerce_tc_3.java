package eCommerceAPP;

import java.net.MalformedURLException;

import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecommerce_tc_3 extends base{

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Wing");
		driver.hideKeyboard();
		driver.findElementById("com.androidsample.generalstore:id/radioMale").click();
		driver.findElementById("android:id/text1").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))");
		driver.findElementByXPath("//*[@text='Argentina']").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))");
		
		int count = driver.findElementsById("com.androidsample.generalstore:id/productName").size();
		for(int i=0; i<count; i++) 
		{
			String text = driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
			if (text.contentEquals("Jordan 6 Rings"))
			{
				driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
				break;
			}
		}
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		String resultName = driver.findElementById("com.androidsample.generalstore:id/productName").getText();
		Assert.assertEquals(resultName ,"Jordan 6 Rings", "Item not match");

	}

}

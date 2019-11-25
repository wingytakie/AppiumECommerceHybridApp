package eCommerceAPP;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecommerce_tc_4 extends base{

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Wing");
		driver.hideKeyboard();

		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
		driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(0).click();
		driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(1).click();
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		
		String cost1 = driver.findElementsByXPath("//*[@resource-id= 'com.androidsample.generalstore:id/productPrice']").get(0).getText();
		String cost2 = driver.findElementsByXPath("//*[@resource-id= 'com.androidsample.generalstore:id/productPrice']").get(1).getText();
		cost1 = cost1.replace("$", "" );
		cost2 = cost2.replace("$", "" );
		double total = Double.parseDouble(cost1) + Double.parseDouble(cost2);
		String totalAmount = driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
		totalAmount = totalAmount.replace("$", "");
		double totalA = Double.parseDouble(totalAmount);
		Assert.assertEquals(Double.parseDouble(totalAmount), total, "Cost not match, expecting:"  + total);

	}

}

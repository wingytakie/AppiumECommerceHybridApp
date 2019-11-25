package eCommerceAPP;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecommerce_tc_5 extends base{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Wing");
		driver.hideKeyboard();

		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
		driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(0).click();
		driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(1).click();
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		
		Thread.sleep(4000);
		double cost1 = getAmount(driver.findElementsByXPath("//*[@resource-id= 'com.androidsample.generalstore:id/productPrice']").get(0).getText());
		double cost2 = getAmount(driver.findElementsByXPath("//*[@resource-id= 'com.androidsample.generalstore:id/productPrice']").get(1).getText());
		double total = cost1 + cost2;
		double totalAmount = getAmount(driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText());
		Assert.assertEquals(totalAmount, total, "Cost not match, expecting:"  + total);

	}

	public static double getAmount(String value) {
		value = value.replace("$", "");
		double result = Double.parseDouble(value);
		return result;
		
	}
	
}

package eCommerceAPP;

import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import static  io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

public class ecommerce_tc_5_2 extends base{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Wing");
		driver.hideKeyboard();

		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

		driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(0).click();
		driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(1).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))");
		driver.findElementById("com.androidsample.generalstore:id/productAddCart").click();
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		
		Thread.sleep(4000);
		double cost1 = getAmount(driver.findElementsByXPath("//*[@resource-id= 'com.androidsample.generalstore:id/productPrice']").get(0).getText());
		double cost2 = getAmount(driver.findElementsByXPath("//*[@resource-id= 'com.androidsample.generalstore:id/productPrice']").get(1).getText());
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvCartProductList\")).scrollIntoView(new UiSelector().textMatches(\"Air Jordan 9 Retro\").instance(0))");
		double cost3 = getAmount(driver.findElementsByXPath("//*[@resource-id= 'com.androidsample.generalstore:id/productPrice']").get(2).getText());
		double total = Math.floor((cost1 + cost2 + cost3)*100)/100;
		double totalAmount = getAmount(driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText());
		Assert.assertEquals(totalAmount, total, "Cost not match, expecting:"  + total);
		
		WebElement checkbox = driver.findElementByClassName("android.widget.CheckBox");
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(checkbox))).perform();

		WebElement tc = driver.findElementByXPath("//*[@text='Please read our terms of conditions']");
		t.longPress(longPressOptions().withElement(element(tc)).withDuration(ofSeconds(2))).perform();
		
		driver.findElementById("android:id/button1").click();
		driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
		
	}

	public static double getAmount(String value) {
		DecimalFormat df = new DecimalFormat("#.##");
		value = value.replace("$", "");
		double result = Double.parseDouble(value);
		result = Double.valueOf(df.format(result));
		return result;
		
	}
	
}

package eCommerceAPP;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import static  io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class ecommerce_tc_6 extends base{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Wing");
		driver.hideKeyboard();

		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

		driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(0).click();
		driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(1).click();
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		
		Thread.sleep(2000);
		WebElement checkbox = driver.findElementByClassName("android.widget.CheckBox");
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(checkbox))).perform();
		driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
		Thread.sleep(2000);
		Set<String> contexts = driver.getContextHandles();
		for(String contextName :contexts) 
		{
			System.out.println(contextName);
		}
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElementByXPath("//*[@name='q']").sendKeys("Hello");
		driver.findElementByXPath("//*[@name='q']").sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}


	
}

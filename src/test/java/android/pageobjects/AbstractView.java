package android.pageobjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AbstractView{

	protected AndroidDriver driver;
	protected WebDriverWait wait;

	public AbstractView(AndroidDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 60);
	}

	protected static void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	protected void enter(AndroidElement element, String keys) {
		element.clear();
		element.sendKeys(keys);	
	}
	
	
	
	protected void click(AndroidElement element) {
		element.click();
	}
}

package android.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

 
public class AndroidDriverFactory {

	public static final long PAGE_LOAD_TIMEOUT_SEC = 30;

	protected static Logger logger;
	public static AndroidDriver driver;

	public static AndroidDriver get() {
		if (driver != null && isAlive(driver)) {
			return driver;
		} else {
			driver = createDriver();
			return driver;
		}
	}

	private static boolean isAlive(AndroidDriver driver) {
		return !driver.toString().contains("null");
	}


	private static AndroidDriver createDriver() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "TA993034ZX");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "6.0");
		capabilities.setCapability("appPackage", "com.pgssoft.testwarez");
		capabilities.setCapability("appActivity", "com.pgssoft.testwarez.activity.LandingPageActivity");
		capabilities.setCapability("autoAcceptAlerts", true);
		capabilities.setCapability("appWaitPackage", "com.android.packageinstaller");
		capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, "true");

		try {
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		logger = Logger.getLogger("WebDriverFactory");
		return driver;
	}

}

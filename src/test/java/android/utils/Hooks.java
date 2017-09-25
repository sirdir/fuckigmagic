package android.utils;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;

public class Hooks {
     private static AndroidDriver driver;

    @Before
    public void beforeScenario() {
        OpenApp();
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                takeScreenshot(scenario.getName(), scenario.getId());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        closeApp();
    }

    private void OpenApp() {
        driver = AndroidDriverFactory.get();
    }

    private void closeApp() {
        driver.quit();
        driver = null;
    }

    protected void takeScreenshot(String scenarioName, String scenarioId)
            throws IOException {
        File scrFile = driver.getScreenshotAs(OutputType.FILE);
        scrFile.renameTo(new File(".\\screenshots\\",
                Long.toHexString(System.currentTimeMillis()) + scenarioName + "[" + scenarioId + "]_screenshot.png"));

    }
}

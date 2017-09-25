package android;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
		plugin = {
		"pretty", "json:build/Cucumber.json",
		"html:build/cucumber-html-report"},
		features = "classpath:features",
		glue = "classpath:android.steps")
public class RunTests {

}

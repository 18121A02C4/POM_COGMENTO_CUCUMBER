package TestRunner_pack;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/AppFeatures/ContactsPage.feature"},
		glue = {"stepdefinitions", "AppHooks"},
		plugin = {"pretty"},monochrome = true
		
		)

public class MyTestRunner {
	
}
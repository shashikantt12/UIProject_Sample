package assessment.cleartrip.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags = "@FlightSearch", 
		features = "../ClearTripTestAssessment/FeatureFile", 
		glue={"assessment.cleartrip.stepdefinition"}, 
		monochrome = true,
		plugin = { "pretty", "html:target/cucumber-reports",
				"json:target/cucumber-reports/cucumber.json"}
		)
public class Runcukes {

}

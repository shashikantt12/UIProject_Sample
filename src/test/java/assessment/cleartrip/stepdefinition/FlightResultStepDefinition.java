package assessment.cleartrip.stepdefinition;

import assessment.cleartrip.test.FlightSearchTest;
import cucumber.api.java.en.When;

public class FlightResultStepDefinition {

	FlightSearchTest flightSearchTest;
	public FlightResultStepDefinition(){
		flightSearchTest = new FlightSearchTest();
	}
	
	@When("^Verify that user is lands on search result page$")
	public void verify_ResultPage_URL() throws InterruptedException{
		flightSearchTest.flightResultPageVerification();
	}
}

package assessment.cleartrip.stepdefinition;

import assessment.cleartrip.test.HomePageTest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageStepDefinition {

	HomePageTest homePageTest;
	public HomePageStepDefinition(){
		homePageTest = new HomePageTest();
	}
	
	@When("^verify user is on home page$")
	public void verify_HomePage_Header(){
		homePageTest.homePageHeaderVerification();
	}
	
	@Then("^User has to select the trip type as \"([^\"]*)\"$")
	public void select_triptype(String tripType){
		homePageTest.selectTripType(tripType);
	}
	
	@Then("^User has to enter in \"([^\"]*)\" textbox$")
	public void enter_details(String value){
		homePageTest.enterCityForTravel(value);
	}
	
	@Then("^User has to enter \"([^\"]*)\" textbox$")
	public void enterDate(String dateType){
		homePageTest.enterDate(dateType);
	}
	
	@Then("^User will select number of passenger from \"([^\"]*)\" dropdown$")
	public void select_Number_Passenger(String dropDown){
		homePageTest.selectPassengerTypeAndCount(dropDown);
	}
	
	@And("^User choose to click on search flight button$")
	public void click_Search_Button(){
		homePageTest.click();
	}
}

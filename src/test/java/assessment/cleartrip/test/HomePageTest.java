package assessment.cleartrip.test;

import org.junit.Assert;
import assessment.cleartrip.pages.HomePage;
import assessment.cleartrip.utility.DataConfig;
import assessment.cleartrip.utility.DriverUtils;

public class HomePageTest {

	HomePage homePage;
	public HomePageTest(){
		homePage = new HomePage(DriverUtils.getBrowser("firefox"));
	}
	
	public void homePageHeaderVerification(){
		if(homePage.verifyHeaderPresent()){
			Assert.assertEquals("Search flights", homePage.verifyHeaderText());
		}
	}
	
	public void selectTripType(String tripType){
		homePage.clickOnTripType(tripType);
	}
	
	public void enterCityForTravel(String textBox){
		if(textBox.equalsIgnoreCase("from")){
			homePage.enterDepartFrom(DataConfig.from);
		} else if(textBox.equalsIgnoreCase("to")) {
			homePage.enterToDest(DataConfig.to);
		}
	}
	
	public void enterDate(String dateType){
		if(dateType.equalsIgnoreCase("fromDate")){
			homePage.enterDate(dateType,"Thu, 26 Jul, 2018");
		} else if (dateType.equalsIgnoreCase("toDate")){
			homePage.enterDate(dateType,"Sat, 28 Jul, 2018");
		}
	}
	
	public void selectPassengerTypeAndCount(String dropDown){
		if(dropDown.equalsIgnoreCase("adult")){
			homePage.selectPersonCount(dropDown, DataConfig.adultCount);
		} else if(dropDown.equalsIgnoreCase("child")){
			homePage.selectPersonCount(dropDown, DataConfig.childCount);
		}  else if(dropDown.equalsIgnoreCase("infant")){
			homePage.selectPersonCount(dropDown, DataConfig.infantCount);
		}
	}
	
	public void click(){
		homePage.searchFlight();
	}
}

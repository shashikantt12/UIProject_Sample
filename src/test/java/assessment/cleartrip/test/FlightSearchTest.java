package assessment.cleartrip.test;

import org.junit.Assert;

import assessment.cleartrip.pages.FlightResultPage;
import assessment.cleartrip.utility.DriverUtils;



public class FlightSearchTest {

	FlightResultPage flightResultPage;
	public FlightSearchTest(){
		flightResultPage = new FlightResultPage(DriverUtils.getBrowser("firefox"));
	}
	
	public void flightResultPageVerification() throws InterruptedException{
		Thread.sleep(4000);
		Assert.assertTrue("Search result page is not appearing. Pl. check", flightResultPage.verifySearchResultpage());
	}
}

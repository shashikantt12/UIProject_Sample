package assessment.cleartrip.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import assessment.cleartrip.utility.SeleniumFunctionUtils;

public class FlightResultPage {

	WebDriver driver;
	public FlightResultPage(WebDriver driver) {
	    PageFactory.initElements(driver, this);
	    this.driver = driver;
	}
	
	@FindBy(xpath = "//button[@class='booking']")
	private WebElement bookBtn;
	
	@FindBy(xpath = "//th[@class='depart']")
	private WebElement departTime;
	
	@FindBy(xpath = "//th[@class='arrive']")
	private WebElement arriveTime;

	@FindBy(xpath = "//th[@class='duration']")
	private WebElement duration;
	
	@FindBy(xpath = "//th[@class='price']")
	private WebElement price;
	
	@FindBy(xpath = "//small[contains(text(),'GoAir')]")
	private WebElement airlineType;
	
	@FindBy(xpath = "//ul[contains(@class, 'listView')]//li//table")
	private WebElement flightRangeCheck;
	
	@FindBy(xpath = "//a[@id='modifySearchLink']")
	private WebElement modifySearchButton;
	
	private String flightRangeCheck1 = "//ul[contains(@class, 'listView')]//li//table";
	
	public boolean verifySearchResultpage(){
		
		if(	driver.getCurrentUrl().contains("flights/results?from")){
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean verifyModifySearchLinkPresent(){
		//WebElement modifyBtn = SeleniumFunctionUtils.fluentWait(modifySearchButton);
		SeleniumFunctionUtils.implicitWait();
		
		return modifySearchButton.isDisplayed();
	}
	
	public void bookFlight(String departTime, String arriveTime, int fromPriceRange, int toPriceRange, String airlineType){
		
		boolean departTimeCheck = false, arriveTimeCheck = false, airlineTypeCheck = false, fromPriceCheck = false, toPriceCheck = false;
		
		List<WebElement> tables = driver.findElements(By.xpath(flightRangeCheck1));
		for (WebElement table : tables) {
			List<WebElement> allThs = driver.findElements(By.xpath(table+"//th"));
			for (WebElement th : allThs) {
				if(th.getText().toString().equalsIgnoreCase(airlineType)){
					airlineTypeCheck = true;
				} else if(th.getText().toString().equalsIgnoreCase(departTime)){
					departTimeCheck = true;
				} else if(th.getText().toString().equalsIgnoreCase(arriveTime)){
					arriveTimeCheck = true;
				} else if(Integer.parseInt(th.getText())> fromPriceRange){
					fromPriceCheck = true;
				} else if(Integer.parseInt(th.getText())< toPriceRange){
					toPriceCheck = true;
				}
				
				if(departTimeCheck == true && arriveTimeCheck == true && airlineTypeCheck == true 
						&& toPriceCheck == true && fromPriceCheck == true){
					//need perfect code here.
					bookBtn.click();
				}
			}
		}
	}
}

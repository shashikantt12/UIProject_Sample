package assessment.cleartrip.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

	public HomePage(WebDriver driver) {
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1[contains(text(), 'Search flights')]")
	private WebElement searchFlightHeader;
	
	@FindBy(xpath = "//input[@id='OneWay']")
	private WebElement oneWay;
	
	@FindBy(xpath = "//input[@id='RoundTrip']")
	private WebElement roundTrip;
	
	@FindBy(xpath = "//input[@id='MultiCity']")
	private WebElement multiCity;
	
	@FindBy(xpath = "//input[@id='FromTag']")
	private WebElement from;
	
	@FindBy(xpath = "//input[@id='ToTag']")
	private WebElement to;
	
	@FindBy(xpath = "//input[@id='DepartDate']")
	private WebElement fromDate;
	
	@FindBy(xpath = "//input[@id='ReturnDate']")
	private WebElement toDate;
	
	@FindBy(xpath = "")
	private WebElement departOn;
	
	@FindBy(xpath = "//select[@id='Adults']")
	private WebElement adultDropdown;
	
	@FindBy(xpath = "//select[@id='Childrens']")
	private WebElement childDropdown;
	
	@FindBy(xpath = "//select[@id='Infants']")
	private WebElement infantsDropdown;
	
	@FindBy(xpath = "//select[@id='Class']")
	private WebElement classOfTravel;
	
	@FindBy(xpath = "//input[@id='SearchBtn']")
	private WebElement searchFlightBtn;
	
	public boolean verifyHeaderPresent(){
		return searchFlightHeader.isDisplayed();
	}
	
	public String verifyHeaderText(){
		return searchFlightHeader.getText().toString();
	}
	
	public void clickOnTripType(String tripType){
		if(tripType.equalsIgnoreCase("oneway")){
			oneWay.click();
		} else if(tripType.equalsIgnoreCase("roundtrip")){
			roundTrip.click();
		} else if(tripType.equalsIgnoreCase("multicity")){
			multiCity.click();
		} else {
			throw new IllegalStateException("Please provide valid trip types. Valid ones are oneway, roundtrip and multiciy");
		}
	}
	
	public void enterDate(String dateType, String value) {
		if(dateType.equalsIgnoreCase("fromDate")){
			fromDate.clear();
			fromDate.sendKeys(value);
			fromDate.sendKeys(Keys.TAB);
		} else if(dateType.equalsIgnoreCase("toDate")){
			toDate.clear();
			toDate.sendKeys(value);
			toDate.sendKeys(Keys.TAB);
		} else {
			throw new IllegalStateException("Please provide valid date types. Valid ones are fromDate and toDate");
		}
	}
	
	public void enterDepartFrom(String dest){
		try{
			from.clear();
			from.sendKeys(dest);
			from.sendKeys(Keys.TAB);
		} catch (Exception e) {
			throw new IllegalStateException("Please provide valid value");
		}
	}
	
	public void enterToDest(String dest){
		try{
			to.clear();
			to.sendKeys(dest);
			to.sendKeys(Keys.TAB);
		} catch (Exception e) {
			throw new IllegalStateException("Please provide valid value");
		}
	}
	
	public void selectPersonCount(String personType, String count){
		Select select ; 
		List<WebElement> options ;
		try{
			if(personType.equalsIgnoreCase("adult")){
				select = new Select(adultDropdown);
				options = select.getOptions();
				for (WebElement webElement : options) {
					if(webElement.getText().equals(count)){
						webElement.click();
					}
				}
			} else if(personType.equalsIgnoreCase("child")){
				select = new Select(childDropdown);
				options = select.getOptions();
				for (WebElement webElement : options) {
					if(webElement.getText().equals(count)){
						webElement.click();
					}
				}
			} else if(personType.equalsIgnoreCase("infant")){
				select = new Select(infantsDropdown);
				options = select.getOptions();
				for (WebElement webElement : options) {
					if(webElement.getText().equals(count)){
						webElement.click();
					}
				}
			} else {
				throw new IllegalStateException("Please provide valid person types. Valid ones are adult, child and infant");
			}
		} catch (Exception e){
			throw new IllegalStateException("Please provide valid value");
		}
	}
	
	public void selectClassOfTravel(String value){
		try{
			Select select = new Select(classOfTravel);
			List<WebElement> options = select.getOptions();
			for (WebElement webElement : options) {
				if(webElement.getText().equals(value)){
					webElement.click();
				}
			}
		} catch (Exception e){
			throw new IllegalStateException("Please provide valid class value. Valid ones are Economy, Business, First and Premium Economy");
		}
	}
	
	public void searchFlight(){
		searchFlightBtn.click();
	}
}

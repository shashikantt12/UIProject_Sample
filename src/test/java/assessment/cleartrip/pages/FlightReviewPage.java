package assessment.cleartrip.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightReviewPage {

	public FlightReviewPage(WebDriver driver) {
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='name']")
	private WebElement airlineType;
	
	@FindBy(xpath = "//input[@id='itineraryBtn']")
	private WebElement continueBooking;
	
	@FindBy(xpath = "//input[@id='insurance_confirm']")
	private WebElement termConditionChkBox;
	
	@FindBy(xpath = "//input[@id='username']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@id='password_1']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@id='LoginContinueBtn_1']")
	private WebElement continueBtn;
	
	@FindBy(xpath = "//input[@id='signinLabel']")
	private WebElement signInlabel;
	
	public String verifyAirlineType(){
		return airlineType.getText().toString();
	}
	
	public void acceptTermCondition(){
		termConditionChkBox.click();
	}
	
	public void continueBooking(){
		continueBooking.click();
	}
	
	public void enterEmail(String emailId){
		email.sendKeys(emailId);
	}
	
	public void enterPassword(String passwordVal){
		password.sendKeys(passwordVal);
	}
	
	public void selectSignIn(){
		signInlabel.click();
	}
	
	public void continueBtn(){
		continueBtn.click();
	}
}

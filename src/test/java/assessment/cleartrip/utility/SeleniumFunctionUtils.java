package assessment.cleartrip.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumFunctionUtils {

	static WebDriver driver;
	
	static {driver = DriverUtils.getBrowser("firefox");}
	
	public static void enterText(WebElement locator, String text){
		
	}
	
	public static void click(WebElement locator){
			locator.click();
	}
	
	public static boolean isElementPresent(WebElement locator){
		return locator.isDisplayed();
	}
	
	public static void implicitWait(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static WebElement explicitWait(WebElement locator){
		WebElement dynamicElement = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.visibilityOfElementLocated((By) locator));
		
		return dynamicElement;
	}
	
	@SuppressWarnings("deprecation")
	public static WebElement fluentWait(WebElement locator){
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
				.withTimeout(30, TimeUnit.SECONDS) 			
				.pollingEvery(5, TimeUnit.SECONDS) 			
				.ignoring(NoSuchElementException.class);
		WebElement clickableElement = wait.until(ExpectedConditions.visibilityOf(locator));
		
		return clickableElement;
	}
	
	public void selectByValue(WebElement locator, String value){
		Select select = new Select(locator);
		select.selectByValue(value);
	}
	
	public void selectByIndex(WebElement locator, int index){
		Select select = new Select(locator);
		select.selectByIndex(index);
	}
	
	
}

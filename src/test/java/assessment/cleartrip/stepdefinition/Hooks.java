package assessment.cleartrip.stepdefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import assessment.cleartrip.utility.DataConfig;
import assessment.cleartrip.utility.DriverUtils;

public class Hooks {

	WebDriver driver;
	
	@Before
	public void beforeInHooks() throws IOException{
		DataConfig.prepareData();
		driver = DriverUtils.getBrowser("firefox");
		driver.get(DataConfig.url);
	}
	
	@After
	public void tearDown() throws IOException{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File("../ClearTripTest/Screenshots/screenshot.png"));
		driver.close();
	}
}

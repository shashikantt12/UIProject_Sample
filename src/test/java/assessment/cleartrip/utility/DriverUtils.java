package assessment.cleartrip.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverUtils {

	static WebDriver driver = null;
	public static WebDriver getBrowser(String browserName) {
 
		if(browserName.equalsIgnoreCase("Firefox")){
			if (driver == null) {
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//drivers//geckodriver.exe");
				driver = new FirefoxDriver();
			}
		} else if(browserName.equalsIgnoreCase("Chrome")) {
			if (driver == null) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
				driver = new ChromeDriver();
			}
		} else if(browserName.equalsIgnoreCase("IE")) {
			if (driver == null) {
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//drivers//IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
		}
		driver.manage().window().maximize();
		return driver;
	}
}

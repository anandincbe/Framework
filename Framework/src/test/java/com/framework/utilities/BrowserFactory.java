/**
 * 
 */
package com.framework.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author anandmule
 *
 */
public class BrowserFactory {

	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) {

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/anandmule/Anand_Workspace/Framework/Drivers/chromedriver");
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/anandmule/Anand_Workspace/Framework/Drivers/geckodriver");
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("IE")) {

		} 
		else {
			System.out.println("We do not support this type of Browser");
		}
		
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
/*		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/		return driver;

	}
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}
	
	public static void waitForJStoLoad(WebDriver driver) {
		int counter =0;
	    //WebDriverWait wait = new WebDriverWait(driver, 30);
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    while(! js.executeScript("return document.readyState").toString().equals("complete")) {
	    	counter++;
	    	try {
				Thread.sleep(1000);
				System.out.println("Waiting for page to load   "+ js.executeScript("return document.readyState").toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	if(counter>10) {
	    		break;
	    	}
	    }
	    
	}
	
	
}

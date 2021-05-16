/**
 * 
 */
package com.framework.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.framework.utilities.*;
import com.framework.utilities.BrowserFactory;
/**
 * @author anandmule
 *
 */
public class LoginPage extends BaseClass {
	WebDriver driver;
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	
	@FindBy(id="username") WebElement uname;
	@FindBy(id="password") WebElement upassword;
	@FindBy(xpath="//input[@value='Log In']") WebElement loginButton;
	@FindBy(xpath="//a[@id='headerUserName']/img[2]") WebElement logoutDropDown;
	@FindBy(id="logoutLink") WebElement logout;
	
	public void loginToConnection(String username , String password) {
		highLightElement(driver, uname);
		uname.sendKeys(username);
		highLightElement(driver, upassword);
		upassword.sendKeys(password);
		loginButton.click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//BrowserFactory.waitForJStoLoad(driver);
		System.out.println("Login sucessfully");
	}
	
	public void logoutToConnection() {
		highLightElement(driver, logoutDropDown);
		logoutDropDown.click();
		try 
		{
		Thread.sleep(1000);
		} 
		catch (InterruptedException e) {

		System.out.println(e.getMessage());
		} 
		if(logoutDropDown.isDisplayed()) {
			highLightElement(driver, logout);
			logout.click();
			Reporter.log("Logout sucessfully");
		}else 
			logger.error("Logout button nit visible");
		
		try 
		{
		Thread.sleep(1000);
		} 
		catch (InterruptedException e) {

		System.out.println(e.getMessage());
		} 
	}
	
	public  void highLightElement(WebDriver driver, WebElement element)
	{
	JavascriptExecutor js=(JavascriptExecutor)driver; 

	js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

	try 
	{
	Thread.sleep(500);
	} 
	catch (InterruptedException e) {

	System.out.println(e.getMessage());
	} 

	//js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 

	}
}

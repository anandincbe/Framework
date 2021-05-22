/**
 * 
 */
package com.framework.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.framework.pages.BaseClass;
import com.framework.pages.LoginPage;
import com.framework.utilities.BrowserFactory;
import com.framework.utilities.ExcelDataProvider;

/**
 * @author anandmule
 *
 */
public class LoginToConn extends BaseClass {
	
	@Test(enabled=true)
	public void LoginToConn()  {
		logger = report.createTest("Login to connections");
		Reporter.log(dataProvide.getStringData("Login", 0, 0));
		LoginPage loginPage = new LoginPage(driver);
		logger.info("Starting to login to connection");
		loginPage.loginToConnection(dataProvide.getStringData(0, 0, 0),
				dataProvide.getStringData(0, 0, 1));
		logger.pass("Login successfully");
		Reporter.log("Login successfully");
		loginPage.logoutToConnection();
	}
	@Test(enabled=true)
	public void LoginToConn2()  {
		logger = report.createTest("Login to LoginToConn2");
		System.out.println(dataProvide.getStringData("Login", 0, 0));		
		LoginPage loginPage = new LoginPage(driver);
		logger.info("Starting to login to connection2");
		loginPage.loginToConnection(dataProvide.getStringData(0, 0, 0),
				dataProvide.getStringData(0, 0, 1));
		logger.pass("Login successfully");
		loginPage.logoutToConnection();
	
	}
}


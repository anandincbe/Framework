/**
 * 
 */
package com.framework.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.beust.jcommander.Parameter;
import com.framework.utilities.BrowserFactory;
import com.framework.utilities.ConfigDataProvider;
import com.framework.utilities.ExcelDataProvider;
import com.framework.utilities.Helper;

/**
 * @author anandmule
 *
 */
public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider dataProvide;
	public ConfigDataProvider configDataProvider;
	public Helper helper;
	public ExtentReports report;
	public ExtentTest logger;
	
	
	@BeforeSuite
	public void setupSuit() {
		 dataProvide = new ExcelDataProvider();
		 configDataProvider = new ConfigDataProvider();
		 ExtentHtmlReporter extend = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/TestConnections"+
				 					Helper.getCurrentDataTime()+".html"));
		 report = new ExtentReports();
		 report.attachReporter(extend);
		 
	}
	
	@Parameters({"getBrowserName","getAppURL"})
	@BeforeClass
	public void setup(String getBrowserName,String getAppURL) {
		//driver =BrowserFactory.startApplication(driver, configDataProvider.getBrowser(), configDataProvider.getTestUrl());
		
		driver =BrowserFactory.startApplication(driver,getBrowserName , getAppURL);
		Reporter.log("Login on browser  "+getBrowserName +"with app url "+ getAppURL);
	}
	

	
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		if(result.getStatus()== ITestResult.FAILURE) {
			Helper.captureScreenshot(driver);
			logger.fail("Test failed ", 
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}else if(result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Test Passed ", 
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}else if(result.getStatus()==ITestResult.SKIP){
			logger.skip("Skkiped     ");
		}
		report.flush();
	}

}

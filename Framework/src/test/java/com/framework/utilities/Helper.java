/**
 * 
 */
package com.framework.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import com.framework.pages.BaseClass;

/**
 * @author anandmule
 *
 */
public class Helper {
	
	
	
	public static String captureScreenshot(WebDriver driver) {
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir")+"/Screenshots/Login"+ getCurrentDataTime() + ".jpeg";
		try {
			FileHandler.copy(src, new File("./Screenshots/Login"+ getCurrentDataTime() + ".jpeg"));
			System.out.println("Screenshot taken successfully");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Fail"+e.getMessage());
		}
		return screenshotPath;
	}
	
	public static String getCurrentDataTime() {
		Date currentDate = new Date();
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_ss");
		return customFormat.format(currentDate);
	}
	
	
	
	
}

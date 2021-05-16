/**
 * 
 */
package com.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author anandmule
 *
 */
public class ConfigDataProvider {
	Properties pro;
	public ConfigDataProvider() {
		try {
			FileInputStream fis = new FileInputStream("./Config/config.properties");
			pro = new Properties();
			pro.load(fis);
		}  catch (Exception e) {
			System.out.println("Unable to load config file "+ e.getMessage());
		}
	}
	public String getDataFromConfigFile(String key) {
		return pro.getProperty(key);
	}
	
	
	public String getBrowser() {
		return pro.getProperty("Browser");
	}
	public String getTestUrl() {
		return pro.getProperty("qaUrl");
	}

}

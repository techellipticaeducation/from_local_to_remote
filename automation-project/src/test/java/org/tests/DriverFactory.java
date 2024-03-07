package org.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	
	
	public static void setup() {
		String chromeDriverPath = 
				"C:\\Users\\Vaibhav\\testometer_nov_23_java_wd\\automation-project\\drivers\\chrome\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromeDriverPath);
	}
	
	public static WebDriver getDriver(String browser) {
		WebDriver driver = null;
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
			driver.get("https://saucedemo.com");
		}
		
		return driver;
	}
	
}

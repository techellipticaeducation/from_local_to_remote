package org.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSuite {

	public static void main(String[] args) {
		// Set up Selenium
		// Selenum IDE - Legacy / mozilla 
		// selenium RC - Legacy / Pure Js level
		// Selenium Web driver - selenium3, selenium4
		// Selenium Grid - distributed system
		// Master Hub
		// Slave  node

		//Script (IDE)- java ->  mediator -> Browser
		// Chrome 

		// Downloaded Chrome driver

		String chromeDriverPath = "C:\\Users\\Vaibhav\\testometer_nov_23_java_wd\\automation-project\\drivers\\chrome\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromeDriverPath);


		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		String title = driver.getTitle();
		System.out.println(title);
//		String pageSource = driver.getPageSource();
//		System.out.println(pageSource);
		
		
		driver.close(); // kill active tab
		driver.quit(); // entire session
		
		
		
	}

}

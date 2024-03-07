package org.tests;

import java.io.File;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginScenario {

	public static void main(String[] args) {
		TestCaseBase.setup();


		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		
		// Locators
		// 8 locators, id, name, className, tagname, xpath and css-selector
		// 	linktext and partial linktext
		
		
//		By uname = By.id("user-name"); // by ref
//		WebElement ebElm = driver.findElement(uname); // find element
//		ebElm.sendKeys("standard_user"); // action
		
		takeScreen(driver,"screen1");
		driver.findElement(By.name("user-name")).sendKeys("standard_user");
		takeScreen(driver,"screen2");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		takeScreen(driver,"screen3");
		driver.findElement(By.name("login-button")).click();
		takeScreen(driver,"screen4");
		String currentURL = driver.getCurrentUrl();
		if(currentURL.contains("inventory.html")) {
			System.out.println("testcase pass");
		}else {
			System.err.println("testcase fail");
		}
		takeScreen(driver,"screen5");
		// Screenshots
		// Javascript Executor
		// Action Classes
		
		// Double
		// right click
		// element hover
		// mouse move 
		// drag and drop
		
		Actions ac1 = new Actions(driver);
		WebElement facebookelm = driver.findElement(By.linkText("Facebook"));
		WebElement linkdinelm1 = driver.findElement(By.linkText("LinkedIn"));
		
		
		
//		ac1.moveToElement(elm).contextClick();
//		ac1.build().perform();
		
		((JavascriptExecutor)driver).executeScript("arguments[1].click();",linkdinelm1, facebookelm);
		
		// TimeOuts in selenium
		
		// 1 - Page Load TimeOut (until your is not loaded)
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		// 2 - Implicit Wait (Global Wait)
		
		// 3 - Explicit Wait (Element based wait)
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Facebook")));
		
		
//		element - locate - 30th sec (application)
		
		
		// Enter = Return 
		// right = context
		
		
		
//		Window handles
		
//		Select cat_dropdown = new Select(driver.findElement(By.className("product_sort_container")));
//		cat_dropdown.selectByVisibleText("Name (Z to A)");
//		cat_dropdown.selectByValue("hilo");
//		cat_dropdown.selectByIndex(2);
		
	}
	
	
	public static void takeScreen(WebDriver driver, String screenshotName) {
		try {
			
			String timeStamp= String.valueOf(new Date().getTime());
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, 
				new File("C:\\Users\\Vaibhav\\testometer_nov_23_java_wd\\automation-project\\screenshot\\"
			+screenshotName+timeStamp+".png"));
			
		}catch(Exception e) {
			
		}
	}
	
	
}

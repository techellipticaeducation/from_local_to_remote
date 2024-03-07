package org.tests;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleDemo {
	public static void main(String[] args) {
		TestCaseBase.setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/Vaibhav/testometer_nov_23_java_wd/automation-project/html/test1.html");
		driver.findElement(By.id("rollnumber_for_12th")).sendKeys("1234");
		System.out.println("----------------Before tab Open--------------------");
		Set<String> ls = driver.getWindowHandles(); // LinkedHashSet
		for(String handle : driver.getWindowHandles()) {
			System.out.println(handle);
		}	
		driver.findElement(By.linkText("Click to view 10th Result")).click();
		System.out.println("----------------After tab Open--------------------");
		for(String handle : driver.getWindowHandles()) {
			System.out.println(handle);
			driver.switchTo().window(handle);
		}
		driver.findElement(By.id("rollnumber_for_10th")).sendKeys("4567");
		System.out.println("Current Window Active Handle " + driver.getWindowHandle());
	}
}

package org.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTestCase {
	public static void main(String[] args) {
		TestCaseBase.setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.linkText("About")).click();
		driver.navigate().back();
		driver.navigate().forward();

	}
}

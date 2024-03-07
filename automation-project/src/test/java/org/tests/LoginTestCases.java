package org.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class LoginTestCases extends TestCaseBase{
	WebDriver driver;
	LoginModule module ;
	@BeforeMethod
	public void setupTest() {
		setup();
		driver = new ChromeDriver();
		driver.get("https://saucedemo.com");
		
		module = new LoginModule(driver);
	}
	
	@AfterMethod
	public void teadDowntest() {
		driver.quit();
	}
	
	@Test(invocationCount = 4)
	public void test_successful_login() {
		module.login("standard_user", "secret_sauce");
		Assert.assertTrue(driver.getCurrentUrl().contains("xyz.html"));
	}
	
	@DataProvider(name="logindata")
	public Object[][] getTestData(){
		Object[][] data = {
				{"abcd","secret_sauce","Epic sadface: Username and password do not match any user in this service"},
				{"standard_user","abcd","Epic sadface: Username and password do not match any user in this service"},
				{"standard_user","","Epic sadface: Password asdadsf is required"},
				{"","secret_sauce","Epic sadface: Username is required"}
			};
		return data;
	}
	
	@Test(dataProvider = "logindata" ,retryAnalyzer = RetryMyFramework.class)
	public void test_validate_Login(String username, String password, String errorMsg) {
		module.login(username, password);
		Assert.assertEquals(driver.findElement(LoginPageObject.lbl_error).getText(),errorMsg);
	}
	
}

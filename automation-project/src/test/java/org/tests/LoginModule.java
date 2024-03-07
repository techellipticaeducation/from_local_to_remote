package org.tests;

import org.openqa.selenium.WebDriver;

public class LoginModule {

	WebDriver driver;
	public LoginModule(WebDriver driver){
		this.driver = driver;
	}

	public void login(String username, String password) {
		enterUserName(username);
		enterPassword(password);
		clickLoginButton();
	}

	public void enterUserName(String username) {
		driver.findElement(LoginPageObject.txt_username).sendKeys(username);
	}
	public void enterPassword(String password) {
		driver.findElement(LoginPageObject.txt_password).sendKeys(password);
	}

	public void clickLoginButton() {
		driver.findElement(LoginPageObject.btn_login).click();
	}

}

package org.tests;

import org.openqa.selenium.By;

public class LoginPageObject {
	static By txt_username = By.id("user-name");
	static By txt_password = By.id("password");
	static By btn_login = By.id("login-button");
	
	public static By lbl_error = By.xpath("//h3[@data-test='error']");
}

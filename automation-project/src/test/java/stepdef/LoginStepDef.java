package stepdef;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.tests.DriverFactory;
import org.tests.LoginModule;
import org.tests.LoginPageObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef{
	WebDriver driver;
	
	@Given("i open {string}")
	public void i_open(String browser) {
		DriverFactory.setup();
		driver = DriverFactory.getDriver(browser);
	}
	@When("i open url {string}")
	public void i_open_url(String string) {
	    driver.get(string);
	}
	@When("i enter username {string}")
	public void i_enter_username(String string) {
		LoginModule module = new LoginModule(driver);
		module.enterUserName(string);
		
	}
	@When("i enter password {string}")
	public void i_enter_password(String string) {
		LoginModule module = new LoginModule(driver);
		module.enterPassword(string);
	}
	
	@When("i login with {string} and {string}")
	public void i_login_with_and(String string, String string2) {
		LoginModule module = new LoginModule(driver);
		module.login(string,string2);
	}
	
	
	@When("i click on login button")
	public void i_click_on_login_button() {
		LoginModule module = new LoginModule(driver);
		module.clickLoginButton();
	}
	
	@Then("i verify dashborad title as {string}")
	public void i_verify_dashborad_title_as(String string) {
		Assert.assertTrue(driver.getCurrentUrl().contains(string));
	}
	
	@Then("i verify error msg as {string}")
	public void i_verify_error_msg_as(String string) {
		Assert.assertEquals(driver.findElement(LoginPageObject.lbl_error).getText(),string);
	}
}

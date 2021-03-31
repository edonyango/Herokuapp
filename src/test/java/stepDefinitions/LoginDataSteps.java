package stepDefinitions;

import org.junit.runner.RunWith;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pageObject.LoginPage;
import setup.Base;

@RunWith(Cucumber.class)
public class LoginDataSteps extends Base {

	@When("^the user logs in with (.+) and password (.+)$")
	public void the_user_logs_in_with_and_password(String username, String password) throws Throwable {
		LoginPage loginPg = new LoginPage(driver);
		loginPg.userName().sendKeys(username);
		loginPg.passWord().sendKeys(password);
		loginPg.loginButton().click();
	}

	@And("^error alert (.+)$")
	public void error_alert(String alertmsg) throws Throwable {
		LoginPage loginPg = new LoginPage(driver);
		String actualAlert = loginPg.alertMessage().getText();
		boolean messageAlrt = actualAlert.contains(alertmsg);
		Assert.assertTrue(messageAlrt);
	}

}

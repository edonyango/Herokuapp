package stepDefinitions;

import org.junit.runner.RunWith;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pageObject.HomePage;
import pageObject.LoginPage;
import setup.Base;

@RunWith(Cucumber.class)
public class LoginSteps extends Base{
	
	@Given("^Initialize browser with \"([^\"]*)\"$")
	public void initialize_browser_with(String browserName) throws Throwable {
	    driver = initializeDriver();
	}

	@Given("^User navigates to the Internet landing page$")
	public void user_navigates_to_the_Internet_landing_page() throws Throwable {
		String baseUrl = prop.getProperty("webURL");
		driver.get(baseUrl);
	}

	@When("^User clicks on the Form Authentication menu$")
	public void user_clicks_on_the_Form_Authentication_menu() throws Throwable {
		HomePage homePg = new HomePage(driver);		
		homePg.loginForm().click();
		
	}

	@Then("^The login page is populated$")
	public void the_login_page_is_populated() throws Throwable {
		LoginPage loginPg = new LoginPage(driver);		
		String header = loginPg.loginHeader().getText();
		Assert.assertEquals(header, "Login Page");
		
	}

	@Given("^the user is on the internet login page$")
	public void the_user_is_on_the_internet_login_page() throws Throwable {
	    driver = initializeDriver();
	    String baseUrl = prop.getProperty("webURL");
	    driver.get(baseUrl);
	    HomePage homePg = new HomePage(driver);
	    homePg.loginForm().click();
	}

	@When("^the user logs in using \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void the_user_logs_in_using_and_password(String userName, String passWord) throws Throwable {
	    LoginPage loginPg = new LoginPage(driver);
	    loginPg.userName().sendKeys(userName);
	    loginPg.passWord().sendKeys(passWord);
	    loginPg.loginButton().click();
	}

	@Then("^the secure area page is populated$")
	public void the_secure_area_page_is_populated() throws Throwable {
	    LoginPage loginPg = new LoginPage(driver);
	    String header = loginPg.loginHeader().getText();
	    Assert.assertEquals(header, "Secure Area");
	}

	@Then("^login alert is \"([^\"]*)\"$")
	public void login_alert_is(String alertMsg) throws Throwable {
	    LoginPage loginPg = new LoginPage(driver);
	    String actualAlert = loginPg.alertMessage().getText();
	    boolean messageAlrt = actualAlert.contains(alertMsg);
	    Assert.assertTrue(messageAlrt);
	}

	@Then("^the login button is active$")
	public void the_login_button_is_active() throws Throwable {
	    LoginPage loginPg = new LoginPage(driver);
	    boolean bool = loginPg.loginButton().isEnabled();
	    Assert.assertTrue(bool);
	}
	
	@And("^close browser$")
    public void close_browser() throws Throwable {
        driver.quit();
    }

}

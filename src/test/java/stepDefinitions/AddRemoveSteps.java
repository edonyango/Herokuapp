package stepDefinitions;

import static org.testng.Assert.assertTrue;

import org.junit.runner.RunWith;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pageObject.AddRemovePage;
import pageObject.HomePage;
import setup.Base;

@RunWith(Cucumber.class)
public class AddRemoveSteps extends Base {
	@Given("^the user is on the Internet home page$")
    public void the_user_is_on_the_internet_home_page() throws Throwable {
		driver = initializeDriver();
		String baseUrl = prop.getProperty("webURL");
		driver.get(baseUrl);
    }

    @When("^the user clicks on the Add button$")
    public void the_user_clicks_on_the_add_button() throws Throwable {
    	AddRemovePage addPg = new AddRemovePage(driver);			
		addPg.addBtn().click();
    }

    @Then("^a new button is added on the page$")
    public void a_new_button_is_added_on_the_page() throws Throwable {
    	AddRemovePage addPg = new AddRemovePage(driver);
    	boolean isPresent = addPg.deleteBtns().size() > 0;
		assertTrue(isPresent);
    }

    @Then("^the new button is removed from the page$")
    public void the_new_button_is_removed_from_the_page() throws Throwable {
    	AddRemovePage addPg = new AddRemovePage(driver);
    	boolean isNotPresent = !(addPg.deleteBtns().size() > 0);
		assertTrue(isNotPresent);
    }

    @And("^the user clicks on AddRemove elements menu$")
    public void the_user_clicks_on_addremove_elements_menu() throws Throwable {
    	HomePage landingPg = new HomePage(driver);		
		landingPg.addElement().click();	
    }

    @And("^then clicks on Remove button$")
    public void then_clicks_on_remove_button() throws Throwable {
		AddRemovePage addPg = new AddRemovePage(driver);			
		addPg.deleteBtn().click();
		
    }
}

package elementSuite;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObject.DynamicContentPage;
import pageObject.HomePage;
import resources.Utilities;
import setup.Base;

public class DynamicContentTest extends Base {
	
	@AfterTest
	public void browserClose() throws IOException {
		driver = initializeDriver();
		driver.close();
	}
	
	@Test
	public void removeCheckBox() throws IOException, InterruptedException {
		driver = initializeDriver();
		Utilities util = new Utilities(driver);
		HomePage homePg = new HomePage(driver);
		DynamicContentPage dynamicPg = new DynamicContentPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		String baseUrl = util.fetchProperty("webURL");
		driver.get(baseUrl);
		homePg.dynamicControls().click();
		dynamicPg.checkBox().click();
		dynamicPg.removeButton().click();
		wait.until(ExpectedConditions.visibilityOf(dynamicPg.message()));
		String message = dynamicPg.message().getText();
		assertEquals(message, "It's gone!");
	}
	
	@Test
	public void addCheckBox() throws IOException {
		driver = initializeDriver();
		Utilities util = new Utilities(driver);
		HomePage homePg = new HomePage(driver);
		DynamicContentPage dynamicPg = new DynamicContentPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		String baseUrl = util.fetchProperty("webURL");
		driver.get(baseUrl);
		homePg.dynamicControls().click();
		dynamicPg.checkBox().click();
		dynamicPg.removeButton().click();
		wait.until(ExpectedConditions.visibilityOf(dynamicPg.message()));
		dynamicPg.addButton().click();
		wait.until(ExpectedConditions.visibilityOf(dynamicPg.message()));
		String message = dynamicPg.message().getText();
		assertEquals(message, "It's back!");
	}
	
	@Test
	public void enableInputField() throws IOException {
		driver = initializeDriver();
		Utilities util = new Utilities(driver);
		HomePage homePg = new HomePage(driver);
		DynamicContentPage dynamicPg = new DynamicContentPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		String baseUrl = util.fetchProperty("webURL");
		driver.get(baseUrl);
		homePg.dynamicControls().click();
		dynamicPg.enableButton().click();
		wait.until(ExpectedConditions.visibilityOf(dynamicPg.message()));
		boolean inpitFieldEnabled = dynamicPg.inputField().isEnabled();
		assertTrue(inpitFieldEnabled);
	}
	
	@Test
	public void disableInputField() throws IOException {
		driver = initializeDriver();
		Utilities util = new Utilities(driver);
		HomePage homePg = new HomePage(driver);
		DynamicContentPage dynamicPg = new DynamicContentPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		String baseUrl = util.fetchProperty("webURL");
		driver.get(baseUrl);
		homePg.dynamicControls().click();
		dynamicPg.enableButton().click();
		wait.until(ExpectedConditions.visibilityOf(dynamicPg.message()));
		dynamicPg.disableButton().click();
		wait.until(ExpectedConditions.visibilityOf(dynamicPg.message()));
		boolean inputFieldDisabled = dynamicPg.inputField().isEnabled();
		assertFalse(inputFieldDisabled);
	}

}

package elementSuite;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.DynamicContentPage;
import pageObject.HomePage;
import setup.Base;

public class DynamicContentTest extends Base {
	
	@BeforeMethod
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver();
		String baseUrl = prop.getProperty("webURL");
		driver.get(baseUrl);
	}	
	
	@Test
	public void removeCheckBox() throws IOException, InterruptedException {		
		HomePage homePg = new HomePage(driver);
		DynamicContentPage dynamicPg = new DynamicContentPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 5);		
		homePg.dynamicControls().click();
		dynamicPg.checkBox().click();
		dynamicPg.removeButton().click();
		wait.until(ExpectedConditions.visibilityOf(dynamicPg.message()));
		String message = dynamicPg.message().getText();
		assertEquals(message, "It's gone!");
	}
	
	@Test
	public void addCheckBox() throws IOException {		
		HomePage homePg = new HomePage(driver);
		DynamicContentPage dynamicPg = new DynamicContentPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 5);		
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
		HomePage homePg = new HomePage(driver);
		DynamicContentPage dynamicPg = new DynamicContentPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 5);		
		homePg.dynamicControls().click();
		dynamicPg.enableButton().click();
		wait.until(ExpectedConditions.visibilityOf(dynamicPg.message()));
		boolean inpitFieldEnabled = dynamicPg.inputField().isEnabled();
		assertTrue(inpitFieldEnabled);
	}
	
	@Test
	public void disableInputField() throws IOException {		
		HomePage homePg = new HomePage(driver);
		DynamicContentPage dynamicPg = new DynamicContentPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 5);		
		homePg.dynamicControls().click();
		dynamicPg.enableButton().click();
		wait.until(ExpectedConditions.visibilityOf(dynamicPg.message()));
		dynamicPg.disableButton().click();
		wait.until(ExpectedConditions.visibilityOf(dynamicPg.message()));
		boolean inputFieldDisabled = dynamicPg.inputField().isEnabled();
		assertFalse(inputFieldDisabled);
	}
	
	@AfterMethod
	public void browserClose() throws IOException {
		driver = initializeDriver();
		driver.close();
	}

}

package elementSuite;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageObject.DynamicContentPage;
import pageObject.HomePage;
import resources.Utilities;
import setup.Base;

public class DynamicContent extends Base {
	
	@Test
	public void removeCheckBox() throws IOException, InterruptedException {
		setProp();		
		WebDriver driver = new ChromeDriver();
		Utilities util = new Utilities(driver);
		HomePage homePg = new HomePage(driver);
		DynamicContentPage dynamicPg = new DynamicContentPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		String url = util.fetchProperty("webURL");
		driver.get(url);
		homePg.dynamicControls().click();
		dynamicPg.checkBox().click();
		dynamicPg.removeButton().click();
		wait.until(ExpectedConditions.visibilityOf(dynamicPg.message()));
		String message = dynamicPg.message().getText();
		assertEquals(message, "It's gone!");
		driver.close();
	}
	
	@Test
	public void addCheckBox() throws IOException {
		setProp();		
		WebDriver driver = new ChromeDriver();
		Utilities util = new Utilities(driver);
		HomePage homePg = new HomePage(driver);
		DynamicContentPage dynamicPg = new DynamicContentPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		String url = util.fetchProperty("webURL");
		driver.get(url);
		homePg.dynamicControls().click();
		dynamicPg.checkBox().click();
		dynamicPg.removeButton().click();
		wait.until(ExpectedConditions.visibilityOf(dynamicPg.message()));
		dynamicPg.addButton().click();
		wait.until(ExpectedConditions.visibilityOf(dynamicPg.message()));
		String message = dynamicPg.message().getText();
		assertEquals(message, "It's back!");
		driver.close();
	}
	
	@SuppressWarnings("restriction")
	@Test
	public void enableInputField() throws IOException {
		setProp();		
		WebDriver driver = new ChromeDriver();
		Utilities util = new Utilities(driver);
		HomePage homePg = new HomePage(driver);
		DynamicContentPage dynamicPg = new DynamicContentPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		String url = util.fetchProperty("webURL");
		driver.get(url);
		homePg.dynamicControls().click();
		dynamicPg.enableButton().click();
		wait.until(ExpectedConditions.visibilityOf(dynamicPg.message()));
		boolean inpitFieldEnabled = dynamicPg.inputField().isEnabled();
		assertTrue(inpitFieldEnabled);
		driver.close();
	}
	
	@SuppressWarnings("restriction")
	@Test
	public void disableInputField() throws IOException {
		setProp();		
		WebDriver driver = new ChromeDriver();
		Utilities util = new Utilities(driver);
		HomePage homePg = new HomePage(driver);
		DynamicContentPage dynamicPg = new DynamicContentPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		String url = util.fetchProperty("webURL");
		driver.get(url);
		homePg.dynamicControls().click();
		dynamicPg.enableButton().click();
		wait.until(ExpectedConditions.visibilityOf(dynamicPg.message()));
		dynamicPg.disableButton().click();
		wait.until(ExpectedConditions.visibilityOf(dynamicPg.message()));
		boolean inputFieldDisabled = dynamicPg.inputField().isEnabled();
		assertFalse(inputFieldDisabled);
		driver.close();
	}

}

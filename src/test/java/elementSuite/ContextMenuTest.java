package elementSuite;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.ContextMenuPage;
import pageObject.HomePage;
import resources.Utilities;
import setup.Base;

public class ContextMenuTest extends Base {

	@BeforeMethod
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver();
		String baseUrl = prop.getProperty("webURL");
		driver.get(baseUrl);
	}
	
	@Test
	public void contextClick() throws IOException, InterruptedException {		
		HomePage homePg = new HomePage(driver);
		ContextMenuPage contextPg = new ContextMenuPage(driver);
		Actions action = new Actions(driver);
		homePg.contexMenu().click();
		WebElement move = contextPg.contextMenu();
		action.moveToElement(move).contextClick().build().perform();
		String alertMsg = driver.switchTo().alert().getText();
		assertEquals(alertMsg, "You selected a context menu");
		driver.switchTo().alert().dismiss();
	}

	@Test
	public void alert() throws IOException {		
		Utilities util = new Utilities(driver);
		HomePage homePg = new HomePage(driver);
		ContextMenuPage contextPg = new ContextMenuPage(driver);
		Actions action = new Actions(driver);		
		homePg.contexMenu().click();
		WebElement move = contextPg.contextMenu();
		action.moveToElement(move).contextClick().build().perform();
		driver.switchTo().alert().dismiss();
		assertFalse(util.isAlertPresent(driver));
	}

	@AfterMethod
	public void browserClose() throws IOException {
		driver.close();
	}
	
	@AfterTest
	public void killDriverObject() {
		driver=null;
	}	

}

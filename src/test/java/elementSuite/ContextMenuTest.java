package elementSuite;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObject.ContextMenuPage;
import pageObject.HomePage;
import resources.Utilities;
import setup.Base;

public class ContextMenuTest extends Base {
	
	@AfterTest
	public void browserClose() throws IOException {
		driver = initializeDriver();
		driver.close();
	}

	@Test
	public void contextClick() throws IOException, InterruptedException {
		driver = initializeDriver();
		Utilities util = new Utilities(driver);
		HomePage homePg = new HomePage(driver);
		ContextMenuPage contextPg = new ContextMenuPage(driver);
		Actions action = new Actions(driver);
		String baseUrl = util.fetchProperty("webURL");
		driver.get(baseUrl);
		homePg.contexMenu().click();
		WebElement move = contextPg.contextMenu();
		action.moveToElement(move).contextClick().build().perform();
		String alertMsg = driver.switchTo().alert().getText();
		assertEquals(alertMsg, "You selected a context menu");
		driver.switchTo().alert().dismiss();
	}

	@Test
	public void alert() throws IOException {
		driver = initializeDriver();
		Utilities util = new Utilities(driver);
		HomePage homePg = new HomePage(driver);
		ContextMenuPage contextPg = new ContextMenuPage(driver);
		Actions action = new Actions(driver);
		String baseUrl = util.fetchProperty("webURL");
		driver.get(baseUrl);
		homePg.contexMenu().click();
		WebElement move = contextPg.contextMenu();
		action.moveToElement(move).contextClick().build().perform();
		driver.switchTo().alert().dismiss();
		assertFalse(util.isAlertPresent(driver));
	}
	
}

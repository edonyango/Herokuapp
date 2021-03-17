package elementSuite;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObject.AddRemovePage;
import pageObject.HomePage;
import resources.Utilities;
import setup.Base;

public class AddRemoveTest extends Base {

	@AfterTest
	public void browserClose() {
		WebDriver driver = driver();
		driver.close();
	}
	
	@Test
	public void inclusion() throws IOException {
		setProp();		
		WebDriver driver = driver();
		Utilities util = new Utilities(driver);
		HomePage landingPg = new HomePage(driver);
		AddRemovePage addPg = new AddRemovePage(driver);
		String url = util.fetchProperty("webURL");
		driver.get(url);		
		landingPg.addElement().click();		
		addPg.addBtn().click();
		boolean isPresent = addPg.deleteBtns().size() > 0;
		assertTrue(isPresent);
		
	}

	@Test
	public void exclusion() throws IOException {
		setProp();		
		WebDriver driver = driver();
		Utilities util = new Utilities(driver);
		HomePage landingPg = new HomePage(driver);
		AddRemovePage addPg = new AddRemovePage(driver);
		String url = util.fetchProperty("webURL");
		driver.get(url);		
		landingPg.addElement().click();		
		addPg.addBtn().click();
		addPg.deleteBtn().click();
		boolean isNotPresent = !(addPg.deleteBtns().size() > 0);
		assertTrue(isNotPresent);
	
	}

}

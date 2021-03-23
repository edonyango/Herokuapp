package elementSuite;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.AddRemovePage;
import pageObject.HomePage;
import setup.Base;

public class AddRemoveTest extends Base {

	@BeforeMethod
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver();
		String baseUrl = prop.getProperty("webURL");
		driver.get(baseUrl);
	}
	
	@Test
	public void inclusion() throws IOException {		
		HomePage landingPg = new HomePage(driver);
		AddRemovePage addPg = new AddRemovePage(driver);			
		landingPg.addElement().click();		
		addPg.addBtn().click();
		boolean isPresent = addPg.deleteBtns().size() > 0;
		assertTrue(isPresent);
	}

	@Test
	public void exclusion() throws IOException {		
		HomePage landingPg = new HomePage(driver);
		AddRemovePage addPg = new AddRemovePage(driver);			
		landingPg.addElement().click();		
		addPg.addBtn().click();
		addPg.deleteBtn().click();
		boolean isNotPresent = !(addPg.deleteBtns().size() > 0);
		assertTrue(isNotPresent);
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

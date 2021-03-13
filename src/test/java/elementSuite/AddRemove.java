package elementSuite;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pageObject.AddRemovePage;
import pageObject.HomePage;
import resources.Utilities;
import setup.Base;

public class AddRemove extends Base {

	@Test
	public void inclusion() throws IOException {
		setProp();		
		WebDriver driver = new ChromeDriver();
		Utilities util = new Utilities(driver);
		HomePage landingPg = new HomePage(driver);
		AddRemovePage addPg = new AddRemovePage(driver);
		String url = util.fetchProperty("webURL");
		driver.get(url);		
		landingPg.addElement().click();		
		addPg.addBtn().click();
		boolean isPresent = addPg.deleteBtns().size() > 0;
		assertTrue(isPresent);
		driver.close();
	}

	@Test
	public void exclusion() throws IOException {
		setProp();		
		WebDriver driver = new ChromeDriver();
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
		driver.close();
	}

}

package elementSuite;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import resources.Utilities;
import setup.Base;

public class LoginTest extends Base {

	@AfterTest
	public void browserClose() throws IOException {
		driver = initializeDriver();
		driver.close();
	}
	
	@Test
	public void loginFullCreds() throws IOException {
		driver = initializeDriver();
		Utilities util = new Utilities(driver);
		HomePage homePg = new HomePage(driver);
		LoginPage loginPg = new LoginPage(driver);
		String baseUrl = util.fetchProperty("webURL");
		String userName = util.fetchProperty("userName");
		String passWord = util.fetchProperty("passWord");
		driver.get(baseUrl);
		homePg.loginForm().click();
		loginPg.userName().sendKeys(userName);
		loginPg.passWord().sendKeys(passWord);
		loginPg.loginButton().click();
		String loginMsg = loginPg.loginHeader().getText();
		assertEquals(loginMsg, "Secure Area");
	}

	
	@Test
	public void loginWrongPassword() throws IOException {
		driver = initializeDriver();
		Utilities util = new Utilities(driver);
		HomePage homePg = new HomePage(driver);
		LoginPage loginPg = new LoginPage(driver);
		String baseUrl = util.fetchProperty("webURL");
		String userName = util.fetchProperty("userName");
		String passWord = util.fetchProperty("passWord1");
		driver.get(baseUrl);
		homePg.loginForm().click();
		loginPg.userName().sendKeys(userName);
		loginPg.passWord().sendKeys(passWord);
		loginPg.loginButton().click();
		String loginMsg = loginPg.alertMessage().getText();
		boolean errorMessage = loginMsg.contains("Your password is invalid!");
		assertTrue(errorMessage);
	}

	@Test
	public void loginWrongUserName() throws IOException {
		driver = initializeDriver();
		Utilities util = new Utilities(driver);
		HomePage homePg = new HomePage(driver);
		LoginPage loginPg = new LoginPage(driver);
		String baseUrl = util.fetchProperty("webURL");
		String userName = util.fetchProperty("userName1");
		String passWord = util.fetchProperty("passWord");
		driver.get(baseUrl);
		homePg.loginForm().click();
		loginPg.userName().sendKeys(userName);
		loginPg.passWord().sendKeys(passWord);
		loginPg.loginButton().click();
		String loginMsg = loginPg.alertMessage().getText();
		boolean errorMessage = loginMsg.contains("Your username is invalid!");
		assertTrue(errorMessage);
	}

}

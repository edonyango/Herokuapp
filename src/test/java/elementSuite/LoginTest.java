package elementSuite;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import setup.Base;

public class LoginTest extends Base {
	
	@BeforeMethod
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver();
		String baseUrl = prop.getProperty("webURL");
		driver.get(baseUrl);
	}	
	
	@Test
	public void loginFullCreds() throws IOException {		
		HomePage homePg = new HomePage(driver);
		LoginPage loginPg = new LoginPage(driver);		
		String userName = prop.getProperty("userName");
		String passWord = prop.getProperty("passWord");		
		homePg.loginForm().click();
		loginPg.userName().sendKeys(userName);
		loginPg.passWord().sendKeys(passWord);
		loginPg.loginButton().click();
		String loginMsg = loginPg.loginHeader().getText();
		assertEquals(loginMsg, "Secure Area");
	}
	
	@Test
	public void loginWrongPassword() throws IOException {		
		HomePage homePg = new HomePage(driver);
		LoginPage loginPg = new LoginPage(driver);		
		String userName = prop.getProperty("userName");
		String passWord = prop.getProperty("passWord1");		
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
		HomePage homePg = new HomePage(driver);
		LoginPage loginPg = new LoginPage(driver);		
		String userName = prop.getProperty("userName1");
		String passWord = prop.getProperty("passWord");		
		homePg.loginForm().click();
		loginPg.userName().sendKeys(userName);
		loginPg.passWord().sendKeys(passWord);
		loginPg.loginButton().click();
		String loginMsg = loginPg.alertMessage().getText();
		boolean errorMessage = loginMsg.contains("Your username is invalid!");
		assertTrue(errorMessage);
	}
	
	@AfterMethod
	public void browserClose() throws IOException {
		driver = initializeDriver();
		driver.close();
	}

}

package elementSuite;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import resources.Utilities;
import setup.Base;

public class Login extends Base {

	@Test
	public void loginFullCreds() throws IOException {
		setProp();
		WebDriver driver = new ChromeDriver();
		Utilities util = new Utilities(driver);
		HomePage homePg = new HomePage(driver);
		LoginPage loginPg = new LoginPage(driver);
		String url = util.fetchProperty("webURL");
		String userName = util.fetchProperty("userName");
		String passWord = util.fetchProperty("passWord");
		driver.get(url);
		homePg.loginForm().click();
		loginPg.userName().sendKeys(userName);
		loginPg.passWord().sendKeys(passWord);
		loginPg.loginButton().click();
		String loginMsg = loginPg.loginHeader().getText();
		assertEquals(loginMsg, "Secure Area");
		driver.close();
	}

	@SuppressWarnings("restriction")
	@Test
	public void loginWrongPassword() throws IOException {
		setProp();
		WebDriver driver = new ChromeDriver();
		Utilities util = new Utilities(driver);
		HomePage homePg = new HomePage(driver);
		LoginPage loginPg = new LoginPage(driver);
		String url = util.fetchProperty("webURL");
		String userName = util.fetchProperty("userName");
		String passWord = util.fetchProperty("passWord1");
		driver.get(url);
		homePg.loginForm().click();
		loginPg.userName().sendKeys(userName);
		loginPg.passWord().sendKeys(passWord);
		loginPg.loginButton().click();
		String loginMsg = loginPg.alertMessage().getText();
		boolean errorMessage = loginMsg.contains("Your password is invalid!");
		assertTrue(errorMessage);
		driver.close();
	}

	@SuppressWarnings("restriction")
	@Test
	public void loginWrongUserName() throws IOException {
		setProp();
		WebDriver driver = new ChromeDriver();
		Utilities util = new Utilities(driver);
		HomePage homePg = new HomePage(driver);
		LoginPage loginPg = new LoginPage(driver);
		String url = util.fetchProperty("webURL");
		String userName = util.fetchProperty("userName1");
		String passWord = util.fetchProperty("passWord");
		driver.get(url);
		homePg.loginForm().click();
		loginPg.userName().sendKeys(userName);
		loginPg.passWord().sendKeys(passWord);
		loginPg.loginButton().click();
		String loginMsg = loginPg.alertMessage().getText();
		boolean errorMessage = loginMsg.contains("Your username is invalid!");
		assertTrue(errorMessage);
		driver.close();
	}

}

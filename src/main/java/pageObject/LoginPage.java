package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	WebElement user;
	
	@FindBy(id="password")
	WebElement passwrd;
	
	@FindBy(xpath="//button[@type='submit']/i")
	WebElement loginBtn;
	
	@FindBy(xpath="//i[contains(text(),'Logout')]")
	WebElement logoutBtn;
	
	@FindBy(xpath="//div[@class='example']/h2")
	WebElement loginTitle;
	
	@FindBy(id="flash")
	WebElement alertMsg;
	
	public WebElement userName() {
		return user;
	}
	
	public WebElement passWord() {
		return passwrd;
	}
	
	public WebElement loginButton() {
		return loginBtn;
	}
	
	public WebElement logOutButton() {
		return logoutBtn;
	}
	
	public WebElement loginHeader() {
		return loginTitle;
	}
	
	public WebElement alertMessage() {
		return alertMsg;
	}

}

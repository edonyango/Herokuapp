package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Add/Remove Elements')]")
	WebElement addRemove;
	
	@FindBy(xpath="//a[contains(text(),'Context Menu')]")
	WebElement context;
	
	@FindBy(xpath="//a[contains(text(),'Dynamic Controls')]")
	WebElement dynamic;
	
	public WebElement addElement() {
		return addRemove;
	}
	
	public WebElement contexMenu() {
		return context;
	}
	
	public WebElement dynamicControls() {
		return dynamic;
	}
}

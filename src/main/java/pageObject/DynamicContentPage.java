package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicContentPage {
	
	WebDriver driver;
	public DynamicContentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@label='blah']")
	WebElement checkBx;
	
	@FindBy(xpath="//button[contains(text(),'Remove')]")
	WebElement removeBtn;
	
	@FindBy(xpath="//button[contains(text(),'Add')]")
	WebElement addBtn;
	
	@FindBy(id="message")
	WebElement messageAction;
	
	@FindBy(xpath="//form[@id='input-example']/input")
	WebElement inputFld;
	
	@FindBy(xpath="//button[contains(text(),'Enable')]")
	WebElement enableBtn;
	
	@FindBy(xpath="//button[contains(text(),'Disable')]")
	WebElement disableBtn;
	
	public WebElement checkBox() {
		return checkBx;
	}
	
	public WebElement removeButton() {
		return removeBtn;
	}
	
	public WebElement addButton() {
		return addBtn;
	}
	
	public WebElement message () {
		return messageAction;
	}
	
	public WebElement inputField() {
		return inputFld;
	}
	
	public WebElement enableButton() {
		return enableBtn;
	}
	
	public WebElement disableButton() {
		return disableBtn;
	}

}

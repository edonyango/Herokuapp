package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRemovePage {
	
	WebDriver driver;
	public AddRemovePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//div[@class='example']/button")
	WebElement additionButton;
	
	@FindBy(xpath="//div[@id='elements']/button[1]")
	WebElement deletionButton;
	
	@FindBy(xpath ="//div[@id='elements']/button[1]")
	List<WebElement> deletionBtns;
	
	public WebElement addBtn() {
		return additionButton;
	}
	
	public WebElement deleteBtn() {
		return deletionButton;
	}
	
	public List<WebElement> deleteBtns(){
		return deletionBtns;
	}

}

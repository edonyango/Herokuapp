package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class Utilities {
	
	WebDriver driver;
	public Utilities(WebDriver driver) {
		this.driver = driver;
	}
	
	public String fetchProperty(String prop) throws IOException {
		FileInputStream loadProperties = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\setup\\global.properties");
		Properties projectProp = new Properties();
		projectProp.load(loadProperties);
		String propertyValue = (String) projectProp.getProperty(prop);		
		return propertyValue;
	}
	
	public boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

}

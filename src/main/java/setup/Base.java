package setup;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {

	public static void setProp() {
		String currentDir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", currentDir + "\\src\\chromedriver.exe");

	}

	public ChromeDriver driver () {
		ChromeOptions options = new ChromeOptions();		  
		options.addArguments("enable-automation");
		options.addArguments("--headless");		
		ChromeDriver chroDriver = new ChromeDriver(options);
		return chroDriver;
	}

}

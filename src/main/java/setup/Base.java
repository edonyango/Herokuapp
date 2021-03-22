package setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	public WebDriver driver;
	public WebDriver initializeDriver () throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new  FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\setup\\global.properties");
		prop.load(fis);
		
		String browserName=prop.getProperty("browser");
		String currentDir = System.getProperty("user.dir");
		if(browserName.equals("chrome")) {			
			System.setProperty("webdriver.chrome.driver", currentDir + "\\src\\chromedriver89.exe");			
			ChromeOptions options = new ChromeOptions();		  
			options.addArguments("enable-automation");
			options.addArguments("--headless");		
			driver = new ChromeDriver(options);
			
		} else if(browserName.contentEquals("firefox")) {
			System.setProperty("webdriver.gecko.driver", currentDir + "\\src\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("enable-automation");
			options.addArguments("--headless");
			driver = new FirefoxDriver(options);
			
		} else if (browserName.contentEquals("internetexplorer")) {
			System.setProperty("webdriver.ie.driver", currentDir + "\\src\\IEDriverServer.exe");			
			driver = new InternetExplorerDriver();
			
		}		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}

}

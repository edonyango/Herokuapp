package setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Base {
	public static WebDriver driver;
	// public static RemoteWebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\setup\\global.properties");
		prop.load(fis);

		String browserName = prop.getProperty("browser");
		String currentDir = System.getProperty("user.dir");
		if (browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", currentDir + "\\src\\chromedriver89.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("enable-automation");
			options.addArguments("--headless");
			driver = new ChromeDriver(options);

			/*
			 * URL url = new URL("http://localhost:4444/wd/hub"); DesiredCapabilities dc =
			 * DesiredCapabilities.chrome(); driver = new RemoteWebDriver(url, dc);
			 */

		} else if (browserName.contentEquals("firefox")) {
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

	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "\\src\\screenshots\\" + result + ".png"));
	}

}

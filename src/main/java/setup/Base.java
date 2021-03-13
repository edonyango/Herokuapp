package setup;

public class Base {
	
	public static void setProp() {
		String currentDir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", currentDir+"\\src\\chromedriver.exe");
	}

}

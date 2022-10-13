package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
static WebDriver driver;
static String browser;
static String url;


public static void readConfig() {
	try {
		InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
		// java doesn't understand key and value so introducing the property class for
		// the property file
		Properties prop = new Properties();
		// whatever we are reading should be associated to this prop so java can
		// understand
		prop.load(input);
		// store it in a String bucket called browser
		browser = prop.getProperty("browser");
		url = prop.getProperty("url");
		

	} catch (IOException e) {
		e.printStackTrace();
	}
}


public static WebDriver init() {
	
	readConfig();

	if (browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();

	} else if (browser.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
		driver = new FirefoxDriver();
	}

	driver.manage().deleteAllCookies();
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
}


public static void tearDown() {
	driver.close();
	driver.quit();	
	}
}

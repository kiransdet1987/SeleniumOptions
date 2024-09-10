import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class sslCheck {

	public static void main(String[] args) throws IOException {

		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		System.setProperty("webdriver.chrome.driver","./resources/chromedriver");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://expired.badssl.com");
		System.out.println(driver.getTitle());

		
		//Block- unwanted pop-ups.
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		
		// Set download paths:-
		Map<String, Object> prefs =  new HashMap<String,Object>();
		prefs.put("download.default.directory","/directory/path");
		options.setExperimentalOption("prefs", prefs);
		
		//Proxy
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:4444");
		options.setCapability("proxy", proxy);
		
		driver.get("www.google.com");
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://path.png"));
		
	}

}

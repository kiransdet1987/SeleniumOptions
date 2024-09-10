
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelIntroduction {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
		
		 WebDriver driver = new ChromeDriver();

		//System.setProperty("webdriver.gecko.driver", "./resources/geckodriver");
		//WebDriver driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/");
		//driver.navigate().to("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		//System.out.println(driver.getPageSource());
		// driver.quit();
		driver.close();
	

	}

}

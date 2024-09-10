import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","./resources/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Actions a = new Actions(driver);
		
		
		//DoubleClick
		a.moveToElement(driver.findElement(By.cssSelector("#twotabsearchtextbox")))
		.click().keyDown(Keys.SHIFT).sendKeys("Hello").doubleClick().build().perform();
		
		a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		
		//Right click using COntext Click
		a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).contextClick().build().perform();
		
		
	}
	

}

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frameTest_Actions {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./resources/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		//to see how many frames are avaialble in single web page
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(0); // by index
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']"))); //by locator
		driver.findElement(By.id("draggable")).click();
		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target =  driver.findElement(By.id("droppable"));
		
		a.dragAndDrop(source, target).build().perform();
		
		driver.switchTo().defaultContent(); // to come to normal window
		
		driver.quit();
		

	}

}

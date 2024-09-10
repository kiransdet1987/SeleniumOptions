import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Interview1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./resources/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		// Complete tags in a page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		// Limited to footer section.
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		System.out.println(footer.findElements(By.tagName("a")).size());
		
		
		// Need only first colum footer section links
		WebElement cols = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(cols.findElements(By.tagName("a")).size());
		//int ColsCount = cols.findElements(By.tagName("a")).size();
		
		
		
		
		// Click on each link from the colum links and print.
		
		for(int i=1;i<cols.findElements(By.tagName("a")).size();i++) {

			//for mac- it is keys.COMMAND
			//for windows - it is keys.CONTROL
			String clickOnLinkTabs = Keys.chord(Keys.COMMAND,Keys.ENTER);
			cols.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTabs);

			 Thread.sleep(5000L);
		}
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		
		while(itr.hasNext()) {
			driver.switchTo().window(itr.next());
			System.out.println(driver.getTitle());
		}
		
		driver.quit();
		
		
		
		
		
	}

}

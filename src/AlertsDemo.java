import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsDemo {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"./resources/chromedriver");
		WebDriver driver = new ChromeDriver();
		// driver.manage().window().maximize();
		String text = "Rahul";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.cssSelector("[id='alertbtn']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());

		alert.accept();
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(alert.getText());
		alert.dismiss();
		driver.close();

	}

}

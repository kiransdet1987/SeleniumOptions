import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SiblingConcepts {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"./resources/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.getTitle());

		String element = driver.findElement(
				By.xpath("//header/div/button[1]/following-sibling::button[1]"))
				.getText();

		System.out.println(element);

	}

}

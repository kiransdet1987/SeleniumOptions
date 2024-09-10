import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeLoc {

	// 4.0 new features
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameEditBox =driver.findElement(By.cssSelector("[name='name']"));
		//Above
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
		WebElement dateofBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		//below
		driver.findElement(with(By.tagName("input")).below(dateofBirth)).click();
		WebElement iceCreamLabel =driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		//toLeftOf
		driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();
		WebElement rdb = driver.findElement(By.id("inlineRadio1"));
		//toRightOf
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());
}
}

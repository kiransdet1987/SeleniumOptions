import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class LocatorsDemo {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"./resources/chromedriver");

		WebDriver driver = new ChromeDriver();

		// System.setProperty("webdriver.gecko.driver",
		// "./resources/geckodriver");
		// WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		loginCredentials(driver, "kiran", "hello123");

		String errorMesg = driver.findElement(By.cssSelector("p.error"))
				.getText();
		System.out.println(errorMesg);
		driver.findElement(By.linkText("Forgot your password?")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@placeholder='Name']"))
				.sendKeys("John");

		driver.findElement(By.cssSelector("input[placeholder='Email']"))
				.sendKeys("John@gmail.com");

		driver.findElement(By.xpath("//form/input[3]"))
				.sendKeys("8767878776");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

		String passwordError = driver.findElement(By.cssSelector("form p"))
				.getText();
		System.out.println(passwordError);

		String actualword = extractedPassword(passwordError);

		driver.findElement(By.className("go-to-login-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("inputUsername")).clear();
		driver.findElement(By.name("inputPassword")).clear();

		loginCredentials(driver, "rahul ", actualword);

		String successMessage = driver.findElement(By.xpath(
				"//p[normalize-space()='You are successfully logged in.']"))
				.getText();
		Thread.sleep(5000);
		System.out.println(successMessage);
		Assert.assertEquals(successMessage, "You are successfully logged in.");
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();

		driver.close();
	}

	private static String extractedPassword(String passwordError) {
		String[] words = passwordError.split(" ");
		String word = words[4];
		String actualword = word.replaceAll("\'(\\w+)\'", "$1");
		System.out.println(actualword);
		return actualword;
	}

	private static void loginCredentials(WebDriver driver, String name,
			String password) {
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("submit")).click();
	}




}

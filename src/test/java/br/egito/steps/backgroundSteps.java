package br.egito.steps;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class backgroundSteps {

	private WebDriver driver;

	@Given("I launch the Swaglabs browser")
	public void i_launch_the_swaglabs_browser() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/emanu/eclipse-workspace/SwagLabs/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();

	}

	@When("I access the Swaglabs page")
	public void i_access_the_swaglabs_page() {
		driver.get("https://www.saucedemo.com/");
	}

	@Then("the Login page is displayed")
	public void the_login_page_is_displayed() {
		driver.findElement(By.className("login_logo"));
		driver.findElement(By.id("user-name"));
		driver.findElement(By.id("password"));
		driver.findElement(By.id("login-button"));
		driver.findElement(By.className("bot_column"));

	}

	@Given("I am on Swaglabs page")
	public void i_am_on_swaglabs_page() {
		driver.findElement(By.className("login_logo"));
		driver.findElement(By.id("user-name"));
		driver.findElement(By.id("password"));
		driver.findElement(By.id("login-button"));
		driver.findElement(By.className("bot_column"));
	}

	@When("I insert the username {string}")
	public void i_insert_the_username(String username) {
		driver.findElement(By.id("user-name")).sendKeys(username);
	}

	@When("I insert the password")
	public void i_insert_the_password() {
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
	}

	@When("I click Login")
	public void i_click_login() {
		driver.findElement(By.id("login-button")).click();
	}

	@Then("The Product Page is displayed")
	public void the_product_page_is_displayed() {
		driver.findElement(By.id("login-button")).click();
		WebElement image = driver.findElement(By.xpath("//img[@alt='Sauce Labs Backpack']"));
		String imageFile = image.getAttribute("src");
		System.out.println(imageFile);
		Assert.assertEquals("https://www.saucedemo.com/static/media/sauce-backpack-1200x1500.34e7aa42.jpg", imageFile);
	}
	
	@Then("The Lockout Message is displayed")
	public void the_lockout_message_is_displayed() {
		driver.findElement(By.id("login-button")).click();
		WebElement lockoutMSG = driver.findElement(By.xpath("//div[@class='error-message-container error']"));
		String lockoutMessage = lockoutMSG.getText();
		System.out.println(lockoutMessage);
		Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", lockoutMessage);
	}
	
	@Then("The Problem Page is displayed")
	public void the_problem_page_is_displayed() {
		driver.findElement(By.id("login-button")).click();
		WebElement image = driver.findElement(By.xpath("//img[@alt='Sauce Labs Backpack']"));
		String imageFile = image.getAttribute("src");
		System.out.println(imageFile);
		Assert.assertEquals("https://www.saucedemo.com/static/media/sl-404.168b1cce.jpg", imageFile);
	}
	
	@When("I Access Perfomance page")
	public void i_access_perfomance_page() {
		driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");

	}

	@Then("The Perfomance Page is displayed")
	public void the_perfomance_page_is_displayed() {
		StopWatch watch = new StopWatch();
		watch.start();
		driver.findElement(By.id("login-button")).click();
		WebElement image = driver.findElement(By.xpath("//img[@alt='Sauce Labs Backpack']"));
		String imageFile = image.getAttribute("src");
		System.out.println(imageFile);
		Assert.assertEquals("https://www.saucedemo.com/static/media/sauce-backpack-1200x1500.34e7aa42.jpg", imageFile);
		watch.stop();
		System.out.println("Time Elapsed: " + watch.getTime());
		Long timeElapsed = watch.getTime();
		Boolean time = false;
		if (timeElapsed > 5200) {
			time = true;
		}
		Assert.assertTrue(time);	    
		
	}
	
	
	
	@When("I access with {string}")
	public void i_access_with(String username) {
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
//		driver.findElement(By.id("login-button")).click();
		
	}


	@Before
	public void startTest() {
		System.out.println("Start the Test");
	}

	@After(order = 0, value = "@tag")
	public void closeBrowser() {
		driver.quit();
		System.out.println("Finish the Test");
	}
	
	@After(order = 0, value = "@tag1")
	public void closeBrowser1() {
		driver.quit();
		System.out.println("Finish the Test");
	}
}

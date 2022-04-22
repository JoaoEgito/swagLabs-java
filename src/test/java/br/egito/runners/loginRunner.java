package br.egito.runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/", glue = "br.egito.steps", tags = "@tag1", plugin = {
		"pretty", "html:target/report-html",
		"json:target/report.json" }, monochrome = false, snippets = SnippetType.CAMELCASE, dryRun = false)

public class loginRunner {

//	private WebDriver driver;

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/emanu/eclipse-workspace/SwagLabs/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.className("login_logo"));
		driver.findElement(By.id("user-name"));
		driver.findElement(By.id("password"));
		driver.findElement(By.id("login-button"));
		driver.findElement(By.className("bot_column"));
		driver.quit();

	}

	@AfterClass
	public static void tearDown() {
		WebDriver driver = new ChromeDriver();
		driver.quit();
		System.out.println("Finish the Test");
	}

}

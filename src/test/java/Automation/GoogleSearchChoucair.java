package Automation;

import static org.testng.AssertJUnit.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchChoucair {

private WebDriver driver;
	
	@Before
	public void setUp () {
		
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com.co/");
		
		
	}

	@Test
	public void testGooglePage() {
		
		WebElement searchbox = driver.findElement(By.name("q"));
		
		searchbox.clear();
		
		searchbox.sendKeys("Choucair Testing");
		
		searchbox.submit();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		assertEquals("Choucair Testing - Buscar con Google", driver.getTitle());
		
	}
	
	@After
	
	public void tearDown() {
		
		driver.quit();
	}
	
	
}

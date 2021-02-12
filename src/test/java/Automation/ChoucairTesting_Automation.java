package Automation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChoucairTesting_Automation {
	
	private WebDriver driver;
	
	By RegisterLinkLocator = By.linkText("Empleos");
	By RegisterPageLocator = By.xpath("//img[@src='https://www.choucairtesting.com/wp-content/uploads/2020/11/150.jpg']");
	By keywordsLocator = By.name("search_keywords");
	By locationLocator = By.name("search_location");
	By searchjobsLocator = By.xpath("//input[@value=\"Search Jobs\"]");
	
	
	
			
		@Before
		
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.choucairtesting.com/");
		
	}

		@After
		
	public void tearDown() throws Exception {
		
		driver.quit();
		
	}

	@Test
	public void SearchJobs() throws InterruptedException {
		
		driver.findElement(RegisterLinkLocator).click();
		Thread.sleep(2000);
		if(driver.findElement(RegisterPageLocator).isDisplayed()) {
			
			driver.findElement(keywordsLocator).sendKeys("Testing");
			driver.findElement(locationLocator).sendKeys("Medellin");
			driver.findElement(searchjobsLocator).click();
		}
		else {
			System.out.print("Palabra no encontrada");
		}
		
	}

}

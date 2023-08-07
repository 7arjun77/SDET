package CP.TestScripts;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import CP.Pages.AutomationPanda;
import CP.Pages.Flipkart;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestSC2 {
	public static WebDriver driver;
	public static Flipkart  fp;
	
	
	@BeforeSuite
	public void settingup() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
	
		
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		

}
	
	
	@AfterSuite
	public void last() {
		driver.quit();
	}

}

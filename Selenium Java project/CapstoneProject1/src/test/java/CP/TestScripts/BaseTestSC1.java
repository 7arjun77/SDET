package CP.TestScripts;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import CP.Pages.AutomationPanda;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestSC1 {
	public static WebDriver driver;
	public static AutomationPanda ap;
	
	
	@BeforeSuite
	public void settingup() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
	
		
		driver.get("https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		

}
	
	
	@AfterSuite
	public void last() {
		driver.quit();
	}
}

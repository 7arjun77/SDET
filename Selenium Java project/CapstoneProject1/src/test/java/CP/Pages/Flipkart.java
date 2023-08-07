package CP.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Flipkart {
	WebDriver driver;
	//By logo = By.xpath("//a[@aria-label='Flipkart']");
	//By search1 = By.xpath("//input[@type='text']");
	//By showresult = By.xpath("/html/body/div/div/div[3]/div[1]/div[2]/div[1]/div/div/span");
	//By firstitem = By.xpath("//div[@data-id='MOBGHWFHECFVMDCX']");
	
	
	@FindBy(xpath="//a[@aria-label='Flipkart']")
	WebElement logo;
	
	@FindBy(xpath="//input[@type='text']")
	WebElement search1;
	
	@FindBy(xpath="/html/body/div/div/div[3]/div[1]/div[2]/div[1]/div/div/span")
	WebElement showresult;
	
	@FindBy(xpath="//div[@data-id='MOBGHWFHECFVMDCX']")
	WebElement firstitem;
	
	
	public Flipkart(WebDriver d) {
		driver = d;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
		
	}
	
	

	public void verifylogo() {
		
		if (logo.isDisplayed()) {
			System.out.println("logo Verified");
			
		}
		else {
			System.out.println("logo not present");
			
		}

	}
	
	
	
	
	public void search(String items) {
		search1.sendKeys(items);
	}
	
	
	
	public void getshowingResultCOUNT() {
		showresult.getText();
	}
	
	
	
	
	public void clickonFirstItem() {
		 firstitem.click();
	 }
	

}

package CP.TestScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import CP.Pages.Flipkart;

public class TCFlipkart extends BaseTestSC2{
	
	
	@Test(priority=1)
	public void TClog() {
		fp= new Flipkart(driver);
		
		//driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		fp.verifylogo();	
	}
	
	
	@Test(priority=2)
	public void TCsearch() throws AWTException, InterruptedException {
		fp.search("iphone 14");
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		fp.getshowingResultCOUNT();
		fp.clickonFirstItem();
		
		Set<String> handles = driver.getWindowHandles();
		Iterator it = handles.iterator();
		String Parent =(String) it.next();
		String child =(String) it.next();
		driver.switchTo().window(child);
		
		Thread.sleep(3000);
		String URL =driver.getCurrentUrl();
		System.out.println(URL);
		String expURL="https://www.flipkart.com/apple-iphone-14-midnight-128-gb/p/itm9e6293c322a84?pid=MOBGHWFHECFVMDCX&lid=LSTMOBGHWFHECFVMDCXSSCYWA&marketplace=FLIPKART&q=iphone+14&store=tyy%2F4io&srno=s_1_1&otracker=search&otracker1=search&fm=Search&iid=4368a47e-c863-47eb-ba58-a7456023a38b.MOBGHWFHECFVMDCX.SEARCH&ppt=sp&ppn=sp&ssid=v97z3b2dxc0000001691321569483&qH=860f3715b8db08cd";
		if  (URL.equals(URL)) {
			Assert.assertTrue(true);
			System.out.println("Successfully navigated and url verified");
			
		}
		else {
			System.out.println("Navigated to a differet page");
			Assert.assertTrue(false);
		}
		
		
		String title =driver.getTitle();
		String exptitle ="APPLE iPhone 14 ( 128 GB Storage ) Online at Best Price On Flipkart.com";
		if  (title.equals(exptitle)) {
			Assert.assertTrue(true);
			System.out.println("Successfully verified page title ");
			
		}
		else {
			System.out.println("Page Title verification failed");
			Assert.assertTrue(false);
		}
		
		
	
	}
	
	

}

package CP.TestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import CP.Pages.AutomationPanda;



public class TCPanda extends BaseTestSC1{
	
	
	@Test(priority=1)
	public void test1() {
		
		String title = driver.getTitle();
		String expTitle="Want to practice test automation? Try these demo sites! | Automation Panda";
		if  (expTitle.equals(title)) {
			Assert.assertTrue(true);
			System.out.println("Successfully verified Title");
		
		}
		else {
			System.out.println("verification failed ");
			Assert.assertTrue(false);
		}
	}
	
	
	@Test(priority=2)
	public void Test2() throws InterruptedException {
		ap = new AutomationPanda(driver);
		ap.clickContact();
		Thread.sleep(2000);;
		String Ctitle=driver.getTitle();
		System.out.println(Ctitle);
		String expCtitle ="Contact | Automation Panda";
		if  (expCtitle.equals(Ctitle)) {
			Assert.assertTrue(true);
			System.out.println("Successfully verified contact page Title");
			
		}
		else {
			System.out.println("contact page Title verification failed");
			Assert.assertTrue(false);
		}
		
		ap.enterName("Arjun");
		ap.enterEMAIL("arjun@gmail.com");
		ap.enterComment("This is a sample comment");
		ap.clickSubmit();
		ap.verifyMessageSent("Your message has been sent");
		
		
		
		
		
	}
	

}

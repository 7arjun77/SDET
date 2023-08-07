package CP.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AutomationPanda {
	WebDriver driver;
	//By contact = By.id("menu-item-10");
	//By name1 = By.name("g3-name");
	//By EMAIL = By.id("g3-email");
	//By comment = By.id("contact-form-comment-g3-message");
	//By conatactMe = By.xpath("//button[@type='submit']");
	//By msgSend = By.id("contact-form-success-header");
	
	@FindBy(id="menu-item-10")
	WebElement contact;
	
	@FindBy(name="g3-name")
	WebElement name1;
	
	@FindBy(id="g3-email")
	WebElement EMAIL;
	
	@FindBy(id="contact-form-comment-g3-message")
	WebElement comment;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement conatactMe;
	
	@FindBy(id="contact-form-success-header")
	WebElement msgSend;
	
	
	
	public AutomationPanda(WebDriver d) {
		driver=d;
		//PageFactory.initElements(driver, this);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
	}
	

	


	public void clickContact() {
		contact.click();
	}
	
	
	public void enterName(String name) {
		name1.sendKeys(name);
	}
	
	public void enterEMAIL(String email) {
		EMAIL.sendKeys(email);
	}
	
	public void enterComment(String Comment) {
		comment.sendKeys(Comment);
	}
	
	public void clickSubmit() {
		conatactMe.click();
	}
	
	
	
	public void verifyMessageSent(String msg) {
		String t= msgSend.getText();
		if (t.equals(msg)) {
			System.out.println("Verified");
			
		}
		else {
			System.out.println("A  different message is printed");
			
		}
		
	}
	
	
	
	

}

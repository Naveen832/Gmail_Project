package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class meet_page {

		 WebDriver driver;
		 @FindBy(xpath = "//*[@id=\"identifierId\"]" ) WebElement Email;
		 @FindBy(className = "VfPpkd-vQzf8d") WebElement IdentifireNext;
		 @FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input") WebElement Password;
		 @FindBy(className = "VfPpkd-vQzf8d") WebElement PasswordNext;
		 @FindBy(linkText ="New meeting") WebElement NewMeet;
		 @FindBy(linkText ="Join a meeting") WebElement JoinMeet;
		 @FindBy(xpath ="//*[@id=\"yDmH0d\"]/c-wiz/div/div/div/div/div[3]/div/button/span") WebElement StartMeet;
		 @FindBy(className = "YK") WebElement EnterCode;
		 
		 public meet_page(WebDriver driver) {
		        this.driver = driver;
		        PageFactory.initElements(driver, this);
		 }
		  
		 public void logIn(String arg1, String arg2) throws InterruptedException{
		       
			 Email.sendKeys(arg1);
		     IdentifireNext.click();
		     Thread.sleep(3000);
		     Password.sendKeys(arg2);
		     PasswordNext.click();
		     Thread.sleep(6000);
		        
		    }
		 
		
		 
		 public void newMeet() throws InterruptedException {
			 
			  Actions actions = new Actions(driver);
			  actions.moveToElement(NewMeet).build().perform();
			  NewMeet.click();
			 Thread.sleep(2000);
			 
			 
		 }
		 
		 public void startMeet() throws InterruptedException {
			 
			 String parent = driver.getWindowHandle();	
			 System.out.println(parent);
			 
			 Actions actions = new Actions(driver);
			 actions.moveToElement(NewMeet).build().perform();
		         NewMeet.click();
			 Thread.sleep(2000);
			 
			 Set<String> allWindows = driver.getWindowHandles();
			 int count = allWindows.size();
			 System.out.println(count);
			 
			 for(String child:allWindows) {
				 System.out.println(child);
				 if(!parent.equalsIgnoreCase(child))
				 {
				      driver.switchTo().window(child);
				      System.out.println(child);
				      String title = driver.getTitle();
				      System.out.println(title);
				   
				      Actions actions2 = new Actions(driver);
				      actions2.moveToElement(StartMeet).build().perform();
				      Thread.sleep(5000);
				      StartMeet.click();
				      Thread.sleep(3000);
					 
				 }
			 }
			 
			 
		}
		 
               public void copyMeetingLink() throws InterruptedException {
			 
			 String parent = driver.getWindowHandle();	
			 
			 Actions actions = new Actions(driver);
			 actions.moveToElement(NewMeet).build().perform();
		         NewMeet.click();
			 Thread.sleep(3000);
			 
			 Set<String> allWindows = driver.getWindowHandles();
			 
			 for(String child:allWindows) {
				 
				 if(!parent.equalsIgnoreCase(child))
				 {
				      driver.switchTo().window(child);
				      
				      String copy = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/div/div/div[1]/span[1]")).getText();
				      System.out.println("Meeting code is " + copy);
				      driver.close();
				 }
			 }
			 
			 
		}
		 
		 
		 public void joinMeet() throws InterruptedException {
			 
			  Actions actions = new Actions(driver);
			  actions.moveToElement(JoinMeet).build().perform();
			  JoinMeet.click();
			  Thread.sleep(3000);
			 
			 
			 
		 }
		 
		 public void enterMeetCode(String arg) throws InterruptedException {
			 
			 Actions actions = new Actions(driver);
			 actions.moveToElement(JoinMeet).build().perform();
			 JoinMeet.click();
			 Thread.sleep(3000);
			
			
		         EnterCode.sendKeys(arg);
			 Thread.sleep(3000);
			 EnterCode.sendKeys(Keys.ENTER);
					 
		         Thread.sleep(3000);
					 
	        }
			 
			 	 
}
		 

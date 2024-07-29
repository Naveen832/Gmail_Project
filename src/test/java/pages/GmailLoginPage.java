package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 

public class GmailLoginPage {
     WebDriver driver;
     @FindBy(xpath = "//*[@id=\"identifierId\"]" ) WebElement Email;
     @FindBy(className = "VfPpkd-vQzf8d") WebElement Next;
	 @FindBy(xpath = "//*[@id=\"forgotPassword\"]/div/button/span") WebElement ForgetPassword;
	 @FindBy(xpath="//*[@id=\"voiceButton\"]/div/button/div[2]") WebElement call;
	 @FindBy(xpath="//*[@id=\"idvPin\"]") WebElement otp;
	 @FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input") WebElement EnterPassword;
	 @FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input") WebElement Password;
	 @FindBy(xpath = "//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[3]/div/div[1]/div/div/div[1]/div/input") WebElement Showpassword;
	 @FindBy(className = "VfPpkd-vQzf8d") WebElement PasswordNext;
	 @FindBy(xpath="//*[@id=\"password\"]/div[1]/div/div[1]/input") WebElement lastpassword;
	 @FindBy(xpath="//*[@id=\"view_container\"]/div/div/div[2]/div/div[2]/div/div[2]/div/div/button/div[2]") WebElement tryanother;
     @FindBy(xpath="//*[@id=\"gb\"]/div[2]/div[3]/div[1]/div[2]/div/a/img")WebElement compose;
 

//    public GmailLoginPage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }
    public void validateemail(String arg1) throws InterruptedException{
        Email.sendKeys(arg1);
        Next.click();
        Thread.sleep(3000);  
      
       
    }
    public void validatepassword(String arg2) throws InterruptedException {
    	 EnterPassword.sendKeys(arg2);
    	 Showpassword.click();
    	 Thread.sleep(2000);
         PasswordNext.click();
         
         Thread.sleep(5000);
    }
    public void forgetpassword() throws InterruptedException {
    	//EnterPassword.sendKeys("Abc@123");
    	
    	ForgetPassword.click();
    	//tryanother.click();
    	//lastpassword.sendKeys("Abcd@1234566780");
    	//call.click();
    	Thread.sleep(3000);
    	//otp.sendKeys("234567");
    }
    public void homepage() {
    	JavascriptExecutor js=(JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,3000)");
    	compose.click();
    	
    }
}
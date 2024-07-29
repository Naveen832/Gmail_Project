package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 

public class login {
     WebDriver driver;
     @FindBy(xpath = "//*[@id=\"identifierId\"]" ) WebElement Email;
     @FindBy(className = "VfPpkd-vQzf8d") WebElement Next;
	 @FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input") WebElement EnterPassword;
	 @FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input") WebElement Password;
	 @FindBy(xpath = "//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[3]/div/div[1]/div/div/div[1]/div/input") WebElement Showpassword;
	 @FindBy(className = "VfPpkd-vQzf8d") WebElement PasswordNext;
	 @FindBy(xpath ="//*[@id=\":2d\"]") WebElement SelectMail1;
	@FindBy(xpath = "//*[@id=\":4\"]/div[2]/div[1]/div/div[2]/div[3]") WebElement DeleteButton;
	@FindBy(xpath ="//*[@id=\":62\"]") WebElement selectmail;
	@FindBy(xpath ="//*[@id=\":8t\"]/div[1]") WebElement Moveto;
	@FindBy(xpath ="//*[@id=\":ba\"]/div") WebElement prudhvi;
	
	
	
		  
 

    public login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void logIn(String arg1, String arg2) throws InterruptedException{
        Email.sendKeys(arg1);
        Next.click();
        Thread.sleep(3000);  
       EnterPassword.sendKeys(arg2);
      
       Showpassword.click();
        Thread.sleep(2000);
        PasswordNext.click();
        
        Thread.sleep(5000);
//        SelectMail1.click();
//        Thread.sleep(5000);
//        
//        DeleteButton.click();
//        
//        selectmail.click();
//        Thread.sleep(3000);
//        Moveto.click();
//        
//        prudhvi.click();
        
       
    }
	public void SelectMail1() {
		// TODO Auto-generated method stub
		
	}
	public void DeleteButton() {
		// TODO Auto-generated method stub
		
	}
	public void selectmail() {
		// TODO Auto-generated method stub
		
	}
	public void Moveto() {
		// TODO Auto-generated method stub
		
	}
	public void prudhvi() {
		// TODO Auto-generated method stub
		
	}
}
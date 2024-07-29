package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pages.RegistrationPage;

public class TC1_steps {
	WebDriver driver = null;
	RegistrationPage objectSignUpPage;
	@Given("browser is open")
	public void brower_is_open() {
		String projectPath = System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
	} 

	@When("user enters the url")
	public void user_enters_the_url() {
		driver.navigate().to("https://mail.google.com");
	}

	@Then("user is redirected to home page")
	public void user_is_redirected_to_the_registeration_page() {
		
//		driver.findElement(By.className("ahT6S")).isDisplayed();
		if(!driver.getTitle().equals("Gmail")) {
			throw new IllegalStateException("This is not homepage and the current page is"+driver.getCurrentUrl());
		}
	}
	@Then("user clicks on create account and then myself")
	public void user_clicks_on_create_account_and_then_myself() throws InterruptedException {
		objectSignUpPage = new RegistrationPage(driver);
		objectSignUpPage.createAccount();
		
	}

	@Then("user is redirected to registeration page")
	public void user_is_redirected_to_registeration_page() {
		if(!driver.getTitle().equals("Create your Google Account")){
			throw new IllegalStateException("this is not registeration page");
		}
	    
	}

}

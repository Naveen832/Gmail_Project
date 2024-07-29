package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pages.RegistrationPage;

public class TC5_steps {
	WebDriver driver;
	RegistrationPage objectSignUpPage = null;
	@Given("user get to registeration page")
	public void user_get_to_registeration_page() throws InterruptedException {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.navigate().to("https://mail.google.com");
		objectSignUpPage = new RegistrationPage(driver);
		objectSignUpPage.createAccount();
	  
	}

	@Then("user enters all the details in the registeration form")
	public void user_enters_all_the_details_in_the_registeration_form() {
		objectSignUpPage = new RegistrationPage(driver);
		  objectSignUpPage.enterFullName("vipul" , "sharma");
		  objectSignUpPage.enterUserName("faeiieie1223");
	   
	}

	@Then("user enters wrong password")
	public void user_enters_wrong_password() throws InterruptedException {
		 objectSignUpPage.enterPassword("1234567");
		 Thread.sleep(2000);
		 objectSignUpPage.nextButton();
	  
	}

	@Then("we veify if the user is not able to register")
	public void we_veify_if_the_user_is_not_able_to_register() {
		if(!(driver.getTitle().equals("Verifying your phone number"))) {
			throw new IllegalArgumentException("this is working");
		}
	}

}

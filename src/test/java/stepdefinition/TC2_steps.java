package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.RegistrationPage;

public class TC2_steps {
	WebDriver driver = null;
	RegistrationPage objectSignUpPage;
	@Given("the user is at registeration page")
	public void the_user_is_at_registeration_page() throws InterruptedException {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.navigate().to("https://mail.google.com");
		objectSignUpPage = new RegistrationPage(driver);
		objectSignUpPage.createAccount();

	}

	@Then("user enters the data in the fields given")
	public void user_enters_the_data_in_the_fields_given() {
		 objectSignUpPage = new RegistrationPage(driver);
		  objectSignUpPage.enterFullName("abc", "Test");
		  objectSignUpPage.enterUserName("vipul.sharma823");
		  objectSignUpPage.enterPassword("Test123456&@");
		  objectSignUpPage.nextButton();
	}

}

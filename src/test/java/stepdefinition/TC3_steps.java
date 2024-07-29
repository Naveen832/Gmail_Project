package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.RegistrationPage;

public class TC3_steps {
	WebDriver driver = null;
	RegistrationPage objectSignUpPage;
	@Given("user is at the registeration page")
	public void user_is_at_the_registeration_page() throws InterruptedException {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.navigate().to("https://mail.google.com");
		objectSignUpPage = new RegistrationPage(driver);
		objectSignUpPage.createAccount();
	}

	@Then("^user should be able to enter the wrong <firstName> and <lastName> in the fields$")
	public void user_should_be_able_to_enter_the_wrong_data_in_the_fields(String firstName, String lastName) {
		objectSignUpPage = new RegistrationPage(driver);
		  objectSignUpPage.enterFullName(firstName, lastName);
		  objectSignUpPage.enterUserName("faeiieie1223");
		  objectSignUpPage.enterPassword("Test123456&@");
		  objectSignUpPage.nextButton();  
	}

	@And("should not be able to go to next page")
	public void should_not_be_able_to_go_to_next_page() throws InterruptedException {
		Thread.sleep(2000);
		objectSignUpPage.checkNameError();
	}

}

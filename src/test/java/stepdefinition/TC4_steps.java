package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import pages.RegistrationPage;

public class TC4_steps {
	WebDriver driver;
	RegistrationPage objectSignUpPage = null;
	@Given("user should be at the registeration page")
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
	@Then("user will click on next button")
	public void user_will_click_on_next_button() {
		objectSignUpPage.nextButton();
	}

	@Then("user will not be redirected to next page")
	public void user_will_not_be_redirected_to_next_page() {
		driver.getTitle().equals("Verifying your phone number");

	}


}

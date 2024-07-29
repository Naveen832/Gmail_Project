package pages;

import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	WebDriver driver;
	@FindBy(xpath = "//*[@id=\"firstName\"]" ) WebElement FirstName;
	@FindBy(xpath = "//*[@id=\"lastName\"]") WebElement LastName;
	@FindBy(xpath = "//*[@id=\"username\"]") WebElement UserName;
	@FindBy(xpath = "//*[@id=\"passwd\"]/div[1]/div/div[1]/input") WebElement Password;
	@FindBy(xpath = "//*[@id=\"confirm-passwd\"]/div[1]/div/div[1]/input") WebElement ConfirmPass;
	@FindBy(xpath = "//*[@id=\"accountDetailsNext\"]/div/button/span") WebElement AccountDetailsNext;
	@FindBy(xpath = "//*[@id=\"view_container\"]/div/div/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/button/span") WebElement CreateAccount;
	@FindBy(xpath = "//*[@id=\"view_container\"]/div/div/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/ul/li[1]/span[2]") WebElement Myself;
	@FindBy(xpath = "//*[@id=\":4\"]/div/div[1]/div/div[2]/div[3]/div") WebElement deleteButton;
	@FindBy(xpath = "//*[@id=\"headingText\"]/span") WebElement verifyPhoneNumber;
	@FindBy(xpath = "//*[@id=\"identifierId\"]" ) WebElement emaildd;
	@FindBy(xpath = "//*[@id=\"headingText\"]/span") WebElement signInText;
	@FindBy(xpath = "//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[2]/div[1]/div/div[2]/div[2]/div") WebElement usernameTakenError;
	@FindBy(xpath = "//*[@id=\"nameError\"]/div[2]") WebElement nameError;
	
	
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void verifyHomePage() {
		String header = signInText.getText().trim();
		AssertJUnit.assertEquals("Sign in", header);
	}
	public void createAccount() throws InterruptedException{
		CreateAccount.click();
		Thread.sleep(1000);
		Myself.click();
		
	}
	public void enterFullName(String arg1, String arg2) {
		FirstName.sendKeys(arg1);
		LastName.sendKeys(arg2);
	}
	public void enterUserName(String arg1) {
		UserName.sendKeys(arg1);
	}
	public void enterPassword(String arg1) {
		Password.sendKeys(arg1);
		ConfirmPass.sendKeys(arg1);
	}
	public void nextButton() {
		AccountDetailsNext.click();
	}
	
	public void verifyPhoneNumberHeader() {
		String headerText = verifyPhoneNumber.getText().trim();
		AssertJUnit.assertEquals("Verifying your phone number", headerText );
	}
	public void verifyHeader() {
		String headerText = verifyPhoneNumber.getText().trim();
//		assertNotEquals("Verifying your phone number", headerText );
		driver.findElement(By.xpath(headerText)).isDisplayed();
	}
	public void checkUsernameTakenIsDisplayed() {
		String checkMail = usernameTakenError.getText().trim();
		driver.findElement(By.xpath(checkMail)).isDisplayed();
	}
	public void checkNameError() {
		String errorName = nameError.getText().trim();
		String expectedError = "Are you sure that you've entered your name correctly?";
		AssertJUnit.assertEquals(expectedError, errorName);
		
		}

	}

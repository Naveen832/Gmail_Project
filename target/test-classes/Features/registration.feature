Feature: Check Login Functionality
	@First
  Scenario: user should be able to access registeration page
    Given browser is open
    When user enters the url
    Then user is redirected to home page
    Then user clicks on create account and then myself
    Then user is redirected to registeration page
	@Second
  Scenario: user should be able to enter data in regirstration form
    Given the user is at registeration page
    Then user enters the data in the fields given

	@Third
  Scenario: user should not be able to enter more than 10 characters in first name and last name
    Given user is at the registeration page
    Then user should be able to enter the wrong <firstName> and <lastName> in the fields
    Then should not be able to go to next page

	@Fourth
  Scenario: user should not be able to continue with blank fields
    Given user should be at the registeration page
    Then user will click on next button
    And user will not be redirected to next page
    
    @Fifth
    Scenario: Verify whether the password must Use 8 or more characters with a mix of letters, numbers & symbols
    Given user get to registeration page
    Then user enters all the details in the registeration form
    Then user enters wrong password
    Then we veify if the user is not able to register

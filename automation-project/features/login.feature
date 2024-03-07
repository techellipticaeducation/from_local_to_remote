@regression
Feature: login functionality

  Background: 
    Given i open "chrome"
    When i open url "https://www.saucedemo.com"

 	@sanity @positive
  Scenario: verify user able to login successfully
    And i login with "standard_user" and "secret_sauce"
    Then i verify dashborad title as "Sauce Demo Dashboard"
    
  @sanity @smoke @negative  
  Scenario Outline: verify user see error msg for <username> and <password>
    And i enter username "<username>"
    And i enter password "<password>"
    And i click on login button
    Then i verify error msg as "<errormsg>"

    Examples: 
      | username      | password     | errormsg                                                                  |
      | abc           | secret_sauce | Epic sadface: Username and password do not match any user in this service |
      | standard_user | abcd         | Epic sadface: Username and password do not match any user in this service |
      |               | secret_sauce | Epic sadface: Username is required                                        |
      | standard_user |              | Epic sadface: Password is required                                        |
      
